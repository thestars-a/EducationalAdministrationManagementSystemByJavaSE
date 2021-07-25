package Dao.DaoImpl.Student_Login_RegisterImpl;

import Dao.Student_Login_Register.Login_Register_interface;
import Model.StuUserInfo;
import Model.UserLoginRegister;
import Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Login_Register__Dao_Impl implements Login_Register_interface {

    /**
     * 注册判断的函数遗留一个小问题，其实这个学生的id和教师的id也不能重复，但是测试阶段我为了方便记忆就让他们可以重复，
     * 正式开发不能有这种问题，以免产生bug。
     * @param userLG
     * @return
     */
    @Override
    public int register_Judge_Dao(UserLoginRegister userLG) {
        String username = userLG.getUsername();
        List<String> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            String sql = "select username from stu_login ";
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
    public void register_Dao(UserLoginRegister userG) {
        String username = userG.getUsername();
        String password = userG.getPassword();
        String sql = "insert into stu_login(username,password) values(?,?)";
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
    public int login_Dao(UserLoginRegister userlg) {
        String username = userlg.getUsername();
        String password = userlg.getPassword();
        String sql = "select username,password from stu_login";
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
    public void infoInput_Dao(StuUserInfo userInfo) {
        String stu_id = userInfo.getStu_id();
        String name = userInfo.getName();
        String sex = userInfo.getSex();
        String colloege = userInfo.getColloege();
        String secret_que = userInfo.getSecret_que();
        String secret_ans = userInfo.getSecret_ans();
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert into stu_info value (null ,?,?,?,?,?,?)";
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, stu_id);
            pstm.setString(2, name);
            pstm.setString(3, sex);
            pstm.setString(4, colloege);
            pstm.setString(5, secret_que);
            pstm.setString(6, secret_ans);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }

    @Override
    public String findPassword_Dao(String stu_id,String secret_ans) {
        String sql = "select * from stu_info,stu_login where stu_info.stu_id=stu_login.username";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                if (stu_id.equals(resultSet.getString("stu_id"))) {
                    if (secret_ans.equals(resultSet.getString("secret_ans"))) {
                        return resultSet.getString("password");
                    }else return "回答错误";
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public String findPasswordJudge_Dao(String stu_id) {
        String sql = "select * from stu_info where stu_id=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,stu_id);
            resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                    return resultSet.getString("secret_que");
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
