package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.NumberFormat;

public class ReceiptController {
    final double TAX = 0.06;
    @FXML
    Car c1 = new Car() {};
    @FXML
    private Label title, lbName, lbBrand, lbPrice, lbTax, lbTotal;

    //Method that collects data from previously selected car image/model & first, last name of user
    public void data(Car car, String firstName, String lastName) {
        c1.setBrand(car.brand);
        c1.setColor(car.color);
        c1.setPics(car.getPics());
        c1.setPrice(car.price);
        c1.setAcceleration(car.acceleration);
        c1.setConvertible(car.convertible);
        c1.setCylinderCount(car.cylinderCount);
        c1.setElectric(car.electric);

        lbName.setText("Congratulations, " + firstName + " " + lastName + ":");
        lbBrand.setText("You have purchased a(n) " + c1.getBrand());

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        double price = Double.parseDouble(c1.getPrice());
        String formattedPrice = numberFormat.format(price);
        lbPrice.setText("Worth:..................................$" + formattedPrice);
        double tax = price * TAX;
        String formattedTax = numberFormat.format(tax);
        lbTax.setText("TAX:......................................$" + formattedTax);
        double totalPrice = price + tax;
        String formattedTotalPrice = numberFormat.format(totalPrice);
        lbTotal.setText("Total:..................................$" + formattedTotalPrice);

    }
}
