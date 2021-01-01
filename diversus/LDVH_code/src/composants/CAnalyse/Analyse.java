/**
 * 
 */
package composants.CAnalyse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import composants.CLivre.Enchainement;
import composants.CLivre.GestLivres;
import composants.CLivre.Livre;
import composants.CLivre.Section;
import itf.IAnalyse;
import itf.ILivre;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Analyse implements IAnalyse{
	
	ILivre livre;
	
	public Analyse(ILivre livre) {
		this.livre=livre;
	}
	@Override
	public List<String> Analyser_graphe() {
		Section teteSection=((Livre) livre).getSection().get(livre.getTete());
		
		List<Section> TouteSections=new ArrayList<>();
		for (Entry<String, Section> entry : ((Livre) livre).getSection().entrySet()) {
			TouteSections.add(entry.getValue());
		}
		TouteSections.remove(teteSection);
		
		List<String> atteignable=new ArrayList<>();
		atteignable.add(teteSection.getNom());
		
		int nb=50000;
		while(nb>0 && !TouteSections.isEmpty())
		teteSection.getNextAtteignable();
		
		
		
		
		return atteignable;
	}

	@Override
	public void updateAtteignabilite(String nomSection, String nomEnchainement, String nomObjet) {
		// TODO Auto-generated method stub

	}
}