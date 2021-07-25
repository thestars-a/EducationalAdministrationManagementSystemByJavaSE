package Service.Student;

import Dao.DaoImpl.StudentSurfaceImpl.StudentSurfaceDaoImpl;
import Dao.DaoImpl.Student_Login_RegisterImpl.Login_Register__Dao_Impl;
import Model.StuUserInfo;
import Model.UserLoginRegister;

public class LoginRegisterService {

    public int registerJudge(UserLoginRegister userLoginRegister){
        int i = new Login_Register__Dao_Impl().register_Judge_Dao(userLoginRegister);
        if (i==1)
        {
            return 1;
        }
        return 0;
    }
    public int register(UserLoginRegister userLoginRegister,StuUserInfo stuUserInfo){
        Login_Register__Dao_Impl lrdi = new Login_Register__Dao_Impl();
        int i = registerJudge(userLoginRegister);
        if (i==1)
        {
            return 1;
        }else {
            lrdi.register_Dao(userLoginRegister);
            lrdi.infoInput_Dao(stuUserInfo);
            return 2;
        }
    }
    public int login(UserLoginRegister userLoginRegister)
    {
        Login_Register__Dao_Impl lrdi = new Login_Register__Dao_Impl();
        int i = lrdi.login_Dao(userLoginRegister);
        return i;
    }

    public String findPassword(String stu_id,String secret_que)
    {

        String passwordFind = new Login_Register__Dao_Impl().findPassword_Dao(stu_id,secret_que);
        return passwordFind;

    }

    //用来返回问题
    public String findPasswordJudge(String stu_id){
        String i = new Login_Register__Dao_Impl().findPasswordJudge_Dao(stu_id);
        return i;
    }
    public void studentPasswordUpdate_Ser(String new_password,String stu_id){
        new StudentSurfaceDaoImpl().studentPasswordUpdate_Dao(new_password,stu_id);
    }
}
