/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

import com.dao.DataConnect;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class UserChart implements Serializable {

    private PieChartModel pieModel1;

    long DishInfra;
    long DishTV;
    long Cyquator;
    long SitiCable;
    long Ebex;
    long ZEEL;
    long ZLL;
    long ZMCL;
    long LEEL;
    private final Date currentDate = new Date();
    String ChekCompany;
    String region;

    LineChartModel animatedModel1;

    @PostConstruct

    public void init() {
        createPieModels();
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    private void createPieModels() {
        createPieModel1();
    }

    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        CompanyCountgraph();
        pieModel1.set("DishTV", DishTV);
        pieModel1.set("DishInfra", DishInfra);
        pieModel1.set("Cyquator", Cyquator);
        pieModel1.set("Ebex", Ebex);
        pieModel1.set("LEEL", LEEL);
        pieModel1.set("SitiCable", SitiCable);
        pieModel1.set("ZLL", ZLL);
        pieModel1.set("ZEEL", ZEEL);
        pieModel1.set("ZMCL", ZMCL);
        pieModel1.setTitle("Total Inward Count By Company");
        pieModel1.setShowDataLabels(true); 
        pieModel1.setLegendCols(0);
        pieModel1.setLegendPosition("E");
    }

    public void CompanyCountgraph() {

        PreparedStatement ps;
        Connection con;
        ResultSet rs;
        try {
            con = DataConnect.getConnection();
            if (con != null) {
                if (ChekCompany("Dish TV") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'Dish TV'");
                    rs = ps.executeQuery();
                    rs.next();
                    DishTV = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("Dish Infra") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'Dish Infra'");
                    rs = ps.executeQuery();
                    rs.next();
                    DishInfra = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("cyquator") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'cyquator'");
                    rs = ps.executeQuery();
                    rs.next();
                    Cyquator = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("Ebex") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'Ebex'");
                    rs = ps.executeQuery();
                    rs.next();
                    Ebex = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("LEEL") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'LEEL'");
                    rs = ps.executeQuery();
                    rs.next();
                    LEEL = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("Siti Cable") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'Siti Cable'");
                    rs = ps.executeQuery();
                    rs.next();
                    SitiCable = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("ZLL") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'ZLL'");
                    rs = ps.executeQuery();
                    rs.next();
                    ZLL = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("ZEEL") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'ZEEL'");
                    rs = ps.executeQuery();
                    rs.next();
                    ZEEL = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("ZMCL") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'ZMCL'");
                    rs = ps.executeQuery();
                    rs.next();
                    ZMCL = rs.getLong(2);
                    ChekCompany = null;
                }

            }
            con.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public LineChartModel createAnimatedModels(String user) {
        Region(user);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String CDate = format.format(currentDate);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        String cDate = format.format(cal.getTime());
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Performance Graph");
        animatedModel1.setAnimate(true);
        animatedModel1.setZoom(true);
        animatedModel1.setLegendPosition("w");
        animatedModel1.getAxis(AxisType.Y).setLabel("Score");
        DateAxis axis = new DateAxis("Date");
        axis.setTickAngle(-40);
        axis.setMin(cDate);
        axis.setMax(CDate);
        axis.setTickFormat("%b %#d, %y");
        animatedModel1.getAxes().put(AxisType.X, axis);
        return animatedModel1;
    }

    public LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        LineChartSeries AP = new LineChartSeries();
        AP.setLabel("vikram");
        LineChartSeries Inward = new LineChartSeries();
        Inward.setLabel("Deepak");
        PreparedStatement ps;
        Connection con;
        ResultSet rs;
        try {
            con = DataConnect.getConnection();
            String sql = "exec apgraph '" + region.trim() + "' ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AP.set(rs.getString(1), rs.getLong(3));
                Inward.set(rs.getString(1), rs.getLong(2));
            }
            model.addSeries(AP);
            model.addSeries(Inward);
            con.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return model;
    }

    public String ChekCompany(String Company) {
        PreparedStatement ps;
        Connection con;
        ResultSet rs;
        try {
            con = DataConnect.getConnection();
            if (con != null) {
                String sql = "CheckCompanyCountgraph '" + Company + "'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                ChekCompany = rs.getString(1);
            }

            con.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return ChekCompany;
    }

    public String Region(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con;
            ResultSet rs = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "userslogin '" + uName + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next();
                    region = rs.getString("region");

                }
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }
        return region;
    }
    
    private String getYesterdayDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);    
        System.out.println(dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
        
}
    public static void main(String[] args) {
        UserChart n=new UserChart();
        n.getYesterdayDateString();
    }
}
