package com.example.entity.inheritance;

import jakarta.persistence.*;

@Entity
@Table(name = "topic_post")
@PrimaryKeyJoinColumn(name="topic_id")
public class Post extends Topic{

    @Column(name = "content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
