package Kontrolatzailea;

/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Etxea extends Ostatu{

	private int LogelaKopurua;
	//private int HartutakoLogelak;
	private double prezioEtxea;
	private String helbideEtxea;
	/**
	 * 
	 * @param id_Hotel
	 * @param izena_Hotel
	 * @param prezioEtxea
	 * @param helbideEtxea
	 */
	//Kontruktorea hotelak behar dituen datuak sartzeko...

	public Etxea(int id_Hotel, String izena_Hotel,
			double prezioEtxea, String helbideEtxea) {
		super(id_Hotel, izena_Hotel);
		//this.HartutakoLogelak = hartutakoLogelak;
		this.prezioEtxea = prezioEtxea;
		this.helbideEtxea = helbideEtxea;
	}
/**
 * 
 * @return
 */
	public int getLogelaKopurua() {
		return LogelaKopurua;
	}
/**
 * 
 * @param logelaKopurua
 */
	public void setLogelaKopurua(int logelaKopurua) {
		LogelaKopurua = logelaKopurua;
	}
/**
 * 
 * @return
 */
	public double getPrezioEtxea() {
		return prezioEtxea;
	}
/**
 * 
 * @param prezioEtxea
 */
	public void setPrezioEtxea(double prezioEtxea) {
		this.prezioEtxea = prezioEtxea;
	}
/**
 * 
 * @return
 */
	public String getHelbideEtxea() {
		return helbideEtxea;
	}
/**
 * 
 * @param helbideEtxea
 */
	public void setHelbideEtxea(String helbideEtxea) {
		this.helbideEtxea = helbideEtxea;
	}

	@Override
	public int LogelaEskugarri(int logelaKopurua, int hartutakoLogelak) {
		return 0;
	}
/**
 * 
 * @return
 */
	public String comboboxIzena() {
		String cb = this.getOstatu_Izena()+"           Helbidea: "+this.helbideEtxea+"           Prezioa: "+this.prezioEtxea;
		return cb;
	}

}
