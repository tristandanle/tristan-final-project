package com.gogo.admin.web;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// Use to display photo from server into Web
public class MvcWebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String directoryName = "user-photos";
		Path photo = Paths.get(directoryName);
		
		String photoPath = photo.toFile().getAbsolutePath();
		registry.addResourceHandler("/" + directoryName + "/**")
		.addResourceLocations("file:/" + photoPath + "/");
	}

}
