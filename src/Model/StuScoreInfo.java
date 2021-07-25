package Model;

public class StuScoreInfo {
    private String stu_id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String subject_name;
    private double score;

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }


    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StuScoreInfo{" +
                "stu_id='" + stu_id + '\'' +
                ", name='" + name + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", score=" + score +
                '}';
    }

    public StuScoreInfo(String stu_id, String name, String subject_name, double score) {
        this.stu_id = stu_id;
        this.name = name;

        this.subject_name = subject_name;
        this.score = score;
    }
}
