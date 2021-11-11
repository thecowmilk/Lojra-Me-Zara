package gui;

import java.util.Random;


public class Zari {
	public int vleraZari[]=new int[5];//do te ruaje vlerat random te 5 zareve
	public boolean boolZari[]=new boolean[5];//true nese duam ta ruajme vleren e nje zari
	public int hedhja=0;
	
	
	public Zari() {
		
	}
	
	
	
	public void gjenero() {
		if(hedhja<=3)
		for(int i=0; i<5; i++) {
			if(boolZari[i]==false) {
				int rand=(int) Math.floor(Math.random()*6+1);
				vleraZari[i]=rand;
			}
		}
	} 
	
	
	
	public void resetZarin() {
		//rikthej vektorin boolean dhe nr e hedhjes ne vlerat e fillimit
			hedhja=0;
			for(int i=0; i<5; i++) 
				boolZari[i]=false;
		}	
	
	
	public void ruaj(int nrZari) {
		boolZari[nrZari-1]=true;//ku nrZari fillon nga 1-5 (nrZari-1=pozicioni ne vektor)
	}
	
}