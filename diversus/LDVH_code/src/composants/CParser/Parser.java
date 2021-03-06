/**
 *
 */
package composants.CParser;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
import itf.IParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import composants.CLivre.Enchainement;
import composants.CLivre.Livre;
import composants.CLivre.Section;
import itf.*;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author inas
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Parser implements IParser {

	/* (non-Javadoc)
	 * @see itf.IParser#generateImprimable(composants.CLivre.Livre)
	 */
	@Override
	public String generateImprimable(ILivre l) throws DocumentException, IOException{

		//creation du dossier
		File file = new File("./LivrePDF");
		if (!file.exists()) file.mkdir();

		//creation du PDF
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./LivrePDF/"+l.getTitre()+".pdf"));
		document.open();

		//creation de differente police de caractere
		Font f10 = new Font(FontFamily.TIMES_ROMAN, 10);
		Font f14 = new Font(FontFamily.TIMES_ROMAN, 14);
		Font f24 = new Font(FontFamily.TIMES_ROMAN, 24);

		//creation de la premier page
		Paragraph p = new Paragraph("page 1", f10);
		p.setAlignment(2);
		document.add(p);
		p=new Paragraph(l.getTitre(), f24);
		p.setAlignment(1);
		document.add(p);
		p=new Paragraph("by "+l.getAuteur(), f14);
		p.setAlignment(1);
		document.add(p);
		Image image1 = Image.getInstance("./dvstory.png");
		image1.setAlignment(Element.ALIGN_CENTER);
		image1.scaleAbsolute(450, 150);
		Image image2 = Image.getInstance("./Logo_Diversus.png");
		image2.setAlignment(Element.ALIGN_CENTER);
		image2.scaleAbsolute(450, 250);
		document.add(new Paragraph(" ", f24));
		document.add(new Paragraph(" ", f24));
		document.add(new Paragraph(" ", f24));
		document.add(image1);
		document.add(new Paragraph(" ", f24));
		document.add(image2);
		HashMap<String, Section> sections = l.getSection();
		HashMap<Section, Integer> pages = new HashMap();
		int i = 2;
		pages.put(l.getTetedesection(), i++);

		//map assignant une section a un numero de page
		for (Entry<String, Section> entry : sections.entrySet()) {
			Section value = (Section) entry.getValue();
			if(value!=l.getTetedesection())pages.put(value, i++);
		}
		//On commence par la tete de section
		String str = "";
		document.newPage();
		p = new Paragraph("page "+pages.get(l.getTetedesection()), f10);
		p.setAlignment(2);
		document.add(p);
		p = new Paragraph(l.getTetedesection().getNom(), f24);
		p.setAlignment(1);
		document.add(p);
		p = new Paragraph(" ", f24);
		document.add(p);
		document.add(new Paragraph(l.getTetedesection().getText(), f14));
		document.add(new Paragraph(" ", f14));
		str = "Voici les objets que vous venez de récupérer : ";
		for(IObjet o : l.getTetedesection().getObjets()) {
			str = str + o.getNom()+" / ";
		}
		if(l.getTetedesection().getObjets().size()!=0)str = str.substring(0, str.length()-2);
		document.add(new Paragraph(str, f14));
		document.add(new Paragraph(" ", f14));
		document.add(new Paragraph(" ", f14));
		document.add(new Paragraph("Où choisissez vous de vous rendre ?", f14));
		document.add(new Paragraph(" ", f14));
		for(Enchainement e : l.getTetedesection().getEnchainementSource()) {
			str = "Liste des objets requis : ";
			document.add(new Paragraph(e.getNom()+" (en page "+pages.get(e.getDestinationSection())+") : \n"+e.getTexte(), f14));
			for(IObjet o : e.getObjets()) {
				str = str + o.getNom() +" / ";
			}
			if(e.getObjets().size()!=0)str = str.substring(0, str.length()-2);
			document.add(new Paragraph(str, f14));
			document.add(new Paragraph(" ", f14));
		}

		//On fait ensuite toute les autres sections
		for (Entry<String, Section> entry : sections.entrySet()) {
			Section value = (Section) entry.getValue();
			if(value!=l.getTetedesection()) {
				document.newPage();
				p = new Paragraph("page "+pages.get(value), f10);
				p.setAlignment(2);
				document.add(p);
				p = new Paragraph(value.getNom(), f24);
				p.setAlignment(1);
				document.add(p);
				p = new Paragraph(" ", f24);
				document.add(p);
				document.add(new Paragraph(value.getText(), f14));
				document.add(new Paragraph(" ", f14));
				str = "Voici les objets que vous venez de récupérer : ";
				for(IObjet o : value.getObjets()) {
					str = str + o.getNom()+" / ";
				}
				if(value.getObjets().size()!=0)str = str.substring(0, str.length()-2);
				document.add(new Paragraph(str, f14));
				document.add(new Paragraph(" ", f14));
				document.add(new Paragraph(" ", f14));
				document.add(new Paragraph("Où choisissez vous de vous rendre ?", f14));
				document.add(new Paragraph(" ", f14));
				for(Enchainement e : value.getEnchainementSource()) {
					str = "Liste des objets requis : ";
					document.add(new Paragraph(e.getNom()+" (en page "+pages.get(e.getDestinationSection())+") : "+e.getTexte(), f14));
					for(IObjet o : e.getObjets()) {
						str = str + o.getNom() +" / ";
					}
					if(e.getObjets().size()!=0)str = str.substring(0, str.length()-2);
					document.add(new Paragraph(str, f14));
					document.add(new Paragraph(" ", f14));
				}
			}
		}

		document.close();
		writer.close();

		return null;
	}

	@Override
	public String generateHTML(ILivre l) throws IOException {
		//creation des dossiers
		File file = new File("./LivreHTML");
		if (!file.exists()) file.mkdir();
		file = new File("./LivreHTML/"+l.getTitre());
		if (!file.exists()) file.mkdir();
		File[] files = file.listFiles();
		for (File f : files) {
			f.delete();
		}


		//creation du fichier css
		file = new File("./LivreHTML/style.css");
		String str = "/* MVP.css v1.6.3 - https://github.com/andybrewer/mvp */\n" +
				"\n" +
				":root {\n" +
				"    --border-radius: 5px;\n" +
				"    --box-shadow: 2px 2px 10px;\n" +
				"    --color: #118bee;\n" +
				"    --color-accent: #118bee15;\n" +
				"    --color-bg: #fff;\n" +
				"    --color-bg-secondary: #e9e9e9;\n" +
				"    --color-secondary: #920de9;\n" +
				"    --color-secondary-accent: #920de90b;\n" +
				"    --color-shadow: #f4f4f4;\n" +
				"    --color-text: #000;\n" +
				"    --color-text-secondary: #999;\n" +
				"    --font-family: -apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, Oxygen-Sans, Ubuntu, Cantarell, \"Helvetica Neue\", sans-serif;\n" +
				"    --hover-brightness: 1.2;\n" +
				"    --justify-important: center;\n" +
				"    --justify-normal: left;\n" +
				"    --line-height: 1.5;\n" +
				"    --width-card: 285px;\n" +
				"    --width-card-medium: 460px;\n" +
				"    --width-card-wide: 800px;\n" +
				"    --width-content: 1080px;\n" +
				"}\n" +
				"\n" +
				"/*\n" +
				"@media (prefers-color-scheme: dark) {\n" +
				"    :root {\n" +
				"        --color: #0097fc;\n" +
				"        --color-accent: #0097fc4f;\n" +
				"        --color-bg: #333;\n" +
				"        --color-bg-secondary: #555;\n" +
				"        --color-secondary: #e20de9;\n" +
				"        --color-secondary-accent: #e20de94f;\n" +
				"        --color-shadow: #bbbbbb20;\n" +
				"        --color-text: #f7f7f7;\n" +
				"        --color-text-secondary: #aaa;\n" +
				"    }\n" +
				"}\n" +
				"*/\n" +
				"\n" +
				"/* Layout */\n" +
				"article aside {\n" +
				"    background: var(--color-secondary-accent);\n" +
				"    border-left: 4px solid var(--color-secondary);\n" +
				"    padding: 0.01rem 0.8rem;\n" +
				"}\n" +
				"\n" +
				"body {\n" +
				"    background: var(--color-bg);\n" +
				"    color: var(--color-text);\n" +
				"    font-family: var(--font-family);\n" +
				"    line-height: var(--line-height);\n" +
				"    margin: 0;\n" +
				"    overflow-x: hidden;\n" +
				"    padding: 1rem 0;\n" +
				"}\n" +
				"\n" +
				"footer,\n" +
				"header,\n" +
				"main {\n" +
				"    margin: 0 auto;\n" +
				"    max-width: var(--width-content);\n" +
				"    padding: 2rem 1rem;\n" +
				"}\n" +
				"\n" +
				"hr {\n" +
				"    background-color: var(--color-bg-secondary);\n" +
				"    border: none;\n" +
				"    height: 1px;\n" +
				"    margin: 4rem 0;\n" +
				"}\n" +
				"\n" +
				"section {\n" +
				"    display: flex;\n" +
				"    flex-wrap: wrap;\n" +
				"    justify-content: var(--justify-important);\n" +
				"}\n" +
				"\n" +
				"section aside {\n" +
				"    border: 1px solid var(--color-bg-secondary);\n" +
				"    border-radius: var(--border-radius);\n" +
				"    box-shadow: var(--box-shadow) var(--color-shadow);\n" +
				"    margin: 1rem;\n" +
				"    padding: 1.25rem;\n" +
				"    width: var(--width-card);\n" +
				"}\n" +
				"\n" +
				"section aside:hover {\n" +
				"    box-shadow: var(--box-shadow) var(--color-bg-secondary);\n" +
				"}\n" +
				"\n" +
				"section aside img {\n" +
				"    max-width: 100%;\n" +
				"}\n" +
				"\n" +
				"[hidden] {\n" +
				"    display: none;\n" +
				"}\n" +
				"\n" +
				"/* Headers */\n" +
				"article header,\n" +
				"div header,\n" +
				"main header {\n" +
				"    padding-top: 0;\n" +
				"}\n" +
				"\n" +
				"header {\n" +
				"    text-align: var(--justify-important);\n" +
				"}\n" +
				"\n" +
				"header a b,\n" +
				"header a em,\n" +
				"header a i,\n" +
				"header a strong {\n" +
				"    margin-left: 0.5rem;\n" +
				"    margin-right: 0.5rem;\n" +
				"}\n" +
				"\n" +
				"header nav img {\n" +
				"    margin: 1rem 0;\n" +
				"}\n" +
				"\n" +
				"section header {\n" +
				"    padding-top: 0;\n" +
				"    width: 100%;\n" +
				"}\n" +
				"\n" +
				"/* Nav */\n" +
				"nav {\n" +
				"    align-items: center;\n" +
				"    display: flex;\n" +
				"    font-weight: bold;\n" +
				"    justify-content: space-between;\n" +
				"    margin-bottom: 7rem;\n" +
				"}\n" +
				"\n" +
				"nav ul {\n" +
				"    list-style: none;\n" +
				"    padding: 0;\n" +
				"}\n" +
				"\n" +
				"nav ul li {\n" +
				"    display: inline-block;\n" +
				"    margin: 0 0.5rem;\n" +
				"    position: relative;\n" +
				"    text-align: left;\n" +
				"}\n" +
				"\n" +
				"/* Nav Dropdown */\n" +
				"nav ul li:hover ul {\n" +
				"    display: block;\n" +
				"}\n" +
				"\n" +
				"nav ul li ul {\n" +
				"    background: var(--color-bg);\n" +
				"    border: 1px solid var(--color-bg-secondary);\n" +
				"    border-radius: var(--border-radius);\n" +
				"    box-shadow: var(--box-shadow) var(--color-shadow);\n" +
				"    display: none;\n" +
				"    height: auto;\n" +
				"    left: -2px;\n" +
				"    padding: .5rem 1rem;\n" +
				"    position: absolute;\n" +
				"    top: 1.7rem;\n" +
				"    white-space: nowrap;\n" +
				"    width: auto;\n" +
				"    z-index: 1;\n" +
				"}\n" +
				"\n" +
				"nav ul li ul::before {\n" +
				"    /* fill gap above to make mousing over them easier */\n" +
				"    content: \"\";\n" +
				"    position: absolute;\n" +
				"    left: 0;\n" +
				"    right: 0;\n" +
				"    top: -0.5rem;\n" +
				"    height: 0.5rem;\n" +
				"}\n" +
				"\n" +
				"nav ul li ul li,\n" +
				"nav ul li ul li a {\n" +
				"    display: block;\n" +
				"}\n" +
				"\n" +
				"/* Typography */\n" +
				"code,\n" +
				"samp {\n" +
				"    background-color: var(--color-accent);\n" +
				"    border-radius: var(--border-radius);\n" +
				"    color: var(--color-text);\n" +
				"    display: inline-block;\n" +
				"    margin: 0 0.1rem;\n" +
				"    padding: 0 0.5rem;\n" +
				"}\n" +
				"\n" +
				"details {\n" +
				"    margin: 1.3rem 0;\n" +
				"}\n" +
				"\n" +
				"details summary {\n" +
				"    font-weight: bold;\n" +
				"    cursor: pointer;\n" +
				"}\n" +
				"\n" +
				"h1,\n" +
				"h2,\n" +
				"h3,\n" +
				"h4,\n" +
				"h5,\n" +
				"h6 {\n" +
				"    line-height: var(--line-height);\n" +
				"}\n" +
				"\n" +
				"mark {\n" +
				"    padding: 0.1rem;\n" +
				"}\n" +
				"\n" +
				"ol li,\n" +
				"ul li {\n" +
				"    padding: 0.2rem 0;\n" +
				"}\n" +
				"\n" +
				"p {\n" +
				"    margin: 0.75rem 0;\n" +
				"    padding: 0;\n" +
				"}\n" +
				"\n" +
				"pre {\n" +
				"    margin: 1rem 0;\n" +
				"    max-width: var(--width-card-wide);\n" +
				"    padding: 1rem 0;\n" +
				"}\n" +
				"\n" +
				"pre code,\n" +
				"pre samp {\n" +
				"    display: block;\n" +
				"    max-width: var(--width-card-wide);\n" +
				"    padding: 0.5rem 2rem;\n" +
				"    white-space: pre-wrap;\n" +
				"}\n" +
				"\n" +
				"small {\n" +
				"    color: var(--color-text-secondary);\n" +
				"}\n" +
				"\n" +
				"sup {\n" +
				"    background-color: var(--color-secondary);\n" +
				"    border-radius: var(--border-radius);\n" +
				"    color: var(--color-bg);\n" +
				"    font-size: xx-small;\n" +
				"    font-weight: bold;\n" +
				"    margin: 0.2rem;\n" +
				"    padding: 0.2rem 0.3rem;\n" +
				"    position: relative;\n" +
				"    top: -2px;\n" +
				"}\n" +
				"\n" +
				"/* Links */\n" +
				"a {\n" +
				"    color: var(--color-secondary);\n" +
				"    display: inline-block;\n" +
				"    font-weight: bold;\n" +
				"    text-decoration: none;\n" +
				"}\n" +
				"\n" +
				"a:hover {\n" +
				"    filter: brightness(var(--hover-brightness));\n" +
				"    text-decoration: underline;\n" +
				"}\n" +
				"\n" +
				"a b,\n" +
				"a em,\n" +
				"a i,\n" +
				"a strong,\n" +
				"button {\n" +
				"    border-radius: var(--border-radius);\n" +
				"    display: inline-block;\n" +
				"    font-size: medium;\n" +
				"    font-weight: bold;\n" +
				"    line-height: var(--line-height);\n" +
				"    margin: 0.5rem 0;\n" +
				"    padding: 1rem 2rem;\n" +
				"}\n" +
				"\n" +
				"button {\n" +
				"    font-family: var(--font-family);\n" +
				"}\n" +
				"\n" +
				"button:hover {\n" +
				"    cursor: pointer;\n" +
				"    filter: brightness(var(--hover-brightness));\n" +
				"}\n" +
				"\n" +
				"a b,\n" +
				"a strong,\n" +
				"button {\n" +
				"    background-color: var(--color);\n" +
				"    border: 2px solid var(--color);\n" +
				"    color: var(--color-bg);\n" +
				"}\n" +
				"\n" +
				"a em,\n" +
				"a i {\n" +
				"    border: 2px solid var(--color);\n" +
				"    border-radius: var(--border-radius);\n" +
				"    color: var(--color);\n" +
				"    display: inline-block;\n" +
				"    padding: 1rem 2rem;\n" +
				"}\n" +
				"\n" +
				"/* Images */\n" +
				"figure {\n" +
				"    margin: 0;\n" +
				"    padding: 0;\n" +
				"}\n" +
				"\n" +
				"figure img {\n" +
				"    max-width: 100%;\n" +
				"}\n" +
				"\n" +
				"figure figcaption {\n" +
				"    color: var(--color-text-secondary);\n" +
				"}\n" +
				"\n" +
				"/* Forms */\n" +
				"\n" +
				"button:disabled,\n" +
				"input:disabled {\n" +
				"    background: var(--color-bg-secondary);\n" +
				"    border-color: var(--color-bg-secondary);\n" +
				"    color: var(--color-text-secondary);\n" +
				"    cursor: not-allowed;\n" +
				"}\n" +
				"\n" +
				"button[disabled]:hover {\n" +
				"    filter: none;\n" +
				"}\n" +
				"\n" +
				"form {\n" +
				"    border: 1px solid var(--color-bg-secondary);\n" +
				"    border-radius: var(--border-radius);\n" +
				"    box-shadow: var(--box-shadow) var(--color-shadow);\n" +
				"    display: block;\n" +
				"    max-width: var(--width-card-wide);\n" +
				"    min-width: var(--width-card);\n" +
				"    padding: 1.5rem;\n" +
				"    text-align: var(--justify-normal);\n" +
				"}\n" +
				"\n" +
				"form header {\n" +
				"    margin: 1.5rem 0;\n" +
				"    padding: 1.5rem 0;\n" +
				"}\n" +
				"\n" +
				"input,\n" +
				"label,\n" +
				"select,\n" +
				"textarea {\n" +
				"    display: block;\n" +
				"    font-size: inherit;\n" +
				"    max-width: var(--width-card-wide);\n" +
				"}\n" +
				"\n" +
				"input[type=\"checkbox\"],\n" +
				"input[type=\"radio\"] {\n" +
				"    display: inline-block;\n" +
				"}\n" +
				"\n" +
				"input[type=\"checkbox\"]+label,\n" +
				"input[type=\"radio\"]+label {\n" +
				"    display: inline-block;\n" +
				"    font-weight: normal;\n" +
				"    position: relative;\n" +
				"    top: 1px;\n" +
				"}\n" +
				"\n" +
				"input,\n" +
				"select,\n" +
				"textarea {\n" +
				"    border: 1px solid var(--color-bg-secondary);\n" +
				"    border-radius: var(--border-radius);\n" +
				"    margin-bottom: 1rem;\n" +
				"    padding: 0.4rem 0.8rem;\n" +
				"}\n" +
				"\n" +
				"input[readonly],\n" +
				"textarea[readonly] {\n" +
				"    background-color: var(--color-bg-secondary);\n" +
				"}\n" +
				"\n" +
				"label {\n" +
				"    font-weight: bold;\n" +
				"    margin-bottom: 0.2rem;\n" +
				"}\n" +
				"\n" +
				"/* Tables */\n" +
				"table {\n" +
				"    border: 1px solid var(--color-bg-secondary);\n" +
				"    border-radius: var(--border-radius);\n" +
				"    border-spacing: 0;\n" +
				"    display: inline-block;\n" +
				"    max-width: 100%;\n" +
				"    overflow-x: auto;\n" +
				"    padding: 0;\n" +
				"    white-space: nowrap;\n" +
				"}\n" +
				"\n" +
				"table td,\n" +
				"table th,\n" +
				"table tr {\n" +
				"    padding: 0.4rem 0.8rem;\n" +
				"    text-align: var(--justify-important);\n" +
				"}\n" +
				"\n" +
				"table thead {\n" +
				"    background-color: var(--color);\n" +
				"    border-collapse: collapse;\n" +
				"    border-radius: var(--border-radius);\n" +
				"    color: var(--color-bg);\n" +
				"    margin: 0;\n" +
				"    padding: 0;\n" +
				"}\n" +
				"\n" +
				"table thead th:first-child {\n" +
				"    border-top-left-radius: var(--border-radius);\n" +
				"}\n" +
				"\n" +
				"table thead th:last-child {\n" +
				"    border-top-right-radius: var(--border-radius);\n" +
				"}\n" +
				"\n" +
				"table thead th:first-child,\n" +
				"table tr td:first-child {\n" +
				"    text-align: var(--justify-normal);\n" +
				"}\n" +
				"\n" +
				"table tr:nth-child(even) {\n" +
				"    background-color: var(--color-accent);\n" +
				"}\n" +
				"\n" +
				"/* Quotes */\n" +
				"blockquote {\n" +
				"    display: block;\n" +
				"    font-size: x-large;\n" +
				"    line-height: var(--line-height);\n" +
				"    margin: 1rem auto;\n" +
				"    max-width: var(--width-card-medium);\n" +
				"    padding: 1.5rem 1rem;\n" +
				"    text-align: var(--justify-important);\n" +
				"}\n" +
				"\n" +
				"blockquote footer {\n" +
				"    color: var(--color-text-secondary);\n" +
				"    display: block;\n" +
				"    font-size: small;\n" +
				"    line-height: var(--line-height);\n" +
				"    padding: 1.5rem 0;\n" +
				"}\n" +
				"\n" +
				".inline {\n" +
				"  display:inline;\n" +
				"  margin: 0;\n" +
				"  padding: 0;\n" +
				"}\n" +
				"";

		FileOutputStream outputStream = new FileOutputStream("./LivreHTML/style.css");
		byte[] strToBytes = str.getBytes();
		outputStream.write(strToBytes);
		outputStream.close();


		//creation de toutes les setions .html
		HashMap<String, Section> sections = l.getSection();
		for (Entry<String, Section> entry : sections.entrySet()) {
			Section value = (Section) entry.getValue();
			File file2 = new File("./LivreHTML/"+value.getNom()+".html");
			String str2 = "<!doctype html>\n" +
					"<html lang=\"fr\">\n" +
					"<head>\n" +
					"  <meta charset=\"utf-8\">\n" +
					"  <title>DVStory by Diversus</title>\n" +
					"  <link rel=\"stylesheet\" href=\"../style.css\">\n" +
					"  <script src=\"script.js\"></script>\n" +
					"</head>\n" +
					"<body>\n" +
					"<script src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>"+
					"<script>"+
					"function redirectTo(elem) {"+
					"event.preventDefault();"+
					"top.location.href = elem.firstElementChild.options[elem.firstElementChild.selectedIndex].value"+
					"}"+
					"</script>" +
					"  <header>\n" +
					"    <h1>"+l.getTitre()+"</h1>\n" +
					"    <ul class=\"inline\" id=\"inventaire\"> inventaire :\n";
			for(IObjet o : value.getObjets()) {
				str2 = str2 + "      <li class=\"inline\">"+o.getNom()+"</li>\n";
			}
			str2 = str2 + "    </ul>\n" +
					"  </header>\n" +
					"\n" +
					"  <h3>"+value.getNom()+"</h3>\n" +
					"  <p>"+value.getText()+"</p>\n" +
					"  <ul class=\"inline\" id=\"recuperer\">voici les objets que vous venez de récupéré :\n";
			for(IObjet o : value.getObjets()) {
				str2 = str2 + "      <li class=\"inline\">"+o.getNom()+"</li>\n";
			}
			str2 = str2 +"  </ul>\n" +
					"  <p>Où choisissez vous de vous rendre ?</p>\n" +
					"  <ul>\n";
			//affichage enchainement avec lien cliquable
			for(Enchainement e : value.getEnchainementSource()) {
				str2 = str2 + "      <li> <a href=\"./"+e.getDestinationSection().getNom()+".html\">"+e.getNom()+"</a> : "+e.getTexte()+"<br>( objets requis : ";
				for(IObjet o : e.getObjets()) {
					str2 = str2 + o.getNom() + " ";
				}
				str2 = str2 + ")</li>";
			}
			str2 = str2 +"  </ul>" +
			//affichage enchainement avec un formulaire
			/*
			for(Enchainement e : value.getEnchainementSource()) {
				str2 = str2 + "      <li>"+e.getNom()+" : "+e.getTexte()+"<br>( objets requis : ";
				for(IObjet o : e.getObjets()) {
					str2 = str2 + o.getNom() + " ";
				}
				str2 = str2 + ")</li>";
			}
			str2 = str2 +"  </ul>" +
			"<form name=\"urlselect\" onsubmit=\"return redirectTo(this)\">"+
			"<select name=\"menu\" value=\"GO\">";
			for(Enchainement e : value.getEnchainementSource()) {
				str2 = str2 +"<option value=\"./"+e.getDestinationSection().getNom()+".html\">"+e.getNom()+"</option>";
			}
			str2 = str2 + "</select>"+
					"<input type=\"submit\"></form>"+
			*/
			"</body>\n" +
			"</html>\n" +
			"";
			FileOutputStream outputStream2 = new FileOutputStream("./LivreHTML/"+l.getTitre()+"/"+value.getNom()+".html");
			byte[] strToBytes2 = str2.getBytes();
			outputStream2.write(strToBytes2);
			outputStream2.close();

			//creation de la page de garde
			file2 = new File("./LivreHTML/"+l.getTitre()+".html");
			str2 = "<!doctype html>\n" +
					"<html lang=\"fr\">\n" +
					"<head>\n" +
					"  <meta charset=\"utf-8\">\n" +
					"  <title>DVStory by Diversus</title>\n" +
					"  <link rel=\"stylesheet\" href=\"./style.css\">\n" +
					"  <script src=\"script.js\"></script>\n" +
					"</head>\n" +
					"<body>\n" +
					"<script src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>"+
					"  <header>\n" +
					"<h1>"+l.getTitre()+"</h1>"+
					"<h3>by "+l.getAuteur()+"</h3>"+
					"<a href=\"./"+l.getTitre()+"/"+l.getTetedesection().getNom()+".html\">Commencer</a>"+
					"  </header>\n" +
					"<div style=\"text-align: center\"><img src=\"../LOGO_DVStory.gif\" width=200px height=200px></div>"+
					"<div style=\"text-align: center\"><img src=\"../Logo_Diversus.png\" width=200px height=130px></div>"+
					"</body>\n" +
					"</html>\n" +
					"";
			outputStream2 = new FileOutputStream("./LivreHTML/"+l.getTitre()+".html");
			strToBytes2 = str2.getBytes();
			outputStream2.write(strToBytes2);
			outputStream2.close();
		}
		return null;
	}
}
