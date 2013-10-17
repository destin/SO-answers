package com.db.crds.ws.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class LoggingHandler implements
		javax.xml.ws.handler.soap.SOAPHandler<SOAPMessageContext> {

	public void close(MessageContext messagecontext) {
	}

	public Set<QName> getHeaders() {
		return null;
	}

	public boolean handleFault(SOAPMessageContext messagecontext) {
		return true;
	}

	public boolean handleMessage(SOAPMessageContext smc) {
		Boolean outboundProperty = (Boolean) smc
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			System.out.println("\nOutbound message:");
		} else {
			System.out.println("\nInbound message:");
		}

		SOAPMessage message = smc.getMessage();

		try {
			File file = new File("soap_responce"
					+ System.currentTimeMillis());
			System.out.println(file.getAbsolutePath());
			PrintWriter writer = new PrintWriter("soap_responce"
					+ System.currentTimeMillis(), "UTF-8");
			
			writer.println(message);
			writer.close();
			message.writeTo(System.out);
			System.out.println(""); // just to add a newline
		} catch (Exception e) {
			System.out.println("Exception in handler: " + e);
		}
		return outboundProperty;
	}
}