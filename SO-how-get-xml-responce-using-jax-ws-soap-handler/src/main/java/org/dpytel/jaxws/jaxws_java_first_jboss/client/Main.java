package org.dpytel.jaxws.jaxws_java_first_jboss.client;

import org.dpytel.jaxws.jaxws_java_first_jboss.MyWebService;
import org.dpytel.jaxws.jaxws_java_first_jboss.MyWebServiceImplService;

public class Main {

	public static void main(String[] args) {
		MyWebServiceImplService service = new MyWebServiceImplService();
		MyWebService myWebService = service.getMyWebServiceImplPort();
		System.out.println(myWebService.hello("ja"));
	}
	
}
