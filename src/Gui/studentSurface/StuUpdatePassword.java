/*
 * Created by JFormDesigner on Thu Mar 11 22:38:54 CST 2021
 */

package Gui.studentSurface;

import Gui.student_login_register.StuLogin;
import Service.Student.StudentSurfaceService;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class StuUpdatePassword extends JFrame {
    public StuUpdatePassword() {
        initComponents();
    }

    public void UI_init(){
        setResizable(false);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    private void cancelActionPerformed(ActionEvent e) {
        new StuOwnInfo().UI_init();
        dispose();
    }

    private void sureActionPerformed(ActionEvent e) {
        String old_password=oldPassword.getText();
        String new_password=newPassword.getText();
        int i = new StudentSurfaceService().student_update_password(old_password, new_password,StuView.stu_id);
        if (i==1)
        {
            JOptionPane.showMessageDialog(this,"修改成功，请重新登录");
            new StuLogin().UI_init();
            dispose();
        }else {
            JOptionPane.showMessageDialog(this,"旧密码不正确请重新输入");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        oldPassword = new JTextField();
        newPassword = new JTextField();
        sure = new JButton();
        cancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u65e7\u5bc6\u7801");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 7f));

        //---- label2 ----
        label2.setText("\u65b0\u5bc6\u7801");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 7f));

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
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(oldPassword, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addComponent(newPassword, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(sure)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancel)))
                    .addContainerGap(115, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(oldPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(newPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sure)
                        .addComponent(cancel))
                    .addGap(38, 38, 38))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField oldPassword;
    private JTextField newPassword;
    private JButton sure;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
