package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sales.Product;
import util.Converter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLProductWorker {
    private File xmlPath;
    private ArrayList<Product> products;

    public XMLProductWorker(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = new File(xmlPath);
        this.products = parse();
    }

    public XMLProductWorker(File xmlPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = xmlPath;
        this.products = parse();
    }


    public ArrayList<Product> parse() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(this.xmlPath);

        Converter converter = new Converter(Converter.RUB);
        ArrayList<Product> products = new ArrayList<>();
        NodeList productsNodeList = document.getElementsByTagName("product");
        for (int i = 0; i < productsNodeList.getLength(); i++) {
            NodeList childNodesProduct = productsNodeList.item(i).getChildNodes();
            Product product = new Product();
            for (int j = 0; j < childNodesProduct.getLength(); j++) {
                Node childItem = childNodesProduct.item(j);
                if(childItem.getNodeType() == Node.ELEMENT_NODE) {
                    String nodeName = childItem.getNodeName();
                    if(nodeName.equals("name"))
                        product.setName(childItem.getTextContent());
                    else if(nodeName.equals("description"))
                        product.setDesc(childItem.getTextContent());
                    else if(nodeName.equals("price")) {
                        String unt = ((Element)childItem).getAttribute("unt");
                        double resConvert = converter.convert(Double.parseDouble(childItem.getTextContent()), unt);
                        product.setPrice(resConvert);
                    }
                    else if(nodeName.equals("qtyOnHand"))
                        product.setQtyOnHand(Integer.parseInt(childItem.getTextContent()));
                    else if(nodeName.equals("minOrderQty"))
                        product.setMinOrderQty(Integer.parseInt(childItem.getTextContent()));
                }
            }
            products.add(product);
        }
        return products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
