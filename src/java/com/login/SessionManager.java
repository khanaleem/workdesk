/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author hriday.dubey
 */
public class SessionManager implements HttpSessionBindingListener {

    // All logins.
    private static Map<SessionManager, HttpSession> logins = new HashMap<SessionManager, HttpSession>();

    // Normal properties.
    private Long id;
    private String username;
    // Etc.. Of course with public getters+setters.

    @Override
    public boolean equals(Object other) {
        return (other instanceof SessionManager) && (id != null) ? id.equals(((SessionManager) other).id) : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = logins.remove(this);
        if (session != null) {
            session.invalidate();
        }
        logins.put(this, event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logins.remove(this);
    }

}