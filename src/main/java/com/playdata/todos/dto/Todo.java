package com.playdata.todos.dto;

public class Todo {
    private Integer id;
    private String content;
    private String creatAt;
    private boolean checked;


    public Todo(Integer id, String content, String creatAt, boolean checked) {
        this.id = id;
        this.content = content;
        this.creatAt = creatAt;
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public boolean isChecked() {
        return checked;

    }
}
