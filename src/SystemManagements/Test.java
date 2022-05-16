package SystemManagements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test {
	public static void main(String[] args) throws IOException {

		Writer os = new FileWriter("data/test.txt"); //덮어쓰기
		BufferedWriter bos = new BufferedWriter(os);
		
	}

}
