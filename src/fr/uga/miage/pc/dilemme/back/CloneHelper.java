package fr.uga.miage.pc.dilemme.back;

import fr.uga.miage.pc.dilemme.back.strategie.*;
import fr.uga.miage.pc.interfaces.IStrategie;

/**
 * This class is used in order to create a clone of a Strategie for the creation of Confrontation
 * @implSpec Created in order to replace the method in the IStrategie interface
 * @implNote <p>The methods implemented in order to replace the method <code>clone()</code>
 * in the IStrategie interface isn't good because we made a test on the code
 * or on the type of instance<br/>
 * For a futher development, we should change that by using a new system to do the clone
 * without these tests in order to get a generic software</p>
 * @author Aur�lien Avanzino - St�phanie Gourdon
 * @since 3.0
 * @version 1.0
 */
public final class CloneHelper {

    /**
     * Private class which extends the class <code>Strategie</code> in order to create a object 
     * which is a clone of a <code>Strategie</code>
     * @implNote this private class is here to replace the other methods of the class
     * which are not good to in their implementation
     * @deprecated This system isn't finished yet
     * @since 3.0
     */
    @Deprecated
    private static class strategieClone extends Strategie{

        /**
         * Constructor for the clone which just call the constructor of Strategie
         * @param strategie - Strategie to clone
         */
        public strategieClone(IStrategie strategie){ 
            super(strategie.getStrategyName(), strategie.getDescription());
            setComportement(strategie.getComportement());
        }

        /** {@inheritDoc} */
        @Override
        public void compareComportements(){}
    }

    //TODO Une fois les versions 2.5 et 3.0 terminé faire cette partie
    /**
     * Create a clone of the Strategie given by using the private class StrategieClone
     * @implNote This method is here to replace the other methods of the class which
     * are not godd in their implementation
     * @deprecated This system isn't finished yet
     * @since 3.0
     * @param strategie - Strategie to clone
     * @return The clone of the Strategie
     */
    @Deprecated
    public static IStrategie cloneTest(IStrategie strategie) {
        IStrategie clone = new CloneHelper.strategieClone(strategie){
            @Override
            public void compareComportements(){
                //int tourTmp = strategie.getNumTour();
                strategie.compareComportements();
            }
        };
        return clone;
    }
    
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
        //TODO Lorsque les stragies de Mariia et Marie-José seront récupérées
        //Penser à rajouter une condition instanceof Strategie, ce qui permettra
        //de différencier les stratgies venant de chez nous avec celles venant de
        //chez elles
        IStrategie clone = null;
        if(strategie instanceof Gentille){ clone = new Gentille(); }
        else if(strategie instanceof Mechante){ clone = new Mechante(); }
        else if(strategie instanceof Mefiante){ clone = new Mefiante(); }
        else if(strategie instanceof Rancuniere){ clone = new Rancuniere(); }
        else if(strategie instanceof DonnantDonnant){ clone = new DonnantDonnant(); }
        else if(strategie instanceof DonnantDonnantDur){ clone = new DonnantDonnantDur(); }
        else if(strategie instanceof PerGentille){ clone = new PerGentille(); }
        else if(strategie instanceof PerMechant){ clone = new PerMechant(); }
        //Ajout des strategies de Mariia Selivanova et Marie-Jos�e Bassil
        else if(strategie instanceof fr.uga.miage.pc.strategies.Gentille) { clone = new fr.uga.miage.pc.strategies.Gentille();}
        else if(strategie instanceof fr.uga.miage.pc.strategies.Mechante) {clone = new fr.uga.miage.pc.strategies.Mechante();}
        else if(strategie instanceof fr.uga.miage.pc.strategies.Rancuniere) {clone = new fr.uga.miage.pc.strategies.Rancuniere();}
        else if(strategie instanceof fr.uga.miage.pc.strategies.DonnantDonnantDur) {clone = new fr.uga.miage.pc.strategies.DonnantDonnantDur();}
        else if(strategie instanceof fr.uga.miage.pc.strategies.DonnantDonnant) {clone = new fr.uga.miage.pc.strategies.DonnantDonnant();}
        else if(strategie instanceof fr.uga.miage.pc.strategies.Mefiante) {clone = new fr.uga.miage.pc.strategies.Mefiante();}
        else{ throw new Exception("The strategie that you want to clone is not available");}
        return clone;
    }
}
