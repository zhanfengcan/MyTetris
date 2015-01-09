package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Layer extends JButton{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3144082323765440087L;

	private static final int SIZE = 7;

	private static final Image WINDOW_IMG=new ImageIcon("Graphics/window/Window.png").getImage();
	//private static final Image WINDOW_IMG=new ImageIcon("Graphics/button/yellow.png").getImage();
	
	private static final int WINDOW_IMGW = WINDOW_IMG.getWidth(null);
	
	private static final int WINDOW_IMGH = WINDOW_IMG.getHeight(null);
	
	/**
	 * 窗口左上角x坐标
	 */
	public int x;
	/**
	 * 窗口左上角y坐标
	 */
	public int y;
	/**
	 * 窗口宽度
	 */
	public int h;
	/**
	 * 窗口高度
	 */
	public int w;
	/**
	 * 构造函数
	 */
	public Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	/**
	 * 创建窗体
	 */
	public void creatwindow(Graphics g){
		//左上
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//中上
		g.drawImage(WINDOW_IMG, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WINDOW_IMGW-SIZE, SIZE, null);
		//右上
		g.drawImage(WINDOW_IMG, x+w-SIZE, y, x+w, y+SIZE, WINDOW_IMGW-SIZE, 0, WINDOW_IMGW, SIZE, null);
		//左中
		g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_IMGH-SIZE, null);	
		//中
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_IMGW-SIZE, WINDOW_IMGH-SIZE, null);			
		//右中
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_IMGW-SIZE, SIZE, WINDOW_IMGW,WINDOW_IMGH-SIZE, null);
		//左下
		g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_IMGH-SIZE, SIZE, WINDOW_IMGH, null);
		//中下
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_IMGH-SIZE, WINDOW_IMGW-SIZE, WINDOW_IMGH, null);
		//右下
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_IMGW-SIZE, WINDOW_IMGH-SIZE, WINDOW_IMGW, WINDOW_IMGH, null);		
	}
	
	
}
