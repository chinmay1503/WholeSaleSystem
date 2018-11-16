package com.wholesalesystem.controllers;

import com.wholesalesystem.data.PurchaseOrders;
import com.wholesalesystem.services.PurchaseOrderServiceImpl;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

/**
 * PurchaseOrderController.java - Handles all api requests related to PurchaseOrders */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "purchaseorders")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderServiceImpl purchaseOrderService;

    @RequestMapping(value = "/displayAllPurchaseOrders", method = RequestMethod.GET)
    @ResponseBody
    public List<PurchaseOrders> listAllPurchaseOrders() {
        List<PurchaseOrders> purchaseOrders;
        purchaseOrders = purchaseOrderService.listAllPurchaseOrders();
        return purchaseOrders;
    }

    @RequestMapping(value = "/displayPurchaseOrder", method = RequestMethod.GET)
    @ResponseBody
    public PurchaseOrders listPurchaseOrder() {
        PurchaseOrders po;
        po = purchaseOrderService.get();
        return po;
    }

    @RequestMapping(value = "/addPurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public PurchaseOrders addPurchaseOrder(@RequestParam(value = "id") String supplier_id,
                                           @RequestParam(value = "date") String delivery_date) {
        Integer id = Integer.parseInt(supplier_id);
        DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern("dd-MM-yyyy").toFormatter();
        LocalDate expdeldate = LocalDate.parse(delivery_date, DATE_FORMAT);
        PurchaseOrders purchaseOrder;
        purchaseOrder = purchaseOrderService.addPurchaseOrder(id, expdeldate);
        return purchaseOrder;
    }

    @RequestMapping(value = "/updatePurchaseOrder", method = RequestMethod.PUT)
    @ResponseBody
    public void updatePurchaseOrder(@RequestParam(value = "id") String purchaseord_id,
                                    @RequestParam(value = "date") String delivery_date) {
        Integer id = Integer.parseInt(purchaseord_id);
        DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern("dd-MM-yyyy").toFormatter();
        LocalDate expdeldate = LocalDate.parse(delivery_date, DATE_FORMAT);
        // LocalDate expdeldate = LocalDate.of(2018,07,15);
        purchaseOrderService.updatePurchOrderDeliveryDate(id, expdeldate);
    }

    @RequestMapping(value = "/deletePurchaseOrder", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePurchaseOrder(@RequestParam(value = "id") String purchaseord_id) {
        Integer id = Integer.parseInt(purchaseord_id);
        purchaseOrderService.deletePurchaseOrder(id);
    }

}
