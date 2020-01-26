package com.robottitto.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSHandler extends DefaultHandler {

    private boolean newItem = false;
    private String title = null;

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        if (qName.equals("item")) {
            newItem = true;
        } else if (qName.equals("title") && newItem) {
            title = "";
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        if (qName.equals("title") && newItem) {
            System.out.println(title);
            title = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (title != null) {
            title += new String(ch, start, length);
        }
    }

}