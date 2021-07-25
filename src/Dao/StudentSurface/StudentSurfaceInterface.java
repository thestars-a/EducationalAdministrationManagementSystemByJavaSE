package Dao.StudentSurface;

import Model.SubjectInfo;

import java.util.List;

public interface StudentSurfaceInterface {

    String[] studentInfo_Dao(String stu_id);
    int studentPasswordJudge_Dao(String old_password,String stu_id);

    /**
     * 其实不止这个void，以及后边的都不应该是void，实则要进行一波判断，看是否数据库操作成功，我这么写是因为我懒，哈哈哈，
     * 而且我的数据咱不会出错，但实际开发切记要判断
     * @param new_password
     * @param stu_id
     */
    void studentPasswordUpdate_Dao(String new_password,String stu_id);
    void studenInfoUpdate_Dao(String stu_id,String stu_name,String stu_sex,String secret_que,String secret_ans);
    void student_subject_info_input(List<SubjectInfo> subjectNameInfoList);
    boolean student_subject_isSelect_judge(String stu_id);
    List<String> student_subject_info_subName_Dao(String stu_id);
    Object[][] student_score_seek_Dao(String stu_id);
    List<List<String>> student_subject_info_tecName_Dao(List<String> collegeName,String college);
    /**
     * 这里有个判断的，判断这门课是否被选择过，但是学生一学期只能选一次，所以这个暂时可以不用，如果实际中应当有这个判断
     * 我在教师那里有这个是因为教师教的课是固定的，不能多人教一门，不要抬杠，我规定的学校就这要求，正常需求有点麻烦
     */
    //List<String> student_subject_info_input_judge(List<SubjectInfo> subjectNameInfoListJudge);
}
