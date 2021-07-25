/*
 * Created by JFormDesigner on Thu Mar 18 10:49:56 CST 2021
 */

package Gui.studentSurface;

import Gui.teacherSurface.TecSubjectChoose;
import Gui.teacherSurface.TecSubjectView;
import Gui.teacherSurface.TecView;
import Model.SubjectInfo;
import Service.Student.StudentSurfaceService;
import Service.Teacher.TecSurfaceService;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.AbstractTableModel;

/**
 * @author s
 */
public class StuSubjectChoose extends JFrame {
    public StuSubjectChoose() {
        initComponents();
    }

    boolean cou0 = false;
    boolean cou1 = false;
    boolean cou2 = false;
    boolean cou3 = false;
    boolean cou4 = false;
    boolean cou5 = false;
    boolean cou6 = false;
    boolean cou7 = false;
    boolean cou8 = false;
    boolean cou9 = false;

    String[] sub_name=new String[10];
    int row1=100;
    int row2=100;
    int row3=100;

    private String college;
    public void UI_init() {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        college=new StudentSurfaceService().student_info_find(StuView.stu_id)[3];
        sub_name = new TecSurfaceService().tec_sub_get(college);
        table_init();
    }
    private void sureActionPerformed(ActionEvent e) {
        if (row1==100 && row2==100 && row3==100)
            JOptionPane.showMessageDialog(this,"选择不能为空");
        else {
            List<SubjectInfo> subjectNameInfoList = new ArrayList<>();
            if (row1 != 100) {
                Object valueAt = table1.getValueAt(row1, 0);
                subjectNameInfoList.add(new SubjectInfo((String) valueAt,StuView.stu_id));
            }
            if (row2 != 100) {
                Object valueAt1 = table1.getValueAt(row2, 0);
                subjectNameInfoList.add(new SubjectInfo((String) valueAt1,StuView.stu_id));
            }
            if (row3 != 100) {
                Object valueAt2 = table1.getValueAt(row3, 0);
                subjectNameInfoList.add(new SubjectInfo((String) valueAt2,StuView.stu_id));
            }
            int result = JOptionPane.showConfirmDialog(this, "选课功能一学期仅开启一次，确认选择吗？",
                    "确认对话框", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result==JOptionPane.YES_OPTION)
            {
                new StudentSurfaceService().stu_sub_info_input(subjectNameInfoList);
                JOptionPane.showMessageDialog(this,"选择成功");
                new StuSubjectView().UI_Init();
                dispose();
            }
        }
    }

    private void cancelActionPerformed(ActionEvent e) {
        new StuSubjectView().UI_Init();
        dispose();
    }

    public void table_init() {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        table1.setModel(new MyTableModels());
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int flag=0;
                if (e.getClickCount() == 1) {
                    int row = table1.getSelectedRow();
                    int column = table1.getSelectedColumn();
                    if (column == 1) {
                        for (int i = 0; i < list.size(); i++) {
                            int temp = list.get(i);
                            if (temp==row)
                            {
                                flag++;
                                list.remove((Integer)row);
                            }
                        }
                        if (flag==0)
                            list.add(row);
                        if (list.size()==2)
                            row1=list.get(1);
                        if (list.size()==3) {
                            row2 = list.get(2);
                        }if (list.size()==4) {
                            row3 = list.get(3);
                        }
                        if (list.size()==5) {
                            list.remove(1);
                            row1=list.get(1);
                            row2=list.get(2);
                            row3=list.get(3);
                            for (Integer integer1 : list) {
                                if (integer1 == 0)
                                    cou0 = true;
                                else if (integer1 == 1)
                                    cou1 = true;
                                else if (integer1 == 2)
                                    cou2 = true;
                                else if (integer1 == 3)
                                    cou3 = true;
                                else if (integer1 == 4)
                                    cou4 = true;
                                else if (integer1 == 5)
                                    cou5 = true;
                                else if (integer1 == 6)
                                    cou6 = true;
                                else if (integer1 == 7)
                                    cou7 = true;
                                else if (integer1 == 8)
                                    cou8 = true;
                                else if (integer1 == 9)
                                    cou9 = true;
                            }
                            table1.setModel(new MyTableModels());
                            cou0=false;
                            cou1=false;
                            cou2=false;
                            cou3=false;
                            cou4=false;
                            cou5=false;
                            cou6=false;
                            cou7=false;
                            cou8=false;
                            cou9=false;
                        }
                    }
                }
            }
        });
    }

    class MyTableModels extends AbstractTableModel {
        private Object[] columnNames = {"name", "choose"};

        private Object[][] rowData = {{sub_name[0], cou0},
                {sub_name[1], cou1},
                {sub_name[2], cou2},
                {sub_name[3], cou3},
                {sub_name[4], cou4},
                {sub_name[5],cou5},
                {sub_name[6],cou6},
                {sub_name[7],cou7},
                {sub_name[8],cou8},
                {sub_name[9],cou9}};

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

        Class<?>[] columnTypes = new Class<?>[]{
                Object.class, Boolean.class
        };

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rowData[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        sure = new JButton();
        cancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setFont(scrollPane1.getFont().deriveFont(scrollPane1.getFont().getSize() + 3f));

            //---- table1 ----
            table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 3f));
            table1.setRowHeight(23);
            scrollPane1.setViewportView(table1);
        }

        //---- sure ----
        sure.setText("\u786e\u5b9a");
        sure.addActionListener(e -> sureActionPerformed(e));

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.addActionListener(e -> cancelActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(64, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(sure)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                            .addComponent(cancel)))
                    .addGap(67, 67, 67))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sure)
                        .addComponent(cancel))
                    .addGap(53, 53, 53))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
