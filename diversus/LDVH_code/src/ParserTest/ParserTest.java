package ParserTest;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import composants.CLivre.Livre;
import composants.Factory.CFactory;
import itf.ILivre;
import itf.IParser;

public class ParserTest {

	CLivreBouchon LivreBouchon;
	protected IParser parser;

	public ParserTest() {
		
	}
	
	@Before
	public void creation() {

		LivreBouchon = (CLivreBouchon) CFactory.CreateLivreBouchon("Jungle", "Rudyard Kipling");
		parser = CFactory.createParser();

	}

	@Test
	public void parserTest() throws DocumentException {

		assertEquals("Jungle", LivreBouchon.getTitre());
		assertEquals("Rudyard Kipling", LivreBouchon.getAuteur());
		
		LivreBouchon.addObjet("obj1");
		LivreBouchon.addObjet("obj2");
		LivreBouchon.addObjet("obj3");

		String section1 = LivreBouchon.createSection("sec1", "sec1blablabla");
		String section2 = LivreBouchon.createSection("sec2", "sec2blablabla");
		String section3 = LivreBouchon.createSection("sec3", "sec3blablabla");

		try {
			assert (LivreBouchon.SectionExist("sec1"));
			assert (LivreBouchon.SectionExist("sec2"));
			assert (LivreBouchon.SectionExist("sec3"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		
		try {

			String fichier_pdf = parser.generateHTML(LivreBouchon);
			File file1 = new File("./LivreHTML/Jungle");
			assert (file1.exists());
			//assertEquals("Jungle.pdf", nom_fichier_pdf);

			String fichier_html = parser.generateImprimable(LivreBouchon);
			File file2 = new File("./LivrePDF/Jungle.pdf");
			assert (file2.exists());
			// assertEquals("Jungle.html", nom_fichier_html);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void HTMLTest() throws IOException {
		BufferedReader in1 = new BufferedReader(new FileReader("./LivreHTML/Jungle/sec1.html"));
		BufferedReader in2 = new BufferedReader(new FileReader("./LivreHTML/Jungle/sec2.html"));
		BufferedReader in3 = new BufferedReader(new FileReader("./LivreHTML/Jungle/sec3.html"));
		String line, content1 = "", content2 = "", content3 = "";
		while ((line = in1.readLine()) != null) {
			content1 = content1 + line;
			// Afficher le contenu du section 1
			System.out.println(line);

		}
		assert (content1.contains("sec1"));
		assert (content1.contains("sec1blablabla"));
		assert (content1.contains("obj1"));
		assert (content1.contains("obj2"));
		assert (content1.contains("obj3"));
		in1.close();
		
		
		while ((line = in2.readLine()) != null) {
			content2 = content2 + line;
			// Afficher le contenu de section 2
			System.out.println(line);
		}
		assert (content2.contains("sec2"));
		assert (content2.contains("sec2blablabla"));
		assert (content2.contains("obj1"));
		assert (content2.contains("obj2"));
		assert (content2.contains("obj3"));
		in2.close();
		
		
		while ((line = in3.readLine()) != null) {
			content3 = content3 + line;
			// Afficher le contenu du section 3
			System.out.println(line);
		}
	assert (content3.contains("sec3"));
	assert (content3.contains("sec3blablabla"));
	assert (content3.contains("obj1"));
	assert (content3.contains("obj2"));
	assert (content3.contains("obj3"));
	in3.close();
	}
	@Test
	public void pdfTest() {
		try {
			// Créer une instance PdfReader.

			PdfReader pdf = new PdfReader("./LivrePDF/Jungle");

			// Récupérer le nombre de pages en pdf.
			int nbrPages = pdf.getNumberOfPages();
			String content = "";
			// Itérer le pdf à travers les pages.
			for (int i = 1; i <= nbrPages; i++) {
				// Extraire le contenu de la page à l'aide de PdfTextExtractor.
				content = content + PdfTextExtractor.getTextFromPage(pdf, i);

				// Afficher le contenu de la page sur la console.
				System.out.println("Contenu du page : " + content);

			}
			assert (content.contains("sec1"));
			assert (content.contains("sec2"));
			assert (content.contains("sec3"));
			assert (content.contains("blablabla"));
			assert (content.contains("obj1"));
			assert (content.contains("obj2"));
			assert (content.contains("obj3"));
			// Fermez le PdfReader.
			pdf.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}