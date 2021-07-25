/*
 * Created by JFormDesigner on Fri Mar 12 17:18:39 CST 2021
 */

package Gui.studentSurface;

import Service.Student.StudentSurfaceService;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

/**
 * @author s
 */
public class StuUpdateInfo extends JFrame {
    public StuUpdateInfo() {
        initComponents();
    }


    public void UI_init() {
        setResizable(false);
        setDefaultCloseOperation(3);
        setVisible(true);
        table_init();
    }

    public void table_init() {
        table1.setModel(new MyTableModel());
        //表格居中
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table1.setDefaultRenderer(Object.class, renderer);
        /*table1.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    //业务逻辑
                    if (e.getColumn() == 1) {
                        String newvalue = new MyTableModel().getValueAt(e.getLastRow(), e.getColumn()).toString();
                        //System.out.println(newvalue);
                    }
                }
            }
        });*/
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Object o = e.getSource();
                    if (o instanceof JTable) {
                        if (table1.isCellEditable(table1.getSelectedRow(), table1.getSelectedColumn())) {
                            table1.setValueAt("", table1.getSelectedRow(), table1.getSelectedColumn());
                        }
                    }
                }
            }
        });
    }


    public static class MyTableModel extends AbstractTableModel {
        String[] str = new StudentSurfaceService().student_info_find(StuView.stu_id);
        private Object[] columnNames = {"类别", "数据"};
        private Object[][] rowData = {{"学号", str[0]},
                {"姓名", str[1]},
                {"性别", str[2]},
                {"专业", str[3]},
                {"密保问题", str[4]},
                {"密保答案", str[5]}};

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

        //单元格可否被编辑
        @Override
        public boolean isCellEditable(int row, int column) {
            /*学号虽说是注册的，但是我是懒得写一个没有重复的随机数发放函数，
            实际上学号是发放的不可以修改，专业更不用说，也不能修改*/
            if (column == 1 && row != 0 && row != 3) {
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


    private void sureActionPerformed(ActionEvent e) {
        //为了方便，不论修改多少信息都统一整体重新更新到数据库，就不修改几个更新几个了，一切从简哈哈
        new StudentSurfaceService().studen_update_info((String) table1.getValueAt(0, 1),(String) table1.getValueAt(1, 1),
                (String) table1.getValueAt(2, 1),
                (String) table1.getValueAt(4, 1), (String) table1.getValueAt(5, 1));
        JOptionPane.showMessageDialog(this,"修改成功");
        new StuOwnInfo().UI_init();
        dispose();
    }

    private void cancelActionPerformed(ActionEvent e) {
        new StuOwnInfo().UI_init();
        dispose();
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        sure = new JButton();
        cancel = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(14, 37));
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setRowHeight(40);
            scrollPane1.setViewportView(table1);
        }

        //---- sure ----
        sure.setText("\u786e\u5b9a");
        sure.addActionListener(e -> sureActionPerformed(e));

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.addActionListener(e -> {
			button2ActionPerformed(e);
			cancelActionPerformed(e);
		});

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(113, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addGap(110, 110, 110))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(132, 132, 132)
                    .addComponent(sure)
                    .addGap(105, 105, 105)
                    .addComponent(cancel)
                    .addContainerGap(130, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sure)
                        .addComponent(cancel))
                    .addContainerGap(47, Short.MAX_VALUE))
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
