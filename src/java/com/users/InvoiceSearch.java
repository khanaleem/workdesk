/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

import com.users.InvoiceSearchBeans;
import com.dao.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Hriday Dubey
 */

public class InvoiceSearch {

    private String region;
    public  ArrayList<InvoiceSearchBeans> getInvData(String user)
    {     Region(user);   
        ArrayList<InvoiceSearchBeans> emplist=new ArrayList<InvoiceSearchBeans>();
        try
        {    boolean found = false;        
            Connection con=DataConnect.getConnection();
            Statement st=con.createStatement();                            
            ResultSet rs=st.executeQuery("Searchinward '"+region+"'");
            while(rs.next())
            {
                InvoiceSearchBeans e=new InvoiceSearchBeans();
                e.setReceiptID(rs.getInt(1));
                e.setInvoiceNumber(rs.getString(2));
                e.setVenderName(rs.getString(3));
                e.setPONumber(rs.getString(4));
                e.setReceivingDate(rs.getDate(5));
                e.setCourierName(rs.getString(7));
                e.setDDSNo(rs.getString(6));
                e.setSenderName(rs.getString(8));
                e.setSenderNo(rs.getString(9));
                e.setAPNo(rs.getString(10));
                emplist.add(e);
                found = true;
            }
           rs.close();
            st.close();
            con.close();
            if (found) {
                return emplist;
            } else {
                return null; // no entires found
            }
        }
        catch(SQLException ex)
        {
            System.out.println("SQL Exception..."+ex.getMessage());
            return (null);
        }
        
    }
     public String Region(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "userlogin '" + uName + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next();
                    region = rs.getString("region");
                    System.out.print(region.trim());

                }
                rs.close(); 
            con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }
        return region;
    }
}
