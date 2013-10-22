package org.dpytel.jaxb.versioning;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RootElement {

	private SomeBean someBean;

	public SomeBean getSomeBean() {
		return someBean;
	}

	public void setSomeBean(SomeBean someBean) {
		this.someBean = someBean;
	}
	
}
