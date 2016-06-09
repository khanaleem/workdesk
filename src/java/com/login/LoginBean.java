package com.login;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dao.DataConnect;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 7765876811740798583L;
    // Simple user database :)

    private static String username;
    private static String password;
    private  String dbusername;
    private String dbpassword;
    private static String dbrole;
    private boolean loggedIn;
    public String dbuserindex;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;
    DataConnect ds;
 
    Login n=new Login();
   

    public void dbData(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;            
                try {
                    con = ds.getConnection();
                    if (con != null) {
                        String sql = "UserLogin '"+ uName + "'";
                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();
                        rs.next();
                        dbusername = rs.getString("username");
                        dbpassword = rs.getString("currentpassword");
                        System.out.print(dbpassword);
                       
                    }
                    rs.close();
             
            con.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            
        }
            
    }   
    
    public void dbRole(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
                try {
                    con = ds.getConnection();
                    if (con != null) {
                        String sql = "UserLogin '"+ uName + "'";
                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();
                        rs.next();
                        dbusername = rs.getString("username");
                        dbrole = rs.getString("usertype");
                        System.out.print(dbrole);
                        
                    }
                    rs.close();
            
            con.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
        }
    }

    /**
     * Login operation.
     * @return
     */
    public String doLogin() {
        dbData(username);
        dbRole(username);        
        // Successful login
        if(username.equals(dbusername.trim())&& password.equals(dbpassword.trim())&&dbrole.equals("a")){
            loggedIn = true;
//            HttpSession session = SessionBean.getSession();
//            session.setAttribute("username", username);
            return navigationBean.redirectToWelcome();
        }else if(username.equals(dbusername.trim())&& password.equals(dbpassword.trim())&&dbrole.equals("u")){
            loggedIn = true;
//            HttpSession session = SessionBean.getSession();
//            session.setAttribute("username", username);
            return navigationBean.redirectToUser();
        } else{
        // Set login ERROR
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // To to login page
        return navigationBean.toLogin();
        }
    }
    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
//        HttpSession session = SessionBean.getSession();
//        session.invalidate();
        // Set logout message
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return navigationBean.toLogin();
    }
    // ------------------------------
    // Getters & Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public String getDbPassword() {
        return dbusername;
    }
    public String getDbName() {
        return dbpassword;

    }
     public String getDbRole() {
        return dbrole;

    }     
     
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
    
    public static String username(){       
        String user=username;
        return user;
    }
    public static String password(){
        String pass=password;
        return pass;
    }
    public static String Role(){
        String role=dbrole;
        return role;
    }   
    
    public static void main(String[] args) {
        LoginBean n = new LoginBean();
        n.dbRole("dee");
        
    }
    
    
}
