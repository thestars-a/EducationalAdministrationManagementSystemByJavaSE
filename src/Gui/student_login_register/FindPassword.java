/*
 * Created by JFormDesigner on Wed Mar 10 15:29:08 CST 2021
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
public class FindPassword extends JFrame {

    private String student_id;
    public FindPassword() {
        initComponents();
    }

    public void UI_init(String que,String id){
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        student_id=id;
        queText.setText(que);
    }

    private void cancelActionPerformed(ActionEvent e) {
        new StuLogin().UI_init();
        dispose();
    }

    private void sureActionPerformed(ActionEvent e) {
        String serectAns =ansText.getText();
        if (StringUtils.isEmpty(serectAns)) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        }else {
            String pw = new LoginRegisterService().findPassword(student_id, serectAns);
            if (pw.equals("回答错误")) {
                JOptionPane.showMessageDialog(this, "回答错误");
            } else {
                new UpadtePW().UI_init();
                dispose();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        head = new JLabel();
        serectQue = new JLabel();
        serectAns = new JLabel();
        ansText = new JTextField();
        sure = new JButton();
        cancel = new JButton();
        queText = new JTextField();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 23));
        var contentPane = getContentPane();

        //---- head ----
        head.setText("\u627e\u56de\u5bc6\u7801");
        head.setFont(head.getFont().deriveFont(head.getFont().getSize() + 12f));

        //---- serectQue ----
        serectQue.setText("\u5bc6\u4fdd\u95ee\u9898");
        serectQue.setFont(serectQue.getFont().deriveFont(serectQue.getFont().getSize() + 5f));

        //---- serectAns ----
        serectAns.setText("\u5bc6\u4fdd\u7b54\u6848");
        serectAns.setFont(serectAns.getFont().deriveFont(serectAns.getFont().getSize() + 5f));

        //---- sure ----
        sure.setText("\u786e\u5b9a");
        sure.addActionListener(e -> sureActionPerformed(e));

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.addActionListener(e -> cancelActionPerformed(e));

        //---- queText ----
        queText.setEnabled(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(233, 233, 233)
                            .addComponent(head))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(serectQue)
                                .addComponent(serectAns))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(queText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ansText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(178, 178, 178)
                            .addComponent(sure)
                            .addGap(61, 61, 61)
                            .addComponent(cancel)))
                    .addContainerGap(178, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(head, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(serectQue)
                        .addComponent(queText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(serectAns)
                        .addComponent(ansText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sure)
                        .addComponent(cancel))
                    .addContainerGap(136, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel head;
    private JLabel serectQue;
    private JLabel serectAns;
    private JTextField ansText;
    private JButton sure;
    private JButton cancel;
    private JTextField queText;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
