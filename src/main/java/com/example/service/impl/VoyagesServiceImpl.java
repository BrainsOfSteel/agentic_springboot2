package com.example.service.impl;

import com.example.entity.Voyages;
import com.example.repository.VoyagesRepository;
import com.example.service.VoyagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VoyagesServiceImpl implements VoyagesService {

    @Autowired
    private VoyagesRepository voyagesRepository;

    @Override
    public Voyages saveVoyage(Voyages voyage) {
        return voyagesRepository.save(voyage);
    }

    @Override
    public List<Voyages> getAllVoyages() {
        return voyagesRepository.findAll();
    }

    @Override
    public Voyages getVoyageById(String id) {
        Optional<Voyages> voyage = voyagesRepository.findById(id);
        return voyage.orElse(null);
    }

    @Override
    public void deleteVoyage(String id) {
        voyagesRepository.deleteById(id);
    }

    @Override
    public Map<String, Long> getCountByBenchName(){
        List<String> benches = voyagesRepository.findDistinctBenches();
        Map<String, Long> benchVsCount = new HashMap<>();
        for(String bench : benches){
            Long count = voyagesRepository.countByBench(bench);
            benchVsCount.put(bench, count);
        }

        return benchVsCount;
    }
}
