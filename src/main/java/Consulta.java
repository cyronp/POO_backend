import java.sql.*;

public class Consulta {
    public static void Select(){
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
    public static void Update(String nome, String sobrenome, String cpf, Boolean ativo, String dataNascimento, double peso, double altura, int id) {
        String url = "jdbc:sqlite:pessoa.db";
        try{
            Connection con = DriverManager.getConnection(url);
            String update = "update pessoa set nome = ?, sobrenome = ?, cpf = ?, ativo = ?," +
                    "dataNascimento = ?, peso = ?, altura = ?  where id = ?;";
            PreparedStatement ps = con.prepareStatement(update);
            ResultSet rs = ps.executeQuery();

            ps.setString(1,nome);
            ps.setString(2,sobrenome);
            ps.setString(3,cpf);
            ps.setBoolean(4,ativo);
            ps.setString(5,dataNascimento);
            ps.setDouble(6,peso);
            ps.setDouble(7,altura);
            ps.setInt(8,id);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void SelectWithId(int id){
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
    public static void Count() {
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
    public static void Insert(String nome, String sobrenome, String cpf, Boolean ativo, String dataNascimento, double peso, double altura) {
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
