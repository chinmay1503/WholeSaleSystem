package com.wholesalesystem.services;

import com.wholesalesystem.data.Buyers;

import java.util.List;

public interface BuyerService {

    Buyers get(int buyer_id);

    List<Buyers> listAllBuyers();

    void add(String buyer_name, String buyer_address, String buyer_phone_no, String buyer_email_id , String buyer_pass);

    void updateBuyer(int buyer_id, String buyer_name, String buyer_address, String buyer_phone_no, String buyer_email_id);

    void deleteBuyer(int buyer_id);

}
