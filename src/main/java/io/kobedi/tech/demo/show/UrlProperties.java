package io.kobedi.tech.demo.show;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "url")
@Component
public class UrlProperties {
	
	

}
