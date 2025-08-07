import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Atualizar {
    public static void update(String nome, String sobrenome, String cpf, Boolean ativo, String dataNascimento, double peso, double altura) {
        String url = "jdbc:sqlite:pessoa.db";
        try{
            Connection con = DriverManager.getConnection(url);
            String update = "update pessoa set nome = nome, sobrenome = sobrenome, cpf = cpf, ativo = ativo," +
                    "dataNascimento = dataNascimento, peso = peso, altura = altura  where id = id;";
            PreparedStatement ps = con.prepareStatement(update);
            ResultSet rs = ps.executeQuery();

            ps.setString(1,nome);
            ps.setString(2,sobrenome);
            ps.setString(3,cpf);
            ps.setBoolean(4,ativo);
            ps.setString(5,dataNascimento);
            ps.setDouble(6,peso);
            ps.setDouble(7,altura);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
