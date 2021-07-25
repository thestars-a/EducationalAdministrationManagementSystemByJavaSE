/*
 * Created by JFormDesigner on Sun Mar 07 14:34:51 CST 2021
 */

package Gui.student_login_register;

import Gui.studentSurface.StuView;
import Gui.sys_login.Login;
import Model.CheckCode;
import Model.UserLoginRegister;
import Service.LogintInfotime.LoginInfoService;
import Service.Student.LoginRegisterService;
import Util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class StuLogin extends JFrame {

    private String strCode;

    public void UI_init() {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        ShowPwd();
        checkCreate();
    }

    private void checkCreate() {
        CheckCode checkCode = new CheckCode();
        try {
            checkCode.output(checkCode.getImage(), new FileOutputStream("test.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        strCode = checkCode.getText();
        checkPhoto.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("test.jpg")));
    }

    public StuLogin() {
        initComponents();
    }

    private void registerButtonActionPerformed(ActionEvent e) {
        new Stu_Register().UI_init();
        dispose();
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        String username = numText.getText();
        String password = new String(passwordText.getPassword());
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        } else if (StringUtils.isEmpty(checkNumText.getText())) {
            JOptionPane.showMessageDialog(this, "验证码不能为空");
        } else {
            if (!strCode.equals(checkNumText.getText())) {
                JOptionPane.showMessageDialog(this, "验证码错误,请重新输入");
            } else {
                int i = new LoginRegisterService().login(new UserLoginRegister(username, password));
                if (i == 1) {
                    //通过时间转换为long类型再转化为timestamp类型
                    Timestamp date = new java.sql.Timestamp(new Date().getTime());
                    new LoginInfoService().input_info_Ser(username, "学生", date);
                    StuView stuView = new StuView();
                    stuView.UI_Init();
                    StuView.stu_id = username;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "学号或密码错误");
                }
            }
        }
    }

    private void findPasswordMouseClicked(MouseEvent e) {
        new FindPasswordJudge().UI_init();
        dispose();
    }

    private void exitActionPerformed(ActionEvent e) {
        new Login().UI_Init();
        dispose();
    }


    private void ShowPwd() {
        getContentPane().setLayout(null);
        getContentPane().add(passwordText);
        checkBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {//被选中
                    passwordText.setEchoChar((char) 0);
                } else {
                    passwordText.setEchoChar('*');
                }
            }
        });
        getContentPane().add(checkBox1);
    }

    private void label1MouseClicked(MouseEvent e) {
        checkCreate();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        stuHead = new JLabel();
        stuNum = new JLabel();
        numText = new JTextField();
        stuPassword = new JLabel();
        loginButton = new JButton();
        registerButton = new JButton();
        findPassword = new JLabel();
        exit = new JButton();
        checkBox1 = new JCheckBox();
        passwordText = new JPasswordField();
        checkNum = new JLabel();
        checkPhoto = new JLabel();
        label1 = new JLabel();
        checkNumText = new JTextField();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 23));
        var contentPane = getContentPane();

        //---- stuHead ----
        stuHead.setFont(stuHead.getFont().deriveFont(stuHead.getFont().getSize() + 12f));
        stuHead.setText("\u5b66\u751f\u767b\u5f55");

        //---- stuNum ----
        stuNum.setText("\u5b66\u53f7");
        stuNum.setFont(stuNum.getFont().deriveFont(stuNum.getFont().getSize() + 5f));

        //---- stuPassword ----
        stuPassword.setText("\u5bc6\u7801");
        stuPassword.setFont(stuPassword.getFont().deriveFont(stuPassword.getFont().getSize() + 5f));

        //---- loginButton ----
        loginButton.setText("\u767b\u5f55");
        loginButton.addActionListener(e -> loginButtonActionPerformed(e));

        //---- registerButton ----
        registerButton.setText("\u6ce8\u518c");
        registerButton.addActionListener(e -> registerButtonActionPerformed(e));

        //---- findPassword ----
        findPassword.setText("\u5fd8\u8bb0\u5bc6\u7801?");
        findPassword.setFont(findPassword.getFont().deriveFont(findPassword.getFont().getSize() + 3f));
        findPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                findPasswordMouseClicked(e);
            }
        });

        //---- exit ----
        exit.setText("\u9000\u51fa");
        exit.addActionListener(e -> exitActionPerformed(e));

        //---- checkBox1 ----
        checkBox1.setText("\u663e\u793a\u5bc6\u7801");

        //---- checkNum ----
        checkNum.setText("\u9a8c\u8bc1\u7801");
        checkNum.setFont(checkNum.getFont().deriveFont(checkNum.getFont().getSize() + 5f));

        //---- checkPhoto ----
        checkPhoto.setText("  ");
        checkPhoto.setFont(checkPhoto.getFont().deriveFont(checkPhoto.getFont().getSize() + 5f));

        //---- label1 ----
        label1.setText("\u770b\u4e0d\u6e05\u695a?\u6362\u4e00\u5f20");
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label1MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(loginButton)
                                .addGap(119, 119, 119)
                                .addComponent(registerButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(stuHead, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addGap(261, 261, 261))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(exit)
                                                .addGap(42, 42, 42))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(stuNum)
                                                        .addComponent(stuPassword))
                                                .addGap(34, 34, 34)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(numText, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(findPassword))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(checkBox1)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(checkNum)
                                                .addGap(18, 18, 18)
                                                .addComponent(checkNumText, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(checkPhoto, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(138, 138, 138))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(stuHead, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(stuNum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(stuPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkBox1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(findPassword)
                                .addGap(23, 23, 23)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(checkNum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkNumText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkPhoto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(loginButton)
                                                        .addComponent(registerButton))
                                                .addGap(65, 65, 65))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(exit)
                                                .addGap(16, 16, 16))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel stuHead;
    private JLabel stuNum;
    private JTextField numText;
    private JLabel stuPassword;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel findPassword;
    private JButton exit;
    private JCheckBox checkBox1;
    private JPasswordField passwordText;
    private JLabel checkNum;
    private JLabel checkPhoto;
    private JLabel label1;
    private JTextField checkNumText;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
