package com.wholesalesystem.services;


import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.OrderDetails;
import com.wholesalesystem.data.PaymentDetails;
import com.wholesalesystem.data.SalesOrder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Override
    public List<SalesOrder> listAllSalesOrders() {
        List<SalesOrder> listsaleOrder = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SALESORDERS");
            while (rs.next()) {
                SalesOrder salesOrder = new SalesOrder();
                salesOrder.setSalesord_id(rs.getInt("SALESORD_ID"));
                salesOrder.setSo_buyer_id(rs.getInt("SO_BUYER_ID"));
                salesOrder.setSaleprice(rs.getDouble("SALEPRICE"));
                salesOrder.setSaledate(rs.getDate("SALEDATE"));
                salesOrder.setPayment_status(rs.getString("PAYMENT_STATUS"));
                salesOrder.setOrder_status(rs.getString("ORDER_STATUS"));
                salesOrder.setDeliverydate(rs.getDate("EXP_DELIVERY_DATE"));
                listsaleOrder.add(salesOrder);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listsaleOrder;
    }

    @Override
    public SalesOrder get() {
        SalesOrder so = new SalesOrder();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SALESORDERS WHERE SALESORD_ID = (SELECT MAX(SALESORD_ID) FROM SALESORDERS)");
            while (rs.next()) {
                so.setSalesord_id(rs.getInt("SALESORD_ID"));
                so.setSo_buyer_id(rs.getInt("SO_BUYER_ID"));
                so.setSaleprice(rs.getDouble("SALEPRICE"));
                so.setSaledate(rs.getDate("SALEDATE"));
                so.setPayment_status(rs.getString("PAYMENT_STATUS"));
                so.setOrder_status(rs.getString("ORDER_STATUS"));
                so.setDeliverydate(rs.getDate("EXP_DELIVERY_DATE"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }

    @Override
    public void addSalesOrder(int so_buyer_id) {
        Connection con = null;
        java.time.LocalDate saledate = LocalDate.now();
        java.sql.Date orderDate = java.sql.Date.valueOf(saledate);
        java.time.LocalDate delivery_date = saledate.plusDays(4);
        java.sql.Date expdeldate = java.sql.Date.valueOf(delivery_date);
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO SALESORDERS VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, null);
            stmt.setInt(2, so_buyer_id);
            stmt.setInt(3, 0);
            stmt.setDate(4, orderDate);
            stmt.setString(5, "UNPAID");
            stmt.setString(6, "PROCESSED");
            stmt.setDate(7, expdeldate);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSalesOrderDeliveryDate(int salesord_id, LocalDate delivery_date) {
        Connection con = null;
        java.sql.Date expdeldate = java.sql.Date.valueOf(delivery_date);
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE SALESORDERS SET EXP_DELIVERY_DATE=? WHERE SALESORD_ID=?");
            stmt.setDate(1, expdeldate);
            stmt.setInt(2, salesord_id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void orderStatus(String payment_status, String order_status) {
        SalesOrder salesOrder = new SalesOrder();
        int salesord_id;
        Connection con = null;
        try{
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM SALESORDERS WHERE SALESORD_ID = (SELECT MAX(SALESORD_ID) FROM SALESORDERS)");
            while (rs.next()) {
                salesOrder.setSalesord_id(rs.getInt("SALESORD_ID"));
            }
            salesord_id = salesOrder.getSalesord_id();
            statement.close();
            PreparedStatement stmt = con.prepareStatement("UPDATE SALESORDERS SET PAYMENT_STATUS=? , ORDER_STATUS=? WHERE SALESORD_ID=?");
            stmt.setString(1, payment_status);
            stmt.setString(2, order_status);
            stmt.setInt(3,salesord_id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSalesOrder(int salesord_id) {
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM SALESORDERS WHERE SALESORD_ID=?");
            stmt.setInt(1, salesord_id);
            stmt.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //----------------------------------------------BUYER AND ORDER DETAILS------------------------------------------------------

    public List<OrderDetails> listAllOrderDetails() {
        List<OrderDetails> listProduct = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT B.BUYER_NAME,B.BUYER_ADDRESS, B.BUYER_PHONE_NO , SI.SI_PRODUCT_ID,SI.SI_QUANTITY,SI.SI_UNIT_PRICE,SI.ITEM_TOTAL_PRICE,SO.SALEPRICE,SO.SALEDATE,SO.ORDER_STATUS,SO.PAYMENT_STATUS " +
                    "FROM BUYERS B JOIN " +
                    "     SALESORDERS SO " +
                    "     ON (B.BUYER_ID = SO.SO_BUYER_ID) JOIN " +
                    "     SALESITEM SI " +
                    "     ON (SO.SALESORD_ID = SI.SI_ORDER_ID)");
            while (rs.next()) {
                OrderDetails pd = new OrderDetails();
                pd.setBuyer_name(rs.getString("BUYER_NAME"));
                pd.setBuyer_address(rs.getString("BUYER_ADDRESS"));
                pd.setBuyer_phone_no(rs.getString("BUYER_PHONE_NO"));
                pd.setProduct_id(rs.getInt("SI_PRODUCT_ID"));
                pd.setQuantity(rs.getDouble("SI_QUANTITY"));
                pd.setUnit_price(rs.getDouble("SI_UNIT_PRICE"));
                pd.setTotal_price(rs.getDouble("ITEM_TOTAL_PRICE"));
                pd.setSaleprice(rs.getDouble("SALEPRICE"));
                pd.setSaledate(rs.getDate("SALEDATE").toLocalDate());
                pd.setOrder_status(rs.getString("ORDER_STATUS"));
                pd.setPayment_status(rs.getString("PAYMENT_STATUS"));
                listProduct.add(pd);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }

    // List of Buyers whose payment is pending
    public List<PaymentDetails> paymentDetails() {
        List<PaymentDetails> listPaymentDetails = new ArrayList<>();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT B.BUYER_ID,B.BUYER_NAME,B.BUYER_PHONE_NO ,SO.SALEPRICE,SO.ORDER_STATUS,SO.PAYMENT_STATUS \n" +
                    "FROM BUYERS B JOIN\n" +
                    "    SALESORDERS SO\n" +
                    "    ON B.BUYER_ID = SO.SO_BUYER_ID");
            while (rs.next()) {
                PaymentDetails paymentDetails = new PaymentDetails();
                paymentDetails.setBuyer_id(rs.getInt("BUYER_ID"));
                paymentDetails.setBuyer_name(rs.getString("BUYER_NAME"));
                paymentDetails.setPhone_no(rs.getDouble("BUYER_PHONE_NO"));
                paymentDetails.setSaleprice(rs.getDouble("SALEPRICE"));
                paymentDetails.setOrder_status(rs.getString("ORDER_STATUS"));
                paymentDetails.setPayment_status(rs.getString("PAYMENT_STATUS"));
                listPaymentDetails.add(paymentDetails);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPaymentDetails;

    }

    //To Calculate Profit
    @Override
    public SalesOrder salesProfit(LocalDate start_Date, LocalDate end_Date) {
        SalesOrder salesOrder = new SalesOrder();
        Connection con = null;
        java.sql.Date startDate = java.sql.Date.valueOf(start_Date);
        java.sql.Date endDate = java.sql.Date.valueOf(end_Date);
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT SUM(SALEPRICE) AS SALEPRICE FROM SALESORDERS WHERE SALEDATE BETWEEN  ? AND ?");
            stmt.setDate(1, startDate);
            stmt.setDate(2,endDate);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                salesOrder.setSaleprice(rs.getDouble("SALEPRICE"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesOrder;
    }
}
