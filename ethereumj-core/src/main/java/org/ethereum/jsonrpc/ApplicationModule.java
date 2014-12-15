package org.ethereum.jsonrpc;

import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

@Configuration
public class ApplicationModule {
    // Declare "application" scope beans here (ie., beans that are not only used by the web context)

    @Bean(name = "/EthereumService.json")
    public JsonServiceExporter getJsonServiceExporter(@Qualifier("main") EthereumService service) {
        JsonServiceExporter jsonServiceExporter = new JsonServiceExporter();
        jsonServiceExporter.setService(service);
        jsonServiceExporter.setServiceInterface(EthereumService.class);
        return jsonServiceExporter;
    }

    @Bean
    @Qualifier("main")
    public EthereumService ethereumService() {
        return new EthereumServiceImpl();
    }

    @Bean
    public BeanNameUrlHandlerMapping getBeanNameUrlHandlerMapping() {
        return new BeanNameUrlHandlerMapping();
    }
}
