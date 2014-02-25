import org.sikuli.script.*;
public class sik_main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws FindFailed 
	 */
	public static void main(String[] args) throws InterruptedException, FindFailed {
		Screen s = new Screen();
		 //Inne i spelet				       
		diablo3bot d3b = new diablo3bot();
		d3b.start();
	}
	public static void run(Screen s) throws InterruptedException{
		/*
			try{

		         //s.click("imgs/visa_skrivbord.png");
		         //s.wait(3); 
		         //s.doubleClick("imgs/diablo3_skrivbord.png");
		         //s.wait("imgs/redo_play_knapp.png", 10000000);
		         
		         
		         ///*
		         s.wait("imgs/resume_game_2.png", 10000000);
		         s.click("imgs/resume_game_2.png");
		         
		         //Inne i spelet
		         s.wait("imgs/game_on.png",10000000);
		         s.click(new Location(600,400));
		         s.wait("imgs/old_ruins.png",10000000);
		         s.click("imgs/old_ruins.png");
		         Thread.sleep(1000);
		         
		       
		         
		         s.hover(new Location(15,1));
		         s.keyDown("h");
		         Thread.sleep(20000);
		         s.keyUp("h");
		         
		         
		         
		         //Titta om ingången är öppen
		         
		         try{
		         s.find("imgs/closed_door.png");
		        	 //ingången är stängd, starta om loop
		         Thread.sleep(1000);
		         s.keyDown(Key.NUM1);
		         s.keyUp(Key.NUM1);
		         s.keyDown(Key.NUM3);
		         s.keyUp(Key.NUM3);
		         s.keyDown(Key.ESC);
		         s.keyUp(Key.ESC);
		         s.click("imgs/leave.png");
		         return;
		         }
		         catch(FindFailed e){
		        	 s.click(new Location(300,600));
		        	 
		         }
		         
		         
		         //attackingposition
		         s.wait("imgs/cellar_entered.png",10000000);
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
		         //
		        //escape
		         Thread.sleep(1000);
		         s.keyDown(Key.ESC);
		         s.keyUp(Key.ESC);
		         s.click("imgs/leave.png");
		         
		    }
		    catch(FindFailed e){
		            e.printStackTrace();
		    }
		    
		 */
	}

}
