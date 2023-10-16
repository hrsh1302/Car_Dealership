package com.example.finalproject;

//REMOVED Car car = new car

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {
    @FXML
    private AnchorPane paymentPage;
    @FXML
    private ImageView carImage;
    @FXML
    private Label lbFName, lbLName, lbCbNum, lbDigitCode, lbDate, title;
    @FXML
    private TextField txtFName, txtLName, txtCbNum, txtDigitCode, txtDate;
    @FXML
    private Label fNameError, lNameError, cbNumError, digitCodeError, cbDateError;
    @FXML
    private Button purchase;

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

        carImage.setImage(c1.getPics().getImage());
    }

    //Method that verifies all the text fields with conditions
    //If condition not met, it displays an error message
    @FXML
    public void verify(ActionEvent event) {
        boolean fName = false;
        boolean lName = false;
        boolean cbNum = false;
        boolean digitCode = false;
        boolean cbDate = false;

        //Checks for only alpha characters
        if (txtFName.getText().matches("[a-zA-Z]+")) {
            fName = true;
        } else {
            fNameError.setText("Enter only letters from A-Z");
        }

        //Checks for only alpha characters
        if (txtLName.getText().matches("[a-zA-Z]+")) {
            lName = true;
        } else {
            lNameError.setText("Enter only letters from A-Z");
        }

        //Checks if the text field only has numeric characters, and it's length is 16
        if (txtCbNum.getText().matches("\\d+") && txtCbNum.getText().length() == 16) {
            cbNum = true;
        } else {
            cbNumError.setText("Enter only 16 numeric values");
        }

        //Checks if the text field only has numeric characters, and it's length is 3
        if (txtDigitCode.getText().matches("\\d+") && txtDigitCode.getText().length() == 3) {
            digitCode = true;
        } else {
            digitCodeError.setText("Enter only 3 numeric values");
        }

        //Checks if the text field has the date format, like XX/XX
        if (txtDate.getText().matches("\\d{2}/\\d{2}")) {
            cbDate = true;
        } else {
            cbDateError.setText("Enter a date in the format: XX/XX ");
        }

        //If all text fields are error free, it creates the receiptStage
        if ((fName) && (lName) && (cbNum) && (digitCode) && (cbDate)) {
            try {
                FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("receipt.fxml"));
                Parent root = fxmlLoader4.load();
                ReceiptController controller = fxmlLoader4.getController();
                controller.data(c1, txtFName.getText(), txtLName.getText());
                Stage receiptStage = new Stage();
                receiptStage.setTitle("Receipt");
                receiptStage.setScene(new Scene(root));
                receiptStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
