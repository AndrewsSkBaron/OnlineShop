package com.onlineStore.coherent.parser;

import com.onlineStore.coherent.model.Root;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserHandler extends DefaultHandler  {
    private static final String TAG_SORT = "sort";
    private static final String TAG_NAME = "name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_RATE = "rate";

    private Root root = new Root();

    public Root getRoot() {
        return root;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        //System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        //System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //System.out.println("Start element " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("End element " + qName);
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //System.out.println("characters " + new String(ch, start, length));
        super.characters(ch, start, length);
    }
}
