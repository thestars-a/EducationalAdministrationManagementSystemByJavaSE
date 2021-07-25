/*
 * Created by JFormDesigner on Tue Mar 09 16:58:44 CST 2021
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
public class StuView extends JFrame {
    //private static String stu_id;
    //学生得一系列操作要有一个学号来标识是这个学生，方便数据库查询
    public static String stu_id;

    public void UI_Init(){
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        button_init();
    }

    /*public void studentJudge(String stu_only_id){
        stu_id=stu_only_id;
    }*/

    public void button_init(){
        ownInfo.setFocusPainted(false);
    }

    public StuView() {
        initComponents();
    }

    private void ownInfoActionPerformed(ActionEvent e) {
        new StuOwnInfo().UI_init();
        dispose();
        setDefaultCloseOperation(3);
    }

    private void exitActionPerformed(ActionEvent e) {
        new StuLogin().UI_init();
        dispose();
    }

    private void subjectActionPerformed(ActionEvent e) {
        new StuSubjectView().UI_Init();
        dispose();
    }

    private void scoreActionPerformed(ActionEvent e) {
        if (new StudentSurfaceService().stu_sub_isSelect_judge(StuView.stu_id))
        {
            new StuScoreSeek().UI_init();
            dispose();
        }else {
            JOptionPane.showMessageDialog(this,"本学期您尚未选择课程，请先选择课程");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        head = new JLabel();
        ownInfo = new JButton();
        score = new JButton();
        subject = new JButton();
        exit = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- head ----
        head.setText("\u5b66 \u751f \u7ba1 \u7406 \u7cfb \u7edf \u5b66 \u751f \u754c \u9762");
        head.setFont(head.getFont().deriveFont(head.getFont().getSize() + 12f));

        //---- ownInfo ----
        ownInfo.setText("\u4e2a\u4eba\u4fe1\u606f\u67e5\u8be2");
        ownInfo.addActionListener(e -> ownInfoActionPerformed(e));

        //---- score ----
        score.setText("\u6210\u7ee9\u67e5\u8be2");
        score.addActionListener(e -> scoreActionPerformed(e));

        //---- subject ----
        subject.setText("\u8bfe\u7a0b\u7ba1\u7406");
        subject.addActionListener(e -> subjectActionPerformed(e));

        //---- exit ----
        exit.setText("\u9000\u51fa");
        exit.addActionListener(e -> exitActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(ownInfo, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                    .addGap(71, 71, 71)
                    .addComponent(score, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                    .addGap(82, 82, 82)
                    .addComponent(subject, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(193, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(head, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
                            .addGap(190, 190, 190))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(exit)
                            .addGap(131, 131, 131))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(head, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                    .addGap(88, 88, 88)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ownInfo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addComponent(score, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addComponent(subject, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                    .addGap(84, 84, 84)
                    .addComponent(exit)
                    .addContainerGap(124, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel head;
    private JButton ownInfo;
    private JButton score;
    private JButton subject;
    private JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
