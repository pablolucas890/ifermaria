/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "enfermidade", catalog = "db_enfermagem", schema = "")
public class Enfermidade implements Serializable,Comparable<Enfermidade> {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "idEnfermidade")
    private Integer idEnfermidade;
    @Column(name = "nome")
    private String nome;
    
    @ManyToMany(mappedBy = "enfermidades")
    private List<Atendimento> atendimentos = new ArrayList<>();

    public Integer getIdEnfermidade() {
        return idEnfermidade;
    }

    public void setIdEnfermidade(Integer idEnfermidade) {
        Integer oldIdEnfermidade = this.idEnfermidade;
        this.idEnfermidade = idEnfermidade;
        changeSupport.firePropertyChange("idEnfermidade", oldIdEnfermidade, idEnfermidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnfermidade != null ? idEnfermidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermidade)) {
            return false;
        }
        Enfermidade other = (Enfermidade) object;
        if ((this.idEnfermidade == null && other.idEnfermidade != null) || (this.idEnfermidade != null && !this.idEnfermidade.equals(other.idEnfermidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public int compareTo(Enfermidade t) {
                String aux = nome.toLowerCase();
        String aux2  = t.getNome().toLowerCase();
       return aux.compareTo(aux2);
    }
    
}
