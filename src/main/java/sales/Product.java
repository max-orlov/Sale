package sales;

public class Product {
    private String name;
    private String desc;
    private double price;
    private int qtyOnHand;
    private int minOrderQty;

    public Product() {
    }

    public Product(String name, String desc, double price, int qtyOnHand, int minOrderQty) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
        this.minOrderQty = minOrderQty;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public int getMinOrderQty() {
        return minOrderQty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", qtyOnHand=" + qtyOnHand +
                ", minOrderQty=" + minOrderQty +
                '}';
    }

}
