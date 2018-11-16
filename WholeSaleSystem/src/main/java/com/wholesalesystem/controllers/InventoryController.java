package com.wholesalesystem.controllers;

import com.wholesalesystem.data.Inventory;
import com.wholesalesystem.services.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * InventoryController.java - Handles all api requests related to Inventory */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value="inventory")
public class InventoryController {


    @Autowired
    private InventoryServiceImpl  inventoryService;

    @RequestMapping(value = "/displayAllInvProducts", method = RequestMethod.GET)
    @ResponseBody
    public List<Inventory> listAllInvProducts() {
        List<Inventory> products;
        products = inventoryService.listAllProducts();
        return products;
    }

    @RequestMapping(value = "/displayProduct", method = RequestMethod.GET)
    @ResponseBody
    public Inventory listProduct(@RequestParam(value = "id") String inv_product_id) {
        int id = Integer.parseInt(inv_product_id);
        Inventory product;
        product = inventoryService.get(id);
        return product;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public void addProduct(@RequestParam(value = "id") String product_id,
                           @RequestParam(value = "quantity") String product_quantity,
                           @RequestParam(value = "min_stock") String min_stock_level) {
        Integer id = Integer.parseInt(product_id);
        Double quantity = Double.parseDouble(product_quantity);
        Double minlevel = Double.parseDouble(min_stock_level);
        inventoryService.addInv(id, quantity, minlevel);
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
    @ResponseBody
    public void updateProduct(@RequestParam(value = "id") String product_id,
                              @RequestParam(value = "min_stock") String min_stock_level) {
        Integer id = Integer.parseInt(product_id);
        Double minlevel = Double.parseDouble(min_stock_level);
        inventoryService.updateInv(id, minlevel);
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@RequestParam(value = "id") String product_id) {
        Integer id = Integer.parseInt(product_id);
        inventoryService.deleteInv(id);
    }
}