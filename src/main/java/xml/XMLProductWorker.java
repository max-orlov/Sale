package xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLProductWorker {
    private File xmlPath;
    private List<Product> products;

    public XMLProductWorker(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = new File(xmlPath);
        this.products = parse();
    }
    
    public XMLProductWorker(File xmlPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = xmlPath;
        this.products = parse();
    }
    
    public XMLProductWorker(File xmlPath, Product[] products) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = xmlPath;
        this.products = Arrays.asList(products);
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
    
    public void save() throws IOException {
        String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        XML += "<products>";
        for (int i = 0; i < this.products.size(); i++) {
            Product pr = this.products.get(i);
            if(pr == null)
                continue;
            XML += "<product>";
            XML += "<name>" + pr.getName() + "</name>";
            XML += "<description>" + pr.getDesc()+ "</description>";
            XML += "<price>" + String.format("%.2f", pr.getPrice()) + "</price>";
            XML += "<qtyOnHand>" + pr.getQtyOnHand()+ "</qtyOnHand>";
            XML += "<minOrderQty>" + pr.getMinOrderQty()+ "</minOrderQty>";
            XML += "</product>";             
        }
        XML += "</products>";
        BufferedWriter writer = new BufferedWriter(new FileWriter(xmlPath));
        writer.write(XML);
        writer.close();
    }

    public List<Product> getProducts() {
        return products;
    }
}
