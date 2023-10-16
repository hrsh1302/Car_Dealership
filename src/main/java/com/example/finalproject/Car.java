package com.example.finalproject;

import javafx.scene.image.ImageView;


abstract class Car {
    Brand brand;
    Colors color;
    String price;
    String acceleration;
    String cylinderCount;
    boolean convertible;
    ImageView pics;
    boolean electric;

    Car() {}

    public ImageView getPics() { return pics; }
    public void setPics(ImageView pics) { this.pics = pics; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public Colors getColor() { return color; }
    public void setColor(Colors color) { this.color = color; }

    public String getAcceleration() { return acceleration; }
    public void setAcceleration(String acceleration) { this.acceleration = acceleration; }

    public String getCylinderCount() { return cylinderCount; }
    public void setCylinderCount(String cylinderCount) { this.cylinderCount = cylinderCount; }

    public boolean isConvertible() { return convertible; }
    public void setConvertible(boolean convertible) { this.convertible = convertible; }

    public boolean isElectric() { return electric; }

    public void setElectric(boolean electric) { this.electric = electric; }


    //Cars for each Brand

    static class AstonMartin extends Car {
        AstonMartin(Colors color) {
            this.brand = Brand.ASTON_MARTIN;
            this.price = "220000";
            this.acceleration = "3.6";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.BLACK) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BlkAstonConvertible.jpg");
                setConvertible(true);
            }
            if (color == Colors.BLUE) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BluAston.jpg");
            if (color == Colors.GREEN) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\GreenAston.jpg");
            if (color == Colors.RED) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\RedAstonConvertible.jpg");
                setConvertible(true);
            }
        }
    }

    static class BMW extends Car {
        BMW(Colors color) {
            this.brand = Brand.BMW;
            this.price = "250000";
            this.acceleration = "2.3";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.GOLD) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\GoldBMWElec.png");
                setElectric(true);
            }
        }
    }

    static class Ferrari extends Car {
        Ferrari(Colors color, boolean convertible) {
            this.brand = Brand.FERRARI;
            this.price = "300000";
            this.acceleration = "2.7";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.BLACK) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BlkFerrariConvertible.jpg");
                setConvertible(true);
            }
            if (color == Colors.BLUE) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BluFerrariConvertible.jpg");
                setConvertible(true);
            }
            if (color == Colors.RED) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\RedFerrari.jpg");
            if (color == Colors.WHITE) {
                if (!convertible) {
                    this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\WhiteFerrari.jpg");
                } else {
                    this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\WhiteFerrConvertible.jpg");
                    setConvertible(true);
                }
            }
            if (color == Colors.YELLOW) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\YellowFerrari.jpg");

        }
    }

    static class Genesis extends Car {
        Genesis(Colors color) {
            this.brand = Brand.GENESIS;
            this.price = "300000";
            this.acceleration = "2.3";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.WHITE) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\WhiteGenesisConvertibleElec.png");
                setConvertible(true);
                setElectric(true);
            }
        }
    }

    static class Lamborghini extends Car {
        Lamborghini(Colors color, boolean convertible) {
            this.brand = Brand.LAMBORGHINI;
            this.price = "400000";
            this.acceleration = "2.5";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.BLACK) {
                if (convertible) {
                    this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BlkLamboConvertible.jpg");
                    setConvertible(true);
                } else {
                    this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BlkLambo.jpg");
                }
            }
            if (color == Colors.BLUE) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BluLamboConvertible.jpg");
                setConvertible(true);
            }

            if (color == Colors.GREEN) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\GreenLambo.jpg");
            if (color == Colors.WHITE) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\WhiteLambo.jpg");
            if (color == Colors.YELLOW) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\YellowLambo.jpg");
        }
    }

    static class Maserati extends Car {
        Maserati(Colors color) {
            this.brand = Brand.MASERATI;
            this.price = "200000";
            this.acceleration = "3.8";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.BLACK) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BlkMaserati.jpg");
            if (color == Colors.BLUE) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BluMaserati.jpg");
            if (color == Colors.RED) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\RedMaserati.jpg");
            if (color == Colors.WHITE) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\WhiteMaseratiConvertible.jpg");
                setConvertible(true);
            }
        }
    }

    static class McLaren extends Car {
        McLaren(Colors color) {
            this.brand = Brand.MCLAREN;
            this.price = "365000";
            this.acceleration = "2.5";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.BLACK) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BlkMcLaren.jpg");
            if (color == Colors.BLUE) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\BluMcLaren.jpg");
            if (color == Colors.GREEN) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\GreenMcLaren.jpg");
            if (color == Colors.ORANGE) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\OranMcLarenConvertible.jpg");
                setConvertible(true);
            }

            if (color == Colors.RED) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\RedMcLaren.jpg");
            if (color == Colors.YELLOW) this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\YellowMcLaren.jpg");
        }
    }

    static class Mercedes extends Car {
        Mercedes(Colors color) {
            this.brand = Brand.MERCEDES;
            this.price = "40000";
            this.acceleration = "2.3";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.RED) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\RedMercedesMaybachElectric.png");
                setElectric(true);
            }
        }
    }

    static class RollsRoyce extends Car {
        RollsRoyce(Colors color) {
            this.brand = Brand.ROLLSROYCE;
            this.price = "500000";
            this.acceleration = "3.0";
            this.color = color;
            this.pics = new ImageView();
            this.cylinderCount = "12";

            if (color == Colors.GOLD) {
                this.pics = new ImageView("C:\\Users\\banga\\IntelliJ IDEA\\Java II\\finaal\\finalProject\\src\\main\\resources\\com\\example\\finalproject\\GoleRollsRoyceElectric.png");
                setElectric(true);
            }
        }
    }
}