package sales;

import java.util.Objects;

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

    public void qtyOnHandDegree(int val) {
        qtyOnHand -= val;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public void setMinOrderQty(int minOrderQty) {
        this.minOrderQty = minOrderQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                qtyOnHand == product.qtyOnHand &&
                minOrderQty == product.minOrderQty &&
                Objects.equals(name, product.name) &&
                Objects.equals(desc, product.desc);
    }

    @Override
    public String toString() {
        return  "name: '" + name + '\'' +
                ", price: " + String.format("%.2f", price) +
                ", min order quantity: " + minOrderQty;
    }
}
