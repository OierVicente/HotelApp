package Eredua;

import java.sql.DriverManager; 

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import Kontrolatzailea.ErabiltzaileaIgo;
import Kontrolatzailea.Metodoak;


/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Konsulta_Erregistro {
	
	
	public static void Erabiltzailea_erregistratu(ErabiltzaileaIgo e1) {
		
		Connection Conexion = (Connection) Konexioa.getConexion();
		Statement s =null;
		try {

			//Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+"bidaion","root","");

			s = (Statement) Conexion.createStatement();

			s.executeUpdate("INSERT INTO `bezero` (`idBezero`, `pasahitzaBezero`, `izenBezero`, `abizenBezero`, `postaBezero`, `jaiotzeData`, `altaData`) "
					+ "VALUES ('"+e1.getNan()+"', '"+e1.getPasahitza()+"', '"+e1.getErabil_Izena()+"', '"+e1.getErabil_Abizenak()+"', '"+e1.getPostaBezero()+"', '"+e1.getJaiotzeData()+"', '"+e1.getAltaData()+"')");
			s.close();

			System.out.println("Conexioa eginda");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
//	INSERT INTO `bezero` (`idBezero`, `pasahitzaBezero`, `izenBezero`, `abizenBezero`, `postaBezero`, `jaiotzeData`) VALUES ('15634D', 'c4ca4238a0b923820dcc509a6f75849b', 'Prueba', 'prueba2', 'gdfdfg@fdgdfg.com', 'frtdfgd');
//
//	INSERT INTO bezero (idBezero,pasahitzaBezero,izenBezero,abizenBezero,postaBezero,jaiotzeData) VALUES ('1342345D', 'hola', 'dasda', 'gsdfgsdfg', 'fsdfsdf@gdfgdf.com', '1990-01-01')
	
// INSERT INTO `bezero` (`idBezero`, `pasahitzaBezero`, `izenBezero`, `abizenBezero`, `postaBezero`, `jaiotzeData`) "
// + "VALUES ('"+e1.getNan()+"','"+e1.getPasahitza()+"', '"+e1.getErabil_Izena()+"', '"+e1.getErabil_Abizenak()+"', '"+e1.getPostaBezero()+"', '"+e1.getJaiotzeData()+"')
	
	
}