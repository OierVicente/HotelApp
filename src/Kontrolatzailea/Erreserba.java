package Kontrolatzailea;

import java.sql.Date;

import Eredua.Kontsulta_Erreserba;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Erreserba {

	private int idErreserba;
	private int idOstatu;
	private String idBezero;
	private String dataJoan;
	private String dataEtorri;
	private double precio;
	private int sinp =0;
	private int bisinp=0;
	private int bik=0;
	private int sinpbik=0;
	private int sehaska=0;
	private String Eskatutakodata;
	private String EskatutakoOrdua;
	private int logelaKopurua=0;
	/**
	 * 
	 * @param idOstatu
	 * @param idBezero
	 * @param dataJoan
	 * @param dataEtorri
	 * @param precio
	 * @param sinp
	 * @param bisinp
	 * @param bik
	 * @param sinpbik
	 * @param sehaska
	 * @param eskatutakodata
	 * @param eskatutakoOrdua
	 * @param LogelaKopurua
	 */
	
	public Erreserba(int idOstatu, String idBezero, String dataJoan, String dataEtorri, double precio,
			int sinp, int bisinp, int bik, int sinpbik, int sehaska, String eskatutakodata, String eskatutakoOrdua,int LogelaKopurua) {
		//this.idErreserba = idErreserba;
		this.idOstatu = idOstatu;
		this.idBezero = idBezero;
		this.dataJoan = dataJoan;
		this.dataEtorri = dataEtorri;
		this.precio = precio;
		this.sinp = sinp;
		this.bisinp = bisinp;
		this.bik = bik;
		this.sinpbik = sinpbik;
		this.sehaska = sehaska;
		this.Eskatutakodata = eskatutakodata;
		this.EskatutakoOrdua = eskatutakoOrdua;
		this.logelaKopurua = LogelaKopurua;
	}
	
	/**
	 * 
	 * @param idErreserba
	 * @param idOstatu
	 * @param idBezero
	 * @param dataJoan
	 * @param dataEtorri
	 * @param precio
	 * @param sinp
	 * @param bisinp
	 * @param bik
	 * @param sinpbik
	 * @param sehaska
	 * @param eskatutakodata
	 * @param eskatutakoOrdua
	 */
	
	//Erreserba imprimatzeko beste kontruktore bat
	public Erreserba(int idErreserba,int idOstatu, String idBezero, String dataJoan, String dataEtorri, double precio,
			int sinp, int bisinp, int bik, int sinpbik, int sehaska, String eskatutakodata, String eskatutakoOrdua) {
		this.idErreserba = idErreserba;
		this.idOstatu = idOstatu;
		this.idBezero = idBezero;
		this.dataJoan = dataJoan;
		this.dataEtorri = dataEtorri;
		this.precio = precio;
		this.sinp = sinp;
		this.bisinp = bisinp;
		this.bik = bik;
		this.sinpbik = sinpbik;
		this.sehaska = sehaska;
		Eskatutakodata = eskatutakodata;
		EskatutakoOrdua = eskatutakoOrdua;
	}
	
	
	/**
	 * 
	 * @return
	 */
	 



//	public int getIdErreserba() {
//		return idErreserba;
//	}






//	public void setIdErreserba(int idErreserba) {
//		this.idErreserba = idErreserba;
//	}






	public int getIdOstatu() {
		return idOstatu;
	}

/**
 * 
 * @param idOstatu
 */




	public void setIdOstatu(int idOstatu) {
		this.idOstatu = idOstatu;
	}
	/**
	 * 
	 * @return
	 */





	public String getIdBezero() {
		return idBezero;
	}

	/**
	 * 
	 * @param idBezero
	 */




	public void setIdBezero(String idBezero) {
		this.idBezero = idBezero;
	}

	/**
	 * 
	 * @return
	 */




	public String getDataJoan() {
		return dataJoan;
	}

	/**
	 * 
	 * @param dataJoan
	 */




	public void setDataJoan(String dataJoan) {
		this.dataJoan = dataJoan;
	}

	/**
	 * 
	 * @return
	 */




	public String getDataEtorri() {
		return dataEtorri;
	}

	/**
	 * 
	 * @param dataEtorri
	 */




	public void setDataEtorri(String dataEtorri) {
		this.dataEtorri = dataEtorri;
	}

	/**
	 * 
	 * @return
	 */




	public double getPrecio() {
		return precio;
	}

/**
 * 
 * @param precio
 */




	public void setPrecio(double precio) {
		this.precio = precio;
	}


/**
 * 
 * @return
 */



	public int getSinp() {
		return sinp;
	}

/**
 * 
 * @param sinp
 */




	public void setSinp(int sinp) {
		this.sinp = sinp;
	}



/**
 * 
 * @return
 */


	public int getBisinp() {
		return bisinp;
	}

/**
 * 
 * @param bisinp
 */




	public void setBisinp(int bisinp) {
		this.bisinp = bisinp;
	}


/**
 * 
 * @return
 */



	public int getBik() {
		return bik;
	}

/**
 * 
 * @param bik
 */




	public void setBik(int bik) {
		this.bik = bik;
	}

/**
 * 
 * @return
 */




	public int getSinpbik() {
		return sinpbik;
	}



/**
 * 
 * @param sinpbik
 */


	public void setSinpbik(int sinpbik) {
		this.sinpbik = sinpbik;
	}


/**
 * 
 * @return
 */



	public int getSehaska() {
		return sehaska;
	}



/**
 * 
 * @param sehaska
 */


	public void setSehaska(int sehaska) {
		this.sehaska = sehaska;
	}


/**
 * 
 * @return
 */



	public String getEskatutakodata() {
		return Eskatutakodata;
	}

/**
 * 
 * @param eskatutakodata
 */




	public void setEskatutakodata(String eskatutakodata) {
		Eskatutakodata = eskatutakodata;
	}


/**
 * 
 * @return
 */



	public String getEskatutakoOrdua() {
		return EskatutakoOrdua;
	}

/**
 * 
 * @param eskatutakoOrdua
 */




	public void setEskatutakoOrdua(String eskatutakoOrdua) {
		EskatutakoOrdua = eskatutakoOrdua;
	}
	/**
	 * 
	 * @return
	 */
	
	public int getlogelaKopurua() {
		return logelaKopurua;
	}


/**
 * 
 * @param LogelaKopurua
 */



	public void setlogelaKopurua(int LogelaKopurua) {
		logelaKopurua = LogelaKopurua;
	}




	@Override
	public String toString() {
		return " \n" + "                                                             Erreserba                        "
				+ " \t\n"
				+ " ----------------------------------------------------------------------------------------------------------------------"
				+ " \t\n"

				+ " -Erreserba Kodea: "+this.idErreserba + " \t" + " -Id Ostatu: " + this.idOstatu + " \t" + "-Id bezero: " + this.idBezero + " \n" + " \n"
				+ "-Erreserba data: "+this.Eskatutakodata+" \t" + " -Ordua: "+this.EskatutakoOrdua+" \t\n"
				+ " \t\n"
				+ "-----------------------------------------------------------------------------------------------------------------------"
				+ " \t\n"
				+" -Joateko data: " + this.dataJoan + " \t\t" + "-Etorri data: " + this.dataEtorri + " \t\n"
				+ " ----------------------------------------------------------------------------------------------------------------------"
				+ " \t\n"

				+ " -Prezioa: " + this.precio + " €";
	}








}
