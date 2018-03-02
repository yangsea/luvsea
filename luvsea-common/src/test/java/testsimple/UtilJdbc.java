package testsimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class UtilJdbc {
    
    private static String driverName = "com.mysql.jdbc.Driver";
    public static Connection connection; 
  private static String urlStr = "jdbc:mysql://10.39.75.146:3306/jx_mall?useUnicode=true&amp;characterEncoding=UTF-8";
  private static String username = "jx_user";
  private static String password = "jx_user";
    
    public static Connection getConnectForHive() throws ClassNotFoundException, SQLException{
        Class.forName(driverName);
        Connection connection = DriverManager.getConnection(urlStr, username, password);
        return connection;
    }
    
    public static void closeAll(Connection conn, Statement state, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(state != null){
                state.close();
            }
            if(conn != null){
                conn.close();
            }
          } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception{

        Class.forName(driverName);
        Connection con = DriverManager.getConnection(urlStr, username, password);
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM t_marketing_userinfo limit 5";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(3) + "\t" );
        }
        UtilJdbc.closeAll(con, stmt, rs);
    }
    
    public static List<HashMap<String, Object>> getObjects(String sql) throws Exception{
            Connection con = null;
            Statement stmt =  null;
            ResultSet rs = null;
           try {
                   Class.forName(driverName);
                   con = DriverManager.getConnection(urlStr, username, password);
                  stmt = con.createStatement();
                   rs = stmt.executeQuery(sql);
                   if (rs == null){
                       return Collections.EMPTY_LIST;   
                   }else{
                       ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等   
                       int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数   
                       List<HashMap<String, Object>> list = new ArrayList();   
                       HashMap<String, Object> rowData = new HashMap();   
                       while (rs.next()) {   
                        rowData = new HashMap(columnCount);   
                        for (int i = 1; i <= columnCount; i++) {   
                                rowData.put(md.getColumnName(i), rs.getObject(i));   
                        }   
                        list.add(rowData);   
                       }   
                       return list;  
                   }
        } catch (Exception e) {
            UtilJdbc.closeAll(con, stmt, rs);
        }finally{
            UtilJdbc.closeAll(con, stmt, rs);
        }
        return null;
    }
    
    public static void insertObject(String sql) throws Exception{
        Connection con = null;
        PreparedStatement  stmt =  null;
       try {
               Class.forName(driverName);
               con = DriverManager.getConnection(urlStr, username, password);
              stmt = (PreparedStatement) con.createStatement();
              stmt.executeUpdate(sql);
    } catch (Exception e) {
        UtilJdbc.closeAll(con, stmt, null);
    }finally{
        UtilJdbc.closeAll(con, stmt, null);
    }
}
}
