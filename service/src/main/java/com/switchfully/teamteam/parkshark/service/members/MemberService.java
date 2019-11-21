package com.switchfully.teamteam.parkshark.service.members;

import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberValidator memberValidator;

    @Autowired
    public MemberService(MemberRepository memberRepository, MemberValidator memberValidator) {
        this.memberRepository = memberRepository;
        this.memberValidator = memberValidator;
    }

    public Member createMember(Member memberToCreate) {
        if (!memberValidator.isValidForCreation(memberToCreate)) {
            throw new IllegalArgumentException();
        }
        return memberRepository.save(memberToCreate);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

}