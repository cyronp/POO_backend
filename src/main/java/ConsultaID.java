import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaID {
    public static void idconsult(int id){
        String url = "jdbc:sqlite:pessoa.db";
        int id_pessoa = id;
        String idconsult = "select * from pessoa where id = '"+id_pessoa+"';";
        try{
            Connection con = DriverManager.getConnection(url);
            PreparedStatement ps = con.prepareStatement(idconsult);

            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
