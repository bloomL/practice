package org.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liguo
 * @Description 注解实现filter注册
 * @date 2020/6/22/022 14:27
 */
@WebFilter(filterName = "MyFilterWithAnnotation",urlPatterns = "/api/annotation/*")
public class MyFilterWithAnnotation implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilterWithAnnotation.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("初始化过滤器：" + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //对请求进行预处理
        LOGGER.info("过滤器对请求进行预处理");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();
        System.out.println("请求的接口为：" + requestUri);
        long startTime = System.currentTimeMillis();
        //通过 doFilter实现过滤功能
        filterChain.doFilter(servletRequest, servletResponse);
        // 上面的 doFilter执行结束后用户的请求已经返回
        long endTime = System.currentTimeMillis();
        System.out.println("该用户的请求已经处理完毕，请求花费的时间为：" + (endTime - startTime));
    }

    @Override
    public void destroy() {
        LOGGER.info("销毁过滤器");
    }
}
