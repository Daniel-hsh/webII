package br.com.ib.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
import br.com.ib.model.Pessoa;
import br.com.ib.dao.PessoaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUsuarioDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pessoa usu = new Pessoa();
        usu.setLogin("Vir");
        usu.setSenha("vv123");
        usu.setNome("Vimerson");
        
        PessoaDAO usuDao = new PessoaDAO();
        try {
            usuDao.inserir(usu);
        } catch (SQLException ex) {
            Logger.getLogger(TestUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
