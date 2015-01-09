package entity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Num {

		private static final int NUMW = 26;
		
		private static final int NUMH = 34; 
		
		private int num;
		
		private int x;
		
		private int y;
		
		private Image NUM_IMG = new ImageIcon("Graphics/string/num.png").getImage();
		
		public Num(int x,int y){

			//this.num=num;	
			
			this.x=x;
			
			this.y=y;
			
		}
		
		public void write(Graphics g,int num){
			
			this.num=num;	
			
			int wei = 1 ;
				
			while((num/Math.pow(10, wei)) > 1){	
				
				wei++;
				
			}
			
			for(int i=0;i<wei;i++){
				
				int tmp=num % (int)Math.pow(10, wei-i) / (int)Math.pow(10, wei-i-1);
				
				g.drawImage(NUM_IMG, x+i*NUMW , y, x+(i+1)*NUMW , y+NUMH, tmp*NUMW, 0 , (tmp+1)*NUMW, NUMH, null);
				
			}
			
			
		}
}
