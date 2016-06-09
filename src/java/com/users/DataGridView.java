/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

/**
 *
 * @author hriday.dubey
 */
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped; 
 
@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {
     
    private List<CarService> cars;
     
    private CarService selectedCar;
     
    @ManagedProperty("#{carService}")
    private CarService service;
     
    @PostConstruct
    public void init() {
//        cars = service.createCars(6);
    }
 
    public List<CarService> getCars() {
        return cars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
 
    public CarService getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(CarService selectedCar) {
        this.selectedCar = selectedCar;
    }
}
