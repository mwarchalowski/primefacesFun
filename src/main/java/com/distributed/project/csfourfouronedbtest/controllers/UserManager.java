/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.project.csfourfouronedbtest.controllers;

import com.distributed.project.csfourfouronedbtest.db.entities.Customer;
import com.distributed.project.csfourfouronedbtest.db.entities.Customercredentials;
import com.distributed.project.csfourfouronedbtest.ejbs.CustomercredentialsFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author punker
 */
@Named(value = "userManager")
@SessionScoped
public class UserManager implements Serializable {

    @EJB
    private CustomercredentialsFacade customer_cred;
    private FacesMessage msg;
    private String password;
    private String username;
    private Customer current_customer;

    public Customer getCurrent_customer() {
        return current_customer;
    }
    
    public UserManager() {
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        String action = null;
        Customercredentials temp_customer = customer_cred.findByLogin(username);

        if (temp_customer != null && temp_customer.getCustomerLogin().equals(username) && temp_customer.getCustomerPassword().equals(password) && username != null && password != null) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", temp_customer.getCustomerId().getFirstName());
            action = "mainscreen";
            current_customer = temp_customer.getCustomerId();
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        return action;
    }
   
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }
    public boolean isLoggedIn() {
        return current_customer != null;
    }
    
    @Override
    public String toString() {
        return "dupa";
    }

}
