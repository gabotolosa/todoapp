package com.springboot.app.mapper;

public interface RequestMapper <Request, Response>{
    public Response map(Request request);
}
