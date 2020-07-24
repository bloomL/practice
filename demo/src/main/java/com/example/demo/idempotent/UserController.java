package com.example.demo.idempotent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liguo
 * @Description
 * @date 2020/7/24/024 16:54
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public String addUser(String id){
        //非空
        //幂等性判断
        if (!IdempotentUtils.judge(id,this)){
            return "执行失败";
        }
        //执行业务代码
        System.out.println("添加用户ID:" + id);
        return "执行成功！";
    }
}
