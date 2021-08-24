package fr.uga.miage.pc.dilemme.System;

import fr.uga.miage.pc.dilemme.System.Logs.LogHelper;

public final class StringHelper {

	public static CharSequence getErrorMessage(final Throwable e) {
		CharSequence result = "";
		for (final StackTraceElement st : e.getStackTrace()) 
			result = result + "at " + st.toString() + "\n";
		return result;
	}

	public static boolean IsNull(final String object) {
		return object == null;
	}

	public static boolean IsNullOrEmpty(final String object) {
		return object == null || object.isEmpty();
	}
	
	public static boolean IsNullOrWhiteSpace(final String object) {
		return object == null || object.isBlank();
	}
	
	public static String Format(String texte, final String... args) {
		for(int i = 0; i < args.length; i++) {
			final String elt = "{"+i+"}";
			if(!texte.contains(elt)) {
				LogHelper.warning("Attention ! Chaine mal definie ou trop d'arguments !");
				return null;
			}
			texte = texte.replace(elt, args[i]);
		}
		return texte;
	}
	
	public static String Concat(final String... args) {
		String result = "";
		for(int i = 0; i < args.length; i++) result += args[i];
		return result;
	}
}
