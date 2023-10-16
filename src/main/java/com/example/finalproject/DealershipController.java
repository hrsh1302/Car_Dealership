package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class DealershipController implements Initializable {

    @FXML
    private AnchorPane p1;

    @FXML
    private CheckBox cbAston, cbBMW, cbFerrari, cbGenesis, cbLambo, cbMaserati, cbMercedes, cbMcLaren, cbRolls;

    @FXML
    private RadioButton rbAll, rbBlack, rbBlue, rbGreen, rbOrange, rbRed, rbWhite, rbYellow, rbGold;

    @FXML
    private ToggleGroup colors;

    @FXML
    private RadioButton rbPriceAscending, rbPriceDescending;

    @FXML
    private ToggleGroup sort;

    @FXML
    private CheckBox cbConvertible;

    List<Car> displayList = new ArrayList<>();

    //List used to store all cars
    List<Car> carsForSale = new ArrayList<>(Arrays.asList(
            new Car.AstonMartin(Colors.BLACK),
            new Car.AstonMartin(Colors.BLUE),
            new Car.AstonMartin(Colors.GREEN),
            new Car.AstonMartin(Colors.RED),
            new Car.BMW(Colors.GOLD),
            new Car.Ferrari(Colors.BLACK, true),
            new Car.Ferrari(Colors.BLUE, true),
            new Car.Ferrari(Colors.RED, false),
            new Car.Ferrari(Colors.WHITE, false),
            new Car.Ferrari(Colors.WHITE, true),
            new Car.Ferrari(Colors.YELLOW, false),
            new Car.Genesis(Colors.WHITE),
            new Car.Lamborghini(Colors.BLACK, false),
            new Car.Lamborghini(Colors.BLACK, true),
            new Car.Lamborghini(Colors.BLUE, true),
            new Car.Lamborghini(Colors.GREEN, false),
            new Car.Lamborghini(Colors.WHITE, false),
            new Car.Lamborghini(Colors.YELLOW, false),
            new Car.Maserati(Colors.BLACK),
            new Car.Maserati(Colors.BLUE),
            new Car.Maserati(Colors.RED),
            new Car.Maserati(Colors.WHITE),
            new Car.McLaren(Colors.BLACK),
            new Car.McLaren(Colors.BLUE),
            new Car.McLaren(Colors.GREEN),
            new Car.McLaren(Colors.ORANGE),
            new Car.McLaren(Colors.RED),
            new Car.McLaren(Colors.YELLOW),
            new Car.Mercedes(Colors.RED),
            new Car.RollsRoyce(Colors.GOLD)

    ));


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //GridPane created in order to store and display all cars
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(20);


        int row = 0;
        int column = 0;
        //Loop that adds all cars' images into the GridPane
        for (Car car : carsForSale) {
            ImageView imageView = new ImageView(car.getPics().getImage());
            imageView.setFitHeight(50);
            imageView.setFitWidth(80);
            VBox vBox = new VBox(imageView);

            //Event handler triggered when an image is clicked twice. It opens the car details stage
            imageView.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) {
                    try {
                        openCarInfo(car);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            gridPane.add(vBox, column, row);
            column++;
            if (column > 4) {
                column = 0;
                row++;
            }
        }

        //Updates the pane with the GridPane & adds all the car in carsForSale list into the displayList List
        p1.getChildren().add(gridPane);
        displayList.addAll(carsForSale);

    }

    //Triggered when any sort/filter buttons are used
    @FXML
    public void onCheckBoxClicked() {

        //Clears the display list
        displayList.clear();

        //List that stores all cars with selected color
        List<Colors> selectedColors = new ArrayList<>();

        // Add selected colors to the list
        if (rbAll.isSelected()) {
            selectedColors.add(Colors.BLACK);
            selectedColors.add(Colors.BLUE);
            selectedColors.add(Colors.GOLD);
            selectedColors.add(Colors.RED);
            selectedColors.add(Colors.WHITE);
            selectedColors.add(Colors.YELLOW);
            selectedColors.add(Colors.GREEN);
            selectedColors.add(Colors.ORANGE);
        }

        if (rbBlack.isSelected()) {
            selectedColors.add(Colors.BLACK);
        }
        if (rbBlue.isSelected()) {
            selectedColors.add(Colors.BLUE);
        }
        if (rbGold.isSelected()) {
            selectedColors.add(Colors.GOLD);
        }
        if (rbRed.isSelected()) {
            selectedColors.add(Colors.RED);
        }
        if (rbWhite.isSelected()) {
            selectedColors.add(Colors.WHITE);
        }
        if (rbYellow.isSelected())
            selectedColors.add(Colors.YELLOW);

        if (rbGreen.isSelected())
            selectedColors.add(Colors.GREEN);

        if (rbOrange.isSelected())
            selectedColors.add(Colors.ORANGE);

        //Boolean variable that checks if any brands are checked or not
        boolean anyBrandSelected = cbAston.isSelected() || cbBMW.isSelected() || cbFerrari.isSelected() ||
                cbGenesis.isSelected() || cbLambo.isSelected() || cbMcLaren.isSelected() ||
                cbMaserati.isSelected() || cbMercedes.isSelected() || cbRolls.isSelected();

        //Boolean variable that checks if car is convertible or not
        boolean isConvertibleSelected = cbConvertible.isSelected();

        //Loops through the carsForSale list and add the ones that have a selected color, brand, and convertible to the displayList
        for (Car car : carsForSale) {
            if ( !(anyBrandSelected) ||
                    (cbAston.isSelected() && car.getBrand() == Brand.ASTON_MARTIN) ||
                    (cbBMW.isSelected() && car.getBrand() == Brand.BMW) ||
                    (cbFerrari.isSelected() && car.getBrand() == Brand.FERRARI) ||
                    (cbGenesis.isSelected() && car.getBrand() == Brand.GENESIS) ||
                    (cbLambo.isSelected() && car.getBrand() == Brand.LAMBORGHINI) ||
                    (cbMcLaren.isSelected() && car.getBrand() == Brand.MCLAREN) ||
                    (cbMaserati.isSelected() && car.getBrand() == Brand.MASERATI) ||
                    (cbMercedes.isSelected() && car.getBrand() == Brand.MERCEDES) ||
                    (cbRolls.isSelected() && car.getBrand() == Brand.ROLLSROYCE)) {
                if (selectedColors.contains(car.getColor()) || selectedColors.isEmpty()) {
                    if (!isConvertibleSelected || car.isConvertible()) {
                        displayList.add(car);
                    }
                }
            }
        }

        // Sort the displayList based on the selected radio button
        if (rbPriceAscending.isSelected()) {
            displayList.sort(Comparator.comparing(Car::getPrice));
        } else if (rbPriceDescending.isSelected()) {
            displayList.sort(Comparator.comparing(Car::getPrice).reversed());
        }

        // Clear the GridPane from initialize() and add the sorted images
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        int row = 0;
        int column = 0;
        for (Car car : displayList) {
            ImageView imageView = new ImageView(car.getPics().getImage());
            imageView.setFitHeight(50);
            imageView.setFitWidth(80);
            VBox vBox = new VBox(imageView);

            //Event handler triggered when an image is clicked twice. It opens the car details stage
            imageView.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) {
                    try {
                        openCarInfo(car);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            gridPane.add(vBox, column, row);
            column++;
            if (column > 4) {
                column = 0;
                row++;
            }
        }


        // Replace the old GridPane with the new one
        p1.getChildren().clear();
        p1.getChildren().add(gridPane);
    }

    //Method used to open the carInfo stage
    public void openCarInfo(Car car) throws IOException {
        Stage carInfoStage = new Stage();
        carInfoStage.setTitle(String.valueOf(car.getBrand()));
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("CarInfo.fxml"));
        Parent root = fxmlLoader2.load();
        CarInfoController controller = fxmlLoader2.getController();
        controller.data(car);
        carInfoStage.setScene(new Scene(root));
        carInfoStage.show();
    }
}