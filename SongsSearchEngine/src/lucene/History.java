package lucene;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class History {
	

	public History() throws IOException {
	
	}
	
	
	public void addQueryToHistory(String inputQuery) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("History.txt", true));
		
		writer.newLine();
		writer.write(inputQuery);
		writer.close();	
	}
	

	
	public ArrayList<String> readHistory() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("History.txt"));
		
		ArrayList<String> allLines = new ArrayList<>(); 

		String line;
		while((line = reader.readLine()) != null) {
			allLines.add(line);

		}
		reader.close();
		return allLines;
	}
	
	
	public ArrayList<String> findMostCommon() throws IOException {
		
		ArrayList<String> allLines = new ArrayList<String>();
		
		allLines = readHistory();
		
		HashMap<String,Integer> countAppearance = new HashMap<>();
		
		for(String word : allLines) {
			
			String trimmedWord = word.trim();
			
			if( ! countAppearance.containsKey(trimmedWord)) {
				countAppearance.put(trimmedWord, 1);
			}
			
			else {
				int value = countAppearance.get(trimmedWord);
				value += 1;
				countAppearance.put(trimmedWord, value);
			}
		}
		
		ArrayList<String> mostCommon = new ArrayList<>();
		
		for ( Map.Entry<String,Integer> i : countAppearance.entrySet() ) {
			if (i.getValue() >= 5 ) {
	            mostCommon.add(i.getKey()) ;
	        }   
	    }
		return mostCommon;	
	}
	

}