package fr.uga.miage.pc.dilemme.System.Logs;

public enum LogLevel implements ILogLevel{
	INFO("INFO"), ERROR("ERROR"), WARNING("WARNING");

	private String code;

	LogLevel(String code) { this.code = code; }

	public String getCode() { return code; }
	
	public static LogLevel fromValue(String v) {
		for (LogLevel c: LogLevel.values()) {
            if (c.toString().equals(v)) return c;
        }
        return null;
    }
}
