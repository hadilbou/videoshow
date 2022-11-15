package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// création de la fenêtre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// création de la zône de dessin dans la fenêtre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fenêtre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[10];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		visage v= new visage(d);
		d.ajouterObjet(v);
       
        Forme f2= new PolygoneRegulier(5,240,40,40,4.0f,Color.DARK_GRAY,Color.BLACK);
       
        d.ajouterObjet(f2);
        visage v2= new visage(d);
		d.ajouterObjet(v2);
		 Forme f3= new Etoile(150, 150, 50, 8.f, Color.GREEN, Color.GREEN);
		 d.ajouterObjet(f3);
		 MvtCirculaire m1=new MvtCirculaire(100, 150, 150, 10, 6.2);
		 Forme f= new Etoile(150, 150, 50, 8.f, Color.yellow, Color.yellow);
		 AnimationForme k= new AnimationForme(f,m1);
		 d.ajouterObjet(k);
		 MvtCirculaire m2=new MvtCirculaire(200, 300, 150, 5, 2.2);
		 Forme f1= new PolygoneRegulier(5,240,40,40,4.0f,Color.GRAY,Color.GRAY);
		 AnimationForme k1= new AnimationForme(f1,m2);
		 d.ajouterObjet(k1);
		 
		while(true) {
		// la zone de dessin se réaffiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//réaliser à tous les trains un déplacement élémentaire
		d.animer();
		
		}

	}

}
