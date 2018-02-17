package Model;

public class StoreItem {

    private String name;

    private Double boughtAt;

    private Double soldAt;

    private Integer availableQty;

    private Integer numberSold;

    public StoreItem(String name, Double boughtAt, Double soldAt) {
        this.name = name;
        this.boughtAt = boughtAt;
        this.soldAt = soldAt;
        this.availableQty = 0;
        this.numberSold = 0;
    }

    public Integer getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(Integer numberSold) {
        this.numberSold = numberSold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Double boughtAt) {
        this.boughtAt = boughtAt;
    }

    public Double getSoldAt() {
        return soldAt;
    }

    public void setSoldAt(Double soldAt) {
        this.soldAt = soldAt;
    }

    public Integer getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Integer availableQty) {
        this.availableQty = availableQty;
    }

    @Override
    public String toString() {
        return name + " " + boughtAt + " " + soldAt + " " + availableQty;
    }
}
