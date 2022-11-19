package Eredua;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Kontrolatzailea.Bezero;
import Kontrolatzailea.Etxea;
import Kontrolatzailea.Hotel;
import Kontrolatzailea.PromoKodea;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Kontsulta_Promoak {
	public static ArrayList<PromoKodea> Promoak(String idBezero) {
		ArrayList<PromoKodea> promoArray = new ArrayList<PromoKodea>();
		String promoKodea = null;
		int promoZbk = 0;
	
		System.out.println("IdBezero: " + idBezero);
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT promozioKodea, promozioa FROM promozioak WHERE idBezero = '"+idBezero+"'  OR idBezero IS NULL");
			while (rs.next()) {
				
				promoKodea = rs.getString("promozioKodea");
				promoZbk = rs.getInt("promozioa");
				System.out.println(idBezero + " codigo: "+promoKodea);
				
				PromoKodea p1 = new PromoKodea(promoKodea, promoZbk);
				promoArray.add(p1);

				//promoArray.add(promoKodea);

			}
		
			System.out.println();
			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Array 0 =" + promoArray.get(0));
		return promoArray;
	
		
		
	}
	

}
