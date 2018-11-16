package com.wholesalesystem.services;

import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.Buyers;
import org.springframework.stereotype.Service;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class BuyerServiceImpl implements BuyerService {


    public BuyerServiceImpl() {

    }

    @Override
    public List<Buyers> listAllBuyers() {
        List<Buyers> listBuyer = new ArrayList<Buyers>();
        Connection con = null;
        try {

            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BUYERS");
            while (rs.next()) {
                Buyers b = new Buyers();
                b.setBuyerId(rs.getInt("BUYER_ID"));
                b.setBuyer_name(rs.getString("BUYER_NAME"));
                b.setBuyer_address(rs.getString("BUYER_ADDRESS"));
                b.setBuyer_phone_no(rs.getString("BUYER_PHONE_NO"));
                b.setBuyer_email_id(rs.getString("BUYER_EMAIL_ID"));
                listBuyer.add(b);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listBuyer;
    }

    @Override
    public Buyers get(int buyer_id) {
        Buyers b = new Buyers();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM BUYERS WHERE BUYER_ID = ?");
            stmt.setInt(1, buyer_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                b.setBuyerId(rs.getInt("BUYER_ID"));
                b.setBuyer_name(rs.getString("BUYER_NAME"));
                b.setBuyer_address(rs.getString("BUYER_ADDRESS"));
                b.setBuyer_phone_no(rs.getString("BUYER_PHONE_NO"));
                b.setBuyer_email_id(rs.getString("BUYER_EMAIL_ID"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public void add(String buyer_name, String buyer_address, String buyer_phone_no, String buyer_email_id , String buyer_pass) {
        //  Buyers b = new Buyers();
        Connection con = null;
        int userid;
        Buyers buyer = new Buyers();
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO BUYERS VALUES(?,?,?,?,?)");
            //   stmt.setInt(1,buyer_id);
            stmt.setString(1, null);
            stmt.setString(2, buyer_name);
            stmt.setString(3, buyer_address);
            stmt.setString(4, buyer_phone_no);
            stmt.setString(5, buyer_email_id);
            stmt.executeQuery();
            stmt = con.prepareStatement("SELECT * FROM BUYERS WHERE BUYER_ID = (SELECT MAX(BUYER_ID) FROM BUYERS)");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                buyer.setBuyerId(rs.getInt("BUYER_ID"));
            }
            userid = buyer.getBuyerId();
            PreparedStatement statement = con.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?)");
            statement.setInt(1,userid);
            statement.setString(2,buyer_name);
            statement.setString(3,buyer_pass);
            statement.setString(4,"2");
            statement.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBuyer(int buyer_id, String buyer_name, String buyer_address, String buyer_phone_no, String buyer_email_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE BUYERS SET BUYER_NAME = ? ,BUYER_ADDRESS = ? ,BUYER_PHONE_NO = ? ,BUYER_EMAIL_ID = ? WHERE BUYER_ID = ?");
            stmt.setString(1, buyer_name);
            stmt.setString(2, buyer_address);
            stmt.setString(3, buyer_phone_no);
            stmt.setString(4, buyer_email_id);
            stmt.setInt(5, buyer_id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBuyer(int buyer_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM BUYERS WHERE BUYER_ID=?");
            stmt.setInt(1, buyer_id);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
