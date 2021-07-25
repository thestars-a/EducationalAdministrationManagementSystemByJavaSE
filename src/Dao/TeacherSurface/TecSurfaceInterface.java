package Dao.TeacherSurface;

import Model.StuAdd;
import Model.StuScoreInfo;
import Model.SubjectInfo;

import java.util.List;

/**
 * 此接口的抽象类也都如此，void都应该有个判断，boolean或者int都行，我是数据少，赶时间，赶进度就这么写了，请勿模仿
 */
public interface TecSurfaceInterface {
    String college_name_find(String tec_id);
    String[] subject_name_find(String college_name);
    void subject_info_input(List<SubjectInfo> subjectNameInfoList);
    List<String> subject_info_input_judge(List<SubjectInfo> subjectNameInfoListJudge);
    boolean subject_isSelect_judge(String tec_id,String tec_college);
    List<String> subject_info_get(String tec_college,String tec_id);
    Object[][] score_input(String tec_college,String tec_id);
    void score_input_really(List<StuScoreInfo> list,String tec_college);
    List<String> subject_name_get(String tec_college,String tec_id);
    Object[][] stu_info_manage_Dao(String comboSelect,String textfield,String tec_id,String tec_college);
    void stu_subject_del(String stu_id,String stu_subject);
    void stu_subject_add(StuAdd stuAdd);
    boolean stu_subject_add_judge(StuAdd stuAdd);
    boolean stu_subject_add_judgePlus(String stu_id,String tec_college);
    boolean stu_subject_add_judgePlus_idAndName(String stu_id,String name);
    boolean stu_subject_add_judgePlus_sub(String stu_id);
}
