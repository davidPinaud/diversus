/**
 * 
 */
package composants.CLivre;

import itf.ILivre;

import java.util.HashMap;
import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
import itf.ISection;
import itf.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Livre implements ILivre {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Set<Section> section;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String titre;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String auteur;
	

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Set<Enchainement> enchainement;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	//private Set<deliverable> deliverable;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	//private Set<deliverable> deliverable;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Integer id;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Section tetedesection;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private HashMap<String,Objets> objets;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Set<Objets> objets2;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Section tetesection;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Set<Section> section2;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Set<Enchainement> enchainement2;

	@Override
	public void CheckGrapheAcceptable(Object Jungle) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<ISection> listerSections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createSection(String test, Boolean isAtteignable, String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createObject(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createEnchainement(String texte, String nom) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> getSections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getObjets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getEnchainements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ChargerOngletEchainement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AddEnchainement(String nom, String description, ISection src, ISection dst, String... objets) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean EnchainementExists(ISection src, ISection dst) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void selectEnchainement(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifEnchainement(String id, String nom, String description, ISection src, ISection dst,
			String... objets) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEnchainement(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean checkEnchainementExists(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteSection(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isTete(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean SectionExist(Class nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTete() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(id);
		sb.append("livre :");
		sb.append(titre);
		sb.append(" d'auteur ' ");
		sb.append(auteur);
		sb.append(" '");
		return sb.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see itf.ILivre#deleteObjet(java.lang.String)
	 * @return false si l'objet n'existe pas 
	 */
	@Override
	public boolean deleteObjet(String nom){
		Objets o=objets.get(nom);
		if( o==null) {
			return false;
		}
		o.deleteObjet();
		objets.remove(nom);
		return true;
		
	}
	public void addObjet(String nom) {
		
	}
	
}