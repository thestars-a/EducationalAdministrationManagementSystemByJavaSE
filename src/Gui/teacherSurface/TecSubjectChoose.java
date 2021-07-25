/*
 * Created by JFormDesigner on Sun Mar 14 21:53:31 CST 2021
 */

package Gui.teacherSurface;

import java.awt.event.*;

import Model.SubjectInfo;
import Service.Teacher.TecSurfaceService;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author s
 */
public class TecSubjectChoose extends JFrame {

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

    private String college;
/*    @Test*/
    public void UI_init() {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        college=new TecSurfaceService().tec_college_get(TecView.tec_id);
        sub_name = new TecSurfaceService().tec_sub_get(college);
        table_init();
    }

    /**
     * 这是我给JTable加入Model和此功能的核心处，当然有更好的方法，可惜我不想再去想了，累
     */
    public void table_init() {
        /*这里首先来一个集合，用来存储选中的复选框，这里有人可能好奇你也没定义复选框啊，实际我这里
            存的是选中复选框的行，复选框在上边那个类里就会通过设置的布尔值和重写的方法实现
        */
        List<Integer> list = new ArrayList<>();
        //集合首先添加一个100是因为我用不到100行，而且我不让集合初始有数据我下边就没法通过for给集合添加数据，
        //这里应该有更好的解决思路
        list.add(100);
        table1.setModel(new MyTableModel3());
        //给表格加入点击监听，因为我在表格的单元格改变那个监听遇到了bug，没有解决掉就改成了鼠标监听
        table1.addMouseListener(new MouseAdapter() {
            //不要用click点击监听，如果速度过快就会识别为双击，有bug
            @Override
            public void mousePressed(MouseEvent e) {
                //用到后边判断我到后便会说道为啥要放到重写的函数里定义
                int flag=0;
                if (e.getClickCount() == 1) {
                    int row = table1.getSelectedRow();
                    int column = table1.getSelectedColumn();
                    //复选框在哪列填多少，限制鼠标点击的位置
                    if (column == 1) {
                        //这里一定要先判断而且要用这种方法 不能用for each 不然会有bug在remove产生
                        //具体可以在这篇文章研究
                        for (int i = 0; i < list.size(); i++) {
                            int temp = list.get(i);
                            if (temp==row)
                            {
                                //如果新点击的和之前行一样说明是取消了选中就要移除这个行，并且这一行不能加入到集合中
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
                        }
                        //如果集合有了四个，就说明什么，说明有第三个复选框被选中，这时候就要让先选的一个从集合删除
                        //然后让之前的变量通过判断让还在集合里的变成true
                        if (list.size()==4) {
                            list.remove(1);
                            row1=list.get(1);
                            row2=list.get(2);
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
                            //这一步，更新就会让你之前变量变成true的变成选中的
                            table1.setModel(new MyTableModel3());
                            //然后要让变量又恢复到false，不会影响表格，因为没传进去，方便下一次的更新
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

    /**
     * 此类不用单独创建，可以当一个内部类使用，写到你生成JTable的那个类里，
     * 然后用你创建的JTable.setModel(new MyTableMode)来实现JTable插入复选框
     */
    class MyTableModel3 extends AbstractTableModel {
        //这是每列名字，有几个写几个
        private Object[] columnNames = {"name", "choose"};

        /*这是插入的数据就按着我写的说了，第一列不用照着我的，可以用中英文，第二列就得用到boolean值，
        这里要设置成一个变量的boolean值，后边要更新它达到限制效果，而且这个要设置成全局变量放到这个类的外边，
        再次声明，我用的内部类写法*/
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

        /**
         * 这里以及紧接着的下边的那个函数必须要有，这里就让这个复选框居中和展现出来，
         * 就不用去写渲染器了，也不用别的方法
         */
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

        //因为我是第二列需要编辑就设置了column=1，column是列的索引，这里也是必须要设置的
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            } else {
                return false;
            }
        }
        //这个函数必须有，不然有bug，先选的三个看不到
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            rowData[rowIndex][columnIndex] = aValue;
            //只需要更新对应的位置
            this.fireTableCellUpdated(rowIndex, columnIndex);
        }
    }



    public TecSubjectChoose() {
        initComponents();
    }

    private void cancelActionPerformed(ActionEvent e) {
        new TecSubjectView().UI_Init();
        dispose();
    }

    private void sureActionPerformed(ActionEvent e) {
        if (row1==100 && row2==100)
            JOptionPane.showMessageDialog(this,"选择不能为空");
        else {
            List<SubjectInfo> subjectNameInfoList = new ArrayList<>();
            if (row1 != 100) {
                Object valueAt = table1.getValueAt(row1, 0);
                subjectNameInfoList.add(new SubjectInfo((String) valueAt, TecView.tec_id, college));
            }
            if (row2 != 100) {
                Object valueAt1 = table1.getValueAt(row2, 0);
                subjectNameInfoList.add(new SubjectInfo((String) valueAt1, TecView.tec_id, college));
            }
            List<String> stringList = new TecSurfaceService().tec_sub_info_judge(subjectNameInfoList);
            if (stringList.size() == 0) {
                int result = JOptionPane.showConfirmDialog(this, "选课功能一学期仅开启一次，确认选择吗？",
                        "确认对话框", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result==JOptionPane.YES_OPTION)
                {
                    new TecSurfaceService().tec_sub_info_input(subjectNameInfoList);
                    JOptionPane.showMessageDialog(this,"选择成功");
                    new TecSubjectView().UI_Init();
                    dispose();
                }
            } else if (stringList.size() == 1) {
                JOptionPane.showMessageDialog(this, stringList.get(0) + "已经被选择");
            } else if (stringList.size() == 2) {
                JOptionPane.showMessageDialog(this, stringList.get(0) + "和" + stringList.get(1) + "已经被选择");
            }
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
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
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
