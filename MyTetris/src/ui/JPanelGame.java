package ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import control.GameControl;
import entity.Font;
import entity.Num;

public class JPanelGame extends JPanel{

	
	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = -6837014904297362969L;
	
	private final static Layer playwin = new Layer(5,5,234,400); 
	private final static Layer tipwin = new Layer(280,20,130,100); 
	private final static Layer rmlinewin = new Layer(280,135,180,54);
	private final static Layer levelwin = new Layer(280,202,180,54);	
	public final Layer startwin = new Layer(280,270,83,54);
	public final Layer pausewin = new Layer(280,335,83,54);	
	private final static Layer scorewin = new Layer(380,270,120,110);	
	
	private final static Background back = new Background();
	
	private final static Font rmlinestring = new Font("rmline");
	private final static Font levelstring = new Font("level");
	private final static Font startstring = new Font("start");
	private final static Font pausestring = new Font("pause");
	private final static Font scorestring = new Font("score");
	
	private final static Num rmline = new Num(363,145);
	private final static Num levelline = new Num(363,212);
	private final static Num score = new Num(400,325);	
	
	private GameControl gamecontrol;
	
	public JPanelGame(GameControl gamecontrol){
		
		this.gamecontrol = gamecontrol;
		
	}
	
	
	@Override
	public void paint(Graphics g){
	
		back.draw(g);
		
		playwin.creatwindow(g);
		tipwin.creatwindow(g);
		rmlinewin.creatwindow(g);
		levelwin.creatwindow(g);
		startwin.creatwindow(g);
		pausewin.creatwindow(g);
		scorewin.creatwindow(g);
		
		rmlinestring.write(g,290,147);
		levelstring.write(g,290,212);
		startstring.write(g,290,282);
		pausestring.write(g,290,347);
		scorestring.write(g,390, 280);
		
		rmline.write(g,gamecontrol.gamedao.cancelline);
		levelline.write(g,gamecontrol.gamedao.level);
		score.write(g,gamecontrol.gamedao.mark);
		
		gamecontrol.nowrect.draw(g,12,12);
		gamecontrol.nextrect.draw(g,235,72);
		gamecontrol.gamedao.drawmap(g);
		
	}
}
