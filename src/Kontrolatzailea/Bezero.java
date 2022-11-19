package Kontrolatzailea;

public class Bezero {
	/**
	 * @author Oier Vicente,Diego,Erlantz,Aintzane
	 * 
	 */

	private String idBezeroNan;
	private String pasahitzaBezero;
	private String izenBezero;
	private String abizenBezero;
	private String postaBezero;
	
	/**
	 * 
	 * @param idBezeroNan
	 * @param pasahitzaBezero
	 * @param izenBezero
	 * @param abizenBezero
	 * @param postaBezero
	 */
	
	public Bezero(String idBezeroNan, String pasahitzaBezero, String izenBezero, String abizenBezero,
			String postaBezero) {
		this.idBezeroNan = idBezeroNan;
		this.pasahitzaBezero = pasahitzaBezero;
		this.izenBezero = izenBezero;
		this.abizenBezero = abizenBezero;
		this.postaBezero = postaBezero;
	}
	/**
	 * 
	 * @return
	 */

	public String getIdBezeroNan() {
		return idBezeroNan;
	}
	/**
	 * 
	 * @param idBezeroNan
	 */

	public void setIdBezeroNan(String idBezeroNan) {
		this.idBezeroNan = idBezeroNan;
	}
	/**
	 * 
	 * @return
	 */

	public String getPasahitzaBezero() {
		return pasahitzaBezero;
	}
	/**
	 * 
	 * @param pasahitzaBezero
	 */

	public void setPasahitzaBezero(String pasahitzaBezero) {
		this.pasahitzaBezero = pasahitzaBezero;
	}
	/**
	 * 
	 * @return
	 */

	public String getIzenBezero() {
		return izenBezero;
	}
	/**
	 * 
	 * @param izenBezero
	 */

	public void setIzenBezero(String izenBezero) {
		this.izenBezero = izenBezero;
	}
	/**
	 * 
	 * @return
	 */

	public String getAbizenBezero() {
		return abizenBezero;
	}
	/**
	 * 
	 * @param abizenBezero
	 */

	public void setAbizenBezero(String abizenBezero) {
		this.abizenBezero = abizenBezero;
	}
	/**
	 * 
	 * @return
	 */

	public String getPostaBezero() {
		return postaBezero;
	}
	/**
	 * 
	 * @param postaBezero
	 */

	public void setPostaBezero(String postaBezero) {
		this.postaBezero = postaBezero;
	}

	@Override
	public String toString() {
		return "Bezero [idBezeroNan=" + idBezeroNan + ", pasahitzaBezero=" + pasahitzaBezero + ", izenBezero="
				+ izenBezero + ", abizenBezero=" + abizenBezero + ", postaBezero=" + postaBezero + "]";
	}
	
	
	
	
	
	
	
	
	
	
}