package lucene;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class Indexer {
	
	private  IndexWriter writer;
	private  String dataFile = "data.csv";
	private  String indexPath = "Index";
	private  Analyzer analyzer;
	private  Directory directory;
	
	
	public Indexer() throws IOException, CsvException {
		analyzer = new StandardAnalyzer();
		directory = FSDirectory.open(Paths.get(indexPath) );
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		writer = new IndexWriter(directory, config);
		
		createIndex();
		
		writer.close();
	}
	
	
	// Method responsible for reading the csv file
	public  List<String[]> readData() throws IOException {
		List<String[]> data = new ArrayList<>();
		CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
		try(CSVReader reader = new CSVReaderBuilder(new FileReader(dataFile)).withCSVParser(parser).withSkipLines(1).build())																	
		{
			data = reader.readAll();
		}
		return data;
	}
	
	
	// Method responsible for creating an index, if it doesn't exist
	public void createIndex() throws IOException, CsvException 
	{
		File dir = new File(Paths.get(indexPath).toString());
		String[] files = dir.list();
		
		List<String[]> data = readData();
		
		if(dir.isDirectory() && files.length == 1) {

			for(int i = 0; i < data.size(); i++) {
				String[] row = data.get(i);
				if ( row.length >= 6) {
					Document doc = createDocument(row);
					writer.addDocument(doc);
				}
				else {
					continue;
				}
			}
		}
	}
	
	
	// This method is responsible for creating a document with the following fields
	public Document createDocument(String[] row) {
		Document document = new Document();
	    document.add(new TextField("id", row[0] , Field.Store.YES));
	    document.add(new TextField("Artist", row[1] , Field.Store.YES));
	    document.add(new TextField("Title", row[2] , Field.Store.YES));
	    document.add(new TextField("Album", row[3] , Field.Store.YES));
	    document.add(new TextField("Year", row[4] , Field.Store.YES));
	    document.add(new TextField("Lyric", row[5] , Field.Store.YES));
	    return document;
		
	}
	
	
	public static void main(String[] args) throws IOException, CsvException {
		Indexer in = new Indexer();
	}
	

}
