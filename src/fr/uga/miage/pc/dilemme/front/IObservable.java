package fr.uga.miage.pc.dilemme.front;

public interface IObservable {
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifierAll();
}
