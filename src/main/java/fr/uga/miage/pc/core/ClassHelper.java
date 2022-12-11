package fr.uga.miage.pc.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ClassHelper {
	private ClassHelper() {}
	
	public static final <T> List<T> createListObject(final List<Class<? extends T>> classes) 
			throws SecurityException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException
	{
        ArrayList<T> objects = new ArrayList<>();
        for (final Class<? extends T> classe : classes) {
        	T objet = create(classe);
            objects.add(objet);
        }
        return objects;
    }
	
	public static <T> T create(final Class<? extends T> classe) 
			throws SecurityException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException 
	{
		final Constructor<? extends T> constructor = classe.getConstructor();
    	return constructor.newInstance();
	}
	
	public static <T> T clonebyReflection(final T object) 
			throws SecurityException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException
	{
    	@SuppressWarnings("unchecked")
		final Class<? extends T> classe = (Class<? extends T>) object.getClass();
    	return create(classe);
    }
	
	public static boolean haveInterface(Class<?> classe, final Class<?> inter) 
			throws NullPointerException 
	{
		if(classe == null || inter == null) {
			throw new NullPointerException();
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
	public static List<Class> filterClass(final List<Class> classes, final Predicate<? super Class> predicate){
		return classes.stream().filter(predicate).toList();
	}
}
