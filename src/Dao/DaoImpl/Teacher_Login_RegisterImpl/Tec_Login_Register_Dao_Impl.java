package Dao.DaoImpl.Teacher_Login_RegisterImpl;

import Dao.Teacher_Login_Register.Tec_Login_Register_interface;
import Model.TecUserInfo;
import Model.UserLoginRegister;
import Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class Tec_Login_Register_Dao_Impl implements Tec_Login_Register_interface {
    @Override
    public int tec_register_Judge_Dao(UserLoginRegister userLG) {
        String username = userLG.getUsername();
        List<String> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            String sql = "select username from tec_login ";
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            res = pstm.executeQuery();
            while (res.next()) {
                String stuNumLogin = res.getString("username");
                list.add(stuNumLogin);
            }
            for (String s : list) {
                if (s.equals(username)) {
                    return 1;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return 0;
    }

    @Override
    public void tec_register_Dao(UserLoginRegister userG) {
        String username = userG.getUsername();
        String password = userG.getPassword();
        String sql = "insert into tec_login values(?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }

    @Override
    public int tec_login_Dao(UserLoginRegister userlg) {
        String username = userlg.getUsername();
        String password = userlg.getPassword();
        String sql = "select * from tec_login";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            res = pstm.executeQuery();
            while (res.next()) {
                String usern = res.getString("username");
                String userp = res.getString("password");
                if (usern.equals(username) && userp.equals(password)) {
                    //登录成功
                    return 1;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return 0;
    }

    @Override
    public void tec_infoInput_Dao(TecUserInfo userInfo) {
        String tec_id = userInfo.getTec_id();
        String tec_name = userInfo.getTec_name();
        String tec_sex = userInfo.getTec_sex();
        String tec_colloege = userInfo.getTec_college();
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert into tec_info value (null ,?,?,?,?)";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tec_id);
            pstm.setString(2, tec_name);
            pstm.setString(3, tec_sex);
            pstm.setString(4, tec_colloege);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }
}
