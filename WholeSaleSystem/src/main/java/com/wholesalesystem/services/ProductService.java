package com.wholesalesystem.services;

import com.wholesalesystem.data.Products;
import oracle.sql.BLOB;

import java.util.List;

public interface ProductService {

     Products get(int product_id);

     List<Products> listAllProducts();

     void addProduct(String product_name, String product_desc, double product_price , String product_img , String product_type , int margin_per);

     void updateDescAndPrice(int product_id,String product_name,String product_desc, double product_price , String product_type , int margin_per);

     void deleteProduct(int product_id);

}
