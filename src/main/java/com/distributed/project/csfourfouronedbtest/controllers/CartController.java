/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.controllers;

import com.distributed.project.csfourfouronedbtest.db.entities.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

/**
 *
 * @author punker
 */
@Named(value = "cartController")
@SessionScoped
public class CartController implements Serializable {

    private List<Product> product_list;
    private float subtotal;
    private float shipping;
    private float tax; 
    private float total;

    public List<Product> getProduct_list() {
        return product_list;
    }
    /**
     * Creates a new instance of CartController
     */
    @PostConstruct
    private void initialize() {
        product_list = new ArrayList<Product>();
    }
    
    public CartController() {
    }
    
    public void addItem(Product p) {
        product_list.add(p);
    }
    
    public void removeItem(Product p) {
       
        product_list.remove(p);
    }
    
    public float getSubtotal() { 
        float subtotal = 0;
        for(Product p : product_list ) {
            subtotal = subtotal + p.getProductpricesList().get(0).getSpecialPrice();
        }
        this.subtotal = subtotal;
        return subtotal;
    }
    
    public float getShipping() {
        shipping = (float)(subtotal * 0.1);
        return shipping;
    }
    
    public float getTax() {
        tax = (float)(subtotal * 0.095);
        return tax;
    }
    
    public float getTotal() {
        total = shipping + tax + subtotal;
        return total;
    }
}
