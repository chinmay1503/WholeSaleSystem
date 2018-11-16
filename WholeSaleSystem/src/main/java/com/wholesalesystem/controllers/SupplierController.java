package com.wholesalesystem.controllers;


import com.wholesalesystem.data.Suppliers;
import com.wholesalesystem.services.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SupplierController.java - Handles all api requests related to Suppliers */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "suppliers")
public class SupplierController {

    @Autowired
    SupplierServiceImpl supplierService;

    /**
     * listAllSuppliers - @return returns a List Of Suppliers */
    @RequestMapping(value = "/displayAllSuppliers", method = RequestMethod.GET)
    @ResponseBody
    public List<Suppliers> listAllSuppliers() {
        List<Suppliers> suppliers;
        suppliers = supplierService.listAllSuppliers();
        return suppliers;
    }

    /**
     * listSuppliers
     * @param supplier_id takes id of supplier as input
     * @return returns Supplier with the id specified */
    @RequestMapping(value = "/displaySupplier", method = RequestMethod.GET)
    @ResponseBody
    public Suppliers listSuppliers(@RequestParam(value = "id") String supplier_id) {
        Integer id = Integer.parseInt(supplier_id);
        Suppliers supplier;
        supplier = supplierService.get(id);
        return supplier;
    }

    /**
     * addSupplier
     * takes various supplier details as input and add him/her to the database */
    @RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
    @ResponseBody
    public void addSupplier(@RequestParam(value = "name") String supplier_name,
                            @RequestParam(value = "contact") String phone_no) {
        supplierService.addSupplier(supplier_name, phone_no);
    }

    /**
     * deleteSupplier
     * @param supplier_id takes supplier's id as input and removes his/her information from the database */
    @RequestMapping(value = "/deleteSupplier", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSupplier(@RequestParam(value = "id") String supplier_id) {
        Integer id = Integer.parseInt(supplier_id);
        supplierService.deleteSupplier(id);
    }
}
