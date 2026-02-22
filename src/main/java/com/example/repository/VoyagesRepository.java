package com.example.repository;

import com.example.entity.Voyages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoyagesRepository extends JpaRepository<Voyages, String> {
    Long countByBench(String bench);

    @Query("SELECT DISTINCT p.bench FROM Voyages p")
    List<String> findDistinctBenches();
}
