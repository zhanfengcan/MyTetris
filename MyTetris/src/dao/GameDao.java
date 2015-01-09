package dao;

import java.awt.Graphics;

import entity.Rect;

public class GameDao {

	private boolean[][] gamemap;
	
	public int cancelline=0;
	
	public int mark=0;
	
	public int level=0;
	
	public GameDao(){
		
		this.init();
		
	}
	
	public void init(){
		
		this.gamemap = new boolean[11][19];
		for(int x=0;x<11;x++)
			for(int y=0;y<19;y++)
				gamemap[x][y]=false;
		level=0;
		mark=0;
	}
	
	public boolean isleftside(Rect nowrect){
		
		for(int i=0;i<4;i++){
			//左边有墙或者方块都不行
			if(nowrect.x[i]==0 || gamemap[nowrect.x[i]-1][nowrect.y[i]])		
				return true;
		}
		return false;
	}
	
	public boolean isrightside(Rect nowrect){
		
		for(int i=0;i<4;i++){
			//右边有墙或者方块都不行
			if(nowrect.x[i]==10  || gamemap[nowrect.x[i]+1][nowrect.y[i]])
				return true;
		}
		return false;
	}
	
	public boolean isput(Rect nowrect){
		
		boolean isput = false;

		for(int i=0;i<4;i++)
			//底下有墙或者方块
			if( nowrect.y[i]>=18 || gamemap[nowrect.x[i]][nowrect.y[i]+1] ){
				isput = true;
				break;
			}

		if(isput)
			//如果isput，放进地图
			for(int j=0;j<4;j++)
				gamemap[nowrect.x[j]][nowrect.y[j]]=true;
		
		return isput;
	}

	public boolean ischangeok(Rect nowrect){
		
		for(int i=0;i<4;i++){
			int change_x = nowrect.y[i]-nowrect.y[0]+nowrect.x[0] ;
			int change_y = nowrect.x[0]-nowrect.x[i]+nowrect.y[0] ;
			if(  change_x<0 || change_y<0 || change_x>10 || gamemap[change_x][change_y])
				return false;
		}
		return true;
	}
	
	public boolean gameover(){
		
		//boolean game=false;
		for(int x=0;x<11;x++){
			if(gamemap[x][0] == true)
				return true;
		}
		return false;
		
	}
	public boolean iscancel(){
		
		boolean iscancel=false;
		int tmpline=0;						//用于算分
		for(int y=18;y>=0;y--)
			for(int x=0;x<11;x++){
				if(gamemap[x][y] != true)
					break;

				if(x==10){
					tmpline++;
					cancelline++;
					cancelline(y);
					y++;
					iscancel=true;
				}
			}
		
		if(tmpline != 0){
			
			//分数和等级计算
			mark+=tmpline*tmpline;
			if(mark > (2+2*level*level))
				level++;
			
		}
			
		
		return iscancel;
	}
	
	public void cancelline(int line){
		
		for(int y=line;y>0;y--)
			for(int x=0;x<11;x++){
				gamemap[x][y] = gamemap[x][y-1];
			}	
		
	}
	public void drawmap(Graphics g){
		
		Rect rect = new Rect(0);
		for(int x=0;x<11;x++)
			for(int y=0;y<19;y++)
				if(gamemap[x][y]==true)
					rect.drawone(g,12,12,x,y);
		
	}
}
