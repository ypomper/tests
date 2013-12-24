package randomtests;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jonathanpomper
 */
public class SetPractice {
    public static void setPracticeRun(){
        //the JFrame
        JFrame jf = new JFrame();
        jf.setSize(300, 300);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //the 2 JList's, and added to jf
        String [] listData1 = {"a","b","c","d"};
        String [] listData2 = {"e","f","g","h"};
        String [] listData3 = new String[4];
        
        DefaultListModel listModelBob = new DefaultListModel();
        listModelBob.addElement("bob");
        
        JList list3 = new JList();
        
        list3.setModel(listModelBob);
        DefaultListModel listModel1 = new DefaultListModel();
        DefaultListModel listModel2 = new DefaultListModel();
        for(int index=0;index<listData1.length;index++){
            listModel1.add(index, listData1[index]);
            listModel2.add(index, listData2[index]);
        }
        JList list1 = new JList();
        JList list2 = new JList();
        list1.setModel(listModel1);
        list2.setModel(listModel2);
        //trying to play with sizes...
        //list1.setSize(50, 100);
        //System.out.println(list1.getSize());
        
        list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jf.add(list1);
        list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jf.add(list2);
        jf.add(list3);
        
        jf.setLayout(new FlowLayout());
        jf.setVisible(true);
        
        //DnD
        list1.setDragEnabled(true);
        list2.setDragEnabled(true);
        list1.setDropMode(DropMode.ON);
        list2.setDropMode(DropMode.ON);
        list1.setTransferHandler(new ListTransferHandler());
        list2.setTransferHandler(new ListTransferHandler());
        
        Set set = new TreeSet();
        set.add("1");
        set.add("1");
        set.add("2");
        Iterator iter = set.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }   
    }
    
    public static void transfer(TreeSet origin, TreeSet dest) //array of objects
    {
    
    }
}
