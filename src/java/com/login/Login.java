package com.login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 
import com.dao.DataConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;
    private String role;
    private String pass;
    private String dbrole;
    private boolean loggedIn;
    private String Region;
    private String dbsession;

    FacesContext fCtx = FacesContext.getCurrentInstance();
    HttpSession session = SessionBean.getSession();
    String sessionId = session.getId();
    
    String ImagePath;

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String ImagePath) {
        this.ImagePath = ImagePath;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }    

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getDbrole() {
        return dbrole;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    //validate login
    public String validateUsernamePassword() throws IOException {
        dbRole(user.trim());          
        boolean valid = LoginDAO.validate(user.trim(), pwd.trim());
        if (valid) { 
             if (dbrole.equals("u")||dbrole.equals("m")) {
                
                 loggedIn=true; 
                session.setAttribute("username", user);
                 
                return "/user/Welcome.jsf?faces-redirect=true";

            } else {
                  loggedIn=true;
                session.setAttribute("username", user);
                return "/admin/welcome.jsf?faces-redirect=true";
            }
             
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    ":login-form:password",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Please enter correct username and Password",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    public String Region(String User) {
        if (User != null) {
            PreparedStatement ps;
            Connection con;
            ResultSet rs;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "UsersLogin '" + User + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next();
                    
                    Region = rs.getString("region");
                    System.out.print(Region.trim());

                }

                con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }
        return Region;
    }

    public String Pass() {
        if (user != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "UsersLogin '" + user + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next(); 
                    pass = rs.getString("current_password");
                    System.out.print(pass);

                }
                rs.close();

                con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return pass;
    }

    public void dbRole(String uName) {
        if(uName != null) {
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
                    dbrole = rs.getString("user_type");
                    ImagePath  = rs.getString("image_path");
                }
                rs.close();

                con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }    
    //logout event, invalidate session
    public String logout() {
        loggedIn=false;
        session.invalidate();
        FacesMessage msg1 = new FacesMessage("Loged Out successfully", "INFO MSG");
        msg1.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg1);
        return "/login.jsf?faces-redirect=true";
    }   
     
 
}
