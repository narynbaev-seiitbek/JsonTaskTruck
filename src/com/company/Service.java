package com.company;

import com.company.interfaces.ServiceTruck;

import java.io.IOException;
import java.util.Random;

public class Service implements ServiceTruck {


    @Override
    public void changeDriver(Truck truck, Driver driver) {
           if (truck.getState().equals("base")) {
               truck.setDriver(driver.getName());
               driver.setTruck(truck.getName());
           } else if (truck.getState().equals("route")) {
               System.out.println("You successfully changed, driver on the road");
           } else {
               System.out.println("You can not change driver");
           }

    }

    @Override
    public void startDriving(Truck truck, Driver driver) {
        if (truck.getState().equals("base")){
            if (!truck.getDriver().equals("")){
                truck.setState("route");
                System.out.println("Driver successfully start ");
            }else {
                System.out.println("Here not driver");
            }
        }else if(truck.getState().equals("route")){
            System.out.println("The driver is on the way!");
        }else {
            Random random = new Random();
            int road = random.nextInt(2);
            if (road==0){
                truck.setState("route");
                System.out.println("Truck is on the way!");
            }else {
                truck.setState("base");
                System.out.println("Truck is on base");

            }
        }

    }

    @Override
    public void startRepair(Truck truck, Driver driver) {
        if (truck.getState().equals("base")){
            truck.setState("repair");
            System.out.println("Truck is on repair");
        }else if (truck.getState().equals("route")){
            truck.setState("repair");
        }else {
            System.out.println("Truck is on repair");
        }
    }
}
