package co.edureka.boot.beans;

import org.springframework.stereotype.Component;

@Component
public class Engine {

	public Engine() {
		System.out.println("###--- Engine :: Constructor ---###");
	}

	public Integer start() {
		//login to start engine
		return 1;
	}
}
