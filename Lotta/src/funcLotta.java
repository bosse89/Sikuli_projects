import java.util.ArrayList;
import java.util.Iterator;


import org.sikuli.script.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.regex.Pattern;
public class funcLotta {


	public Screen s; 
	
	public funcLotta(){		
		s = new Screen();
	}

	public void runLotta2()throws FindFailed, InterruptedException{
		String str;				
		 		
		StringSelection strSel;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		for(int year=1998;2013>=year ;year++ ) {
			for(int week=1;53>=week ;week++ ) {
				
				//Select page
				s.click(new Location(850,40));			
				str="svenskaspel.se/?pageid=/resultat/lottoonsdag&selectWeekYear="+year+"&selectWeekWeek="+week; 	
				//str="svenskaspel.se/?pageid=/resultat/lottolordag&selectWeekYear="+year+"&selectWeekWeek="+week; 	
				strSel = new StringSelection(str);				
				clipboard.setContents(strSel, null);									
				s.keyDown(Key.CTRL);
				s.keyDown("v");							
				s.keyUp(Key.CTRL);
				s.keyUp("v");	
				s.keyDown(Key.ENTER);
				s.keyUp(Key.ENTER);
				
				//Save page
				Thread.sleep(2000);
				s.keyDown(Key.CTRL);
				s.keyDown("s");
				s.keyUp(Key.CTRL);
				s.keyUp("s");
				Thread.sleep(300);		
				s.type("s-"+Integer.toString(year)+"-"+Integer.toString(week));
				s.keyDown(Key.ENTER);
				s.keyUp(Key.ENTER);
			}
			
		}
		
		//https://svenskaspel.se/?pageid=/resultat/lottoonsdag&selectWeekYear=2003&selectWeekWeek=40
	}
	public void runLotta() throws FindFailed, InterruptedException{
		//Loop years
		//Go to position for year
		//Press 1 9 9 2 , next 1 9 9 3 etc , 1992-2012 for starters
		
		//Loop weeks
		//Press down for few secs,toscoll down
		 
		
		for(int year=2004;2014>=year ;year++ ) {
			for(int week=40;52>=week ;week++ ) {
				
				down(); 
				
				Thread.sleep(2000);
				s.click(new Location(850,790));
				pressKeys(week);
				Thread.sleep(2000);
				s.keyDown(Key.ENTER);
				s.keyUp(Key.ENTER);
				Thread.sleep(2000);
				s.keyDown(Key.TAB);
				s.keyUp(Key.TAB);
				Thread.sleep(2000);
				s.keyDown(Key.ENTER);
				s.keyUp(Key.ENTER);
				
				Thread.sleep(2000);
				s.keyDown(Key.CTRL);
				s.keyDown("s");
				s.keyUp(Key.CTRL);
				s.keyUp("s");
				Thread.sleep(2000);
			
				s.type("o-"+Integer.toString(year-1)+"-"+Integer.toString(week));
				s.keyDown(Key.ENTER);
				s.keyUp(Key.ENTER);
				
				
			}
			down(); 			
			Thread.sleep(2000);
			s.click(new Location(850,770));
			pressKeys(year);
			Thread.sleep(2000);
			s.keyDown(Key.ENTER);
			s.keyUp(Key.ENTER);
			Thread.sleep(2000);
			s.keyDown(Key.TAB);
			s.keyUp(Key.TAB);
			s.keyDown(Key.TAB);
			s.keyUp(Key.TAB);
			Thread.sleep(2000);
			s.keyDown(Key.ENTER);
			s.keyUp(Key.ENTER);
		}
		//s.keyDown(Key.NUM1);
		
        //s.keyUp(Key.NUM1);
		//press week button 1,2...1 0, 1 1, 1 2 etc 1-52
		
		//Press enter, tap, enter
		
		//now press ctrl+s
		//write 1992-1 , or something
		//Press enter
		//Done.. next week ready
		
		
		
		
	}
	public void pressKeys(int in){//in comes the whole numer 1992
		String str=Integer.toString(in);
		int ke;//represents 1, and then 9 9 2 
		for(int i=0;str.length()>i ;i++ ) {		  
			 s.keyDown(str.substring(i,i+1));
			 s.keyUp(str.substring(i,i+1));
			 System.out.print(str.substring(i,i+1));
		}
		
	}
	public String numToKey(String a){
		
		switch (a){
		case "1": return Key.NUM1;
		case "2": return Key.NUM2;
		case "3": return Key.NUM3;
		case "4": return Key.NUM4;
		case "5": return Key.NUM5;
		case "6": return Key.NUM6;
		case "7": return Key.NUM7;
		case "8": return Key.NUM8;
		case "9": return Key.NUM9;
		case "0": return Key.NUM0;
		
		
		}
		
		return Key.NUM1;
	}
	public void down() throws InterruptedException{
		Thread.sleep(500);
		s.keyDown(Key.DOWN);
		 s.keyUp(Key.DOWN);
		 Thread.sleep(500);
		 s.keyDown(Key.DOWN);
		 s.keyUp(Key.DOWN);
		 Thread.sleep(500);
		 s.keyDown(Key.DOWN);
		 s.keyUp(Key.DOWN);
		 Thread.sleep(500);
		 s.keyDown(Key.DOWN);
		 s.keyUp(Key.DOWN);
		 Thread.sleep(500);
		 s.keyDown(Key.DOWN);
		 s.keyUp(Key.DOWN);
		 Thread.sleep(500);
		 s.keyDown(Key.DOWN);
		 s.keyUp(Key.DOWN);
		 Thread.sleep(500);
		 s.keyDown(Key.DOWN);
		 s.keyUp(Key.DOWN);
		 Thread.sleep(500);
	}
	
