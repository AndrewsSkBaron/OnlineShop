package com.onlineStore.coherent.parser;

import com.onlineStore.coherent.model.Root;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Parser {
    public Root parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        ParserHandler handler = new ParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error " + e.toString());
            return null;
        }

        File file = new File("/store/src/main/resources/config.xml");
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error " + e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error " + e.toString());
            return null;
        }
        return handler.getRoot();
    }
}
