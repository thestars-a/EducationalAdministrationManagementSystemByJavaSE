package Dao.DaoImpl.StudentSurfaceImpl;

import Dao.StudentSurface.StudentSurfaceInterface;
import Model.SubjectInfo;
import Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class StudentSurfaceDaoImpl implements StudentSurfaceInterface {

    @Override
    public String[] studentInfo_Dao(String stu_only_id) {
        String[] info = new String[6];
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet res=null;
        String sql= "select stu_id,name,sex,colloege,secret_que,secret_ans from stu_info";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            res = pstm.executeQuery();
            while(res.next())
            {
                if (stu_only_id.equals(res.getString("stu_id")))
                {
                    info[0]=res.getString("stu_id");
                    info[1]=res.getString("name");
                    info[2]=res.getString("sex");
                    info[3]=res.getString("colloege");
                    info[4]=res.getString("secret_que");
                    info[5]=res.getString("secret_ans");
                    return info;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(res,pstm,conn);
        }
        return new String[0];
    }

    @Override
    public int studentPasswordJudge_Dao(String old_password,String stu_id) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet res=null;
        String sql="select password from stu_login where username=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,stu_id);
            res = pstm.executeQuery();
            while (res.next())
            {
                if (old_password.equals(res.getString("password")))
                {
                    return 1;
                }else {
                    return 0;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(res,pstm,conn);
        }
        return 0;
    }

    @Override
    //这里有无返回值都行，为了方便选择void 真实开发考虑int
    public void studentPasswordUpdate_Dao(String new_password,String stu_id) {
        Connection conn=null;
        PreparedStatement pstm=null;
        String sql="update stu_login set password=? where username=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,new_password);
            pstm.setString(2,stu_id);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(pstm,conn);
        }
    }

    @Override
    public void studenInfoUpdate_Dao(String stu_id,String stu_name, String stu_sex, String secret_que, String secret_ans) {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "update stu_info set name=?,sex=?,secret_que=?,secret_ans=? where stu_id=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, stu_name);
            pstm.setString(2, stu_sex);
            pstm.setString(3, secret_que);
            pstm.setString(4, secret_ans);
            pstm.setString(5,stu_id);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }

    /**
     * 这个函数没有写好，但是我想早点完工，这里有待优化，希望以后有机会优化
     * @param subjectNameInfoList
     */
    @Override
    public void student_subject_info_input(List<SubjectInfo> subjectNameInfoList) {
        SubjectInfo s1 = new SubjectInfo();
        SubjectInfo s2 = new SubjectInfo();
        SubjectInfo s3 = new SubjectInfo();
        String sql1 = null;
        String sql2 = null;
        String sql3 = null;
        Connection conn = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        PreparedStatement pstm3 = null;
        if (subjectNameInfoList.size()==3)
        {
            s1=subjectNameInfoList.get(0);
            s2=subjectNameInfoList.get(1);
            s3=subjectNameInfoList.get(2);
            sql1="insert into stu_subject_info(stu_num,subject_name) values(?,?)";
            sql2="insert into stu_subject_info(stu_num,subject_name) values(?,?)";
            sql3="insert into stu_subject_info(stu_num,subject_name) values(?,?)";
        }else if(subjectNameInfoList.size()==2){
            s1=subjectNameInfoList.get(0);
            s2=subjectNameInfoList.get(1);
            sql1="insert into stu_subject_info(stu_num,subject_name) values(?,?)";
            sql2="insert into stu_subject_info(stu_num,subject_name) values(?,?)";
        }else if (subjectNameInfoList.size()==1){
            s1=subjectNameInfoList.get(0);
            sql1="insert into stu_subject_info(stu_num,subject_name) values(?,?)";
        }
        try {
            conn = JDBCUtils.getConnection();
            if (subjectNameInfoList.size()==3){
                pstm1 = conn.prepareStatement(sql1);
                pstm2 = conn.prepareStatement(sql2);
                pstm3 = conn.prepareStatement(sql3);
                pstm1.setString(1,s1.getTec_num());
                pstm1.setString(2,s1.getSubject_name());
                pstm2.setString(1,s2.getTec_num());
                pstm2.setString(2,s2.getSubject_name());
                pstm3.setString(1,s3.getTec_num());
                pstm3.setString(2,s3.getSubject_name());
                pstm1.executeUpdate();
                pstm2.executeUpdate();
                pstm3.executeUpdate();
            }else if (subjectNameInfoList.size()==2)
            {
                pstm1 = conn.prepareStatement(sql1);
                pstm2 = conn.prepareStatement(sql2);
                pstm1.setString(1,s1.getTec_num());
                pstm1.setString(2,s1.getSubject_name());
                pstm2.setString(1,s2.getTec_num());
                pstm2.setString(2,s2.getSubject_name());
                pstm1.executeUpdate();
                pstm2.executeUpdate();
            }else if (subjectNameInfoList.size()==1)
            {
                pstm1 = conn.prepareStatement(sql1);
                pstm1.setString(1,s1.getTec_num());
                pstm1.setString(2,s1.getSubject_name());
                pstm1.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (subjectNameInfoList.size()==3)
            {
                JDBCUtils.close(pstm1, conn);
                JDBCUtils.close(pstm2, conn);
                JDBCUtils.close(pstm3, conn);
            }else if(subjectNameInfoList.size()==2){
                JDBCUtils.close(pstm1, conn);
                JDBCUtils.close(pstm2, conn);
            }else if (subjectNameInfoList.size()==1){
                JDBCUtils.close(pstm1, conn);
            }
        }
    }

    @Override
    public boolean student_subject_isSelect_judge(String stu_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql="select stu_num from stu_subject_info where stu_num=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,stu_id);
            res = pstm.executeQuery();
            while (res.next()) {
                if (res.getString("stu_num")!=null)
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
    public List<String> student_subject_info_subName_Dao(String stu_id) {
        List<String> list_subName = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql="select * from stu_subject_info where stu_num=?";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,stu_id);
            res = pstm.executeQuery();
            while (res.next()) {
                list_subName.add(res.getString("subject_name"));
            }
            return list_subName;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return null;
    }

    @Override
    public Object[][] student_score_seek_Dao(String stu_id) {
        Object data[][];
        String sql="SELECT * FROM stu_subject_info,stu_info WHERE stu_id=? AND stu_id =stu_num";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,stu_id);
            res = pstm.executeQuery();
            res.last();
            data=new Object[res.getRow()][4];
            int i = 0;
            res.beforeFirst();
            while (res.next()) {
                String name=res.getString("name");
                String subject_name=res.getString("subject_name");
                Double score=res.getDouble("score");
                data[i][0]=stu_id;
                data[i][1]=name;
                data[i][2]=subject_name;
                if (score==0.0)
                {
                    data[i][3]="暂未批改";
                }else {
                    data[i][3] = score;
                }
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
    public List<List<String>> student_subject_info_tecName_Dao(List<String> collegeName,String college_name) {
        String subName1=null;
        String subName2=null;
        String subName3=null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String sql=null;
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        List<List<String>> lists=new ArrayList<>();
        if (collegeName.size()==1)
        {
            subName1=collegeName.get(0);
            if (college_name.equals("计算机科学与技术")) {
                sql = "select * from tec_info,computer_subject where subject_name=? and tec_num=tec_id";
            } else if (college_name.equals("合肥推拿")) {
                sql = "select * from tec_info,tuina_subject where subject_name=? and tec_num=tec_id";

            } else if (college_name.equals("电子竞技")) {
                sql = "select * from tec_info,game_subject where subject_name=? and tec_num=tec_id";
            }
        }else if (collegeName.size()==2){
            subName1=collegeName.get(0);
            subName2=collegeName.get(1);
            if (college_name.equals("计算机科学与技术")) {
                sql = "SELECT * FROM tec_info,computer_subject where (subject_name=? OR subject_name=?) AND tec_id=tec_num";
            } else if (college_name.equals("合肥推拿")) {
                sql = "select * from tec_info,tuina_subject where (subject_name=? OR subject_name=?) AND tec_id=tec_num";

            } else if (college_name.equals("电子竞技")) {
                sql = "select * from tec_info,game_subject where (subject_name=? OR subject_name=?) AND tec_id=tec_num";
            }
        }else if (collegeName.size()==3)
        {
            subName1=collegeName.get(0);
            subName2=collegeName.get(1);
            subName3=collegeName.get(2);
            if (college_name.equals("计算机科学与技术")) {
                sql = "select * from tec_info,computer_subject where (subject_name=? OR subject_name=? OR subject_name=?) AND tec_id=tec_num";
            } else if (college_name.equals("合肥推拿")) {
                sql = "select * from tec_info,tuina_subject where (subject_name=? OR subject_name=? OR subject_name=?) AND tec_id=tec_num";
            } else if (college_name.equals("电子竞技")) {
                sql = "select * from tec_info,game_subject where (subject_name=? OR subject_name=? OR subject_name=?) AND tec_id=tec_num";
            }
        }
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            if (collegeName.size()==1)
            {
                pstm.setString(1,subName1);
            }else if (collegeName.size()==2)
            {
                pstm.setString(1,subName1);
                pstm.setString(2,subName2);
            }else if (collegeName.size()==3)
            {
                pstm.setString(1,subName1);
                pstm.setString(2,subName2);
                pstm.setString(3,subName3);
            }
            res = pstm.executeQuery();
            while (res.next()) {
                if (res.getString("tec_name")!=null) {
                    list1.add(res.getString("tec_name"));
                    list2.add(res.getString("subject_name"));
                }else
                {
                    list1.add("暂未有授课教师");
                    list2.add(res.getString("subject_name"));
                }
            }
            lists.add(list1);
            lists.add(list2);
            return lists;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return null;
    }
}
