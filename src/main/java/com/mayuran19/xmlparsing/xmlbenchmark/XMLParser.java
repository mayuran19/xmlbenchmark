package com.mayuran19.xmlparsing.xmlbenchmark;

import com.mayuran19.generated.example.Shiporder;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by mayuran on 29/11/16.
 */
public class XMLParser {
    public static void main(String[] args) throws Exception{
        parse();
        parse2();
        domParser();
    }

    public static void parse() throws Exception {
        long beginTime = System.currentTimeMillis();
        FileReader fr = new FileReader("/Users/mayuran/Workspace/JavaEE/xmlbenchmark/src/main/resources/xsd/sample.xml");
        JAXBContext jc = JAXBContext.newInstance(Shiporder.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        System.out.println(unmarshaller.getClass());

        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLEventReader xmler = xmlif.createXMLEventReader(fr);
        System.out.println(xmlif.getClass());

        Shiporder obj = (Shiporder) unmarshaller.unmarshal(xmler);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - beginTime);
    }

    public static void parse2() throws Exception {
        long beginTime = System.currentTimeMillis();
        FileReader fr = new FileReader("/Users/mayuran/Workspace/JavaEE/xmlbenchmark/src/main/resources/xsd/sample.xml");
        JAXBContext jc = JAXBContext.newInstance(Shiporder.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        System.out.println(unmarshaller.getClass());
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        System.out.println(xmlif.getClass());
        XMLStreamReader xmler = xmlif.createXMLStreamReader(fr);


        Shiporder obj = (Shiporder) unmarshaller.unmarshal(xmler);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - beginTime);
    }

    public static void domParser() throws Exception{
        long beginTime = System.currentTimeMillis();
        File inputFile = new File("/Users/mayuran/Workspace/JavaEE/xmlbenchmark/src/main/resources/xsd/sample.xml");
        DocumentBuilderFactory dbFactory
                = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        System.out.println("Root element :"
                + doc.getDocumentElement().getNodeName());

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - beginTime);
    }
}
