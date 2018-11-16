package com.wholesalesystem.services;

import com.wholesalesystem.data.Suppliers;

import java.util.List;

public interface SupplierService {

    Suppliers get(int supplier_id);

    List<Suppliers> listAllSuppliers();

    void addSupplier(String supplier_name, String supplier_phone_no);

    void deleteSupplier(int supplier_id);

}

