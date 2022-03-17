package com.pbilbd.ui.dashboard.updatekyc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.button.MaterialButton;
import com.pbilbd.R;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.databinding.UpdateKYCFragmentBinding;
import com.pbilbd.dto.responses.agents.Agent;
import com.pbilbd.dto.responses.agents.AgentsResponse;
import com.pbilbd.dto.responses.getkyc.Country;
import com.pbilbd.dto.responses.getkyc.District;
import com.pbilbd.dto.responses.getkyc.GetKYCResponse;
import com.pbilbd.dto.responses.placementuser.Datum;
import com.pbilbd.dto.responses.placementuser.PlacementUserResponse;
import com.pbilbd.dto.responses.positionbyplacement.PositionByPlacementResponse;
import com.pbilbd.dto.responses.thana.Thana;
import com.pbilbd.dto.responses.thana.ThanaResponse;
import com.pbilbd.dto.responses.updateaccount.UpdateAccountResponse;
import com.pbilbd.utils.ExecutorServices;
import com.pbilbd.utils.ProgressDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class UpdateKYCFragment extends Fragment {

    private Context context;
    private UpdateKYCViewModel viewModel;
    private UpdateKYCFragmentBinding binding;
    private AwesomeValidation accountValidation;

    private List<Datum> placementUserData;
    private List<com.pbilbd.dto.responses.positionbyplacement.Datum> positionByPlacementData;
    private List<String> genderList;
    private List<String> bloodGroupList;
    private List<String> religionsList;
    private List<String> mobileBankingList;
    private List<Country> countryList;
    private List<District> districtList;
    private List<Thana> thanaList;
    private List<Agent> agentList;

    //variables
    private int districtId = -1;
    private int thanaId = -1;
    private int agentId = -1;
    private String agentName = null;
    private String placementUserName = null;
    private String positionName = null;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UpdateKYCFragmentBinding.inflate(inflater, container, false);
        binding.marqueeText.setSelected(true);
        viewModel =
                new ViewModelProvider(this).get(UpdateKYCViewModel.class);
        accountValidation = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        placementUserData = new ArrayList<>();
        positionByPlacementData = new ArrayList<>();
        countryList = new ArrayList<>();
        genderList = new ArrayList<>();
        bloodGroupList = new ArrayList<>();
        religionsList = new ArrayList<>();
        mobileBankingList = new ArrayList<>();
        districtList = new ArrayList<>();
        thanaList = new ArrayList<>();
        agentList = new ArrayList<>();
        viewModel.initViewModel(context);
        //get previous kyc info
        getKYCInfo();
        return binding.getRoot();
    }


    @Override
    public void onResume() {
        super.onResume();

        //account validation
        accountValidation.addValidation(getActivity(), binding.positionLayout.getId(), RegexTemplate.NOT_EMPTY, R.string.warning_empty);
        accountValidation.addValidation(getActivity(), binding.ownFbLayout.getId(), RegexTemplate.NOT_EMPTY, R.string.warning_empty);
        accountValidation.addValidation(getActivity(), binding.agentNameLayout.getId(), RegexTemplate.NOT_EMPTY, R.string.warning_empty);

        //search placement user on inputs
        binding.etPlacementUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchPlacementUser = String.valueOf(editable);
                searchPlacementUser(searchPlacementUser);
                Log.e("Item Selected", "FALSE");
            }
        });
        //search placement user selection
        binding.spinnerPlacementUser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Item Selected", "True");
                String placementUserId = placementUserData.get(i).getId();
                placementUserName = placementUserData.get(i).getText();
                positionByPlacement(placementUserId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //position
        binding.atvPosition.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (positionByPlacementData != null && !positionByPlacementData.isEmpty()) {
                    positionName = positionByPlacementData.get(i).getPosition();
                }
            }
        });

        //select agent btn
        binding.selectAgentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectAgent();
            }
        });

        //update account btn work
        binding.updateAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (accountValidation.validate()) {
                    updateAccount();
                }
            }
        });
    }

    //update account
    private void updateAccount() {
        if (placementUserName != null && positionName != null && agentName != null) {
            ProgressDialog.show(context);
            HashMap<String, String> params = new HashMap<>();
            params.put("placement", placementUserName);
            params.put("position", positionName);
            params.put("fb", String.valueOf(binding.ownFbLayout.getEditText().getText()));
            params.put("agent", agentName);
            viewModel.updateAccount(params)
                    .observe(getViewLifecycleOwner(), new Observer<UpdateAccountResponse>() {
                        @Override
                        public void onChanged(UpdateAccountResponse updateAccountResponse) {
                            viewModel.getErrorUpdateAccount()
                                    .observe(getViewLifecycleOwner(), new Observer<Integer>() {
                                        @Override
                                        public void onChanged(Integer integer) {
                                            if (integer == 200) {
                                                ProgressDialog.cancel();
                                                Toasty.success(context, "Updated successfully.").show();
                                            } else if (integer == 401) {
                                                ProgressDialog.cancel();
                                                Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                                            } else if (integer == BaseConstants.FAILURE_ERROR) {
                                                ProgressDialog.cancel();
                                                Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
                                            } else {
                                                ProgressDialog.cancel();
                                                Toasty.warning(context, BaseConstants.ERROR_UNKNOWN).show();
                                            }
                                        }
                                    });
                        }
                    });
        } else {
            Toasty.warning(context, "Please provide valid information!").show();
        }
    }

    //select agent
    private void selectAgent() {

        //set up select agent dialog
        Dialog agentDialog = new Dialog(context);
        agentDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        agentDialog.setContentView(R.layout.dialog_select_agent);

        AutoCompleteTextView atvDistricts = agentDialog.findViewById(R.id.atv_district);
        AutoCompleteTextView atvThana = agentDialog.findViewById(R.id.atv_thana);
        AutoCompleteTextView atvAgents = agentDialog.findViewById(R.id.atv_agent);
        AppCompatImageButton closeBTN = agentDialog.findViewById(R.id.close_dialog_btn);
        MaterialButton saveAgentBTN = agentDialog.findViewById(R.id.save_agent_btn);

        //district drop down
        if (districtList != null && !districtList.isEmpty()) {
            ArrayAdapter<District> districtAdapter = new ArrayAdapter<District>(context, android.R.layout.simple_spinner_dropdown_item, districtList);
            atvDistricts.setAdapter(districtAdapter);

            //on district item selected
            atvDistricts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    districtId = districtList.get(i).getId();
                    Log.e("District Id: ", String.valueOf(districtId));
                    //get thana list
                    viewModel.getThanaList(districtId)
                            .observe(getViewLifecycleOwner(), new Observer<ThanaResponse>() {
                                @Override
                                public void onChanged(ThanaResponse thanaResponse) {
                                    if (thanaResponse.getThanas() != null && !thanaResponse.getThanas().isEmpty()) {
                                        //thana drop down
                                        thanaList = thanaResponse.getThanas();
                                        ArrayAdapter<Thana> thanaAdapter = new ArrayAdapter<Thana>(context, android.R.layout.simple_spinner_dropdown_item, thanaList);
                                        atvThana.setAdapter(thanaAdapter);

                                        //on thana item selected
                                        atvThana.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                thanaId = thanaList.get(i).getId();

                                                //agent drop down
                                                viewModel.getAgentList(districtId, thanaId)
                                                        .observe(getViewLifecycleOwner(), new Observer<AgentsResponse>() {
                                                            @Override
                                                            public void onChanged(AgentsResponse agentsResponse) {
                                                                if (agentsResponse.getAgents() != null && !agentsResponse.getAgents().isEmpty()) {
                                                                    agentList = agentsResponse.getAgents();
                                                                    ArrayAdapter<Agent> agentAdapter = new ArrayAdapter<Agent>(context, android.R.layout.simple_spinner_dropdown_item, agentList);
                                                                    atvAgents.setAdapter(agentAdapter);

                                                                    atvAgents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                                        @Override
                                                                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                                            agentId = agentList.get(i).getUser().getId();
                                                                            agentName = agentList.get(i).getUser().getUsername();
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        });
                                            }
                                        });
                                    }
                                }
                            });
                }
            });
        }

        //close btn work
        closeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agentDialog.dismiss();
            }
        });

        //save btn work
        saveAgentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (agentId != -1 && agentName != null && !agentName.isEmpty()) {
                    binding.tvAgentName.setText(agentName);
                    agentDialog.dismiss();
                } else {
                    Toasty.warning(context, "Select agent please.").show();
                }
            }
        });

        agentDialog.show();
    }

    //get kyc info
    private void getKYCInfo() {

        ProgressDialog.show(context);

        ExecutorServices.getExecutor()
                .execute(new Runnable() {
                    @Override
                    public void run() {

                        viewModel.getKYCInformation();

                        new Handler(Looper.getMainLooper())
                                .post(new Runnable() {
                                    @Override
                                    public void run() {

                                        viewModel.getErrorKYCLiveData()
                                                .observe(getViewLifecycleOwner(), new Observer<Integer>() {
                                                    @Override
                                                    public void onChanged(Integer integer) {
                                                        if (integer == 200) {
                                                            ProgressDialog.cancel();
                                                            viewModel.getKycResponseLiveData()
                                                                    .observe(getViewLifecycleOwner(), new Observer<GetKYCResponse>() {
                                                                        @Override
                                                                        public void onChanged(GetKYCResponse getKYCResponse) {
                                                                            if (getKYCResponse != null) {
                                                                                if (getKYCResponse.getUser() != null) {
                                                                                    if (getKYCResponse.getUser().getKycStatus() != null &&
                                                                                            getKYCResponse.getUser().getKycStatus().equals("0")) {
                                                                                        //all the work if kyc not updated
                                                                                        /**
                                                                                         * check
                                                                                         * marquee
                                                                                         * text
                                                                                         * */
                                                                                        if (binding.marqueeText.getVisibility() == View.GONE) {
                                                                                            binding.marqueeText.setVisibility(View.VISIBLE);
                                                                                        }

                                                                                        /**
                                                                                         * check
                                                                                         * shopping
                                                                                         * balance
                                                                                         * */
                                                                                        if (getKYCResponse.getShoppingWallet() != null) {
                                                                                            binding.tvShoppingPointBalance.setText(getKYCResponse.getShoppingWallet());
                                                                                        }

                                                                                        /**
                                                                                         * check
                                                                                         * recharge
                                                                                         * btn
                                                                                         * */
                                                                                        binding.btnRechargeNow.setText(getString(R.string.recharge_now_btn_warning));

                                                                                        /**
                                                                                         * Set
                                                                                         * Country
                                                                                         * Spinner
                                                                                         * */
                                                                                        if (getKYCResponse.getCountries() != null) {
                                                                                            countryList = getKYCResponse.getCountries();
                                                                                            ArrayAdapter<Country> countryAdapter = new ArrayAdapter<Country>(context, android.R.layout.simple_spinner_dropdown_item, countryList);
                                                                                            binding.atvCountires.setAdapter(countryAdapter);
                                                                                        }

                                                                                        /**
                                                                                         * Set
                                                                                         * Gender
                                                                                         * Spinner
                                                                                         * */
                                                                                        genderList.add("Male");
                                                                                        genderList.add("Female");
                                                                                        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, genderList);
                                                                                        binding.atvGender.setAdapter(genderAdapter);

                                                                                        /**
                                                                                         * Set
                                                                                         * Blood
                                                                                         * Group
                                                                                         * Spinner
                                                                                         * */
                                                                                        if (getKYCResponse.getBloodGroups() != null) {
                                                                                            bloodGroupList = getKYCResponse.getBloodGroups();
                                                                                            ArrayAdapter<String> bloodGroupAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, bloodGroupList);
                                                                                            binding.atvBloodGroup.setAdapter(bloodGroupAdapter);
                                                                                        }

                                                                                        /**
                                                                                         * Set
                                                                                         * Religion
                                                                                         * Spinner
                                                                                         * */
                                                                                        if (getKYCResponse.getReligions() != null) {
                                                                                            religionsList = getKYCResponse.getReligions();
                                                                                            ArrayAdapter<String> religionAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, religionsList);
                                                                                            binding.atvReligion.setAdapter(religionAdapter);
                                                                                        }

                                                                                        /**
                                                                                         * Set
                                                                                         * Mobile
                                                                                         * Banking
                                                                                         * Spinner
                                                                                         * */
                                                                                        if (getKYCResponse.getBanks() != null) {
                                                                                            mobileBankingList = getKYCResponse.getBanks();
                                                                                            ArrayAdapter<String> mobileBankignAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, mobileBankingList);
                                                                                            binding.atvMobileBanking.setAdapter(mobileBankignAdapter);
                                                                                        }

                                                                                        /**
                                                                                         * Save
                                                                                         * District
                                                                                         * List
                                                                                         * */
                                                                                        if (getKYCResponse.getDistricts() != null) {
                                                                                            districtList = getKYCResponse.getDistricts();
                                                                                        }

                                                                                    } else if (getKYCResponse.getUser().getKycStatus() != null &&
                                                                                            getKYCResponse.getUser().getKycStatus().equals("1")) {
                                                                                        //all the work if kyc already updated
                                                                                        /**
                                                                                         * check
                                                                                         * marquee
                                                                                         * text
                                                                                         * */
                                                                                        if (binding.marqueeText.getVisibility() == View.VISIBLE) {
                                                                                            binding.marqueeText.setVisibility(View.GONE);
                                                                                        }
                                                                                        /**
                                                                                         * check
                                                                                         * recharge
                                                                                         * btn
                                                                                         * */
                                                                                        binding.btnRechargeNow.setText(getString(R.string.recharge_now_btn));

                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    });
                                                        } else if (integer == 401) {
                                                            ProgressDialog.cancel();
                                                            Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                                                        } else if (integer == BaseConstants.FAILURE_ERROR) {
                                                            ProgressDialog.cancel();
                                                            Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
                                                        } else {
                                                            ProgressDialog.cancel();
                                                            Toasty.warning(context, BaseConstants.ERROR_UNKNOWN).show();
                                                        }
                                                    }
                                                });

                                    }
                                });
                    }
                });
    }

    //placement user from db
    private void searchPlacementUser(String searchPlacementUser) {
        viewModel.searchPlacementUser(searchPlacementUser)
                .observe(getViewLifecycleOwner(), new Observer<PlacementUserResponse>() {
                    @Override
                    public void onChanged(PlacementUserResponse placementUserResponse) {
                        if (placementUserResponse != null && placementUserResponse.getData() != null) {
                            if (!placementUserResponse.getData().isEmpty()) {
                                placementUserData = placementUserResponse.getData();
                                binding.atvPosition.setAdapter(null);
                                ArrayAdapter<Datum> placementUserSpinnerAdapter =
                                        new ArrayAdapter<Datum>(context, android.R.layout.simple_spinner_dropdown_item, placementUserData);
                                binding.spinnerPlacementUser.setVisibility(View.VISIBLE);
                                binding.spinnerPlacementUser.setAdapter(placementUserSpinnerAdapter);
                            } else {
                                binding.atvPosition.setAdapter(null);
                                binding.spinnerPlacementUser.setAdapter(null);
                                binding.spinnerPlacementUser.setVisibility(View.GONE);
                            }
                        }
                    }
                });
    }

    //position from db based on placement
    private void positionByPlacement(String placementUserId) {
        viewModel.positionByPlacement(placementUserId)
                .observe(getViewLifecycleOwner(), new Observer<PositionByPlacementResponse>() {
                    @Override
                    public void onChanged(PositionByPlacementResponse positionByPlacementResponse) {
                        if (positionByPlacementResponse != null && positionByPlacementResponse.getData() != null) {
                            if (!positionByPlacementResponse.getData().isEmpty()) {
                                positionByPlacementData = positionByPlacementResponse.getData();
                                ArrayAdapter<com.pbilbd.dto.responses.positionbyplacement.Datum> positionAdapter =
                                        new ArrayAdapter<com.pbilbd.dto.responses.positionbyplacement.Datum>(context,
                                                android.R.layout.simple_spinner_dropdown_item, positionByPlacementData);
                                binding.atvPosition.setAdapter(positionAdapter);
                            } else {
                                binding.atvPosition.setAdapter(null);
                            }
                        }
                    }
                });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}