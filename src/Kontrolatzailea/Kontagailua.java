package Kontrolatzailea;

import Ikuspegia.EskerrikAskoLeihoa;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class Kontagailua extends Thread {

	
	@Override
    public void run(){
		EskerrikAskoLeihoa EskerrikAskoLeihoa= new EskerrikAskoLeihoa();
		EskerrikAskoLeihoa.setVisible(true);
    	for (int i=0;i<=5;i++) {
        	try {
				Thread.sleep(1000);

			}catch(InterruptedException e){
				e.printStackTrace();
			}	
    	}
    	EskerrikAskoLeihoa.dispose();
    	Metodoak.ongietorrileihora();
    }
    	
	
}