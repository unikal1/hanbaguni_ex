package com.demo.hanbaguni.loginManage.memberManage.entity;

public enum MemberRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    GUEST("ROLE_GUEST"),
    SELLER("ROLE_SELLER");

    private final String roleValue;

    MemberRole(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRole() {
        return roleValue;
    }
}
