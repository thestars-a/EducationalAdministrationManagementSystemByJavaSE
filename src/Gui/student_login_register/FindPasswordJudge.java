/*
 * Created by JFormDesigner on Fri Mar 12 20:10:19 CST 2021
 */

package Gui.student_login_register;

import Service.Student.LoginRegisterService;
import Util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class FindPasswordJudge extends JFrame {
    static String stu_id;
    public FindPasswordJudge() {
        initComponents();
    }

    public void UI_init()
    {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    private void cancelActionPerformed(ActionEvent e) {
        new StuLogin().UI_init();
        dispose();
    }

    private void sureActionPerformed(ActionEvent e) {
        if (StringUtils.isEmpty(numText.getText())) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        }else {
            String judge = new LoginRegisterService().findPasswordJudge(numText.getText());
            if (judge == null) {
                JOptionPane.showMessageDialog(this, "学号不存在");
            } else {
                stu_id=numText.getText();
                new FindPassword().UI_init(judge, numText.getText());
                dispose();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        stuNum = new JLabel();
        numText = new JTextField();
        sure = new JButton();
        cancel = new JButton();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 23));
        var contentPane = getContentPane();

        //---- stuNum ----
        stuNum.setText("\u8bf7\u8f93\u5165\u5b66\u53f7");
        stuNum.setFont(stuNum.getFont().deriveFont(stuNum.getFont().getSize() + 5f));

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
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(stuNum)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(numText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                    .addGap(113, 113, 113))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(sure)
                    .addGap(68, 68, 68)
                    .addComponent(cancel)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(numText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(stuNum))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cancel)
                        .addComponent(sure))
                    .addContainerGap(31, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel stuNum;
    private JTextField numText;
    private JButton sure;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
