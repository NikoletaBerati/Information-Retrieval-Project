package lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.StoredFields;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.opencsv.exceptions.CsvException;

public class Searcher {
	
	private static  IndexReader reader;
	private static  IndexSearcher searcher;
	private  IndexWriter writer;
	private String index = "Index";
	private Analyzer analyzer;
	private Directory directory;
	private String inputQuery;

	
	public Searcher(String inputQuery) throws IOException, CsvException {
		analyzer = new StandardAnalyzer();
		directory = FSDirectory.open(Paths.get(index));
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		writer = new IndexWriter(directory, config);
				
		searcher = createSearcher();
		
		this.inputQuery = inputQuery;
		
		writer.close();
	}
	
	
	public IndexSearcher createSearcher() throws IOException {
		Directory dir = FSDirectory.open(Paths.get(index));
		reader = DirectoryReader.open(dir);
		searcher = new IndexSearcher(reader);		
		return searcher;
	}
	
	
	
	private TopDocs searchByArtist(String name, IndexSearcher searcher) throws Exception{
		QueryParser qp = new QueryParser("Artist", new StandardAnalyzer());
		Query query = qp.parse(name);
		TopDocs hits = searcher.search(query, 200);
		
		return hits;
	}

	private TopDocs searchByTitle(String name, IndexSearcher searcher) throws Exception{
		QueryParser qp = new QueryParser("Title", new StandardAnalyzer());
		Query query = qp.parse(name);
		TopDocs hits = searcher.search(query, 200);
		return hits;
	}
	
	private TopDocs searchByAlbum(String name, IndexSearcher searcher) throws Exception{
		QueryParser qp = new QueryParser("Album", new StandardAnalyzer());
		Query query = qp.parse(name);
		TopDocs hits = searcher.search(query, 200);
		return hits;
	}
	
	private TopDocs searchByYear(String name, IndexSearcher searcher) throws Exception{
		QueryParser qp = new QueryParser("Year", new StandardAnalyzer());
		Query query = qp.parse(name);
		TopDocs hits = searcher.search(query, 200);
		return hits;
	}
	
	private TopDocs searchByLyric(String name, IndexSearcher searcher) throws Exception{
		QueryParser qp = new QueryParser("Lyric", new StandardAnalyzer());
		Query query = qp.parse(name);
		TopDocs hits = searcher.search(query, 200);
		return hits;
	}
	
	
	public TopDocs searchByAll(String name, IndexSearcher searcher) throws ParseException, IOException 
	{
		String[] fields = {"Artist", "Title", "Album", "Year", "Lyric" };
		MultiFieldQueryParser qp = new MultiFieldQueryParser(fields, analyzer);
		Query query= qp.parse(name);
		TopDocs hits = searcher.search(query, 100, Sort.RELEVANCE);
        return hits;
	}
	
			
	
	public ArrayList<Document> findArtist(String field) throws Exception {
		TopDocs foundDocs = searchByArtist(field, searcher);
		ArrayList<Document> documents = new ArrayList<>();
	
		StoredFields storedFields = searcher.storedFields();
		for (ScoreDoc sd : foundDocs.scoreDocs){
			Document docum = storedFields.document(sd.doc);
			documents.add(docum);
		}
		return documents;
	}
	
	
	public ArrayList<Document> findAlbum(String field) throws Exception {
		TopDocs foundDocs = searchByAlbum(field, searcher);
		ArrayList<Document> documents = new ArrayList<>();
			
		StoredFields storedFields = searcher.storedFields();
		for (ScoreDoc sd : foundDocs.scoreDocs){
			Document docum = storedFields.document(sd.doc);
			documents.add(docum);
		}
		return documents;
	}
	
	
	public ArrayList<Document> findTitle(String field) throws Exception {
		TopDocs foundDocs = searchByTitle(field, searcher);
		ArrayList<Document> documents = new ArrayList<>();

		StoredFields storedFields = searcher.storedFields();
		for (ScoreDoc sd : foundDocs.scoreDocs){
			Document docum = storedFields.document(sd.doc);
			documents.add(docum);
		}
		return documents;
	}
	
	
	public ArrayList<Document> findYear(String field) throws Exception {
		TopDocs foundDocs = searchByYear(field, searcher);
		ArrayList<Document> documents = new ArrayList<>();
		
		
		StoredFields storedFields = searcher.storedFields();
		for (ScoreDoc sd : foundDocs.scoreDocs){
			Document docum = storedFields.document(sd.doc);
			documents.add(docum);
		}
		return documents;
	}
	
	
	public ArrayList<Document> findLyric(String field) throws Exception {
		TopDocs foundDocs = searchByLyric(field, searcher);
		ArrayList<Document> documents = new ArrayList<>();
		
		StoredFields storedFields = searcher.storedFields();
		for (ScoreDoc sd : foundDocs.scoreDocs){
			Document docum = storedFields.document(sd.doc);
			documents.add(docum);
		}
		return documents;
	}
	
	
	public ArrayList<Document> findAll(String field) throws Exception {
		TopDocs foundDocs = searchByAll(field, searcher);
		ArrayList<Document> documents = new ArrayList<>();
		
		StoredFields storedFields = searcher.storedFields();
		for (ScoreDoc sd : foundDocs.scoreDocs){
			Document docum = storedFields.document(sd.doc);
			documents.add(docum);
		}
		return documents;
	}

}
