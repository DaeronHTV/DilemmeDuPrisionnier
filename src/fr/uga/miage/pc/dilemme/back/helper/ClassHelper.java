package fr.uga.miage.pc.dilemme.back.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Predicate;

import fr.uga.miage.pc.interfaces.IStrategie;

public class ClassHelper {
	public static IStrategie create(Class<? extends IStrategie> strategie) throws Exception {
		Constructor<? extends IStrategie> constructor = strategie.getConstructor();
    	return (IStrategie)constructor.newInstance();
		
	}
	
	public static <T> T clonebyReflection(T strategie) throws Exception {
    	@SuppressWarnings("unchecked")
		Class<? extends T> classe = (Class<? extends T>) strategie.getClass();
    	Constructor<? extends T> constructor = classe.getConstructor();
    	return (T)constructor.newInstance();
    }
	
	public static boolean HaveInterface(Class<?> classe, Class<?> inter) throws Exception {
		if(classe == null || inter == null) {
			throw new Exception();
		}
		while(classe != null) {
			for(Class<?> interf: classe.getInterfaces()) {
				if(interf.equals(inter)) {
					return true;
				}
			}
			classe = classe.getSuperclass();
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> FilterClass(List<Class> classes, Predicate<? super Class> predicate){
		return classes.stream().filter(predicate).toList();
	}
}
