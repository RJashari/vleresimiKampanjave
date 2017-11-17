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
		
		
		
		
//		Dega dega = new Dega
//		
//		String locationForPdf = "C:\\Users\\rinor.jashari\\Documents\\2017_11_08\\rinorTest\\";
//		String dayOfModification = "12.10.2017";
//		String user = "Partin Halimi";
//		
//		GjeneroPdf gjeneroPdf = new GjeneroPdf(locationForPdf, user, dayOfModification);
//		
//		gjeneroPdf.gjeneroPdf(dega);
		
//		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
//		KeyReport keyReport = (KeyReport)context.getBean("keyreport");
//		System.out.println(keyReport);
//		((FileSystemXmlApplicationContext)context).close();
		
		
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