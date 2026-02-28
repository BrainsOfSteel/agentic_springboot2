package com.example.service;

import com.example.entity.inheritance.Announcement;
import com.example.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService implements CommonService<Announcement> {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Override
    public Announcement save(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement findById(Long id) {
        return announcementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        announcementRepository.deleteById(id);
    }
}
