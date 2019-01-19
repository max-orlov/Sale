package sales;

import java.util.Arrays;

public class ProductList {
    private Product[] listOfProducts;
    private  static int index;

    public ProductList() {
        this.index = 0;
        this.listOfProducts = new Product[5];
    }

    public void addProduct(String name, String desc, double price,  int qtyOnHand, int minOrderQty){
        Product prd = new Product(name, desc, price, qtyOnHand, minOrderQty);
        listOfProducts[index++] = prd;
    }


    public boolean isFull(){
        return listOfProducts[4] != null;
    }

    public int countProducts() {
        return this.index;
    }

    public boolean isEmpty(){
        return countProducts() == 0;
    }

//    public Product[] getListOfProducts() {
//        return listOfProducts;
//    }

    public Product getProduct(int ind) {
        if(ind < 0 || ind > listOfProducts.length)
            return null;
        return this.listOfProducts[ind];
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "listOfProducts=" + Arrays.toString(listOfProducts) +
                '}';
    }


}
