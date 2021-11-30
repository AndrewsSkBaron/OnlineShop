package com.onlineStore.coherent.parser;

import com.onlineStore.coherent.model.Root;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Parser {
    public Root parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        ParserHandler handler = new ParserHandler();
        try {
            SAXParser parser = factory.newSAXParser();
            File file = new File("C:/Users/AndreiBaron/IdeaProjects/OnlineShop/store/src/main/resources/config.xml");
            parser.parse(file, handler);
        } catch (Exception e) {
            System.out.println("Parser was not created. " + e);
            e.printStackTrace();
        }
        return handler.getRoot();
    }
}