package fr.uga.miage.pc.dilemme.front.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;*/

//@XmlRootElement
public class JDilemmeContent {
	/*@XmlElement(name="Title", required=true)
	public String WindowTitle;
	
	@XmlElementWrapper
	@XmlElement(name="Button", required=true)
	public List<MapElement> Buttons;
	
	@XmlTransient
	private Map<String, String> ButtonsMap = null;
	
	@XmlTransient
	public Map<String, String> ButtonsMap(){
		if(ButtonsMap == null) {
			ButtonsMap = new HashMap<String, String>();
			for(MapElement element: Buttons) {
				ButtonsMap.put(element.name, element.valeur);
			}
		}
		return ButtonsMap;
	}*/
}

