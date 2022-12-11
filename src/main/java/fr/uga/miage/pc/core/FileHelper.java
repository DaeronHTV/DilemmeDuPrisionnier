package fr.uga.miage.pc.core;

import java.io.File;
import java.net.URL;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.List;
import fr.uga.miage.pc.dilemme.back.ConstHelper;
import fr.uga.miage.pc.dilemme.back.helper.StringHelper;

public final class FileHelper {
	private static String prefixPackName;
	
	private FileHelper() {}
	
	static {
		String basePackName = Thread.currentThread().getContextClassLoader().getDefinedPackages()[0].getName();
		prefixPackName = StringHelper.substringBefore(basePackName, ".");
	}

	public static List<File> getSubFile(final String path, final boolean recursive) 
			throws NotDirectoryException
	{
		return getSubFile(new File(path), recursive);
	}
	
	public static List<File> getSubFile(final File directory, final boolean recursive) 
			throws NotDirectoryException
	{
		if(!directory.exists() || !directory.isDirectory()) {
			throw new NotDirectoryException("The file given doesn't exist or isn't a directory");
		}
		List<File> directories = new ArrayList<>();
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
		String path = StringHelper.substringAfter(fileClass.getAbsolutePath(), prefixPackName, true);
		return path.substring(0, path.length()-6);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> getClasses(final String packname, final boolean includeSubDir) 
			throws NotDirectoryException, ClassNotFoundException
	{
		String path = packname.replace('.', '/');
		URL resource = Thread.currentThread().getContextClassLoader().getResource(path);
		if (resource == null) {
			throw new ClassNotFoundException("No resource for " + path);
		}
		return getClasses(new File(resource.getFile()), includeSubDir);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> getClasses(final File directory, final boolean includeSubDir) 
			throws NotDirectoryException, ClassNotFoundException
	{
		if(!directory.exists() || !directory.isDirectory()) {
			throw new NotDirectoryException("The file given doesn't exist or isn't a directory");
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
