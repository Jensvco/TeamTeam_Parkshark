package com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates;

public class CreateLicensePlateDto {
    private String number;
    private String issuingCountry;



    public String getNumber() {
        return number;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public CreateLicensePlateDto(Long id, String number, String issuingCountry) {
        this.number = number;
        this.issuingCountry = issuingCountry;

    }

}
