/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

/**
 *
 * @author Hriday Dubey
 *
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
import java.sql.PreparedStatement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@RequestScoped
@ApplicationScoped
public class DisputedInvoice {
    
    private long ReceiptID;
    private String InvoiceNo;
    private String VenderName;
    private String Remarks;
    private String region;
    boolean INVD;
    boolean INVNO;
    boolean VNAD;
    boolean CNAD;
    boolean STSBC;
    boolean AI;
    boolean IVMPO;
    boolean NPOCWPC;
    boolean NPONEVC;
    boolean NPOASIN;
    boolean PONOA;
    boolean POR2K;
    boolean POVSIN;
    boolean PANNO;
    boolean STTIN;

    private List<DisputedInvoice> filteredck;

    public List<DisputedInvoice> getFilteredck() {
        return filteredck;
    }

    public void setFilteredAP(List<DisputedInvoice> filteredck) {
        this.filteredck = filteredck;
    }

    public long getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(long ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getVenderName() {
        return VenderName;
    }

    public void setVenderName(String VenderName) {
        this.VenderName = VenderName;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getINVD() {
        if (INVD==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
        
    }
     


    public void setINVD(boolean INVD) {
        this.INVD = INVD;
    }

    public String getINVNO() {
     
        if (INVNO==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setINVNO(boolean INVNO) {
        this.INVNO = INVNO;
    }

    public String getVNAD() {
         
        if (VNAD==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setVNAD(boolean VNAD) {
        this.VNAD = VNAD;
    }

    public String getCNAD() {
          
        if (CNAD==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setCNAD(boolean CNAD) {
        this.CNAD = CNAD;
    }

    public String getSTSBC() {
         
        if (STSBC==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setSTSBC(boolean STSBC) {
        this.STSBC = STSBC;
    }

    public String getAI() {
         
        if (AI==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setAI(boolean AI) {
        this.AI = AI;
    }

    public String getIVMPO() {
      
        if (IVMPO==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setIVMPO(boolean IVMPO) {
        this.IVMPO = IVMPO;
    }

    public String getNPOCWPC() {
        
        if (NPOCWPC==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setNPOCWPC(boolean NPOCWPC) {
        this.NPOCWPC = NPOCWPC;
    }

    public String getNPONEVC() {
         
        if (NPONEVC==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setNPONEVC(boolean NPONEVC) {
        this.NPONEVC = NPONEVC;
    }

    public String getNPOASIN() {
     
        if (NPOASIN==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setNPOASIN(boolean NPOASIN) {
        this.NPOASIN = NPOASIN;
    }

    public String getPONOA() {
         
        if (PONOA==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setPONOA(boolean PONOA) {
        this.PONOA = PONOA;
    }

    public String getPOR2K() {
         
        if (POR2K==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setPOR2K(boolean POR2K) {
        this.POR2K = POR2K;
    }

    public String getPOVSIN() {
         
        if (POVSIN==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setPOVSIN(boolean POVSIN) {
        this.POVSIN = POVSIN;
    }

    public String getPANNO() {
         
        if (PANNO==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setPANNO(boolean PANNO) {
        this.PANNO = PANNO;
    }

    public String getSTTIN() {
         
        if (STTIN==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setSTTIN(boolean STTIN) {
        this.STTIN = STTIN;
    }

    public List<DisputedInvoice> getckData(String user) {
        Region(user);
        List<DisputedInvoice> aplist = new LinkedList<DisputedInvoice>();
        try {
            Connection con = DataConnect.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("inwardcheck '" + region.trim() + "'");
            while (rs.next()) {
                DisputedInvoice ap = new DisputedInvoice();
                ap.setReceiptID(rs.getInt(1));
                ap.setInvoiceNo(rs.getString(2));
                ap.setVenderName(rs.getString(3));                
                ap.setINVD(rs.getBoolean(4));
                ap.setINVNO(rs.getBoolean(5));
                ap.setVNAD(rs.getBoolean(6));
                ap.setCNAD(rs.getBoolean(7));
                ap.setSTSBC(rs.getBoolean(8));
                ap.setAI(rs.getBoolean(9));
                ap.setIVMPO(rs.getBoolean(10));
                ap.setNPOCWPC(rs.getBoolean(11));
                ap.setNPONEVC(rs.getBoolean(12));
                ap.setNPOASIN(rs.getBoolean(13));
                ap.setPONOA(rs.getBoolean(14));
                ap.setPOR2K(rs.getBoolean(15));
                ap.setPOVSIN(rs.getBoolean(16));
                ap.setPANNO(rs.getBoolean(17));
                ap.setSTTIN(rs.getBoolean(18));
                ap.setRemarks(rs.getString(19));
                aplist.add(ap);
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return aplist;
    }

//    public void onRemarksEdit(long ID) {
//        int i = 0;
//        long ReceiptID = ID;
//        PreparedStatement ps = null;
//        Connection con = null;
//        try {
//            con = DataConnect.getConnection();
//
//            String sql = "UPDATE insertap set remarks = '" + Remarks + "' WHERE ReceiptID=" + ReceiptID;
//            ps = con.prepareStatement(sql);
//            i = ps.executeUpdate();
//
////            String to = new InsertAPBeans().SenderEmail(ReceiptID);
////            String message = "<p>Dear User,</p>\n"
////                    + "<p>We have received the submitted invoice and the Receipt ID is <strong>" + ReceiptID + "</strong>.However, it is not yet processed because of the following reason:<br /> Remarks:<strong>" + Remarks + "</strong><br />Please contact respective DMS member and provide the necessary details/supporting documents to DMS. <br /><br /> <span style=\"color: #003366;\">Regards</span>,<br /> <span style=\"color: #003366;\">Ebex BillDesk Team </span></p>\n"
////                    + "<p><br /> <strong>Note</strong>:<span style=\"background-color: #ffff00;\"> Please do not reply to this message via e-mail. This address is automated, unattended, and cannot help with questions or requests</span></p><br/>";
////
////            new SendEmailOffice365().sendEmail(to, "Issue in invoice :" + Remarks + " ", message);
//      con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        if (i > 0) {
//            FacesMessage msg = new FacesMessage("Successfully Added AP", "Email will configure soon");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//
//        } else {
//            FacesMessage msg = new FacesMessage("Error in AP !", "Try again");
//            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//
//        }
//
//    }

     

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

    public static void main(String[] args) {
        InsertAPBeans n = new InsertAPBeans();
        n.ChekAP("000");
    }

}
