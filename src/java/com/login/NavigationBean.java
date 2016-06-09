package com.login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1520318172495977648L;

	/**
	 * Redirect to login page.
	 * @return Login page name.
	 */
	public String redirectToLogin() {
		return "/login.jsf?faces-redirect=true";
	}
	
	/**
	 * Go to login page.
	 * @return Login page name.
	 */
	public String toLogin() {
		return "/login.jsf";
	}
	
	/**
	 * Redirect to info page.
	 * @return Info page name.
	 */
	public String redirectToUser() {
		return "/user/Welcome.jsf?faces-redirect=true";
	}
	
	/**
	 * Go to info page.
	 * @return Info page name.
	 */
	public String toUser() {
		return "/user/Welcome.jsf";
	}
	
	/**
	 * Redirect to welcome page.
	 * @return Welcome page name.
	 */
	public String redirectToWelcome() {
		return "/admin/welcome.jsf?faces-redirect=true";
	}
	
	/**
	 * Go to welcome page.
	 * @return Welcome page name.
	 */
	public String toWelcome() {
		return "/admin/welcome.jsf";
	}

        public String redirectToWelcomeU() {
		return "/user/Welcome.jsf?faces-redirect=true";
	}

	/**
	 * Go to welcome page.
	 * @return Welcome page name.
	 */
	public String toWelcomeU() {
		return "/user/Welcome.jsf";
	}
         /**
	 * Redirect to Register page.
	 * @return Register page name.
	 */
        
        public String redirectToRegister() {
		return "/admin/register.jsf?faces-redirect=true";
	}
	/**
	 * Go to Register page.
	 * @return Register page name.
	 */
	public String toRegister() {
		return "/admin/register.jsf";
	}
         /**
	 * Redirect to Register page.
	 * @return Register page name.
	 */

        public String redirectToResetpassword() {
		return "/admin/resetpassword.jsf?faces-redirect=true";
	}
	/**
	 * Go to Register page.
	 * @return Register page name.
	 */
	public String toResetpassword() {
		return "/admin/resetpassword.jsf";
	}

         public String redirectToResetpasswordU() {
		return "/user/resetpassword.jsf?faces-redirect=true";
	}
	/**
	 * Go to Register page.
	 * @return Register page name.
	 */
	public String toResetpasswordU() {
		return "/user/resetpassword.jsf";
	}
        
        public String redirectToAP() {
		return "/user/APentry.jsf?faces-redirect=true";
	}
	/**
	 * Go to Register page.
	 * @return Register page name.
	 */
	public String toAP() {
		return "/user/APentry.jsf";
	}
	
}
