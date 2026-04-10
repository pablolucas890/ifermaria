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
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "estoque", catalog = "db_enfermagem", schema = "")
public class Estoque implements Serializable, Comparable<Estoque> {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idestoque")
    private Integer idestoque;
    @Column(name = "dataValidade")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataValidade;
    @Column(name = "lote")
    private String lote;
    @Column(name = "quantRetirada")
    private String quantRetirada;
    @Column(name = "dataEntrada")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "quant_atual")
    private Integer quantAtual;
    @Column(name = "quantAntiga")
    private Integer quantAntiga;
    @ManyToOne
    private Medicamento medicamento;

    @ManyToMany(mappedBy = "estoque")
    List<Atendimento> atendimentos = new ArrayList<>();

    public Integer getIdestoque() {
        return idestoque;
    }

    public void setIdestoque(Integer idestoque) {
        Integer oldIdestoque = this.idestoque;
        this.idestoque = idestoque;
        changeSupport.firePropertyChange("idestoque", oldIdestoque, idestoque);
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public String getQuantRetirada() {
        return quantRetirada;
    }

    public void setQuantRetirada(String quantRetirada) {
        String oldQuantRetirada = this.quantRetirada;
        this.quantRetirada = quantRetirada;
        changeSupport.firePropertyChange("quantRetirada", oldQuantRetirada, quantRetirada);
    }

    public void setMedicamento(Medicamento medicamento) {
        Medicamento oldMedicamento = this.medicamento;
        this.medicamento = medicamento;
        changeSupport.firePropertyChange("medicamento", oldMedicamento, medicamento);
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        Date oldDataValidade = this.dataValidade;
        this.dataValidade = dataValidade;
        changeSupport.firePropertyChange("dataValidade", oldDataValidade, dataValidade);
    }

    public Integer getQuantAntiga() {
        return quantAntiga;
    }

    public void setQuantAntiga(Integer quantAntiga) {
        Integer oldQuantAntiga = this.quantAntiga;
        this.quantAntiga = quantAntiga;
        changeSupport.firePropertyChange("quantAntiga", oldQuantAntiga, quantAntiga);
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        String oldLote = this.lote;
        this.lote = lote;
        changeSupport.firePropertyChange("lote", oldLote, lote);
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        Date oldDataEntrada = this.dataEntrada;
        this.dataEntrada = dataEntrada;
        changeSupport.firePropertyChange("dataEntrada", oldDataEntrada, dataEntrada);
    }

    public Integer getQuantAtual() {
        return quantAtual;
    }

    public void setQuantAtual(Integer quantAtual) {

        Integer oldQuantAtual = this.quantAtual;
        this.quantAtual = quantAtual;
        changeSupport.firePropertyChange("quantAtual", oldQuantAtual, quantAtual);

//        int quantTotalAntiga = medicamento.getQuantTotal();
//        int quantSub = oldQuantAtual - quantAtual;
//        int quantTotalNova = quantTotalAntiga - quantSub;
//        medicamento.setQuantTotal(quantTotalNova);
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
        hash += (idestoque != null ? idestoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.idestoque == null && other.idestoque != null) || (this.idestoque != null && !this.idestoque.equals(other.idestoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String dataNovaString = "";
        String loteStr = "";
        if (dataValidade != null) {
            String dataAntigaDate = dataValidade.toString();
            String ano = dataAntigaDate.substring(0, 4);
            String mes = dataAntigaDate.substring(5, 7);
            String dia = dataAntigaDate.substring(8, 10);
            dataNovaString = dia + "/" + mes + "/" + ano;
        }
        if (lote != null) {
            loteStr = lote;
        }

        return medicamento.toString() + ", Lote: " + loteStr + ", Validade: " + dataNovaString;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public int compareTo(Estoque t) {
        String aux = medicamento.getNome().toLowerCase();
        String aux2 = medicamento.getNome().toLowerCase();
        return aux.compareTo(aux2);
    }

}
