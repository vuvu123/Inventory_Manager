package Model;

import javafx.beans.property.*;

public abstract class Part {
    private final IntegerProperty partID;
    private final StringProperty partName;
    private final DoubleProperty partPrice;
    private final IntegerProperty partStock;
    private final IntegerProperty minPartStock;
    private final IntegerProperty maxPartStock;

    public Part(int partID, String partName, double partPrice, int partStock, int min, int max) {
        this.partID = new SimpleIntegerProperty(partID);
        this.partName = new SimpleStringProperty(partName);
        this.partPrice = new SimpleDoubleProperty(partPrice);
        this.partStock = new SimpleIntegerProperty(partStock);
        this.minPartStock = new SimpleIntegerProperty(min);
        this.maxPartStock = new SimpleIntegerProperty(max);
    }

    public int getPartID() {
        return partID.get();
    }

    public IntegerProperty partIDProperty() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID.set(partID);
    }

    public String getPartName() {
        return partName.get();
    }

    public StringProperty partNameProperty() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName.set(partName);
    }

    public double getPartPrice() {
        return partPrice.get();
    }

    public DoubleProperty partPriceProperty() {
        return partPrice;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice.set(partPrice);
    }

    public int getPartStock() {
        return partStock.get();
    }

    public IntegerProperty partStockProperty() {
        return partStock;
    }

    public void setPartStock(int partStock) {
        this.partStock.set(partStock);
    }

    public int getMinPartStock() {
        return minPartStock.get();
    }

    public IntegerProperty minPartStockProperty() {
        return minPartStock;
    }

    public void setMinPartStock(int minPartStock) {
        this.minPartStock.set(minPartStock);
    }

    public int getMaxPartStock() {
        return maxPartStock.get();
    }

    public IntegerProperty maxPartStockProperty() {
        return maxPartStock;
    }

    public void setMaxPartStock(int maxPartStock) {
        this.maxPartStock.set(maxPartStock);
    }
}
