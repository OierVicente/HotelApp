package Kontrolatzailea;

import javax.swing.JFrame;

public class Apartamentua extends Ostatu {
	/**
	 * @author Oier Vicente,Diego,Erlantz,Aintzane
	 * 
	 */
	
	private double prezioApartementua;
	private String helbidea;
	/**
	 * 
	 * @param id_Ostatu
	 * @param ostatu_Izena
	 * @param prezioApartementua
	 * @param helbidea
	 */
	
	public Apartamentua(int id_Ostatu, String ostatu_Izena, double prezioApartementua, String helbidea) {
		super(id_Ostatu, ostatu_Izena);
		this.prezioApartementua = prezioApartementua;
		this.helbidea = helbidea;
	}
	/**
	 * 
	 * @return
	 */
	

	public double getPrezioApartementua() {
		return prezioApartementua;
	}
	/**
	 * 
	 * @param prezioApartementua
	 */


	public void setPrezioApartementua(double prezioApartementua) {
		this.prezioApartementua = prezioApartementua;
	}
	/**
	 * 
	 * @return
	 */


	public String getHelbidea() {
		return helbidea;
	}
	/**
	 * 
	 * @param helbidea
	 */


	public void setHelbidea(String helbidea) {
		helbidea = helbidea;
	}
	/**
	 * 
	 */
	
	public int LogelaEskugarri(int logelaKopurua, int hartutakoLogelak) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 
	 * @return
	 */
	public String comboboxIzena() {
		String cb = this.getOstatu_Izena()+"           Helbidea: "+this.helbidea+"           Prezioa: "+this.prezioApartementua;
		return cb;
	}


}
