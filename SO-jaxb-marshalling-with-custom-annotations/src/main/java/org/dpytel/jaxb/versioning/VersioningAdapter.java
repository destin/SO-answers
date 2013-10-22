package org.dpytel.jaxb.versioning;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class VersioningAdapter extends XmlAdapter<Object, Object> {

	@Override
	public Object unmarshal(Object v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object marshal(Object v) throws Exception {
		if (v == null) {
			return v;
		}
		Field[] fields = v.getClass().getDeclaredFields();
		for (Field field : fields) {
			Annotation[] annotations = field.getDeclaredAnnotations();
			CustomVersion annotation = findCustomVersion(annotations);
			if (annotation != null) {
				if (!contains(annotation, Configuration.getVersion())) {
					field.setAccessible(true);
					field.set(v, null);
				}
			}
		}
		return v;
	}

	private CustomVersion findCustomVersion(Annotation[] annotations) {
		for (Annotation annotation : annotations) {
			if (annotation instanceof CustomVersion) {
				return (CustomVersion) annotation;
			}
		}
		return null;
	}

	private boolean contains(CustomVersion annotation, String version) {
		String[] values = annotation.value();
		for (String value : values) {
			if (value.equals(version)) {
				return true;
			}
		}
		return false;
	}

}
