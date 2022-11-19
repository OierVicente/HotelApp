package Eredua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Kontrolatzailea.Apartamentua;
import Kontrolatzailea.Etxea;
import Kontrolatzailea.Hotel;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Kontsulta_Apartamentua {
	
	public static ArrayList <Apartamentua> ApartamentuakIkusi(){
		ArrayList <Apartamentua> Apartamentuak = new ArrayList<Apartamentua>();
		int idApartamentu=0;
		String izenaApartamentu=null;
		double prezioApartamentu;
		String helbideApartamentu=null;
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idApartamentu, izenaApartamentu, prezioApartamentu, helbideApartamentu FROM apartamentu");
			while (rs.next()) {
				idApartamentu = rs.getInt("idApartamentu");
				izenaApartamentu = rs.getString("izenaApartamentu");
				prezioApartamentu = rs.getDouble("prezioApartamentu");
				helbideApartamentu = rs.getString("helbideApartamentu");
				Apartamentua a1 = new Apartamentua (idApartamentu, izenaApartamentu, prezioApartamentu,helbideApartamentu);
				Apartamentuak.add(a1);

			}
			System.out.println();
			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return Apartamentuak;
	}
	/**
	 * 
	 * @return
	 */
	
	public static ArrayList <String> ApartamentuenHelbideakIkusi() {
		ArrayList <String> Helbideak = new ArrayList<String>();
		String helbideak=null;
		
		
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT distinct helbideApartamentu FROM apartamentu");
			while (rs.next()) {
				helbideak = rs.getString("helbideApartamentu");
				Helbideak.add(helbideak);
				
			}
			System.out.println();
			System.out.println("Conexioa eginda");
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
	
	public static ArrayList <Apartamentua> ApartamentuakHelbidearekinAtera(String helbideaHartu) {
		
		ArrayList <Apartamentua> apartamentu2 = new ArrayList<Apartamentua>();
		int idApartamentu=0;
		String izenaApartamentu=null;

		double prezioaApartamentu;
		String helbideApartamentu=null;
		
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idApartamentu,izenaApartamentu,prezioApartamentu,helbideApartamentu FROM apartamentu where helbideApartamentu='"+helbideaHartu+"'");
			while (rs.next()) {
				idApartamentu = rs.getInt("idApartamentu");
				izenaApartamentu = rs.getString("izenaApartamentu");
				prezioaApartamentu = rs.getDouble("prezioApartamentu");
				helbideApartamentu = rs.getString("helbideApartamentu");
				Apartamentua a1 = new Apartamentua(idApartamentu, izenaApartamentu, prezioaApartamentu, helbideApartamentu);
				apartamentu2.add(a1);

			}
			
			System.out.println();
			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return apartamentu2;
		
		
	}

}
