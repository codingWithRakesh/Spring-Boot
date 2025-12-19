package com.learnRESTAPIs.learnRESTAPIs.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

public class Teacher {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
