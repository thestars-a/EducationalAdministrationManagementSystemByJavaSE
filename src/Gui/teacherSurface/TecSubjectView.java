/*
 * Created by JFormDesigner on Sun Mar 14 21:28:07 CST 2021
 */

package Gui.teacherSurface;

import Gui.studentSurface.StuSubjectSeek;
import Gui.studentSurface.StuView;
import Service.Student.StudentSurfaceService;
import Service.Teacher.TecSurfaceService;
import com.itextpdf.text.DocumentException;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author s
 */
public class TecSubjectView extends JFrame {
    /*发现后边选课需要这个学院，如果不想后边多次查询的时候就在这里给它设置好值，有些地方我就懒得改了
     所以我就提个醒*/
    private String college;
    public TecSubjectView() {
        initComponents();
    }
    public void button_init(){
        button1.setFocusPainted(false);
    }

    public void UI_Init(){
        setResizable(false);
        setVisible(true);
        button_init();
        setDefaultCloseOperation(3);
        college=new TecSurfaceService().tec_college_get(TecView.tec_id);
    }
    private void return_btActionPerformed(ActionEvent e) {
        new TecView().UI_Init();
        dispose();
    }

    private void subjectChooserActionPerformed(ActionEvent e) {
        boolean b = new TecSurfaceService().tec_sub_isSelect_judge(TecView.tec_id, college);
        if (b)
        {
            JOptionPane.showMessageDialog(this,"本学期你已经选择过课程");
        }else {
            new TecSubjectChoose().UI_init();
            dispose();
        }
    }

    /**
     * 这里竟然遇到个bug，不过已经修改，如果我复制另一个按钮，然后修改名字以及监听函数名字和内容，但运行后还是会
     * 运行复制那个按钮的监听事件，无语plus
     * @param e
     */
    private void button1ActionPerformed(ActionEvent e) throws IOException, DocumentException {
        boolean b = new TecSurfaceService().tec_sub_isSelect_judge(TecView.tec_id,college);
        if (b)
        {
            new TecSubjectSeek().UI_init();
            dispose();
        }else {
            JOptionPane.showMessageDialog(this,"本学期您尚未选择课程，请先选择课程");
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        head = new JLabel();
        subjectChooser = new JButton();
        return_bt = new JButton();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- head ----
        head.setText("\u8bfe\u7a0b\u7ba1\u7406");
        head.setFont(head.getFont().deriveFont(head.getFont().getSize() + 10f));

        //---- subjectChooser ----
        subjectChooser.setText("\u8bfe\u7a0b\u9009\u62e9");
        subjectChooser.addActionListener(e -> subjectChooserActionPerformed(e));

        //---- return_bt ----
        return_bt.setText("\u8fd4\u56de");
        return_bt.addActionListener(e -> return_btActionPerformed(e));

        //---- button1 ----
        button1.setText("\u8bfe\u7a0b\u4fe1\u606f");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (DocumentException documentException) {
                documentException.printStackTrace();
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(161, 161, 161)
                            .addComponent(head, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(subjectChooser, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(31, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 261, Short.MAX_VALUE)
                    .addComponent(return_bt)
                    .addGap(94, 94, 94))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(head, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(subjectChooser, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                    .addComponent(return_bt)
                    .addGap(56, 56, 56))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel head;
    private JButton subjectChooser;
    private JButton return_bt;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
