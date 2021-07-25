package Service.Teacher;

import Dao.DaoImpl.TeacherSurfaceImpl.TecSurfaceDaoImpl;
import Model.StuAdd;
import Model.StuScoreInfo;
import Model.SubjectInfo;

import java.util.List;

public class TecSurfaceService {
    public String tec_college_get(String tec_id)
    {
        return new TecSurfaceDaoImpl().college_name_find(tec_id);
    }
    public String[] tec_sub_get(String college_name)
    {
        return new TecSurfaceDaoImpl().subject_name_find(college_name);
    }
    public void tec_sub_info_input(List<SubjectInfo> subjectNameInfoList)
    {
        new TecSurfaceDaoImpl().subject_info_input(subjectNameInfoList);
    }
    public List<String> tec_sub_info_judge(List<SubjectInfo> subjectInfoListJudge)
    {
        return new TecSurfaceDaoImpl().subject_info_input_judge(subjectInfoListJudge);
    }
    public boolean tec_sub_isSelect_judge(String tec_id,String tec_college)
    {
        return new TecSurfaceDaoImpl().subject_isSelect_judge(tec_id,tec_college);
    }
    public String[] tec_sub_info_get(String tec_college,String tec_id){
        String[] lists = new String[10];
        List<String> list = new TecSurfaceDaoImpl().subject_info_get(tec_college, tec_id);
        String tec_name = list.remove(list.size() - 1);
        String str=null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("javaEE") || list.get(i).equals("中医基础理论") || list.get(i).equals("Facker的核心技术")) {
                str = list.get(i) + ",教师:" + tec_name;
                lists[0] = str;
            } else if (list.get(i).equals("云计算") || list.get(i).equals("中医概论") || list.get(i).equals("LPL经验之谈")) {
                str =list.get(i) + ",教师:" + tec_name;
                lists[1] = str;
            } else if (list.get(i).equals("数值计算") || list.get(i).equals("刮痧拔罐") || list.get(i).equals("上单教学")) {
                str =list.get(i) + ",教师:" + tec_name;
                lists[2] = str;
            } else if (list.get(i).equals("数据库系统") || list.get(i).equals("小儿推拿按摩") || list.get(i).equals("产业管理")) {
                str =list.get(i) + ",教师:" + tec_name;
                lists[3] = str;
            } else if (list.get(i).equals("离散数学") || list.get(i).equals("脏腑点穴") || list.get(i).equals("战队管理")) {
                str =list.get(i) + ",教师:" + tec_name;
                lists[4] = str;
            } else if (list.get(i).equals("移动端开发") || list.get(i).equals("腰椎按摩") || list.get(i).equals("打野思路")) {
                str =list.get(i) + ",教师:" + tec_name;
                lists[5] = str;
            } else if (list.get(i).equals("程序理论") || list.get(i).equals("艾灸") || list.get(i).equals("最强王者的晋级之路")) {
                str =list.get(i) + ",教师:" + tec_name;
                lists[6] = str;
            } else if (list.get(i).equals("自然语言处理") || list.get(i).equals("足疗") || list.get(i).equals("极限拉扯")) {
                str = list.get(i) + ",教师:" + tec_name;
                lists[7] = str;
            } else if (list.get(i).equals("计算机网络应用") || list.get(i).equals("颈椎按摩") || list.get(i).equals("电竞文化史")) {
                str =list.get(i) + ",教师:" + tec_name;
                lists[8] = str;
            } else if (list.get(i).equals("软件工程") || list.get(i).equals("黯然销魂掌") || list.get(i).equals("课程设计")) {
                str =list.get(i) + ",教师:" + tec_name;
                lists[9] = str;
            }
        }
        return lists;
    }

    public Object[][] tec_score_input(String tec_college, String tec_id)
    {
        Object[][] stuScoreInfoList = new TecSurfaceDaoImpl().score_input(tec_college, tec_id);
        return stuScoreInfoList;
    }

    public void tec_score_input_really(List<StuScoreInfo> list,String tec_college)
    {
        new TecSurfaceDaoImpl().score_input_really(list,tec_college);
    }

    public List<String> tec_sub_name_get(String tec_college, String tec_id){
        return new TecSurfaceDaoImpl().subject_name_get(tec_college,tec_id);
    }
    public Object[][] stu_info_manage_Ser(String comboSelect, String textfield,String tec_id,String tec_college)
    {
        return new TecSurfaceDaoImpl().stu_info_manage_Dao(comboSelect,textfield,tec_id,tec_college);
    }
    public void stu_subject_del_Ser(String stu_id, String stu_subject){
        new TecSurfaceDaoImpl().stu_subject_del(stu_id,stu_subject);
    }
    public void stu_subject_add_Ser(StuAdd stuAdd){
        new TecSurfaceDaoImpl().stu_subject_add(stuAdd);
    }
    public Boolean stu_subject_add_judge_Ser(StuAdd stuAdd)
    {
        return new TecSurfaceDaoImpl().stu_subject_add_judge(stuAdd);
    }
    public boolean stu_subject_add_judgePlus_Ser(String stu_id, String tec_college){
        return  new TecSurfaceDaoImpl().stu_subject_add_judgePlus(stu_id,tec_college);
    }
    public boolean stu_subject_add_judgePlus_idAndName_Ser(String stu_id, String name){
        return  new TecSurfaceDaoImpl().stu_subject_add_judgePlus_idAndName(stu_id,name);
    }
    public boolean stu_subject_add_judgePlus_sub_Ser(String stu_id)
    {
        return new TecSurfaceDaoImpl().stu_subject_add_judgePlus_sub(stu_id);
    }
}
