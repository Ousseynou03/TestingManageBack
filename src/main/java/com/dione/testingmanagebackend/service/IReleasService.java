package com.dione.testingmanagebackend.service;

import com.dione.testingmanagebackend.entities.Releas;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public interface IReleasService {
    Releas getReleas(Long refRelease) throws ResourceNotFoundException;
    Releas updateReleas( Releas releas) throws ResourceNotFoundException;
    Releas addReleas(Releas releas);
    void deleteReleas(Long refRelease);
    List<Releas> getAllReleas();
}
