package com.fyle.interview.controller.viewmode.response;

import com.fyle.interview.model.BankBranchesDto;

public class BankDetailsModel {
    private String ifsc;
    private String bankName;
    private String branch;
    private String address;
    private String district;
    private String city;
    private String state;

    public BankDetailsModel(BankBranchesDto bankBranchesDto) {
        this.ifsc = bankBranchesDto.getIfsc();
        this.bankName = bankBranchesDto.getBank_name();
        this.branch = bankBranchesDto.getBranch();
        this.address = bankBranchesDto.getAddress();
        this.district = bankBranchesDto.getDistrict();
        this.city = bankBranchesDto.getCity();
        this.state = bankBranchesDto.getState();
    }

    @Override
    public String toString() {
        return "BankDetailsModel{" +
                "ifsc='" + ifsc + '\'' +
                ", bankName='" + bankName + '\'' +
                ", branch='" + branch + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
}
