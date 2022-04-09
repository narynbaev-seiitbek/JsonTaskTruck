package com.company.interfaces;

import com.company.Driver;
import com.company.Truck;

public interface ServiceTruck {
    void changeDriver(Truck truck,Driver driver);
    void startDriving(Truck truck,Driver driver);
    void startRepair(Truck truck, Driver driver);
}
