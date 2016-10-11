package com.ocean.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="menurole") 
public class MenuRole {
    
    @Id// 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")   @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "menuRoleId")
    private Integer menuRoleId;
    private Integer roleId;
    private Integer menuId;
    private Date createTime;
    public Integer getMenuRoleId() {
        return menuRoleId;
    }
    public void setMenuRoleId(Integer menuRoleId) {
        this.menuRoleId = menuRoleId;
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
