package org.example.Excersice3;

public class Truck extends  Vehicle{
    Integer bedLength;
    Double payloadCapacity;
    public Truck(String make, String model, Integer year, String color, Double price) {
        super(make, model, year, color, price);
    }


    public Integer getBedLength() {
        return bedLength;
    }

    public void setBedLength(Integer bedLength) {
        this.bedLength = bedLength;
    }

    public Double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(Double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }
}
