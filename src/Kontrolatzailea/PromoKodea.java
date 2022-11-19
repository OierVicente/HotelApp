package Kontrolatzailea;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class PromoKodea {
	
	
	private String promozioKodeaIzen;
	private int promozioaZbk;
	/**
	 * 
	 * @param promozioKodeaIzen
	 * @param promozioaZbk
	 */
	public PromoKodea(String promozioKodeaIzen, int promozioaZbk) {
		super();
		this.promozioKodeaIzen = promozioKodeaIzen;
		this.promozioaZbk = promozioaZbk;
	}
	/**
	 * 
	 * @return
	 */

	public String getPromozioKodeaIzen() {
		return promozioKodeaIzen;
	}
	/**
	 * 
	 * @param promozioKodeaIzen
	 */

	public void setPromozioKodeaIzen(String promozioKodeaIzen) {
		this.promozioKodeaIzen = promozioKodeaIzen;
	}
	/**
	 * 
	 * @return
	 */

	public int getPromozioaZbk() {
		return promozioaZbk;
	}
	/**
	 * 
	 * @param promozioaZbk
	 */

	public void setPromozioaZbk(int promozioaZbk) {
		this.promozioaZbk = promozioaZbk;
	}
	
	
	
	
	
	

}
