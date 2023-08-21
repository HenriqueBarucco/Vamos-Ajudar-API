package com.got.vamosajudar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedOriginPatterns(List.of("*"));
        config.setAllowedMethods(Arrays.asList("GET","POST", "DELETE", "PUT"));

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
