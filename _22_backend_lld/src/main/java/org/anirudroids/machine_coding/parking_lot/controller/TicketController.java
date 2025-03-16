package org.anirudroids.machine_coding.parking_lot.controller;

import org.anirudroids.machine_coding.parking_lot.dto.IssueTicketRequestDto;
import org.anirudroids.machine_coding.parking_lot.dto.IssueTicketResponseDto;
import org.anirudroids.machine_coding.parking_lot.dto.ResponseStatus;
import org.anirudroids.machine_coding.parking_lot.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        ticketService.issueTicket(
                issueTicketRequestDto.getLicensePlate(),
                issueTicketRequestDto.getOwnerName(),
                issueTicketRequestDto.getVehicleType(),
                issueTicketRequestDto.getGateId()
        );

        issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return issueTicketResponseDto;
    }
}
