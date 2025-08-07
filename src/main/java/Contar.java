import java.sql.*;

public class Contar {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:pessoa.db";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            String contar = "select count(id) from pessoa";
            ps = con.prepareStatement(contar);
            rs = ps.executeQuery();

            int colunas = rs.getInt(1);
            System.out.println("Numero de colunas: "+colunas);



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
