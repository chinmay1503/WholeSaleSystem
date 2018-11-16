package com.wholesalesystem.services;

import com.wholesalesystem.data.Users;

import javax.sql.DataSource;

public interface UserService {

    void setDataSource(DataSource dataSource);

    boolean authenticateUser(String username, String password);

    Users getUserDetails(String username, String password);

}
