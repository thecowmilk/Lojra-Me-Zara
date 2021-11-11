package gui;

import java.util.Arrays;

public class Lojetar {
    public String emri;
    public String mbiemri;
    public String mosha;
    public int[] vlZaret;//zaret
    public int[] pikeKategorie = {-1, -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private int piketSiperme=-1;
    private int piketPoshtme =-1;
    private int totali =-1;
    private int bonus=0;


    public int getPiketSiperme() {
		return piketSiperme;
	}


	public void setPiketSiperme(int piketSiperme) {
		this.piketSiperme = piketSiperme;
	}


	public int getPiketPoshtme() {
		return piketPoshtme;
	}


	public void setPiketPoshtme(int piketPoshtme) {
		this.piketPoshtme = piketPoshtme;
	}


	public int getTotali() {
		return totali;
	}


	public void setTotali(int totali) {
		this.totali = totali;
	}


	public String getEmri() {
		return emri;
	}


	public String getMbiemri() {
		return mbiemri;
	}


	public String getMosha() {
		return mosha;
	}


	public int[] getVlZaret() {
		return vlZaret;
	}


	public int[] getPikeKategorie() {
		return pikeKategorie;
	}


	public int getBonus() {
		return bonus;
	}


	public Lojetar(String emri, String mbiemri, String m ){
        this.emri = emri;
        this.mbiemri=mbiemri;
        this.mosha=m;
    }
    
    
    public void setPikeKategorie(int kategori, int piket) {
    	pikeKategorie[kategori]=piket;
    }
    
    
    public boolean kategoriELire(int kategoria){// kategoriaEZgjedhurMePare
        if(this.pikeKategorie[kategoria]>=0) {//tregon nese eshte zgjedhur tashme kategoria me pare
            return false;
        }
        return true;
    }
    
    

    public void shtoPiketNeKategorine(int kategoria, int piket){
        this.pikeKategorie[kategoria-1]=piket;
    }
    

    public int llogaritPiketSiperme(){
    	int piket=0;
            for (int i =0; i<6; i++)
                piket+= this.pikeKategorie[i];
            this.piketSiperme = piket;
            return this.piketSiperme;
    }

    
    public int llogaritPiketPoshtme(){
        int piket=0;
        for(int i=6; i<13; i++)
            piket+=this.pikeKategorie[i];
        this.piketPoshtme = piket;
        return this.piketPoshtme;
    }
    

    public int llogaritBonus(){
        if (this.piketSiperme>63)
            bonus=35;
        return bonus;
    }


    public int llogaritTotalin(){
            int totali = 0;
            for(int i =0; i<this.pikeKategorie.length; i++)
                totali+=this.pikeKategorie[i];
            totali+=bonus;
            this.totali = totali;
            return totali;
    }
}