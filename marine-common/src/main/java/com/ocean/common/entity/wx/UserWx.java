package com.ocean.common.entity.wx;

import java.sql.Timestamp;

/** 这是微信用户表，有区别于签到记录表*/
public class UserWx {
    
    private Integer id;
    
    private Integer openid;
    
    private String nickname;
    
    private Integer sex;
    
    private String province;
    
    private String city;
    
    private String country;
    
    private String headimgurl;
    
    private String privilege;
    
    private Integer unionid;
    
    private Timestamp createTime;
    
    private Timestamp updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOpenid() {
        return openid;
    }

    public void setOpenid(Integer openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public Integer getUnionid() {
        return unionid;
    }

    public void setUnionid(Integer unionid) {
        this.unionid = unionid;
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
            
}
