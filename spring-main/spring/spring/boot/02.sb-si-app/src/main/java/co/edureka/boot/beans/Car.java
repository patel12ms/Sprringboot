package co.edureka.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Engine engine;
	
	public Car() {
		System.out.println("###--- Car :: Constructor ---###");
	}
	
	@Autowired
	public void setEngine(Engine engine) {
		System.out.println("---- inside setEngine method ----");
		this.engine = engine;
	}
	
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
