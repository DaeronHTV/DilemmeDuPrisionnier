package fr.uga.miage.pc.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ClassHelper {
	public final static <T> List<T> createListObject(final List<Class<? extends T>> classes) throws Exception{
        ArrayList<T> objects = new ArrayList<T>();
        for (final Class<? extends T> classe : classes) {
        	T objet = create(classe);
            objects.add(objet);
        }
        return objects;
    }
	
	public static <T> T create(final Class<? extends T> classe) throws Exception {
		final Constructor<? extends T> constructor = classe.getConstructor();
    	return (T)constructor.newInstance();
		
	}
	
	public static <T> T clonebyReflection(final T object) throws Exception {
    	@SuppressWarnings("unchecked")
		final Class<? extends T> classe = (Class<? extends T>) object.getClass();
    	return create(classe);
    }
	
	public static boolean HaveInterface(Class<?> classe, final Class<?> inter) throws Exception {
		if(classe == null || inter == null) {
			throw new Exception();
		}
		while(classe != null) {
			for(final Class<?> interf: classe.getInterfaces()) {
				if(interf.equals(inter)) {
					return true;
				}
			}
			classe = classe.getSuperclass();
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> FilterClass(final List<Class> classes, final Predicate<? super Class> predicate){
		return classes.stream().filter(predicate).toList();
	}
}
