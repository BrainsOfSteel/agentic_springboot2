package com.example.service;

import com.example.entity.inheritance.Topic;

import java.util.List;

public interface CommonService<T> {
    T save(T t);
    List<T> findAll();
    T findById(Long id);
    void deleteById(Long id);
}
