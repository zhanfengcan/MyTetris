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
	 int windowWidth = helpmenu.getWidth(); //��ô��ڿ�
	 int windowHeight = helpmenu.getHeight(); //��ô��ڸ�
	 Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
	 Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
	 int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
	 int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�

	 ImageIcon background = new ImageIcon("Graphics/menu/menu.png");// ˵��ͼƬ
	 JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
	  // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
	 label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
	 JPanel imagePanel = (JPanel) helpmenu.getContentPane();
	// ���ݴ���Ĭ�ϵĲ��ֹ�����ΪBorderLayout
	 imagePanel.setLayout(new FlowLayout());
	 imagePanel.setOpaque(false);
	 helpmenu.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	 
	 helpmenu.setLocation(screenWidth / 2 - windowWidth / 2-background.getIconWidth()/2, screenHeight / 2 - windowHeight / 2-background.getIconHeight()/2-20);//���ô��ھ�����ʾ
	 helpmenu.setSize(background.getIconWidth(), background.getIconHeight()+20);
	 helpmenu.setResizable(false);
	 helpmenu.setVisible(true);
}

}
