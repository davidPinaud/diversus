/**
 * 
 */
package composants.CLivre;

import itf.IObjet;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Objets implements IObjet {

	private String nom_objet;
	/**
	 * Liste initialement vide, contient des références vers les sections et les enchainements qui référencent l'objet courant
	 */
	private List< ObjectConteners> contaners=new ArrayList< ObjectConteners> ();
	public Objets(String nom) {
		nom_objet=nom;
		
	}
	
	public String getNom() {

		return nom_objet;
	}

	/** 
	* (non-Javadoc)
	* @see IObjet#deleteObjet()
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void deleteObjet() {
		for (ObjectConteners o: contaners) {
			o.deleteObjet(this);
		}
	}

	public void addContener(ObjectConteners o) {
		
		contaners.add(o);
	}



}