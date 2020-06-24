package Main;

import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Inventory System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setTestData() {
        //Add Parts
        Part ih1 = new InHouse(1000, "Part One", 19.99, 5, 1, 50, 100);
        Part ih2 = new InHouse(1001, "Part Two", 29.99, 5, 1, 50, 100);
        Part ih3 = new InHouse(1002, "Part Three", 14.99, 5, 1, 50, 101);
        Inventory.addPart(ih1);
        Inventory.addPart(ih2);
        Inventory.addPart(ih3);

        Part os1 = new OutSourced(1003, "Bike Wheel", 29.99, 10, 1, 30, "Vitus");
        Part os2 = new OutSourced(1004, "Bike Frame", 24.99, 10, 1, 30, "GT");
        Part os3 = new OutSourced(1005, "Bike Brakes", 15.99, 10, 1, 30, "Trek");

        Inventory.addPart(os1);
        Inventory.addPart(os2);
        Inventory.addPart(os3);

        //Add Products
        Product p1 = new Product(100, "Bike 1",  99.99, 10, 1, 30);
        p1.addAssociatedPart(os1);
        p1.addAssociatedPart(os2);
        p1.addAssociatedPart(os3);

        Product p2 = new Product(200, "Bike 2", 499.99, 3, 1, 10);
        p2.addAssociatedPart(os1);
        p2.addAssociatedPart(os2);
        p2.addAssociatedPart(os3);
        p2.addAssociatedPart(ih1);
        p2.addAssociatedPart(ih2);

        Product p3 = new Product(300, "Bike 3", 79.99, 10, 1, 15);
        p3.addAssociatedPart(ih1);
        p3.addAssociatedPart(ih2);

        Inventory.addProduct(p1);
        Inventory.addProduct(p2);
        Inventory.addProduct(p3);
    }


}
