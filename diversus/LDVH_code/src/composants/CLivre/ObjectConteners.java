/**
 * 
 */
package composants.CLivre;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.PrimitiveIterator.OfDouble;

import itf.IObjet;

/** 
 * Classe parent qui référence une liste d'objets 
 */
public class ObjectConteners {
	String nom;
	private List<IObjet> objets=new ArrayList<IObjet>();
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ObjectConteners) {
			return ((ObjectConteners) obj).getNom().equals(this.nom)&&((ObjectConteners) obj).getObjets().equals(this.objets);
		}
		return false;
	}

	public ObjectConteners(String nom) {
		this.nom=nom;
	}
	public ObjectConteners(List<IObjet> objets) {
		for (IObjet o:objets) {
			try {
				AddObjet(o);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String getNom() {
		return nom;
	}
	public List<IObjet> getObjets() {
		// begin-user-code
		// TODO Auto-generated method stub
		return objets;
		// end-user-code
	}
	public void setObjets(List<IObjet> objets) {
		this.objets=objets;
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	 * @throws Exception 
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void AddObjet(IObjet o) throws Exception {
		// ajouter la référence à l'objet
		if ( ! (o instanceof Objets)) {
			throw new Exception(" problème d'argument dans AddObjet, doit être un instance de Objets");
		}
		Objets ob=(Objets) o;
		
;		
		ob.addContener(this);
		objets.add(o);
		//System.out.println(" Objet "+ o.getNom()+ " ajouté au conteneur "+nom);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void deleteObjet(IObjet o) throws Exception{
		if ( ! (o instanceof Objets)) {
			throw new Exception(" problème d'argument dans AddObjet, doit être un instance de Objets");
		}
		Objets ob=(Objets) o;
		ob.deleteContaner(this);
		objets.remove(o);
		
		//System.out.println(" Objet "+ o.getNom()+ " supprimé du conteneur "+nom);
	}
	public void setNom(String nom) {
		this.nom=nom;
		
	}
}