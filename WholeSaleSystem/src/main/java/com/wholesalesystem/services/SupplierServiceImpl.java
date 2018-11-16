package com.wholesalesystem.services;

import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.Suppliers;
import org.springframework.stereotype.Service;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {


    public SupplierServiceImpl() {

    }

    @Override
    public List<Suppliers> listAllSuppliers() {
        List<Suppliers> listSupplier = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SUPPLIERS");
            while (rs.next()) {
                Suppliers s = new Suppliers();
                s.setSupplier_id(rs.getInt("SUPPLIER_ID"));
                s.setSupplier_name(rs.getString("SUPPLIER_NAME"));
                s.setSupplier_phone_no(rs.getString("SUPPLIER_PHONE_NO"));
                listSupplier.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSupplier;
    }

    @Override
    public Suppliers get(int supplier_id) {
        Suppliers s = new Suppliers();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Suppliers WHERE SUPPLIER_ID = ?");
            stmt.setInt(1, supplier_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                s.setSupplier_id(rs.getInt("SUPPLIER_ID"));
                s.setSupplier_name(rs.getString("SUPPLIER_NAME"));
                s.setSupplier_phone_no(rs.getString("SUPPLIER_PHONE_NO"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void addSupplier(String supplier_name, String supplier_phone_no) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO SUPPLIERS VALUES(?,?,?)");
            stmt.setString(1, null);
            stmt.setString(2, supplier_name);
            stmt.setString(3, supplier_phone_no);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSupplier(int supplier_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM SUPPLIERS WHERE SUPPLIER_ID=?");
            stmt.setInt(1, supplier_id);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

