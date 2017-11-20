package Main;


import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VleresimiKampanjaveMainApp {
	public static void main(String[] args) throws FileNotFoundException, MalformedURLException, ParseException {
		SpringApplication.run(VleresimiKampanjaveMainApp.class, args);
		
		

		
}

	@Autowired
	private ApplicationContext applicationContext;

	public VleresimiKampanjaveMainApp(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		for(String s: this.applicationContext.getBeanDefinitionNames()) {
			System.out.println("bean definition name: " + s);
		}
	}
	
	

}