package Eredua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Kontrolatzailea.Etxea;
import Kontrolatzailea.Hotel;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Kontsulta_Etxeak {

	public static ArrayList <Etxea> EtxeakIkusi(){
		ArrayList <Etxea> etxeak = new ArrayList<Etxea>();
		int idEtxea=0;
		String etxeaIzena=null;
		double prezioEtxea;
		String Helbidea=null;
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idEtxea, izenaEtxea, prezioEtxea, helbideEtxea FROM etxea");
			while (rs.next()) {
				idEtxea = rs.getInt("idEtxea");
				etxeaIzena = rs.getString("izenaEtxea");
				prezioEtxea = rs.getDouble("prezioEtxea");
				Helbidea = rs.getString("helbideEtxea");
				Etxea e1 = new Etxea (idEtxea, etxeaIzena, prezioEtxea,Helbidea);
				etxeak.add(e1);
				//System.out.println(izena);

			}
			System.out.println();
			System.out.println("Conexioa eginda3");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return etxeak;
	}
	
	
	public static ArrayList <Etxea> EtxeakHelbidearekinAtera(String helbideaHartu) {
		ArrayList <Etxea> etxeak2 = new ArrayList<Etxea>();
		int idEtxea=0;
		String etxeaIzena=null;
		double prezioEtxea;
		String Helbidea=null;
		
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idEtxea, izenaEtxea, prezioEtxea, helbideEtxea "
					+ "FROM etxea where helbideEtxea='"+helbideaHartu+"'");
			while (rs.next()) {
				idEtxea = rs.getInt("idEtxea");
				etxeaIzena = rs.getString("izenaEtxea");
				prezioEtxea = rs.getDouble("prezioEtxea");
				Helbidea = rs.getString("helbideEtxea");
				Etxea e1 = new Etxea (idEtxea, etxeaIzena, prezioEtxea,Helbidea);
				etxeak2.add(e1);
				//System.out.println(izena);

			}
			for (int i = 0; i < etxeak2.size(); i++) {
				etxeak2.get(i);
			}
			
			
			System.out.println();
			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(etxeak2);
		return etxeak2;
		
		
	}
	
	public static ArrayList <String> HelbideakIkusi() {
		ArrayList <String> Helbideak = new ArrayList<String>();
		String helbideak=null;
		
		
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;
	
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();
	
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT distinct helbideEtxea FROM etxea");
			while (rs.next()) {
				helbideak = rs.getString("helbideEtxea");
				Helbideak.add(helbideak);
				
			}
			System.out.println();
			System.out.println("Conexioa eginda2");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Helbideak;
		
	}

}
