package fr.uga.miage.pc.dilemme.front;

/**
 * This interface is used in order to respect the design patter Observer.
 * It defines the functionnement of the object that notify the observer
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 3.0
 * @version 1.0
 */
public interface IObservable {

    /**
     * Add a <code>IObserver</code> to the list
     * @param observer The observer to add
     */
    public void addObserver(IObserver observer);
    
    /**
     * Remove a <code>IObserver</code> from the list
     * @param observer The observer to remove
     */
    public void removeObserver(IObserver observer);
    
    /**
     * Notify all the Observer of the list
     * @see IObserver#notifier()
     * @since 3.0
     */
    public void notifierAll();
}
