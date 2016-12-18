package com.ocean.stock.entity;

import java.io.Serializable;
import java.util.Date;

public class PricedReg implements Serializable {
    private Long id;

    private Integer integralStart;

    private Integer integralEnd;

    private Float money;

    private Float ratioEarn;

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

    public Integer getIntegralStart() {
        return integralStart;
    }

    public void setIntegralStart(Integer integralStart) {
        this.integralStart = integralStart;
    }

    public Integer getIntegralEnd() {
        return integralEnd;
    }

    public void setIntegralEnd(Integer integralEnd) {
        this.integralEnd = integralEnd;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getRatioEarn() {
        return ratioEarn;
    }

    public void setRatioEarn(Float ratioEarn) {
        this.ratioEarn = ratioEarn;
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
        PricedReg other = (PricedReg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIntegralStart() == null ? other.getIntegralStart() == null : this.getIntegralStart().equals(other.getIntegralStart()))
            && (this.getIntegralEnd() == null ? other.getIntegralEnd() == null : this.getIntegralEnd().equals(other.getIntegralEnd()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getRatioEarn() == null ? other.getRatioEarn() == null : this.getRatioEarn().equals(other.getRatioEarn()))
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
        result = prime * result + ((getIntegralStart() == null) ? 0 : getIntegralStart().hashCode());
        result = prime * result + ((getIntegralEnd() == null) ? 0 : getIntegralEnd().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getRatioEarn() == null) ? 0 : getRatioEarn().hashCode());
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
        sb.append(", integralStart=").append(integralStart);
        sb.append(", integralEnd=").append(integralEnd);
        sb.append(", money=").append(money);
        sb.append(", ratioEarn=").append(ratioEarn);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", invalid=").append(invalid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}