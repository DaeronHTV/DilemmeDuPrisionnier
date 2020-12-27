package fr.uga.miage.pc.dilemme.back;
import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;
import fr.uga.miage.pc.dilemme.back.Confrontation.ConfrontationConstants;

public final class StringHelper {

    public static String tournoi(Tournoi tournoi){
        String result = "Voici la configuration du tournoi actuelle :\nNombre de rencontre : " 
		    + tournoi.getConfrontations().size() + "\nNombre de Tours par rencontre : " + tournoi.getNbTours() + "\n" +
		    "\nCe Tournoi opposera les strategies suivantes :\n";
		for(IStrategie strategie: tournoi.getStrategies()) { result += strategie.toString() + "\n"; }
		result += "\nVoici les differentes rencontres du tournoi : \n" + tournoi.toString();
		return result;
    }
    
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
