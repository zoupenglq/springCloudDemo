package com.itcast.feignClient;

import com.itcast.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//调用微服务名称
@FeignClient("service-product")
public interface ProductFeginClient {

    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") long id);
}
