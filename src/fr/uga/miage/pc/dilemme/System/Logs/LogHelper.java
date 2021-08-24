package fr.uga.miage.pc.dilemme.System.Logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import fr.uga.miage.pc.dilemme.System.*;
import static fr.uga.miage.pc.dilemme.System.StringHelper.getErrorMessage;

public final class LogHelper {
	private static boolean logFile;
	private static String filepath = "logs/VisioPadLog.log";
	
	static {
	
	}
	
	public static boolean fileActivate() { return logFile; }

	public static void setLogFile(boolean activate) { logFile = activate; }
	
	public static String getFilePath() { return filepath; }
	
	public static void setFilePath(String path) { filepath = path; }
	
	/********************************************/
	/*ENSEMBLE DES FONCTIONS D'ECRITURE DES LOGS*/
	/********************************************/	
	public static void info(CharSequence seq) { log(LogLevel.INFO, seq); }
	
	public static void info(Throwable e) { log(LogLevel.INFO, e); }
	
	public static void info(CharSequence seq, Throwable e) { log(LogLevel.INFO, seq, e); }
	
	public static void warning(CharSequence seq) { log(LogLevel.WARNING, seq); }
	
	public static void warning(Throwable e) { log(LogLevel.WARNING, e); }
	
	public static void warning(CharSequence seq, Throwable e) { log(LogLevel.WARNING, seq, e); }

	public static void error(CharSequence seq) { log(LogLevel.ERROR, seq); }

	public static void error(Throwable e) { log(LogLevel.ERROR, e); }

	public static void error(CharSequence seq, Throwable e) { log(LogLevel.ERROR, seq, e); }
	
	public static void log(ILogLevel level, Throwable e) {
		log(level, "", e);
	}

	public static void log(ILogLevel level, CharSequence seq) {
		CharSequence message = Now() + " - " + level.getCode() + " : " + seq;
		System.out.println(message);
		if (logFile) write(message + "\n");
	}

	public static void log(ILogLevel level, CharSequence seq, Throwable e) {
		log(level, seq + "\n" + getErrorMessage(e));
	}

	private static void write(String seq) {
		try {
			if (FileHelper.createFolder(FileHelper.getRootPath(), "logs")) {
				FileWriter pw = new FileWriter(FileHelper.getRootPath() + File.separatorChar + filepath, true);
				pw.write(seq);
				pw.close();
			}
		} 
		catch (IOException ioe) { ioe.printStackTrace(); }
	}

	private static String Now() {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return format.format(new Date());
	}
}
