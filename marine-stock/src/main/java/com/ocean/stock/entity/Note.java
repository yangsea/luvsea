package com.ocean.stock.entity;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private Long id;

    private String openid;

    private String title;

    private String stockCode;

    private String investType;

    private Date investTerm;

    private Float incomeRateArg;

    private String remark;

    private Float priced;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType == null ? null : investType.trim();
    }

    public Date getInvestTerm() {
        return investTerm;
    }

    public void setInvestTerm(Date investTerm) {
        this.investTerm = investTerm;
    }

    public Float getIncomeRateArg() {
        return incomeRateArg;
    }

    public void setIncomeRateArg(Float incomeRateArg) {
        this.incomeRateArg = incomeRateArg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Float getPriced() {
        return priced;
    }

    public void setPriced(Float priced) {
        this.priced = priced;
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
        Note other = (Note) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getStockCode() == null ? other.getStockCode() == null : this.getStockCode().equals(other.getStockCode()))
            && (this.getInvestType() == null ? other.getInvestType() == null : this.getInvestType().equals(other.getInvestType()))
            && (this.getInvestTerm() == null ? other.getInvestTerm() == null : this.getInvestTerm().equals(other.getInvestTerm()))
            && (this.getIncomeRateArg() == null ? other.getIncomeRateArg() == null : this.getIncomeRateArg().equals(other.getIncomeRateArg()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPriced() == null ? other.getPriced() == null : this.getPriced().equals(other.getPriced()))
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
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getStockCode() == null) ? 0 : getStockCode().hashCode());
        result = prime * result + ((getInvestType() == null) ? 0 : getInvestType().hashCode());
        result = prime * result + ((getInvestTerm() == null) ? 0 : getInvestTerm().hashCode());
        result = prime * result + ((getIncomeRateArg() == null) ? 0 : getIncomeRateArg().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPriced() == null) ? 0 : getPriced().hashCode());
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
        sb.append(", openid=").append(openid);
        sb.append(", title=").append(title);
        sb.append(", stockCode=").append(stockCode);
        sb.append(", investType=").append(investType);
        sb.append(", investTerm=").append(investTerm);
        sb.append(", incomeRateArg=").append(incomeRateArg);
        sb.append(", remark=").append(remark);
        sb.append(", priced=").append(priced);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", invalid=").append(invalid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}