package Model;

public class StuAdd {
    private String stu_id;
    private String name;
    private String subject;

    @Override
    public String toString() {
        return "StuAdd{" +
                "stu_id='" + stu_id + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public StuAdd(String stu_id, String name, String subject) {
        this.stu_id = stu_id;
        this.name = name;
        this.subject = subject;
    }

    public StuAdd() {
    }
}
