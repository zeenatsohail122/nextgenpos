/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.nextgenpos.view;
import java.util.List;
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
        enterItem(3);
	enterItem(10);
    }

    @Override
    public void itemAdded(SalesLineItem lineItem) {
    }
    
    @Override
    public void saleListUpdated(SalesLineItem[] allItems) {
        this.printList(allItems);
    }
    
    private void printList(SalesLineItem[] lineItems) {
        System.out.println("## Sale updated! Current items in Sale are:\n");
        for (SalesLineItem lineItem : lineItems) {
            System.out.println("* " + lineItem + "\n");
        }
    }
    
    private void notifyError(Exception err) {
        System.out.println("Oops, try again! " + err.getMessage());
    }

    private void enterItem(int itemId) {
	int quantity = 1;
        try {
            ProductSpecification itemSpec = cont.enterItem(itemId, quantity);
        } catch (ProductNotFoundException productException) {
            this.notifyError(productException);
        }   
    }
}