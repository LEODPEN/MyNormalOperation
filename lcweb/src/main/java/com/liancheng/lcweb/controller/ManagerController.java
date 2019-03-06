package com.liancheng.lcweb.controller;


import com.liancheng.lcweb.repository.ManagerRepository;
import com.liancheng.lcweb.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerService managerService;

    //查司机by name

}
