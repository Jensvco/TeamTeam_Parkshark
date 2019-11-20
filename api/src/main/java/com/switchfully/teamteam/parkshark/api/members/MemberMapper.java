package com.switchfully.teamteam.parkshark.api.members;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressMapper;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberMapper;
import com.switchfully.teamteam.parkshark.domain.members.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberMapper implements Mapper<CreateMemberDto,MemberDto, Member> {


    private AddressMapper addressMapper;
    private LicensePlateMapper licensePlateMapper;
    private PhoneNumberMapper phoneNumberMapper;


    @Autowired
    public MemberMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public Member toDomain(CreateMemberDto createMemberDto) {
        return new Member.MemberBuilder()
                .withAddress(addressMapper.toDomain(createMemberDto.getAddress()))
                .withEmail(createMemberDto.getEmail())
                .withFirstName(createMemberDto.getFirstName())
                .withLastName(createMemberDto.getLastName())
                .withLicensePlate()
                .withPhoneNumber()

    }

    @Override
    public MemberDto toDto(Member member) {
        return null;
    }
}
