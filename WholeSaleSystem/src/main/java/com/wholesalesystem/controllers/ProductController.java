package com.wholesalesystem.controllers;


import com.wholesalesystem.data.InventoryDetails;
import com.wholesalesystem.data.ProductDetails;
import com.wholesalesystem.data.Products;
import com.wholesalesystem.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * ProductController.java - Handles all api requests related to Products */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "products")
public class ProductController {


    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(value = "/displayAllProducts", method = RequestMethod.GET)
    @ResponseBody
    public List<Products> listAllProducts() {
        List<Products> products;
        products = productService.listAllProducts();
        return products;
    }

    @RequestMapping(value = "/displayProduct", method = RequestMethod.GET)
    @ResponseBody
    public Products listProduct(HttpServletRequest request) {
        String product_id = request.getParameter("product_id");
        int id = Integer.parseInt(product_id);
        Products product;
        product = productService.get(id);
        return product;
    }

    //Also Inserts into Product Type
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public void addProduct(@RequestParam(value = "name") String product_name,
                           @RequestParam(value = "price") String product_price,
                           @RequestParam(value = "desc") String product_desc,
                           @RequestParam(value = "img") String product_img,
                           @RequestParam(value = "type") String product_type,
                           @RequestParam(value = "margin") String product_margin) {
        Double price = Double.parseDouble(product_price);
        Integer margin = Integer.parseInt(product_margin);
        productService.addProduct(product_name, product_desc, price, product_img, product_type, margin);
    }

    //Also Updates Product Type
    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
    @ResponseBody
    public void updateProduct(@RequestParam(value = "id") String product_id,
                              @RequestParam(value = "name") String product_name,
                              @RequestParam(value = "desc") String product_desc,
                              @RequestParam(value = "price") String product_price,
                              @RequestParam(value = "type") String product_type,
                              @RequestParam(value = "margin") String product_margin) {
        Integer id = Integer.parseInt(product_id);
        Double price = Double.parseDouble(product_price);
        Integer margin = Integer.parseInt(product_margin);
        productService.updateDescAndPrice(id, product_name, product_desc, price, product_type, margin);
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@RequestParam(value = "id") String product_id) {
        Integer id = Integer.parseInt(product_id);
        productService.deleteProduct(id);
    }

    //--------------------------------------------------PRODUCT RELATED API-----------------------------------------------------------------

    @RequestMapping(value = "/displayAllProductDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDetails> listAllProductsAndType() {
        List<ProductDetails> products;
        products = productService.listAllProductsAndType();
        return products;
    }


    @RequestMapping(value = "/displayAllNames", method = RequestMethod.GET)
    @ResponseBody
    public List<Products> listAllProductName(HttpServletRequest request) {
        List<Products> products;
        String name = request.getParameter("name");
        products = productService.listAllProductName(name);
        return products;
    }

    //--------------------------------------------------INVENTORY & PRODUCT RELATED API-----------------------------------------------------------------


    @RequestMapping(value = "/displayAllDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<InventoryDetails> listAllProdDetails() {
        List<InventoryDetails> products;
        products = productService.listAllProdDetails();
        return products;
    }

}
