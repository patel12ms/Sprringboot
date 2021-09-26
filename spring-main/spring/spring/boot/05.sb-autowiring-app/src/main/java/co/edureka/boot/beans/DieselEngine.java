package co.edureka.boot.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
@Component("de")
public class DieselEngine implements Engine {

	@Override
	public Integer start() {
		System.out.println("$$$--- DieselEngine :: start() method called ---$$$");
		return 1;
	}

}
