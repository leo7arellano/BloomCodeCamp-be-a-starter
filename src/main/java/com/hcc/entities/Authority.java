package com.hcc.entities;

import java.util.Objects;

public class Authority {

    private static Long id = 0L;
    private String authority;
    private String user;


    public Authority() {
        id += 1;
    }

    public Authority(String authority, String user) {
        id += 1;
        this.authority = authority;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authority)) return false;
        Authority authority1 = (Authority) o;
        return Objects.equals(getId(), authority1.getId()) && Objects.equals(getAuthority(), authority1.getAuthority()) && Objects.equals(getUser(), authority1.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthority(), getUser());
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
