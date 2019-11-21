package com.switchfully.teamteam.parkshark.api.members.dtos;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressMapper;
import com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates.LicensePlateMapper;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberMapper;
import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class MemberMapper implements Mapper<CreateMemberDto, MemberDto, Member> {


    private AddressMapper addressMapper;
    private LicensePlateMapper licensePlateMapper;
    private PhoneNumberMapper phoneNumberMapper;


    @Autowired
    public MemberMapper(AddressMapper addressMapper, LicensePlateMapper licensePlateMapper, PhoneNumberMapper phoneNumberMapper) {
        this.addressMapper = addressMapper;
        this.licensePlateMapper = licensePlateMapper;
        this.phoneNumberMapper = phoneNumberMapper;
    }


    @Override
    public Member toDomain(CreateMemberDto createMemberDto) {
        LicensePlate licensePlate = new LicensePlate(createMemberDto.getLicensePlateNumber(),createMemberDto.getLicensePlateIssuingCountry());
        return Member.memberBuilder()
                .withAddress(addressMapper.toDomain(createMemberDto.getAddress()))
                .withEmail(createMemberDto.getEmail())
                .withFirstName(createMemberDto.getFirstName())
                .withLastName(createMemberDto.getLastName())
                .withLicensePlate(Arrays.asList(licensePlate))
                .withPhoneNumber(createMemberDto.getPhoneNumbers().stream()
                        .map(value -> phoneNumberMapper.toDomain(value))
                        .collect(Collectors.toList()))
                .build();

    }

    public Member toDomain(MemberDto memberDto) {
        return Member.memberBuilder()
                .withAddress(addressMapper.toDomain(memberDto.getAddress()))
                .withEmail(memberDto.getEmail())
                .withFirstName(memberDto.getFirstName())
                .withLastName(memberDto.getLastName())
                .withLicensePlate(memberDto.getLicensePlate().stream()
                        .map(value -> licensePlateMapper.toDomain(value))
                        .collect(Collectors.toList()))
                .withPhoneNumber(memberDto.getPhoneNumbers().stream()
                        .map(value -> phoneNumberMapper.toDomain(value))
                        .collect(Collectors.toList()))
                .build();

    }



    public OverviewMemberDto toOverviewDto(Member member) {
        return new OverviewMemberDto(
                member.getId()
                , member.getFirstName()
                , member.getLastName()
                , member.getPhoneNumbers().stream().map(value -> phoneNumberMapper.toDto(value)).collect(Collectors.toList())
                , member.getEmail()
                , member.getLicensePlate().stream().map(value -> licensePlateMapper.toOverviewDto(value))
                .collect(Collectors.toList())
                , member.getRegistrationDate());
    }

    @Override
    public MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId()
                , member.getFirstName()
                , member.getLastName()
                , addressMapper.toDto(member.getAddress())
                , member.getPhoneNumbers().stream().map(value -> phoneNumberMapper.toDto(value)).collect(Collectors.toList())
                , member.getEmail()
                , member.getLicensePlate().stream().map(value -> licensePlateMapper.toDto(value)).collect(Collectors.toList())
                , member.getRegistrationDate());
    }
}
