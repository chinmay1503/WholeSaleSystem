package com.wholesalesystem.services;


import com.wholesalesystem.controllers.ConnectionController;
import com.wholesalesystem.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;

@Service
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        boolean userExists = false;
        String sql = "SELECT COUNT(*) FROM USERS WHERE USERNAME = ? and PASSWORD = ?";
        int rowcount = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, Integer.class);
        if (rowcount == 1) {
            userExists = true;
        }
        return userExists;
    }

    @Override
    public Users getUserDetails(String username, String password) {
        Users user = new Users();
        Connection con = null;
        try {
            ConnectionController cc = new ConnectionController();
            con = cc.newConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user.setUser_id(rs.getInt("USER_ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole_id(rs.getInt("ROLE_ID"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}

