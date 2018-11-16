package com.wholesalesystem.services;

import com.wholesalesystem.data.ProductTypes;

import java.util.List;

public interface ProductTypeService {

    List<ProductTypes> listAllProductAndType();

     ProductTypes get(int product_id);

     void addProductType(int pt_product_id , String product_type,double margin_per);

}
