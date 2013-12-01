/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.project.csfourfouronedbtest.controllers;

import com.distributed.project.csfourfouronedbtest.db.entities.StoreCategories;
import com.distributed.project.csfourfouronedbtest.ejbs.StoreCategoriesFacade;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author punker
 */
@Named(value = "imageRenderer")
@SessionScoped
public class ImageRenderer implements Serializable {
    
    @Inject
    private StoreCategoriesFacade cat_facade;
    private StreamedContent ready_image;
    /**
     * Creates a new instance of ImageRenderer
     */
    public ImageRenderer() {
       
    }

    @PostConstruct
    private void initializeImage() {
        
    }
    
    public StreamedContent renderImage(byte[] img) {
        
        if(img != null) {
        //System.out.println("Byte Length:" + img.length);
        ByteArrayInputStream bais = new ByteArrayInputStream(img);
        StreamedContent myImage = new DefaultStreamedContent(bais, "image/png");
        ready_image = myImage;
        return myImage;
        }
        Map param  = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        //System.out.println("2nd Pass:");
        
        String cat_id =  (String)param.get("catid");
        int category = Integer.parseInt(cat_id);
        ByteArrayInputStream bais = new ByteArrayInputStream(cat_facade.find(category).getCatPicture());
        StreamedContent myImage = new DefaultStreamedContent(bais, "image/png");
        return myImage;
    }
    public boolean hasImage(StoreCategories cat) {
        //System.out.println("Checking for image of category " + cat.getCatName());
        if(cat.getCatPicture() != null) {
            
            //System.out.println("image is not null");
             return true;
        }
        //System.out.println("Image Is null");
        return false;
    }
}
