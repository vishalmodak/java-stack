package com.hotel.pricing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;

@Configuration
@EnableSpringBootMetricsCollector
class PrometheusAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "prometheusMetricsServletRegistrationBean")
    ServletRegistrationBean prometheusMetricsServletRegistrationBean(@Value("${prometheus.metrics.path:/prometheus}") String metricsPath) {
        DefaultExports.initialize();
        return new ServletRegistrationBean(new MetricsServlet(), metricsPath);
    }
    
}
