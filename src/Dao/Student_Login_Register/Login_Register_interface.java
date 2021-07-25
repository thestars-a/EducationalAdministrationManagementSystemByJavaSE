package Dao.Student_Login_Register;

import Model.StuUserInfo;
import Model.UserLoginRegister;

public interface Login_Register_interface {
    int register_Judge_Dao(UserLoginRegister userLG);
    void register_Dao(UserLoginRegister userG);
    int login_Dao(UserLoginRegister userlg);
    void infoInput_Dao(StuUserInfo userInfo);
    String findPassword_Dao(String stu_id,String secret_ans);
    String findPasswordJudge_Dao(String stu_id);

}
