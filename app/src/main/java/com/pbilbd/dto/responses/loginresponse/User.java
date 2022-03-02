
package com.pbilbd.dto.responses.loginresponse;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("country_id")
    @Expose
    private Integer countryId;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("two_factor_country_code")
    @Expose
    private Object twoFactorCountryCode;
    @SerializedName("two_factor_phone")
    @Expose
    private Object twoFactorPhone;
    @SerializedName("two_factor_options")
    @Expose
    private Object twoFactorOptions;
    @SerializedName("email_verified_at")
    @Expose
    private String emailVerifiedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("announcements_last_read_at")
    @Expose
    private String announcementsLastReadAt;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("mother_name")
    @Expose
    private String motherName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("present_address")
    @Expose
    private String presentAddress;
    @SerializedName("permanent_address")
    @Expose
    private String permanentAddress;
    @SerializedName("blood_group")
    @Expose
    private String bloodGroup;
    @SerializedName("religion")
    @Expose
    private String religion;
    @SerializedName("nid")
    @Expose
    private String nid;
    @SerializedName("nid_photo_front")
    @Expose
    private String nidPhotoFront;
    @SerializedName("nid_photo_back")
    @Expose
    private String nidPhotoBack;
    @SerializedName("fb")
    @Expose
    private String fb;
    @SerializedName("main_wallet")
    @Expose
    private Integer mainWallet;
    @SerializedName("total_self_id")
    @Expose
    private Integer totalSelfId;
    @SerializedName("withdraw_wallet")
    @Expose
    private Integer withdrawWallet;
    @SerializedName("social_income_wallet")
    @Expose
    private Integer socialIncomeWallet;
    @SerializedName("main_wallet_status")
    @Expose
    private Integer mainWalletStatus;
    @SerializedName("shopping_wallet")
    @Expose
    private Integer shoppingWallet;
    @SerializedName("shopping_wallet_status")
    @Expose
    private Integer shoppingWalletStatus;
    @SerializedName("pbc_wallet")
    @Expose
    private Integer pbcWallet;
    @SerializedName("usdt")
    @Expose
    private Integer usdt;
    @SerializedName("pbc_wallet_status")
    @Expose
    private Integer pbcWalletStatus;
    @SerializedName("nominee_name")
    @Expose
    private String nomineeName;
    @SerializedName("nominee_relation")
    @Expose
    private String nomineeRelation;
    @SerializedName("nominee_dob")
    @Expose
    private String nomineeDob;
    @SerializedName("nominee_address")
    @Expose
    private String nomineeAddress;
    @SerializedName("account_name")
    @Expose
    private String accountName;
    @SerializedName("bank_name")
    @Expose
    private String bankName;
    @SerializedName("account_no")
    @Expose
    private String accountNo;
    @SerializedName("branch_name")
    @Expose
    private String branchName;
    @SerializedName("mfs_type")
    @Expose
    private String mfsType;
    @SerializedName("mfs_no")
    @Expose
    private String mfsNo;
    @SerializedName("insurance_package_type")
    @Expose
    private Object insurancePackageType;
    @SerializedName("insurance_no")
    @Expose
    private String insuranceNo;
    @SerializedName("policy_document")
    @Expose
    private String policyDocument;
    @SerializedName("placement")
    @Expose
    private Object placement;
    @SerializedName("position")
    @Expose
    private Object position;
    @SerializedName("referred_by")
    @Expose
    private Object referredBy;
    @SerializedName("left")
    @Expose
    private Integer left;
    @SerializedName("middle")
    @Expose
    private Object middle;
    @SerializedName("right")
    @Expose
    private Object right;
    @SerializedName("kyc_status")
    @Expose
    private Integer kycStatus;
    @SerializedName("account_status")
    @Expose
    private Integer accountStatus;
    @SerializedName("is_agent")
    @Expose
    private Integer isAgent;
    @SerializedName("is_vip")
    @Expose
    private Integer isVip;
    @SerializedName("is_free_active")
    @Expose
    private Integer isFreeActive;
    @SerializedName("total_initial_insurance")
    @Expose
    private Integer totalInitialInsurance;
    @SerializedName("is_merchant")
    @Expose
    private Integer isMerchant;
    @SerializedName("agent")
    @Expose
    private Object agent;
    @SerializedName("buy_type")
    @Expose
    private String buyType;
    public final static Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(android.os.Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;

    protected User(android.os.Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.avatar = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.countryId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.roleId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.birthday = ((String) in.readValue((String.class.getClassLoader())));
        this.lastLogin = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.twoFactorCountryCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.twoFactorPhone = ((Object) in.readValue((Object.class.getClassLoader())));
        this.twoFactorOptions = ((Object) in.readValue((Object.class.getClassLoader())));
        this.emailVerifiedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.announcementsLastReadAt = ((String) in.readValue((String.class.getClassLoader())));
        this.fatherName = ((String) in.readValue((String.class.getClassLoader())));
        this.motherName = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.presentAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.permanentAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.bloodGroup = ((String) in.readValue((String.class.getClassLoader())));
        this.religion = ((String) in.readValue((String.class.getClassLoader())));
        this.nid = ((String) in.readValue((String.class.getClassLoader())));
        this.nidPhotoFront = ((String) in.readValue((String.class.getClassLoader())));
        this.nidPhotoBack = ((String) in.readValue((String.class.getClassLoader())));
        this.fb = ((String) in.readValue((String.class.getClassLoader())));
        this.mainWallet = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalSelfId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.withdrawWallet = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.socialIncomeWallet = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mainWalletStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.shoppingWallet = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.shoppingWalletStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pbcWallet = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usdt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pbcWalletStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nomineeName = ((String) in.readValue((String.class.getClassLoader())));
        this.nomineeRelation = ((String) in.readValue((String.class.getClassLoader())));
        this.nomineeDob = ((String) in.readValue((String.class.getClassLoader())));
        this.nomineeAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.accountName = ((String) in.readValue((String.class.getClassLoader())));
        this.bankName = ((String) in.readValue((String.class.getClassLoader())));
        this.accountNo = ((String) in.readValue((String.class.getClassLoader())));
        this.branchName = ((String) in.readValue((String.class.getClassLoader())));
        this.mfsType = ((String) in.readValue((String.class.getClassLoader())));
        this.mfsNo = ((String) in.readValue((String.class.getClassLoader())));
        this.insurancePackageType = ((Object) in.readValue((Object.class.getClassLoader())));
        this.insuranceNo = ((String) in.readValue((String.class.getClassLoader())));
        this.policyDocument = ((String) in.readValue((String.class.getClassLoader())));
        this.placement = ((Object) in.readValue((Object.class.getClassLoader())));
        this.position = ((Object) in.readValue((Object.class.getClassLoader())));
        this.referredBy = ((Object) in.readValue((Object.class.getClassLoader())));
        this.left = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.middle = ((Object) in.readValue((Object.class.getClassLoader())));
        this.right = ((Object) in.readValue((Object.class.getClassLoader())));
        this.kycStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.accountStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isAgent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isVip = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isFreeActive = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalInitialInsurance = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isMerchant = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.agent = ((Object) in.readValue((Object.class.getClassLoader())));
        this.buyType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getTwoFactorCountryCode() {
        return twoFactorCountryCode;
    }

    public void setTwoFactorCountryCode(Object twoFactorCountryCode) {
        this.twoFactorCountryCode = twoFactorCountryCode;
    }

    public Object getTwoFactorPhone() {
        return twoFactorPhone;
    }

    public void setTwoFactorPhone(Object twoFactorPhone) {
        this.twoFactorPhone = twoFactorPhone;
    }

    public Object getTwoFactorOptions() {
        return twoFactorOptions;
    }

    public void setTwoFactorOptions(Object twoFactorOptions) {
        this.twoFactorOptions = twoFactorOptions;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAnnouncementsLastReadAt() {
        return announcementsLastReadAt;
    }

    public void setAnnouncementsLastReadAt(String announcementsLastReadAt) {
        this.announcementsLastReadAt = announcementsLastReadAt;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNidPhotoFront() {
        return nidPhotoFront;
    }

    public void setNidPhotoFront(String nidPhotoFront) {
        this.nidPhotoFront = nidPhotoFront;
    }

    public String getNidPhotoBack() {
        return nidPhotoBack;
    }

    public void setNidPhotoBack(String nidPhotoBack) {
        this.nidPhotoBack = nidPhotoBack;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public Integer getMainWallet() {
        return mainWallet;
    }

    public void setMainWallet(Integer mainWallet) {
        this.mainWallet = mainWallet;
    }

    public Integer getTotalSelfId() {
        return totalSelfId;
    }

    public void setTotalSelfId(Integer totalSelfId) {
        this.totalSelfId = totalSelfId;
    }

    public Integer getWithdrawWallet() {
        return withdrawWallet;
    }

    public void setWithdrawWallet(Integer withdrawWallet) {
        this.withdrawWallet = withdrawWallet;
    }

    public Integer getSocialIncomeWallet() {
        return socialIncomeWallet;
    }

    public void setSocialIncomeWallet(Integer socialIncomeWallet) {
        this.socialIncomeWallet = socialIncomeWallet;
    }

    public Integer getMainWalletStatus() {
        return mainWalletStatus;
    }

    public void setMainWalletStatus(Integer mainWalletStatus) {
        this.mainWalletStatus = mainWalletStatus;
    }

    public Integer getShoppingWallet() {
        return shoppingWallet;
    }

    public void setShoppingWallet(Integer shoppingWallet) {
        this.shoppingWallet = shoppingWallet;
    }

    public Integer getShoppingWalletStatus() {
        return shoppingWalletStatus;
    }

    public void setShoppingWalletStatus(Integer shoppingWalletStatus) {
        this.shoppingWalletStatus = shoppingWalletStatus;
    }

    public Integer getPbcWallet() {
        return pbcWallet;
    }

    public void setPbcWallet(Integer pbcWallet) {
        this.pbcWallet = pbcWallet;
    }

    public Integer getUsdt() {
        return usdt;
    }

    public void setUsdt(Integer usdt) {
        this.usdt = usdt;
    }

    public Integer getPbcWalletStatus() {
        return pbcWalletStatus;
    }

    public void setPbcWalletStatus(Integer pbcWalletStatus) {
        this.pbcWalletStatus = pbcWalletStatus;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(String nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }

    public String getNomineeDob() {
        return nomineeDob;
    }

    public void setNomineeDob(String nomineeDob) {
        this.nomineeDob = nomineeDob;
    }

    public String getNomineeAddress() {
        return nomineeAddress;
    }

    public void setNomineeAddress(String nomineeAddress) {
        this.nomineeAddress = nomineeAddress;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getMfsType() {
        return mfsType;
    }

    public void setMfsType(String mfsType) {
        this.mfsType = mfsType;
    }

    public String getMfsNo() {
        return mfsNo;
    }

    public void setMfsNo(String mfsNo) {
        this.mfsNo = mfsNo;
    }

    public Object getInsurancePackageType() {
        return insurancePackageType;
    }

    public void setInsurancePackageType(Object insurancePackageType) {
        this.insurancePackageType = insurancePackageType;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public String getPolicyDocument() {
        return policyDocument;
    }

    public void setPolicyDocument(String policyDocument) {
        this.policyDocument = policyDocument;
    }

    public Object getPlacement() {
        return placement;
    }

    public void setPlacement(Object placement) {
        this.placement = placement;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public Object getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(Object referredBy) {
        this.referredBy = referredBy;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Object getMiddle() {
        return middle;
    }

    public void setMiddle(Object middle) {
        this.middle = middle;
    }

    public Object getRight() {
        return right;
    }

    public void setRight(Object right) {
        this.right = right;
    }

    public Integer getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(Integer kycStatus) {
        this.kycStatus = kycStatus;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(Integer isAgent) {
        this.isAgent = isAgent;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getIsFreeActive() {
        return isFreeActive;
    }

    public void setIsFreeActive(Integer isFreeActive) {
        this.isFreeActive = isFreeActive;
    }

    public Integer getTotalInitialInsurance() {
        return totalInitialInsurance;
    }

    public void setTotalInitialInsurance(Integer totalInitialInsurance) {
        this.totalInitialInsurance = totalInitialInsurance;
    }

    public Integer getIsMerchant() {
        return isMerchant;
    }

    public void setIsMerchant(Integer isMerchant) {
        this.isMerchant = isMerchant;
    }

    public Object getAgent() {
        return agent;
    }

    public void setAgent(Object agent) {
        this.agent = agent;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(email);
        dest.writeValue(username);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(phone);
        dest.writeValue(avatar);
        dest.writeValue(address);
        dest.writeValue(countryId);
        dest.writeValue(roleId);
        dest.writeValue(birthday);
        dest.writeValue(lastLogin);
        dest.writeValue(status);
        dest.writeValue(twoFactorCountryCode);
        dest.writeValue(twoFactorPhone);
        dest.writeValue(twoFactorOptions);
        dest.writeValue(emailVerifiedAt);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(announcementsLastReadAt);
        dest.writeValue(fatherName);
        dest.writeValue(motherName);
        dest.writeValue(gender);
        dest.writeValue(presentAddress);
        dest.writeValue(permanentAddress);
        dest.writeValue(bloodGroup);
        dest.writeValue(religion);
        dest.writeValue(nid);
        dest.writeValue(nidPhotoFront);
        dest.writeValue(nidPhotoBack);
        dest.writeValue(fb);
        dest.writeValue(mainWallet);
        dest.writeValue(totalSelfId);
        dest.writeValue(withdrawWallet);
        dest.writeValue(socialIncomeWallet);
        dest.writeValue(mainWalletStatus);
        dest.writeValue(shoppingWallet);
        dest.writeValue(shoppingWalletStatus);
        dest.writeValue(pbcWallet);
        dest.writeValue(usdt);
        dest.writeValue(pbcWalletStatus);
        dest.writeValue(nomineeName);
        dest.writeValue(nomineeRelation);
        dest.writeValue(nomineeDob);
        dest.writeValue(nomineeAddress);
        dest.writeValue(accountName);
        dest.writeValue(bankName);
        dest.writeValue(accountNo);
        dest.writeValue(branchName);
        dest.writeValue(mfsType);
        dest.writeValue(mfsNo);
        dest.writeValue(insurancePackageType);
        dest.writeValue(insuranceNo);
        dest.writeValue(policyDocument);
        dest.writeValue(placement);
        dest.writeValue(position);
        dest.writeValue(referredBy);
        dest.writeValue(left);
        dest.writeValue(middle);
        dest.writeValue(right);
        dest.writeValue(kycStatus);
        dest.writeValue(accountStatus);
        dest.writeValue(isAgent);
        dest.writeValue(isVip);
        dest.writeValue(isFreeActive);
        dest.writeValue(totalInitialInsurance);
        dest.writeValue(isMerchant);
        dest.writeValue(agent);
        dest.writeValue(buyType);
    }

    public int describeContents() {
        return  0;
    }

}
