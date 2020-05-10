package m6uf3ex1;

import ElsMeusBeans.Comanda;
import ElsMeusBeans.Producte;

public class Ex1T6M6 {
	
	public static void main(String[] args) {
		//declarem els productes
		Producte productes[] = new Producte [4];
		productes[0] = new Producte(1, "Patates",10, 3, 50);
		productes[1] = new Producte(2, "Cogombres",5, 4, 50);
		productes[2] = new Producte(3, "Fuet",60, 5, 50);
		productes[3] = new Producte(4, "Pizza",22, 6, 50);
		
		//canviem l'stock per un nou valor superior al minim
		for (int i = 0; i < productes.length; i++) {
			
		int stockMin = productes[i].getStockminim();
		System.out.println("Producte:" + productes[i].getDescripcio());
		System.out.println("Stock anterior:" + productes[i].getStockactual());
		int nouStock = 0 ;
		while(nouStock < stockMin) {
			nouStock = (int)(Math.random()*10);
		}
		productes[i].setStockactual(nouStock);
		System.out.println("Stock actual: " + productes[i].getStockactual());
		System.out.println("Stock minim: " + stockMin);
		System.out.println();
		}
		
		Comanda comanda1 = new Comanda();
		comanda1.setIdproducte(1);
		comanda1.setQuantitat(3);
		productes[0].addPropertyChangeListener(comanda1);
		productes[0].setStockactual((productes[0].getStockactual() - comanda1.getQuantitat()));
		
		if(comanda1.isDemana()) {
			System.out.println("Fer comanda en producte: " + productes[0].getDescripcio());
			System.out.println("Stock actual: " + productes[0].getStockactual());
		}
		else {
			System.out.println("No hi ha comanda");
		}
		System.out.println();
		
		Comanda comanda2 = new Comanda();
		comanda1.setIdproducte(3);
		comanda1.setQuantitat(3);
		productes[2].addPropertyChangeListener(comanda2);
		productes[2].setStockactual((productes[3].getStockactual() - comanda2.getQuantitat()));
		
		if(comanda1.isDemana()) {
			System.out.println("Fer comanda en producte: " + productes[2].getDescripcio());
			System.out.println("Stock actual: " + productes[3].getStockactual());
		}
		else {
			System.out.println("No hi ha comanda");
		}
	}
	

}
