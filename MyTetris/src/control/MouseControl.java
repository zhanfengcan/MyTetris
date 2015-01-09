package control;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseControl extends MouseAdapter {

	private GameControl gameControl;
	public MouseControl(GameControl gameControl){
		this.gameControl = gameControl;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getX()>gameControl.panel.startwin.x && e.getX()<(gameControl.panel.startwin.x+gameControl.panel.startwin.w))
			if(e.getY()>gameControl.panel.startwin.y+50 && e.getY()<(gameControl.panel.startwin.y+gameControl.panel.startwin.h+50)){
				gameControl.start();
		}
		
		if(e.getX()>gameControl.panel.pausewin.x && e.getX()<(gameControl.panel.pausewin.x+gameControl.panel.pausewin.w))
			if(e.getY()>gameControl.panel.pausewin.y+50 && e.getY()<(gameControl.panel.pausewin.y+gameControl.panel.pausewin.h+50)){
				gameControl.keyPause();
		}
		
	}
	
    @Override
    public void mouseMoved(MouseEvent e) {
    	
		if(e.getX()>gameControl.panel.startwin.x && e.getX()<(gameControl.panel.startwin.x+gameControl.panel.startwin.w))
		{
			if(e.getY()>gameControl.panel.startwin.y+50 && e.getY()<(gameControl.panel.startwin.y+gameControl.panel.startwin.h+50))
				gameControl.frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			else if(e.getY()>gameControl.panel.pausewin.y+50 && e.getY()<(gameControl.panel.pausewin.y+gameControl.panel.pausewin.h+50))
				gameControl.frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			else 
				gameControl.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		else 
			gameControl.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
	
}
