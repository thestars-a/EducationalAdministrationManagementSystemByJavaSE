/*
 * Created by JFormDesigner on Sat Mar 13 18:48:47 CST 2021
 */

package Gui.studentSurface;

import Gui.teacherSurface.TecSubjectChoose;
import Service.Student.StudentSurfaceService;
import com.itextpdf.text.DocumentException;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class StuSubjectView extends JFrame {
    public StuSubjectView() {
        initComponents();
    }

    public void button_init(){
        subjecSelect.setFocusPainted(false);
    }
    public void UI_Init(){
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        button_init();
    }
    private void returnBtActionPerformed(ActionEvent e) {
        new StuView().UI_Init();
        dispose();
    }

    private void subjectChooseActionPerformed(ActionEvent e) {
        boolean b = new StudentSurfaceService().stu_sub_isSelect_judge(StuView.stu_id);
        if (b)
        {
            JOptionPane.showMessageDialog(this,"本学期你已经选择过课程");
        }else {
            new StuSubjectChoose().UI_init();
            dispose();
        }
    }

    private void subjecSelectActionPerformed(ActionEvent e) throws IOException, DocumentException {
        boolean b = new StudentSurfaceService().stu_sub_isSelect_judge(StuView.stu_id);
        if (b)
        {
            new StuSubjectSeek().UI_init();
            dispose();
        }else {
            JOptionPane.showMessageDialog(this,"本学期您尚未选择课程，请先选择课程");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        head = new JLabel();
        subjecSelect = new JButton();
        subjectChoose = new JButton();
        returnBt = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- head ----
        head.setText("\u8bfe\u7a0b\u7ba1\u7406");
        head.setFont(head.getFont().deriveFont(head.getFont().getSize() + 10f));

        //---- subjecSelect ----
        subjecSelect.setText("\u8bfe\u7a0b\u67e5\u8be2");
        subjecSelect.addActionListener(e -> {
            try {
                subjecSelectActionPerformed(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (DocumentException documentException) {
                documentException.printStackTrace();
            }
        });

        //---- subjectChoose ----
        subjectChoose.setText("\u8bfe\u7a0b\u9009\u62e9");
        subjectChoose.addActionListener(e -> subjectChooseActionPerformed(e));

        //---- returnBt ----
        returnBt.setText("\u8fd4\u56de");
        returnBt.addActionListener(e -> returnBtActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(head, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(192, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(subjecSelect, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(subjectChoose, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 13, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(298, Short.MAX_VALUE)
                            .addComponent(returnBt)))
                    .addGap(82, 82, 82))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(head, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(subjecSelect, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addComponent(subjectChoose, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                    .addComponent(returnBt)
                    .addGap(55, 55, 55))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel head;
    private JButton subjecSelect;
    private JButton subjectChoose;
    private JButton returnBt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
