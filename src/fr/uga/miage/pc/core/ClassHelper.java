package fr.uga.miage.pc.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ClassHelper {
	public final static <T> List<T> createListObject(List<Class<? extends T>> classes) {
        ArrayList<T> objects = new ArrayList<T>();
        for (Class<? extends T> classe : classes) {
            try {
            	T objet = create(classe);
            	objects.add(objet);
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
        return objects;
    }
	
	public static <T> T create(Class<? extends T> classe) throws Exception {
		Constructor<? extends T> constructor = classe.getConstructor();
    	return (T)constructor.newInstance();
		
	}
	
	public static <T> T clonebyReflection(T object) throws Exception {
    	@SuppressWarnings("unchecked")
		Class<? extends T> classe = (Class<? extends T>) object.getClass();
    	return create(classe);
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
