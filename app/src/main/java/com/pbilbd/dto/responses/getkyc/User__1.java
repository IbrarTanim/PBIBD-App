
package com.pbilbd.dto.responses.getkyc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class User__1 implements Serializable
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
    private Object address;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("role_id")
    @Expose
    private String roleId;
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
    private String placement;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("referred_by")
    @Expose
    private String referredBy;
    @SerializedName("left")
    @Expose
    private String left;
    @SerializedName("middle")
    @Expose
    private String middle;
    @SerializedName("right")
    @Expose
    private String right;
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
    private String agent;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
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

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
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

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

}
