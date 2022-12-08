package fr.uga.miage.pc.dilemme.back.strategie;

public final class StrategieConstHelper {
	public final static String DDNAME = "Donnant-Donnant";
	public final static String GNNAME = "Gentille";
	public final static String MNNAME = "M�chante";
	public final static String RNAME = "Rancuni�re";
	public final static String DDDNAME = "Donnant-Donnant-Dur";
	public final static String MFNAME = "M�fiante";
	public final static String PERGNAME = "P�riodique-Gentille";
	public final static String PERMNAME = "P�riodique-M�chante";
	public final static String GDESC = "Je coopere toujours.";
	public final static String MDESC = "Je trahis toujours";
	public final static String RDESC = "Je coopere a la premiere partie, mais des que mon adversaire trahit, je trahis toujours.";
	public final static String DDDESC = "Je coopere a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.";
	public final static String DDDDESC = "Je coopere a la premiere partie, puis je coopere sauf si mon adversaire a trahi lors de l'une des deux parties precedentes.";
	public final static String MFDESC = "Je trahis a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.";
	public final static String PERGDESC = "Je joue cooperer, cooperer, trahir, cooperer, cooperer, trahir, ...";
	public final static String PERMDESC = "Je joue trahir, trahir, cooperer, trahir, trahir, cooperer, ...";
}
