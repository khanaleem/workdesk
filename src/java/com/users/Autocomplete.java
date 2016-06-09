/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

/**
 *
 * @author DMS
 */
import com.dao.DataConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

@ManagedBean

@SessionScoped

public class Autocomplete {

    private String message;

    public Autocomplete() {

    }

    public List<String> complete(String query) {

                List<String> filteredlist = new ArrayList<String>();
                List<String> list = new ArrayList<String>();
        try {
            Connection con = DataConnect.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("getemail '" + query + "'");
            
            while (rs.next()) {                 
                String email=rs.getString(1);
                list.add(email);
            }
            for (int i = 0; i < list.size(); i++) {
                String skin = list.get(i);
                if (skin.toLowerCase().startsWith(query)) {
                    filteredlist.add(skin);
                }
            }
            System.out.println(filteredlist);
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return filteredlist;

    }

    public String getMessage() {

        return message;

    }

    public void setMessage(String message) {

        this.message = message;

    }

    public static void main(String[] args) {
        Autocomplete n=new Autocomplete();
        n.complete("h");
    }
}
