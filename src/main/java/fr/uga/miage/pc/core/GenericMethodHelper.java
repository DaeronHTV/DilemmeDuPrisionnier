package fr.uga.miage.pc.core;

import java.io.File;
/*import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;*/

public class GenericMethodHelper {
	/*public static void getXmlFileFromObject(final String fileName, Object obj) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(obj, new File(fileName));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getJaxbObjectFromFile(final String fileName, Class<T> classe) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(classe);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (T)unmarshaller.unmarshal(new File(fileName));
	}*/
}
