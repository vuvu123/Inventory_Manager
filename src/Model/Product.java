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

    public void addAssociatedPart(Part partsAdded) {
        this.associatedParts.add(partsAdded);
    }

    public void setAssociatedParts(ObservableList<Part> partsAdded) {
        this.associatedParts = partsAdded;
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

    public static String productValidation(String name, int min, int max, int inv, double price, ObservableList<Part> parts, String eMessage) {
        double sumOfParts = 0.00;
        for (Part part : parts)
            sumOfParts += part.getPartPrice();

        if (name.isEmpty())
            eMessage = eMessage + "Product name field is blank.\n";

        if (inv <= 0)
            eMessage = eMessage + "Inventory must be greater than 0.\n";

        if (price <= 0)
            eMessage = eMessage + "Price must be greater than $0.\n";

        if (min > max)
            eMessage = eMessage + "Inventory minimum cannot be less than maximum.\n";

        if (inv < min || inv > max)
            eMessage = eMessage + "Inventory must be between minimum and maximum values.\n";

        if (parts.isEmpty())
            eMessage = eMessage + "Product must contain at least one part.\n";

        if (sumOfParts > price)
            eMessage = eMessage + "Product price must be greater than total cost of parts.\n";

        return eMessage;
    }

}
