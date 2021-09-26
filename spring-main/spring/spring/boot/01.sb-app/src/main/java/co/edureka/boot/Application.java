package co.edureka.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.edureka", "co.edureka"})
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		System.out.println("No of Spring Beans with Container = " + context.getBeanDefinitionCount());
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(int i=0; i<beanNames.length; i++) {
			System.out.println((i+1)+") " + beanNames[i]);
		}
		System.out.println();
		
		context.close();
	}

}
