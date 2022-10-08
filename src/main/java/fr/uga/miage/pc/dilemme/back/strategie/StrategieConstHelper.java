package fr.uga.miage.pc.dilemme.back.strategie;

public final class StrategieConstHelper {
	public final static String DDName = "Donnant-Donnant";
	public final static String GName = "Gentille";
	public final static String MName = "Méchante";
	public final static String RName = "Rancunière";
	public final static String DDDName = "Donnant-Donnant-Dur";
	public final static String MfName = "Méfiante";
	public final static String PerGName = "Périodique-Gentille";
	public final static String PerMName = "Périodique-Méchante";
	public final static String GDesc = "Je coopere toujours.";
	public final static String MDesc = "Je trahis toujours";
	public final static String RDesc = "Je coopere a la premiere partie, mais des que mon adversaire trahit, je trahis toujours.";
	public final static String DDDesc = "Je coopere a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.";
	public final static String DDDDesc = "Je coopere a la premiere partie, puis je coopere sauf si mon adversaire a trahi lors de l'une des deux parties precedentes.";
	public final static String MfDesc = "Je trahis a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.";
	public final static String PerGDesc = "Je joue cooperer, cooperer, trahir, cooperer, cooperer, trahir, ...";
	public final static String PerMDesc = "Je joue trahir, trahir, cooperer, trahir, trahir, cooperer, ...";
}
