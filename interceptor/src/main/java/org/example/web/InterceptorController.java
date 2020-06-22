package org.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liguo
 * @Description   @Deprecated 接口过时必须加,并清晰地说明采用的新接口或新服务是什么
 *               表示此方法或类不再建议使用，调用时也会出现删除线，但并不代表不能用，只是说，不推荐使用，因为还有更好的方法可以调用
 * @date 2020/6/22/022 16:21
 */
@Controller
public class InterceptorController {

    @RequestMapping(value = {"/","/test"})
    public String test(Model model){
        System.out.println("\n-------- MainController.test --- ");
        System.out.println(" ** You are in Controller ** ");
        return "test";
    }

    @Deprecated
    @RequestMapping(value = { "/admin/oldLogin" })
    public String oldLogin(Model model){

        return "oldLogin";
    }

    @RequestMapping(value = { "/admin/login" })
    public String login(Model model){
        System.out.println("\n-------- MainController.login --- ");
        System.out.println(" ** You are in Controller ** ");
        return "login";
    }
}
