package com.fyle.interview.model;

public class BankBranchesDto {
    private String ifsc;
    private String bank_name;
    private String branch;
    private String address;
    private String district;
    private String city;
    private String state;

    @Override
    public String toString() {
        return "BankBranchesDto{" +
                "ifsc='" + ifsc + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", branch='" + branch + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

}
