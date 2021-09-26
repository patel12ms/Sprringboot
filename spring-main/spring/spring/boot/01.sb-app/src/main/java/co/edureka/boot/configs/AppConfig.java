package co.edureka.boot.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edureka.boot.beans.utils.PasswordEncryptor;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("###--- AppConfig :: Constructor ---###");
	}
	
	@Bean
	public PasswordEncryptor getInstance() {
		return new PasswordEncryptor();
	}
}
