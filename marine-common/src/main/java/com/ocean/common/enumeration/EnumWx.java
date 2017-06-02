package com.luvsea.common.enumeration;

public enum EnumWx {
    
    appId("wxc84cf9b020395899"),
    secret("cf416f50f1e702ae95bb577359391b2c "),
    token("juner");
    
    private String values;
    
    private EnumWx(String values) {
        this.values = values;
    }
    
    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
    

}
