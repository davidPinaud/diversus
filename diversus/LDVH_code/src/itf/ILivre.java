/**
 * 
 */
package itf;

import java.util.List;
import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ILivre {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param Jungle
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void CheckGrapheAcceptable(Object Jungle);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<ISection> listerSections();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param test
	* @param isAtteignable
	* @param nom
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String createSection(String test, Boolean isAtteignable, String nom);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param nom
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void createObject(String nom);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param texte
	* @param nom
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void createEnchainement(String texte, String nom, ISection src, ISection dst, List<IObjet> objets);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<String> getSections();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<String> getObjets();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<String> getEnchainements();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void ChargerOngletEchainement();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param nom
	* @param description
	* @param src
	* @param dst
	* @param objets
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void AddEnchainement(String nom, String description, ISection src, ISection dst, String... objets);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param src
	* @param dst
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean EnchainementExists(ISection src, ISection dst);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void selectEnchainement(int id);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @param nom
	* @param description
	* @param src
	* @param dst
	* @param objets
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void modifEnchainement(String id, String nom, String description, ISection src, ISection dst,
			String... objets);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void deleteEnchainement(int id);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param nom
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean checkEnchainementExists(String nom);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param nom
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean isTete(String nom);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param nom
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean SectionExist(Class nom);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getTete();
	public boolean deleteSection(String nom) ;
	public String toString();
	public boolean deleteObjet(String nom);
	public void addObjet(String nom);

}