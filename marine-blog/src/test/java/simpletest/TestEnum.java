package simpletest;

import org.junit.Test;

//枚举， 1、用做常量，增强可读性，2、规定集合内容，保证安全
public enum TestEnum {

    a(1,"bac"),
    b(2,"def");
    
    private int keys;
    private String values;
    public EntityTestEnum entityTestEnum;
    
    
    public EntityTestEnum getEntityTestEnum() {
        return entityTestEnum;
    }

    TestEnum(int keys, String values){
        
        this.entityTestEnum = new EntityTestEnum();
        this.entityTestEnum.setId(keys);
        this.keys = keys;
        this.values = values;
        
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
        
}
