package Dao.Teacher_Login_Register;

import Model.TecUserInfo;
import Model.UserLoginRegister;

public interface Tec_Login_Register_interface {
    int tec_register_Judge_Dao(UserLoginRegister userLG);
    void tec_register_Dao(UserLoginRegister userG);
    int tec_login_Dao(UserLoginRegister userlg);
    void tec_infoInput_Dao(TecUserInfo userInfo);
}
