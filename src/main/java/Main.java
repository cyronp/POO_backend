import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends ConsultaID{
    public static void main(String[] args){
        connect();
        createNewDB();
        ConsultaID.idconsult(1);
    }

    private static void createNewDB() {
        String url = "jdbc:sqlite:pessoa.db";
        String sql = "create table if not exists pessoa (" +
                "id integer primary key AUTOINCREMENT," +
                "nome varchar(255)," +
                "sobrenome varchar(255)," +
                "cpf varchar(11) unique," +
                "ativo boolean," +
                "dataNascimento date," +
                "peso float," +
                "altura float)";
        try (Connection con = DriverManager.getConnection(url);
        java.sql.Statement state = con.createStatement()){
            state.execute(sql);
            System.out.println("Tabela criada");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void connect(){
        String url = "jdbc:sqlite:pessoa.db";
        try (Connection con = DriverManager.getConnection(url)){
            if (con != null){
                System.out.println("Conectou com database.");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
