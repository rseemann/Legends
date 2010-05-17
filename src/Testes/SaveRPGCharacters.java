package Testes;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveRPGCharacters {
	
	
	public static void main(String[] args) throws IOException {
		FileOutputStream fileStream = new FileOutputStream("RPGCharacters.ser");
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		
		
		os.writeObject(RPGChar1);
		
	}
	
	
	
}
