package Dao.DaoImpl.TeacherSurfaceImpl;

import Dao.TeacherSurface.TecSurfaceInterface;
import Model.StuAdd;
import Model.StuScoreInfo;
import Model.SubjectInfo;
import Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class TecSurfaceDaoImpl implements TecSurfaceInterface {
    @Override
    public String college_name_find(String tec_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = "select tec_college from tec_info where tec_id=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tec_id);
            res = pstm.executeQuery();
            while (res.next()) {
                return res.getString("tec_college");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return null;
    }

    @Override
    public String[] subject_name_find(String college_name) {
        String[] sub_name = new String[10];
        List<String> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = null;
        if (college_name.equals("计算机科学与技术"))
            sql = "select subject_name from computer_subject";
        else if (college_name.equals("合肥推拿"))
            sql = "select subject_name from tuina_subject";
        else if (college_name.equals("电子竞技"))
            sql = "select subject_name from game_subject";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            res = pstm.executeQuery();
            while (res.next()) {
                list.add(res.getString("subject_name"));
            }
            for (int i = 0; i < list.size(); i++) {
                sub_name[i] = list.get(i);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return sub_name;
    }

    /**
     * 这里有一些优化问题，暂未去改，但不影响运行，我将第一次优化写在了学生端
     *
     * @param subjectNameInfoList
     */
    @Override
    public void subject_info_input(List<SubjectInfo> subjectNameInfoList) {
        if (subjectNameInfoList.size() == 2) {
            String subject_name1 = subjectNameInfoList.get(0).getSubject_name();
            String subject_name2 = subjectNameInfoList.get(1).getSubject_name();
            String college_name = subjectNameInfoList.get(0).getCollege();
            String tec_num = subjectNameInfoList.get(0).getTec_num();
            Connection conn = null;
            PreparedStatement pstm1 = null;
            PreparedStatement pstm2 = null;
            String sql1 = null;
            String sql2 = null;
            if (college_name.equals("计算机科学与技术")) {
                sql1 = "UPDATE computer_subject SET tec_num=? WHERE subject_name=?";
                sql2 = "UPDATE computer_subject SET tec_num=? WHERE subject_name=?";
            } else if (college_name.equals("合肥推拿")) {
                sql1 = "UPDATE tuina_subject SET tec_num=? WHERE subject_name=?";
                sql2 = "UPDATE tuina_subject SET tec_num=? WHERE subject_name=?";
            } else if (college_name.equals("电子竞技")) {
                sql1 = "UPDATE game_subject SET tec_num=? WHERE subject_name=?";
                sql2 = "UPDATE game_subject SET tec_num=? WHERE subject_name=?";
            }
            try {
                conn = JDBCUtils.getConnection();
                pstm1 = conn.prepareStatement(sql1);
                pstm2 = conn.prepareStatement(sql2);
                pstm1.setString(1, tec_num);
                pstm1.setString(2, subject_name1);
                pstm2.setString(1, tec_num);
                pstm2.setString(2, subject_name2);
                pstm1.executeUpdate();
                pstm2.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(pstm1, conn);
                JDBCUtils.close(pstm2, conn);
            }
        } else {
            String subject_name1 = subjectNameInfoList.get(0).getSubject_name();
            String college_name = subjectNameInfoList.get(0).getCollege();
            String tec_num = subjectNameInfoList.get(0).getTec_num();
            Connection conn = null;
            PreparedStatement pstm1 = null;
            String sql1 = null;
            String sql2 = null;
            if (college_name.equals("计算机科学与技术")) {
                sql1 = "UPDATE computer_subject SET tec_num=? WHERE subject_name=?";
            } else if (college_name.equals("合肥推拿")) {
                sql1 = "UPDATE tuina_subject SET tec_num=? WHERE subject_name=?";
            } else if (college_name.equals("电子竞技")) {
                sql1 = "UPDATE game_subject SET tec_num=? WHERE subject_name=?";
            }
            try {
                conn = JDBCUtils.getConnection();
                pstm1 = conn.prepareStatement(sql1);
                pstm1.setString(1, tec_num);
                pstm1.setString(2, subject_name1);
                pstm1.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(pstm1, conn);
            }
        }
    }

    @Override
    public List<String> subject_info_input_judge(List<SubjectInfo> subjectNameInfoListJudge) {
        List<String> stringList = new ArrayList<>();
        String college_name = subjectNameInfoListJudge.get(0).getCollege();
        if (subjectNameInfoListJudge.size() == 2) {
            String subject_name1 = subjectNameInfoListJudge.get(0).getSubject_name();
            String subject_name2 = subjectNameInfoListJudge.get(1).getSubject_name();
            Connection conn = null;
            PreparedStatement pstm1 = null;
            ResultSet res1 = null;
            String sql1 = null;
            if (college_name.equals("计算机科学与技术")) {
                sql1 = "select * from computer_subject where subject_name=? or subject_name=?";
            } else if (college_name.equals("合肥推拿")) {
                sql1 = "select * from tuina_subject where subject_name=? or subject_name=?";
            } else if (college_name.equals("电子竞技")) {
                sql1 = "select * from game_subject where subject_name=? or subject_name=?";
            }
            try {
                conn = JDBCUtils.getConnection();
                pstm1 = conn.prepareStatement(sql1);
                pstm1.setString(1, subject_name1);
                pstm1.setString(2, subject_name2);
                res1 = pstm1.executeQuery();
                while (res1.next()) {
                    if (res1.getString("tec_num") != null) {
                        stringList.add(res1.getString("subject_name"));
                    }
                }
                for (String s1 : stringList) {
                    System.out.println(s1);
                }
                return stringList;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(res1, pstm1, conn);
            }
        } else {
            String subject_name1 = subjectNameInfoListJudge.get(0).getSubject_name();
            Connection conn = null;
            PreparedStatement pstm1 = null;
            ResultSet res1 = null;
            String sql1 = null;
            if (college_name.equals("计算机科学与技术")) {
                sql1 = "select * from computer_subject where subject_name=?";
            } else if (college_name.equals("合肥推拿")) {
                sql1 = "select * from tuina_subject where subject_name=?";
            } else if (college_name.equals("电子竞技")) {
                sql1 = "select * from game_subject where subject_name=?";
            }
            try {
                conn = JDBCUtils.getConnection();
                pstm1 = conn.prepareStatement(sql1);
                pstm1.setString(1, subject_name1);
                res1 = pstm1.executeQuery();
                while (res1.next()) {
                    if (res1.getString("tec_num") != null) {
                        stringList.add(res1.getString("subject_name"));
                    }
                }
                for (String s1 : stringList) {
                    System.out.println(s1);
                }
                return stringList;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(res1, pstm1, conn);
            }

        }
        return null;
    }

    @Override
    public boolean subject_isSelect_judge(String tec_id, String tec_college) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = null;
        if (tec_college.equals("计算机科学与技术")) {
            sql = "select tec_num from computer_subject where tec_num=?";
        } else if (tec_college.equals("合肥推拿")) {
            sql = "select tec_num from tuina_subject where tec_num=?";
        } else if (tec_college.equals("电子竞技")) {
            sql = "select tec_num from game_subject where tec_num=?";
        }
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tec_id);
            res = pstm.executeQuery();
            while (res.next()) {
                if (res.getString("tec_num") != null)
                    return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return false;
    }

    @Override
    public List<String> subject_info_get(String tec_college, String tec_id) {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = null;
        String name = null;
        if (tec_college.equals("计算机科学与技术")) {
            sql = "SELECT * FROM tec_info,computer_subject WHERE tec_num=tec_id AND tec_num=?";
        } else if (tec_college.equals("合肥推拿")) {
            sql = "SELECT * FROM tec_info,tuina_subject WHERE tec_num=tec_id AND tec_num=?";
        } else if (tec_college.equals("电子竞技")) {
            sql = "SELECT * FROM tec_info,game_subject WHERE tec_num=tec_id AND tec_num=?";
        }
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tec_id);
            res = pstm.executeQuery();
            while (res.next()) {
                name = res.getString("tec_name");
                list.add(res.getString("subject_name"));
            }
            list.add(name);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return null;
    }

    @Override
    public Object[][] score_input(String tec_college, String tec_id) {
        Object data[][];
        String sql = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        if (tec_college.equals("计算机科学与技术")) {
            sql = "SELECT stu_id,NAME,com.`subject_name`,score FROM stu_subject_info stu,computer_subject com ,stu_info WHERE " +
                    "stu.`subject_name`=com.`subject_name` " +
                    "AND stu.`stu_num`=stu_info.`stu_id` " +
                    "AND com.`tec_num`=?";
        } else if (tec_college.equals("合肥推拿")) {
            sql = "SELECT stu_id,NAME,com.`subject_name`,score FROM stu_subject_info stu,tuina_subject com ,stu_info WHERE " +
                    "stu.`subject_name`=com.`subject_name` " +
                    "AND stu.`stu_num`=stu_info.`stu_id` " +
                    "AND com.`tec_num`=?";
        } else if (tec_college.equals("电子竞技")) {
            sql = "SELECT stu_id,NAME,com.`subject_name`,score FROM stu_subject_info stu,game_subject com ,stu_info WHERE " +
                    "stu.`subject_name`=com.`subject_name` " +
                    "AND stu.`stu_num`=stu_info.`stu_id` " +
                    "AND com.`tec_num`=?";
        }
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tec_id);
            res = pstm.executeQuery();
            res.last();
            data = new Object[res.getRow()][4];
            int i = 0;
            res.beforeFirst();
            while (res.next()) {
                String stu_id = res.getString("stu_id");
                String name = res.getString("name");
                String subject_name = res.getString("subject_name");
                Double score = res.getDouble("score");;
                data[i][0] = stu_id;
                data[i][1] = name;
                data[i][2] = subject_name;
                if (score==0.0)
                    data[i][3] = "暂未批改";
                else
                    data[i][3]=score;
                i++;
            }
            return data;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return null;
    }

    @Override
    public void score_input_really(List<StuScoreInfo> list, String tec_college) {
        String sql = "UPDATE stu_subject_info SET score=? WHERE stu_num=? AND subject_name=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                pstm.setDouble(1, list.get(i).getScore());
                pstm.setString(2, list.get(i).getStu_id());
                pstm.setString(3, list.get(i).getSubject_name());
                pstm.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }

    @Override
    public List<String> subject_name_get(String tec_college, String tec_id) {
        List<String> list_name = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = null;
        if (tec_college.equals("计算机科学与技术")) {
            sql = "SELECT * FROM tec_info,computer_subject WHERE tec_num=tec_id AND tec_num=?";
        } else if (tec_college.equals("合肥推拿")) {
            sql = "SELECT * FROM tec_info,tuina_subject WHERE tec_num=tec_id AND tec_num=?";
        } else if (tec_college.equals("电子竞技")) {
            sql = "SELECT * FROM tec_info,game_subject WHERE tec_num=tec_id AND tec_num=?";
        }
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tec_id);
            res = pstm.executeQuery();
            while (res.next()) {
                list_name.add(res.getString("subject_name"));
            }
            return list_name;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return null;
    }

    @Override
    public Object[][] stu_info_manage_Dao(String comboSelect, String textfield, String tec_id, String tec_college) {
        Object data[][];
        String sql = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        if (tec_college.equals("计算机科学与技术")) {
            if (comboSelect.equals("学号")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM computer_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.stu_id=?";
            } else if (comboSelect.equals("姓名")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM computer_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.name=?";
            } else if (comboSelect.equals("课程")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM computer_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.subject_name=?";
            }
        } else if (tec_college.equals("合肥推拿")) {
            if (comboSelect.equals("学号")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM tuina_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.stu_id=?";
            } else if (comboSelect.equals("姓名")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM tuina_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.name=?";
            } else if (comboSelect.equals("课程")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM tuina_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.subject_name=?";
            }
        } else if (tec_college.equals("电子竞技")) {
            if (comboSelect.equals("学号")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM game_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.stu_id=?";
            } else if (comboSelect.equals("姓名")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM game_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.name=?";
            } else if (comboSelect.equals("课程")) {
                sql = "SELECT * FROM(SELECT stu_id,NAME,com.subject_name,score FROM game_subject com,stu_subject_info stu_sub,stu_info stu " +
                        "WHERE com.`tec_num`=? " +
                        "AND com.`subject_name`=stu_sub.`subject_name`" +
                        "AND stu.`stu_id`=stu_sub.`stu_num`) tab " +
                        "WHERE tab.subject_name=?";
            }
        }
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tec_id);
            pstm.setString(2, textfield);
            res = pstm.executeQuery();
            res.last();
            data = new Object[res.getRow()][4];
            int i = 0;
            res.beforeFirst();
            while (res.next()) {
                String stu_id = res.getString("stu_id");
                String name = res.getString("name");
                String subject_name = res.getString("subject_name");
                Double score = res.getDouble("score");
                data[i][0] = stu_id;
                data[i][1] = name;
                data[i][2] = subject_name;
                data[i][3] = score;
                i++;
            }
            return data;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return new Object[0][];
    }

    @Override
    public void stu_subject_del(String stu_id, String stu_subject) {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "delete from stu_subject_info where stu_num=? and subject_name=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, stu_id);
            pstm.setString(2, stu_subject);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }

    @Override
    public void stu_subject_add(StuAdd stuAdd) {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert into stu_subject_info(stu_num,subject_name) value(?,?)";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, stuAdd.getStu_id());
            pstm.setString(2, stuAdd.getSubject());
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }

    @Override
    public boolean stu_subject_add_judge(StuAdd stuAdd) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = "select * from stu_subject_info where stu_num=? and subject_name=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, stuAdd.getStu_id());
            pstm.setString(2, stuAdd.getSubject());
            res = pstm.executeQuery();
            while (res.next()) {
                if (res.getString("subject_name") != null) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return false;
    }

    @Override
    public boolean stu_subject_add_judgePlus(String stu_id, String tec_college) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = "select * from stu_info where stu_id=? and colloege=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, stu_id);
            pstm.setString(2, tec_college);
            res = pstm.executeQuery();
            while (res.next()) {
                if (res.getString("stu_id") != null) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return false;
    }

    @Override
    public boolean stu_subject_add_judgePlus_idAndName(String stu_id, String name) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = "select * from stu_info where stu_id=? and name=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, stu_id);
            pstm.setString(2, name);
            res = pstm.executeQuery();
            while (res.next()) {
                if (res.getString("stu_id") != null) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return false;
    }

    @Override
    public boolean stu_subject_add_judgePlus_sub(String stu_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql = "select * from stu_subject_info where stu_num=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, stu_id);
            res = pstm.executeQuery();
            res.last();
            int row = res.getRow();
            if (row >= 0 && row < 3) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return false;
    }
}
