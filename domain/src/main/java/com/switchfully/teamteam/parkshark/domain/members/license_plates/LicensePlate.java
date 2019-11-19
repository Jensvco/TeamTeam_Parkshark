package com.switchfully.teamteam.parkshark.domain.members.license_plates;

public class LicensePlate {

    private String number;
    private String issuingCountry;

    public static class LicensePlateBuilder {
        private String number;
        private String issuingCountry;

        public static LicensePlateBuilder licensePlate() {
            return new LicensePlateBuilder();
        }
    }

}
