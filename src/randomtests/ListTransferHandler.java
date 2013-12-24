package randomtests;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

/**
 *
 * @author jonathanpomper
 */
public class ListTransferHandler extends TransferHandler{

        public boolean canImport(TransferHandler.TransferSupport info){
            //check if it is a string
            if(!info.isDataFlavorSupported(DataFlavor.stringFlavor)){
                return false;
            }
            return true;
        }
        
        protected Transferable createTransferable(JComponent c){
            JList list = (JList)c;
            String name = (String)list.getSelectedValue();
            return new StringSelection(name);
        }
        
        public int getSourceActions(JComponent c) {
            return TransferHandler.MOVE;
        }
        public boolean importData(TransferHandler.TransferSupport info) {
            if (!info.isDrop()) {
                return false;
            }
            JList list = (JList)info.getComponent();
            DefaultListModel listModel = (DefaultListModel)list.getModel();
            JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
            int index = dl.getIndex();
            boolean insert = dl.isInsert();
            // Get the string that is being dropped.
            Transferable t = info.getTransferable();
            String data;
            try {
                data = (String)t.getTransferData(DataFlavor.stringFlavor);
            } 
            catch (Exception e) { return false; }
insert = true;
            if (insert) {
                listModel.add(index++, data);
            } else {
                // If the items go beyond the end of the current
                // list, add them in.
                System.out.println("1");
                if (index < listModel.getSize()) {
                    listModel.set(index++, data);
                } else {
                System.out.println("2");
                    listModel.add(index++, data);
                }
            }
            return true;
        }
        /**
         * Remove the items moved from the list.
         */
        protected void exportDone(JComponent c, Transferable data, int action) {
            JList source = (JList)c;
            System.out.println(source.getModel());
            DefaultListModel listModel  = (DefaultListModel)source.getModel();
            if(action == TransferHandler.MOVE)
            {
                listModel.remove(source.getSelectedIndex());
            }
        }        
}
