package Eredua;
import java.sql.*; 

import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Ikuspegia.HotelakAukeratuLeihoa;
import Kontrolatzailea.Hotel;
import Kontrolatzailea.Metodoak;
import Kontrolatzailea.OheMotak;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Kontsulta_Hoteles{
	
	public static ArrayList <Hotel> HotelakIkusi() {
		ArrayList <Hotel> hotelak = new ArrayList<Hotel>();
		int idHotela=0;
		String hotelIzena=null;
		int logelaKopurua=0;
		int HartutakoLogelak=0;
		int izarKopurua=0;
		Double prezioHotel=null;
		String Helbidea=null;
		
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idHotel,izenaHotel,izarKopurua,prezioHotelSimple,helbideHotel FROM hotel");
			while (rs.next()) {
				idHotela = rs.getInt("idHotel");
				hotelIzena = rs.getString("izenaHotel");
				izarKopurua = rs.getInt("izarKopurua");
				prezioHotel = rs.getDouble("prezioHotelSimple");
				Helbidea = rs.getString("helbideHotel");
				Hotel h1 = new Hotel(idHotela, hotelIzena, izarKopurua, prezioHotel,Helbidea);
				hotelak.add(h1);
			

			}
			System.out.println("Conexioa eginda3");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return hotelak;
		
	}
	/**
	 * 
	 * @return
	 */
	
	public static ArrayList <String> HelbideakIkusi() {
		ArrayList <String> Helbideak = new ArrayList<String>();
		String helbideak=null;
		
		
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT distinct helbideHotel FROM hotel");
			while (rs.next()) {
				helbideak = rs.getString("helbideHotel");
				Helbideak.add(helbideak);
				
			}
			System.out.println("Conexioa eginda2");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Helbideak;
		
	}
	/**
	 * 
	 * @param helbideaHartu
	 * @return
	 */
	
	public static ArrayList <Hotel> HotelakHelbidearekinAtera(String helbideaHartu) {
		
		ArrayList <Hotel> hotelak2 = new ArrayList<Hotel>();
		int idHotela=0;
		String hotelIzena=null;
		int logelaKopurua=0;
		//int HartutakoLogelak=0;
		int izarKopurua=0;
		Double prezioHotel=null;
		String Helbidea=null;
		
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idHotel,izenaHotel,izarKopurua,prezioHotelSimple,helbideHotel FROM hotel where helbideHotel='"+helbideaHartu+"'");
			while (rs.next()) {
				idHotela = rs.getInt("idHotel");
				hotelIzena = rs.getString("izenaHotel");
				//HartutakoLogelak = rs.getInt("HartutakoLogelak");
				izarKopurua = rs.getInt("izarKopurua");
				prezioHotel = rs.getDouble("prezioHotelSimple");
				Helbidea = rs.getString("helbideHotel");
				Hotel h1 = new Hotel(idHotela, hotelIzena, izarKopurua, prezioHotel,Helbidea);
				hotelak2.add(h1);

			}
			for (int i = 0; i < hotelak2.size(); i++) {
				hotelak2.get(i);
			}
			
			
			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return hotelak2;
		
		
	}
	/**
	 * 
	 * @param idHotel
	 * @return
	 */
	
	public static Double PrezioaAtera(int idHotel) {
		
		Double prezioHotel=null;

		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT prezioHotelSimple FROM hotel WHERE idHotel ='"+idHotel+"'");
			while (rs.next()) {
				
				prezioHotel = rs.getDouble("prezioHotelSimple");
				
				

			}
			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

		
		return prezioHotel;
		
	}
	/**
	 * 
	 * @param oheMotak
	 * @return
	 */
	public static ArrayList<Date>[] dataJoan(String oheMotak) {
		ArrayList<java.sql.Date> dataJoan = new ArrayList<java.sql.Date>();
		ArrayList<java.sql.Date> dataEtorri = new ArrayList<java.sql.Date>();
		ArrayList<java.sql.Date>[] dataArray = new ArrayList[2]; 
		int i=0;
	

		Date JoatekoData = null;
		Date EtortzekoData = null;

		int loguelaKopurua;
		
		int idHotel = HotelakAukeratuLeihoa.idHotelArtu();

		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s = null;

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + "bidaion", "root", "");
			s = (Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT dataJoan, dataEtorri, "+oheMotak+" FROM erreserba WHERE idOstatu  ='"+idHotel+"' AND "+oheMotak+" > 0"); 
					
			while (rs.next()) {
				JoatekoData = rs.getDate("dataJoan");
				EtortzekoData = rs.getDate("dataEtorri"); 
				loguelaKopurua = rs.getInt(oheMotak);
				i=0;
				
				do {
					dataJoan.add(JoatekoData);
					dataEtorri.add(EtortzekoData);
					

					++i;
					
					
					}while(loguelaKopurua > i );

			}
			System.out.println("Conexioa eginda");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		dataArray[0] = dataJoan;
		dataArray[1] = dataEtorri;
		
		
		
		
		
		return dataArray;

	}
	/**
	 * 
	 * @param oheMotak
	 * @return
	 */
	


	
	public static int HoteleanZenbatLekuDauden(String oheMotak) {
		int logelaKopuru=0;
		int idHotel = HotelakAukeratuLeihoa.idHotelArtu();
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s = null;
		

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + "bidaion", "root", "");
			s = (Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT "+oheMotak+" FROM hotel where idHotel ='"+idHotel+"'");
			while (rs.next()) {
				logelaKopuru = rs.getInt(oheMotak);

			}
			System.out.println("Conexioa eginda1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return logelaKopuru;

	}
	/**
	 * 
	 * @return
	 */
	


	public static OheMotak logelaKopurua() {
		int idHotel = HotelakAukeratuLeihoa.idHotelArtu();
		OheMotak o2 = new OheMotak(9, 9, 9, 9, 9);
	
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s = null;

	try {
		// Class.forName("com.mysql.jdbc.Driver");
		//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + "bidaion", "root", "");
		s = (Statement) Conexion.createStatement();

		ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT 1sinp, 2sinp, 1bik, 1sinp1bik FROM hotel where idHotel ='"+idHotel+"'");
		
		while (rs.next()) {
			
			o2.setOheSimpleBat(rs.getInt("1sinp"));
			o2.setOheSimpleBi(rs.getInt("2sinp"));
			o2.setOheBikoitzBat(rs.getInt("1bik"));
			o2.setOheBikoitzBatEtaOheSimpleBat(rs.getInt("1sinp1bik"));
			
			


		}
		System.out.println("Conexioa eginda2");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	

	
	
	return o2;
		
	}
	
	
	
	
	
	
	
}