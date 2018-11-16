package com.wholesalesystem.controllers;

import com.wholesalesystem.services.BuyerServiceImpl;
import com.wholesalesystem.data.Buyers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * BuyerController.java - Handles all api requests related to Buyers */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "/buyers")
public class BuyerController {

    @Autowired
    private BuyerServiceImpl buyers;

    /**
     * listBuyer - @return returns a List Of Buyers */
    @RequestMapping(value = "/displayAllBuyers", method = RequestMethod.GET)
    @ResponseBody
    public List<Buyers> listBuyer() {
        List<Buyers> buyerlist = new ArrayList<Buyers>();
        buyerlist = buyers.listAllBuyers();
        return buyerlist;
    }


    /**
     * getBuyer
     * @param buyer_id takes id of buyer as input
     * @return returns Buyer with the id specified */
    @RequestMapping(value = "/displayBuyer", method = RequestMethod.GET)
    @ResponseBody
    public Buyers getBuyer(@RequestParam(value = "id", defaultValue = "125") String buyer_id) {
        int id = Integer.parseInt(buyer_id);
        Buyers a;
        a = buyers.get(id);
        return a;
    }

    /**
     * addBuyer - takes various buyer details as input and add him to the database */
    @RequestMapping(value = "/addBuyer", method = RequestMethod.POST)
    @ResponseBody
    public void addBuyer(@RequestParam(value = "name") String buyer_name,
                         @RequestParam(value = "address") String buyer_address,
                         @RequestParam(value = "contact") String buyer_phone,
                         @RequestParam(value = "email") String buyer_email,
                         @RequestParam(value = "pass") String buyer_pass){
        BuyerServiceImpl buyers = new BuyerServiceImpl();
        buyers.add(buyer_name, buyer_address, buyer_phone, buyer_email, buyer_pass);
    }

    /**
     * updateBuyer - takes various buyer details as input and updates his/her information from the database */
    @RequestMapping(value = "/updateBuyer", method = RequestMethod.PUT)
    @ResponseBody
    public void updateBuyer(@RequestParam(value = "id") String buyer_id,
                            @RequestParam(value = "name") String buyer_name,
                            @RequestParam(value = "address") String buyer_address,
                            @RequestParam(value = "contact") String buyer_phone,
                            @RequestParam(value = "email") String buyer_email) {
        int id = Integer.parseInt(buyer_id);
        buyers.updateBuyer(id, buyer_name, buyer_address, buyer_phone, buyer_email);
    }

    /**
     * deleteBuyer
     * @param buyer_id takes buyer id as input and removes his/her information from the database */
    @RequestMapping(value = "/deleteBuyer", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBuyer(@RequestParam(value = "id") String buyer_id) {
        int id = Integer.parseInt(buyer_id);
        buyers.deleteBuyer(id);
    }
}
