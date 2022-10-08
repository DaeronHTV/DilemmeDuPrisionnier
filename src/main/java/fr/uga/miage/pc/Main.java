package fr.uga.miage.pc;
import java.util.ArrayList;

import fr.uga.miage.pc.core.GenericMethodHelper;
import fr.uga.miage.pc.dilemme.front.JDilemme;
import fr.uga.miage.pc.dilemme.front.content.JDilemmeContent;
import fr.uga.miage.pc.dilemme.front.content.MapElement;

public class Main {

	public static void main(String[] args) throws Exception {
		JDilemme.getInstance().showFrame();
		/*JDilemmeContent content = new JDilemmeContent();
		content.Buttons = new ArrayList<MapElement>();
		MapElement test = new MapElement();
		content.Buttons.add(test);
		content.WindowTitle = "Hello World";
		GenericMethodHelper.getXmlFileFromObject("./test.xml", content);*/
	}
}
