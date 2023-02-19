package com.dione.testingmanagebackend.service;

import com.dione.testingmanagebackend.entities.Ticket;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public interface ITicketService {
    Ticket getTicket(Long refTicket) throws ResourceNotFoundException;
    Ticket updateTicket( Ticket ticket) throws ResourceNotFoundException;
    Ticket addTicket(Ticket ticket);
    void deleteTicket(Long refTicket);
    List<Ticket> getAllTicket();

    List<Ticket> getAllTicketForRelease(Long id);

    Object getVision(Long id);

    Object getVisionBloquante(Long id);

    Object getVisionMajeure(Long id);

    Object getVisionMineure(Long id);
}
