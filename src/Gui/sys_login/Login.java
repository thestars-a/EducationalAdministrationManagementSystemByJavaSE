/*
 * Created by JFormDesigner on Sun Mar 07 14:13:20 CST 2021
 */

package Gui.sys_login;

import Gui.student_login_register.StuLogin;
import Gui.teacher_login_register.TecLogin;
import Model.TimeForChina;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class Login extends JFrame {

    public Login() {
        initComponents();
    }

    private void stuLoginActionPerformed(ActionEvent e) {
        new StuLogin().UI_init();
        dispose();
    }

    private void tecLoginActionPerformed(ActionEvent e) {
        new TecLogin().UI_init();
        dispose();
    }

    public void UI_Init(){
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        initButton();
        configTimeArea();
        getWeekOfDate(new Date());
        setChinaday();
    }


    private void configTimeArea() {
        Timer tmr = new Timer();
        tmr.scheduleAtFixedRate(new TimeShow(), new Date(), 1000);
    }


    private class TimeShow extends TimerTask {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @Override
        public void run() {
            String time = dateFormatter.format(Calendar.getInstance().getTime());
            timeshow.setText(time);
        }
    }


    /**
     * 阴历
     */
    private void setChinaday()
    {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        chinaday.setText(new TimeForChina(instance).toString());
    }

    private void getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        weekshow.setText(weekDays[w]);
    }

    /*让界面开始后让第一个按钮没有被选中的痕迹（第一个按钮名字.setFocusPainted(false)）
    ,此方法只能在创建视图后紧接着调用，参考stuLoin和StuView用法*/
    public void initButton(){
        stuLogin.setFocusPainted(false);
    }

    private void button1ActionPerformed(ActionEvent e) {
            new Login_Info().UI_Init();
            dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        head = new JLabel();
        stuLogin = new JButton();
        tecLogin = new JButton();
        button1 = new JButton();
        timeshow = new JLabel();
        weekshow = new JLabel();
        chinaday = new JLabel();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 23));
        var contentPane = getContentPane();

        //---- head ----
        head.setText("\u5b66 \u751f \u7ba1 \u7406 \u7cfb \u7edf");
        head.setFont(head.getFont().deriveFont(head.getFont().getSize() + 12f));

        //---- stuLogin ----
        stuLogin.setText("\u5b66\u751f\u767b\u5f55");
        stuLogin.setFont(stuLogin.getFont().deriveFont(stuLogin.getFont().getSize() + 7f));
        stuLogin.addActionListener(e -> stuLoginActionPerformed(e));

        //---- tecLogin ----
        tecLogin.setText("\u6559\u5e08\u767b\u5f55");
        tecLogin.setFont(tecLogin.getFont().deriveFont(tecLogin.getFont().getSize() + 7f));
        tecLogin.addActionListener(e -> tecLoginActionPerformed(e));

        //---- button1 ----
        button1.setText("\u767b\u5f55\u65e5\u5fd7");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- timeshow ----
        timeshow.setText("text");
        timeshow.setFont(timeshow.getFont().deriveFont(timeshow.getFont().getSize() + 5f));

        //---- weekshow ----
        weekshow.setText("text");
        weekshow.setFont(weekshow.getFont().deriveFont(weekshow.getFont().getSize() + 5f));

        //---- chinaday ----
        chinaday.setText("text");
        chinaday.setFont(chinaday.getFont().deriveFont(chinaday.getFont().getSize() + 5f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(timeshow, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 329, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(weekshow, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(chinaday, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25))))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(195, Short.MAX_VALUE)
                    .addComponent(head, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addGap(189, 189, 189))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(225, 225, 225)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(tecLogin, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                        .addComponent(stuLogin, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(226, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(head, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)
                    .addComponent(stuLogin, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addComponent(tecLogin, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                    .addComponent(timeshow, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(weekshow, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1)
                        .addComponent(chinaday, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel head;
    private JButton stuLogin;
    private JButton tecLogin;
    private JButton button1;
    private JLabel timeshow;
    private JLabel weekshow;
    private JLabel chinaday;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
