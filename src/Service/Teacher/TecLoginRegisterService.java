package Service.Teacher;

import Dao.DaoImpl.Teacher_Login_RegisterImpl.Tec_Login_Register_Dao_Impl;
import Model.TecUserInfo;
import Model.UserLoginRegister;

public class TecLoginRegisterService {
    public int registerJudge(UserLoginRegister userLoginRegister){
        int i = new Tec_Login_Register_Dao_Impl().tec_register_Judge_Dao(userLoginRegister);
        if (i==1)
        {
            return 1;
        }
        return 0;
    }
    public int register(UserLoginRegister userLoginRegister, TecUserInfo tecUserInfo){
        Tec_Login_Register_Dao_Impl lrdi = new Tec_Login_Register_Dao_Impl();
        int i = registerJudge(userLoginRegister);
        if (i==1)
        {
            return 1;
        }else {
            lrdi.tec_register_Dao(userLoginRegister);
            lrdi.tec_infoInput_Dao(tecUserInfo);
            return 2;
        }
    }
    public int login(UserLoginRegister userLoginRegister)
    {
        Tec_Login_Register_Dao_Impl lrdi = new Tec_Login_Register_Dao_Impl();
        int i = lrdi.tec_login_Dao(userLoginRegister);
        return i;
    }
}
