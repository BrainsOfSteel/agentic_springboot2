package com.example.service;

import com.example.entity.inheritance.Topic;
import com.example.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService implements CommonService<Topic>{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public Topic findById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }
}
