package Service.LogintInfotime;

import Dao.DaoImpl.Login_Info_Impl.Login_Info_Dao;
import Gui.sys_login.Login_Info;

import java.sql.Timestamp;

public class LoginInfoService {
    public void input_info_Ser(String id, String category, Timestamp time){
        new Login_Info_Dao().input_info(id,category,time);
    }
    public Object[][] login_info_get_Ser()
    {
        return new Login_Info_Dao().login_info_get();
    }
    public void login_info_del_Ser(Timestamp del_time){
        new Login_Info_Dao().login_info_del(del_time);
    }
}
