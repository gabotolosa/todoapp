package com.springboot.app.mapper;

public interface RequestMapper <Request, Response>{
    Response map(Request request);
}
