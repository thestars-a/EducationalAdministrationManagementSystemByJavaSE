/*
 * Created by JFormDesigner on Sun Mar 21 18:05:00 CST 2021
 */

package Gui.sys_login;

import Dao.DaoImpl.Login_Info_Impl.Login_Info_Dao;
import Gui.teacherSurface.TecView;
import Service.LogintInfotime.LoginInfoService;
import Service.Teacher.TecSurfaceService;

import java.awt.event.*;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author s
 */
public class Login_Info extends JFrame {

    public void UI_Init(){
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        time_update();
        table_init();
    }

    private void time_update()
    {
        Date date = new Date();
        long time = date.getTime();
        time=time-7*24*60*60*1000;
        Timestamp timestamp = new Timestamp(time);
        new LoginInfoService().login_info_del_Ser(timestamp);
    }
    public void table_init()
    {
        table1.setModel(new Login_Info_Model());
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table1.setDefaultRenderer(Object.class, renderer);
    }

    public static class Login_Info_Model extends AbstractTableModel {

        private Object[] columnNames = {"账号", "类别","时间"};
        private Object[][] rowData = new LoginInfoService().login_info_get_Ser();

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

    public Login_Info() {
        initComponents();
    }

    private void returnBtActionPerformed(ActionEvent e) {
        new Login().UI_Init();
        dispose();
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
            table1.setRowHeight(30);
            scrollPane1.setViewportView(table1);
        }

        //---- returnBt ----
        returnBt.setText("\u8fd4\u56de");
        returnBt.addActionListener(e -> returnBtActionPerformed(e));

        //---- label1 ----
        label1.setText("\u4ec5\u663e\u793a\u4e03\u65e5\u5185\u767b\u5f55\u8bb0\u5f55");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(73, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(returnBt)
                            .addGap(44, 44, 44))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
                            .addGap(76, 76, 76))))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(73, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(0, 380, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                    .addComponent(returnBt)
                    .addGap(18, 18, 18))
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
