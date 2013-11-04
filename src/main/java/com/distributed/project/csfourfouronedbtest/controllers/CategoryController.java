/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.controllers;

import com.distributed.project.csfourfouronedbtest.db.entities.Product;
import com.distributed.project.csfourfouronedbtest.db.entities.StoreCategories;
import com.distributed.project.csfourfouronedbtest.ejbs.StoreCategoriesFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author punker
 */
@Named(value = "categoryController")
@SessionScoped
public class CategoryController implements Serializable {

    @Inject
    private StoreCategoriesFacade store_cats_fac;
    private List<StoreCategories> store_cats;
    private StoreCategories selected_cat;

    public StoreCategories getSelected_cat() {
        System.out.println("get triggered");
        return selected_cat;
    }

    public void setSelected_cat(StoreCategories selected_cat) {
        this.selected_cat = selected_cat;
        System.out.println("Set triggered");
    }
    
    public void setSelected(StoreCategories selected) {
        selected_cat = selected;
    }

    public List<StoreCategories> getStore_cats() {
         store_cats = store_cats_fac.findAll();
         return store_cats;
    }
    
    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
    }
    
    @PostConstruct
    private void getCategory() { 
    }
    
}
