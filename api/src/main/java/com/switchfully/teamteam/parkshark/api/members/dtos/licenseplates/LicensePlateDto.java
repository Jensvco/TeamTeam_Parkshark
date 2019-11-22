package com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates;

public class LicensePlateDto {
    private Integer id;
    private String number;
    private String issuingCountry;

    public LicensePlateDto(Integer id, String number, String issuingCountry) {
        this.id = id;
        this.number = number;
        this.issuingCountry = issuingCountry;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }
}
