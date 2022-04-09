package com.company;

import com.company.json.JsonService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path TRUCKS = Paths.get("./trucks");
    public static final Path DRIVERS = Paths.get("./drivers");


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Truck[] trucks = {new Truck(1, "Honda     ", "", "base"),
                new Truck(2, "Mercedes  ", "", "base"),
                new Truck(3, "Toyota    ", "", "base"),
                new Truck(4, "Lexus     ", "", "base"),
                new Truck(5, "Kamaz     ", "", "base")
        };
        Driver[] drivers = {
                new Driver(1, "Messi    ", "driver-1"),
                new Driver(2, "Neymar   ", "driver-2"),
                new Driver(3, "Mbappe   ", "driver-3"),
                new Driver(4, "Verratti ", "driver-3"),
        };

        String json = GSON.toJson(trucks);
        JsonService.writeFile(json,DRIVERS);
        System.out.println(JsonService.readFile(DRIVERS));

        String json2 = GSON.toJson(trucks);
        JsonService.writeFile(json,TRUCKS);
        System.out.println(JsonService.readFile(TRUCKS));


        print(trucks);
        print(drivers);
        System.out.println("--------------------------------");
        while (true) {
            System.out.println("Choose truck: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            Driver.getInfo(trucks[input - 1]);
            Service service = new Service();
            getInstruction();
            String action = scanner.nextLine();
            if (action.equals("1")) {
                service.changeDriver(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("2")) {
                service.startDriving(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("3")) {
                service.startRepair(trucks[input - 1], drivers[input - 1]);
            }
            print(trucks);
            print(drivers);
        }

    }

    public static void print(Truck[] trucks) {
        System.out.println("---------------------TRUCKS---------------------");
        System.out.println(" #  |    Bus         |  State     |      Driver  ");
        System.out.println("----+----------------+------------+--------------");
        for (int i = 0; i < trucks.length; i++) {
            System.out.println(trucks[i]);

        }
    }

    public static void print(Driver[] drivers) {
        System.out.println("________DRIVERS______________");
        System.out.println(" # |   Driver    |   Bus      ");
        System.out.println("---+-------------+------------");
        for (int i = 0; i < drivers.length; i++) {
            System.out.println(drivers[i]);
        }
    }

    public static void getInstruction() {
        System.out.println("Choose -1- to change");
        System.out.println("Choose -2- to start");
        System.out.println("Choose -3- to repair");
    }
}

