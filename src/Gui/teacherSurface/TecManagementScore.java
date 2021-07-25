/*
 * Created by JFormDesigner on Fri Mar 19 15:12:39 CST 2021
 */

package Gui.teacherSurface;

import Gui.studentSurface.StuOwnInfo;
import Gui.studentSurface.StuView;
import Model.StuScoreInfo;
import Service.Student.StudentSurfaceService;
import Service.Teacher.TecSurfaceService;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 表格动态的问题，如果实现动态刷新岂不是此此要操作数据库，链接，写入，
 * 如果一次性的更新呢，一次性的可能适合多数据修改，动态刷新需要小范围修改
 * @author s
 */
public class TecManagementScore extends JFrame {

    public void UI_init() {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        table_init();
    }

    public void table_init()
    {
        table1.setModel(new MyTableModelScore());
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table1.setDefaultRenderer(Object.class, renderer);
    }



    public static class MyTableModelScore extends AbstractTableModel {

        private Object[] columnNames = {"学号", "姓名","课程","成绩"};
        private Object[][] rowData = new TecSurfaceService().tec_score_input(new TecSurfaceService().tec_college_get(TecView.tec_id),TecView.tec_id);

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
        public boolean isCellEditable(int row, int column) {
            if (column == 3) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            rowData[rowIndex][columnIndex] = aValue;
            //只需要更新对应的位置
            this.fireTableCellUpdated(rowIndex, columnIndex);
        }
    }


    public TecManagementScore() {
        initComponents();
    }

    private void cancelActionPerformed(ActionEvent e) {
        new TecView().UI_Init();
        dispose();
    }

    /**
     *
     * @param e
     */
    private void sureActionPerformed(ActionEvent e) {
        int rowCount = table1.getRowCount();
        List<StuScoreInfo> row_score = new ArrayList<>();
        StuScoreInfo stuScoreInfo=null;
        for (int i = 0; i < rowCount; i++) {
            Double score;
            String stu_id=(String) table1.getValueAt(i,0);
            String name=(String) table1.getValueAt(i,1);
            String subject_name=(String) table1.getValueAt(i,2);
            if (table1.getValueAt(i,3).toString().equals("暂未批改")){
                score=0.0;
            }else {
                score = Double.parseDouble(table1.getValueAt(i, 3).toString());
            }
            stuScoreInfo=new StuScoreInfo(stu_id,name,subject_name,score);
            row_score.add(stuScoreInfo);
        }
        new TecSurfaceService().tec_score_input_really(row_score,new TecSurfaceService().tec_college_get("192030429"));
        JOptionPane.showMessageDialog(this,"修改成功");
        table1.setModel(new MyTableModelScore());
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table1.setDefaultRenderer(Object.class, renderer);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        sure = new JButton();
        cancel = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setRowHeight(30);
            scrollPane1.setViewportView(table1);
        }

        //---- sure ----
        sure.setText("\u786e\u5b9a");
        sure.setFont(sure.getFont().deriveFont(sure.getFont().getSize() + 3f));
        sure.addActionListener(e -> sureActionPerformed(e));

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.addActionListener(e -> cancelActionPerformed(e));

        //---- label1 ----
        label1.setText("\u8bf7\u8fd9\u4f4d\u8001\u5e08\u5f55\u5165\u6216\u4fee\u6539\u6240\u53d7\u8bfe\u7a0b\u5b66\u751f\u6210\u7ee9\uff0c\u70b9\u51fb\u786e\u8ba4\u63d0\u4ea4");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(sure)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cancel))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addComponent(label1)))
                    .addContainerGap(104, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(26, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sure)
                        .addComponent(cancel))
                    .addGap(27, 27, 27))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton sure;
    private JButton cancel;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
