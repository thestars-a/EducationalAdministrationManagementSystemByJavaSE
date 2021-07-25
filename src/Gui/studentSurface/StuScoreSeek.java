/*
 * Created by JFormDesigner on Sat Mar 20 12:38:49 CST 2021
 */

package Gui.studentSurface;

import Gui.teacherSurface.TecView;
import Service.Student.StudentSurfaceService;
import Service.Teacher.TecSurfaceService;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author s
 */
public class StuScoreSeek extends JFrame {


    public void UI_init() {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        table_init();
    }

    public void table_init()
    {
        table1.setModel(new ScoreSeek());
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table1.setDefaultRenderer(Object.class, renderer);
    }


    public StuScoreSeek() {
        initComponents();
    }

    private void returnBtActionPerformed(ActionEvent e) {
        new StuView().UI_Init();
        dispose();
    }
    public static class ScoreSeek extends AbstractTableModel {

        private Object[] columnNames = {"学号", "姓名","课程","成绩"};
        private Object[][] rowData = new StudentSurfaceService().student_score_seek_Dao(StuView.stu_id);

        @Override
        public int getRowCount() {
            return rowData.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column].toString();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rowData[rowIndex][columnIndex];
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            rowData[rowIndex][columnIndex] = aValue;
            this.fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        returnBt = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setRowHeight(55);
            table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 3f));
            scrollPane1.setViewportView(table1);
        }

        //---- returnBt ----
        returnBt.setText("\u8fd4\u56de");
        returnBt.addActionListener(e -> returnBtActionPerformed(e));

        //---- label1 ----
        label1.setText("\u4e1a\u7cbe\u4e8e\u52e4\u8352\u4e8e\u5b09\uff0c\u884c\u6210\u4e8e\u601d\u6bc1\u4e8e\u968f\u3002");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(67, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
                                .addComponent(returnBt))
                            .addGap(47, 47, 47))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(137, 137, 137))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                    .addGap(48, 48, 48)
                    .addComponent(returnBt)
                    .addGap(47, 47, 47))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton returnBt;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
