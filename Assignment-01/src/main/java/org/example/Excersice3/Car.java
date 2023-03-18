package org.example.Excersice3;

public class Car extends  Vehicle{

    public Car(String make, String model, Integer year, String color, Double price) {
        super(make, model, year, color, price);
    }

    public Integer getNumDoor() {
        return numDoor;
    }

    public void setNumDoor(Integer numDoor) {
        this.numDoor = numDoor;
    }

    public Integer getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(Integer numPassengers) {
        this.numPassengers = numPassengers;
    }

    public Boolean getConvertible() {
        return isConvertible;
    }

    public void setConvertible(Boolean convertible) {
        isConvertible = convertible;
    }

    Integer numDoor;
    Integer numPassengers;
    Boolean isConvertible;


}
