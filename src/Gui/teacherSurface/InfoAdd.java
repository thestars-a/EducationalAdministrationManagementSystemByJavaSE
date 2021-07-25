/*
 * Created by JFormDesigner on Sun Mar 21 13:33:34 CST 2021
 */

package Gui.teacherSurface;

import java.awt.event.*;

import Model.StuAdd;
import Service.Teacher.TecSurfaceService;
import Util.StringUtils;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.List;

/**
 * @author s
 */
public class InfoAdd extends JFrame {


    public void UI_init() {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        combo_init();
    }

    public void combo_init() {
        List<String> list = new TecSurfaceService().tec_sub_name_get(new TecSurfaceService().tec_college_get(TecView.tec_id), TecView.tec_id);
        if (list.size() == 1)
            subject.addItem(list.get(0));
        else if (list.size() == 2) {
            subject.addItem(list.get(0));
            subject.addItem(list.get(1));
        }
    }


    public InfoAdd() {
        initComponents();
    }

    private void cancelActionPerformed(ActionEvent e) {
        dispose();
    }

    private void sureActionPerformed(ActionEvent e) {
        String text = id.getText();
        String text1 = name.getText();
        Object selectedItem = subject.getSelectedItem();
        StuAdd stuAdd = new StuAdd(text, text1, (String) selectedItem);
        if (StringUtils.isEmpty(text) || StringUtils.isEmpty(text1)) {
            JOptionPane.showMessageDialog(this, "信息输入不能为空,请重新输入");
        } else {
            if (!new TecSurfaceService().stu_subject_add_judgePlus_Ser(text, new TecSurfaceService().tec_college_get(TecView.tec_id))) {
                JOptionPane.showMessageDialog(this, "该学生不存在或者不属于本专业");
            } else {
                if (!new TecSurfaceService().stu_subject_add_judgePlus_idAndName_Ser(text, text1)) {
                    JOptionPane.showMessageDialog(this, "学号姓名不一致");
                } else {
                    if (new TecSurfaceService().stu_subject_add_judge_Ser(stuAdd)) {
                        JOptionPane.showMessageDialog(this, "该课程已经存在该学生");
                    } else {
                        if (!new TecSurfaceService().stu_subject_add_judgePlus_sub_Ser(text)) {
                            JOptionPane.showMessageDialog(this, "该学生选择科目以达上限");
                        } else {
                            new TecSurfaceService().stu_subject_add_Ser(stuAdd);
                            JOptionPane.showMessageDialog(this, "添加成功");
                            dispose();
                        }
                    }
                }
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        id = new JTextField();
        name = new JTextField();
        subject = new JComboBox();
        sure = new JButton();
        cancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5b66\u53f7");

        //---- label2 ----
        label2.setText("\u59d3\u540d");

        //---- label3 ----
        label3.setText("\u8bfe\u7a0b");

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
                                .addGap(63, 63, 63)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label3)
                                                .addGap(36, 36, 36)
                                                .addComponent(subject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                        .addGap(9, 9, 9)
                                                        .addComponent(sure)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cancel))
                                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                                .addComponent(label1)
                                                                .addComponent(label2))
                                                        .addGap(26, 26, 26)
                                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                                .addComponent(id, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(81, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancel)
                                        .addComponent(sure))
                                .addGap(38, 38, 38))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField id;
    private JTextField name;
    private JComboBox subject;
    private JButton sure;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
