package com.howtodoinjava.example.springconfigclient;

public class ProdMessageServiceImpl implements MessageService{

    @Override
    public String getMessage() {
        return "prod one";
    }
}
