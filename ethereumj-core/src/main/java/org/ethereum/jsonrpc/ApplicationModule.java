package org.ethereum.jsonrpc;

import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

@Configuration
public class ApplicationModule {
    // Declare "application" scope beans here (ie., beans that are not only used by the web context)

    @Bean
    public EthServiceImpl ethService() {
        return new EthServiceImpl();
    }

    @Bean
    public BeanNameUrlHandlerMapping getBeanNameUrlHandlerMapping() {

        return new BeanNameUrlHandlerMapping();
    }

    @Bean(name="/EthService.json")
    public JsonServiceExporter getJsonServiceExporter(EthService service) {
        JsonServiceExporter jsonServiceExporter = new JsonServiceExporter();
        jsonServiceExporter.setService(service);
        jsonServiceExporter.setServiceInterface(EthService.class);
        return jsonServiceExporter;
    }
}
