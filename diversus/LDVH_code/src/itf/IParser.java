/**
 *
 */
package itf;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import composants.CLivre.Livre;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface IParser {
	/**
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @throws DocumentException 
	* @throws IOException
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String generateImprimable(Livre l) throws DocumentException, IOException;

	/**
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @throws IOException
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String generateHTML(Livre l) throws IOException;
}
