/*
 * Created by JFormDesigner on Thu Mar 18 18:41:31 CST 2021
 */

package Gui.teacherSurface;

import java.awt.*;

import Service.Teacher.TecSurfaceService;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @author s
 */
public class TecSubjectSeek extends JFrame {

    private static String[][] strings;
    public TecSubjectSeek() {
        initComponents();
    }


    public void UI_init() throws IOException, DocumentException {
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        tecSetRowData();
        table_init();
        tecCreatePdf();
    }

    public void table_init() {
        table1.setModel(new MyTableModelSeekTec());
        table1.setDefaultRenderer(Object.class, new TableCellTextAreaRendererss());
    }
    public static class MyTableModelSeekTec extends AbstractTableModel {
        String[] lists_subjectInfo = new TecSurfaceService().tec_sub_info_get
                (new TecSurfaceService().tec_college_get(TecView.tec_id),TecView.tec_id);
        private Object[] columnNames = {"时间","星期一","星期二","星期三","星期四","星期五"};
        private Object[][] rowData = {
                {"上午06:00-07:00",lists_subjectInfo[0],lists_subjectInfo[4],lists_subjectInfo[9],lists_subjectInfo[3],lists_subjectInfo[0]},
                {"上午07:20-08:20",lists_subjectInfo[1],lists_subjectInfo[3],lists_subjectInfo[8],lists_subjectInfo[1],lists_subjectInfo[1]},
                {"上午08:40-10:00",lists_subjectInfo[2],lists_subjectInfo[1],lists_subjectInfo[7],lists_subjectInfo[5],lists_subjectInfo[2]},
                {"上午10:20-12:00",lists_subjectInfo[3],lists_subjectInfo[2],lists_subjectInfo[6],lists_subjectInfo[2],lists_subjectInfo[3]},
                {"下午13:00-14:00",lists_subjectInfo[4],lists_subjectInfo[0],lists_subjectInfo[5],lists_subjectInfo[9],lists_subjectInfo[4]},
                {"下午14:20-15:20",lists_subjectInfo[5],lists_subjectInfo[6],lists_subjectInfo[4],lists_subjectInfo[0],lists_subjectInfo[5]},
                {"下午15:40-17:00",lists_subjectInfo[6],lists_subjectInfo[9],lists_subjectInfo[3],lists_subjectInfo[6],lists_subjectInfo[6]},
                {"下午17:00-18:00",lists_subjectInfo[7],lists_subjectInfo[7],lists_subjectInfo[5],lists_subjectInfo[7],lists_subjectInfo[7]},
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

    private void button1ActionPerformed(ActionEvent e) {
        new TecSubjectView().UI_Init();
        dispose();
    }
    private void tecSetRowData()
    {
        String[] lists_subjectInfo = new TecSurfaceService().tec_sub_info_get
                (new TecSurfaceService().tec_college_get(TecView.tec_id),TecView.tec_id);
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

    private void tecCreatePdf() throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("TeacherSub.pdf"));
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

    private void label1MouseClicked(MouseEvent e) {
        Process p = null;
        try {
            p = Runtime
                    .getRuntime()
                    .exec("rundll32 url.dll,FileProtocolHandler TeacherSub.pdf");
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
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setRowHeight(40);
            table1.setPreferredScrollableViewportSize(new Dimension(550, 400));
            table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 5f));
            scrollPane1.setViewportView(table1);
        }

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
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(15, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 792, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 559, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(22, 22, 22))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(10, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(16, 16, 16))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

class TableCellTextAreaRendererss extends JTextArea implements TableCellRenderer {
    public TableCellTextAreaRendererss() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        // 计算当下行的最佳高度
        int maxPreferredHeight = 45;
        if (table.getRowHeight(row) != maxPreferredHeight)  // 关键
            table.setRowHeight(row, maxPreferredHeight);
        setText(value == null ? "" : value.toString());
        return this;
    }
}
