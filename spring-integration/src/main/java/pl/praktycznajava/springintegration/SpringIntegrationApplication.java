package pl.praktycznajava.springintegration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringIntegrationApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context
				= new AnnotationConfigApplicationContext(BasicIntegrationConfig.class);
		context.registerShutdownHook();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Naciśnij q a następnie <enter> aby zamknąć program: ");

		while (true) {
			String input = scanner.nextLine();
			if("q".equals(input.trim())) {
				break;
			}
		}
		System.exit(0);
	}

}
