package com.ocean.frame.main.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonResult<T> {
    
    private static SerializerFeature[] features = {SerializerFeature.WriteNullNumberAsZero, 
        SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect};  
    
    private T result;
    
    private int ret;
    
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
//        result = prime * result + ret;
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        JsonResult other = (JsonResult) obj;
//        if (result == null) {
//            if (other.result != null)
//                return false;
//        } else if (!result.equals(other.result))
//            return false;
//        if (ret != other.ret)
//            return false;
//        return true;
//    }

    public JsonResult(){
        this.ret = 0;
    }

   public JsonResult(T result){
       
       this.result = result;
   }

    @Override
    public String toString() {

        return JSONObject.toJSONString(this, features).toString();
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    
    
}
