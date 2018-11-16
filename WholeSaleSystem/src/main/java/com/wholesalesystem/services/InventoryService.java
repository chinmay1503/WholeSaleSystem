package com.wholesalesystem.services;


import com.wholesalesystem.data.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory get(int inv_product_id);

    List<Inventory> listAllProducts();

    void addInv(int inv_product_id, double product_quantity, double min_stock_level);

    void updateInv(int inv_product_id, double min_stock_level);

    void deleteInv(int inv_product_id);

}

