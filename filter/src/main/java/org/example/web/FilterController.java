package org.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liguo
 * @Description
 * @date 2020/6/22/022 14:35
 */
@RestController
@RequestMapping("/api")
public class FilterController {

    @GetMapping("/hello")
    public String getHello() throws InterruptedException{
        Thread.sleep(1000);
        return "Hello";
    }
}
