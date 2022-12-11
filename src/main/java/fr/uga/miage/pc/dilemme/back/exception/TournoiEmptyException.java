package fr.uga.miage.pc.dilemme.back.exception;

public class TournoiEmptyException extends Exception{
	private static final long serialVersionUID = 8711959132974333600L;
	
	public TournoiEmptyException(String message) {
		super(message);
	}
}
