package cn.company.project.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/api/*")
public class SecurityFilter  implements Filter {

    protected final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void destroy() {
        //System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ///System.out.println("过滤器主逻辑");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        ///System.out.println("过滤器初始化");
    }
}
