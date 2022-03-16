
package com.pbilbd.dto.responses.getkyc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class GetKYCResponse implements Serializable
{

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("edit")
    @Expose
    private Boolean edit;
    @SerializedName("roles")
    @Expose
    private Roles roles;
    @SerializedName("countries")
    @Expose
    private List<Country> countries = null;
    @SerializedName("socialLogins")
    @Expose
    private List<Object> socialLogins = null;
    @SerializedName("statuses")
    @Expose
    private Statuses statuses;
    @SerializedName("agents")
    @Expose
    private List<Agent> agents = null;
    @SerializedName("districts")
    @Expose
    private List<District> districts = null;
    @SerializedName("blood_groups")
    @Expose
    private List<String> bloodGroups = null;
    @SerializedName("religions")
    @Expose
    private List<String> religions = null;
    @SerializedName("shopping_wallet")
    @Expose
    private String shoppingWallet;
    @SerializedName("banks")
    @Expose
    private List<String> banks = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Object> getSocialLogins() {
        return socialLogins;
    }

    public void setSocialLogins(List<Object> socialLogins) {
        this.socialLogins = socialLogins;
    }

    public Statuses getStatuses() {
        return statuses;
    }

    public void setStatuses(Statuses statuses) {
        this.statuses = statuses;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<String> getBloodGroups() {
        return bloodGroups;
    }

    public void setBloodGroups(List<String> bloodGroups) {
        this.bloodGroups = bloodGroups;
    }

    public List<String> getReligions() {
        return religions;
    }

    public void setReligions(List<String> religions) {
        this.religions = religions;
    }

    public String getShoppingWallet() {
        return shoppingWallet;
    }

    public void setShoppingWallet(String shoppingWallet) {
        this.shoppingWallet = shoppingWallet;
    }

    public List<String> getBanks() {
        return banks;
    }

    public void setBanks(List<String> banks) {
        this.banks = banks;
    }

}
