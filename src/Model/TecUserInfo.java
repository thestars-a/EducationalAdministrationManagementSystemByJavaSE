package Model;

public class TecUserInfo {

    private String tec_id;
    private String tec_name;
    private String tec_sex;
    private String tec_college;

    public TecUserInfo() {
    }

    public String getTec_id() {
        return tec_id;
    }

    public void setTec_id(String tec_id) {
        this.tec_id = tec_id;
    }

    public String getTec_name() {
        return tec_name;
    }

    public void setTec_name(String tec_name) {
        this.tec_name = tec_name;
    }

    public String getTec_sex() {
        return tec_sex;
    }

    public void setTec_sex(String tec_sex) {
        this.tec_sex = tec_sex;
    }

    public String getTec_college() {
        return tec_college;
    }

    public void setTec_college(String tec_college) {
        this.tec_college = tec_college;
    }

    public TecUserInfo(String tec_id, String tec_name, String tec_sex, String tec_college) {
        this.tec_id = tec_id;
        this.tec_name = tec_name;
        this.tec_sex = tec_sex;
        this.tec_college = tec_college;
    }
}
