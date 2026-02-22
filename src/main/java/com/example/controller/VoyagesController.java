package com.example.controller;

import com.example.entity.Voyages;
import com.example.service.VoyagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/voyages")
public class VoyagesController {

    @Autowired
    private VoyagesService voyagesService;

    @PostMapping
    public Voyages createVoyage(@RequestBody Voyages voyage) {
        return voyagesService.saveVoyage(voyage);
    }

    @GetMapping
    public List<Voyages> getAllVoyages() {
        return voyagesService.getAllVoyages();
    }

    @GetMapping("/{id}")
    public Voyages getVoyageById(@PathVariable String id) {
        return voyagesService.getVoyageById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteVoyage(@PathVariable String id) {
        voyagesService.deleteVoyage(id);
    }

    @GetMapping("/distinctCountByBenches")
    public Map<String, Long> getDistinctCountByBenches() {
        return voyagesService.getCountByBenchName();
    }
}
