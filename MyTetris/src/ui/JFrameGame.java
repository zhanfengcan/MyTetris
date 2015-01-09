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
		
		//���ñ���
		this.setTitle("����˹����");
		//���ò���
		this.setLayout(new BorderLayout());
		//���ô����С
		this.setSize(535,480);
		//����
		this.setLocationRelativeTo(null);
		//�ر��¼�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        
        JMenu game = new JMenu("��Ϸ");
        JMenuItem newgame = game.add("����Ϸ");
        JMenuItem exit = game.add("�˳�");
        JMenu help = new JMenu("����");
        JMenuItem about = help.add("����");
        JMenu author = new JMenu("����");
        
        newgame.addActionListener(new Menurestart(gamecontrol));
        exit.addActionListener(new ActionListener(){
       	 public void actionPerformed(ActionEvent e){
       		 System.exit(0);
    	 }
        });
        about.addActionListener(new Menuabout(gamecontrol));
        	  
   
        author.add("�̻���");
        author.add("���Ⱥ");
        author.add("������");
        author.add("ղ���");
        author.add("�޼ξ�");
        
        menu.add(game);
        menu.add(help);
        menu.add(author);
        
		//����Ĭ��Panel
		this.setContentPane(panel);
	}
}
