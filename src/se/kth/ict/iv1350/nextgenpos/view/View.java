/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.nextgenpos.view;
import se.kth.ict.iv1350.nextgenpos.controller.Controller;
import se.kth.ict.iv1350.nextgenpos.model.ProductNotFoundException;
import se.kth.ict.iv1350.nextgenpos.model.ProductSpecification;

/**
 * A placeholder for the view.
 */
public class View {
    private Controller cont;

    /**
     * Creates a new <code>View</code>.
     * @param cont           The controller of the application.
     */
    public View(Controller cont) {
	this.cont = cont;
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() {
	cont.makeNewSale();
	enterItem(1);
	enterItem(3);
        enterItem(8);
    }
    
    private void NotifyError(Exception err) {
        System.out.println("---TRY AGAIN---");
        System.out.println(err.getMessage());
    }

    private void enterItem(int itemId) {
	int quantity = 1;
        try {
            ProductSpecification SpecifiedItem = cont.enterItem(itemId, quantity);
        } catch (ProductNotFoundException productException) {
            this.NotifyError(productException);
        }   
}
}

