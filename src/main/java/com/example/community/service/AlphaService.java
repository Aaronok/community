package com.example.community.service;

import com.example.community.controller.AlphaController;
import com.example.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLOutput;

@Service
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;



    public AlphaService(){
        System.out.println("无参构造创建实例化AlphaService");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁AlphaService");
    }

    public String find(){
        return alphaDao.select();
    }
}
