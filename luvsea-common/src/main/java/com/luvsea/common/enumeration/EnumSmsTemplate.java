package com.luvsea.common.enumeration;

public enum EnumSmsTemplate {

    valiCode("您的登陆验证码为x请在10分钟内使用!");
    
    private String value;
    
    private EnumSmsTemplate(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    

}
