/**
 * 
 */
package composants.Factory;

import itf.ILivre;
import itf.IParser;
import itf.ILivreController;
import itf.IAnalyse;
import itf.IAffichageGraphique;
import itf.IEnchainement;
import itf.IObjet;
import composants.CIHM.GestIHM;
import composants.CLivre.*;
import composants.CParser.*;
import composants.CAffichageGraphique.*;
import composants.CAnalyse.*;
import composants.CController.*;
import itf.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CFactory {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param titre
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static ILivre createLivre(String titre,String auteur) {
		// begin-user-code
		// TODO Auto-generated method stub
		return new Livre(titre,auteur);
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param livre
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static IParser createParser(ILivre livre) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param livre
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static ILivreController createController(ILivre livre) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param livre
	* @param section
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static IAnalyse createAnalyse(ILivre livre, ISection section) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static IAffichageGraphique createAffichageGraphique() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new AffichageGraphique();
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param livre
	* @param section
	* @param parser
	* @param livreCont
	* @param enchainement
	* @param objet
	* @param affG
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static GestIHM createIHM(ILivre livre, itf.ISection section, IParser parser, ILivreController livreCont,
			IEnchainement enchainement, IObjet objet, IAffichageGraphique affG) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
	public static IGestLivre createGestLivre() {
		
		return new GestLivres();
		
	}
}