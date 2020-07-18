package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedProcessFile {
	public static String proccessFile(BufferedReaderProcessor p) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("F://test.txt"))){
			return p.process(br);
		}
	}
	
	public static String proccessFile(BufferedReaderProcessor p,String filename) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			return p.process(br);
		}
	}
}
