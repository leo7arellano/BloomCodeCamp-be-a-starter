package com.hcc.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static Long id;
    @Column(name = "status")
    private String status;
    @Column(name = "number")
    private Integer number;
    @Column(name = "githubUrl")
    private String githubUrl;
    @Column(name = "branch")
    private String branch;
    @Column(name = "reviewVideoUrl")
    private String reviewVideoUrl;
    @Column(name = "user")
    private User user;
    @Column(name = "codeReviewer")
    private User codeReviewer;

    public Assignment(String status, Integer number, String githubUrl, String branch, String reviewVideoUrl, User user, User codeReviewer) {
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
        this.codeReviewer = codeReviewer;
    }

    public Assignment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCodeReviewer() {
        return codeReviewer;
    }

    public void setCodeReviewer(User codeReviewer) {
        this.codeReviewer = codeReviewer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getGithubUrl(), that.getGithubUrl()) && Objects.equals(getBranch(), that.getBranch()) && Objects.equals(getReviewVideoUrl(), that.getReviewVideoUrl()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getCodeReviewer(), that.getCodeReviewer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getNumber(), getGithubUrl(), getBranch(), getReviewVideoUrl(), getUser(), getCodeReviewer());
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", number=" + number +
                ", githubUrl='" + githubUrl + '\'' +
                ", branch='" + branch + '\'' +
                ", reviewVideoUrl='" + reviewVideoUrl + '\'' +
                ", user=" + user +
                ", codeReviewer=" + codeReviewer +
                '}';
    }
}
