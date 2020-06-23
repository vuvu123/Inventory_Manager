package Model;

import javafx.beans.property.IntegerProperty;

public class InHouse extends Part{
    private final IntegerProperty machineID;

    public InHouse(int partID, String partName, double partPrice, int partStock, int min, int max, IntegerProperty machineID) {
        super(partID, partName, partPrice, partStock, min, max);
        this.machineID = machineID;
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