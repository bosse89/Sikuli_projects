import java.io.File;

import net.sourceforge.tess4j.*;
public class testmain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File imageFile = new File("nums.jpg");
        
		//Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
		
		 Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
		 instance.setTessVariable("tessedit_char_whitelist", "1234567890");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
		
	}

}
