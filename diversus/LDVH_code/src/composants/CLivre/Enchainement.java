/**
 * 
 */
package composants.CLivre;

import itf.*;

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
public class Enchainement extends ObjectConteners implements IEnchainement {
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
	private ISection section1;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/

	private ISection section2;
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
	private String nom;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private int id;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Enchainement(String nom, String description, ISection src, ISection dst, List<IObjet> objets) {
		super(objets);
		this.nom = nom;
		this.texte = description;
		this.section1 = src;
		this.section2 = dst;
	}

	/** 
	* (non-Javadoc)
	* @see IEnchainement#getSource()
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getSource() {
		return section1.getNom();
	}

	/** 
	* (non-Javadoc)
	* @see IEnchainement#getDestination()
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getDestination() {
		// begin-user-code
		// TODO Auto-generated method stub
		return section2.getNom();
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see IEnchainement#getNom()
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public String getNom() {
		// begin-user-code
		// TODO Auto-generated method stub
		return nom;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see IEnchainement#setNom(String nom)
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** 
	* (non-Javadoc)
	* @see IEnchainement#SetDescription(String desc)
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void SetDescription(String desc) {
		this.texte = desc;
	}

	/** 
	* (non-Javadoc)
	* @see IEnchainement#setSrc(ISection src)
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setSrc(ISection src) {
		this.section1 = src;
	}
	
	public ISection getSourceSection() {
		return this.section1;
	}
	public ISection getDestinationSection() {
		return this.section2;
	}

	/** 
	* (non-Javadoc)
	* @see IEnchainement#setDest(ISection dst)
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setDest(ISection dst) {
		this.section2 = dst;
	}
	
	public int getId() {
		return id;
		}


	@Override
	public void AddObjet(String Objet) {
		// TODO Auto-generated method stub
		
	}

	public String etatEnchainement() {
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append("nom : ");
		sBuilder.append(this.nom+" \n");
		sBuilder.append("description : ");
		sBuilder.append(this.texte+" \n");
		sBuilder.append("source : ");
		sBuilder.append(this.getSource()+"\n");
		sBuilder.append("destination : ");
		sBuilder.append(this.getDestination()+"\n");
		sBuilder.append("objets : ");
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

	/** 
	* (non-Javadoc)
	* @see IEnchainement#AddObjet(String Objet)
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	//public void AddObjet(String Objet) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	//}
}