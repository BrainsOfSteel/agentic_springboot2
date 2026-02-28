package com.example.entity.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "announcement")
@PrimaryKeyJoinColumn(name="topic_id")
public class Announcement extends Topic{

    @Column(name = "details")
    private String details;

    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {this.details = details;}
}
