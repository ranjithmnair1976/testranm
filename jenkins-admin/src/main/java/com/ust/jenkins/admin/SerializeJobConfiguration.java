package com.ust.jenkins.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ust.plugins.build.jenkins.ConfigurationDocument;

public class SerializeJobConfiguration {
	public void parseConfiguration()
			throws SAXException, IOException, ParserConfigurationException, TransformerException {
		File file = new File("src/main/resources/config-template.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		ConfigurationDocument config = new ConfigurationDocument();
		config.setDocument(doc);
		FileOutputStream fout = new FileOutputStream("src/main/resources/dom.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(config);
		doc = null;
		oos.close();
		fout.close();
		oos=null;
		fout=null;
		/*		Element elementProjectPath = (Element) doc.getElementsByTagName("projectPath").item(0);
		elementProjectPath.appendChild(doc.createTextNode(""));
		doc.getDocumentElement().normalize();

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		 StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
	    transformer.transform(source,result);
	    String strResult = writer.toString();
		System.out.println(strResult);
	    

*/		
	}

	public void parseSonarConfiguration()
			throws SAXException, IOException, ParserConfigurationException, TransformerException {
		File file = new File("src/main/resources/sonar-config-template.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		ConfigurationDocument config = new ConfigurationDocument();
		config.setDocument(doc);
		FileOutputStream fout = new FileOutputStream("src/main/resources/sonar-dom.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(config);
		doc = null;
		oos.close();
		fout.close();
		oos=null;
		fout=null;
	}

	

	public static void main(String... args) {
		try {
			new SerializeJobConfiguration().parseSonarConfiguration();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
