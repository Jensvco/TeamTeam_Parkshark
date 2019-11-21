package com.switchfully.teamteam.parkshark.service.members;

import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.MemberRepository;
import com.switchfully.teamteam.parkshark.infrastructure.exception.NotCreatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
            throw new NotCreatedException();
        }
        return memberRepository.save(memberToCreate);
    }


    public Member findMemberById(int id){
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()){
            return member.get();
        }
        return null;
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }


    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }



}