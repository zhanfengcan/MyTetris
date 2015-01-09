package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menurestart  implements ActionListener{

	public GameControl gamecontrol;
	public Menurestart(GameControl gamecontrol){
		this.gamecontrol= gamecontrol;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	 gamecontrol.restart();
}

}
