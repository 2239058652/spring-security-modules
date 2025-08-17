package com.dc.entity;

public class TRole {

    private Integer id;
    private String role;
    private String roleName;

    public TRole() {
    }

    public TRole(Integer id, String role, String roleName) {
        this.id = id;
        this.role = role;
        this.roleName = roleName;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String toString() {
        return "TRole{id = " + id + ", role = " + role + ", roleName = " + roleName + "}";
    }
}
