package com.siddhant.portfolio.dto;

public class PortfolioResponse {
    private String name;
    private String title;
    private String about;
    private String email;

    public PortfolioResponse(String name, String title, String about, String email) {
        this.name = name;
        this.title = title;
        this.about = about;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getAbout() {
        return about;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }
}
