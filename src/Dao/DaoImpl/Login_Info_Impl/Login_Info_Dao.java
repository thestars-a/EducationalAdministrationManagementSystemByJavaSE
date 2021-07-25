package Dao.DaoImpl.Login_Info_Impl;

import Dao.Login_Info.Login_Info_Interface;
import Util.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login_Info_Dao implements Login_Info_Interface {
    @Override
    public void input_info(String id, String category, Timestamp time) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            String sql = "insert into login_info value (?,?,?)";
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,id);
            pstm.setString(2,category);
            pstm.setTimestamp(3,time);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }

    @Override
    public Object[][] login_info_get() {
        Object data[][];
        String sql="select * from login_info";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            res = pstm.executeQuery();
            res.last();
            int i = res.getRow();
            data=new Object[i][3];
            res.beforeFirst();
            i--;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (res.next()) {
                String id=res.getString("id");
                String category=res.getString("category");
                Timestamp time=res.getTimestamp("time");
                Date date = new Date(time.getTime());
                data[i][0]=id;
                data[i][1]=category;
                data[i][2]=sdf.format(date);
                i--;
            }
            return data;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstm, conn);
        }
        return new Object[0][];
    }

    @Override
    public void login_info_del(Timestamp del_time) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            String sql = "delete from login_info where time<?";
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setTimestamp(1,del_time);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, conn);
        }
    }
}
