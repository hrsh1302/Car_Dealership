package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;

public class CarInfoController {
    @FXML
    private ImageView carImage;

    @FXML
    private Label title;

    @FXML
    private Label txtBrand, txtColor, txtPrice, txtAcceleration, txtConvertible, txtCylinder, txtElectric;

    @FXML
    private Label lbBrand, lbColor, lbPrice, lbAcceleration, lbConvertible, lbCylinder, lbElectric;

    @FXML
    private Button buy;

    @FXML
    Car c1 = new Car() {};

    //Method that collects data from previously selected car image/model
    public void data(Car car) {
        c1.setBrand(car.brand);
        c1.setColor(car.color);
        c1.setPics(car.getPics());
        c1.setPrice(car.price);
        c1.setAcceleration(car.acceleration);
        c1.setConvertible(car.convertible);
        c1.setCylinderCount(car.cylinderCount);
        c1.setElectric(car.electric);

        //Used to get a proper output of the amount
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        double price = Double.parseDouble(c1.getPrice());
        String formattedPrice = numberFormat.format(price);
        lbPrice.setText("$" + formattedPrice);

        lbBrand.setText(c1.getBrand().toString());
        lbColor.setText(c1.getColor().toString());
        lbAcceleration.setText(c1.getAcceleration());
        lbCylinder.setText(c1.getCylinderCount());
        carImage.setImage(c1.getPics().getImage());

        if (c1.isConvertible())
            lbConvertible.setText("Yes");
        else
            lbConvertible.setText("No");

        if (c1.isElectric())
            lbElectric.setText(("Yes"));
        else
            lbElectric.setText("No");
    }

    //Method that triggers when user clicks on the buy button, which creates the paymentStage
    @FXML
    public void buyButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("Payment.fxml"));
            Parent root = fxmlLoader3.load();
            PaymentController controller = fxmlLoader3.getController();
            controller.data(c1);
            Stage paymentStage = new Stage();
            paymentStage.setTitle("Payment Page");
            paymentStage.setScene(new Scene(root));
            paymentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

