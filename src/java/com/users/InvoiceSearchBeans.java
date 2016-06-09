/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

/**
 *
 * @author Hriday Dubey
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.dao.DataConnect;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import com.users.InvoiceSearch;

@ManagedBean(name = "invoiceSearchBeans")
@RequestScoped
@ApplicationScoped
public class InvoiceSearchBeans {   
    
   private long ReceiptID;
    private String InvoiceNumber;
    private String VenderName;
    private String PONumber;    
    private Date ReceivingDate;
    private String CourierName;
    private String DDSNo;
    private String SenderName;
    private String SenderNo;
    private String APNo;

    public String getPONumber() {
        return PONumber;
    }

    public void setPONumber(String PONumber) {
        this.PONumber = PONumber;
    }
    

    public long getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(long ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public String getVenderName() {
        return VenderName;
    }

    public void setVenderName(String VenderName) {
        this.VenderName = VenderName;
    }
   
    public Date getReceivingDate() {
        return ReceivingDate;
    }

    public void setReceivingDate(Date ReceivingDate) {
        this.ReceivingDate = ReceivingDate;
    }

    public String getCourierName() {
        return CourierName;
    }

    public void setCourierName(String CourierName) {
        this.CourierName = CourierName;
    }

    public String getDDSNo() {
        return DDSNo;
    }

    public void setDDSNo(String DDSNo) {
        this.DDSNo = DDSNo;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String SenderName) {
        this.SenderName = SenderName;
    }

    public String getSenderNo() {
        return SenderNo;
    }

    public void setSenderNo(String SenderNo) {
        this.SenderNo = SenderNo;
    }

    
    
    public String getAPNo() {
        return APNo;
    }

    public void setAPNo(String APNo) {
        this.APNo = APNo;
    }
    
    public ArrayList<InvoiceSearchBeans> getMessages(String Muser) {
        return new InvoiceSearch().getInvData(Muser);
    }
       
}