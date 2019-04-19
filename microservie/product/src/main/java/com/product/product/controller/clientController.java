package com.product.product.controller;


import com.product.product.VO.ResultVO;
import com.product.product.client.MTDBackClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class clientController {

    //第二种方式：
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    //第三种方式
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MTDBackClient mtdBackClient;

    @GetMapping("/getfiles")
    public String getMsg(){
        //1.第一种方式
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8090/mtd/user/files",String.class);
//        log.info("response = {}",response);

        //2.第二种方式,考虑多实例下负载均衡与选择问题，利用loadbalancerclient通过应用名获取url
//        RestTemplate restTemplate = new RestTemplate();
//        //先拿地址
//        ServiceInstance serviceInstance = loadBalancerClient.choose("MTDBack");
//
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/mtd/user/files");
//
//        String response = restTemplate.getForObject(url,String.class);

        //3.第三种方式，利用@LoadBalanced，可在restTemplate里面使用应用名
        String response = restTemplate.getForObject("http://MTDBack/mtd/user/files",String.class);
        return response;
    }

    @GetMapping("/getTags")
    public Integer getTags(){
        ResultVO resultVO = (ResultVO) mtdBackClient.MTDUserTags();
        return resultVO.getCode();

    }
}
