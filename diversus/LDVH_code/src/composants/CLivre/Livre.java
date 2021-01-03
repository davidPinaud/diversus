/**
 * 
 */
package composants.CLivre;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	
	//private HashMap<String,Section> section2;
	
	private String titre;
	private String auteur;
	
	private Integer id;
	
	private Section tetedesection;
	
	private HashMap<String,Objets> objets;
	//private HashMap<String,Objets> objets2;
	
	
	private HashMap<String,Enchainement> enchainement;
	//private HashMap<String,Enchainement> enchainement2;

	
	public Livre(String titre,String auteur) {
		this.titre=titre;
		this.auteur=auteur;
		this.section=new HashMap<>();
		this.objets=new HashMap<>();
		this.enchainement=new HashMap<>();
	}
	@Override
	public String createSection(String texte, String nom) {
		try {
			if(!SectionExist(nom)) {
				Section sec=new Section(nom,texte ,this,  new ArrayList<IObjet>());
				section.put(nom, sec);
				return nom;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public IObjet getObjet(String nom) {
		return objets.get(nom);
	}
	@Override
	public ISection getSection(String nom) {
		return section.get(nom);
	}
	@Override
	public IEnchainement getEnchainement(String nom) {
		return enchainement.get(nom);
	}
	@Override
	public void createObject(String nom) {
		objets.put(nom,new Objets(nom));
	}


	@Override
	public Set<String> getSections() {
		return section.keySet();
	}

	@Override
	public HashMap<String,Objets> getObjets() {
		return this.objets;
	}

	@Override
	public Set<String> getEnchainements() {
		return enchainement.keySet();
	}


	@Override
	public void AddEnchainement(String nom, String description, ISection src, ISection dst, List<String> objetsList) {
		if(!this.getEnchainement().containsKey(nom)) {
			ArrayList<IObjet> listObjets=new ArrayList<>();
			for(String obString:objetsList) {
				listObjets.add(objets.get(obString));
			}
			Enchainement e=new Enchainement(nom, description, src, dst, listObjets);
			enchainement.put(e.getNom(), e);
		}
	}
	
	@Override
	public void createEnchainement(String texte, String nom, ISection src, ISection dst, List<IObjet> objets) {
		if(!this.getEnchainement().containsKey(nom)) {
			Enchainement e=new Enchainement(nom, texte, src, dst, objets);
			enchainement.put(e.getNom(), e);
		}
	}
	
	@Override
	public boolean EnchainementExists(ISection src, ISection dst) {
		for (Entry<String, Enchainement> entry : enchainement.entrySet()) {
            Enchainement e=entry.getValue();
            if(e.getSource().equals(src.getNom())) {
            	if(e.getDestination().equals(dst.getNom())) {
            		return true;
            	}
            }
        }
		return false;
	}


	@Override
	public void modifEnchainement(String id, String nom, String description, ISection src, ISection dst,
			List<String> objetsList) {
		Enchainement e=enchainement.get(nom);
		e.SetDescription(description);
		e.setDest(dst);
		e.setSrc(src);
		ArrayList<IObjet> listObjets=new ArrayList<>();
		for(String obString:objetsList) {
			listObjets.add(objets.get(obString));
		}
		e.setObjets(listObjets);
	}

	@Override
	public void deleteEnchainement(int id) {
		for (Entry<String, Enchainement> entry : enchainement.entrySet()) {
            Enchainement e=entry.getValue();
            if(e.getId()==id) {
            	enchainement.remove(entry.getKey());
            	break;
            }
		}
	}

	@Override
	public Boolean checkEnchainementExists(String nom) {
		return enchainement.containsKey(nom);
	}

	
	@Override
	public Boolean isTete(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean SectionExist(String nom) throws Exception{
		if(section.containsKey(nom)) {
			throw new Exception();
		}
		return section.containsKey(nom);
	}

	@Override
	public String getTete() {
		return this.tetedesection.getNom();
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
	
	public String etatLivre() {
		StringBuilder sb=new StringBuilder();
		sb.append("Titre : "+this.titre+"\nAuteur : "+this.auteur+"\n\n");
		sb.append("Sections : \n\n");
		for (Entry<String, Section> entry : this.getSection().entrySet()) {
			sb.append(entry.getValue().etatSection());
		}
		sb.append("----------------------------------------\n");
		sb.append("Enchainements : \n\n");
		for (Entry<String, Enchainement> entry : this.getEnchainement().entrySet()) {
			sb.append(entry.getValue().etatEnchainement());
		}
		sb.append("----------------------------------------\n");
		sb.append("Objets : ");
		if(this.getObjets().isEmpty()) {
			sb.append("Pas d'objets");
		}else {
			for (Entry<String, Objets> entry : this.getObjets().entrySet()) {
				sb.append(entry.getValue().getNom()+" ");
			}
		}
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
		this.objets.put(nom, new Objets(nom));
	}

	
	@Override
	public boolean deleteSection(String nom) {
		if(section.containsKey(nom)) {
			section.remove(nom);
				return true;
		}
		return false;
	}

	
	@Override
	public void setTete(ISection sec) {
		Section s=(Section )sec;
		tetedesection=s;
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


	public void setObjets(HashMap<String, Objets> objets) {
		this.objets = objets;
	}
	
	
}