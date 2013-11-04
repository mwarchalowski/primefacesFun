/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.project.csfourfouronedbtest.controllers;

import com.distributed.project.csfourfouronedbtest.db.entities.Productcustomattr;
import com.distributed.project.csfourfouronedbtest.ejbs.ProductcustomattrFacade;
import java.io.ByteArrayInputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author punker
 */
@Named(value = "productImageRenderer")
@SessionScoped
public class ProductImageRenderer implements Serializable {

    @Inject
    private ProductcustomattrFacade atrr_facade;

    /**
     * Creates a new instance of ProductImageRenderer
     */
    public ProductImageRenderer() {
    }

    public StreamedContent renderImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent(); 
        }
            Map param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            System.out.println("2nd Pass:");

            String attrib_id = (String) param.get("img_attr_id");
            int image_id = Integer.parseInt(attrib_id);
            Productcustomattr ca = atrr_facade.find(image_id);
            byte[] bytes = ca.getProductImage();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            StreamedContent myImage = new DefaultStreamedContent(bais, "image/png");
            
            return myImage;
        }
    }
