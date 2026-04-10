/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import model.Atendente;

/**
 *
 * @author Pablo
 */
public class Sessao {
    
    private static Atendente atendente;
    
    public Sessao(Atendente atendente){
        this.atendente = atendente;
    }
    
    public static Atendente getAtendenteLogado(){
        return atendente;
    }
    
}
