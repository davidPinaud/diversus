/**
 * 
 */
package itf;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ILivreController {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param titre
	* @param auteur
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void creerLivre(String titre, String auteur);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param titre
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean supprimerLivre(String titre);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param titre
	* @param auteur
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ILivre chargerLivre(String titre, String auteur);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param titre
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void sauvegarde(String titre);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param titre
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean CheckUnique(String titre);
}