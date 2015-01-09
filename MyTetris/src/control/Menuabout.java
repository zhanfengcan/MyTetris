package control;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menuabout  implements ActionListener{

	public GameControl gamecontrol;
	public Menuabout(GameControl gamecontrol){
		this.gamecontrol= gamecontrol;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	 gamecontrol.keyPause();
	 JFrame helpmenu=new JFrame();
	 int windowWidth = helpmenu.getWidth(); //获得窗口宽
	 int windowHeight = helpmenu.getHeight(); //获得窗口高
	 Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
	 Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
	 int screenWidth = screenSize.width; //获取屏幕的宽
	 int screenHeight = screenSize.height; //获取屏幕的高

	 ImageIcon background = new ImageIcon("Graphics/menu/menu.png");// 说明图片
	 JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
	  // 把标签的大小位置设置为图片刚好填充整个面板
	 label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
	 JPanel imagePanel = (JPanel) helpmenu.getContentPane();
	// 内容窗格默认的布局管理器为BorderLayout
	 imagePanel.setLayout(new FlowLayout());
	 imagePanel.setOpaque(false);
	 helpmenu.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	 
	 helpmenu.setLocation(screenWidth / 2 - windowWidth / 2-background.getIconWidth()/2, screenHeight / 2 - windowHeight / 2-background.getIconHeight()/2-20);//设置窗口居中显示
	 helpmenu.setSize(background.getIconWidth(), background.getIconHeight()+20);
	 helpmenu.setResizable(false);
	 helpmenu.setVisible(true);
}

}
