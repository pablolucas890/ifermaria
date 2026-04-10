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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "medicamento", catalog = "db_enfermagem", schema = "")
public class Medicamento implements Serializable,Comparable<Medicamento> {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmedicamento")
    private Integer idmedicamento;
    @Column(name = "nome")
    private String nome;
    @Column(name = "unidade")
    private String unidade;
    @Column(name = "tipo")
    private String tipo;    
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantTotal")
    private Integer quantTotal;
    @Column(name = "catmat")
    private Integer catmat;
    @Column(name = "quant_Antiga")
    private Integer quant_Antiga;

    @OneToMany(mappedBy = "medicamento")
    private List<Estoque> estoques = new ArrayList<>();

    public Integer getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(Integer idmedicamento) {
        Integer oldIdmedicamento = this.idmedicamento;
        this.idmedicamento = idmedicamento;
        changeSupport.firePropertyChange("idmedicamento", oldIdmedicamento, idmedicamento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
               String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Integer getQuant_Antiga() {
        return quant_Antiga;
    }

    public void setQuant_Antiga(Integer quant_Antiga) {
        Integer oldQuant_Antiga = this.quant_Antiga;
        this.quant_Antiga = quant_Antiga;
        changeSupport.firePropertyChange("quant_Antiga", oldQuant_Antiga, quant_Antiga);
    }

    public Integer getCatmat() {
        return catmat;
    }

    public void setCatmat(Integer catmat) {

        Integer oldCatmat = this.catmat;
        this.catmat = catmat;
        changeSupport.firePropertyChange("catmat", oldCatmat, catmat);
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        String oldUnidade = this.unidade;
        this.unidade = unidade;
        changeSupport.firePropertyChange("unidade", oldUnidade, unidade);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public Integer getQuantTotal() {
        return quantTotal;
    }

    public void setQuantTotal(Integer quantTotal) {

        Integer oldQuantTotal = this.quantTotal;
        this.quantTotal = quantTotal;
        changeSupport.firePropertyChange("quantTotal", oldQuantTotal, quantTotal);
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicamento != null ? idmedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idmedicamento == null && other.idmedicamento != null) || (this.idmedicamento != null && !this.idmedicamento.equals(other.idmedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome + " em " + tipo;
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public int compareTo(Medicamento t) {
        String aux = nome.toLowerCase();
        String aux2  = t.getNome().toLowerCase();
       return aux.compareTo(aux2);
    }

}
