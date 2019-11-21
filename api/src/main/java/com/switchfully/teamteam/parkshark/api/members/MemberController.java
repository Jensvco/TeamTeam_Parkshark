package com.switchfully.teamteam.parkshark.api.members;

import com.switchfully.teamteam.parkshark.api.members.dtos.CreateMemberDto;
import com.switchfully.teamteam.parkshark.api.members.dtos.MemberDto;
import com.switchfully.teamteam.parkshark.api.members.dtos.MemberMapper;
import com.switchfully.teamteam.parkshark.api.members.dtos.OverviewMemberDto;
import com.switchfully.teamteam.parkshark.service.members.MemberService;
import com.switchfully.teamteam.parkshark.service.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/members")
public class MemberController {

    private MemberService memberService;
    private MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public MemberDto createMember(@RequestBody CreateMemberDto dto) {
        var memberToCreate = memberMapper.toDomain(dto);
        return memberMapper.toDto(memberService.createMember(memberToCreate));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<OverviewMemberDto> getAllMembers(){
       return memberService.getAllMembers().stream()
                .map(memberMapper::toOverviewDto)
                .collect(toList());
    }




}
