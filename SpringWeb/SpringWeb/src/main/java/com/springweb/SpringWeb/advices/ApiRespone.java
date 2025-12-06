package com.springweb.SpringWeb.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiRespone<T>{

    @JsonFormat(pattern = "hh-mm-ss dd-MM-yyy")
    private LocalDateTime timestamps;
    private T data;
    private ApiError error;

    public ApiRespone(){
        this.timestamps = LocalDateTime.now();
    }

    public ApiRespone(T Data){
        this();
        this.data = Data;
    }

    public ApiRespone(ApiError error){
        this();
        this.error = error;
    }
}
