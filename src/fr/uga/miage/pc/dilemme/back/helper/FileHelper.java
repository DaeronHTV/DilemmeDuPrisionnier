package fr.uga.miage.pc.dilemme.back.helper;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import fr.uga.miage.pc.dilemme.back.ConstHelper;

public final class FileHelper {

	public static List<File> GetSubFile(String path, boolean recursive) throws Exception{
		return GetSubFile(new File(path), recursive);
	}
	
	public static List<File> GetSubFile(File directory, boolean recursive) throws Exception{
		if(!directory.exists() || !directory.isDirectory()) {
			throw new Exception("The file given doesn't exist or isn't a directory");
		}
		List<File> directories = new ArrayList<File>();
		for(File file : directory.listFiles()) {
			if(file.isDirectory()) {
				directories.add(file);
				if(recursive) {
					directories.addAll(GetSubFile(file, recursive));
				}
			}
		}
		return directories;
	}
	
	public static String ClassNameByPath(File fileClass) {
		String path = StringHelper.substringAfter(fileClass.getAbsolutePath(), "bin\\");
		return path.substring(0, path.length()-6);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> GetClasses(String packname, boolean includeSubDir) throws Exception{
		String path = packname.replace('.', '/');
		URL resource = Thread.currentThread().getContextClassLoader().getResource(path);
		if (resource == null) {
			throw new ClassNotFoundException("No resource for " + path);
		}
		return GetClasses(new File(resource.getFile()), includeSubDir);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> GetClasses(File directory, boolean includeSubDir) throws Exception{
		if(!directory.exists() || !directory.isDirectory()) {
			throw new Exception("The file given doesn't exist or isn't a directory");
		}
		List<Class> classes = new ArrayList<Class>();
		for(File file: directory.listFiles()) {
			if(file.isDirectory() && includeSubDir) {
				classes.addAll(GetClasses(file, includeSubDir));
			}
			else if(file.getAbsolutePath().endsWith(ConstHelper.ClasseExtension)) {
				String className = ClassNameByPath(file).replace('\\', '.');
				classes.add(Class.forName(className));
			}
		}
		return classes;
	}
}
