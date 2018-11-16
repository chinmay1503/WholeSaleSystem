package com.wholesalesystem.services;

import com.wholesalesystem.data.SalesItems;

import java.util.List;

public interface SalesItemService {

    SalesItems get(int order_id);

    List<SalesItems> listAllSalesItems();

    void addItem(int si_order_id, int si_product_id, double si_quantity, double si_unit_price, double si_discounted_price);

    void deleteItem(int order_id);

}
