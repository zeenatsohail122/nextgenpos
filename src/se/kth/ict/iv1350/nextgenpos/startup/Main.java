
package se.kth.ict.iv1350.nextgenpos.startup;


import se.kth.ict.iv1350.nextgenpos.controller.Controller;
import se.kth.ict.iv1350.nextgenpos.view.View;

/**
 * Starts the application.
 */
public class Main {
    public static void main(String[] args) {
	Controller cont = new Controller();
	View view = new View(cont);
	view.test();
    }
}
