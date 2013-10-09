package org.dpytel.servicemix.camel;

import java.util.logging.Logger;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class MyCustomHandler implements ValidationEventHandler {
	
	private Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

	/* (non-Javadoc)
	 * @see javax.xml.bind.ValidationEventHandler#handleEvent(javax.xml.bind.ValidationEvent)
	 */
	public boolean handleEvent(ValidationEvent event) {
		logger.severe("Error: " + event.getMessage());
		return true;
	}

}
