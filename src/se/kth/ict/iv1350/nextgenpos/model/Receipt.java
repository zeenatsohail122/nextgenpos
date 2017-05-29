/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.nextgenpos.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Holds all information needed by the receipt. 
 */
public class Receipt {
    private int payedAmount;
    private int totalCost;
    private List<SalesLineItem> receiptLines = new ArrayList<SalesLineItem>();
    
    /**
     * Creates a new receipt and saves all information it needs.
     *
     * @param sale      The <code>Sale</code> for which the receipt shall be created.
     */
    Receipt(Sale sale) {
	totalCost = sale.getCurrentTotal();
	payedAmount = sale.getPayedAmount();
	createReceiptLines(sale);
    }

    private void createReceiptLines(Sale sale) {
	sale.resetLineItemIterator();
	while (sale.hasMoreLineItems()) {
	    receiptLines.add(sale.nextLineItem());
	}
    }

    /**
     * Returns the amount of change the customer should have.
     *
     * @return The amount of change the customer should have.
     */
    public int getChange() {
	return payedAmount - totalCost;
    }

    /**
     * Returns a well-formatted string with all receipt information.
     *
     * @return A well-formatted string with all receipt information.
     */
    public String toString() {
	//create a string that can be printed on the receipt.
	return null; //Sould return the string created above.
    }

}
