///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.users;
//
//import com.dao.DataConnect;
//import java.io.Serializable;
//import java.sql.Connection;
//import java.util.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import org.primefaces.event.FlowEvent;
//
///**
// *
// * @author Hriday Dubey
// */
//@ManagedBean
//@ViewScoped
//public class InvoiceEntry implements Serializable{
//
//    Date ReciDate= new Date();
//    String DelMethod;   
//    String DDSNo=null;
//    String PageNo=null;
//    Date DDDate= new Date();  
//    String CourierName=null;
//    String CourierNo=null;
//    Date CourierDate= new Date();   
//    String SenderName=null;
//    String SenderEmail=null; 
//    String SenderMo=null;
////  String SenderMo=null; 
//    String SenderEK=null;
//    String DocType=null;     
//    String InvoiceType=null;    
//    String ComName=null;    
//    String InvoiceNo;
//    String NoOfInvoice=null;   
//    Date InvoiceDate=new Date();
//     String venderName;
//    String PoCategory=null;
//     String PONo;
//    String billAmount=null;
//   String Costcenter=null; 
//   String CostcenterNo=null;
//   String Remarks=null;
//    
////   boolean INVD;
////   boolean INVNO;
////   boolean VNAD;
////   boolean CNAD;
////   boolean STSBC;
////   boolean AI ;
////   boolean IVMPO;
////   boolean NPOCWPC;
////   boolean NPONEVC;
////   boolean NPOASIN;
////   boolean PONOA;
////   boolean POR2K;
////   boolean POVSIN;
////   boolean PANNO;
////   boolean STTIN;
//   
//   String INVD;
//   String INVNO;
//   String VNAD;
//   String CNAD;
//   String STSBC;
//   String AI ;
//   String IVMPO;
//   String NPOCWPC;
//   String NPONEVC;
//   String NPOASIN;
//   String PONOA;
//   String POR2K;
//   String POVSIN;
//   String PANNO;
//   String STTIN;
//   
//    
//     
//    private String CheckVender;
//    private String region;
//    private boolean skip;
//    private Date currentDate = new Date();
//
////    public boolean isINVD() {
////        return INVD;
////    }
////
////    public void setINVD(boolean INVD) {
////        this.INVD = INVD;
////    }
////
////    public boolean isINVNO() {
////        return INVNO;
////    }
////
////    public void setINVNO(boolean INVNO) {
////        this.INVNO = INVNO;
////    }
////
////    public boolean isVNAD() {
////        return VNAD;
////    }
////
////    public void setVNAD(boolean VNAD) {
////        this.VNAD = VNAD;
////    }
////
////    public boolean isCNAD() {
////        return CNAD;
////    }
////
////    public void setCNAD(boolean CNAD) {
////        this.CNAD = CNAD;
////    }
////
////    public boolean isSTSBC() {
////        return STSBC;
////    }
////
////    public void setSTSBC(boolean STSBC) {
////        this.STSBC = STSBC;
////    }
////
////    public boolean isAI() {
////        return AI;
////    }
////
////    public void setAI(boolean AI) {
////        this.AI = AI;
////    }
////
////    public boolean isIVMPO() {
////        return IVMPO;
////    }
////
////    public void setIVMPO(boolean IVMPO) {
////        this.IVMPO = IVMPO;
////    }
////
////    public boolean isNPOCWPC() {
////        return NPOCWPC;
////    }
////
////    public void setNPOCWPC(boolean NPOCWPC) {
////        this.NPOCWPC = NPOCWPC;
////    }
////
////    public boolean isNPONEVC() {
////        return NPONEVC;
////    }
////
////    public void setNPONEVC(boolean NPONEVC) {
////        this.NPONEVC = NPONEVC;
////    }
////
////    public boolean isNPOASIN() {
////        return NPOASIN;
////    }
////
////    public void setNPOASIN(boolean NPOASIN) {
////        this.NPOASIN = NPOASIN;
////    }
////
////    public boolean isPONOA() {
////        return PONOA;
////    }
////
////    public void setPONOA(boolean PONOA) {
////        this.PONOA = PONOA;
////    }
////
////    public boolean isPOR2K() {
////        return POR2K;
////    }
////
////    public void setPOR2K(boolean POR2K) {
////        this.POR2K = POR2K;
////    }
////
////    public boolean isPOVSIN() {
////        return POVSIN;
////    }
////
////    public void setPOVSIN(boolean POVSIN) {
////        this.POVSIN = POVSIN;
////    }
////
////    public boolean isPANNO() {
////        return PANNO;
////    }
////
////    public void setPANNO(boolean PANNO) {
////        this.PANNO = PANNO;
////    }
////
////    public boolean isSTTIN() {
////        return STTIN;
////    }
////
////    public void setSTTIN(boolean STTIN) {
////        this.STTIN = STTIN;
////    }
//    
//   String True="\u2714";
//
//    public String getTrue() {
//        return True;
//    }
//
//    public void setTrue(String True) {
//        this.True = True;
//    }
//   
//   
//
//    public String getINVD() {
//        if (INVD=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//        
//    }
//     
//
//
//    
//
//    public String getINVNO() {
//     
//        if (INVNO=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//    public String getVNAD() {
//         
//        if (VNAD=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//
//    public String getCNAD() {
//          
//        if (CNAD=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//   
//
//    public String getSTSBC() {
//         
//        if (STSBC=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
// 
//
//    public String getAI() {
//         
//        if (AI=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//    public String getIVMPO() {
//      
//        if (IVMPO=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//
//    public String getNPOCWPC() {
//        
//        if (NPOCWPC=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//   
//
//    public String getNPONEVC() {
//         
//        if (NPONEVC=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//
//    public String getNPOASIN() {
//     
//        if (NPOASIN=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//
//    public String getPONOA() {
//         
//        if (PONOA=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//
//    public String getPOR2K() {
//         
//        if (POR2K=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//
//    public String getPOVSIN() {
//         
//        if (POVSIN=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//   
//
//    public String getPANNO() {
//         
//        if (PANNO=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//
//    
//
//    public String getSTTIN() {
//         
//        if (STTIN=="true"){
//            return "\u2714";
//        }else{
//            return "\u2716";
//        }
//    }
//    
//    
//    public void setINVD(String INVD) {
//        this.INVD = INVD;
//    }
//
//    public void setINVNO(String INVNO) {
//        this.INVNO = INVNO;
//    }
//
//    public void setVNAD(String VNAD) {
//        this.VNAD = VNAD;
//    }
//
//    public void setCNAD(String CNAD) {
//        this.CNAD = CNAD;
//    }
//
//    public void setSTSBC(String STSBC) {
//        this.STSBC = STSBC;
//    }
//
//    public void setAI(String AI) {
//        this.AI = AI;
//    }
//
//    public void setIVMPO(String IVMPO) {
//        this.IVMPO = IVMPO;
//    }
//
//    public void setNPOCWPC(String NPOCWPC) {
//        this.NPOCWPC = NPOCWPC;
//    }
//
//    public void setNPONEVC(String NPONEVC) {
//        this.NPONEVC = NPONEVC;
//    }
//
//    public void setNPOASIN(String NPOASIN) {
//        this.NPOASIN = NPOASIN;
//    }
//
//    public void setPONOA(String PONOA) {
//        this.PONOA = PONOA;
//    }
//
//    public void setPOR2K(String POR2K) {
//        this.POR2K = POR2K;
//    }
//
//    public void setPOVSIN(String POVSIN) {
//        this.POVSIN = POVSIN;
//    }
//
//    public void setPANNO(String PANNO) {
//        this.PANNO = PANNO;
//    }
//
//    public void setSTTIN(String STTIN) {
//        this.STTIN = STTIN;
//    }
//
//    
//    
//    
//
//    
//    public Date getDDDate() {
//        return DDDate;
//    }
//
//    public void setDDDate(Date DDDate) {
//        this.DDDate = DDDate;
//    }
//    
//    
//
//   
//
//    public Date getCourierDate() {
//        return CourierDate;
//    }
//
//    public void setCourierDate(Date CourierDate) {
//        this.CourierDate = CourierDate;
//    }
//
//    public String getSenderMo() {
//        return SenderMo;
//    }
//
//    public void setSenderMo(String SenderMo) {
//        this.SenderMo = SenderMo;
//    }
//
//    public String getSenderEK() {
//        return SenderEK;
//    }
//
//    public void setSenderEK(String SenderEK) {
//        this.SenderEK = SenderEK;
//    }
//
//    
//
//    
//
//    public String getDocType() {
//        return DocType;
//    }
//
//    public void setDocType(String DocType) {
//        this.DocType = DocType;
//    }
//
//    public String getCostcenterNo() {
//        return CostcenterNo;
//    }
//
//    public void setCostcenterNo(String CostcenterNo) {
//        this.CostcenterNo = CostcenterNo;
//    }
//
//    public String getRemarks() {
//        return Remarks;
//    }
//
//    public void setRemarks(String Remarks) {
//        this.Remarks = Remarks;
//    }
//    
//    
//     public String getNoOfInvoice() {
//        return NoOfInvoice;
//    }
//
//    public void setNoOfInvoice(String NoOfInvoice) {
//        this.NoOfInvoice = NoOfInvoice;
//    }
//
//    public Date getCurrentDate() {
//
//    return currentDate;
//    }
//     public void setCurrentDate(Date currentDate) {
//        this.currentDate = currentDate;
//    }
//
//    public String getComName() {
//        return ComName;
//    }
//
//    public void setComName(String ComName) {
//        this.ComName = ComName;
//    }
//
//    public String getCourierName() {
//        return CourierName;
//    }
//
//    public void setCourierName(String CourierName) {
//        this.CourierName = CourierName;
//    }
//
//    public String getCourierNo() {
//        return CourierNo;
//    }
//
//    public void setCourierNo(String CourierNo) {
//        this.CourierNo = CourierNo;
//    }
//
//    public String getDDSNo() {
//        return DDSNo;
//    }
//
//    public void setDDSNo(String DDSNo) {
//        this.DDSNo = DDSNo;
//    }
//
//    public String getDelMethod() {
//        return DelMethod;
//    }
//
//    public void setDelMethod(String DelMethod) {
//        this.DelMethod = DelMethod;
//    }
//
//    public Date getInvoiceDate() {
//        return InvoiceDate;
//    }
//
//    public void setInvoiceDate(Date InvoiceDate) {
//        this.InvoiceDate = InvoiceDate;
//    }
//
//    public String getInvoiceNo() {
//        return InvoiceNo;
//    }
//
//    public void setInvoiceNo(String InvoiceNo) {
//        this.InvoiceNo = InvoiceNo;
//    }
//
//    public String getPONo() {
//        return PONo;
//    }
//
//    public void setPONo(String PONo) {
//        this.PONo = PONo;
//    }
//
//    public String getPoCategory() {
//        return PoCategory;
//    }
//
//    public void setPoCategory(String PoCategory) {
//        this.PoCategory = PoCategory;
//    }
//
//
//    public String getPageNo() {
//        return PageNo;
//    }
//
//    public void setPageNo(String PageNo) {
//        this.PageNo = PageNo;
//    }
//
//    public Date getReciDate() {
//        return ReciDate;
//    }
//
//    public void setReciDate(Date ReciDate) {
//        this.ReciDate = ReciDate;
//    }
//
//   
//
//    public String getSenderEmail() {
//        return SenderEmail;
//    }
//
//    public void setSenderEmail(String SenderEmail) {
//        this.SenderEmail = SenderEmail;
//    }
//
//    public String getSenderName() {
//        return SenderName;
//    }
//
//    public void setSenderName(String SenderName) {
//        this.SenderName = SenderName;
//    }
//
//    public String getBillAmount() {
//        return billAmount;
//    }
//
//    public void setBillAmount(String billAmount) {
//        this.billAmount = billAmount;
//    }
//
//    public String getVenderName() {
//        return venderName;
//    }
//
//    public void setVenderName(String venderName) {
//        this.venderName = venderName;
//    }
//
//    public String getCostcenter() {
//        return Costcenter;
//    }
//
//    public void setCostcenter(String Costcenter) {
//        this.Costcenter = Costcenter;
//    }
//
//    public String getInvoiceType() {
//        return InvoiceType;
//    }
//
//    public void setInvoiceType(String InvoiceType) {
//        this.InvoiceType = InvoiceType;
//    }
//
//    public String getCheckVender() {
//        return CheckVender;
//    }
//
//    public void setCheckVender(String CheckVender) {
//        this.CheckVender = CheckVender;
//    }
//    
//    
//    
//    
//public  String saven(String user) {
//    int i = 0;  
//    Region(user);
//    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//    String IDate=format.format(InvoiceDate);  
//    String DDate=format.format(DDDate); 
//    String CDate=format.format(CourierDate);
//          if (InvoiceNo != null) {           
//          String Check=new InvoiceEntry().CheckInvoice(InvoiceNo.toUpperCase(),venderName.toUpperCase());
//           if (InvoiceNo.toUpperCase().equals(Check)) {
//               
//               FacesMessage msg1 = new FacesMessage("The Invoice No : "+ InvoiceNo+" is Already exist against Vendor Name : "+venderName+"","Please Contact to vendor");
//               msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
//               FacesContext.getCurrentInstance().addMessage(null, msg1);
//               return "/user/Bill Entry.jsf";               
//               
//           }else{
//               
//               PreparedStatement ps = null;
//               Connection con = null;
//            try {
//                con = DataConnect.getConnection();
//                    if (con != null) {
//                        String sql = "exec insertinvoiceentry ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
//                        ps = con.prepareStatement(sql);
//                        ps.setString(1, InvoiceNo.toUpperCase());
//                        ps.setString(2, venderName.toUpperCase());
//                        ps.setString(3, IDate);
//                        ps.setString(4, billAmount);
//                        ps.setString(5, PoCategory );
//                        ps.setString(6, PONo);
//                        ps.setString(7, ComName );
//                        ps.setString(8, PageNo);
//                        ps.setString(9, DelMethod);
//                        ps.setString(10, DDSNo);
//                        ps.setString(11, CourierName);
//                        ps.setString(12, CourierNo);
//                        ps.setString(13, SenderName);
//                        ps.setString(14,SenderMo);
//                        ps.setString(15, SenderEmail);
//                        ps.setString(16, NoOfInvoice);
//                        ps.setString(17, Costcenter );
//                        ps.setString(18, InvoiceType );
//                        ps.setString(19, region );
//                        ps.setString(20, DDate);
//                        ps.setString(21, CDate);
//                        ps.setString(22,SenderEK);
//                        ps.setString(23, CostcenterNo);
//                        ps.setString(24, DocType);
//                        ps.setString(25, Remarks);
//                        ps.setString(26, INVD);
//                        ps.setString(27, INVNO);
//                        ps.setString(28, VNAD);
//                        ps.setString(29, CNAD);
//                        ps.setString(30,STSBC);
//                        ps.setString(31, AI);
//                        ps.setString(32, IVMPO);
//                        ps.setString(33,NPOCWPC);
//                        ps.setString(34, NPONEVC);
//                        ps.setString(35, NPOASIN);
//                        ps.setString(36,  PONOA);
//                        ps.setString(37,  POR2K);
//                        ps.setString(38, POVSIN);
//                        ps.setString(39, PANNO);
//                        ps.setString(40, STTIN);
//                        i= ps.executeUpdate();
//                        System.out.println(InvoiceDate);
//                    }
//                 
//            con.close();
//            } catch (Exception e) {
//                System.out.println(e);
//            } 
//            
//            
//        }
//            
//        }
//        if (i > 0) {
//            FacesMessage msg = new FacesMessage("Successfully Added invoice", "Enter New Invoice");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//            return "/user/Bill Entry.jsf";
//        } else{
//            FacesMessage msg = new FacesMessage("Error in Adding invoice!", "Try again");
//            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//            return "/user/Bill Entry.jsf";
//        }
//    } 
//
//public  String save(String user) {
//    int i = 0;  
//    Region(user);
//    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//    String IDate=format.format(InvoiceDate);    
//          if (InvoiceNo != null) {           
//          String Check=new InvoiceEntry().CheckInvoice(InvoiceNo,venderName);
//           if (InvoiceNo.equals(Check)) {
//               
//               FacesMessage msg1 = new FacesMessage("The Invoice No : "+ InvoiceNo+" is Already exist against Vendor Name : "+venderName+"","Please Contact to vendor");
//               msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
//               FacesContext.getCurrentInstance().addMessage(null, msg1);
//               return "/user/Bill Entry.jsf";               
//               
//           }else{
//               
//               PreparedStatement ps = null;
//               Connection con = null;
//            try {
//                con = DataConnect.getConnection();
//                    if (con != null) {
//                        String sql = "exec insertinvoiceentry ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
//                        ps = con.prepareStatement(sql);
//                        ps.setString(1, InvoiceNo.toUpperCase());
//                        ps.setString(2, venderName.toUpperCase());
//                        ps.setString(3, IDate);
//                        ps.setString(4, billAmount);
//                        ps.setString(5, PoCategory.trim());
//                        ps.setString(6, PONo);
//                        ps.setString(7, ComName.trim());
//                        ps.setString(8, PageNo);
//                        ps.setString(9, DelMethod.trim());
//                        ps.setString(10, DDSNo);
//                        ps.setString(11, CourierName);
//                        ps.setString(12, CourierNo);
//                        ps.setString(13, SenderName.trim());
//                        ps.setString(14, SenderMo);
//                        ps.setString(15, SenderEmail.trim());
//                        ps.setString(16, NoOfInvoice);
//                        ps.setString(17, Costcenter.trim());
//                        ps.setString(18, InvoiceType.trim());
//                        ps.setString(19, region.trim());
//                        i= ps.executeUpdate();
//                        System.out.println(InvoiceDate);
//                    }
//                
//            con.close();
//            } catch (Exception e) {
//                System.out.println(e);
//            } 
//            
//            
//        }
//            
//        }
//        if (i > 0) {
//            FacesMessage msg = new FacesMessage("Successfully Added invoice", "Enter New Invoice");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//            return "/user/Bill Entry.jsf";
//        } else{
//            FacesMessage msg = new FacesMessage("Error in Adding invoice!", "Try again");
//            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//            return "/user/Bill Entry.jsf";
//        }
//    }
//
//    public boolean isSkip() {
//        return skip;
//    }
//
//    public void setSkip(boolean skip) {
//        this.skip = skip;
//    }
//
//    public String onFlowProcess(FlowEvent event) {
//        if(skip) {
//            skip = false;   //reset in case user goes back
//            return "confirm";
//        }
//        else {
//            return event.getNewStep();
//        }
//        
//        
//    }
//    
//     public String CheckInvoice(String InvoiceNo,String vendor) {
//        
//            PreparedStatement ps = null;
//            Connection con = null;
//            ResultSet rs = null;            
//                try {
//                    con = DataConnect.getConnection();
//                    if (con != null) {
//                        String sql = "select * from invoicedetail where vendorname = '"+ vendor + "' and invoicenumber='"+InvoiceNo+"'";
//                        ps = con.prepareStatement(sql);
//                        rs = ps.executeQuery();
//                        rs.next();                       
//                       CheckVender = rs.getString("invoicenumber");
//                       System.out.print(CheckVender);
//                       
//                    }
//                    rs.close();
//             
//            con.close();
//                } catch (SQLException sqle) {
//                    sqle.printStackTrace();
//                }            
//                           
//        
//      return CheckVender;      
//    } 
//     
//     public String Region(String uName) {
//        if (uName != null) {
//            PreparedStatement ps = null;
//            Connection con = null;
//            ResultSet rs = null;
//            try {
//                con = DataConnect.getConnection();
//                if (con != null) {
//                    String sql = "select * from Users a inner join password b on a.userindex=b.userindex where username = '" + uName + "'";
//                    ps = con.prepareStatement(sql);
//                    rs = ps.executeQuery();
//                    rs.next();
//                    region = rs.getString("region");
//                    System.out.print(region.trim());
//
//                }
//                rs.close();
//           
//            con.close();
//            } catch (SQLException sqle) {
//                sqle.printStackTrace();
//            }
//
//        }
//        return region;
//    }
//     
//     
//     
//    public static void main(String[] args) {
//        InvoiceEntry n=new InvoiceEntry();
//        n.saven("dee");
//        
//    }
//
//    void setReceiptID(int aInt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
// 
//
//}
//
//
///*
//// * To change this template, choose Tools | Templates
//// * and open the template in the editor.
//// */
////
////package com.users;
////
////import com.dao.DataConnect;
////import java.io.Serializable;
////import java.sql.Connection;
////import java.util.Date;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.text.SimpleDateFormat;
////import javax.faces.application.FacesMessage;
////import javax.faces.bean.ManagedBean;
////import javax.faces.bean.ViewScoped;
////import javax.faces.context.FacesContext;
////import org.primefaces.event.FlowEvent;
////
/////**
//// *
//// * @author Hriday Dubey
//// */
////@ManagedBean
////@ViewScoped
////public class InvoiceEntry implements Serializable{
////
////    Date ReciDate= new Date();
////    String DelMethod;   
////    String DDSNo=null;
////    String PageNo=null;
////    Date DDDate= new Date();  
////    String CourierName=null;
////    String CourierNo=null;
////    Date CourierDate= new Date();   
////    String SenderName=null;
////    String SenderEmail=null; 
////    String SenderMo=null;
//////  String SenderMo=null; 
////    String SenderEK=null;
////    String DocType=null;     
////    String InvoiceType=null;    
////    String ComName=null;    
////    String InvoiceNo;
////    String NoOfInvoice=null;   
////    Date InvoiceDate=new Date();
////     String venderName;
////    String PoCategory=null;
////     String PONo;
////    String billAmount=null;
////   String Costcenter=null; 
////   String CostcenterNo=null;
////   String Remarks=null;
////    
////   boolean INVD;
////   boolean INVNO;
////   boolean VNAD;
////   boolean CNAD;
////   boolean STSBC;
////   boolean AI ;
////   boolean IVMPO;
////   boolean NPOCWPC;
////   boolean NPONEVC;
////   boolean NPOASIN;
////   boolean PONOA;
////   boolean POR2K;
////   boolean POVSIN;
////   boolean PANNO;
////   boolean STTIN;
////   
////    
////     
////    private String CheckVender;
////    private String region;
////    private boolean skip;
////    private Date currentDate = new Date();
////
////    public boolean isINVD() {
////        return INVD;
////    }
////
////    public void setINVD(boolean INVD) {
////        this.INVD = INVD;
////    }
////
////    public boolean isINVNO() {
////        return INVNO;
////    }
////
////    public void setINVNO(boolean INVNO) {
////        this.INVNO = INVNO;
////    }
////
////    public boolean isVNAD() {
////        return VNAD;
////    }
////
////    public void setVNAD(boolean VNAD) {
////        this.VNAD = VNAD;
////    }
////
////    public boolean isCNAD() {
////        return CNAD;
////    }
////
////    public void setCNAD(boolean CNAD) {
////        this.CNAD = CNAD;
////    }
////
////    public boolean isSTSBC() {
////        return STSBC;
////    }
////
////    public void setSTSBC(boolean STSBC) {
////        this.STSBC = STSBC;
////    }
////
////    public boolean isAI() {
////        return AI;
////    }
////
////    public void setAI(boolean AI) {
////        this.AI = AI;
////    }
////
////    public boolean isIVMPO() {
////        return IVMPO;
////    }
////
////    public void setIVMPO(boolean IVMPO) {
////        this.IVMPO = IVMPO;
////    }
////
////    public boolean isNPOCWPC() {
////        return NPOCWPC;
////    }
////
////    public void setNPOCWPC(boolean NPOCWPC) {
////        this.NPOCWPC = NPOCWPC;
////    }
////
////    public boolean isNPONEVC() {
////        return NPONEVC;
////    }
////
////    public void setNPONEVC(boolean NPONEVC) {
////        this.NPONEVC = NPONEVC;
////    }
////
////    public boolean isNPOASIN() {
////        return NPOASIN;
////    }
////
////    public void setNPOASIN(boolean NPOASIN) {
////        this.NPOASIN = NPOASIN;
////    }
////
////    public boolean isPONOA() {
////        return PONOA;
////    }
////
////    public void setPONOA(boolean PONOA) {
////        this.PONOA = PONOA;
////    }
////
////    public boolean isPOR2K() {
////        return POR2K;
////    }
////
////    public void setPOR2K(boolean POR2K) {
////        this.POR2K = POR2K;
////    }
////
////    public boolean isPOVSIN() {
////        return POVSIN;
////    }
////
////    public void setPOVSIN(boolean POVSIN) {
////        this.POVSIN = POVSIN;
////    }
////
////    public boolean isPANNO() {
////        return PANNO;
////    }
////
////    public void setPANNO(boolean PANNO) {
////        this.PANNO = PANNO;
////    }
////
////    public boolean isSTTIN() {
////        return STTIN;
////    }
////
////    public void setSTTIN(boolean STTIN) {
////        this.STTIN = STTIN;
////    }
////
////    
////    public Date getDDDate() {
////        return DDDate;
////    }
////
////    public void setDDDate(Date DDDate) {
////        this.DDDate = DDDate;
////    }
////    
////    
////
////   
////
////    public Date getCourierDate() {
////        return CourierDate;
////    }
////
////    public void setCourierDate(Date CourierDate) {
////        this.CourierDate = CourierDate;
////    }
////
////    public String getSenderMo() {
////        return SenderMo;
////    }
////
////    public void setSenderMo(String SenderMo) {
////        this.SenderMo = SenderMo;
////    }
////
////    public String getSenderEK() {
////        return SenderEK;
////    }
////
////    public void setSenderEK(String SenderEK) {
////        this.SenderEK = SenderEK;
////    }
////
////    
////
////    
////
////    public String getDocType() {
////        return DocType;
////    }
////
////    public void setDocType(String DocType) {
////        this.DocType = DocType;
////    }
////
////    public String getCostcenterNo() {
////        return CostcenterNo;
////    }
////
////    public void setCostcenterNo(String CostcenterNo) {
////        this.CostcenterNo = CostcenterNo;
////    }
////
////    public String getRemarks() {
////        return Remarks;
////    }
////
////    public void setRemarks(String Remarks) {
////        this.Remarks = Remarks;
////    }
////    
////    
////     public String getNoOfInvoice() {
////        return NoOfInvoice;
////    }
////
////    public void setNoOfInvoice(String NoOfInvoice) {
////        this.NoOfInvoice = NoOfInvoice;
////    }
////
////    public Date getCurrentDate() {
////
////    return currentDate;
////    }
////     public void setCurrentDate(Date currentDate) {
////        this.currentDate = currentDate;
////    }
////
////    public String getComName() {
////        return ComName;
////    }
////
////    public void setComName(String ComName) {
////        this.ComName = ComName;
////    }
////
////    public String getCourierName() {
////        return CourierName;
////    }
////
////    public void setCourierName(String CourierName) {
////        this.CourierName = CourierName;
////    }
////
////    public String getCourierNo() {
////        return CourierNo;
////    }
////
////    public void setCourierNo(String CourierNo) {
////        this.CourierNo = CourierNo;
////    }
////
////    public String getDDSNo() {
////        return DDSNo;
////    }
////
////    public void setDDSNo(String DDSNo) {
////        this.DDSNo = DDSNo;
////    }
////
////    public String getDelMethod() {
////        return DelMethod;
////    }
////
////    public void setDelMethod(String DelMethod) {
////        this.DelMethod = DelMethod;
////    }
////
////    public Date getInvoiceDate() {
////        return InvoiceDate;
////    }
////
////    public void setInvoiceDate(Date InvoiceDate) {
////        this.InvoiceDate = InvoiceDate;
////    }
////
////    public String getInvoiceNo() {
////        return InvoiceNo;
////    }
////
////    public void setInvoiceNo(String InvoiceNo) {
////        this.InvoiceNo = InvoiceNo;
////    }
////
////    public String getPONo() {
////        return PONo;
////    }
////
////    public void setPONo(String PONo) {
////        this.PONo = PONo;
////    }
////
////    public String getPoCategory() {
////        return PoCategory;
////    }
////
////    public void setPoCategory(String PoCategory) {
////        this.PoCategory = PoCategory;
////    }
////
////
////    public String getPageNo() {
////        return PageNo;
////    }
////
////    public void setPageNo(String PageNo) {
////        this.PageNo = PageNo;
////    }
////
////    public Date getReciDate() {
////        return ReciDate;
////    }
////
////    public void setReciDate(Date ReciDate) {
////        this.ReciDate = ReciDate;
////    }
////
////   
////
////    public String getSenderEmail() {
////        return SenderEmail;
////    }
////
////    public void setSenderEmail(String SenderEmail) {
////        this.SenderEmail = SenderEmail;
////    }
////
////    public String getSenderName() {
////        return SenderName;
////    }
////
////    public void setSenderName(String SenderName) {
////        this.SenderName = SenderName;
////    }
////
////    public String getBillAmount() {
////        return billAmount;
////    }
////
////    public void setBillAmount(String billAmount) {
////        this.billAmount = billAmount;
////    }
////
////    public String getVenderName() {
////        return venderName;
////    }
////
////    public void setVenderName(String venderName) {
////        this.venderName = venderName;
////    }
////
////    public String getCostcenter() {
////        return Costcenter;
////    }
////
////    public void setCostcenter(String Costcenter) {
////        this.Costcenter = Costcenter;
////    }
////
////    public String getInvoiceType() {
////        return InvoiceType;
////    }
////
////    public void setInvoiceType(String InvoiceType) {
////        this.InvoiceType = InvoiceType;
////    }
////
////    public String getCheckVender() {
////        return CheckVender;
////    }
////
////    public void setCheckVender(String CheckVender) {
////        this.CheckVender = CheckVender;
////    }
////    
////    
////    
////    
////public  String saven(String user) {
////    int i = 0;  
////    Region(user);
////    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
////    String IDate=format.format(InvoiceDate);  
////    String DDate=format.format(DDDate); 
////    String CDate=format.format(CourierDate);
////          if (InvoiceNo != null) {           
////          String Check=new InvoiceEntry().CheckInvoice(InvoiceNo,venderName);
////           if (InvoiceNo.equals(Check)) {
////               
////               FacesMessage msg1 = new FacesMessage("The Invoice No : "+ InvoiceNo+" is Already exist against Vendor Name : "+venderName+"","Please Contact to vendor");
////               msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
////               FacesContext.getCurrentInstance().addMessage(null, msg1);
////               return "/user/Bill Entry.jsf";               
////               
////           }else{
////               
////               PreparedStatement ps = null;
////               Connection con = null;
////            try {
////                con = DataConnect.getConnection();
////                    if (con != null) {
////                        String sql = "exec insertinvoiceentry ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
////                        ps = con.prepareStatement(sql);
////                        ps.setString(1, InvoiceNo.toUpperCase());
////                        ps.setString(2, venderName.toUpperCase());
////                        ps.setString(3, IDate);
////                        ps.setString(4, billAmount);
////                        ps.setString(5, PoCategory );
////                        ps.setString(6, PONo);
////                        ps.setString(7, ComName );
////                        ps.setString(8, PageNo);
////                        ps.setString(9, DelMethod);
////                        ps.setString(10, DDSNo);
////                        ps.setString(11, CourierName);
////                        ps.setString(12, CourierNo);
////                        ps.setString(13, SenderName);
////                        ps.setString(14,SenderMo);
////                        ps.setString(15, SenderEmail);
////                        ps.setString(16, NoOfInvoice);
////                        ps.setString(17, Costcenter );
////                        ps.setString(18, InvoiceType );
////                        ps.setString(19, region );
////                        ps.setString(20, DDate);
////                        ps.setString(21, CDate);
////                        ps.setString(22,SenderEK);
////                        ps.setString(23, CostcenterNo);
////                        ps.setString(24, DocType);
////                        ps.setString(25, Remarks);
////                        ps.setBoolean(26, INVD);
////                        ps.setBoolean(27, INVNO);
////                        ps.setBoolean(28, VNAD);
////                        ps.setBoolean(29, CNAD);
////                        ps.setBoolean(30,STSBC);
////                        ps.setBoolean(31, AI);
////                        ps.setBoolean(32, IVMPO);
////                        ps.setBoolean(33,NPOCWPC);
////                        ps.setBoolean(34, NPONEVC);
////                        ps.setBoolean(35, NPOASIN);
////                        ps.setBoolean(36,  PONOA);
////                        ps.setBoolean(37,  POR2K);
////                        ps.setBoolean(38, POVSIN);
////                        ps.setBoolean(39, PANNO);
////                        ps.setBoolean(40, STTIN);
////                        i= ps.executeUpdate();
////                        System.out.println(InvoiceDate);
////                    }
////                
////            } catch (Exception e) {
////                System.out.println(e);
////            } 
////            
////            
////        }
////            
////        }
////        if (i > 0) {
////            FacesMessage msg = new FacesMessage("Successfully Added invoice", "Enter New Invoice");
////            FacesContext.getCurrentInstance().addMessage(null, msg);
////            return "/user/Bill Entry.jsf";
////        } else{
////            FacesMessage msg = new FacesMessage("Error in Adding invoice!", "Try again");
////            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
////            FacesContext.getCurrentInstance().addMessage(null, msg);
////            return "/user/Bill Entry.jsf";
////        }
////    } 
////
////public  String save(String user) {
////    int i = 0;  
////    Region(user);
////    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
////    String IDate=format.format(InvoiceDate);    
////          if (InvoiceNo != null) {           
////          String Check=new InvoiceEntry().CheckInvoice(InvoiceNo,venderName);
////           if (InvoiceNo.equals(Check)) {
////               
////               FacesMessage msg1 = new FacesMessage("The Invoice No : "+ InvoiceNo+" is Already exist against Vendor Name : "+venderName+"","Please Contact to vendor");
////               msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
////               FacesContext.getCurrentInstance().addMessage(null, msg1);
////               return "/user/Bill Entry.jsf";               
////               
////           }else{
////               
////               PreparedStatement ps = null;
////               Connection con = null;
////            try {
////                con = DataConnect.getConnection();
////                    if (con != null) {
////                        String sql = "exec insertinvoiceentry ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
////                        ps = con.prepareStatement(sql);
////                        ps.setString(1, InvoiceNo.toUpperCase());
////                        ps.setString(2, venderName.toUpperCase());
////                        ps.setString(3, IDate);
////                        ps.setString(4, billAmount);
////                        ps.setString(5, PoCategory.trim());
////                        ps.setString(6, PONo);
////                        ps.setString(7, ComName.trim());
////                        ps.setString(8, PageNo);
////                        ps.setString(9, DelMethod.trim());
////                        ps.setString(10, DDSNo);
////                        ps.setString(11, CourierName);
////                        ps.setString(12, CourierNo);
////                        ps.setString(13, SenderName.trim());
////                        ps.setString(14, SenderMo);
////                        ps.setString(15, SenderEmail.trim());
////                        ps.setString(16, NoOfInvoice);
////                        ps.setString(17, Costcenter.trim());
////                        ps.setString(18, InvoiceType.trim());
////                        ps.setString(19, region.trim());
////                        i= ps.executeUpdate();
////                        System.out.println(InvoiceDate);
////                    }
////                
////            } catch (Exception e) {
////                System.out.println(e);
////            } 
////            
////            
////        }
////            
////        }
////        if (i > 0) {
////            FacesMessage msg = new FacesMessage("Successfully Added invoice", "Enter New Invoice");
////            FacesContext.getCurrentInstance().addMessage(null, msg);
////            return "/user/Bill Entry.jsf";
////        } else{
////            FacesMessage msg = new FacesMessage("Error in Adding invoice!", "Try again");
////            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
////            FacesContext.getCurrentInstance().addMessage(null, msg);
////            return "/user/Bill Entry.jsf";
////        }
////    }
////
////    public boolean isSkip() {
////        return skip;
////    }
////
////    public void setSkip(boolean skip) {
////        this.skip = skip;
////    }
////
////    public String onFlowProcess(FlowEvent event) {
////        if(skip) {
////            skip = false;   //reset in case user goes back
////            return "confirm";
////        }
////        else {
////            return event.getNewStep();
////        }
////        
////        
////    }
////    
////     public String CheckInvoice(String InvoiceNo,String vendor) {
////        
////            PreparedStatement ps = null;
////            Connection con = null;
////            ResultSet rs = null;            
////                try {
////                    con = DataConnect.getConnection();
////                    if (con != null) {
////                        String sql = "select * from invoicedetail where vendorname = '"+ vendor + "' and invoicenumber='"+InvoiceNo+"'";
////                        ps = con.prepareStatement(sql);
////                        rs = ps.executeQuery();
////                        rs.next();                       
////                       CheckVender = rs.getString("invoicenumber");
////                       System.out.print(CheckVender);
////                       
////                    }
////                } catch (SQLException sqle) {
////                    sqle.printStackTrace();
////                }            
////                           
////        
////      return CheckVender;      
////    } 
////     
////     public String Region(String uName) {
////        if (uName != null) {
////            PreparedStatement ps = null;
////            Connection con = null;
////            ResultSet rs = null;
////            try {
////                con = DataConnect.getConnection();
////                if (con != null) {
////                    String sql = "select * from Users a inner join password b on a.userindex=b.userindex where username = '" + uName + "'";
////                    ps = con.prepareStatement(sql);
////                    rs = ps.executeQuery();
////                    rs.next();
////                    region = rs.getString("region");
////                    System.out.print(region.trim());
////
////                }
////            } catch (SQLException sqle) {
////                sqle.printStackTrace();
////            }
////
////        }
////        return region;
////    }
////     
////     
////     
////    public static void main(String[] args) {
////        InvoiceEntry n=new InvoiceEntry();
////        n.saven("dee");
////        
////    }
//// 
////
////}
