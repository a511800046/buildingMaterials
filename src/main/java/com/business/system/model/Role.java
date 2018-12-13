package com.business.system.model;

/**
 * 一个用户只有一个权限，在资源中管理权限所能访问的页面
 */
public class Role {

    /**
     * 32位UUID主键
     */
    private String roleId;

    /**
     * 权限名称
     */
    private String roleName;

    /**
     * 权限类型
     */
    private String roleType;

    /**
     * 用户主键id
     */
    private String userId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
