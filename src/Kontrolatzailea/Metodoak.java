package Kontrolatzailea;

import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import Eredua.Konsulta_Erregistro;
import Eredua.Kontsulta_Apartamentua;
import Eredua.Kontsulta_Bezero;
import Eredua.Kontsulta_Erreserba;
import Eredua.Kontsulta_Etxeak;
import Eredua.Kontsulta_Hoteles;
import Eredua.Kontsulta_Promoak;
import Ikuspegia.ApartamentuakAukeratuLeihoa;
import Ikuspegia.ErregistroLeihoa;
import Ikuspegia.ErreserbaHasieratu;
import Ikuspegia.ErreserbaHasieratuApartamentua;
import Ikuspegia.ErreserbaHasieratuEtxea;
import Ikuspegia.EskerrikAskoLeihoa;
import Ikuspegia.EtxeakAukeratuLeihoa;
import Ikuspegia.HotelakAukeratuLeihoa;
import Ikuspegia.LoginLeihoa;
import Ikuspegia.OngiEtorriLeihoa;
import Ikuspegia.OrdainduLeihoa;
import Ikuspegia.OrdainduLeihoaEtxeak;
import Ikuspegia.OstauMotaAukeratu;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Metodoak {
	static int LogelaKant;
	static String JaiGustiak;
	static String idBezero;

	//Ventana1
	public static void ongietorrileihora() {

		OngiEtorriLeihoa OngiEtorriLeihoa= new OngiEtorriLeihoa();
		OngiEtorriLeihoa.setVisible(true);


	}
	
	//Ventana2 Login
		public static void loginleihora() {
			ArrayList <Bezero> Bezeroak= new ArrayList <Bezero>();
			Bezeroak=Kontsulta_Bezero.BezeroakIkusi();
			LoginLeihoa LoginLeihoa= new LoginLeihoa(Bezeroak);
			LoginLeihoa.setVisible(true);

		}
		
	//Ventana2 Erregistratu
		public static void erregistroleihora() {
			ArrayList <Bezero> Bezeroak= new ArrayList <Bezero>();
			Bezeroak=Kontsulta_Bezero.BezeroakIkusi();
			ErregistroLeihoa ErregistroLeihoa= new ErregistroLeihoa(Bezeroak);
			ErregistroLeihoa.setVisible(true);

		}
		
		public static void ostatumotaaukeratuleihora() {

			OstauMotaAukeratu OstatuMotaAukeratu= new OstauMotaAukeratu();
			OstatuMotaAukeratu.setVisible(true);

		}
		
	//Ventana3
	public static void hotelakaukeratuleihora() {

		ArrayList <Hotel> Hoteles= new ArrayList <Hotel>();
		Hoteles=Kontsulta_Hoteles.HotelakIkusi();
		ArrayList<String> Helbideak =new ArrayList<String>();
		Helbideak=Kontsulta_Hoteles.HelbideakIkusi();
		HotelakAukeratuLeihoa LoginLeihoa= new HotelakAukeratuLeihoa(Hoteles,Helbideak);
		LoginLeihoa.setVisible(true);

	}
	//etxera aukeratzeko leihora joateko
	public static void etxeakaukeratuleihora() {

		ArrayList <Etxea> Etxeak= new ArrayList <Etxea>();
		Etxeak=Kontsulta_Etxeak.EtxeakIkusi();
		ArrayList<String> Helbideak =new ArrayList<String>();
		Helbideak=Kontsulta_Etxeak.HelbideakIkusi();
		EtxeakAukeratuLeihoa EtxeakAukeratu= new EtxeakAukeratuLeihoa(Etxeak,Helbideak);
		EtxeakAukeratu.setVisible(true);

	}
	//Apartamentua aukeratzeko lehiora joateko
	public static void apartamentuakAukeratuleihora() {
		ArrayList<String> Helbideak =new ArrayList<String>();
		Helbideak=Kontsulta_Apartamentua.ApartamentuenHelbideakIkusi();
		ApartamentuakAukeratuLeihoa apartamentuakAukeratuLeihoa= new ApartamentuakAukeratuLeihoa(Helbideak);
		apartamentuakAukeratuLeihoa.setVisible(true);

	}
	
	
	//Erreserba prestatzeko lehioak
		public static void erreserbahasieratu(String hotelak, double PrezioHotel) {
			ErreserbaHasieratu ErreserbaLehioa = new ErreserbaHasieratu(hotelak, PrezioHotel);
			ErreserbaLehioa.setVisible(true);
		}
		
		public static void erreserbahasieratuetxea(String etxeak, double PrezioEtxea) {
			ErreserbaHasieratuEtxea ErreserbaLehioaEtxea = new ErreserbaHasieratuEtxea(etxeak, PrezioEtxea);
			ErreserbaLehioaEtxea.setVisible(true);
		}
		public static void erreserbahasieratuapartamentua(String apartamentuak, double PrezioApartamentua) {
			ErreserbaHasieratuApartamentua ErreserbaHasieratuApartamentua = new ErreserbaHasieratuApartamentua(apartamentuak, PrezioApartamentua);
			ErreserbaHasieratuApartamentua.setVisible(true);
		}

		
	//Ventana4
	public static void ordainduleihora(String hotelak, double prezioHotel, Date sartuData, Date joanData, OheMotak o1,int logelaKopurua) {

		OrdainduLeihoa HotelakAukeratuLeihoa= new OrdainduLeihoa(hotelak,prezioHotel,sartuData, joanData, o1,logelaKopurua);
		HotelakAukeratuLeihoa.setVisible(true);

	}
	//Ventana5
	public static void eskerrikaskoleihoara() {

		EskerrikAskoLeihoa EskerrikAskoLeihoa= new EskerrikAskoLeihoa();
		EskerrikAskoLeihoa.setVisible(true);

	}
	// Erabiltzaile berri bat erregistratzeko
	public static void Erregistratu(ErabiltzaileaIgo e1) {
		Konsulta_Erregistro.Erabiltzailea_erregistratu(e1);
		
	}
	//ErreserbaEtxetik Ordaindu Etxera
	public static void ordainduleihoraetxea(String hotelak, double prezioHotel, Date sartuData, Date joanData, boolean oierbike) {

		OrdainduLeihoaEtxeak ordainduLeihoaEtxeak= new OrdainduLeihoaEtxeak(hotelak,prezioHotel,sartuData, joanData, oierbike);
		ordainduLeihoaEtxeak.setVisible(true);

	}
	
	public static boolean konprobatuNegatibo(double zbk) {
		boolean balidatu=false;
		if (zbk>0)
			balidatu=true;
		return balidatu;
	}

	public static void imprimatuTiketa(Erreserba e1) {

		String nombre = "erreserba.txt";
		try{
			FileWriter fichero = new FileWriter("src\\Kontrolatzailea\\"+nombre);
			fichero.write(e1.toString() + "\r\n");
			fichero.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void ErreserbaIgo(Erreserba e1) {
		Kontsulta_Erreserba.InsertErreserba(e1);
		
	}
	
	public static void ErreserbaIgoEtxea(Erreserba e1) {
		Kontsulta_Erreserba.InsertErreserbaEtxea(e1);
		
	}

	public static String bueltakMetodoa(double zbk) {


		double kanbio= zbk;

		int aldatzailea = (int) (kanbio*100); // int-a parentesisen artean dagoena, double-a int-a bihurtzen du
		int itzultzeko = aldatzailea;
		String kanbioa="";
		String pantailaratu="";
		//DEZIMALEN FORMATOA.
		DecimalFormat dezimal = new DecimalFormat("#.00");

		pantailaratu=(" Itzultzeko " + dezimal.format(kanbio) + " eman behar da.\n");
		kanbioa=kanbioa+pantailaratu;
		// para cada moneda
		if (itzultzeko >= 20000) {
			pantailaratu=(" 200€-ko billeteak: " + itzultzeko / 20000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 20000;
		}
		if (itzultzeko >= 10000) {
			pantailaratu=(" 100€-ko billeteak: " + itzultzeko / 10000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 10000;
		}
		if (itzultzeko >= 5000) {
			pantailaratu=(" 50€-ko billeteak: " + itzultzeko / 5000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 5000;
		}
		if (itzultzeko >= 2000) {
			pantailaratu=(" 20€-ko billeteak: " + itzultzeko / 2000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 2000;
		}
		if (itzultzeko >= 1000) {
			pantailaratu=(" 10€-ko billeteak: " + itzultzeko / 1000+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 1000;
		}
		if (itzultzeko >= 500) {
			pantailaratu=(" 5€-ko billeteak: " + itzultzeko / 500+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 500;
		}
		if (itzultzeko >= 200) {
			pantailaratu=(" 2€-ko txanponak: " + itzultzeko / 200+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 200;
		}
		if (itzultzeko >= 100) {
			pantailaratu=(" 1€-ko txanponak: " + itzultzeko / 100+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 100;
		}
		if (itzultzeko >= 50) {
			pantailaratu=(" 50 zentimoko txanponak: " + itzultzeko / 50+"\n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 50;
		}
		if (itzultzeko >= 20) {
			pantailaratu=(" 20 zentimoko txanponak: " + itzultzeko / 20+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 20;
		}
		if (itzultzeko >= 10) {
			pantailaratu=(" 10 zentimoko txanponak: " + itzultzeko / 10+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 10;
		}
		if (itzultzeko >= 5) {
			pantailaratu=(" 5 zentimoko txanponak: " + itzultzeko / 5+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 5;
		}
		if (itzultzeko >= 2) {
			pantailaratu=(" 2 zentimoko txanponak: " + itzultzeko / 2+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = itzultzeko % 2;
		}
		if (itzultzeko >= 1) {
			pantailaratu=(" 1 zentimoko txanponak: " + itzultzeko+" \n");
			kanbioa=kanbioa+pantailaratu;
			itzultzeko = 0;
		}
		return kanbioa;
	}

	public static boolean konprobatuLetra(String zbk) {
		boolean balidatu=false;

		try {
			Double.parseDouble(zbk);
			balidatu = false;
		} catch (NumberFormatException letra) {
			balidatu = true;
		}
		return balidatu;
	}

	public static boolean diruFalta(double zbk,double prezioa) {

		boolean diru_falta=false;
		double preziototala = 0;
		preziototala = (double) (zbk-prezioa);
		if (preziototala<0) {
			diru_falta=true;

		}
		return diru_falta;
	}

	public static String orduaAtera () {
		int hora,minutos = 0;
		Calendar fecha = Calendar.getInstance();

		//ordua hartu eta gorde
		hora =fecha.get(Calendar.HOUR_OF_DAY);
		minutos = fecha.get(Calendar.MINUTE);

		String ordua = hora+":"+minutos;

		if (hora<10) {
			ordua = "0"+hora+":"+minutos;
		}
		if (minutos<10) {
			ordua = hora+":"+"0"+minutos;
		}
		if(hora<10 && minutos<10) {
			ordua = hora+":"+"0"+minutos;
		}
		return ordua;
	}

	public static String dataAteraAñoalFinala () {
		int año,mes,dia = 0;

		Calendar fecha = Calendar.getInstance();

		//data hartu eta gorde
		año = fecha.get(Calendar.YEAR);
		mes = fecha.get(Calendar.MONTH) + 1;
		dia = fecha.get(Calendar.DAY_OF_MONTH);

		String data = dia+"-"+mes+"-"+año;

		if(dia<10) {
			data = "0"+dia+"-"+mes+"-"+año;
		}
		if(mes<10) {
			data = dia+"-"+"0"+mes+"-"+año;
		}
		if (dia<10 && mes<10) {
			data = "0"+dia+"-"+"0"+mes+"-"+año;
		}
		return data;
	}
	public static String dataAtera() {
		int año,mes,dia = 0;

		Calendar fecha = Calendar.getInstance();

		//data hartu eta gorde
		año = fecha.get(Calendar.YEAR);
		mes = fecha.get(Calendar.MONTH) + 1;
		dia = fecha.get(Calendar.DAY_OF_MONTH);

		String data = año+"-"+mes+"-"+dia;

		if(dia<10) {
			data = año+"-"+mes+"-"+"0"+dia;
		}
		if(mes<10) {
			data = año+"-"+"0"+mes+"-"+dia;
		}
		if (dia<10 && mes<10) {
			data = año+"-"+"0"+mes+"-"+"0"+dia;
		}
		return data;
	}
	

	public static double RedondearDosDecimales(double numero)
	{
		return Math.rint(numero*100)/100;
	}

	public static String KalkulatuLetra(int dni){
		String karaktereak="TRWAGMYFPDXBNJZSQVHLCKE";
		int modulo= dni % 23;
		char letra1 = karaktereak.charAt(modulo);
		String letra = Character.toString(letra1);
		return letra; 
	} 

	public static String ateraMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	//hola
	
	public static double prezioaEgunekin(double prezioHotel, Date joanData, Date sartuData, OheMotak o1,int idHotel, int zenbatJaiEgun, double promoPortzentaia){
		
		double prezioTrampa = prezioHotel;
		double prezioa0 = 0;
		double prezioa1 = 0;
		double prezioa2 = 0;
		double prezioa3 = 0;
		double prezioa4 = 0;
		
		
		prezioHotel = Kontsulta_Hoteles.PrezioaAtera(idHotel);
		
		
		
		long diff = (joanData.getTime() - sartuData.getTime());
		long diffEguna = (diff / 1000 / 60 / 60 / 24) + 1;
		round(diff, 2);
		if(diffEguna - 1 != 0) {
			prezioHotel = prezioHotel * (diffEguna - 1);	
		}
				
		if(o1.getOheSimpleBat() > 0) {
			 prezioa0 = prezioHotel * o1.getOheSimpleBat();
		}if(o1.getOheBikoitzBat() > 0){
			 prezioa1 = prezioHotel + (o1.getOheBikoitzBat() * (prezioHotel * 0.5)); // 50% extra por cada cama doble
		}if(o1.getOheBikoitzBatEtaOheSimpleBat() > 0) {
			 prezioa2 = prezioHotel + (o1.getOheBikoitzBatEtaOheSimpleBat() * (prezioHotel * 0.75)); // 75% extra por cada cama doble y simple
		}if(o1.getOheSimpleBi() > 0){
			 prezioa3 = prezioHotel + (o1.getOheSimpleBi() * (prezioHotel * 0.65)); 
		} 
		
		if(o1.getSehaska() > 0) {
			 prezioa4 = (o1.getSehaska() * (prezioHotel * 0.25));  //30% por cada Sehaska
		}
		
		prezioHotel = (prezioa0 + prezioa1 + prezioa2 + prezioa3 + prezioa4);
		
		prezioHotel = Math.round(prezioHotel * 100) / 100d;
		
		prezioHotel = prezioHotel + (zenbatJaiEgun * 20);
		System.out.println(prezioHotel + " "+ zenbatJaiEgun +"__________________");
		
		prezioHotel = prezioHotel - (prezioHotel * (promoPortzentaia / 100));
		prezioHotel = Math.round(prezioHotel * 100) / 100d;
		return (double) prezioHotel;
	}
	
	public static double prezioaEgunekinEtxea(double prezioHotel, Date joanData, Date sartuData,  double promoPortzentaia) {
		
		long diff = (joanData.getTime() - sartuData.getTime());
		long diffEguna = (diff / 1000 / 60 / 60 / 24) + 1;
		round(diff, 2);
		
		prezioHotel = prezioHotel * (diffEguna - 1);
		prezioHotel = Math.round(prezioHotel * 100) / 100d;
		
		prezioHotel = prezioHotel - (prezioHotel * (promoPortzentaia / 100));
		prezioHotel = Math.round(prezioHotel * 100) / 100d;
		return (double) prezioHotel;
	}

	private static void round(long diff, int i) {
	}
	
	public static Date gehituEguna(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
	
	public static Date gehituUrtea(Date date, int years)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }
	
	private static int ateraSinpleak (int sinpleak) {
		return sinpleak;
	}
	
	public static boolean DataKalkulatu (Date sartzekoDataCliente,Date joatekoDataCliente,ArrayList<java.sql.Date> dataJoan,ArrayList<java.sql.Date> dataEtorri, int oheMotakZbk, String oheMotak, int y, OheMotak o1) {
		int logelaKopurua = 0;
		
		
		if(y == 0) {
			logelaKopurua = o1.getOheSimpleBat();
		} else if(y == 1) {
			logelaKopurua = o1.getOheSimpleBi();
		}else if(y== 2) {
			logelaKopurua = o1.getOheBikoitzBat();
		}else if (y==3) {
			logelaKopurua = o1.getOheBikoitzBatEtaOheSimpleBat();
		}
		
		boolean lekua= false;
		
		int i = 0; // para cada intervalo 
	

		do {
	
			
			if(dataJoan.size() == 0) {
				lekua = true;

				getlogelaKant(logelaKopurua);
				return lekua;
			}
			
			if (sartzekoDataCliente.before(dataJoan.get(i))) { // Comparar dia de entrada comparar con dia de entrada BD
				if (joatekoDataCliente.before(dataJoan.get(i))) { // Comparar dia de salida comprara con dia de entrada BD
					

					++i;
				} else {
					++i;
					--logelaKopurua;// esta fecha esta ocupada, comprobamos la siguiente
				}
			} else if (sartzekoDataCliente.after(dataEtorri.get(i))) { // Comparar dia de entrada con dia de salida BD
				++i;
			} else {
				++i;
				--logelaKopurua;// esta fecha esta ocupada, comprobamos la siguiente
			}
			
			if(logelaKopurua < 0) {
				lekua = false;
			}else {
				lekua = true;
			}
			
	

		} while (i != dataJoan.size());
		
	
		

		getlogelaKant(logelaKopurua);
		
		logelaKopurua = logelaKopurua - oheMotakZbk;
		
		if(logelaKopurua < 0) {
			lekua = false;
		}
		

		return lekua;
	}
	
	public static int getlogelaKant (int logelaKant){
		if(logelaKant==999){
			logelaKant = LogelaKant;
		}else {
			LogelaKant = logelaKant;
			
		}
		
		
		
		return logelaKant;
	}
	//Este metodo le pasas un prezioa y las dos fechas seleccionadas.Con el Prezio que metes lo modifica segun las datak(Si coge temporada alta o no) y lo retorna
	public static double PrezioaTemporadekinKalkulatu (Date joanData, Date etorriData,double prezioa) throws ParseException {
		boolean temporadaAlta=false;
		int dias=0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Para declarar valores en nuevos objetos date, usa el mismo formato date que usaste al crear las fechas 
		//Fechas de Verano
		Date InicioVerano = sdf.parse("2019-06-21");
		Date InicioVeranoAñoSiguiente = sdf.parse("2020-06-21");
		Date FinVerano = sdf.parse("2019-09-23");
		Date FinVeranoAñoSiguiente = sdf.parse("2020-09-23");
		//Fechas de Semana Santa
		Date InicioSemanaSanta = sdf.parse("2019-04-05");
		Date InicioSemanaSantaAñoSiguiente = sdf.parse("2020-04-05");
		Date FinSemanaSanta = sdf.parse("2019-04-13");
		Date FinSemanaSantaAñoSiguiente = sdf.parse("2020-04-13");
		//Temporada Alta Navidad
		Date InicioNavidad = sdf.parse("2019-12-01");
		Date InicioNavidadAñoSiguiente = sdf.parse("2020-12-01");
		Date FinNavidad = sdf.parse("2020-01-01");
		Date FinNavidadAñoSiguiente = sdf.parse("2021-01-01");
		
		//Verano el Mismo Año
		if ((joanData.before(InicioVerano) && etorriData.after(InicioVerano))) {
		    dias=(int) ((etorriData.getTime()-InicioVerano.getTime())/86400000);
		    //egun bakoitza en temporada alta 10 euro gehiago
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(FinVerano) && etorriData.after(FinVerano)) {
		    dias=(int) ((FinVerano.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(InicioVerano) && etorriData.after(FinVerano)) {
		    dias=(int) ((FinVerano.getTime()-InicioVerano.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.after(InicioVerano) && etorriData.before(FinVerano)) {
		    dias=(int) ((etorriData.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		
		//------------------------------------------------------------------------------
		//SemanaSanta el Mismo Año
		if ((joanData.before(InicioSemanaSanta) && etorriData.after(InicioSemanaSanta))) {
			dias=(int) ((etorriData.getTime()-InicioSemanaSanta.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(FinSemanaSanta) && etorriData.after(FinSemanaSanta)) {
		    dias=(int) ((FinSemanaSanta.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(InicioSemanaSanta) && etorriData.after(FinSemanaSanta)) {
		    dias=(int) ((FinSemanaSanta.getTime()-InicioSemanaSanta.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.after(InicioSemanaSanta) && etorriData.before(FinSemanaSanta)) {
		    dias=(int) ((etorriData.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		//------------------------------------------------------------------------------
		//Verano el Siguiente Año
		if ((joanData.before(InicioVeranoAñoSiguiente) && etorriData.after(InicioVeranoAñoSiguiente))) {
		    dias=(int) ((etorriData.getTime()-InicioVeranoAñoSiguiente.getTime())/86400000);
		    //egun bakoitza en temporada alta 10 euro gehiago
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(FinVeranoAñoSiguiente) && etorriData.after(FinVeranoAñoSiguiente)) {
		    dias=(int) ((FinVeranoAñoSiguiente.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(InicioVeranoAñoSiguiente) && etorriData.after(FinVeranoAñoSiguiente)) {
		    dias=(int) ((FinVeranoAñoSiguiente.getTime()-InicioVeranoAñoSiguiente.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.after(InicioVeranoAñoSiguiente) && etorriData.before(FinVeranoAñoSiguiente)) {
		    dias=(int) ((etorriData.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		
		//------------------------------------------------------------------------------
		//Semana Santa el Siguiente Año
		if ((joanData.before(InicioSemanaSantaAñoSiguiente) && etorriData.after(InicioSemanaSantaAñoSiguiente))) {
		    dias=(int) ((etorriData.getTime()-InicioSemanaSantaAñoSiguiente.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(FinSemanaSantaAñoSiguiente) && etorriData.after(FinSemanaSantaAñoSiguiente)) {
		    dias=(int) ((FinSemanaSantaAñoSiguiente.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(InicioSemanaSantaAñoSiguiente) && etorriData.after(FinSemanaSantaAñoSiguiente)) {
		    dias=(int) ((FinSemanaSantaAñoSiguiente.getTime()-InicioSemanaSantaAñoSiguiente.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.after(InicioSemanaSantaAñoSiguiente) && etorriData.before(FinSemanaSantaAñoSiguiente)) {
		    dias=(int) ((etorriData.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		//------------------------------------------------------------------------------
		//Navidad el Mismo Año
		if ((joanData.before(InicioNavidad) && etorriData.after(InicioNavidad))) {
		    dias=(int) ((etorriData.getTime()-InicioNavidad.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(FinNavidad) && etorriData.after(FinNavidad)) {
		    dias=(int) ((FinNavidad.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(InicioNavidad) && etorriData.after(FinNavidad)) {
		    dias=(int) ((FinNavidad.getTime()-InicioNavidad.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.after(InicioNavidad) && etorriData.before(FinNavidad)) {
		    dias=(int) ((etorriData.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		
		//------------------------------------------------------------------------------
		//Navidad el Siguiente Año
		if ((joanData.before(InicioNavidadAñoSiguiente) && etorriData.after(InicioNavidadAñoSiguiente))) {
		    dias=(int) ((etorriData.getTime()-InicioNavidadAñoSiguiente.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(FinNavidadAñoSiguiente) && etorriData.after(FinNavidadAñoSiguiente)) {
		    dias=(int) ((FinNavidadAñoSiguiente.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.before(InicioNavidadAñoSiguiente) && etorriData.after(FinNavidadAñoSiguiente)) {
		    dias=(int) ((FinNavidadAñoSiguiente.getTime()-InicioNavidadAñoSiguiente.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		else if (joanData.after(InicioNavidadAñoSiguiente) && etorriData.before(FinNavidadAñoSiguiente)) {
		    dias=(int) ((etorriData.getTime()-joanData.getTime())/86400000);
		    prezioa=prezioa+(dias*10);
		    System.out.println("TEMPORADA ALTA ESTOS DIAS : "+dias+" PREZIO FINAL:"+prezioa);
		    temporadaAlta=true;
		}
		if (temporadaAlta=false) {
			System.out.println("No hay temporada Alta");
		}
		
		
		return prezioa;
	}


	/*private static String[] dataOkupatuta(Date joanData, Date sartuData) {
		String[] egunak;
		
		
		
		return egunak;
	}*/
	public static int SumaSpinners(int spinner1,int spinner2,int spinner3,int spinner4) {
		int sumaTotala=spinner1+spinner1+spinner3+spinner4;
		return sumaTotala;
	}
	
	public static int DataFestiboak(Date sartzekoDataKliente, Date joatekoDataKliente, Jaiegunak j1){
		int i=0;
		int jaiaKount = 0;
		ArrayList<java.sql.Date> jaiDatak = new ArrayList<java.sql.Date>();
		ArrayList <String> jaiIzenak = new ArrayList<String>();
		jaiDatak = j1.getJaiDatak();
		jaiIzenak = j1.getJaiIzenak();
		String jaiGustiak = "";
		String[] jaiakPrint =new String[100];
		do {
			if(sartzekoDataKliente.equals(jaiDatak.get(i))) {
		
		++jaiaKount;
		
	
			jaiakPrint[i] = jaiIzenak.get(i) + ":  " + jaiDatak.get(i);
			jaiGustiak = jaiakPrint[i] + "\n" + jaiGustiak;	
			}
			if(sartzekoDataKliente.before(jaiDatak.get(i))) { // 1 antes que: 5
		if(joatekoDataKliente.after(jaiDatak.get(i))) {  // 7 despues que: 5
		
			++jaiaKount;
			
				
				jaiakPrint[i] = jaiIzenak.get(i) + ":  " + jaiDatak.get(i);
				jaiGustiak = jaiakPrint[i] + "\n" + jaiGustiak;	
			}
		}
			++i;
		}while(jaiDatak.size() > i);
	
		
		printJaiegunak1(jaiGustiak, i);

	return jaiaKount;
		
	}


	public static String printJaiegunak1(String jaiGustiak, int i) {
		if(i != 999) {
			JaiGustiak = jaiGustiak;
		}else {
			jaiGustiak = JaiGustiak;
		}
	
		return jaiGustiak;
	}
	
	public static ArrayList<PromoKodea> promoKodeaBalidatu(String promoKodea){//Promozio gustiak artzen ditu BD-tik idBezeroaren arabera...
		boolean promoTrue = false;
		System.out.println("IMPORTANTE IDBEZERO = " + idBezero);
		ArrayList<PromoKodea> bdPromoKodeaArray = Kontsulta_Promoak.Promoak(idBezero);
		
		return bdPromoKodeaArray;
	}
	
	public static void promoIdBezeroBalidatu(String nan){//idBezero Gorde...
		idBezero = nan;
	}
	
}