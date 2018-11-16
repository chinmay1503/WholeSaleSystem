package com.wholesalesystem.controllers;

import com.wholesalesystem.data.PurchaseItems;
import com.wholesalesystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PurchaseItemController.java - Handles all api requests related to PurchaseItems */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "purchaseitems")
public class PurchaseItemController {

    @Autowired
    private PurchaseItemServiceImpl purchaseItemService;


    @RequestMapping(value = "/displayAllItems", method = RequestMethod.GET)
    @ResponseBody
    public List<PurchaseItems> listAllItems() {
        List<PurchaseItems> purchaseItems;
        purchaseItems = purchaseItemService.listAllPurchaseItems();
        return purchaseItems;
    }

    @RequestMapping(value = "/displayItem", method = RequestMethod.GET)
    @ResponseBody
    public PurchaseItems listItems(@RequestParam(value = "item_id") String item_id) {
        Integer id = Integer.parseInt(item_id);
        PurchaseItems item;
        item = purchaseItemService.get(id);
        return item;
    }

        @RequestMapping(value="/addItem" , method= RequestMethod.POST)
        @ResponseBody
        public void addItem(@RequestParam(value = "purchase_id") String pi_purchase_id,
                            @RequestParam(value = "item_id") String pi_item_id,
                            @RequestParam(value = "quantity") String item_quantity,
                            @RequestParam(value = "price") String item_price){
            Integer purchase_id = Integer.parseInt(pi_purchase_id);
            Integer product_id = Integer.parseInt(pi_item_id);
            Double quantity = Double.parseDouble(item_quantity);
            Double price = Double.parseDouble(item_price);
            purchaseItemService.addItem(purchase_id,product_id , quantity,price);
        }

    @RequestMapping(value = "/deleteItem", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteItem(@RequestParam(value = "purchase_id") String pi_purchase_id,
                           @RequestParam(value = "item_id") String pi_item_id) {
        Integer id = Integer.parseInt(pi_purchase_id);
        Integer product = Integer.parseInt(pi_item_id);
        purchaseItemService.deleteItem(id, product);
    }

}
