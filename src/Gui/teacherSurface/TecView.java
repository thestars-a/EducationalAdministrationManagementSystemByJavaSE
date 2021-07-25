/*
 * Created by JFormDesigner on Sun Mar 14 16:56:24 CST 2021
 */

package Gui.teacherSurface;

import Gui.teacher_login_register.TecLogin;
import Service.Teacher.TecSurfaceService;
import org.w3c.dom.ls.LSOutput;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class TecView extends JFrame {

    /**
     * 登录后获取此时登录者的唯一标识工号,在登录的时候获取,但在本类中未设置初值，所以本类的此值为空,如果想用，就得设置值
     */
    public static String tec_id;


    public TecView() {
        initComponents();
    }
    public void button_init(){
        ownInfo.setFocusPainted(false);
    }

    public void UI_Init(){
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        button_init();
    }

    private void ownInfoActionPerformed(ActionEvent e) {
        new TecManageStuInfo().UI_init();
        dispose();
    }

    private void subjectActionPerformed(ActionEvent e) {
        new TecSubjectView().UI_Init();
        dispose();
    }

    private void exitActionPerformed(ActionEvent e) {
        new TecLogin().UI_init();
        dispose();
    }

    private void scoreActionPerformed(ActionEvent e) {
        if (new TecSurfaceService().tec_sub_isSelect_judge(TecView.tec_id,new TecSurfaceService().tec_college_get(TecView.tec_id)))
        {
            new TecManagementScore().UI_init();
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
        head.setText("\u5b66 \u751f \u7ba1 \u7406 \u7cfb \u7edf \u6559 \u5e08 \u754c \u9762");
        head.setFont(head.getFont().deriveFont(head.getFont().getSize() + 12f));

        //---- ownInfo ----
        ownInfo.setText("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
        ownInfo.addActionListener(e -> ownInfoActionPerformed(e));

        //---- score ----
        score.setText("\u5b66\u751f\u6210\u7ee9\u7ba1\u7406");
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
