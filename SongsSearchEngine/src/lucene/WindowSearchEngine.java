package lucene;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.lucene.document.Document;

import com.opencsv.exceptions.CsvException;

public class WindowSearchEngine {
	
	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	
	private static String inputQuery = "";
	
	private History historyFile;
	
	
	public WindowSearchEngine() throws IOException {
		initialize();

	}
	
	public void initialize() throws IOException {
		
		historyFile = new History();
		
		
		frame = new JFrame("Search Engine for Songs!");
		frame.setSize(1024,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setVisible(true);
		
		
		
		panel = new JPanel();
		panel.setBounds(150, 100, 500, 500);
		frame.getContentPane().add(panel);
		
		JLabel searchLabel = new JLabel("Type the searching key word ");
		searchLabel.setBounds(25, 40, 130, 25);
		panel.add(searchLabel);
		
		
		textField = new JTextField("");
		textField.setBounds(50, 50, 300, 50);
		textField.setColumns(20);
		panel.add(textField);
		

		JButton searchButton = new JButton("Search");
		panel.add(searchButton);
		

		searchButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				inputQuery = textField.getText().toString();
				
				try {
					historyFile.addQueryToHistory(inputQuery);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(inputQuery.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter some info");
				}
				else{
					try {
						Searcher searchQuery = new Searcher(inputQuery);
						try {
							ArrayList<Document> found = searchQuery.findAll(inputQuery);
							
							WindowForResult result = new WindowForResult(found, inputQuery);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (CsvException e) {
						e.printStackTrace();
					}
				}
			}
		});
				
		
		JButton searchByArtist = new JButton("Search by Artist");
		panel.add(searchByArtist); 
		
		
		searchByArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputQuery = textField.getText().toString();
				
				try {
					historyFile.addQueryToHistory(inputQuery);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(inputQuery.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter some info");
				}
				else{
					try {
						Searcher searchQuery = new Searcher(inputQuery);
						try {
							ArrayList<Document> found = searchQuery.findArtist(inputQuery);
							
							WindowForResult result = new WindowForResult(found, inputQuery);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (CsvException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		
		
		JButton searchByTitle = new JButton("Search by Title");
		panel.add(searchByTitle);
		
		searchByTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputQuery = textField.getText().toString();
				
				try {
					historyFile.addQueryToHistory(inputQuery);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(inputQuery.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter some info");
				}
				else{
					try {
						Searcher searchQuery = new Searcher(inputQuery);
						try {
							ArrayList<Document> found = searchQuery.findTitle(inputQuery);
							
							WindowForResult result = new WindowForResult(found, inputQuery);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (CsvException e) {
						e.printStackTrace();
					}

				}
			}
		});
		
		
		
		JButton searchByAlbum = new JButton("Search by Album");
		panel.add(searchByAlbum); 
		searchByAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputQuery = textField.getText().toString();
				
				try {
					historyFile.addQueryToHistory(inputQuery);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(inputQuery.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter some info");
				}
				else{
					try {
						Searcher searchQuery = new Searcher(inputQuery);
						try {
							ArrayList<Document> found = searchQuery.findAlbum(inputQuery);
							
							WindowForResult result = new WindowForResult(found, inputQuery);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (CsvException e) {
						e.printStackTrace();
					}

				}
			}
		});
		
		
		
		
		JButton searchByYear = new JButton("Search by Year");
		panel.add(searchByYear); 
		
		searchByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputQuery = textField.getText().toString();
				
				try {
					historyFile.addQueryToHistory(inputQuery);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(inputQuery.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter some info");
				}
				else{
					try {
						Searcher searchQuery = new Searcher(inputQuery);
						try {
							ArrayList<Document> found = searchQuery.findYear(inputQuery);
							
							WindowForResult result = new WindowForResult(found, inputQuery);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (CsvException e) {
						e.printStackTrace();
					}

				}
			}
		});
		
		
		
		
		JButton searchByLyric = new JButton("Search by Lyric");
		panel.add(searchByLyric); 
		searchByLyric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputQuery = textField.getText().toString();
				
				try {
					historyFile.addQueryToHistory(inputQuery);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(inputQuery.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter some info");
				}
				else{
					try {
						Searcher searchQuery = new Searcher(inputQuery);
						try {
							ArrayList<Document> found = searchQuery.findLyric(inputQuery);
							
							WindowForResult result = new WindowForResult(found, inputQuery);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (CsvException e) {
						e.printStackTrace();
					}

				}
			}
		});	
		
		
		// New panel for the suggestions from the history
		
		JPanel p = new JPanel();
				
		p.setBounds(200, 350, 500, 500);
		frame.getContentPane().add(p);
		
		
		ArrayList<String> mostCommons = historyFile.findMostCommon();

		
		JButton topQuery = new JButton("Some suggestions for you:");

		p.add(topQuery, new GridLayout(2,4));
		
		JTextArea txtArea = new JTextArea();
	
		p.add(txtArea, new GridLayout(0,2));
		
		
		ArrayList<JButton> button = new ArrayList<JButton>();
		
		for(int i = 0; i < mostCommons.size(); i++) {
			
			String s = mostCommons.get(i);
			JButton b = new JButton(mostCommons.get(i));
			button.add(b);
			p.add(button.get(i));
			
			
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inputQuery = s ;
					
					if(inputQuery.equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter some info");
					}
					else{
						try {
							Searcher searchQuery = new Searcher(inputQuery);
							try {
								ArrayList<Document> found = searchQuery.findAll(inputQuery);
								
								WindowForResult result = new WindowForResult(found, inputQuery);
							} catch (Exception e) {
								e.printStackTrace();
							}
						} catch (IOException e) {
							e.printStackTrace();
						} catch (CsvException e) {
							e.printStackTrace();
						}

					}
				}
			});		
		}
			
		topQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	
	public static void main(String[] args) throws IOException {
		WindowSearchEngine x = new WindowSearchEngine();

	}

}
