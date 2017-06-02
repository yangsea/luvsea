package com.luvsea.common.json;

public class PageResult<T> {
    
    private T rows;
    
    private long total;

    
    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
    
}
