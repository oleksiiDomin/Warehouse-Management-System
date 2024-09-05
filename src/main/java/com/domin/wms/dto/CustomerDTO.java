package com.domin.wms.dto;

public class CustomerDTO {

    private String companyName;

    private String country;

    private String city;



    public CustomerDTO() {
    }

    public CustomerDTO(String companyName, String country, String city) {
        this.companyName = companyName;
        this.country = country;
        this.city = city;
    }



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
