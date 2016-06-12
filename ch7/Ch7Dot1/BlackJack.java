package ch7;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Implement BlcakJack with Card subclass
 */
public class BlackJack extends Card{
	public BlackJack(int n, Pattern p){
		super(n,p);
	}
	
	public int pointConversion(){
		int v = super.getValue();
		if (v ==1){
			//Which is Ace
			return 11;
		}
		if (v<10){
			return v;
		}
		
		//else JQK are count as 10
		return 10;
	}
	
	public boolean isAce(){
		return super.getValue() == 1;
	}
}
