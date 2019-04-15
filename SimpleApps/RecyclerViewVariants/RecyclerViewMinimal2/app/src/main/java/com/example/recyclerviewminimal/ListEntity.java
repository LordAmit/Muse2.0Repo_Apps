package com.example.recyclerviewminimal;

public class ListEntity {
    private String title, id;

    public ListEntity(){}
    public ListEntity(String title, String id){
        this.title = title;
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

