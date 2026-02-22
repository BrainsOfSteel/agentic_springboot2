package com.example.service;

import com.example.entity.Voyages;
import java.util.List;
import java.util.Map;

public interface VoyagesService {
    Voyages saveVoyage(Voyages voyage);
    List<Voyages> getAllVoyages();
    Voyages getVoyageById(String id);
    void deleteVoyage(String id);

    Map<String, Long> getCountByBenchName();
}
