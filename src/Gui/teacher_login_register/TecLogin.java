/*
 * Created by JFormDesigner on Sun Mar 14 15:40:36 CST 2021
 */

package Gui.teacher_login_register;

import Gui.sys_login.Login;
import Gui.teacherSurface.TecView;
import Model.UserLoginRegister;
import Service.LogintInfotime.LoginInfoService;
import Service.Teacher.TecLoginRegisterService;
import Util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class TecLogin extends JFrame {
    public TecLogin() {
        initComponents();
    }

    public void UI_init()
    {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        ShowPwd();
    }
    public void ShowPwd() {
        getContentPane().setLayout(null);
        getContentPane().add(passwordText);
        checkBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){//被选中
                    passwordText.setEchoChar((char)0);
                }else{
                    passwordText.setEchoChar('*');
                }
            }
        });
        getContentPane().add(checkBox1);
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        String username = numText.getText();
        String password = new String(passwordText.getPassword());
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        }else {
            int i = new TecLoginRegisterService().login(new UserLoginRegister(username, password));
            if (i == 1) {
                Timestamp date =  new java.sql.Timestamp(new Date().getTime());
                new LoginInfoService().input_info_Ser(username,"教师",date);
                TecView tecView = new TecView();
                tecView.UI_Init();
                TecView.tec_id = username;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "工号或密码错误");
            }
        }
    }

    private void registerButtonActionPerformed(ActionEvent e) {
        new Tec_Register().UI_init();
        dispose();
    }

    private void forgetMouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(this,"寻找管理员，懒得写，教师不支持找回密码");
    }

    private void exitActionPerformed(ActionEvent e) {
        new Login().UI_Init();
        dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tecHead = new JLabel();
        tecNum = new JLabel();
        numText = new JTextField();
        tecPassword = new JLabel();
        loginButton = new JButton();
        registerButton = new JButton();
        forget = new JLabel();
        exit = new JButton();
        passwordText = new JPasswordField();
        checkBox1 = new JCheckBox();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 23));
        var contentPane = getContentPane();

        //---- tecHead ----
        tecHead.setFont(tecHead.getFont().deriveFont(tecHead.getFont().getSize() + 12f));
        tecHead.setText("\u6559\u5e08\u767b\u5f55");

        //---- tecNum ----
        tecNum.setText("\u5de5\u53f7");
        tecNum.setFont(tecNum.getFont().deriveFont(tecNum.getFont().getSize() + 5f));

        //---- tecPassword ----
        tecPassword.setText("\u5bc6\u7801");
        tecPassword.setFont(tecPassword.getFont().deriveFont(tecPassword.getFont().getSize() + 5f));

        //---- loginButton ----
        loginButton.setText("\u767b\u5f55");
        loginButton.addActionListener(e -> loginButtonActionPerformed(e));

        //---- registerButton ----
        registerButton.setText("\u6ce8\u518c");
        registerButton.addActionListener(e -> registerButtonActionPerformed(e));

        //---- forget ----
        forget.setText("\u5fd8\u8bb0\u5bc6\u7801");
        forget.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                forgetMouseClicked(e);
            }
        });

        //---- exit ----
        exit.setText("\u9000\u51fa");
        exit.addActionListener(e -> exitActionPerformed(e));

        //---- checkBox1 ----
        checkBox1.setText("\u663e\u793a\u5bc6\u7801");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(forget)
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(tecPassword)
                                        .addGap(222, 222, 222)))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                        .addComponent(tecNum)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numText, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(checkBox1))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(loginButton)
                            .addGap(109, 109, 109)
                            .addComponent(registerButton)))
                    .addContainerGap(69, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(243, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(tecHead, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                            .addGap(214, 214, 214))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(exit)
                            .addGap(56, 56, 56))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(tecHead, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(numText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tecNum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tecPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(forget)
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(registerButton)
                        .addComponent(loginButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                    .addComponent(exit)
                    .addGap(47, 47, 47))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel tecHead;
    private JLabel tecNum;
    private JTextField numText;
    private JLabel tecPassword;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel forget;
    private JButton exit;
    private JPasswordField passwordText;
    private JCheckBox checkBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
