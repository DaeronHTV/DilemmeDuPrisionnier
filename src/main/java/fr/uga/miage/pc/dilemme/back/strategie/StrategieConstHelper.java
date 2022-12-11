package fr.uga.miage.pc.dilemme.back.strategie;

public final class StrategieConstHelper {
	private StrategieConstHelper() {}
	
	public static final String DDNAME = "Donnant-Donnant";
	public static final String GNNAME = "Gentille";
	public static final String MNNAME = "M�chante";
	public static final String RNAME = "Rancuni�re";
	public static final String DDDNAME = "Donnant-Donnant-Dur";
	public static final String MFNAME = "M�fiante";
	public static final String PERGNAME = "P�riodique-Gentille";
	public static final String PERMNAME = "P�riodique-M�chante";
	public static final String GDESC = "Je coopere toujours.";
	public static final String MDESC = "Je trahis toujours";
	public static final String RDESC = "Je coopere a la premiere partie, mais des que mon adversaire trahit, je trahis toujours.";
	public static final String DDDESC = "Je coopere a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.";
	public static final String DDDDESC = "Je coopere a la premiere partie, puis je coopere sauf si mon adversaire a trahi lors de l'une des deux parties precedentes.";
	public static final String MFDESC = "Je trahis a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.";
	public static final String PERGDESC = "Je joue cooperer, cooperer, trahir, cooperer, cooperer, trahir, ...";
	public static final String PERMDESC = "Je joue trahir, trahir, cooperer, trahir, trahir, cooperer, ...";
}
