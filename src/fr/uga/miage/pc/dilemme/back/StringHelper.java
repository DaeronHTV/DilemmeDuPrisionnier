package fr.uga.miage.pc.dilemme.back;
import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;
import fr.uga.miage.pc.dilemme.back.Confrontation.ConfrontationConstants;

/**
 * 
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
    public static String tournoi(Tournoi tournoi){
        String result = "Voici la configuration du tournoi actuelle :\nNombre de rencontre : " 
		    + tournoi.getConfrontations().size() + "\nNombre de Tours par rencontre : " + tournoi.getNbTours() + "\n" +
		    "\nCe Tournoi opposera les strategies suivantes :\n";
		for(IStrategie strategie: tournoi.getStrategies()) { result += strategie.toString() + "\n"; }
		result += "\nVoici les differentes rencontres du tournoi : \n" + tournoi.toString();
		return result;
    }
    
    /**
     * Give the sum up of the tournament on a text
     * @param tournoi Tournoi where the sum up is needed
     * @return String A text with the sum up
     * @since 3.0
     */
    public static String sumUpTournoi(Tournoi tournoi){
        String line = "\n--------------------------------------------------------------------------\n";
        String result = "\t|";
        String resultTmp = "";
        for(IStrategie strategie: tournoi.getStrategies()){
            int total = 0;
            result += strategie.getNom() + "|" ;
            resultTmp += strategie.getNom() + "|";
			for(Confrontation confrontation: tournoi.getConfrontations()) {
				if(strategie.equals(confrontation.getStrategie(ConfrontationConstants.STRATEGIE_1))) {
					total += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1);
                    resultTmp += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1) + "\t|";
				}else if(strategie.equals(confrontation.getStrategie(ConfrontationConstants.STRATEGIE_2))){
					total += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2);
                    resultTmp += confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2) + "\t|";
				}
			}
			resultTmp += total + "\t|" + line;
        }
        return result + line + resultTmp;
    }

    /**
     * Give the sum up of the confrontation on a text
     * @param num the number of the confrontation
     * @param Confrontation Confrontation where the sum up is needed
     * @return String A text with the sum up
     * @since 3.0
     */
    public static String sumUpConfrontation(int num, Confrontation confrontation){
        IStrategie s1 = confrontation.getStrategie(ConfrontationConstants.STRATEGIE_1);
        IStrategie s2 = confrontation.getStrategie(ConfrontationConstants.STRATEGIE_2);
        String result = "Rencontre N°" + num + " - " + confrontation.toString()
        +"\n" + "Le score final est de : \n" + s1.getNom()+ " : "
        + confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_1) + "\n" + s2.getNom() 
        + " : " + confrontation.getFinalScore(ConfrontationConstants.STRATEGIE_2);
        return result;
    }
}
