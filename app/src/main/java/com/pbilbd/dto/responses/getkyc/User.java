
package com.pbilbd.dto.responses.getkyc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class User implements Serializable
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
    private Object avatar;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("country_id")
    @Expose
    private Object countryId;
    @SerializedName("role_id")
    @Expose
    private String roleId;
    @SerializedName("birthday")
    @Expose
    private Object birthday;
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
    private Object announcementsLastReadAt;
    @SerializedName("father_name")
    @Expose
    private Object fatherName;
    @SerializedName("mother_name")
    @Expose
    private Object motherName;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("present_address")
    @Expose
    private Object presentAddress;
    @SerializedName("permanent_address")
    @Expose
    private Object permanentAddress;
    @SerializedName("blood_group")
    @Expose
    private Object bloodGroup;
    @SerializedName("religion")
    @Expose
    private Object religion;
    @SerializedName("nid")
    @Expose
    private Object nid;
    @SerializedName("nid_photo_front")
    @Expose
    private Object nidPhotoFront;
    @SerializedName("nid_photo_back")
    @Expose
    private Object nidPhotoBack;
    @SerializedName("fb")
    @Expose
    private Object fb;
    @SerializedName("main_wallet")
    @Expose
    private String mainWallet;
    @SerializedName("total_self_id")
    @Expose
    private String totalSelfId;
    @SerializedName("withdraw_wallet")
    @Expose
    private String withdrawWallet;
    @SerializedName("social_income_wallet")
    @Expose
    private String socialIncomeWallet;
    @SerializedName("main_wallet_status")
    @Expose
    private String mainWalletStatus;
    @SerializedName("shopping_wallet")
    @Expose
    private String shoppingWallet;
    @SerializedName("shopping_wallet_status")
    @Expose
    private String shoppingWalletStatus;
    @SerializedName("pbc_wallet")
    @Expose
    private String pbcWallet;
    @SerializedName("usdt")
    @Expose
    private String usdt;
    @SerializedName("pbc_wallet_status")
    @Expose
    private String pbcWalletStatus;
    @SerializedName("nominee_name")
    @Expose
    private Object nomineeName;
    @SerializedName("nominee_relation")
    @Expose
    private Object nomineeRelation;
    @SerializedName("nominee_dob")
    @Expose
    private Object nomineeDob;
    @SerializedName("nominee_address")
    @Expose
    private Object nomineeAddress;
    @SerializedName("account_name")
    @Expose
    private Object accountName;
    @SerializedName("bank_name")
    @Expose
    private Object bankName;
    @SerializedName("account_no")
    @Expose
    private Object accountNo;
    @SerializedName("branch_name")
    @Expose
    private Object branchName;
    @SerializedName("mfs_type")
    @Expose
    private Object mfsType;
    @SerializedName("mfs_no")
    @Expose
    private Object mfsNo;
    @SerializedName("insurance_package_type")
    @Expose
    private Object insurancePackageType;
    @SerializedName("insurance_no")
    @Expose
    private Object insuranceNo;
    @SerializedName("policy_document")
    @Expose
    private Object policyDocument;
    @SerializedName("placement")
    @Expose
    private Object placement;
    @SerializedName("position")
    @Expose
    private Object position;
    @SerializedName("referred_by")
    @Expose
    private String referredBy;
    @SerializedName("left")
    @Expose
    private Object left;
    @SerializedName("middle")
    @Expose
    private Object middle;
    @SerializedName("right")
    @Expose
    private Object right;
    @SerializedName("kyc_status")
    @Expose
    private String kycStatus;
    @SerializedName("account_status")
    @Expose
    private String accountStatus;
    @SerializedName("is_agent")
    @Expose
    private String isAgent;
    @SerializedName("is_vip")
    @Expose
    private String isVip;
    @SerializedName("is_classic")
    @Expose
    private String isClassic;
    @SerializedName("is_free_active")
    @Expose
    private String isFreeActive;
    @SerializedName("total_initial_insurance")
    @Expose
    private String totalInitialInsurance;
    @SerializedName("is_merchant")
    @Expose
    private String isMerchant;
    @SerializedName("agent")
    @Expose
    private Object agent;
    @SerializedName("buy_type")
    @Expose
    private String buyType;

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

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getCountryId() {
        return countryId;
    }

    public void setCountryId(Object countryId) {
        this.countryId = countryId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
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

    public Object getAnnouncementsLastReadAt() {
        return announcementsLastReadAt;
    }

    public void setAnnouncementsLastReadAt(Object announcementsLastReadAt) {
        this.announcementsLastReadAt = announcementsLastReadAt;
    }

    public Object getFatherName() {
        return fatherName;
    }

    public void setFatherName(Object fatherName) {
        this.fatherName = fatherName;
    }

    public Object getMotherName() {
        return motherName;
    }

    public void setMotherName(Object motherName) {
        this.motherName = motherName;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(Object presentAddress) {
        this.presentAddress = presentAddress;
    }

    public Object getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Object permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Object getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Object bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Object getReligion() {
        return religion;
    }

    public void setReligion(Object religion) {
        this.religion = religion;
    }

    public Object getNid() {
        return nid;
    }

    public void setNid(Object nid) {
        this.nid = nid;
    }

    public Object getNidPhotoFront() {
        return nidPhotoFront;
    }

    public void setNidPhotoFront(Object nidPhotoFront) {
        this.nidPhotoFront = nidPhotoFront;
    }

    public Object getNidPhotoBack() {
        return nidPhotoBack;
    }

    public void setNidPhotoBack(Object nidPhotoBack) {
        this.nidPhotoBack = nidPhotoBack;
    }

    public Object getFb() {
        return fb;
    }

    public void setFb(Object fb) {
        this.fb = fb;
    }

    public String getMainWallet() {
        return mainWallet;
    }

    public void setMainWallet(String mainWallet) {
        this.mainWallet = mainWallet;
    }

    public String getTotalSelfId() {
        return totalSelfId;
    }

    public void setTotalSelfId(String totalSelfId) {
        this.totalSelfId = totalSelfId;
    }

    public String getWithdrawWallet() {
        return withdrawWallet;
    }

    public void setWithdrawWallet(String withdrawWallet) {
        this.withdrawWallet = withdrawWallet;
    }

    public String getSocialIncomeWallet() {
        return socialIncomeWallet;
    }

    public void setSocialIncomeWallet(String socialIncomeWallet) {
        this.socialIncomeWallet = socialIncomeWallet;
    }

    public String getMainWalletStatus() {
        return mainWalletStatus;
    }

    public void setMainWalletStatus(String mainWalletStatus) {
        this.mainWalletStatus = mainWalletStatus;
    }

    public String getShoppingWallet() {
        return shoppingWallet;
    }

    public void setShoppingWallet(String shoppingWallet) {
        this.shoppingWallet = shoppingWallet;
    }

    public String getShoppingWalletStatus() {
        return shoppingWalletStatus;
    }

    public void setShoppingWalletStatus(String shoppingWalletStatus) {
        this.shoppingWalletStatus = shoppingWalletStatus;
    }

    public String getPbcWallet() {
        return pbcWallet;
    }

    public void setPbcWallet(String pbcWallet) {
        this.pbcWallet = pbcWallet;
    }

    public String getUsdt() {
        return usdt;
    }

    public void setUsdt(String usdt) {
        this.usdt = usdt;
    }

    public String getPbcWalletStatus() {
        return pbcWalletStatus;
    }

    public void setPbcWalletStatus(String pbcWalletStatus) {
        this.pbcWalletStatus = pbcWalletStatus;
    }

    public Object getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(Object nomineeName) {
        this.nomineeName = nomineeName;
    }

    public Object getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(Object nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }

    public Object getNomineeDob() {
        return nomineeDob;
    }

    public void setNomineeDob(Object nomineeDob) {
        this.nomineeDob = nomineeDob;
    }

    public Object getNomineeAddress() {
        return nomineeAddress;
    }

    public void setNomineeAddress(Object nomineeAddress) {
        this.nomineeAddress = nomineeAddress;
    }

    public Object getAccountName() {
        return accountName;
    }

    public void setAccountName(Object accountName) {
        this.accountName = accountName;
    }

    public Object getBankName() {
        return bankName;
    }

    public void setBankName(Object bankName) {
        this.bankName = bankName;
    }

    public Object getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Object accountNo) {
        this.accountNo = accountNo;
    }

    public Object getBranchName() {
        return branchName;
    }

    public void setBranchName(Object branchName) {
        this.branchName = branchName;
    }

    public Object getMfsType() {
        return mfsType;
    }

    public void setMfsType(Object mfsType) {
        this.mfsType = mfsType;
    }

    public Object getMfsNo() {
        return mfsNo;
    }

    public void setMfsNo(Object mfsNo) {
        this.mfsNo = mfsNo;
    }

    public Object getInsurancePackageType() {
        return insurancePackageType;
    }

    public void setInsurancePackageType(Object insurancePackageType) {
        this.insurancePackageType = insurancePackageType;
    }

    public Object getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(Object insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public Object getPolicyDocument() {
        return policyDocument;
    }

    public void setPolicyDocument(Object policyDocument) {
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

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public Object getLeft() {
        return left;
    }

    public void setLeft(Object left) {
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

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(String isAgent) {
        this.isAgent = isAgent;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getIsClassic() {
        return isClassic;
    }

    public void setIsClassic(String isClassic) {
        this.isClassic = isClassic;
    }

    public String getIsFreeActive() {
        return isFreeActive;
    }

    public void setIsFreeActive(String isFreeActive) {
        this.isFreeActive = isFreeActive;
    }

    public String getTotalInitialInsurance() {
        return totalInitialInsurance;
    }

    public void setTotalInitialInsurance(String totalInitialInsurance) {
        this.totalInitialInsurance = totalInitialInsurance;
    }

    public String getIsMerchant() {
        return isMerchant;
    }

    public void setIsMerchant(String isMerchant) {
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

}
