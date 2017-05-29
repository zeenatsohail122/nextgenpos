/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.nextgenpos.model;

/**
 * An instance of this class hold all information about a certain product.
 */
public class ProductSpecification {
    private int productId;
    private String description;
    private String name;
    private int price;
    //More properties.

    /**
     * Creates a new instance.
     */
    public ProductSpecification(int productId, String name, String descr, 
				int price /* more properties */) {
	this.productId = productId;
	this.description = descr;
	this.name = name;
	this.price = price;
    }

    public int getPrice() {
	return price;
    }

    //More get methods.

    public String toString() {
	return "Product id: " + productId + ", name: " + name + 
	    ", price:" + price + "\ndescription: " + description;
	    
    }
}
    
