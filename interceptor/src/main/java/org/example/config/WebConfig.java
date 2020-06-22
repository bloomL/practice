package org.example.config;

import org.example.interceptor.AdminInterceptor;
import org.example.interceptor.LogInterceptor;
import org.example.interceptor.OldLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liguo
 * @Description 配置拦截器
 * @date 2020/6/22/022 16:14
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //apply to all URLs
        registry.addInterceptor(new LogInterceptor());

        // Old Login url, no longer use. Use OldURLInterceptor to redirect to a new URL.
        registry.addInterceptor(new OldLoginInterceptor())
                .addPathPatterns("/admin/oldLogin");

        // This interceptor apply to URL like /admin/*   Exclude /admin/oldLogin
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/*")
                .excludePathPatterns("/admin/oldLogin");
    }
}
