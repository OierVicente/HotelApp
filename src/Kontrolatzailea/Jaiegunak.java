package Kontrolatzailea;

import java.sql.Date;
import java.util.ArrayList;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Jaiegunak {
	
	private ArrayList <Date> jaiDatak = new ArrayList<Date>();
	private ArrayList <String> jaiIzenak = new ArrayList<String>();
	/**
	 * 
	 * @param jaiDatak
	 * @param jaiIzenak
	 */
	public Jaiegunak(ArrayList<Date> jaiDatak, ArrayList<String> jaiIzenak) {
		super();
		this.jaiDatak = jaiDatak;
		this.jaiIzenak = jaiIzenak;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Date> getJaiDatak() {
		return jaiDatak;
	}
	/**
	 * 
	 * @param jaiDatak
	 */
	public void setJaiDatak(ArrayList<Date> jaiDatak) {
		this.jaiDatak = jaiDatak;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getJaiIzenak() {
		return jaiIzenak;
	}
	/**
	 * 
	 * @param jaiIzenak
	 */
	public void setJaiIzenak(ArrayList<String> jaiIzenak) {
		this.jaiIzenak = jaiIzenak;
	}

	
	@Override
	public String toString() {
		return "Jaiegunak [jaiDatak=" + jaiDatak + ", jaiIzenak=" + jaiIzenak + "]";
	}
}

