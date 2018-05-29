package com.epam.darya_bogomolova.java.lesson8;

import com.epam.darya_bogomolova.java.lesson8.model.Candy;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

public class MainGift {
    Scanner in;

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        new MainGift().run();
    }

    public void run() throws  ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        in = new Scanner(System.in);

        ParserXML parserXML = new ParserXML();
        parserXML.getXMLfile();

        System.out.println("------------------------");

        List<Candy> candies = parserXML.getCandyFromXml("candies.xml");

        for (Candy candy: candies) {
            System.out.println(candy);
        }


    }


}
