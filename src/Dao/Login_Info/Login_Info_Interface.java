package Dao.Login_Info;

import java.sql.Timestamp;

public interface Login_Info_Interface {
    void input_info(String id, String category, Timestamp del_time);
    Object[][] login_info_get();
    void login_info_del(Timestamp time);
}
