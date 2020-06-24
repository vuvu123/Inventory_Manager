package Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private final IntegerProperty productID;
    private final StringProperty productName;
    private final DoubleProperty productPrice;
    private final IntegerProperty productStock;
    private final IntegerProperty minProductStock;
    private final IntegerProperty maxProductStock;

    public Product() {
        this.productID = new SimpleIntegerProperty();
        this.productName = new SimpleStringProperty();
        this.productPrice = new SimpleDoubleProperty();
        this.productStock = new SimpleIntegerProperty();
        this.minProductStock = new SimpleIntegerProperty();
        this.maxProductStock = new SimpleIntegerProperty();
    }

    public Product(int productID, String productName, double productPrice, int productStock, int minProductStock, int maxProductStock) {
        this.productID = new SimpleIntegerProperty(productID);
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleDoubleProperty(productPrice);
        this.productStock = new SimpleIntegerProperty(productStock);
        this.minProductStock = new SimpleIntegerProperty(minProductStock);
        this.maxProductStock = new SimpleIntegerProperty(maxProductStock);
    }


    public int getProductID() {
        return productID.get();
    }

    public IntegerProperty productIDProperty() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID.set(productID);
    }

    public String getProductName() {
        return productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public double getProductPrice() {
        return productPrice.get();
    }

    public DoubleProperty productPriceProperty() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice.set(productPrice);
    }

    public int getProductStock() {
        return productStock.get();
    }

    public IntegerProperty productStockProperty() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock.set(productStock);
    }

    public int getMinProductStock() {
        return minProductStock.get();
    }

    public IntegerProperty minProductStockProperty() {
        return minProductStock;
    }

    public void setMinProductStock(int minProductStock) {
        this.minProductStock.set(minProductStock);
    }

    public int getMaxProductStock() {
        return maxProductStock.get();
    }

    public IntegerProperty maxProductStockProperty() {
        return maxProductStock;
    }

    public void setMaxProductStock(int maxProductStock) {
        this.maxProductStock.set(maxProductStock);
    }

    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

    public void addAssociatedPart(Part partAdded) {
        this.associatedParts.add(partAdded);
    }

    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        for (int i = 0; i < associatedParts.size(); i++) {
            if (selectedAssociatedPart.equals(associatedParts.get(i).getPartID())) {
                associatedParts.remove(i);
                return true;
            }
        }
        return false;
    }

}
