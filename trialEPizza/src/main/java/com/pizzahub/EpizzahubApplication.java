package com.pizzahub;

import java.util.Properties;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class EpizzahubApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpizzahubApplication.class, args);
	}
	
		//add a method to configure ModelMapper as a spring bean
		@Bean // equivalent to <bean id ..../> in xml file
		public ModelMapper configureMapper() {
			System.out.println("in config mapper....");
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			return modelMapper;//method rets bean instance to SC
		}
		
		
		  @Bean
		    public JavaMailSender javaMailSender() {
		        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		        mailSender.setHost("smtp.gmail.com");
		        mailSender.setPort(587); // or the port used by your email server
		        mailSender.setUsername("dahaputep@gmail.com");
		        mailSender.setPassword("hegeahmfgjphsyeg");
		        
		        Properties props = mailSender.getJavaMailProperties();
		        props.put("mail.transport.protocol", "smtp");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.debug", "true");
		        
		        return mailSender;
		    }

}
