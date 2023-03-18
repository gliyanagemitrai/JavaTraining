package org.example.Excersice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    List<Vehicle> vehicles = new ArrayList<>();

    public Inventory(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("toyota", "aqua", 2012, "red", 100.00));
        vehicles.add(new Truck("mazda", "mode", 2001, "red", 200.00));
        Vehicle chr =new Car("toyota", "chr", 2017, "red", 300.00);
        Vehicle chr2 =new Car("toyota", "chr", 2018, "red", 300.00);

        vehicles.addAll(Arrays.asList(chr2,chr));
        Inventory inventory = new Inventory(vehicles);
        List<Vehicle> results = inventory.searchByMakeAndModel("toyota","chr");
        System.out.println(inventory.getAveragePrice());

        System.out.println(results.contains(chr));
        System.out.println(results.contains(chr2));
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Double getAveragePrice() {
        return this.vehicles.stream().mapToDouble(vehicle -> vehicle.price).average().getAsDouble();
    }

    public List<Vehicle> searchByMakeAndModel(String make, String model) {
        return this.vehicles.stream().filter(e -> e.make == make && e.model == model).toList();
    }
}
