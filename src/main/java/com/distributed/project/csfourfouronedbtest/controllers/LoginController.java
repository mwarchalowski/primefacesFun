/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.controllers;

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
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private  CustomercredentialsFacade customer_cred;
    private  FacesMessage msg;
    
    private String username;

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
    private String password;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    public void login() {
        Customercredentials temp_customer = customer_cred.findByLogin(username);
        
        if(temp_customer != null && temp_customer.getCustomerLogin().equals(username) && temp_customer.getCustomerPassword().equals(password) && username != null && password != null) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", temp_customer.getCustomerId().getFirstName());
        } else {
           msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }
        
        
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
