/*
 * Created by JFormDesigner on Tue Mar 23 17:36:48 CST 2021
 */

package Gui.student_login_register;

import Gui.studentSurface.StuView;
import Service.LogintInfotime.LoginInfoService;
import Service.Student.LoginRegisterService;
import Service.Student.StudentSurfaceService;
import Util.StringUtils;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class UpadtePW extends JFrame {

    /**
     * 第二次修正程序 这样可以少写一个密码修改的sql
     * @param
     */
    public void UI_init(){
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    public UpadtePW() {
        initComponents();
    }

    private void sureActionPerformed(ActionEvent e) {
        String new_password=new String(newpassword.getPassword());
        String sure_password=new String(surepassword.getPassword());
        if (StringUtils.isEmpty(new_password)||StringUtils.isEmpty(sure_password))
        {
            JOptionPane.showMessageDialog(this,"输入不能为空");
        }else if (!new_password.equals(sure_password))
        {
            JOptionPane.showMessageDialog(this,"前后密码不一致");
        }else
        {
            new LoginRegisterService().studentPasswordUpdate_Ser(new_password,FindPasswordJudge.stu_id);
            JOptionPane.showMessageDialog(this,"修改成功，请重新登录");
            new StuLogin().UI_init();
            dispose();
        }
    }

    private void cancelActionPerformed(ActionEvent e) {
        new StuLogin().UI_init();
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        sure = new JButton();
        cancel = new JButton();
        newpassword = new JPasswordField();
        surepassword = new JPasswordField();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u65b0\u5bc6\u7801");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 7f));

        //---- label2 ----
        label2.setText("\u5bc6\u7801\u786e\u8ba4");
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
                            .addComponent(sure)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancel))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(surepassword, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addComponent(newpassword, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(90, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(newpassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(surepassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
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
    private JButton sure;
    private JButton cancel;
    private JPasswordField newpassword;
    private JPasswordField surepassword;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
