package com.dione.testingmanagebackend.controlleur;


import com.dione.testingmanagebackend.entities.Testeur;
import com.dione.testingmanagebackend.service.serviceImpl.TesteurServiceImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testeurManager")
public class TesteurControlleur {
    private final TesteurServiceImpl testeurService;

    private  Testeur test=new Testeur();

    public TesteurControlleur(TesteurServiceImpl testeurService) {
        this.testeurService = testeurService;
    }

    @GetMapping
    public ResponseEntity<List<Testeur>> getAllTesteur(){
        List<Testeur> testeurs = testeurService.getAllTesteur();
        return ResponseEntity.ok().body(testeurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Testeur> getTesteur(@PathVariable(value="id") Long idTesteur) throws ResourceNotFoundException {
        test = testeurService.getTesteur(idTesteur);
        return ResponseEntity.ok().body(test);
    }

    @PostMapping
    public ResponseEntity<Testeur> addTesteur(@RequestBody Testeur testeur){
        return ResponseEntity.ok().body(testeurService.addTesteur(testeur));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Testeur> updateTesteur(@PathVariable (value = "id", required = false) Long idTesteur, @RequestBody Testeur testeurRequest ) throws ResourceNotFoundException {
        testeurRequest.setIdTesteur(idTesteur);
        return ResponseEntity.ok().body(testeurService.updateTesteur(testeurRequest));
    }

    @DeleteMapping("/{id}")
    public String deletePersonne(@PathVariable(value="id") Long idTesteur){
        testeurService.deleteTesteur(idTesteur);
        return "ok";
    }
}
