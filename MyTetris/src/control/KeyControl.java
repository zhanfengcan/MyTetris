package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter{

	private GameControl gameControl;
	public KeyControl(GameControl gameControl){
		this.gameControl = gameControl;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_DOWN:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_LEFT:
			this.gameControl.keyLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.gameControl.keyRight();
			break;
		case KeyEvent.VK_A:
			//this.gameControl.restart();
			break;
		case KeyEvent.VK_SPACE:
			this.gameControl.change();
			break;
		default:
			break;
		}
	}
	
	
	
}
