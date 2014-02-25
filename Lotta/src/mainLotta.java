import java.io.IOException;

import org.sikuli.script.*;
public class mainLotta {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws FindFailed 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, FindFailed, IOException {
		// TODO Auto-generated method stub
		Screen s = new Screen();
		//Goal is to save the text file of the file, so that we later on can work with them
		Thread.sleep(5000);
		
		funcLotta lotta = new funcLotta();
		
		//lotta.runLotta2();
		
		
		lotta.readFiles();
		
		//Loop years
		//Go to position for year
		//Press 1 9 9 2 , next 1 9 9 3 etc , 1992-2012 for starters
		
		//Loop weeks
		//Press down for few secs,toscoll down
		 
         
        
        
		
		//Go to pos of weeks
		//press week button 1,2...1 0, 1 1, 1 2 etc 1-52
		
		//Press enter, tap, enter
		
		//now press ctrl+s
		//write 1992-1 , or something
		//Press enter
		//Done.. next week ready
		
	}
	
}
