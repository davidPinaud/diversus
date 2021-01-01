/**
 * 
 */
package composants.CLivre;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
import itf.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Livre implements ILivre {
	
	
	private HashMap<String,Section> section;
	private String titre;
	private String auteur;
	private HashMap<String,Enchainement> enchainement;
	private Integer id;
	private Section tetedesection;
	private HashMap<String,Objets> objets;
	private HashMap<String,Objets> objets2;
	private Section tetesection;
	private HashMap<String,Section> section2;
	private HashMap<String,Enchainement> enchainement2;

	
	@Override
	public void CheckGrapheAcceptable(Object Jungle) {
		// TODO Auto-generated method stub
	}

	@Override
	public HashMap<String,ISection> listerSections() {
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
	public HashMap<String,String> getSections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String,String> getObjets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String,String> getEnchainements() {
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

	@Override
	public void createEnchainement(String texte, String nom, ISection src, ISection dst, List<IObjet> objets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteSection(String nom) {
		// TODO Auto-generated method stub
		return false;
	}
	public HashMap<String, Section> getSection() {
		return section;
	}

	public void setSection(HashMap<String, Section> section) {
		this.section = section;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public HashMap<String, Enchainement> getEnchainement() {
		return enchainement;
	}

	public void setEnchainement(HashMap<String, Enchainement> enchainement) {
		this.enchainement = enchainement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Section getTetedesection() {
		return tetedesection;
	}

	public void setTetedesection(Section tetedesection) {
		this.tetedesection = tetedesection;
	}

	public HashMap<String, Objets> getObjets2() {
		return objets2;
	}

	public void setObjets2(HashMap<String, Objets> objets2) {
		this.objets2 = objets2;
	}

	public Section getTetesection() {
		return tetesection;
	}

	public void setTetesection(Section tetesection) {
		this.tetesection = tetesection;
	}

	public HashMap<String, Section> getSection2() {
		return section2;
	}

	public void setSection2(HashMap<String, Section> section2) {
		this.section2 = section2;
	}

	public HashMap<String, Enchainement> getEnchainement2() {
		return enchainement2;
	}

	public void setEnchainement2(HashMap<String, Enchainement> enchainement2) {
		this.enchainement2 = enchainement2;
	}

	public void setObjets(HashMap<String, Objets> objets) {
		this.objets = objets;
	}

	
}