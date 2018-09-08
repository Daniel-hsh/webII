/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ib.teste;

import br.com.ib.dao.PessoaDAO;
import br.com.ib.model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Teste {

    public static String main()  {
        Pessoa p = new Pessoa();
        p.setNome("Daniel");
        
        //set de todos os dados
        PessoaDAO dao = new PessoaDAO();
        
        try {
            dao.inserir(p);
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Pessoa> lista = new ArrayList<Pessoa>();
        try {
            lista = dao.buscarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Pessoa x : lista) {
            System.out.println(x.getNome());
        }
        return "Sucesso";
    }
}
