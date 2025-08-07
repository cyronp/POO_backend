import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Consulta {
    public static void main( String[] args ) {
        String url = "jdbc:sqlite:pessoa.db";
        try{
            Connection con = DriverManager.getConnection(url);
            String consulta = "select id, nome, cpf from pessoa order by nome";
            PreparedStatement pre = con.prepareStatement(consulta);
            ResultSet rs = pre.executeQuery();

            while(rs.next()){
                long id = rs.getLong(1);
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                System.out.println(id+", "+nome+", "+cpf);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
