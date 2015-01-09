package control;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import ui.JFrameGame;
import ui.JPanelGame;
import dao.GameDao;
import entity.Rect;




public class GameControl {

	public JPanelGame panel;
	private Timer timer;
	private boolean stop=false;
	
	public GameDao gamedao;
	public JFrameGame frame;
	public Rect nowrect;
	public Rect nextrect;
	
	private class GameTask extends TimerTask {
		private int speed = 10;
        public void run() {
        	if(speed <= 0 && !stop){

            	Random random = new Random();
                
            	if(gamedao.isput(nowrect)){
                	nowrect.color = 0;
                	nowrect = new Rect(nextrect.color);
                	nextrect = new Rect(random.nextInt(7)+1);
                	if(gamedao.iscancel()){};
                	if(gamedao.gameover()){
                		JOptionPane.showMessageDialog(panel,"你输啦"); 
                		timer.cancel();
                	}
                }            
                
                nowrect.down();
                panel.repaint();
                speed=10-gamedao.level;
                
        	}
        	else 
        		speed--;
        }
    }
	
	public GameControl() {
		Random random = new Random();
	
		// 随机产生方块
		this.nowrect  = new Rect(random.nextInt(7)+1);
		this.nextrect = new Rect(random.nextInt(7)+1);
		
		// 创建线程
		timer = new Timer();
		
		// 创建游戏面板
		this.panel = new JPanelGame(this);
		timer.schedule(new GameTask(), 100,30);
		
		// 创建游戏窗口
		frame = new JFrameGame(panel,this);
		frame.setVisible(true);

		// 添加键盘事件
		KeyControl keyboard = new  KeyControl(this);
		frame.addKeyListener(keyboard);
		
		//添加鼠标事件
		MouseControl mouse = new MouseControl(this);
		frame.addMouseListener(mouse);
		frame.addMouseMotionListener(mouse);
		
		gamedao = new GameDao();
	}

	public void keyUp() {
	

		if(gamedao.ischangeok(nowrect) && !stop)
			nowrect.change();
		panel.repaint();
		
	}

	public void keyDown() {
		
    	if(gamedao.isput(nowrect))return;
		if(!stop)
			nowrect.down();
    	panel.repaint();

	}

	public void keyLeft() {

		//if(gamedao.isput(nowrect)) return;
		if(gamedao.isleftside(nowrect))	return;	
		if(!stop)
			nowrect.left();
		panel.repaint();
				
	}

	public void keyRight() {
	   	
		//if(gamedao.isput(nowrect)) return;
		if(gamedao.isrightside(nowrect))	return;	
		if(!stop)
			nowrect.right();
		panel.repaint();
				
	}


	/*
	 * 暂停
	 */
	public void keyPause()  {
		
		stop=true;
		
	}

	/*
	 * 开始
	 */
	public void start() {
		
		stop=false;
		
	}
	
	/*
	 * 开始/暂停
	 */
	public void change() {
		
		stop=!stop;
		
	}

	/*
	 * 重新开始
	 */
	public void restart() {
		
		gamedao.init();
		Random random = new Random();
		this.nowrect  = new Rect(random.nextInt(7)+1);
		this.nextrect = new Rect(random.nextInt(7)+1);
		panel.repaint();
	}	
	
}
