/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ib.dao;

import br.com.ib.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public class PessoaDAO {

    public PessoaDAO() {
    }

    public List<Pessoa> buscarTodos() throws SQLException {
        List<Pessoa> resultados = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * FROM tb_usuario");
            rs = st.executeQuery();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("user_id"));
                p.setLogin(rs.getString("user_login"));
                p.setSenha(rs.getString("user_pass"));
                p.setNome(rs.getString("user_name"));
                resultados.add(p);
            }
            return resultados;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }
    }
    
    /*public void buscarPessoa(String name, String senha) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT user_login, user_pass) FROM tb_pessoa "
                    + "WHERE user_login=name AND user_pass=senha");
            st.executeQuery();
        }catch(Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }
    }*/

    public void inserir(Pessoa pessoa) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            
            st = con.prepareStatement("insert into tb_usuario "
                    + "(user_login, user_pass, user_name) "
                    + "values (?, ?, ?)");
            st.setString(1, pessoa.getLogin());
            st.setString(2, pessoa.getSenha());
            st.setString(3, pessoa.getNome());
            st.executeUpdate();
            
            System.out.println("Cadastrado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }
    }
    
public void atualizar(Pessoa pessoa) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("update tb_usuario "
                    + "set user_login=?, user_pass=?, user_name=? where user_id=?");
            
            st.setString(1, pessoa.getLogin());
            st.setString(2, pessoa.getSenha());
            st.setString(3, pessoa.getNome());
            st.setInt(4, pessoa.getId());
            st.executeQuery();
            System.out.println("Atualizado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }
    }
}

