/*
 * Created by JFormDesigner on Sun Mar 14 15:49:28 CST 2021
 */

package Gui.teacher_login_register;

import Gui.student_login_register.StuLogin;
import Gui.teacherSurface.TecView;
import Model.StuUserInfo;
import Model.TecUserInfo;
import Model.UserLoginRegister;
import Service.Student.LoginRegisterService;
import Service.Teacher.TecLoginRegisterService;
import Util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class Tec_Register extends JFrame {

    public void UI_init()
    {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        checkBoxInit();
        comboxInit();
    }

    public void checkBoxInit() {
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(fmale);
    }

    public void comboxInit() {
        collegeChoose.addItem("计算机科学与技术");
        collegeChoose.addItem("电子竞技");
        collegeChoose.addItem("合肥推拿");
    }

    public Tec_Register() {
        initComponents();
    }

    private void sureActionPerformed(ActionEvent e) {
        String teacherNum = numText.getText();
        String teacherName = nameText.getText();
        String teacherCollege = (String) collegeChoose.getSelectedItem();
        String teacherPassword = passwordText.getText();
        String teacherSex;
        if (male.isSelected()) {
            teacherSex = male.getText();
        }else teacherSex=fmale.getText();
        if (StringUtils.isEmpty(teacherName) || StringUtils.isEmpty(teacherName) || StringUtils.isEmpty(teacherPassword)) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        } else {
            int registerNum = new TecLoginRegisterService().register
                    (new UserLoginRegister(teacherNum, teacherPassword),
                            new TecUserInfo(teacherNum,teacherName,teacherSex,teacherCollege));
            if (registerNum == 1) {
                JOptionPane.showMessageDialog(this, "该工号已注册");
            } else if (registerNum == 2) {
                JOptionPane.showMessageDialog(this, "注册成功");
                //如果在这里给学院设置值就会第二次登录这个值为空，造成空指针异常，所以不能在注册的时候设置
                //TecView.tec_college=teacherCollege;
                new TecLogin().UI_init();
                dispose();
            }
        }
    }

    private void cancelActionPerformed(ActionEvent e) {
        new TecLogin().UI_init();
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tecName = new JLabel();
        sex = new JLabel();
        college = new JLabel();
        password = new JLabel();
        numText = new JTextField();
        tecNum = new JLabel();
        nameText = new JTextField();
        passwordText = new JTextField();
        male = new JCheckBox();
        fmale = new JCheckBox();
        collegeChoose = new JComboBox();
        sure = new JButton();
        cancel = new JButton();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 23));
        var contentPane = getContentPane();

        //---- tecName ----
        tecName.setText("\u59d3\u540d");
        tecName.setFont(tecName.getFont().deriveFont(tecName.getFont().getSize() + 5f));

        //---- sex ----
        sex.setText("\u6027\u522b");
        sex.setFont(sex.getFont().deriveFont(sex.getFont().getSize() + 5f));

        //---- college ----
        college.setText("\u9662\u7cfb");
        college.setFont(college.getFont().deriveFont(college.getFont().getSize() + 5f));

        //---- password ----
        password.setText("\u5bc6\u7801");
        password.setFont(password.getFont().deriveFont(password.getFont().getSize() + 5f));

        //---- tecNum ----
        tecNum.setText("\u5de5\u53f7");
        tecNum.setFont(tecNum.getFont().deriveFont(tecNum.getFont().getSize() + 5f));

        //---- male ----
        male.setText("\u7537");

        //---- fmale ----
        fmale.setText("\u5973");

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
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(163, 163, 163)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(password)
                                    .addGap(18, 18, 18)
                                    .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(tecNum)
                                    .addGap(18, 18, 18)
                                    .addComponent(numText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(tecName)
                                    .addGap(18, 18, 18)
                                    .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(sex)
                                    .addGap(18, 18, 18)
                                    .addComponent(male)
                                    .addGap(37, 37, 37)
                                    .addComponent(fmale))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(college)
                                    .addGap(18, 18, 18)
                                    .addComponent(collegeChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(sure)
                            .addGap(122, 122, 122)
                            .addComponent(cancel)))
                    .addContainerGap(167, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tecNum)
                        .addComponent(numText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(tecName)
                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sex)
                        .addComponent(male)
                        .addComponent(fmale))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(college)
                        .addComponent(collegeChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(password)
                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sure)
                        .addComponent(cancel))
                    .addContainerGap(84, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel tecName;
    private JLabel sex;
    private JLabel college;
    private JLabel password;
    private JTextField numText;
    private JLabel tecNum;
    private JTextField nameText;
    private JTextField passwordText;
    private JCheckBox male;
    private JCheckBox fmale;
    private JComboBox collegeChoose;
    private JButton sure;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
