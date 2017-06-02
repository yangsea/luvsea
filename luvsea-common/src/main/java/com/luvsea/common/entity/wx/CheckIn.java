package com.luvsea.common.entity.wx;

import java.sql.Timestamp;

public class CheckIn {
    
    private Integer id;
    
    private String openId;
    
    private String tMap;
    
    private String bMap;
    
    private String dMap;
    
    private String gMap;
    
    private String latitude;
    
    private String longitude;
    
    //签到时间
    private Timestamp checkInTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String gettMap() {
        return tMap;
    }

    public void settMap(String tMap) {
        this.tMap = tMap;
    }

    public String getbMap() {
        return bMap;
    }

    public void setbMap(String bMap) {
        this.bMap = bMap;
    }

    public String getdMap() {
        return dMap;
    }

    public void setdMap(String dMap) {
        this.dMap = dMap;
    }

    public Timestamp getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Timestamp checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getgMap() {
        return gMap;
    }

    public void setgMap(String gMap) {
        this.gMap = gMap;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
           
}
