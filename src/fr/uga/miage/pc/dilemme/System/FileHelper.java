package fr.uga.miage.pc.dilemme.System;

import java.io.File;
import fr.uga.miage.pc.dilemme.System.Logs.*;

public class FileHelper {

	public static String getRootPath() { return new File("").getAbsolutePath(); }

	public static boolean createFolder(String path, String name) {
		File dir = new File(path + File.separatorChar + name);
		return (dir.exists() && dir.isDirectory()) ? true : dir.mkdirs();
	}
	
	public static boolean createFile(String filePath, String fileName) {
		File file = new File(filePath + File.separatorChar + fileName);
		try {
			if(!file.exists()) return file.createNewFile();
			else LogHelper.info("The file already exists !");
		}
		catch(Exception e) {
			LogHelper.error("Error during the creation of the file !", e);
			return false;
		}
		return true;
	}
}
