import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class librosxml {




	public static void main(String[] args) {
		try {

			// Se crea el SAXBuilder para realizar el parseo del archivo XML
			SAXBuilder builder = new SAXBuilder();

			// Construimos el arbol DOM a partir del fichero xml
			Document document = builder.build(new FileInputStream("JDOM II.xml"));

			// Se obtiene el elemento raiz
			Element rootNode = document.getRootElement();
			// Se obtiene la lista de elementos de la raiz
			List<Element> libros = rootNode.getChildren("book");

			float total = 0;

			// Recorrido de cada uno de los libros : Primer Nivel
			for (Element libro : libros) {

				System.out.println("ISBN : " + libro.getAttributeValue("ISBN"));

				System.out.println("Titulo : "+ libro.getChildText("title"));

				System.out.println("Precio : " + libro.getChildText("price"));

				total = total + Float.parseFloat(libro.getChildText("price"));

				System.out.print("Comentarios : ");

				// Recorrido de los comentarios de cada libro : Segundo Nivel
				for (Element comentario : libro.getChild("comments").getChildren()) {

					System.out.print(comentario.getValue() + "\n");

				}



				System.out.println("------------------------------------");
			}

			System.out.println("Suma Precios:" + total);


		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}

	}



}
