package fr.uga.miage.pc.dilemme.back.helper;

import fr.uga.miage.pc.dilemme.back.interfaces.*;
import fr.uga.miage.pc.dilemme.back.Confrontation.ConfrontationConstants;
import fr.uga.miage.pc.dilemme.back.ConstHelper;
import fr.uga.miage.pc.interfaces.IStrategie;

/**
 * This class allows the back to format the result it has into a text that
 * can be used by the front to show them to the user
 * @implSpec This is a static class
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 3.0
 * @version 1.0
 */
public final class StringHelper {
	public final static String Empty = "";
	
	public static boolean isNullOrEmpty(final CharSequence str) {
		return str == null || str.isEmpty();
	}
	
	public static String substringAfter(final String str, final String separator) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        if (separator == null) {
            return "";
        }
        final int pos = str.indexOf(separator);
        if (pos == 0) {
            return str;
        }
        return str.substring(pos + separator.length());
    }	
	
    public final static String tournoi(final ITournoi tournoi) {
    	final StringBuilder builder = new StringBuilder(tournoi.NbChallenger()*20);
    	builder.append("<h2>Voici la configuration du tournoi actuelle :</h2><p><b>Nombre de rencontre : </b>");
    	builder.append(tournoi.Confrontations().size());
    	builder.append("<br/><b>Nombre de Tours par rencontre :</b> ").append(tournoi.NbTours()).append(ConstHelper.BR);
    	builder.append("<br/><b><u>Ce Tournoi opposera les strategies suivantes :</u></b><br/>");
    	for(int i = 0; i < tournoi.NbChallenger(); i++) {
    		builder.append(tournoi.Challenger(i).getStrategyName()).append(" : ")
    		.append(tournoi.Challenger(i).getDescription()).append(ConstHelper.BR);
    	}
    	builder.append("</p><p><b><u>Voici les differentes rencontres du tournoi :</u></b> <br/>");
        for(final IConfrontation confrontation: tournoi.Confrontations()) {
        	builder.append("Rencontre " + confrontation.Numero() + " : " + confrontation.toString() + "<br/>");
        }
        builder.append(ConstHelper.PFermant);
        return builder.toString();
    }
    
    public final static String sumUpTournoiWithHtml(final ITournoi tournoi) {
    	final StringBuilder builder = new StringBuilder();
    	final StringBuilder builderTmp = new StringBuilder();
    	builder.append(ConstHelper.TableauBase);
        for(int i = 0; i < tournoi.NbChallenger(); i++) {
        	int total = 0; 
        	String nom = tournoi.Challenger(i).getStrategyName();
            builder.append(ConstHelper.TdWithBorder).append("<b>").append(nom).append("</b></td>");
            builderTmp.append("<tr border: 1px solid black;><td border: 1px solid black;><b>").append(nom).append("</b></td>");
			for(final IConfrontation confrontation: tournoi.Confrontations()) {
				if(tournoi.Challenger(i).equals(confrontation.Strategie(ConfrontationConstants.STRATEGIE_1))) {
					total += confrontation.FinalScore(ConfrontationConstants.STRATEGIE_1);
                    builderTmp.append(ConstHelper.TdWithBorder)
                    .append(confrontation.FinalScore(ConfrontationConstants.STRATEGIE_1));
				}else if(tournoi.Challenger(i).equals(confrontation.Strategie(ConfrontationConstants.STRATEGIE_2))){
					total += confrontation.FinalScore(ConfrontationConstants.STRATEGIE_2);
					builderTmp.append(ConstHelper.TdWithBorder)
					.append(confrontation.FinalScore(ConfrontationConstants.STRATEGIE_2));
				}
				builderTmp.append("</td>");
			}
			builderTmp.append(ConstHelper.TdWithBorder).append(total).append("</td></tr>");
        }
        builder.append(ConstHelper.TdWithBorder).append("<b color='red'>TOTAL</b></td></tr>");
        return builder.toString() + builderTmp.toString();
    }
    
    /**
     * Give the sum up of the confrontation on a text
     * @param num the number of the confrontation
     * @param Confrontation Confrontation where the sum up is needed
     * @return String A text with the sum up
     * @since 3.0
     */
    public final static String sumUpConfrontation(final boolean isHtml, final IConfrontation confrontation){
        String result = sumUpConfrontation(confrontation);
    	if(isHtml){
            result = "<p>" + result + ConstHelper.PFermant;
            result = result.replace(ConstHelper.SautLigne, ConstHelper.BR);
        }
        return result;
    }
    
    private final static String sumUpConfrontation(final IConfrontation confrontation) {
    	final IStrategie s1 = confrontation.Strategie(ConfrontationConstants.STRATEGIE_1);
        final IStrategie s2 = confrontation.Strategie(ConfrontationConstants.STRATEGIE_2);
        final StringBuilder builder = new StringBuilder();
        builder.append("Rencontre N°").append(confrontation.Numero()).append(" - ").append(confrontation.toString())
        .append(ConstHelper.SautLigne).append("Le score final est de : \n").append(s1.getStrategyName()).append(" : ")
        .append(confrontation.FinalScore(ConfrontationConstants.STRATEGIE_1)).append(ConstHelper.SautLigne)
        .append(s2.getStrategyName()).append(" : ")
        .append(confrontation.FinalScore(ConfrontationConstants.STRATEGIE_2));
        return builder.toString();
    }
}
