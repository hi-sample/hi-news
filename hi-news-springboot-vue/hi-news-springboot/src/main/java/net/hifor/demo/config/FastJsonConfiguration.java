package net.hifor.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IKin <br/>
 * @description fastjson配置类  <br/>
 * @create 2019/6/20 <br/>
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                // 防止循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );
        //统一使用默认的时间格式:unix时间戳
        ///fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);

        ///SpringBoot 2.0.1版本中加载WebMvcConfigurer的顺序发生了变动，故需使用converters.add(0, converter);
        ///指定FastJsonHttpMessageConverter在converters内的顺序，否则在SpringBoot 2.0.1及之后的版本中将优先使用Jackson处理
        converters.add(0, fastJsonHttpMessageConverter);
    }
}
