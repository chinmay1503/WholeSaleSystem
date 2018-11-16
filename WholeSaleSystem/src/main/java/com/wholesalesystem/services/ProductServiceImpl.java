package com.wholesalesystem.services;

import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.InventoryDetails;
import com.wholesalesystem.data.ProductDetails;
import com.wholesalesystem.data.Products;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl() {

    }

    @Override
    public List<Products> listAllProducts() {
        List<Products> listProduct = new ArrayList<Products>();
        Connection con = null;
        try {

            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTS");
            while (rs.next()) {
                Products p = new Products();
                p.setProduct_id(rs.getInt("PRODUCT_ID"));
                p.setProduct_name(rs.getString("PRODUCT_NAME"));
                p.setProduct_desc(rs.getString("PRODUCT_DESC"));
                p.setProduct_img(rs.getString("IMG_SRC"));
                p.setProduct_price(rs.getDouble("PRODUCT_PRICE"));
                listProduct.add(p);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }


    @Override
    public Products get(int product_id) {
        Products p = new Products();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM PRODUCTS WHERE PRODUCT_ID = ?");
            stmt.setInt(1, product_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p.setProduct_id(rs.getInt("PRODUCT_ID"));
                p.setProduct_name(rs.getString("PRODUCT_NAME"));
                p.setProduct_desc(rs.getString("PRODUCT_DESC"));
                p.setProduct_price(rs.getDouble("PRODUCT_PRICE"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void addProduct(String product_name, String product_desc, double product_price, String product_img, String product_type, int margin_per) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            String[] PRODUCT_ID = {"PRODUCT_ID"};
            PreparedStatement stmt = con.prepareStatement("INSERT INTO PRODUCTS VALUES(?,?,?,?,?)" , PRODUCT_ID );
            stmt.setString(1, null);
            stmt.setString(2, product_name);
            stmt.setString(3, product_desc);
            stmt.setDouble(4, product_price);
            stmt.setString(5, product_img);
            stmt.executeUpdate();
            int candidateId = 0;
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                candidateId = rs.getInt(1);
            }
            stmt = con.prepareStatement("INSERT INTO PRODUCT_TYPE VALUES (?,?,?)");
            stmt.setInt(1, candidateId);
            String type = product_type.toUpperCase();
            stmt.setString(2, type);
            stmt.setInt(3, margin_per);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDescAndPrice(int product_id, String product_name, String product_desc, double product_price, String product_type, int margin_per) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE PRODUCTS SET PRODUCT_NAME=? PRODUCT_DESC = ? , PRODUCT_PRICE= ? WHERE PRODUCT_ID=?");
            stmt.setString(1, product_name);
            stmt.setString(2, product_desc);
            stmt.setDouble(3, product_price);
            stmt.setInt(4, product_id);
            stmt.executeUpdate();
            stmt = con.prepareStatement("UPDATE PRODUCT_TYPE SET PRODUCT_TYPE=? , MARGIN_PER=? WHERE PT_PRODUCT_ID=?");
            stmt.setString(1, product_type);
            stmt.setInt(2, margin_per);
            stmt.setInt(3, product_id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int product_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM PRODUCT_TYPE WHERE PT_PRODUCT_ID=?");
            stmt.setInt(1, product_id);
            stmt.executeQuery();
            stmt = con.prepareStatement("DELETE FROM PRODUCTS WHERE PRODUCT_ID=?");
            stmt.setInt(1, product_id);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------PRODUCT DETAILS----------------------------------------------------
    //To Display Product Name And Its Type
    public List<ProductDetails> listAllProductsAndType() {
        List<ProductDetails> listProduct = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT P.PRODUCT_NAME, PT.PRODUCT_TYPE ,P.PRODUCT_PRICE " +
                    "FROM PRODUCTS P " +
                    "INNER JOIN PRODUCT_TYPE PT " +
                    "ON P.PRODUCT_ID = PT.PT_PRODUCT_ID");
            while (rs.next()) {
                ProductDetails pd = new ProductDetails();
                pd.setProduct_name(rs.getString("PRODUCT_NAME"));
                pd.setProduct_type(rs.getString("PRODUCT_TYPE"));
                pd.setProduct_price(rs.getDouble("PRODUCT_PRICE"));
                listProduct.add(pd);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }

    public List<Products> listAllProductName(String name) {
        List<Products> listProduct = new ArrayList<>();
        Connection con = null;
        try {

            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT PRODUCT_NAME,PRODUCT_DESC FROM PRODUCTS WHERE PRODUCT_NAME LIKE ?");
            stmt.setString(1, name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Products pd = new Products();
                pd.setProduct_name(rs.getString(1));
                pd.setProduct_desc(rs.getString(2));
                listProduct.add(pd);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }

    //To Get Product And Inventory Details
    public List<InventoryDetails> listAllProdDetails() {
        List<InventoryDetails> listProduct = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *  \n" +
                    "FROM INVENTORY I JOIN PRODUCTS P\n" +
                    "ON I.INV_PRODUCT_ID = P.PRODUCT_ID");
            while (rs.next()) {
                InventoryDetails inventoryDetails = new InventoryDetails();
                inventoryDetails.setInv_product_id(rs.getInt("INV_PRODUCT_ID"));
                inventoryDetails.setProduct_quantity(rs.getDouble("PRODUCT_QUANTITY"));
                inventoryDetails.setMin_stock_level(rs.getDouble("MIN_STOCK_LEVEL"));
                inventoryDetails.setProduct_id(rs.getInt("PRODUCT_ID"));
                inventoryDetails.setProduct_name(rs.getString("PRODUCT_NAME"));
                inventoryDetails.setProduct_desc(rs.getString("PRODUCT_DESC"));
                inventoryDetails.setProduct_price(rs.getDouble("PRODUCT_PRICE"));
                inventoryDetails.setProduct_img(rs.getString("IMG_SRC"));
                listProduct.add(inventoryDetails);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }


}
