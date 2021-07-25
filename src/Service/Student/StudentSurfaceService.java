package Service.Student;

import Dao.DaoImpl.StudentSurfaceImpl.StudentSurfaceDaoImpl;
import Model.SubjectInfo;

import java.util.ArrayList;
import java.util.List;

public class StudentSurfaceService {

    public String[] student_info_find(String stu_id) {
        String[] info_dao = new StudentSurfaceDaoImpl().studentInfo_Dao(stu_id);
        return info_dao;
    }

    public int student_judge_password(String old_password, String stu_id) {
        int i = new StudentSurfaceDaoImpl().studentPasswordJudge_Dao(old_password, stu_id);
        return i;
    }

    public int student_update_password(String old_password, String new_password, String stu_id) {
        int i = student_judge_password(old_password, stu_id);
        if (i == 1) {
            new StudentSurfaceDaoImpl().studentPasswordUpdate_Dao(new_password, stu_id);
            return 1;
        }
        return 0;
    }

    /**
     * 这个函数完全可以用一个类来当参数，我后边有类似的用到了类传，这里也是一种写法，但是不建议采用
     *
     * @param stu_id
     * @param stu_name
     * @param stu_sex
     * @param secret_que
     * @param secret_ans
     */
    public void studen_update_info(String stu_id, String stu_name, String stu_sex, String secret_que, String secret_ans) {
        new StudentSurfaceDaoImpl().studenInfoUpdate_Dao(stu_id, stu_name, stu_sex, secret_que, secret_ans);
    }

    /**
     * 这个和上一个函数做对比，这里传递的是一个类的集合，就很方便
     *
     * @param subjectNameInfoList
     */
    public void stu_sub_info_input(List<SubjectInfo> subjectNameInfoList) {
        new StudentSurfaceDaoImpl().student_subject_info_input(subjectNameInfoList);
    }

    public boolean stu_sub_isSelect_judge(String stu_id) {
        return new StudentSurfaceDaoImpl().student_subject_isSelect_judge(stu_id);
    }

    public List<String> stu_sub_info_subName_get(String stu_id) {
        return new StudentSurfaceDaoImpl().student_subject_info_subName_Dao(stu_id);
    }

    public String[] stu_sub_info_tecName_get(String stu_id, String college_name) {
        List<String> list = stu_sub_info_subName_get(stu_id);
        List<List<String>> list_total = new StudentSurfaceDaoImpl().student_subject_info_tecName_Dao(list, college_name);
        String[] lists = new String[10];
        List<String> list1=list_total.get(0);
        if (list.size()==list_total.get(1).size())
            list=list_total.get(1);
        else {
            List<String> stringList1 = list_total.get(1);
            for (int i = 0; i < stringList1.size(); i++) {
                list.remove(stringList1.get(i));
            }
            for (int i = 0; i < list.size(); i++) {
                stringList1.add(list.get(i));
            }
            list=stringList1;
        }
        /**
         * 这里有个问题有待思考如果把result换成表达式放到for循环里就会出错
         * 想明白了，我在动态给list1添加元素，如果放表达式这个result不是固定的了
         */
        int result = list.size() - list1.size();
        for (int i = 0; i < result; i++) {
            list1.add("暂未有授课教师");
        }
        String str = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("javaEE") || list.get(i).equals("中医基础理论") || list.get(i).equals("Facker的核心技术")) {
                str = list.get(i) + ",教师:" + list1.get(i);
                lists[0] = str;
            } else if (list.get(i).equals("云计算") || list.get(i).equals("中医概论") || list.get(i).equals("LPL经验之谈")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[1] = str;
            } else if (list.get(i).equals("数值计算") || list.get(i).equals("刮痧拔罐") || list.get(i).equals("上单教学")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[2] = str;
            } else if (list.get(i).equals("数据库系统") || list.get(i).equals("小儿推拿按摩") || list.get(i).equals("产业管理")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[3] = str;
            } else if (list.get(i).equals("离散数学") || list.get(i).equals("脏腑点穴") || list.get(i).equals("战队管理")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[4] = str;
            } else if (list.get(i).equals("移动端开发") || list.get(i).equals("腰椎按摩") || list.get(i).equals("打野思路")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[5] = str;
            } else if (list.get(i).equals("程序理论") || list.get(i).equals("艾灸") || list.get(i).equals("最强王者的晋级之路")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[6] = str;
            } else if (list.get(i).equals("自然语言处理") || list.get(i).equals("足疗") || list.get(i).equals("极限拉扯")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[7] = str;
            } else if (list.get(i).equals("计算机网络应用") || list.get(i).equals("颈椎按摩") || list.get(i).equals("电竞文化史")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[8] = str;
            } else if (list.get(i).equals("软件工程") || list.get(i).equals("黯然销魂掌") || list.get(i).equals("课程设计")) {
                str =list.get(i) + ",教师:" + list1.get(i);
                lists[9] = str;
            }
        }
        return lists;
    }
        public Object[][] student_score_seek_Dao(String stu_id){
        return new StudentSurfaceDaoImpl().student_score_seek_Dao(stu_id);
    }
}
