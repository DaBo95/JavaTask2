package com.epam.darya_bogomolova.java.lesson8;

import com.epam.darya_bogomolova.java.lesson8.model.Candy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ParserXML {

    public void getXMLfile() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElementNS("com.epam.darya_bogomolova.java.lesson8.model", "Candies");
            doc.appendChild(rootElement);

            rootElement.appendChild(getCandy(doc, "FruitCandy", 1, "Strrawberry", "Fruit", 14.0));

            rootElement.appendChild(getCandy(doc, "ChocolateCandy", 2, "ChocoCandy", "Chocolate", 12.5));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("candies.xml"));

            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Creation of XML file complete!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getCandy(Document doc, String sortCandy, int number, String name, String type, double weight) {
        Element candy = doc.createElement("Candy");
        candy.setAttribute("sortCandy", sortCandy);
        candy.appendChild(getCandyElements(doc, "number", String.valueOf(number)));
        candy.appendChild(getCandyElements(doc, "name", name));
        candy.appendChild(getCandyElements(doc, "type", type));
        candy.appendChild(getCandyElements(doc, "weight", String.valueOf(weight)));

        return candy;
    }

    private static Node getCandyElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    public List<Candy>getCandyFromXml(String fileName) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Candy> result = new ArrayList<>();
        try {

            final File xmlFile = new File(System.getProperty("user.dir")
                    + File.separator + fileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Candy");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    String sortCandy = element.getAttribute("sortCandy");

                    int number = Integer.parseInt(element.getElementsByTagName("number").item(0).getTextContent());
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String type = element.getElementsByTagName("type").item(0).getTextContent();
                    double weight = Double.parseDouble(element.getElementsByTagName("weight").item(0).getTextContent());


                    String candyPack = getPathToClass(sortCandy);
                    Class candyClass = Class.forName(candyPack);
                    Constructor[] a = candyClass.getConstructors();

                    Candy candy = (Candy) a[0].newInstance(number, name, weight);
                    result.add(candy);
                }
            }
        } catch (ParserConfigurationException | SAXException
                | IOException ex) {
        }
        return result;

    }

    public static String getPathToClass(String className) {
        return "com.epam.darya_bogomolova.java.lesson8.model." + className;
    }

}


