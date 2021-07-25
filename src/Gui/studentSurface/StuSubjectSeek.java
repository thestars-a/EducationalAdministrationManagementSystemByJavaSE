/*
 * Created by JFormDesigner on Thu Mar 18 13:51:26 CST 2021
 */

package Gui.studentSurface;

import java.awt.event.*;
import Service.Student.StudentSurfaceService;
import Service.Teacher.TecSurfaceService;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * @author s
 */
public class StuSubjectSeek extends JFrame {

    private static Object[][] rowDataOut;
    private static String[][] strings;

    public void UI_init() throws IOException, DocumentException {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        setRowData();
        table_init();
        //生成pdf
        createPdf();
    }
    private void setRowData()
    {
        String[] lists_subjectInfo = new StudentSurfaceService().stu_sub_info_tecName_get
                (StuView.stu_id,new StudentSurfaceService().student_info_find(StuView.stu_id)[3]);
         strings = new String[][]{
                 {"时间","星期一","星期二","星期三","星期四","星期五"},
                 {"上午06:00-07:00", lists_subjectInfo[0], lists_subjectInfo[4], lists_subjectInfo[9], lists_subjectInfo[3], lists_subjectInfo[0]},
                 {"上午07:20-08:20", lists_subjectInfo[1], lists_subjectInfo[3], lists_subjectInfo[8], lists_subjectInfo[1], lists_subjectInfo[1]},
                 {"上午08:40-10:00", lists_subjectInfo[2], lists_subjectInfo[1], lists_subjectInfo[7], lists_subjectInfo[5], lists_subjectInfo[2]},
                 {"上午10:20-12:00", lists_subjectInfo[3], lists_subjectInfo[2], lists_subjectInfo[6], lists_subjectInfo[2], lists_subjectInfo[3]},
                 {"下午13:00-14:00", lists_subjectInfo[4], lists_subjectInfo[0], lists_subjectInfo[5], lists_subjectInfo[9], lists_subjectInfo[4]},
                 {"下午14:20-15:20", lists_subjectInfo[5], lists_subjectInfo[6], lists_subjectInfo[4], lists_subjectInfo[0], lists_subjectInfo[5]},
                 {"下午15:40-17:00", lists_subjectInfo[6], lists_subjectInfo[9], lists_subjectInfo[3], lists_subjectInfo[6], lists_subjectInfo[6]},
                 {"下午17:00-18:00", lists_subjectInfo[7], lists_subjectInfo[7], lists_subjectInfo[2], lists_subjectInfo[7], lists_subjectInfo[7]},
                 {"下午20:00-21:00", lists_subjectInfo[8], lists_subjectInfo[8], lists_subjectInfo[1], lists_subjectInfo[4], lists_subjectInfo[8]},
                 {"下午21:00-21:40", lists_subjectInfo[9], lists_subjectInfo[5], lists_subjectInfo[0], lists_subjectInfo[8], lists_subjectInfo[9]}};
    }

    private void table_init() {
        table1.setModel(new MyTableModelSeek());
        table1.setDefaultRenderer(Object.class, new TableCellTextAreaRenderers());
    }

    public static class MyTableModelSeek extends AbstractTableModel {
        //这里的学生Id和学院一定要正确，不然有bug
        String[] lists_subjectInfo = new StudentSurfaceService().stu_sub_info_tecName_get
                (StuView.stu_id,new StudentSurfaceService().student_info_find(StuView.stu_id)[3]);
        private Object[] columnNames = {"时间","星期一","星期二","星期三","星期四","星期五"};
        private Object[][] rowData = {
                {"上午06:00-07:00",lists_subjectInfo[0],lists_subjectInfo[4],lists_subjectInfo[9],lists_subjectInfo[3],lists_subjectInfo[0]},
                {"上午07:20-08:20",lists_subjectInfo[1],lists_subjectInfo[3],lists_subjectInfo[8],lists_subjectInfo[1],lists_subjectInfo[1]},
                {"上午08:40-10:00",lists_subjectInfo[2],lists_subjectInfo[1],lists_subjectInfo[7],lists_subjectInfo[5],lists_subjectInfo[2]},
                {"上午10:20-12:00",lists_subjectInfo[3],lists_subjectInfo[2],lists_subjectInfo[6],lists_subjectInfo[2],lists_subjectInfo[3]},
                {"下午13:00-14:00",lists_subjectInfo[4],lists_subjectInfo[0],lists_subjectInfo[5],lists_subjectInfo[9],lists_subjectInfo[4]},
                {"下午14:20-15:20",lists_subjectInfo[5],lists_subjectInfo[6],lists_subjectInfo[4],lists_subjectInfo[0],lists_subjectInfo[5]},
                {"下午15:40-17:00",lists_subjectInfo[6],lists_subjectInfo[9],lists_subjectInfo[3],lists_subjectInfo[6],lists_subjectInfo[6]},
                {"下午17:00-18:00",lists_subjectInfo[7],lists_subjectInfo[7],lists_subjectInfo[2],lists_subjectInfo[7],lists_subjectInfo[7]},
                {"下午20:00-21:00",lists_subjectInfo[8],lists_subjectInfo[8],lists_subjectInfo[1],lists_subjectInfo[4],lists_subjectInfo[8]},
                {"下午21:00-21:40",lists_subjectInfo[9],lists_subjectInfo[5],lists_subjectInfo[0],lists_subjectInfo[8],lists_subjectInfo[9]}};


        @Override
        public int getRowCount() {
            return rowData.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column].toString();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rowData[rowIndex][columnIndex];
        }
    }

    public StuSubjectSeek() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        new StuSubjectView().UI_Init();
        dispose();
    }

    private void createPdf() throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("StudentSub.pdf"));
        document.open();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);//设置中文字体
        com.itextpdf.text.Font headFont =  new com.itextpdf.text.Font(bfChinese, 10, Font.NORMAL);//设置字体大小
        PdfPTable table = new PdfPTable(6);
        String[][] str =strings;
        for (int i = 0; i < 11; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                PdfPCell cell=new PdfPCell(new Paragraph(str[i][i1],headFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);//设置内容水平居中显示
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setFixedHeight(40);
                table.addCell(cell);
            }
        }
        document.add(table);
        document.close();
    }


    private void label1MouseClicked(MouseEvent e){
        //打开pdf
        Process p = null;
        try {
            p = Runtime
                    .getRuntime()
                    .exec("rundll32 url.dll,FileProtocolHandler StudentSub.pdf");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            p.waitFor();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setRowHeight(40);
            table1.setPreferredScrollableViewportSize(new Dimension(550, 400));
            table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 5f));
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- label1 ----
        label1.setText("\u5bfc\u51fa\u8bfe\u8868");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
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
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 585, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(28, 28, 28))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 792, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(label1))
                    .addGap(10, 10, 10))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
class TableCellTextAreaRenderers extends JTextArea implements TableCellRenderer {
    public TableCellTextAreaRenderers() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        // 计算当下行的最佳高度
        int maxPreferredHeight = 45;
        if (table.getRowHeight(row) != maxPreferredHeight)  // 少了这行则处理器瞎忙
            table.setRowHeight(row, maxPreferredHeight);
        setText(value == null ? "" : value.toString());
        return this;
    }
}
