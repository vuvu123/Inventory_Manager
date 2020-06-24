package Model;

import javafx.beans.property.SimpleStringProperty;

public class OutSourced extends Part {

    private final SimpleStringProperty companyName;

    public OutSourced(int partID, String partName, double partPrice, int partStock, int min, int max, String companyName) {
        super(partID, partName, partPrice, partStock, min, max);
        this.companyName = new SimpleStringProperty(companyName);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public SimpleStringProperty companyNameProperty() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
}
