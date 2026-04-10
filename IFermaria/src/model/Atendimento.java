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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import javax.persistence.Temporal;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "atendimento", catalog = "db_enfermagem", schema = "")
public class Atendimento implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAtendimanto")
    private Integer idAtendimanto;
    @Column(name = "dataAtendimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimento;
    @Column(name = "hora")
    private String hora;
    @Column(name = "conduta")
    private String conduta;
    @Column(name = "queixa")
    private String queixa;
    @Column(name = "horaSaida")
    private String horaSaida;
    @Column(name = "encaminhamento")
    private String encaminhamento;
    @Column(name = "quantRetirada")
    private String quantRetirada;
    @ManyToOne
    private Aluno aluno;

    @ManyToMany
    private List<Enfermidade> enfermidades = new ArrayList<>();

    @ManyToMany
    private List<Estoque> estoque = new ArrayList<>();

    @ManyToOne
    private Atendente atendente;

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        Atendente oldAtendente = this.atendente;
        this.atendente = atendente;
        changeSupport.firePropertyChange("atendente", oldAtendente, atendente);
    }

    public String getQuantRetirada() {
        return quantRetirada;
    }

    public void setQuantRetirada(String quantRetirada) {
        String oldQuantRetirada = this.quantRetirada;
        this.quantRetirada = quantRetirada;
        changeSupport.firePropertyChange("quantRetirada", oldQuantRetirada, quantRetirada);
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {

        String oldHoraSaida = this.horaSaida;
        this.horaSaida = horaSaida;
        changeSupport.firePropertyChange("horaSaida", oldHoraSaida, horaSaida);

    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        String oldQueixa = this.queixa;
        this.queixa = queixa;
        changeSupport.firePropertyChange("queixa", oldQueixa, queixa);

    }

    public Integer getIdAtendimanto() {
        return idAtendimanto;
    }

    public void setIdAtendimanto(Integer idAtendimanto) {
        Integer oldIdAtendimanto = this.idAtendimanto;
        this.idAtendimanto = idAtendimanto;
        changeSupport.firePropertyChange("idAtendimanto", oldIdAtendimanto, idAtendimanto);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        Aluno oldAluno = this.aluno;
        this.aluno = aluno;
        changeSupport.firePropertyChange("aluno", oldAluno, aluno);

    }

    public List<Enfermidade> getEnfermidades() {
        return enfermidades;
    }

    public void setEnfermidades(List<Enfermidade> enfermidade) {
        List<Enfermidade> oldEnfermidade = this.enfermidades;
        this.enfermidades = enfermidade;
        changeSupport.firePropertyChange("enfermidades", oldEnfermidade, enfermidade);
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        Date oldDataAtendimento = this.dataAtendimento;
        this.dataAtendimento = dataAtendimento;
        changeSupport.firePropertyChange("dataAtendimento", oldDataAtendimento, dataAtendimento);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        String oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        String oldEncaminhamento = this.encaminhamento;
        this.encaminhamento = encaminhamento;
        changeSupport.firePropertyChange("encaminhamento", oldEncaminhamento, encaminhamento);

    }

    public String getConduta() {
        return conduta;
    }

    public void setConduta(String conduta) {
        String oldConduta = this.conduta;
        this.conduta = conduta;
        changeSupport.firePropertyChange("conduta", oldConduta, conduta);
    }

    public List<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Estoque> estoque) {
        List<Estoque> oldEstoque = this.estoque;
        this.estoque = estoque;
        changeSupport.firePropertyChange("estoque", oldEstoque, estoque);
    }

    public void addMedicamento(Estoque estoque) {
        this.estoque.add(estoque);
    }

    public void removeMedicamento(Estoque estoque) {
        this.estoque.remove(estoque);
    }

    public Estoque getMedicamentoEstoque(int index) {
        return this.estoque.get(index);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtendimanto != null ? idAtendimanto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendimento)) {
            return false;
        }
        Atendimento other = (Atendimento) object;
        if ((this.idAtendimanto == null && other.idAtendimanto != null) || (this.idAtendimanto != null && !this.idAtendimanto.equals(other.idAtendimanto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data: " + getDataAtendimento();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
