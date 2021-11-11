package gui;

import java.util.Arrays;

public class Kategorite {
	
	
    public static int kategori1(int []a){
        int shuma=0;
        for(int i=0; i<5; i++){
            if(a[i]==1){
                shuma+=a[i];
            }
        }
        return shuma;
    }

 

    public static int kategori2(int []a){
        int shuma=0;
        for(int i=0; i<5; i++){
            if(a[i]==2){
                shuma+=a[i];
            }
        }
        return shuma;
    }

 

    public static int kategori3(int []a){
        int shuma=0;
        for(int i=0 ; i<5; i++){
            if(a[i]==3){
                shuma+=a[i];
            }
        }
        return shuma;
    }

 

    public static int kategori4(int []a){
        int shuma=0;
        for(int i=0; i<5; i++){
            if(a[i]==4){
                shuma+=a[i];
            }
        }
        return shuma;
	}
 

    public static int kategori5(int []a){
        int shuma=0;
        for(int i=0; i<5; i++){
            if(a[i]==5){
                shuma+=a[i];
            }
        }
        return shuma;
    }
 

    public static int kategori6(int []a){
        int shuma=0;
        for(int i=0; i<5; i++){
            if(a[i]==6){
                shuma+=a[i];
            }
        }
        return shuma;
    }
 
    
    
    public static int kategori7(int a[]) {//tre me nje vlere
    	int[] perseritje=new int[]{ 0,0,0,0,0,0 };
    	int shuma=0;
    	for(int i=0; i<a.length; i++) {
    		perseritje[a[i]-1]++;
    		shuma=shuma+a[i];
    	}
    	for(int i=0; i<perseritje.length; i++) {
    		if(perseritje[i]>=3)
    			return shuma;
    	}
    	return 0;
    }

    
    
    public static int kategori8(int a[]) {//kater me nje vlere
    	int[] perseritje=new int[]{ 0,0,0,0,0,0 };
    	int shuma=0;
    	for(int i=0; i<a.length; i++) {
    		perseritje[a[i]-1]++;
    		shuma=shuma+a[i];
    	}
    	for(int i=0; i<perseritje.length; i++) {
    		if(perseritje[i]>=4)
    			return shuma;
    	}
    	return 0;
    }
    
    
    public static int kategori9(int a[]) {//tre me dy
    	int[] perseritje=new int[]{ 0,0,0,0,0,0 };
    	int shuma=0;
    	for(int i=0; i<a.length; i++) {
    		perseritje[a[i]-1]++;
    		shuma=shuma+a[i];
    	}
    	for(int i=0; i<perseritje.length; i++) {
    		if(perseritje[i]==2)
    			for(int j=i+1; j<perseritje.length; j++) {
    				if(perseritje[j]==3)
    					return 25;
    			}
    		else if(perseritje[i]==3)
    			for(int j=i+1; j<perseritje.length; j++) {
    				if(perseritje[j]==2)
    					return 25;
    			}
    }
		return 0;
  }
    
    
	public static int kategori10(int a[]) {    //kater te njepasnjeshme
		int[] arr=Arrays.copyOf(a, 5);
		Arrays.sort(arr);
		int count=1;  //mban sa numra te njepasnjeshem kemi
		int piket;
		
		for(int i=1;i<a.length;i++){
			if(arr[i]==arr[i-1]+1)
				count++;
			else continue;
		}
		if(count==4)
			piket=30;
		else piket=0;
		return piket;
	}
	
	
	
	public static int kategori11(int a[]) {    // pese te njepasnjeshme
		int[] arr=Arrays.copyOf(a, 5);
		Arrays.sort(arr);
		int count=1;  //mban sa numra te njepasnjeshem kemi
		int piket;
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i]==arr[i-1]+1)
			count++;
			else continue;
		}
		if(count==5)
			piket=40;
		else piket=0;
		return piket;
	}
	
	
	public static int kategori12(int a[]) { // e njejta vlere
		int i;
		for (i=1; i<a.length; i++) {
			if(a[0]!=a[i])
				break;
			}
		if(i==a.length)
			return 50;
		else return 0;	
	}
	
	public static int kategori13(int a[]){ //cdo rast
		int sum=0;
		for(int i=0; i<a.length; i++)
			sum=sum+a[i];
		return sum;
		}

    

}
