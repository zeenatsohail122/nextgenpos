
package se.kth.ict.iv1350.nextgenpos.startup;
import se.kth.ict.iv1350.nextgenpos.controller.Controller;
import se.kth.ict.iv1350.nextgenpos.view.View;
import org.apache.log4j.PropertyConfigurator;

/**
 * Starts the application.
 */
public class Main {  
    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
	Controller cont = new Controller();
	View view = new View(cont);
	view.test();
   }
}
