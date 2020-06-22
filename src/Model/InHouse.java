package Model;

public class InHouse extends Part{
    private int machineID;

    public InHouse(int partID, String partName, double partPrice, int partStock, int min, int max) {
        super(partID, partName, partPrice, partStock, min, max);
    }

    public void setMachineId(int machineID) {
        this.machineID = machineID;
    }

    public int getMachineID() {
        return this.machineID;
    }

}
