package com.example.controller;

import com.example.entity.inheritance.Announcement;
import com.example.entity.inheritance.Post;
import com.example.entity.inheritance.Topic;
import com.example.service.AnnouncementService;
import com.example.service.CommonService;
import com.example.service.PostService;
import com.example.service.TopicService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/topics/")
public class TopicController {

    private final Map<String, CommonService> router;
    private final ObjectMapper mapper;

    @Autowired
    public TopicController(TopicService topicService, AnnouncementService announcementService, PostService postService) {
        router = new HashMap<>();
        mapper = new ObjectMapper();
        router.put("announcement", announcementService);
        router.put("topic", topicService);
        router.put("post", postService);
    }

    private Class<? extends Topic> resolveClass(String className) {
        return switch (className.toLowerCase()) {
            case "announcement" -> Announcement.class;
            case "topic" -> Topic.class;
            case "post" -> Post.class;
            default -> throw new IllegalArgumentException("Unknown class: " + className);
        };
    }

    @PostMapping("/new/{className}")
    public Object createObject(@PathVariable("className") String className, @RequestBody Map<String, Object> rawBody) {
        Class<? extends Topic> clazz = resolveClass(className);
        Object object = mapper.convertValue(rawBody, clazz);
        // 2. Deserialize the body into the correct child class
        return router.get(className).save(object);
    }

    @GetMapping("/all/{className}")
    public List<Object> getAll(@PathVariable("className") String className) {
        return router.get(className).findAll();
    }

    @GetMapping("/{className}/{id}")
    public Object findById(@PathVariable String className, @PathVariable Long id) {
        return router.get(className).findById(id);
    }

    @DeleteMapping("/{className}/{id}")
    public void deleteTopic(@PathVariable String className, @PathVariable Long id) {
        router.get(className).deleteById(id);
    }
}
