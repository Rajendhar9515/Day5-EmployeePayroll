package com.example.employeepayroll.dto;

public class ResponseDTO {

    String message;
    Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseDTO(String message, Object data){
        this.message = message;
        this.data =data;

    }
    public  ResponseDTO(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
