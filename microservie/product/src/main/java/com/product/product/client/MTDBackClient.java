package com.product.product.client;

import com.product.product.VO.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "MTDBack")
public interface MTDBackClient {

    @GetMapping("/mtd/user/tags")
    ResultVO MTDUserTags();
}
