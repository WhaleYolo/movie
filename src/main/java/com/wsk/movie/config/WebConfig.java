package com.wsk.movie.config;

import com.wsk.movie.tool.Os;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @DESCRIPTION :静态文件访问路径
 * @AUTHOR : WuShukai1103
 * @TIME : 2018/1/1  13:28
 */
@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/image/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/image/");
        registry.addResourceHandler("/js/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/css/");
        //先判断系统
        if (Os.isLinux()){
            registry.addResourceHandler("/images/**").addResourceLocations("file:/home/" + System.getProperty("user.name") + "/image/");
            registry.addResourceHandler("/music/**").addResourceLocations("file:/home/" + System.getProperty("user.name") + "/down/");
        } else {
            //本地测试
            registry.addResourceHandler("/images/**").addResourceLocations("file:/D:/image/");
            registry.addResourceHandler("/music/**").addResourceLocations("file:/G:/down/");
        }
        //服务器
//        registry.addResourceHandler("/images/**").addResourceLocations("file:/C:/myproject/image/");
        // registry.addResourceHandler("/music/**").addResourceLocations("file:/C:/down/");
        super.addResourceHandlers(registry);
    }

}
