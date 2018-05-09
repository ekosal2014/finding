package kh.com.finding.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class FindingConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		/*registry.addViewController("/").setViewName("index");
		registry.addViewController("/kh").setViewName("index");
		registry.addViewController("/en").setViewName("index");*/
	}

	@Bean
	public InternalResourceViewResolver viewResolver (){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("classpath:/templates/views/");
		resolver.setSuffix(".html");
		return resolver;
	}
	
	@Bean(name = "messageSource")
	public MessageSource getMessageResource(){
		
		ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
		
		messageResource.setBasename("classpath:i18n/messages");
		messageResource.setDefaultEncoding("UTF-8");
		return messageResource;
		
	}
	
	@Bean(name = "localeResolver")
	public LocaleResolver getLocaleResolver(){
		LocaleResolver resolver = new UrlLocaleResolver();
		return resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
		
		registry.addInterceptor(localeInterceptor).addPathPatterns("/en/","/kh/");
		
	}
	
	@Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //multipartResolver.setMaxUploadSize(2097152);
        multipartResolver.setMaxUploadSize(5242880);
        return multipartResolver;
    }
	
}
