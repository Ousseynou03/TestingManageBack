package com.dione.testingmanagebackend.controlleur;

import com.dione.testingmanagebackend.entities.Ticket;
import com.dione.testingmanagebackend.service.serviceImpl.TicketServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketManager")
public class TicketControlleur{

    @Autowired
    private TicketServiceImpl ticketService;

    private Ticket ticket = new Ticket();

//    public TicketControlleur (TicketServiceImpl ticketService) {
//        this.ticketService = ticketService;
//    }
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Ticket>> getAllTicket(){
        List<Ticket> tickets = ticketService.getAllTicket();
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping("/ticketRelease/{id}")
    public ResponseEntity<List<Ticket>> getAllTicketRelease(@PathVariable(value="id") Long id)throws ResourceNotFoundException{
        List<Ticket> ticketForReleases = ticketService.getAllTicketForRelease(id);
        return ResponseEntity.ok().body(ticketForReleases);
    }

    @GetMapping("/visionsTicket/{id}")
    public ResponseEntity<Object> getVisionTicket(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
        Object vision = ticketService.getVision(id);
        return ResponseEntity.ok().body(vision);
    }

    @GetMapping("/visionsBloquante/{id}")
    public ResponseEntity<Object> getVisionBloquante(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
        Object visionBloquante = ticketService.getVisionBloquante(id);
        return ResponseEntity.ok().body(visionBloquante);
    }
    @GetMapping("/visionsMajeure/{id}")
    public ResponseEntity<Object> getVisionMajeure(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
        Object visionMajeure = ticketService.getVisionMajeure(id);
        return ResponseEntity.ok().body(visionMajeure);
    }
    @GetMapping("/visionsMineure/{id}")
    public ResponseEntity<Object> getVisionMineure(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
        Object visionMineure = ticketService.getVisionMineure(id);
        return ResponseEntity.ok().body(visionMineure);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable(value="id") Long refTicket) throws ResourceNotFoundException {
        ticket = ticketService.getTicket(refTicket);
        return ResponseEntity.ok().body(ticket);
    }

    @PostMapping
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok().body(ticketService.addTicket(ticket));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable (value = "id", required = false) Long refTicket, @RequestBody Ticket ticketRequest ) throws ResourceNotFoundException {
        ticketRequest.setRefTicket(refTicket);
        return ResponseEntity.ok().body(ticketService.updateTicket(ticketRequest));
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable(value="id") Long refTicket){
        ticketService.deleteTicket(refTicket);
        return "ok";
    }
}
