/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.login.NavigationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;

import com.dao.DataConnect;
/**
 *
 * @author Hriday Dubey
 */
@ManagedBean(name = "user")
@RequestScoped
public class User {
    private String username;
    private String region;
    private String Role;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private DataSource ds=null;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;
    DataConnect bs;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
     public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public String add() {

        int i = 0;
        if (firstName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            try {
                con = bs.getConnection();
                    if (con != null) {
                        String sql = "exec insertuser ?,?,?,?,?,?,?";
                        ps = con.prepareStatement(sql);
                        username=username.trim();
                        ps.setString(1, username.trim());
                        ps.setString(2, firstName.trim());
                        ps.setString(3, lastName.trim());
                        ps.setString(4, region.trim());
                        ps.setString(5, email.trim());
                        ps.setString(6, Role.trim());
                        ps.setString(7, password.trim());
                        i= ps.executeUpdate();
                        System.out.println(firstName);
                    }
                
            con.close();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (i > 0) {                      
            FacesMessage msg = new FacesMessage("Successfully Added User", "The username is  :-"+username+"");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return navigationBean.redirectToRegister();
        } else
            return navigationBean.redirectToRegister();
    }

    public static void main(String[] args) {
        User n = new User();
        n.add();

    }
}