	public void readFiles() throws IOException{
		File folder = new File("import2");
		File[] listOfFiles = folder.listFiles();
		BufferedReader br;
		StringBuilder sb;
        String line;
        String sub;
        int[] intlist;
        ArrayList<int[]> dataList =new ArrayList();
        ArrayList<int[]> data_komb_4_35 =new ArrayList();
        ArrayList<Integer> dataIntList =new ArrayList();
        int[] occur = new int[40];
        for (int i = 0; i < occur.length; i++) {
        	occur[i]=0;
        }
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        //System.out.println("File " + listOfFiles[i].getName());
		        br= new BufferedReader(new FileReader( "import2/" +  (listOfFiles[i].getName())) );
		        sb= new StringBuilder();
		        
		        line = br.readLine();
		        while (line != null) {
		        	if(line.length()>=9){		        			
		        		if(line.substring(0,9).equals("Rätt rad:")){
			        		//System.out.println(line);
			        		//System.out.println(line.substring(10));
			        		sub=line.substring(11);
			        		//sub="  [] ";
			        		//Pattern pattern = Pattern.compile(".xx.");
			       	        //Matcher matcher = pattern.matcher("MxxY");
			        		//String[] alist = sub.split("(?i)(  )(.+?)");
			        		  String[] alist = sub.split("  ");
			        		  intlist = new int[7];
			        		int r=0;
			        		  for (String strel : alist) {
			        			//System.out.println((strel));
			        			int intel=  Integer.parseInt(strel);
			        			  //System.out.print(intel+ "  ");
			        			intlist[r]=intel;
			        			dataIntList.add(intel);			        						        						        			
			        			occur[intel-1]++;
					        	r++;
			        		}
			        		  //System.out.println("");
			        		dataList.add(intlist);			        		
			        		//System.out.println(sub.split("(?i)(  )(.+?)(  )"));	 
		 			        // bad regular expression
			       	        //pattern = Pattern.compile("*xx*");
			        		
			        		
			        	}
		        	}
		        	
		        	//sb.append(line);
		            //sb.append('\n');
		            
		        	line = br.readLine();
		        }
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		int sum=0;
		for (int i = 0; i < 35; i++) {
			System.out.println(i + ":" +(i+1)+": "+occur[i]);
			sum=sum+occur[i];
		}
		System.out.println(sum/35);
		System.out.println(dataList.size());
		
		int[] tmp = dataList.get(0);
		int[] tmp2;
		int ad=0;
		for (int b = 0; b < dataList.size(); b++) {
			//System.out.println("index: "+b);
			tmp = dataList.get(b);
			for (int i = 0; i < dataList.size(); i++) {
				if(b!=i){
					tmp2=dataList.get(i);
					for (int r = 0; r < 7; r++) {
					
						if (tmp[r]==tmp2[r]){
							ad++;
						}
					}
				
				if(b!=i){
					if (ad==7){
						System.out.println("index: "+b);
						for (int intel : tmp) {
							System.out.print(intel+ "  ");
						}
						System.out.println("");
					}
					ad=0;
				}
				}
			}
		}
		System.out.println("");
		System.out.println("Custom search:");
		System.out.println("");
		//tmp = new int[] {1,2,3,4,5,6,7};
		//tmp = new int[] {1,4,8,9,11,13,19}; //lowest occurance
		/*
		tmp = new int[] {5,6,10,11,12,17,18}; //internet dude
		//tmp = new int[] {13,15,18,19,20,26,34}; //random row, to check
		for (int i = 0; i < dataList.size(); i++) {
			
				tmp2=dataList.get(i);
				for (int r = 0; r < 7; r++) {
				
					if (tmp[r]==tmp2[r]){
						ad++;
					}
				}
			
			
				if (ad==7){
					System.out.println("index: "+i);
					for (int intel : tmp) {
						System.out.print(intel+ "  ");
					}
					System.out.println("");
				}
				ad=0;
			
			
		}
		
		*/
		//tmp = new int[] {5,6,10,11}; //analyse row
		
		tmp = new int[] {3,13,22,8,1};
		//tmp = new int[] {1,2,3,4,5,6,7};
		//tmp = new int[] {1,4,8,9,11,13,19}; //lowest occurance
		//tmp = new int[] {13,15,18,19,20,26,34}; //random row, to check
		for (int i = 0; i < dataList.size(); i++) {
			
			tmp2=dataList.get(i); //current row
			for (int r = 0; r < 7; r++) {//loop though all elements of the current row
				
				for (int v = 0; v < tmp.length; v++) { //and for each element in analyse row , see if it exists in current row
					if (tmp[v]==tmp2[r]){
						ad++;
					}
				}
			}
		
		
			if (ad==tmp.length){//all elements in analyse row exist in current row
				System.out.println("index: "+i);
				for (int intel : tmp) {
					System.out.print(intel+ "  ");
				}
				System.out.println("");
			}
			if (ad==5){//all elements in analyse row exist in current row
				System.out.println("<5 index: "+i+ " matched  "+ad);
				for (int intel : tmp) {
					System.out.print(intel+ "  ");
				}
				System.out.println("");
			}
			ad=0;
		}
		System.out.println("Custom search done.");
		//Read a list of general combinations
		int numel=7; 
		int numels=8;
		br= new BufferedReader(new FileReader( "data_komb_" + numels+"_35.txt"));
		 
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 int totalMatch=0;//number of times that all combinations where matched with historical data
		 int localMatch=0;//number of times that a combination was matched with historical data
		 int numLows=0; //number of kombinatinos that was not matched in historydata
		 String lows="";
		 String highs="";
	     sb= new StringBuilder();
	     int intel=0;
	     int bai=0;
	     line = br.readLine();
	     System.out.println("1Starting general analysis...");
	     while (line != null) {
	    	
	    	 
	    	 String[] alist = line.split("-");
   		  	intlist = new int[numel];
   		  	int r=0;
   		  for (String strel : alist) {
   			intel=  Integer.parseInt(strel);
   			  System.out.print(intel+ "  ");
   			intlist[r]=intel;
   			//dataIntList.add(intel);			        						        						        			
   			occur[intel-1]++;
	        	r++;
   		  }
   		  bai++;
   		 //System.out.println(bai);
   		 
   		  //************************
   		//System.out.println("");
   		//data_komb_4_35.add(intlist);
   		  tmp=intlist;
   		for (int i = 0; i < dataList.size(); i++) {
			
			tmp2=dataList.get(i); //current row
			for (int rr = 0; rr < 7; rr++) {//loop though all elements of the current row
				
				for (int v = 0; v < tmp.length; v++) { //and for each element in analyse row , see if it exists in current row
					if (tmp[v]==tmp2[rr]){
						ad++;
					}
				}
			}
			System.out.println("Antal matchade element "+ad);
			System.out.print("index: "+i+"  ");
			if (ad==tmp.length){//all elements in analyse row exist in current row
				localMatch++;
				totalMatch++;
				/*
				System.out.print("index: "+i+"  ");
				for (int intel : tmp) {
					System.out.print(intel+ "  ");
				}
				System.out.print(" _komp_ ");
				for (int intel : tmp2) {
					System.out.print(intel+ "  ");
				}
				System.out.println("");					
				 */
			}
			
			ad=0;
   		}//*****************
   		if(localMatch==0){
   			lows=lows+ "\n"+line +" matched " + localMatch+ " times.";
   			numLows++;
   		}
   		/*
   		if(localMatch<9){
   			lows=lows+ "\n"+line +" matched " + localMatch+ " times.";
   			numLows++;
   		}
   		*/
   		line = br.readLine();//new local line
   		localMatch=0;//reset
   		/*if(bai==1973463){
   			line=null;
   		}
   		*/
   		
   		
	     }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	     System.out.println(lows);
	     System.out.println(numLows);
	     System.out.println("1General Analysis done.");
	     System.out.println(totalMatch+" matches");
	     
	     System.out.println("Starting general analysis...");
	     //For each of the general kombination data_komb_4_35, we shall try to find it in the occured 7digit kombinations dataList
	     for (int b = 0; b < data_komb_4_35.size(); b++) {
	    	 tmp = data_komb_4_35.get(b);
	    	 for (int i = 0; i < dataList.size(); i++) {
					
					tmp2=dataList.get(i); //current row
					for (int r = 0; r < 7; r++) {//loop though all elements of the current row
						
						for (int v = 0; v < numel; v++) { //and for each element in analyse row , see if it exists in current row
							if (tmp[v]==tmp2[r]){
								ad++;
							}
						}
					}
					//System.out.println(ad);
					
					if (ad==numel){//all elements in analyse row exist in current row
						
						totalMatch++;
						/*
						System.out.print("index: "+i+"  ");
						for (int intel : tmp) {
							System.out.print(intel+ "  ");
						}
						System.out.print(" _komp_ ");
						for (int intel : tmp2) {
							System.out.print(intel+ "  ");
						}
						System.out.println("");					
						 */
					}
					
					ad=0;
			}
	     }
	     System.out.println("General Analysis done.");
	     System.out.println(totalMatch+" matches");
	     
	}//end of method
	public void analyseKomb(){
		
	}
}
