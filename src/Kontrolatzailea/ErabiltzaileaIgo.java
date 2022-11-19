package Kontrolatzailea;


public class ErabiltzaileaIgo {
	/**
	 * @author Oier Vicente,Diego,Erlantz,Aintzane
	 * 
	 */
	private String nan;
	private String erabil_Izena;
	private String erabil_Abizenak;
	private String pasahitza;
	private String jaiotzeData;
	private String postaBezero;
	private String altaData;
	
	/**
	 * 
	 * @param nan
	 * @param erabil_Izena
	 * @param erabil_Abizenak
	 * @param pasahitza
	 * @param jaiotzeData
	 * @param postaBezero
	 * @param altaData
	 */
	public ErabiltzaileaIgo(String nan, String erabil_Izena, String erabil_Abizenak, String pasahitza,
			String jaiotzeData, String postaBezero, String altaData) {
		this.nan = nan;
		this.erabil_Izena = erabil_Izena;
		this.erabil_Abizenak = erabil_Abizenak;
		this.pasahitza = pasahitza;
		this.jaiotzeData = jaiotzeData;
		this.postaBezero = postaBezero;
		this.altaData = altaData;
	}
	/**
	 * 
	 * @return
	 */

	public String getNan() {
		return nan;
	}
	/**
	 * 
	 * @param nan
	 */

	public void setNan(String nan) {
		this.nan = nan;
	}
	/**
	 * 
	 * @return
	 */

	public String getErabil_Izena() {
		return erabil_Izena;
	}
	/**
	 * 
	 * @param erabil_Izena
	 */

	public void setErabil_Izena(String erabil_Izena) {
		this.erabil_Izena = erabil_Izena;
	}
	/**
	 * 
	 * @return
	 */

	public String getErabil_Abizenak() {
		return erabil_Abizenak;
	}
	/**
	 * 
	 * @param erabil_Abizenak
	 */

	public void setErabil_Abizenak(String erabil_Abizenak) {
		this.erabil_Abizenak = erabil_Abizenak;
	}
	/**
	 * 
	 * @return
	 */

	public String getPasahitza() {
		return pasahitza;
	}
	/**
	 * 
	 * @param pasahitza
	 */

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	/**
	 * 
	 * @return
	 */

	public String getJaiotzeData() {
		return jaiotzeData;
	}
	/**
	 * 
	 * @param jaiotzeData
	 */

	public void setJaiotzeData(String jaiotzeData) {
		this.jaiotzeData = jaiotzeData;
	}
	/**
	 * 
	 * @return
	 */

	public String getAltaData() {
		return altaData;
	}
	/**
	 * 
	 * @param altaData
	 */

	public void setAltaData(String altaData) {
		this.altaData = altaData;
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
		return "ErabiltzaileaIgo [nan=" + nan + ", erabil_Izena=" + erabil_Izena + ", erabil_Abizenak="
				+ erabil_Abizenak + ", pasahitza=" + pasahitza + ", jaiotzeData=" + jaiotzeData + ", postaBezero="
				+ postaBezero + "]";
	}
	
	
	

	





	

}
