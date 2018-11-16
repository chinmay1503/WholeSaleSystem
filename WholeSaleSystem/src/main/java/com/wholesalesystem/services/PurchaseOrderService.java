package com.wholesalesystem.services;

import com.wholesalesystem.data.PurchaseOrders;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrders> listAllPurchaseOrders();

    PurchaseOrders get();

    PurchaseOrders addPurchaseOrder(int po_supplier_id, LocalDate exp_deliverydate);

    void updatePurchOrderDeliveryDate(int purchaseord_id, LocalDate exp_deliverydate);

    void deletePurchaseOrder(int purchaseord_id);

    PurchaseOrders authenticateOrder(int purchaseord_id);
}
