/**
 * 
 */
package composants.CAnalyse;

import java.util.Set;

import composants.CLivre.GestLivres;
import itf.IAnalyse;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Analyse implements IAnalyse{
	
	GestLivres gestLivre;
	
	public Analyse(GestLivres gestLivre) {
		this.gestLivre=gestLivre;
	}
	@Override
	public Set<String> Analyser_graphe() {
		return null;
	}

	@Override
	public void updateAtteignabilite(String nomSection, String nomEnchainement, String nomObjet) {
		// TODO Auto-generated method stub

	}
}