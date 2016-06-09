/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.users;

/**
 *
 * @author DMS
 */
import com.dao.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean; 
import java.util.Arrays;
import java.util.LinkedList;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {

    String Supervoiser;
    String Firstname;
    String Lastname;
    String ImagePath;

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String ImagePath) {
        this.ImagePath = ImagePath;
    }
    

    public String getSupervoiser() {
        return Supervoiser;
    }

    public void setSupervoiser(String Supervoiser) {
        this.Supervoiser = Supervoiser;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }
    
    
    
     public void Supervoiser(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "UsersLogin '" + uName + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next();
                    Supervoiser = rs.getString("firstname"); ;
                    
                    

                }
                rs.close();

                con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }

    public List<CarService> createCars(String Super) {
       
        Supervoiser(Super);
         List<CarService> list = new ArrayList<CarService>();
        try {
            
            Connection con = DataConnect.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from WD_users where Supervoiser='"+Supervoiser+"'");
            while (rs.next()) {
                CarService ap = new CarService();
                ap.setFirstname(rs.getString(3));
                ap.setLastname(rs.getString(4));
                ap.setImagePath(rs.getString(10));
                list.add(ap);
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
          
        return list;
    }

     
}
