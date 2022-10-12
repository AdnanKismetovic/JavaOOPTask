package Models;

public class Result {
    private String productName;
    private double minValue;
    private double maxValue;
    private double averageValue;

    public Result(String productName, double minValue, double maxValue, double averageValue) {
        this.productName = productName;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.averageValue = averageValue;
    }

    @Override
    public String toString() {
        return productName + "," + minValue + "," + maxValue + "," + averageValue;
    }
}
