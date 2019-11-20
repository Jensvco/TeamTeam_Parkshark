package com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates;

public class LicensePlateDto {
    private Long id;
    private String number;
    private String issuingCountry;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public LicensePlateDto(Long id, String number, String issuingCountry) {
        this.id = id;
        this.number = number;
        this.issuingCountry = issuingCountry;
    }
}
