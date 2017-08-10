package com.online.player;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by ikota on 9.6.17.
 */

@EnableWebMvc
@SpringBootApplication
@EnableTransactionManagement
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {

        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();

        TomcatContextCustomizer contextCustomizer = context -> context.addWelcomeFile("/index.html");
        factory.addContextCustomizers(contextCustomizer);

        return factory;
    }
}
