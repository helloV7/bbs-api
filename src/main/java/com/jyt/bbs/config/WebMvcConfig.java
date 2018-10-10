package com.jyt.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //Swagger ui Mapping
        registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");

        registry.addResourceHandler("/druid/**")
                .addResourceLocations("classpath:/META-INF/resources/");


        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        //config.addAllowedMethod("OPTIONS");
        //config.addAllowedMethod("HEAD");
        //config.addAllowedMethod("GET");
        //config.addAllowedMethod("PUT");
        //config.addAllowedMethod("POST");
        //config.addAllowedMethod("DELETE");
        //config.addAllowedMethod("PATCH");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("*//**", config);
        return new CorsFilter(source);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new CommonInterceptor());
        super.addInterceptors(registry);
    }





    public class CommonInterceptor implements HandlerInterceptor {

        private List<String> excludedUrls;

        public List<String> getExcludedUrls() {
            return excludedUrls;
        }

        public void setExcludedUrls(List<String> excludedUrls) {
            this.excludedUrls = excludedUrls;
        }

        /**
         *
         * 在业务处理器处理请求之前被调用 如果返回false
         * 从当前的拦截器往回执行所有拦截器的afterCompletion(),
         * 再退出拦截器链, 如果返回true 执行下一个拦截器,
         * 直到所有的拦截器都执行完毕 再执行被拦截的Controller
         * 然后进入拦截器链,
         * 从最后一个拦截器往回执行所有的postHandle()
         * 接着再从最后一个拦截器往回执行所有的afterCompletion()
         *
         * @param  request
         *
         * @param  response
         */
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                 Object handler) throws Exception {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers",
                    "Origin, X-Requested-With, Content-Type, Accept,token");
            return true;
        }

        // 在业务处理器处理请求执行完成后,生成视图之前执行的动作
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                               ModelAndView modelAndView) throws Exception {

        }

        /**
         *
         * 在DispatcherServlet完全处理完请求后被调用
         * 当有拦截器抛出异常时,
         * 会从当前拦截器往回执行所有的拦截器的afterCompletion()
         *
         * @param request
         *
         * @param response
         *
         * @param handler
         *
         */
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                    Object handler, Exception ex) throws Exception {

        }
    }


}
