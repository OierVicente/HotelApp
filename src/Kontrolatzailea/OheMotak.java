package Kontrolatzailea;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class OheMotak {
	
	private int OheSimpleBat;
	private int OheSimpleBi;
	private int OheBikoitzBat;
	private int OheBikoitzBatEtaOheSimpleBat;
	private int Sehaska;
	
	public OheMotak() {
		super();
	}
	public OheMotak(int oheSimpleBat, int oheSimpleBi, int oheBikoitzBat, int oheBikoitzBatEtaOheSimpleBat,
			int sehaska) {
		super();
		OheSimpleBat = oheSimpleBat;
		OheSimpleBi = oheSimpleBi;
		OheBikoitzBat = oheBikoitzBat;
		OheBikoitzBatEtaOheSimpleBat = oheBikoitzBatEtaOheSimpleBat;
		Sehaska = sehaska;
	}
	/**
	 * 
	 * @return
	 */
	
	
	public int getOheSimpleBat() {
		return OheSimpleBat;
	}
	/**
	 * 
	 * @param oheSimpleBat
	 */
	public void setOheSimpleBat(int oheSimpleBat) {
		OheSimpleBat = oheSimpleBat;
	}
	/**
	 * 
	 * @return
	 */
	public int getOheSimpleBi() {
		return OheSimpleBi;
	}
	/**
	 * 
	 * @param oheSimpleBi
	 */
	public void setOheSimpleBi(int oheSimpleBi) {
		OheSimpleBi = oheSimpleBi;
	}
	/**
	 * 
	 * @return
	 */
	public int getOheBikoitzBat() {
		return OheBikoitzBat;
	}
	/**
	 * 
	 * @param oheBikoitzBat
	 */
	public void setOheBikoitzBat(int oheBikoitzBat) {
		OheBikoitzBat = oheBikoitzBat;
	}
	/**
	 * 
	 * @return
	 */
	public int getOheBikoitzBatEtaOheSimpleBat() {
		return OheBikoitzBatEtaOheSimpleBat;
	}
	/**
	 * 
	 * @param oheBikoitzBatEtaOheSimpleBat
	 */
	public void setOheBikoitzBatEtaOheSimpleBat(int oheBikoitzBatEtaOheSimpleBat) {
		OheBikoitzBatEtaOheSimpleBat = oheBikoitzBatEtaOheSimpleBat;
	}
	/**
	 * 
	 * @return
	 */
	public int getSehaska() {
		return Sehaska;
	}
	/**
	 * 
	 * @param sehaska
	 */
	public void setSehaska(int sehaska) {
		Sehaska = sehaska;
	}

	
	@Override
	public String toString() {
		return "OheMotak [OheSimpleBat=" + OheSimpleBat + ", OheSimpleBi=" + OheSimpleBi + ", OheBikoitzBat="
				+ OheBikoitzBat + ", OheBikoitzBatEtaOheSimpleBat=" + OheBikoitzBatEtaOheSimpleBat + ", Sehaska="
				+ Sehaska + "]";
	}
	
	

}
