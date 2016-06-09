/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

import com.login.LoginBean;
import com.login.LoginBean;
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
@ManagedBean
@RequestScoped
public class ResetPass {

    private String olpassword;
    private String newpassword;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;
    private String Pass;
    private String oldPass;
    private String Role;
    DataConnect bs;

    public String getOlpassword() {
        return olpassword;
    }

    public void setOlpassword(String olpassword) {
        this.olpassword = olpassword;
    }

    public String getNewPassword() {
        return newpassword;
    }

    public void setNewPassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public void reste(String user) {
        Pass(user);
        Role(user);
        int i = 0;
        if (olpassword.equals(Pass.trim())&&!olpassword.equals(newpassword.trim())&&!newpassword.equals(oldPass)) {
            PreparedStatement ps = null;
            Connection con = null;
            try {
                con = bs.getConnection();
                if (con != null) {
                    String sql = "exec changePassword ?,?,?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, user.trim());
                    ps.setString(2, olpassword.trim());
                    ps.setString(3, newpassword.trim());
                    i = ps.executeUpdate();

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
        }  if (i > 0 && Role.equals("a")) {
            FacesMessage msg2 = new FacesMessage("Your password has changed", "INFO MSG");
                        FacesContext.getCurrentInstance().addMessage(null, msg2); 
        } else if (i > 0 && Role.equals("u")) {
            FacesMessage msg2 = new FacesMessage("Your password has changed", "INFO MSG");           
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
            
            
        }else if (i == 0 &&!olpassword.equals(Pass.trim())) {
            FacesMessage msg2 = new FacesMessage("Your current password is wrong!", "ERROR MSG");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
        }
        else if (i == 0 && olpassword.equals(newpassword.trim())) {
            FacesMessage msg2 = new FacesMessage("new password shouldn't be the current password!", "ERROR MSG");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
        }else if (i == 0 && newpassword.equals(oldPass.trim())) {
            FacesMessage msg2 = new FacesMessage("new password shouldn't be the old password!", "ERROR MSG");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
        }
         else {
            FacesMessage msg1 = new FacesMessage("Your current password is wrong!", "ERROR MSG");
            msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg1); 
        }

    }

    public String Pass(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "UserLogin '" + uName + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next();
                    Pass = rs.getString("currentpassword");
                    oldPass=rs.getString("oldpassword");
                    System.out.print(Pass.trim()+oldPass);

                }
                rs.close();
       
            con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }
        return Pass;
    }

    public String Role(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "UserLogin '"+ uName + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next();
                    Role = rs.getString("usertype");
                    System.out.print(Role);

                }
                rs.close();
             con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return Role;
    }

    public static void main(String[] args) {
        ResetPass n = new ResetPass();
        n.Pass("alim");
    }
}
