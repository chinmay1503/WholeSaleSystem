package com.wholesalesystem.services;

import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.ProductTypes;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Override
    public List<ProductTypes> listAllProductAndType() {
        List<ProductTypes> listProducts = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT_TYPE");
            while (rs.next()) {
                ProductTypes pt = new ProductTypes();
                pt.setPt_product_id(rs.getInt("PT_PRODUCT_ID"));
                pt.setProduct_type(rs.getString("PRODUCT_TYPE"));
                pt.setMargin_per(rs.getDouble("MARGIN_PER"));
                listProducts.add(pt);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProducts;
    }

    @Override
    public ProductTypes get(int product_id) {
        ProductTypes pt = new ProductTypes();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM PRODUCT_TYPE WHERE PT_PRODUCT_ID = ?");
            stmt.setInt(1, product_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pt.setPt_product_id(rs.getInt("PT_PRODUCT_ID"));
                pt.setProduct_type(rs.getString("PRODUCT_TYPE"));
                pt.setMargin_per(rs.getDouble("MARGIN_PER"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pt;
    }

    @Override
    public void addProductType(int pt_product_id, String product_type, double margin_per) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO PRODUCT_TYPE VALUES(?,?,?)");
            stmt.setInt(1,pt_product_id);
            stmt.setString(2, product_type);
            stmt.setDouble(3, margin_per);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
