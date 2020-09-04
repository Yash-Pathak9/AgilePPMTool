package com.AgileIntelligence.App.Exceptions;

public class ProjectIdExceptionResponse {
   private String ProjectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        ProjectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return ProjectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        ProjectIdentifier = projectIdentifier;
    }
}
