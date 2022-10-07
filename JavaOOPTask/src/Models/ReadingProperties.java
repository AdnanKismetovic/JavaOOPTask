package Models;

public class ReadingProperties {
    public String productID;
    public String productName;
    public String productPrice;
    @Override
    public String toString() {
        return this.productID + " " + this.productName + " " + this.productPrice;
    }
}
