package util;

import java.util.HashMap;
import java.util.Map;

public class Converter {
    public static final String RUB = "RUB";
    public static final String EUR = "EUR";
    public static final String USD = "USD";
    public static final String CNY = "CNY";
    /*private double[] toUsdCost;
    private double[] fromUsdCost;*/
    private Map<String, Double> toUsdCost;
    private Map<String, Double> fromUsdCost;
    private String dstCurrency;

    public Converter(String dstCurrency) {
        this.toUsdCost = new HashMap<>();
        this.toUsdCost.put(RUB, 0.015);
        this.toUsdCost.put(EUR, 1.13);
        this.toUsdCost.put(USD, 1.0);
        this.toUsdCost.put(CNY, 0.15);
        //this.toUsdCost = new double[]{0.015, 1.13, 1, 0.15};
        //this.fromUsdCost = new double[]{66.63, 0.89, 1, 6.77};
        this.fromUsdCost = new HashMap<>();
        this.fromUsdCost.put(RUB, 66.63);
        this.fromUsdCost.put(EUR, 0.89);
        this.fromUsdCost.put(USD, 1.0);
        this.fromUsdCost.put(CNY, 6.77);
        this.dstCurrency = dstCurrency;
    }

    public double convert(double crn, String srcCurrency){
        double sumDlrs = this.toUsdCost.get(srcCurrency) * crn;
        return this.fromUsdCost.get(dstCurrency) * sumDlrs;
    }

    public void setDstCurrency(String dstCurrency) {
        this.dstCurrency = dstCurrency;
    }
}
