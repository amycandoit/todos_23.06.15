package com.playdata.todos.dto;

public class TodoJoinUser {
    private Integer id;
    private String content;
    private String creatAt;
    private boolean checked;

    private String name;

    private Integer uid;

    public TodoJoinUser(Integer id, String content, String creatAt, boolean checked,String name, Integer uid) {
        this.id = id;
        this.content = content;
        this.creatAt = creatAt;
        this.checked = checked;
        this.name = name;
        this.uid = uid;
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

    public String getName() {
        return name;
    }

    public Integer getUid() {
        return uid;
    }

    public boolean isChecked() {
        return checked;

    }
}
