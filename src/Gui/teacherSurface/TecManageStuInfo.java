/*
 * Created by JFormDesigner on Fri Mar 19 15:25:40 CST 2021
 */

package Gui.teacherSurface;

import Service.Teacher.TecSurfaceService;
import Util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author s
 */
@SuppressWarnings("all")
public class TecManageStuInfo extends JFrame {

    public static Object[][] objects;
    String comboSelect;
    String textfield;
    public void UI_init() {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        combo_init();
    }

    public void combo_init()
    {
        stu_info_combo.addItem("学号");
        stu_info_combo.addItem("姓名");
        stu_info_combo.addItem("课程");
    }

    public void table_init()
    {
        table1.setModel(new StuManage());
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table1.setDefaultRenderer(Object.class, renderer);
    }

    public static class StuManage extends AbstractTableModel {

        private Object[] columnNames = {"学号", "姓名","课程","成绩"};
        private Object[][] rowData = objects;

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
            //只需要更新对应的位置
            this.fireTableCellUpdated(rowIndex, columnIndex);
        }
    }



    public TecManageStuInfo() {
        initComponents();
    }

    private void thisWindowGainedFocus(WindowEvent e) {
        // TODO add your code here
    }

    //下拉框监听时间
    private void stu_info_comboActionPerformed(ActionEvent e) {

    }

    private void stu_info_tfActionPerformed(ActionEvent e) {

    }

    private void seekActionPerformed(ActionEvent e) {
        comboSelect = (String) stu_info_combo.getSelectedItem();
        textfield=stu_info_tf.getText();
        if (StringUtils.isEmpty(textfield)) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        } else {
            objects = new TecSurfaceService().stu_info_manage_Ser(comboSelect, textfield, TecView.tec_id, new TecSurfaceService().tec_college_get(TecView.tec_id));
            table_init();
        }
    }

    private void allSeekActionPerformed(ActionEvent e) {
        objects=new TecSurfaceService().tec_score_input(new TecSurfaceService().tec_college_get(TecView.tec_id),TecView.tec_id);
        table_init();
    }

    private void addActionPerformed(ActionEvent e) {
        new InfoAdd().UI_init();
    }

    private void delActionPerformed(ActionEvent e) {
        int row = table1.getSelectedRow();
        if (row<0)
        {
            JOptionPane.showMessageDialog(this,"您未选中删除的学生");
        }else {
            Object valueAt = table1.getValueAt(row, 0);
            Object valueAt1 = table1.getValueAt(row, 2);
            int result = JOptionPane.showConfirmDialog(this, "确定从课程移除此人？",
                    "确认对话框", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                new TecSurfaceService().stu_subject_del_Ser((String) valueAt, (String) valueAt1);
                JOptionPane.showMessageDialog(this, "删除成功");
                objects = new TecSurfaceService().tec_score_input(new TecSurfaceService().tec_college_get(TecView.tec_id), TecView.tec_id);
                table_init();
            }
        }

    }

    private void returnBtActionPerformed(ActionEvent e) {
        new TecView().UI_Init();
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        stu_info_combo = new JComboBox();
        stu_info_tf = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        seek = new JButton();
        allSeek = new JButton();
        add = new JButton();
        del = new JButton();
        returnBt = new JButton();

        //======== this ========
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                thisWindowGainedFocus(e);
            }
        });
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
        label1.setFont(new Font(Font.DIALOG, Font.PLAIN, 26));

        //---- label2 ----
        label2.setText("\u8bf7\u9009\u62e9\u67e5\u8be2\u6761\u4ef6\uff1a");
        label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        //---- stu_info_combo ----
        stu_info_combo.addActionListener(e -> stu_info_comboActionPerformed(e));

        //---- stu_info_tf ----
        stu_info_tf.addActionListener(e -> stu_info_tfActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setRowHeight(40);
            scrollPane1.setViewportView(table1);
        }

        //---- seek ----
        seek.setText("\u67e5\u8be2");
        seek.addActionListener(e -> seekActionPerformed(e));

        //---- allSeek ----
        allSeek.setText("\u5168\u90e8\u4fe1\u606f\u67e5\u8be2");
        allSeek.addActionListener(e -> allSeekActionPerformed(e));

        //---- add ----
        add.setText("\u6dfb\u52a0");
        add.addActionListener(e -> addActionPerformed(e));

        //---- del ----
        del.setText("\u5220\u9664");
        del.addActionListener(e -> delActionPerformed(e));

        //---- returnBt ----
        returnBt.setText("\u8fd4\u56de");
        returnBt.addActionListener(e -> returnBtActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(393, 393, 393)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addComponent(stu_info_combo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(stu_info_tf, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(seek)
                            .addGap(29, 29, 29)
                            .addComponent(allSeek)))
                    .addContainerGap(18, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 48, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 872, GroupLayout.PREFERRED_SIZE)
                    .addGap(58, 58, 58))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(returnBt)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 466, Short.MAX_VALUE)
                    .addComponent(add)
                    .addGap(78, 78, 78)
                    .addComponent(del)
                    .addGap(120, 120, 120))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(stu_info_tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(stu_info_combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(seek)
                        .addComponent(allSeek))
                    .addGap(43, 43, 43)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(del)
                        .addComponent(add)
                        .addComponent(returnBt))
                    .addGap(25, 25, 25))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JComboBox stu_info_combo;
    private JTextField stu_info_tf;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton seek;
    private JButton allSeek;
    private JButton add;
    private JButton del;
    private JButton returnBt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
