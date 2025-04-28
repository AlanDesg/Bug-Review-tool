import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class tabledata {
    public static void main(String args[]){
        System.out.println("=============Java GUI Swing Table=================");


        JFrame frame=new JFrame("Java Swing Table");
        frame.setSize(2160,720);


        //Panel Code
        JPanel jPanel=new JPanel();
        BoxLayout verticalLayout=new BoxLayout(jPanel,BoxLayout.Y_AXIS);
        jPanel.setLayout(verticalLayout);
        frame.add(jPanel);



       


        JLabel csv_data_label=new JLabel("CSV Data Table");
        csv_data_label.setAlignmentX(JLabel.CENTER);
        csv_data_label.setBackground(Color.BLACK);
        csv_data_label.setForeground(Color.WHITE);
        csv_data_label.setOpaque(true);
        EmptyBorder emptyBorder3=new EmptyBorder(20,20,20,20);
        csv_data_label.setBorder(emptyBorder3);
        jPanel.add(csv_data_label);

        //Parsing CSV Data
        File csv_file=new File("C:\\Users\\alank\\Downloads\\bug.csv");
        DefaultTableModel csv_data=new DefaultTableModel();

        try{

            int start=0;
            InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(csv_file));
            CSVParser csvParser= CSVFormat.DEFAULT.parse(inputStreamReader);
            for(CSVRecord csvRecord:csvParser){
                if(start==0){
                    start=1;
                    csv_data.addColumn(csvRecord.get(0));
                    csv_data.addColumn(csvRecord.get(1));
                    csv_data.addColumn(csvRecord.get(2));
                    csv_data.addColumn(csvRecord.get(3));
                    csv_data.addColumn(csvRecord.get(4));
                    csv_data.addColumn(csvRecord.get(5));
                    csv_data.addColumn(csvRecord.get(6));
                }
                else{
                    Vector row=new Vector();
                    row.add(csvRecord.get(0));
                    row.add(csvRecord.get(1));
                    row.add(csvRecord.get(2));
                    row.add(csvRecord.get(3));
                    row.add(csvRecord.get(4));
                    row.add(csvRecord.get(5));
                    row.add(csvRecord.get(6));

                    csv_data.addRow(row);
                }
            }

        }
        catch (Exception e){
            System.out.println("Error in Parsing CSV File");
        }

        JTable jTable1=new JTable();
        jTable1.setModel(csv_data);
        JScrollPane jScrollPane2=new JScrollPane();
        jScrollPane2.getViewport().add(jTable1);

        jPanel.add(jScrollPane2);

        //Table Listener
        jTable1.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tableModelEvent) {
                System.out.println("Row : "+jTable1.getSelectedRow()+" | Column : "+jTable1.getSelectedColumn()+" | Current Value : "+jTable1.getValueAt(jTable1.getSelectedRow(),jTable1.getSelectedColumn()).toString());
            }
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}