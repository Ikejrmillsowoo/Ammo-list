package codewithike.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://127.0.0.1:3000","http://192.168.6.100:3000","http://192.168.6.103:3000", "http://localhost:3001", "http://192.168.4.144:3001") // adjust to your frontend port
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*");

        }
}
