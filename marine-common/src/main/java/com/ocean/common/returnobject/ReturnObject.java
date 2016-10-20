package com.ocean.common.returnobject;

import com.alibaba.fastjson.JSON;

public class ReturnObject<T> {
    
    private boolean success = true ;
    
    private int return_code;
    
    private T result;

    public boolean getSuccess(){
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getReturn_code() {
        return return_code;
    }

    public void setReturn_code(int return_code) {
        this.return_code = return_code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString(){
        
        return JSON.toJSONString(this);
    }
    
    
    
    

}
