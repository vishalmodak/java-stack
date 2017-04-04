package com.hotel.aggregator.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;
import io.prometheus.client.spring.boot.SpringBootMetricsCollector;

@Configuration
class PrometheusAutoConfiguration {

    @Bean
    SpringBootMetricsCollector springBootMetricsCollector(Collection<PublicMetrics> publicMetrics) {

        SpringBootMetricsCollector springBootMetricsCollector = new SpringBootMetricsCollector(publicMetrics);
        springBootMetricsCollector.register();

        return springBootMetricsCollector;
    }

    @Bean
    ServletRegistrationBean prometheusMetricsServletRegistrationBean(@Value("${prometheus.metrics.path:/prometheus}") String metricsPath) {
        DefaultExports.initialize();
        return new ServletRegistrationBean(new MetricsServlet(), metricsPath);
    }
    
}
