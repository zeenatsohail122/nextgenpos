
package se.kth.ict.iv1350.nextgenpos.view;
import se.kth.ict.iv1350.nextgenpos.controller.Controller;
import se.kth.ict.iv1350.nextgenpos.model.ProductNotFoundException;
import se.kth.ict.iv1350.nextgenpos.model.ProductSpecification;
import se.kth.ict.iv1350.nextgenpos.model.SalesLineItem;
import se.kth.ict.iv1350.nextgenpos.model.SaleObserver;
import org.apache.log4j.Logger;

/**
 * A placeholder for the view.
 */
public class View implements SaleObserver {
    private Controller cont;
    static Logger logger = Logger.getLogger(View.class);
   
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
        enterItem(2);
	enterItem(12);
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
    
    //not used in this file
    @Override
    public void itemAdded(SalesLineItem lineItem) {
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
        } catch (ProductNotFoundException e) {
           this.notifyError(e);
           logger.debug("An exception thrown", e);
        } 
    }
   
}