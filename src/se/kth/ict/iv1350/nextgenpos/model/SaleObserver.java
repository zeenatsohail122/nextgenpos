
package se.kth.ict.iv1350.nextgenpos.model;
/**
 *
 *  Implementation that notifies whenever a sale changes
 */

public interface SaleObserver {

    /**
     * Called whenever a <code>SalesLineItem</code>
     * is added to the <code>Sale</code>
     * 
     * @param lineItem the specific <code>SalesLineItem</code> added this time
     */
    public void itemAdded (SalesLineItem lineItem);
    
    /**
     * Called whenever a <code>SalesLineItem</code>
     * is added or removed to the <code>Sale</code>.
     * Always preceded by itemAdded
     * 
     * @param allItems list with all the items currently added to Sale
     */
    public void saleListUpdated (SalesLineItem[] allItems);
}

    
