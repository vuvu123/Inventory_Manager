package Model;

public class OutSourced extends Part{
    private String companyName;

    public OutSourced(int partID, String partName, double partPrice, int partStock, int min, int max, String companyName) {
        super(partID, partName, partPrice, partStock, min, max);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
