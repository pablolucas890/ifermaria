package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private static Connection conn;
    private static boolean valida;

    public static boolean isValida() {
        return valida;
    }

    public static void setValida(boolean valida) {
        Conexao.valida = valida;
    }

    private Conexao() {
    }

    public static void setConn(Connection conn) {
        Conexao.conn = conn;
    }

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://***REMOVED***:3306/db_enfermagem", "db_enfermagem", "***REMOVED***");
            setValida(true);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
            setValida(false);
        }

        return conn;
    }

}
