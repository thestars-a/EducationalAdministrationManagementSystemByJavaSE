package Model;

public class StuUserInfo {
    private String stu_id;
    private String name;
    private String sex;
    private String colloege;
    private String secret_que;
    private String secret_ans;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColloege() {
        return colloege;
    }

    public void setColloege(String colloege) {
        this.colloege = colloege;
    }

    public String getSecret_que() {
        return secret_que;
    }

    public void setSecret_que(String secret_que) {
        this.secret_que = secret_que;
    }

    public String getSecret_ans() {
        return secret_ans;
    }

    public void setSecret_ans(String secret_ans) {
        this.secret_ans = secret_ans;
    }

    public StuUserInfo(String stu_id, String name, String sex, String colloege, String secret_que, String secret_ans) {
        this.stu_id = stu_id;
        this.name = name;
        this.sex = sex;
        this.colloege = colloege;
        this.secret_que = secret_que;
        this.secret_ans = secret_ans;
    }

    public StuUserInfo() {
    }

    @Override
    public String toString() {
        return "StuUserInfo{" +
                "stu_id='" + stu_id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", colloege='" + colloege + '\'' +
                ", secret_que='" + secret_que + '\'' +
                ", secret_ans='" + secret_ans + '\'' +
                '}';
    }
}
