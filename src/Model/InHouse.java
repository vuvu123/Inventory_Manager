package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InHouse extends Part {
    private final IntegerProperty machineID;

    public InHouse() {
        super();
        this.machineID = new SimpleIntegerProperty();
    }

    public InHouse(int partID, String partName, double partPrice, int partStock, int min, int max, int machineID) {
        super(partID, partName, partPrice, partStock, min, max);
        this.machineID = new SimpleIntegerProperty(machineID);
    }

    public int getMachineID() {
        return machineID.get();
    }

    public IntegerProperty machineIDProperty() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID.set(machineID);
    }
}
