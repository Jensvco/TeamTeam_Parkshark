package com.switchfully.teamteam.parkshark.api.members.dtos;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressMapper;
import com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates.LicensePlateMapper;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberMapper;
import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import com.switchfully.teamteam.parkshark.domain.memberships.Membership;
import com.switchfully.teamteam.parkshark.domain.memberships.MembershipType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.switchfully.teamteam.parkshark.domain.members.Member.MemberBuilder.member;
import static com.switchfully.teamteam.parkshark.domain.memberships.MembershipType.BRONZE;
import static java.util.stream.Collectors.toList;

@Component
public class MemberMapper implements Mapper<CreateMemberDto, MemberDto, Member> {

    private AddressMapper addressMapper;
    private LicensePlateMapper licensePlateMapper;
    private PhoneNumberMapper phoneNumberMapper;

    @Autowired
    public MemberMapper(AddressMapper addressMapper,
                        LicensePlateMapper licensePlateMapper,
                        PhoneNumberMapper phoneNumberMapper) {
        this.addressMapper = addressMapper;
        this.licensePlateMapper = licensePlateMapper;
        this.phoneNumberMapper = phoneNumberMapper;
    }

    @Override
    public Member toDomain(CreateMemberDto createMemberDto) {
        var licensePlate = new LicensePlate(createMemberDto.getLicensePlateNumber(),
                createMemberDto.getLicensePlateIssuingCountry());
        return member()
                .withAddress(addressMapper.toDomain(createMemberDto.getAddress()))
                .withEmail(createMemberDto.getEmail())
                .withFirstName(createMemberDto.getFirstName())
                .withLastName(createMemberDto.getLastName())
                .withLicensePlate(licensePlate)
                .withPhoneNumbers(createMemberDto.getPhoneNumbers().stream()
                        .map(value -> phoneNumberMapper.toDomain(value))
                        .collect(toList()))
                .withMembership(enrichWithMembership(createMemberDto.getMembershipType()))
                .build();
    }

    private Membership enrichWithMembership(MembershipType membershipType) {
        return membershipType == null ?
                new Membership(BRONZE) : new Membership(membershipType);
    }


    public Member toDomain(MemberDto memberDto) {
        return member()
                .withAddress(addressMapper.toDomain(memberDto.getAddress()))
                .withEmail(memberDto.getEmail())
                .withFirstName(memberDto.getFirstName())
                .withLastName(memberDto.getLastName())
                .withLicensePlate(licensePlateMapper.toDomain(memberDto.getLicensePlate()))
                .withPhoneNumbers(memberDto.getPhoneNumbers().stream()
                        .map(value -> phoneNumberMapper.toDomain(value))
                        .collect(toList()))
                .withMembership(enrichWithMembership(memberDto.getMembershipType()))
                .build();
    }

    public OverviewMemberDto toOverviewDto(Member member) {
        return new OverviewMemberDto(
                member.getId()
                , member.getFirstName()
                , member.getLastName()
                , member.getPhoneNumbers().stream().map(value -> phoneNumberMapper.toDto(value)).collect(toList())
                , member.getEmail()
                , licensePlateMapper.toOverviewDto(member.getLicensePlate())
                , member.getRegistrationDate()
                , member.getMembership().getType());
    }

    @Override
    public MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId()
                , member.getFirstName()
                , member.getLastName()
                , addressMapper.toDto(member.getAddress())
                , member.getPhoneNumbers().stream()
                .map(value -> phoneNumberMapper.toDto(value))
                .collect(toList())
                , member.getEmail()
                , licensePlateMapper.toDto(member.getLicensePlate())
                , member.getRegistrationDate()
                , member.getMembership().getType());
    }

}
