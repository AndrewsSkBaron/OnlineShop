package com.onlineStore.coherent.parser;

import com.onlineStore.coherent.model.Sort;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserHandler extends DefaultHandler {
    private static final String TAG_SORT = "sort";
    private static final String TAG_NAME = "name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_RATE = "rate";

    private String currentTagName;
    private boolean isSorting = false;

    private Sort sort = new Sort();

    public Sort getSort() {
        return sort;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;

        if (currentTagName.equals(TAG_SORT)) {
            isSorting = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(TAG_SORT)) {
            isSorting = false;
        }
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTagName == null) return;
        if(isSorting) {
            switch (currentTagName) {
                case TAG_NAME:
                    String nameOrder = new String(ch, start, length);
                    sort.setName(nameOrder);
                    break;
                case TAG_PRICE:
                    String priceOrder = new String(ch, start, length);
                    sort.setPrice(priceOrder);
                    break;
                case TAG_RATE:
                    String rateOrder = new String(ch, start, length);
                    sort.setRate(rateOrder);
                    break;
            }
        }
    }
}
