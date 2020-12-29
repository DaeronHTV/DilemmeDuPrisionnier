package fr.uga.miage.pc.dilemme.front;

/**
 * This interface is used in order to respect the design patter Observer.
 * It defines the functionnement of the object that will be notify by a observable
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 3.0
 * @version 1.0
 */
public interface IObserver {

    /**
     * Action made by the Observer when the Observeable notify it
     * @since 3.0
     */
    public void notifier();
}
