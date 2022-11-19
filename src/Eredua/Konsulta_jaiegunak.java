package Eredua;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Kontrolatzailea.Hotel;
import Kontrolatzailea.Jaiegunak;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Konsulta_jaiegunak {
	
	public static Jaiegunak JaiegunakAtera() {
		ArrayList <Date> jaiEgunak = new ArrayList<Date>();
		ArrayList <String> jaiIzenak = new ArrayList<String>();

		Date jaieguna=null;
		String jaiegunIzena;
		
		
		
		Connection Conexion = null;
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT jaiEguna, jaiegunIzena FROM jaiegunak");
			while (rs.next()) {
				jaieguna = rs.getDate("jaiEguna");
				jaiegunIzena= rs.getString("jaiegunIzena");
				
				jaiEgunak.add(jaieguna);
				jaiIzenak.add(jaiegunIzena);
		System.out.println(jaiEgunak);
		System.out.println(jaiIzenak);
				
			}
		
			System.out.println();
			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Jaiegunak j1 = new Jaiegunak(jaiEgunak, jaiIzenak);
		
		return j1;
	}
	
}
		
