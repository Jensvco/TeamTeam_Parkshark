package com.switchfully.teamteam.parkshark.service.members;

import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.MemberRepository;
import com.switchfully.teamteam.parkshark.infrastructure.apiExceptions.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

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
            throw new ApiRequestException("wrong JSON format");
        }
        return memberRepository.save(memberToCreate);
    }


    public Member findMemberById(Long id){
        Optional<Member> member = memberRepository.findById(id);
        return member.orElse(null);
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }


    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }



}