package com.usa.ciclo4.reto2.controller;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2.model.Fragance;
import com.usa.ciclo4.reto2.service.FranganceService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fragance")
@CrossOrigin("*")
public class FranganceController {

    @Autowired
    private FranganceService franganceService;   
   
    @GetMapping("/all")
    public List<Fragance> getAllFragance() {
        return franganceService.getAllFragance();
    }
    
    @GetMapping("/{reference}")
    public Optional<Fragance> getFraganceId(@PathVariable("reference") String reference) {
        return franganceService.getFragance(reference);
    }  
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Fragance fragance) {
        franganceService.create(fragance);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Fragance fragance) {
        franganceService.update(fragance);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return franganceService.delete(reference);
    }
}
