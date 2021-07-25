/*
 * Created by JFormDesigner on Mon Mar 08 11:58:18 CST 2021
 */

package Gui.student_login_register;

import Model.StuUserInfo;
import Model.UserLoginRegister;
import Service.Student.LoginRegisterService;
import Util.SendMail;
import Util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import java.security.GeneralSecurityException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
@SuppressWarnings("all")
public class Stu_Register extends JFrame {

    private String sendSelf;
    public void UI_init(){
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        ShowPwd();
        checkBoxInit();
        comboxInit();
    }
    private void checkBoxInit() {
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(fmale);
    }

    private void comboxInit() {
        collegeChoose.addItem("计算机科学与技术");
        collegeChoose.addItem("电子竞技");
        collegeChoose.addItem("合肥推拿");
    }


    public Stu_Register() {
        initComponents();
    }


    private void ShowPwd() {
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


    private void sureActionPerformed(ActionEvent e) {
        String studentNum = numText.getText();
        String studentName = nameText.getText();
        String studentCollege = (String) collegeChoose.getSelectedItem();
        String studentPassword = new String(passwordText.getPassword());
        String studentQue=queText.getText();
        String studentAns=ansText.getText();
        String studentSex;
        if (male.isSelected()) {
            studentSex = male.getText();
        }else studentSex=fmale.getText();
        if (StringUtils.isEmpty(studentName) || StringUtils.isEmpty(studentNum) || StringUtils.isEmpty(studentPassword) ||StringUtils.isEmpty(studentQue)||StringUtils.isEmpty(studentAns)) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        }else if (!checkCodeText.getText().equals(sendSelf)){
            System.out.println("发送:"+sendSelf);
            System.out.println("接受:"+checkCodeText.getText());
            JOptionPane.showMessageDialog(this,"验证码错误");
        }else {
            int registerNum = new LoginRegisterService().register
                    (new UserLoginRegister(studentNum, studentPassword),
                            new StuUserInfo(studentNum,studentName,studentSex,studentCollege,studentQue,studentAns));
            if (registerNum == 1) {
                JOptionPane.showMessageDialog(this, "该学号已注册");
            } else if (registerNum == 2) {
                JOptionPane.showMessageDialog(this, "注册成功");
                new StuLogin().UI_init();
                dispose();
            }
        }
    }

    private void cancelActionPerformed(ActionEvent e) {
        new StuLogin().UI_init();
        dispose();

    }

    public void timeOver() {
        final int[] midTime = {60, 180};
        Timer tmr1 = new Timer();
        Timer tmr2 = new Timer();
        tmr1.schedule(new TimerTask() {
            @Override
            public void run() {
                midTime[0]--;
                long ss = midTime[0];
                time.setText(ss + "秒");
                if (ss == 0) {
                    time.setText("重新点击发送验证码");
                    tmr1.cancel();
                }
            }
        }, 0, 1000);
        tmr2.schedule(new TimerTask() {
            @Override
            public void run() {
                midTime[1]--;
                long sss = midTime[1];
                if (sss == 0) {
                    sendSelf = "我直接无敌";
                    tmr2.cancel();
                }
            }
        }, 0, 1000);
    }

    private void sendnumMouseClicked(MouseEvent e) {
        if (StringUtils.isEmpty(emailText.getText())) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        }else {
            String str = "0123456789";
            StringBuilder stringBuilder = new StringBuilder(5);
            for (int i = 0; i < 5; i++) {
                char ch = str.charAt(new Random().nextInt(str.length()));
                stringBuilder.append(ch);
            }
            final String[] send = {stringBuilder.toString()};
            sendSelf = send[0];
            try {
                new Thread(() -> {
                    try {
                        new SendMail(emailText.getText()).send(send[0]);
                    } catch (MessagingException messagingException) {
                        messagingException.printStackTrace();
                    } catch (GeneralSecurityException generalSecurityException) {
                        generalSecurityException.printStackTrace();
                    }
                }).start();
                timeOver();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void sendnumMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        stuName = new JLabel();
        sex = new JLabel();
        college = new JLabel();
        password = new JLabel();
        numText = new JTextField();
        stuNum = new JLabel();
        nameText = new JTextField();
        male = new JCheckBox();
        fmale = new JCheckBox();
        collegeChoose = new JComboBox();
        sure = new JButton();
        cancel = new JButton();
        serect_que = new JLabel();
        serect_ans = new JLabel();
        ansText = new JTextField();
        queText = new JTextField();
        passwordText = new JPasswordField();
        checkBox1 = new JCheckBox();
        email = new JLabel();
        checkCode = new JLabel();
        emailText = new JTextField();
        checkCodeText = new JTextField();
        sendnum = new JLabel();
        time = new JLabel();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 23));
        var contentPane = getContentPane();

