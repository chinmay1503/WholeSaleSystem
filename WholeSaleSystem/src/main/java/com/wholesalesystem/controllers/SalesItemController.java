package com.wholesalesystem.controllers;

import com.wholesalesystem.data.SalesItems;
import com.wholesalesystem.services.SalesItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wholesalesystem.services.SalesItemServiceImpl.callProcedure;

/**
 * SalesItemController.java - Handles all api requests related to SalesItems */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "salesitem")
public class SalesItemController {

    @Autowired
    SalesItemServiceImpl salesItemService;

    @RequestMapping(value = "/displayAllItems", method = RequestMethod.GET)
    @ResponseBody
    public List<SalesItems> listAllItems() {
        List<SalesItems> salesItems;
        salesItems = salesItemService.listAllSalesItems();
        return salesItems;
    }

    @RequestMapping(value = "/displayItem", method = RequestMethod.GET)
    @ResponseBody
    public SalesItems listItems(@RequestParam(value = "item_id") String item_id) {
        Integer id = Integer.parseInt(item_id);
        SalesItems item;
        item = salesItemService.get(id);
        return item;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public void addItem(@RequestParam(value = "order_id") String si_order_id,
                        @RequestParam(value = "product_id") String si_product_id,
                        @RequestParam(value = "quantity") String item_quantity,
                        @RequestParam(value = "price") String item_price) {
        Integer order_id = Integer.parseInt(si_order_id);
        Integer product_id = Integer.parseInt(si_product_id);
        Double quantity = Double.parseDouble(item_quantity);
        Double price = Double.parseDouble(item_price);
        salesItemService.addItem(order_id, product_id, quantity, price, 0);
        callProcedure(product_id);
    }

    @RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
    @ResponseBody
    public void deleteItem(@RequestParam(value = "order_id") String si_order_id) {
        Integer order_id = Integer.parseInt(si_order_id);
        salesItemService.deleteItem(order_id);
    }
}
