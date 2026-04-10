/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Aluno;
import model.Atendente;
import model.Log;

/**
 *
 * @author Pablo
 */
public class Logger {

    private static EntityManager em;

    private Logger() {
    }

    private static EntityManager getEntitManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        }
        return em;
    }

    public static void log(Atendente atendente,Aluno aluno, String acao, Tabelas tabela) {
        getEntitManager();
        Log log = new Log();
        log.setAtendente(atendente);
        log.setAluno(aluno);
        log.setAcao(acao);
        log.setTabela(tabela.toString());
        log.setDataEvento(new Date());
        log.setHoraEvento(new Date());
        em.getTransaction().begin();
        em.persist(log);
        em.getTransaction().commit();
    }
}
