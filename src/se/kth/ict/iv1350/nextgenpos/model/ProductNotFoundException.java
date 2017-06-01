/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.nextgenpos.model;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(int itemId) {
        super("Product with id " + itemId + " is not found!!!");
    }
    
}