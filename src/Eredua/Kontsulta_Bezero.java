package Eredua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Kontrolatzailea.Bezero;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Kontsulta_Bezero {
	
	public static ArrayList <Bezero> BezeroakIkusi() {
		ArrayList <Bezero> bezeroak = new ArrayList<Bezero>();
		String idBezeroNan=null;
		String pasahitzaBezero=null;
		String izenBezero = null;
		String abizenBezero = null;
		int tlfBezero = 0;
		String postaBezero = null;		
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idBezero,pasahitzaBezero, izenBezero, abizenBezero, postaBezero FROM bezero");
			while (rs.next()) {
				idBezeroNan = rs.getString("idBezero");
				pasahitzaBezero = rs.getString("pasahitzaBezero");
				izenBezero = rs.getString("izenBezero");
				abizenBezero = rs.getString("abizenBezero");
				//tlfBezero = rs.getInt("telefBezero");
				postaBezero = rs.getString("postaBezero");
				Bezero b1 = new Bezero(idBezeroNan,pasahitzaBezero, izenBezero, abizenBezero, postaBezero);
				bezeroak.add(b1);
				System.out.println(b1);

			}
			System.out.println();
			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return bezeroak;
		
	}
}