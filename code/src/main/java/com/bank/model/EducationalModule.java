package com.bank.model;

public class EducationalModule {
    private String title;
    private String content;
    private int ageGroup;

    public EducationalModule(String title, String content, int ageGroup) {
        this.title = title;
        this.content = content;
        this.ageGroup = ageGroup;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getAgeGroup() {
        return ageGroup;
    }
}
