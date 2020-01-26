package com.robottitto.util;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXUtils {

    public static void listHeadings(String url) {
        try {
            DefaultHandler handler = new RSSHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(url, handler);
            System.out.println("Listáronse os titulares de El País");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Non se puideron listar os titulares de El País");
        }
    }

}