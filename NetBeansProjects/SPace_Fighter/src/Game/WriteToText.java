/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToText {

	int num;
	public WriteToText(int score) {
	
		this.num = score;
	}

	public void writeScore() throws IOException{
	File f1 = new File("Scoreboard.txt");
 
	try {
		if(!f1.exists()) {
	        f1.createNewFile();
	     }
		FileWriter fileWritter = new FileWriter(f1.getName(),true);
        BufferedWriter bw = new BufferedWriter(fileWritter);
        bw.write(num+System.lineSeparator());
        bw.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}	