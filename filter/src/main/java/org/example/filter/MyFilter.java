package org.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liguo
 * @date 2020/6/22/022 13:42
 */
@Component
public class MyFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("初始化过滤器："+filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //对请求进行预处理
        LOGGER.info("过滤器开始对请求进行预处理：");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String requestUri = request.getRequestURI();
        System.out.println("请求的接口为："+requestUri);
        long startTime = System.currentTimeMillis();
        //通过doFilter实现过滤
        filterChain.doFilter(servletRequest,servletResponse);
        //上面doFilter执行结束后用户的请求已经返回
        long endTime = System.currentTimeMillis();
        System.out.println("该用户的请求已经处理完毕，请求花费的时间为：" + (endTime - startTime));
    }

    @Override
    public void destroy() {
        LOGGER.info("销毁过滤器");
    }
}
