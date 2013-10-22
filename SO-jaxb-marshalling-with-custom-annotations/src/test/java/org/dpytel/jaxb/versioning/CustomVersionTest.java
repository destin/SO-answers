package org.dpytel.jaxb.versioning;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.junit.Test;

public class CustomVersionTest {

	@Test
	public void test() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(RootElement.class, SomeBean.class);
		Marshaller marshaller = context.createMarshaller();
		
		
		SomeBean object = new SomeBean();
		object.setField1("field1Value");
		object.setField2("field2Value");
		object.setField3("field3Value");
		RootElement rootElement = new RootElement();
		rootElement.setSomeBean(object);
		
		StringWriter writer = new StringWriter();
		
		marshaller.marshal(rootElement, writer);
		
		String xml = writer.toString();
		System.out.println(xml);
		assertThat(xml, not(containsString("field3Value")));
	}
	
	@Test
	public void testSomeBeanAsRootElement() throws Exception {
		JAXBContext context = JAXBContext.newInstance(SomeBean.class);
		Marshaller marshaller = context.createMarshaller();
		
		
		SomeBean object = new SomeBean();
		object.setField1("field1Value");
		object.setField2("field2Value");
		object.setField3("field3Value");
		
		StringWriter writer = new StringWriter();
		object = (SomeBean) new VersioningAdapter().marshal(object);
		marshaller.marshal(object, writer);
		
		String xml = writer.toString();
		System.out.println(xml);
		assertThat(xml, not(containsString("field3Value")));
	}

}
