package com.dione.testingmanagebackend.controlleur;

import com.dione.testingmanagebackend.entities.CasDeTest;
import com.dione.testingmanagebackend.service.serviceImpl.CasDeTestServiceImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casTestManager")
public class CasDeTestControlleur {

    private final CasDeTestServiceImpl casDeTestService;

    private CasDeTest casDeTest = new CasDeTest();

    public CasDeTestControlleur(CasDeTestServiceImpl casDeTestService) {
        this.casDeTestService = casDeTestService;
    }

    @GetMapping
    public ResponseEntity<List<CasDeTest>> getAllCasDeTest(){
        List<CasDeTest> casDeTests = casDeTestService.getAllCasDeTest();
        return ResponseEntity.ok().body(casDeTests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasDeTest> getCasDeTest(@PathVariable(value="id") Long refCasTest) throws ResourceNotFoundException {
        casDeTest = casDeTestService.getCasDeTest(refCasTest);
        return ResponseEntity.ok().body(casDeTest);
    }

    @GetMapping("/visionCasTest/{id}")
    public ResponseEntity<Object> getVisionCasDeTest(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Object casDeTest = casDeTestService.getCasVisionTest(id);
        return ResponseEntity.ok().body(casDeTest);
    }

    @PostMapping
    public ResponseEntity<CasDeTest> addCasDeTest(@RequestBody CasDeTest casDeTest){
        return ResponseEntity.ok().body(casDeTestService.addCasDeTest(casDeTest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasDeTest> updateCasDeTest(@PathVariable (value = "id", required = false) Long refCasTest, @RequestBody CasDeTest casDeTestRequest ) throws ResourceNotFoundException {
        casDeTestRequest.setRefCasTest(refCasTest);
        return ResponseEntity.ok().body(casDeTestService.updateCasDeTest(casDeTestRequest));
    }

    @DeleteMapping("/{id}")
    public String deleteCasDeTest(@PathVariable(value="id") Long refCasTest){
        casDeTestService.deleteCasDeTest(refCasTest);
        return "ok";
    }
}
