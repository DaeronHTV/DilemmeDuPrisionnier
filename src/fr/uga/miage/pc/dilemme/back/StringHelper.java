package fr.uga.miage.pc.dilemme.back;

import fr.uga.miage.pc.dilemme.back.Confrontation.ConfrontationConstants;
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

    /**
     * Give the configuration of the tournament on a text
     * @param tournoi Tournoi where the text is needed
     * @return String A text with the configuration of the tournament
     * @since 3.0
     */
    public static String tournoi(boolean isHtml, Tournoi tournoi){
        String result = "";
        if(isHtml){
            result += "<h2>Voici la configuration du tournoi actuelle :</h2><p><b>Nombre de rencontre : </b>" 
            + tournoi.getConfrontations().size() + "<br/><b>Nombre de Tours par rencontre :</b> " + tournoi.getNbTours() + "<br/>" +
            "<br/><b><u>Ce Tournoi opposera les strategies suivantes :</u></b><br/>";
            for(IStrategie strategie: tournoi.getStrategies()) { result += strategie.toString() + "<br/>"; }
            int i = 0;
            result += "</p><p><b><u>Voici les differentes rencontres du tournoi :</u></b> <br/>";
            for(Confrontation confrontation: tournoi.getConfrontations()) {
                result += "Rencontre " + i + " : " + confrontation.toString() + "<br/>";
                i++;
            }
            result += "</p>";
        }else{
            result += "Voici la configuration du tournoi actuelle :\nNombre de rencontre : " 
		    + tournoi.getConfrontations().size() + "\nNombre de Tours par rencontre : " + tournoi.getNbTours() + "\n" +
		    "\nCe Tournoi opposera les strategies suivantes :\n";
		    for(IStrategie strategie: tournoi.getStrategies()) { result += strategie.toString() + "\n"; }
		    result += "\nVoici les differentes rencontres du tournoi : \n" + tournoi.toString();
        }
		return result;
    }
    
    
    /**
     * Give the sum up of the tournament on a text
     * @param tournoi Tournoi where the sum up is needed
     * @return String A text with the sum up
     * @since 3.0
     */
    public static String sumUpTournoi(boolean isHtml, Tournoi tournoi){
        String line = "\n--------------------------------------------------------------------------\n";
        String result = isHtml ? "<table><tr border: 1px solid black;><td></td>" : "\t|";
        String resultTmp = "";
        for(IStrategie strategie: tournoi.getStrategies()){
            int total = 0; String nom = strategie.getStrategyName();
            result += isHtml ? "<td border: 1px solid black;><b>" + nom + "</b></td>" : nom + "|" ;
            resultTmp += isHtml ? "<tr border: 1px solid black;><td border: 1px solid black;><b>" + nom + "</b></td>" : nom + "|";
			for(Confrontation confrontation: tournoi.getConfrontations()) {
				if(strategie.equals(confrontation.getStrategie(ConfrontationConstants.STRATEGIE_1))) {
					total += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1);
                    resultTmp += isHtml ? "<td border: 1px solid black;>"+ confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1) + "</td>"
                    : confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1) + "\t|";
				}else if(strategie.equals(confrontation.getStrategie(ConfrontationConstants.STRATEGIE_2))){
					total += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2);
                    resultTmp += isHtml ? "<td border: 1px solid black;>"+confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2) + "</td>"
                    :confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2) + "\t|";
				}
			}
			resultTmp += isHtml ? "<td border: 1px solid black;>" +total + "</td></tr>" : total + "\t|" + line;
        }
        result += isHtml ? "<td border: 1px solid black;><b color='red'>TOTAL</b></td></tr>" : line;
        return result + resultTmp;
    }
    
    /**
     * Give the sum up of the confrontation on a text
     * @param num the number of the confrontation
     * @param Confrontation Confrontation where the sum up is needed
     * @return String A text with the sum up
     * @since 3.0
     */
    public static String sumUpConfrontation(boolean isHtml, int num, Confrontation confrontation){
        IStrategie s1 = confrontation.getStrategie(ConfrontationConstants.STRATEGIE_1);
        IStrategie s2 = confrontation.getStrategie(ConfrontationConstants.STRATEGIE_2);
        String result = "Rencontre N°" + num + " - " + confrontation.toString()
        +"\n" + "Le score final est de : \n" + s1.getStrategyName()+ " : "
        + confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1) + "\n" + s2.getStrategyName() 
        + " : " + confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2);
        if(isHtml){
            result = "<p>" + result + "</p>";
            result = result.replace("\n", "<br/>");
        }
        return result;
    }

    /********************DEPRECATED METHOD********************************/
    /*@Deprecated
    public static String sumUpTournoi(Tournoi tournoi){
        List<IStrategie> strategies = tournoi.getStrategies();
        String result = "\t|";
        for(IStrategie strategie: strategies){result += strategie.getNom() + "|";}
		String line = "\n--------------------------------------------------------------------------\n";
		result += "TOTAL\t|" + line;
		for(IStrategie strategie: strategies) {
			int total = 0;
			result += strategie.getNom() + "|";
			for(Confrontation confrontation: tournoi.getConfrontations()) {
				if(strategie.equals(confrontation.getStrategie(ConfrontationConstants.STRATEGIE_1))) {
					total += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1);
					result += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1) + "\t|";
				}else if(strategie.equals(confrontation.getStrategie(ConfrontationConstants.STRATEGIE_2))){
					total += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2);
					result += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2) + "\t|";
				}
            }
			result += total + "\t|" + line;
		}
		return result;
    }*/
}
