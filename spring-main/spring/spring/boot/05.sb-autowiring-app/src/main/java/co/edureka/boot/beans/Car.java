package co.edureka.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	//@Qualifier("petrolEngine")
	//@Qualifier("dieselEngine")
	@Qualifier("de")
	private Engine engine;
	
	public void drive() {
		System.out.println("---- inside Car's drive() method ----");
		Integer status = engine.start();
		if(status == 1) {
			System.out.println("@@@@--- Journey Started ---@@@@");
		}else {
			System.out.println("$$$--- Engine Trouble... Service Required ---$$$");
		}
	}
}
