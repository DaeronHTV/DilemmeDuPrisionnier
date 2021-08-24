package fr.uga.miage.pc.dilemme.back.strategie;

/**
 * This class is used in order to create a clone of a Strategie for the creation of Confrontation
 * @implSpec Created in order to replace the method in the IStrategie interface
 * @implNote <p>The methods implemented in order to replace the method <code>clone()</code>
 * in the IStrategie interface isn't good because we made a test on the code
 * or on the type of instance<br/>
 * For a futher development, we should change that by using a new system to do the clone
 * without these tests in order to get a generic software</p>
 * @author Aurélien Avanzino - Stéphanie Gourdon
 * @since 3.0
 * @version 1.0
 */

public final class CloneHelper {
    
    /**
     * Create the a clone of the Strategie with the code given in parameter
     * @param name The code of the strategie to clone
     * @return IStrategie - Clone of the Strategie
     * @throws Exception If the name of the strategie isn't known
     * @since 3.0  
     */
    public static IStrategie clone(String name) throws Exception {
        IStrategie clone = null;
        switch(name){
            case "Gentille": clone = new Gentille(); break;
            case "Mechante": clone = new Mechante(); break;
            case "Mefiante": clone = new Mefiante(); break;
            case "Periodique-Gentille": clone = new PerGentille(); break;
            case "Donnant-Donnant": clone = new DonnantDonnant(); break;
            case "Donnant-Donnant Dur": clone = new DonnantDonnantDur(); break;
            case "Periodique-Mechant": clone = new PerMechant(); break;
            case "Rancuniere": clone = new Rancuniere(); break;
            default: throw new Exception("The Strategie that you want to clone is not available !");
        }
        return clone;
    }

    /**
     * Create the a clone of the Strategie with the Strategie given in parameter
     * @param IStrategie The Strategie to clone
     * @return IStrategie - Clone of the Strategie
     * @throws Exception If the instance is unknow
     * @since 3.0  
     */
    public static IStrategie clone(IStrategie strategie) throws Exception {
        IStrategie clone = null;
        if(strategie instanceof Gentille){ clone = new Gentille(); }
        else if(strategie instanceof Mechante){ clone = new Mechante(); }
        else if(strategie instanceof Mefiante){ clone = new Mefiante(); }
        else if(strategie instanceof Rancuniere){ clone = new Rancuniere(); }
        else if(strategie instanceof DonnantDonnant){ clone = new DonnantDonnant(); }
        else if(strategie instanceof DonnantDonnantDur){ clone = new DonnantDonnantDur(); }
        else if(strategie instanceof PerGentille){ clone = new PerGentille(); }
        else if(strategie instanceof PerMechant){ clone = new PerMechant(); }
        else{ throw new Exception("The strategie that you want to clone is not available");}
        return clone;
    }
}
