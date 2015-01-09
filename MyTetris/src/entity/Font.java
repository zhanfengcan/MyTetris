package entity;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Font {
	
	private Image Font_Img ;
	
	private String font;
	
	public Font(String string){
		
		this.font = string;
		
		Font_Img = new ImageIcon("Graphics/string/"+this.font+".png").getImage(); 
		
	}
	
	public void write(Graphics g,int x,int y){
		
		g.drawImage(Font_Img, x, y, null);
		
	}
}
