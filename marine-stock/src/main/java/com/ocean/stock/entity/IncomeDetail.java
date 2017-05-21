package com.luvsea.stock.entity;

import java.io.Serializable;
import java.util.Date;

public class IncomeDetail implements Serializable {
    private Long id;

    private Float money;

    private Long noteNumber;

    private Long payUser;

    private Long paidUser;

    private Short payType;

    private Date createTime;

    private Date updateTime;

    private Short status;

    private Boolean invalid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Long getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(Long noteNumber) {
        this.noteNumber = noteNumber;
    }

    public Long getPayUser() {
        return payUser;
    }

    public void setPayUser(Long payUser) {
        this.payUser = payUser;
    }

    public Long getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(Long paidUser) {
        this.paidUser = paidUser;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        IncomeDetail other = (IncomeDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getNoteNumber() == null ? other.getNoteNumber() == null : this.getNoteNumber().equals(other.getNoteNumber()))
            && (this.getPayUser() == null ? other.getPayUser() == null : this.getPayUser().equals(other.getPayUser()))
            && (this.getPaidUser() == null ? other.getPaidUser() == null : this.getPaidUser().equals(other.getPaidUser()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getInvalid() == null ? other.getInvalid() == null : this.getInvalid().equals(other.getInvalid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getNoteNumber() == null) ? 0 : getNoteNumber().hashCode());
        result = prime * result + ((getPayUser() == null) ? 0 : getPayUser().hashCode());
        result = prime * result + ((getPaidUser() == null) ? 0 : getPaidUser().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getInvalid() == null) ? 0 : getInvalid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", money=").append(money);
        sb.append(", noteNumber=").append(noteNumber);
        sb.append(", payUser=").append(payUser);
        sb.append(", paidUser=").append(paidUser);
        sb.append(", payType=").append(payType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", invalid=").append(invalid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}