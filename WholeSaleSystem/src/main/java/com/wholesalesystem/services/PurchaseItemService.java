package com.wholesalesystem.services;

import com.wholesalesystem.data.PurchaseItems;

import java.util.List;

public interface PurchaseItemService {

    PurchaseItems get(int purchase_id);

    List<PurchaseItems> listAllPurchaseItems();

    void addItem(int pi_purchase_id, int pi_product_id, double pi_quantity, double pi_unit_price);

    void deleteItem(int purchase_id, int product_id);

}
