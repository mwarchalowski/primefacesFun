/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author punker
 */
@Named(value = "checkoutController")
@SessionScoped
public class CheckoutController implements Serializable {

@Inject
private UserManager um;

@Inject 
private CartController cc;
    
    private String cc_number;
    private String exp_month;
    private String exp_year;
    private String ccv;
    private String name_on_card;
    
    private boolean checkout_complete;

    public boolean isCheckout_complete() {
        return checkout_complete;
    }

    public String getCc_number() {
        return cc_number;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public String getExp_month() {
        return exp_month;
    }

    public void setExp_month(String exp_month) {
        this.exp_month = exp_month;
    }

    public String getExp_year() {
        return exp_year;
    }

    public void setExp_year(String exp_year) {
        this.exp_year = exp_year;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getName_on_card() {
        return name_on_card;
    }

    public void setName_on_card(String name_on_card) {
        this.name_on_card = name_on_card;
    }
    /**
     * Creates a new instance of CheckoutController
     */
    public CheckoutController() {
    }
    
    public String completeCheckout() {
        String thanks_string;
        thanks_string = "Thank you for placing your order " + um.getCurrent_customer().getFirstName() + "\n Your total is:" + cc.getTotal() ;
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Order Placed",thanks_string);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        checkout_complete = true;
        return null;
    }
    
    
    
}
