import java.sql.*;

public class Inserir {
    public static void insert(String nome, String sobrenome, String cpf, Boolean ativo, String dataNascimento, double peso, double altura) {
        String url = "jdbc:sqlite:pessoa.db";
        String insert = "insert into pessoa(nome, sobrenome, cpf, ativo, dataNascimento, peso, altura) values (?,?,?,?,?,?,?)";
        try{
            Connection con = DriverManager.getConnection(url);
            PreparedStatement ps = con.prepareStatement(insert);

            ps.setString(1,nome);
            ps.setString(2,sobrenome);
            ps.setString(3,cpf);
            ps.setBoolean(4,ativo);
            ps.setString(5,dataNascimento);
            ps.setDouble(6,peso);
            ps.setDouble(7,altura);

            ps.executeUpdate();
            System.out.println("Inserido com sucesso");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
