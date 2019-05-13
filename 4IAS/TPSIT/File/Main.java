import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		
		System.out.println("Input file name: ");
		String input = console.nextLine();
		System.out.println("Output file name: ");
		String output = console.nextLine();
		
		try{
			FileReader reader = new FileReader(input);
			Scanner in = new Scanner(reader);
			FileWriter writer = new FileWriter(output, true);
			PrintWriter out = new PrintWriter(writer);
			while(in.hasNextLine()){
				String line = in.nextLine();
				out.println(line);
			}
			in.close();
			out.close();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
}