package Model;

import javafx.beans.property.StringProperty;

public class OutSourced extends Part{
    private final StringProperty companyName;

    public OutSourced(int partID, String partName, double partPrice, int partStock, int min, int max, StringProperty companyName) {
        super(partID, partName, partPrice, partStock, min, max);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public StringProperty companyNameProperty() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
}
