package com.switchfully.teamteam.parkshark.api.parking_spots;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.members.dtos.MemberMapper;
import com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates.LicensePlateMapper;
import com.switchfully.teamteam.parkshark.api.parking_lots.ParkingLotMapper;
import com.switchfully.teamteam.parkshark.domain.ParkingSpot;
import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import com.switchfully.teamteam.parkshark.domain.memberships.MembershipType;
import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import com.switchfully.teamteam.parkshark.service.members.MemberService;
import com.switchfully.teamteam.parkshark.service.parking_lots.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotMapper implements Mapper<CreateParkingSpotDto,ParkingSpotDto, ParkingSpot> {

    private MemberService memberService;
    private LicensePlateMapper licensePlateMapper;
    private ParkingLotService parkingLotService;
    private ParkingLotMapper parkingLotMapper;
    private MemberMapper memberMapper;
    private Member member;


    @Autowired
    public ParkingSpotMapper(MemberService memberService, LicensePlateMapper licensePlateMapper, ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.licensePlateMapper = licensePlateMapper;
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
        this.memberMapper = memberMapper;
    }


    @Override
    public ParkingSpot toDomain(CreateParkingSpotDto createParkingSpotDto) {
       LicensePlate licensePlate= licensePlateCheck(createParkingSpotDto);
       ParkingLot parkingLot= parkingLotService.findParkingLotById((int)createParkingSpotDto.getMemberId());
       return new ParkingSpot(licensePlate,member,parkingLot);
    }



    private LicensePlate licensePlateCheck(CreateParkingSpotDto createParkingSpotDto)  {
        member=memberService.findMemberById(createParkingSpotDto.getMemberId());
        if(member.getLicensePlate().getNumber()==createParkingSpotDto.getLicensePlateNumber()){
            return member.getLicensePlate();
        }
        if (member.getMembership().getType()== MembershipType.GOLD){
            return new LicensePlate(createParkingSpotDto.getLicensePlateNumber(),null);
        } else {
          //  throw new Exception("NON-GOLDMEMBERS CAN ONLY PARK THEIR OWN CAR");
            return null;
        }
    }

    @Override
    public ParkingSpotDto toDto(ParkingSpot parkingSpot) {
        return new ParkingSpotDto(parkingSpot.getId()
                ,licensePlateMapper.toDto(parkingSpot.getLicensePlate())
                ,memberMapper.toDto(parkingSpot.getMember())
                ,parkingLotMapper.toDto(parkingSpot.getParkingLot())
                ,parkingSpot.getStartSession()
                ,parkingSpot.getStopSession());
    }
}



