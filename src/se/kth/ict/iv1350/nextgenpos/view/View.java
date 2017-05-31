/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.nextgenpos.view;
import se.kth.ict.iv1350.nextgenpos.controller.Controller;
import se.kth.ict.iv1350.nextgenpos.model.ProductNotFoundException;
import se.kth.ict.iv1350.nextgenpos.model.ProductSpecification;
import se.kth.ict.iv1350.nextgenpos.model.SalesLineItem;
import se.kth.ict.iv1350.nextgenpos.model.SaleObserver;


/**
 * A placeholder for the view.
 */
public class View implements SaleObserver {
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
        cont.addSaleObserver(this);
        enterItem(1);
        enterItem(2);
	enterItem(12);
    }

    @Override
    public void itemAdded(SalesLineItem lineItem) {
    }
    
    /**
     * Prints the list of items
     * @param lineItems     represents the sale line items
     */
    private void printList(SalesLineItem[] lineItems) {
        System.out.println("Sale is updated!All items in the  current sale are:\n");
        for (SalesLineItem lineItem : lineItems) {
            System.out.println(lineItem + "\n");
        }
    }
    
    @Override
    public void saleListUpdated(SalesLineItem[] allItems) {
        this.printList(allItems);
    }
    
    /**
     * Displays the error
     * @param error       used to represent the error
     */
    private void notifyError(Exception error) {
        System.out.println("!!!Try again!!! " + error.getMessage());
    }

    private void enterItem(int itemId) {
	int quantity = 1;
        try {
            ProductSpecification itemSpecification = cont.enterItem(itemId, quantity);
        } catch (ProductNotFoundException productException) {
            this.notifyError(productException);
        } 
    }
}