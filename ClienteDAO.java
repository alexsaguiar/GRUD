package clientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public static void salvar(String nome, String email, String usuario, String senha) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientes",
                    "postgres", "oifio2016");

            PreparedStatement clt = conexao.prepareStatement("insert into cliente (nome, email, usuario, senha) "
                    + "values (?, ?, ?, ?); ");

            clt.setString(1, nome);
            clt.setString(2, email);
            clt.setString(3, usuario);
            clt.setString(4, senha);

            clt.executeUpdate();

            clt.close();
            conexao.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Cliente buscar(int id) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientes", "postgres", "oifio2016");

            PreparedStatement clt = conexao.prepareStatement("select * from cliente where id = ?");

            clt.setInt(1, id);

            ResultSet rs = clt.executeQuery();
            rs.next();

            Cliente cliente = new Cliente();

            cliente.id = rs.getInt("id");
            cliente.nome = rs.getString("nome");
            cliente.email = rs.getString("email");

            rs.close();
            clt.close();
            conexao.close();

            return cliente;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static ArrayList<Cliente> listar() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try {
            Class.forName("org.postgresql.Driver");

            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientes", "postgres", "oifio2016");

            PreparedStatement clt = conexao.prepareStatement("select * from cliente");

            ResultSet rs = clt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.id = rs.getInt("id");
                cliente.nome = rs.getString("nome");
                cliente.email = rs.getString("email");
                cliente.usuario = rs.getString("usuario");
                cliente.senha = rs.getString("senha");
                clientes.add(cliente);
            }
            rs.close();
            clt.close();
            conexao.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }

    public static void atualizar(int id, String nome, String email, String usuario, String senha) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientes", "postgres", "oifio2016");

            PreparedStatement clt = conexao.prepareStatement("update cliente set nome = ?, email = ?, usuario = ?, senha = ? where id = ?");

         
            clt.setString(1, nome);
            clt.setString(2, email);
            clt.setString(3, usuario);
            clt.setString(4, senha);
            clt.setInt(5, id);
            
            
            clt.executeUpdate();
                    
            clt.close();
            conexao.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void excluir(int id) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientes", "postgres", "oifio2016");

            PreparedStatement clt = conexao.prepareStatement("delete from cliente where id = ?");

            clt.setInt(1, id);

            clt.executeUpdate();

            clt.close();
            conexao.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Cliente login(String usuario, String senha) {

        try {
            Class.forName("org.postgresql.Driver");

            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clientes", "postgres", "oifio2016");

            PreparedStatement clt = conexao.prepareStatement("select * from cliente where usuario = ? and senha = ?");

           clt.setString(1, usuario);
           clt.setString(2, senha);
           
           ResultSet rs = clt.executeQuery();

           if(rs.next()){

            Cliente cliente = new Cliente();
            cliente.usuario = rs.getString("usuario");
            cliente.senha = rs.getString("senha");

            rs.close();
            clt.close();
            conexao.close();
           
            return cliente;
           }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
