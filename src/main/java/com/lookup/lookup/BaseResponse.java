package com.lookup.lookup;


public abstract class BaseResponse<T extends BaseResponse> {
    private Long id;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public T copy(T t) {
        return t;
    }
}
