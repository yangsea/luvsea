package com.luvsea.stock.entity;

import java.sql.Timestamp;

public abstract class AbstractEntity {

    private Integer id;
    private Short status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Boolean invlaid;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Short getStatus() {
        return status;
    }
    public void setStatus(Short status) {
        this.status = status;
    }
    
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    public Timestamp getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    public Boolean getInvlaid() {
        return invlaid;
    }
    public void setInvlaid(Boolean invlaid) {
        this.invlaid = invlaid;
    }

    
}
