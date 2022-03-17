package fis.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) throws IOException {
		
		File inputFile = new File("src/fis/java/topic01/ex3/input.inp");
		FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);
        
        File outputFile = new File("src/fis/java/topic01/ex3/output.out");
        FileWriter fw = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(fw);

        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            String[] parts = line.split(" ");
    		AnTiemFamily anTiemFamily = new AnTiemFamily(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]);
    		bw.write(line + " P = " +anTiemFamily.caculatePOfSurvival());
    		bw.newLine();
            line = br.readLine();
        }
        br.close();
        fr.close();
        bw.close();

	}
}
