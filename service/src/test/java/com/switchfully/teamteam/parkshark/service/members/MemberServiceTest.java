package com.switchfully.teamteam.parkshark.service.members;

import com.switchfully.teamteam.parkshark.domain.Address;
import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.MemberRepository;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private MemberValidator memberValidator;

    @InjectMocks
    private MemberService memberService;

    private Member member;

    @BeforeEach
    void setUp() {
        initMocks(this);

        Address address = new Address.Builder()
                .withCity("Aalter")
                .withHouseNumber("50")
                .withStreetName("Bosstraat")
                .build();

        LicensePlate licensePlate = new LicensePlate("123-abc", "BE");

        member = Member.memberBuilder()
                .withFirstName("firstyname")
                .withLastName("lastyname")
                .withAddress(address)
                .withEmail("boe@boe.be")
                .withLicensePlate(licensePlate)
                .build();
    }

    @Test
    void createMember_whenMemberValidForCreation() {
        when(memberRepository.save(member)).thenReturn(member);
        when(memberValidator.isValidForCreation(member)).thenReturn(true);

        assertThat(memberService.createMember(member)).isEqualToComparingFieldByField(member);
    }


}