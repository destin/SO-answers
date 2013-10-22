package org.dpytel.jaxb.versioning;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlJavaTypeAdapter(VersioningAdapter.class)
public class SomeBean {

	@CustomVersion("v1")
	private String field1;
	
	@CustomVersion({ "v1", "v2" })
	private String field2;
	
	@CustomVersion("v2")
	private String field3;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

}
