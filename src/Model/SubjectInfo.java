package Model;

/**
 * 突然发现这个实体类有时候离不开学院，虽然里边我没有设置学院，但我还是加上吧，表可能没设计好 无语
 */
public class SubjectInfo {
    private String subject_name;

    @Override
    public String toString() {
        return "SubjectInfo{" +
                "subject_name='" + subject_name + '\'' +
                ", tec_num='" + tec_num + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

    //这里的tec_num设计的有问题，往后这个实体类学生的课程信息也要用到，姑且这么用，就不改名字了，学生用的时候不用college
    private String tec_num;
    private String college;

    //重写一下构造函数，有用到学院就用这个没有就用另一个
    public SubjectInfo(String subject_name, String tec_num, String college) {
        this.subject_name = subject_name;
        this.tec_num = tec_num;
        this.college = college;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getTec_num() {
        return tec_num;
    }

    public void setTec_num(String tec_num) {
        this.tec_num = tec_num;
    }

    public SubjectInfo(String subject_name, String tec_num) {
        this.subject_name = subject_name;
        this.tec_num = tec_num;
    }

    public SubjectInfo() {
    }
}
