package com.dione.testingmanagebackend.service.serviceImpl;

import com.dione.testingmanagebackend.entities.Releas;
import com.dione.testingmanagebackend.repository.ReleaseRepository;
import com.dione.testingmanagebackend.service.IReleasService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleasServiceImpl implements IReleasService {

    private final ReleaseRepository releaseRepository;

    public ReleasServiceImpl(ReleaseRepository releaseRepository){
        this.releaseRepository=releaseRepository;
    }

    @Override
    public Releas getReleas(Long refRelease) throws ResourceNotFoundException {
        return releaseRepository.findById(refRelease).orElseThrow(() -> new ResourceNotFoundException("release non trouvé"));
    }

    @Override
    public Releas updateReleas(Releas releas) throws ResourceNotFoundException {
        return releaseRepository.save(releas);
    }

    @Override
    public Releas addReleas(Releas releas) {
        return releaseRepository.save(releas);
    }

    @Override
    public void deleteReleas(Long refRelease) {
        releaseRepository.deleteById(refRelease);
    }

    @Override
    public List<Releas> getAllReleas() {
        return releaseRepository.findAll();
    }
}
