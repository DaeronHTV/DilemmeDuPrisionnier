package fr.uga.miage.pc.dilemme.back.strategie;

/**
 * This class is used in order to create a clone 
 * @author Aurélien Avanzino - Stéphanie Gourdo
 * @since 3.0
 * @version 1.0
 */

public final class CloneHelper {

    @Deprecated
    private static class strategieClone extends Strategie{

        public strategieClone(String nom, String description) { super(nom, description); }

        public strategieClone(IStrategie strategie){ 
            super(strategie.getNom(), strategie.getDescription());
            setPlay(strategie.getPlay());
        }

        /** {@inheritDoc} */
        @Override
        public void play(){

        }

    }
    //TODO Une fois les versions 2.5 et 3.0 terminé faire cette partie
    @Deprecated
    public static IStrategie cloneTest(IStrategie strategie) {
        IStrategie clone = new CloneHelper.strategieClone(strategie){
            @Override
            public void play(){
                //int tourTmp = strategie.getNumTour();
                strategie.play();
            }
        };
        return clone;
    }
    
    /**
     * 
     * @param name The name of the strategie to clone
     * @return IStrategie - Clone of the Strategie
     * @throws StrategieNotSupportedException If the name of the strategie isn't known
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
        else{ throw new Exception("The strategie that you want to clone is not available");}
        return clone;
    }
}
