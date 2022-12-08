package fr.uga.miage.pc.core;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import fr.uga.miage.pc.dilemme.back.ConstHelper;
import fr.uga.miage.pc.dilemme.back.helper.StringHelper;

public final class FileHelper {

	public static List<File> getSubFile(final String path, final boolean recursive) throws Exception{
		return getSubFile(new File(path), recursive);
	}
	
	public static List<File> getSubFile(final File directory, final boolean recursive) throws Exception{
		if(!directory.exists() || !directory.isDirectory()) {
			throw new Exception("The file given doesn't exist or isn't a directory");
		}
		List<File> directories = new ArrayList<File>();
		for(final File file : directory.listFiles()) {
			if(file.isDirectory()) {
				directories.add(file);
				if(recursive) {
					directories.addAll(getSubFile(file, recursive));
				}
			}
		}
		return directories;
	}
	
	public static String classNameByPath(File fileClass) {
		String path = StringHelper.substringAfter(fileClass.getAbsolutePath(), "bin\\");
		return path.substring(0, path.length()-6);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> getClasses(final String packname, final boolean includeSubDir) throws Exception{
		String path = packname.replace('.', '/');
		URL resource = Thread.currentThread().getContextClassLoader().getResource(path);
		if (resource == null) {
			throw new ClassNotFoundException("No resource for " + path);
		}
		return getClasses(new File(resource.getFile()), includeSubDir);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> getClasses(final File directory, final boolean includeSubDir) throws Exception{
		if(!directory.exists() || !directory.isDirectory()) {
			throw new Exception("The file given doesn't exist or isn't a directory");
		}
		List<Class> classes = new ArrayList<>();
		for(final File file: directory.listFiles()) {
			if(file.isDirectory() && includeSubDir) {
				classes.addAll(getClasses(file, includeSubDir));
			}
			else if(file.getAbsolutePath().endsWith(ConstHelper.CLASSEEXTENSION)) {
				String className = classNameByPath(file).replace('\\', '.');
				classes.add(Class.forName(className));
			}
		}
		return classes;
	}
}
