package com.siddhant.portfolio.dto;

public class ProjectResponse {

    private long id;
    private String title;
    private String description;
    private String technologies;
    private String githubUrl;
    private String liveUrl;

    public ProjectResponse(long id, String title, String description, String technologies, String githubUrl, String liveUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.githubUrl = githubUrl;
        this.liveUrl = liveUrl;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnologies() {
        return technologies;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public String getLiveUrl() {
        return liveUrl;
    }
}