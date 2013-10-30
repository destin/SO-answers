/**
 * 
 */
package org.dpytel.jaxb.xjc.nullablenillable;

import java.math.BigInteger;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElementRef;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JFieldVar;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.model.CPropertyInfo;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.FieldOutline;
import com.sun.tools.xjc.outline.Outline;
import com.sun.xml.xsom.XSComponent;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSParticle;

/**
 * Generates Javadocs based on xsd:documentation.
 * 
 * @author Dawid Pytel
 * 
 */
public class NullableNillablePlugin extends Plugin {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sun.tools.xjc.Plugin#getOptionName()
	 */
	@Override
	public String getOptionName() {
		return "Xnullablenillable";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sun.tools.xjc.Plugin#getUsage()
	 */
	@Override
	public String getUsage() {
		return "  -Xnullablenillable  :  Adds required=false to @XmlElementRef for nullable and nillable elements";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sun.tools.xjc.Plugin#run(com.sun.tools.xjc.outline.Outline,
	 * com.sun.tools.xjc.Options, org.xml.sax.ErrorHandler)
	 */
	@Override
	public boolean run(Outline outline, Options opt, ErrorHandler errorHandler)
			throws SAXException {
		Collection<? extends ClassOutline> classOutlines = outline.getClasses();
		for (ClassOutline classOutline : classOutlines) {

			FieldOutline[] declaredFields = classOutline.getDeclaredFields();
			for (FieldOutline fieldOutline : declaredFields) {
				if (isNullableNillable(fieldOutline)) {
					JFieldVar jFieldVar = classOutline.implClass.fields().get(
							fieldOutline.getPropertyInfo().getName(false));
					fixRequiredInXmlElementRef(jFieldVar);
				}
			}
		}
		return true;
	}

	private void fixRequiredInXmlElementRef(JFieldVar jFieldVar) {
		Collection<JAnnotationUse> annotations = jFieldVar.annotations();
		for (JAnnotationUse annotationUse : annotations) {
			if (XmlElementRef.class.equals(annotationUse.getAnnotationClass()
					.getClass())) {
				annotationUse.param("required", false);
			}
		}
	}

	private boolean isNullableNillable(FieldOutline fieldOutline) {
		CPropertyInfo propertyInfo = fieldOutline.getPropertyInfo();
		XSComponent schemaComponent = propertyInfo.getSchemaComponent();
		if (schemaComponent instanceof XSParticle) {
			XSParticle particle = (XSParticle) schemaComponent;
			if (particle.getMinOccurs().equals(new BigInteger("0"))
					&& particle.getTerm() instanceof XSElementDecl) {
				XSElementDecl elementDecl = (XSElementDecl) particle.getTerm();
				if (elementDecl.isNillable()) {
					return true;
				}
			}
		}
		return false;
	}

}
