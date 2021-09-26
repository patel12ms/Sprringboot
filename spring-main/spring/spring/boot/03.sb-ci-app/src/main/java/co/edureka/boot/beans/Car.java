package co.edureka.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
@Component(value = "mycar")
public class Car {
	private Engine engine;
	
	public Car() {
		System.out.println("###--- Car :: 0 - Argument Constructor ---###");
	}
	
	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
		System.out.println("###--- Car :: 1 - Argument Constructor ---###");
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