        //---- stuName ----
        stuName.setText("\u59d3\u540d");
        stuName.setFont(stuName.getFont().deriveFont(stuName.getFont().getSize() + 5f));

        //---- sex ----
        sex.setText("\u6027\u522b");
        sex.setFont(sex.getFont().deriveFont(sex.getFont().getSize() + 5f));

        //---- college ----
        college.setText("\u9662\u7cfb");
        college.setFont(college.getFont().deriveFont(college.getFont().getSize() + 5f));

        //---- password ----
        password.setText("\u5bc6\u7801");
        password.setFont(password.getFont().deriveFont(password.getFont().getSize() + 5f));

        //---- stuNum ----
        stuNum.setText("\u5b66\u53f7");
        stuNum.setFont(stuNum.getFont().deriveFont(stuNum.getFont().getSize() + 5f));

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

        //---- serect_que ----
        serect_que.setText("\u5bc6\u4fdd\u95ee\u9898");
        serect_que.setFont(serect_que.getFont().deriveFont(serect_que.getFont().getSize() + 5f));

        //---- serect_ans ----
        serect_ans.setText("\u5bc6\u4fdd\u7b54\u6848");
        serect_ans.setFont(serect_ans.getFont().deriveFont(serect_ans.getFont().getSize() + 5f));

        //---- checkBox1 ----
        checkBox1.setText("\u663e\u793a\u5bc6\u7801");

        //---- email ----
        email.setText("\u90ae\u7bb1");
        email.setFont(email.getFont().deriveFont(email.getFont().getSize() + 5f));

        //---- checkCode ----
        checkCode.setText("\u9a8c\u8bc1\u7801");
        checkCode.setFont(checkCode.getFont().deriveFont(checkCode.getFont().getSize() + 5f));

        //---- sendnum ----
        sendnum.setText("\u53d1\u9001\u9a8c\u8bc1\u7801");
        sendnum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sendnumMouseClicked(e);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                sendnumMousePressed(e);
            }
        });

        //---- time ----
        time.setText("                            ");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(serect_ans)
                                .addComponent(serect_que)
                                .addComponent(password)
                                .addComponent(college)
                                .addComponent(sex)
                                .addComponent(stuName)
                                .addComponent(stuNum)
                                .addComponent(checkCode)
                                .addComponent(email))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(ansText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addComponent(queText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(checkBox1))
                                .addComponent(collegeChoose, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(male)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fmale))
                                .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addComponent(numText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(emailText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sendnum))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(checkCodeText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(time, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(159, 159, 159)
                            .addComponent(sure)
                            .addGap(75, 75, 75)
                            .addComponent(cancel)))
                    .addContainerGap(36, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(email)
                        .addComponent(emailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sendnum))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(checkCode)
                        .addComponent(checkCodeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(time))
                    .addGap(15, 15, 15)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(stuNum)
                        .addComponent(numText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(stuName)
                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sex)
                        .addComponent(male)
                        .addComponent(fmale))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(college)
                        .addComponent(collegeChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(password)
                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(serect_que)
                        .addComponent(queText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(serect_ans)
                        .addComponent(ansText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(48, 48, 48)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sure)
                        .addComponent(cancel))
                    .addGap(28, 28, 28))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel stuName;
    private JLabel sex;
    private JLabel college;
    private JLabel password;
    private JTextField numText;
    private JLabel stuNum;
    private JTextField nameText;
    private JCheckBox male;
    private JCheckBox fmale;
    private JComboBox collegeChoose;
    private JButton sure;
    private JButton cancel;
    private JLabel serect_que;
    private JLabel serect_ans;
    private JTextField ansText;
    private JTextField queText;
    private JPasswordField passwordText;
    private JCheckBox checkBox1;
    private JLabel email;
    private JLabel checkCode;
    private JTextField emailText;
    private JTextField checkCodeText;
    private JLabel sendnum;
    private JLabel time;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
