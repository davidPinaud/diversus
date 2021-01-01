/**
 * 
 */
package composants.CLivre;

import itf.IObjet;
import itf.ISection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Section extends ObjectConteners implements ISection {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Livre livre;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private List<Enchainement> enchainement;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private String texte;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Integer idSection;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private List<IObjet> objets=new ArrayList<IObjet>();
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Livre livre2;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	//private Set<Enchainement> enchainement2;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	//private String nom;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	//private Set<Enchainement> enchainement3;

	
	public Section( Integer id, String nom, String texte ,Livre livre,  List<IObjet> objets) {
		super(objets);
		super.nom=nom;
		this.idSection=id;
		this.texte = texte;
		this.livre = livre;
		
	}
	
	
	public Section( Integer id, String nom, String texte ,List<Enchainement> enchainements,Livre livre) {
		super(nom);
		this.idSection=id;
		this.texte = texte;
		this.livre = livre;
		this.enchainement=enchainements;
		
	}
	/** 
	* (non-Javadoc)
	* @see ISection#getNom()
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getNom() {
		return super.nom;
	}
	public List<Enchainement> getEnchainementSource(){
		ArrayList<Enchainement> list=new ArrayList<>();
		for (Entry<String, Enchainement> entry : livre.getEnchainement().entrySet()) {
			if(entry.getValue().getSource().equals(this.nom)) {
				list.add(entry.getValue());
			}
		}
		
		return list;
	}
	
	public List<Enchainement> getEnchainementDestination(){
		ArrayList<Enchainement> list=new ArrayList<>();
		for (Entry<String, Enchainement> entry : livre.getEnchainement().entrySet()) {
			if(entry.getValue().getDestination().equals(this.nom)) {
				list.add(entry.getValue());
			}
		}
		
		return list;
	}
	/** 
	* (non-Javadoc)
	* @see ISection#setNom(String nom)
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setNom(String nom) {
	    super.setNom(nom);
	}

	/** 
	* (non-Javadoc)
	* @see ISection#getNextAtteignable(String nom)
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public List<String>  getNextAtteignable(String nom) {
		List<String>  atteignable= new ArrayList<String>();
		HashMap<String, Enchainement> en=livre.getEnchainement();
		for (Entry<String, Enchainement> entry : en.entrySet()) {
            Enchainement e=entry.getValue();
            if(e.getSource().equals(this.nom)) {
            	if(this.getObjets().containsAll(e.getObjets())) {
            		atteignable.add(e.getDestination());
            	}
            }
		}
		
	/*	for(int i=0; i<en.size();i++)
		{
			if(en.get(i).getSource().equals(nom))
			{
				e.add(en.get(i).getNom());
			}
		}
		*/
		return atteignable;
	}
	
	
	/** 
	* (non-Javadoc)
	* @see ISection#addObjet()
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void addObjet(IObjet ob) {
		try {
			super.AddObjet(ob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public Boolean getIsAtteignable() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return this.texte;
	}
	
	public void setText(String texte) {
		this.texte=texte;
	}


	public String etatSection() {
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append("nom : ");
		sBuilder.append(this.nom+" \n");
		sBuilder.append("description : ");
		sBuilder.append(this.texte+" \n");
		sBuilder.append("objets : \n");
		if(this.getObjets().isEmpty()) {
			sBuilder.append("Pas d'objets");
		}else {
			for (IObjet entry:this.getObjets()) {
				sBuilder.append(entry.getNom()+" ");
			}
		}
		sBuilder.append("\n\n");
		return sBuilder.toString();
	}


}