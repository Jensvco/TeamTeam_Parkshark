package com.switchfully.teamteam.parkshark.service.members;

import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.service.EntityValidator;
import org.springframework.stereotype.Component;

@Component
public class MemberValidator extends EntityValidator<Member> {

    @Override
    protected boolean isAFieldEmptyOrNull(Member member) {
        return isNull(member)
                || isEmptyOrNull(member.getFirstName())
                || isEmptyOrNull(member.getLastName())
                || isNull(member.getAddress())
                || isEmptyOrNull(member.getEmail())
                || isNull(member.getLicensePlate())
                || isNull(member.getRegistrationDate());
    }
}
