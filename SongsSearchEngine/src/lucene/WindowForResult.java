package lucene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


import org.apache.lucene.document.Document;


import java.awt.Component;
import java.awt.Font;

public class WindowForResult {
	
	private ArrayList<Document> foundDocuments;
	private JFrame frame;
	private JTable table;
	private JPanel panel;
	private String resultArray[][];
	private String inputQuery;
	
	public WindowForResult(ArrayList<Document> foundDocuments, String inputQuery) {
		this.foundDocuments = foundDocuments;
		this.resultArray = new String[foundDocuments.size()][5];
		this.inputQuery = inputQuery;
		
		initializeResultWindow();
	}
	
	
	public void initializeResultWindow() {
		
		frame = new JFrame();
		frame.setTitle("Results");
		frame.setSize(700,500);
		frame.setResizable(true);
		frame.setLayout(new GridLayout(2,1));
		
		frame.setVisible(false);
		
		
		panel = new JPanel(new BorderLayout(4,4));
		frame.getContentPane().add(panel);
		
		
		if( foundDocuments.size() != 0) {
			for( int i = 0;i < foundDocuments.size(); i++) {			
				resultArray[i][0] = foundDocuments.get(i).get("Artist");
				resultArray[i][1] = foundDocuments.get(i).get("Title");
				resultArray[i][2] = foundDocuments.get(i).get("Album");
				resultArray[i][3] = foundDocuments.get(i).get("Year");
				resultArray[i][4] = foundDocuments.get(i).get("Lyric");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No result");
		}

	
		// Create a custom cell renderer to highlight the inputQuery
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value != null && value.toString().toLowerCase().contains(inputQuery.toLowerCase())) {
                    component.setFont(component.getFont().deriveFont(Font.BOLD));
                    component.setForeground(Color.BLUE);
                } else {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                    component.setForeground(table.getForeground());
                }

                return component;
            }
        };


		String[] columnsName = { "Artist", "Title", "Album", "Year", "Lyric" };
		
		table = new JTable(new DefaultTableModel(resultArray, columnsName));

		table.setDefaultRenderer(Object.class, cellRenderer);
        table.setRowSelectionAllowed(false);

		
		final int rows = 11;
		
				
		JScrollPane scrollPane2 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
        scrollPane2.setPreferredSize(new Dimension(1000,table.getRowHeight()*rows+5));
		
		
	    table.setFocusable(false);
	    table.addMouseListener((MouseListener) new MouseAdapter() {
	    	 public void mouseClicked(MouseEvent me) {
	    		 if (me.getClickCount() == 1) {
	    			 JTable target = (JTable)me.getSource();
	    			 int row = target.getSelectedRow();
	    			 int column = target.getSelectedColumn();

	    			 JTextArea msg = new JTextArea((String) table.getValueAt(row, column));
	    			 msg.setLineWrap(true);
	    			 msg.setWrapStyleWord(true);

	    			 JScrollPane scrollPane = new JScrollPane(msg);
	    			 scrollPane.setPreferredSize(new Dimension(1000,table.getRowHeight()*rows+5));

	    			 JOptionPane.showMessageDialog(null, scrollPane);
	    			 	 
	            }
	         }
	     });
	
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
        scrollPane.setPreferredSize(new Dimension(1000,table.getRowHeight()*rows+5));

        
        JButton sortArtist = new JButton("Sort by Artist");
        sortArtist.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();
                int columnIndexToSort = 0;
                sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();
            }
            	
         } );
        
        
        JButton sortTitle = new JButton("Sort by Title");
        sortTitle.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();
                int columnIndexToSort = 1;
                sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();
            }
            	
         } );
        
        
        
        JButton sortAlbum = new JButton("Sort by Album");
        sortAlbum.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();
                int columnIndexToSort = 2;
                sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();
            }
            	
         } );
        
        
        
        JButton sortYear = new JButton("Sort by Year");
        sortYear.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();
                int columnIndexToSort = 3;
                sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();
            }
            	
         } );
                
        
        JPanel newPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton next = new JButton("Next page");
        next.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                int height = table.getRowHeight()*(rows-1);
                JScrollBar bar = scrollPane.getVerticalScrollBar();
                bar.setValue( bar.getValue()+height );
            }
        } );
		
		
        JButton previous = new JButton("Previous page");
        previous.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                int height = table.getRowHeight()*(rows-1);
                JScrollBar bar = scrollPane.getVerticalScrollBar();
                bar.setValue( bar.getValue()-height );
            }
        } );
		
		
        newPanel.add(previous);
        newPanel.add(next);
        
        
        newPanel.add(sortArtist);
        newPanel.add(sortTitle);
        newPanel.add(sortAlbum);
        newPanel.add(sortYear);
        
		
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(newPanel, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(null, panel);
		
        table.setEnabled(true);
        scrollPane.setViewportView(table);
 
        panel.add(scrollPane);
	
	}

}
