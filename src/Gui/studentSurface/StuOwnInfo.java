/*
 * Created by JFormDesigner on Thu Mar 11 13:13:17 CST 2021
 */

package Gui.studentSurface;

import java.awt.*;
import java.awt.event.*;

import Service.Student.StudentSurfaceService;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

/**
 * @author s
 */
public class StuOwnInfo extends JFrame {
    //private String stu_id;

    //判断是否点击修改信息，由于信息的表格是个内部类，就写成公用静态的方便调用，暂不考虑安全问题
    public static int flag = 0;


    public StuOwnInfo() {
        initComponents();
    }


    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    public static class MyTableModel extends AbstractTableModel {
        //这个地方应该返回一个实体类，但是懒得改了，我就在教师那里用吧
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
    }

    public void UI_init() {
        setResizable(false);
        setDefaultCloseOperation(3);
        setVisible(true);
        tableInit();
    }

    public void tableInit() {
        table1.setModel(new MyTableModel());
        //居中
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table1.setDefaultRenderer(Object.class, renderer);
    }

    private void return_butActionPerformed(ActionEvent e) {
        new StuView().UI_Init();
        dispose();
    }

    private void label1MouseClicked(MouseEvent e) {
        new StuUpdatePassword().UI_init();
        dispose();
    }

    //修改信息
    private void label2MouseClicked(MouseEvent e) {
        dispose();
        new StuUpdateInfo().UI_init();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        return_but = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(14, 37));
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setRowHeight(40);
            scrollPane1.setViewportView(table1);
        }

        //---- return_but ----
        return_but.setText("\u8fd4\u56de");
        return_but.addActionListener(e -> return_butActionPerformed(e));

        //---- label1 ----
        label1.setText("\u4fee\u6539\u5bc6\u7801");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label1MouseClicked(e);
            }
        });

        //---- label2 ----
        label2.setText("\u4fee\u6539\u4fe1\u606f");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label2MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(113, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label2))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                            .addGap(110, 110, 110))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(return_but)
                            .addGap(44, 44, 44))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addComponent(return_but)
                    .addGap(16, 16, 16))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton return_but;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
