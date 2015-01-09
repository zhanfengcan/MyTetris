package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.GameControl;
import control.Menuabout;
import control.Menurestart;

public class JFrameGame extends JFrame {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7629159316693020768L;
	
	public JFrameGame(JPanelGame panel,GameControl gamecontrol){
		
		//设置标题
		this.setTitle("俄罗斯方块");
		//设置布局
		this.setLayout(new BorderLayout());
		//设置窗体大小
		this.setSize(535,480);
		//居中
		this.setLocationRelativeTo(null);
		//关闭事件
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        
        JMenu game = new JMenu("游戏");
        JMenuItem newgame = game.add("新游戏");
        JMenuItem exit = game.add("退出");
        JMenu help = new JMenu("帮助");
        JMenuItem about = help.add("关于");
        JMenu author = new JMenu("作者");
        
        newgame.addActionListener(new Menurestart(gamecontrol));
        exit.addActionListener(new ActionListener(){
       	 public void actionPerformed(ActionEvent e){
       		 System.exit(0);
    	 }
        });
        about.addActionListener(new Menuabout(gamecontrol));
        	  
   
        author.add("蔡焕坚");
        author.add("杨灿群");
        author.add("梁健铭");
        author.add("詹丰灿");
        author.add("邹嘉境");
        
        menu.add(game);
        menu.add(help);
        menu.add(author);
        
		//设置默认Panel
		this.setContentPane(panel);
	}
}
