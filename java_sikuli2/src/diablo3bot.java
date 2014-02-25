import org.sikuli.script.*;
public class diablo3bot {

	public Screen s; 
	
	public diablo3bot(){		
		s = new Screen();
	}
	
	public void start() throws FindFailed{
		s.click("imgs/minimerad_diablo3_2.png");
		while (true){
			try {
				run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void clickImage(String imgStr) throws FindFailed{
		s.wait(imgStr, 16);
        s.click(imgStr);		
	}
	public void moveCoord(){
		
		
	}
	
	public void moveDir(long time, String dir) throws FindFailed, InterruptedException{
		//dirs: n , s, w, e , nw, ne, sw, se
		//time: walking time in ms
		//walks to mouse pos when h-key is pressed
		
		long[] coords=dir(dir);
		s.hover(new Location(coords[0],coords[1]));
        s.keyDown("h");
        Thread.sleep(time);
        s.keyUp("h");
	}
	
	public long[] dir(String dir){
		//dirs: n , s, w, e , nw, ne, sw, se
		long coords[] = new long[2];
		switch (dir){	
	case  "n":coords[0]=960;coords[1]=1;break;
		case "s":coords[0]=960;coords[1]=1080;break;
		case "w":coords[0]=1;coords[1]=540;break;
		case "e":coords[0]=1920;coords[1]=540;break;
		case "nw":coords[0]=1;coords[1]=1;break;
		case "ne":coords[0]=1920;coords[1]=1;break;
		case "sw":coords[0]=1;coords[1]=1080;break;
		case "se":coords[0]=1920;coords[1]=1080;break;	
	}
		return coords;
	}
	public void safeExit() throws FindFailed{
		s.keyDown("1");
        s.keyUp("1");
        s.keyDown("4");
        s.keyUp("4");
        s.keyDown(Key.ESC);
        s.keyUp(Key.ESC);
        clickImage("imgs/leave.png");	      
	}
	public void exit() throws FindFailed{		
        s.keyDown(Key.ESC);
        s.keyUp(Key.ESC);
        clickImage("imgs/leave.png");
        return;
		
	}
	public void run() throws InterruptedException{		
		try{
	         //Press resumebutton
	         clickImage("imgs/resume_game_2.png");	         
	         
	         //Tryck waypoint
	         //clickImage("imgs/waypoint.png");
	         //s.wait("imgs/waypoint2.png", 12);
	         //s.click("imgs/waypoint2.png");
	         clickImage("imgs/waypoint2.png");
	         
	         //Teleport	        
	         clickImage("imgs/old_ruins.png");	         
	         Thread.sleep(3000);	         	       
	         
	         //Move (waypoint->door)
	         moveDir(6000, "nw");	         	         
	         moveDir(1000, "n");	         	         
	         moveDir(2000, "nw");	         	         
	         moveDir(4000, "w");	         	         
	         moveDir(1000, "n");	         	         
	         Thread.sleep(2000);
	         
	         //Titta om ingången är öppen	         
	         try{
	        	 //s.click("imgs/open_door.png");	
	        	 clickImage("imgs/open_door.png");
	         }
	         catch(FindFailed e){
	        	 //s.find("imgs/closed_door.png");
	        	 //ingången är stängd, starta om loop		         
		         safeExit();
		         return;  	 
	         }
	         
	         
	         //attackingposition	         
	         s.wait("imgs/cellar_entered.png",5);	              	        	 	         
	         s.click(new Location(100,850));
	         Thread.sleep(3000);
	         
	         //attack
	         s.rightClick(new Location(500,100));
	         Thread.sleep(1000);
	         s.rightClick(new Location(500,100));
	         Thread.sleep(1000);
	         s.rightClick(new Location(500,100));
	         Thread.sleep(1000);
	         s.rightClick(new Location(500,100));
	         Thread.sleep(1000);
	         s.rightClick(new Location(500,100));
	         
	         
	         //gather gold
	         s.click(new Location(500,100));
	         Thread.sleep(4000);
	         s.click(new Location(800,700));
	         Thread.sleep(1000);
	         s.click(new Location(1100,600));
	         Thread.sleep(1000);
	         s.click(new Location(1100,400));
	         //*/
	        //escape
	         Thread.sleep(1000);
	         exit();
	         return;
	         
	    }
	    catch(FindFailed e){
	            try {
					safeExit();
					
				} catch (FindFailed e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    }
	}
	
}
