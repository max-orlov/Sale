package program;

import org.xml.sax.SAXException;
import sales.Product;
import xml.XMLProductWorker;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        //Sale sale = new Sale();
        //sale.start();

        /*Converter converter = new Converter(Converter.RUB);
        double convert1 = converter.convert(200, Converter.USD);
        double convert2 = converter.convert(300, Converter.EUR);
        double convert3 = converter.convert(250, Converter.RUB);

        System.out.println(convert1 + " " + String.format("%.2f",convert2) + " " + String.format("%.2f",convert3));

        converter.setDstCurrency(Converter.USD);
        double convert4 = converter.convert(200, Converter.USD);
        double convert5 = converter.convert(300, Converter.EUR);
        double convert6 = converter.convert(250, Converter.RUB);
        System.out.println(String.format("%.2f",convert5) + " " + convert4 + " " + convert6);*/

        try {
            XMLProductWorker worker = new XMLProductWorker("products.xml");
            List<Product> products = worker.getProducts();
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println(product.getName() + " " + product.getDesc() + " "
                    + product.getPrice() + " " + product.getMinOrderQty() + " " + product.getQtyOnHand());
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
