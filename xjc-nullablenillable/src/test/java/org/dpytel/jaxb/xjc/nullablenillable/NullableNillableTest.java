/**
 * 
 */
package org.dpytel.jaxb.xjc.nullablenillable;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import com.sun.tools.xjc.Driver;

/**
 * 
 * @author Dawid Pytel
 * 
 */
public class NullableNillableTest {

	private static final String OUTPUT_DIR = "target";

	@Test
	public void testNullNillable() throws Exception {
		String fileName = "nullablenillable.xsd";

		assertProcessedSuccessful(fileName);
	}

	private void assertProcessedSuccessful(String fileName) throws Exception {
		String xsdPath = new File("src/test/resources", fileName)
				.getAbsolutePath();
		int result = Driver.run(new String[] { xsdPath, "-Xnullablenillable",
				"-d",
				OUTPUT_DIR }, System.out, System.out);

		assertThat(result, is(0));
	}
}
