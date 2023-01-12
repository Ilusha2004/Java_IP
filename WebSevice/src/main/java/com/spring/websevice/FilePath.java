package com.spring.websevice;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class FilePath {

    private final String id;
    private String name;

    public FilePath(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public FilePath(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
