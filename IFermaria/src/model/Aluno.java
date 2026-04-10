package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import static java.lang.Character.digit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "aluno", catalog = "db_enfermagem", schema = "")
public class Aluno implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAluno")
    private Integer idAluno;
    @Column(name = "nome")
    private String nome;
    @Column(name = "foto")
    private String foto;

    @Column(name = "dataNasc")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNasc;

    @Column(name = "nomePai")
    private String nomePai;
    @Column(name = "telefonePai")
    private String telefonePai;
    @Column(name = "nomeMae")
    private String nomeMae;
    @Column(name = "telefoneMae")
    private String telefoneMae;
    @Column(name = "telefoneAluno")
    private String telefoneAluno;
    @Column(name = "cartaoSUS")
    private String cartaoSUS;
    @Column(name = "alergias")
    private String alergias;
    @Column(name = "med_usoContinuo")
    private String medusoContinuo;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "doencas")
    private String doencas;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "area")
    private String area;
    @Column(name = "procedencia")
    private String procedencia;
    @Column(name = "alojamento")
    private String alojamento;

    public String getAlojamento() {
        return alojamento;
    }

    public void setAlojamento(String alojamento) {
        String oldAlojamento = this.alojamento;
        this.alojamento = alojamento;
        changeSupport.firePropertyChange("alojamento", oldAlojamento, alojamento);
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        String oldProcedencia = this.procedencia;
        this.procedencia = procedencia;
        changeSupport.firePropertyChange("procedencia", oldProcedencia, procedencia);
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        Integer oldAno = this.ano;
        this.ano = ano;
        changeSupport.firePropertyChange("ano", oldAno, ano);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        String oldArea = this.area;
        this.area = area;
        changeSupport.firePropertyChange("area", oldArea, area);
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {

        String oldNomeMae = this.nomeMae;
        this.nomeMae = nomeMae;
        changeSupport.firePropertyChange("nomeMae", oldNomeMae, nomeMae);
    }

    public String getTelefoneMae() {
        return telefoneMae;
    }

    public void setTelefoneMae(String telefoneMae) {
        String oldTelefoneMae = this.telefoneMae;
        this.telefoneMae = telefoneMae;
        changeSupport.firePropertyChange("telefoneMae", oldTelefoneMae, telefoneMae);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    @OneToMany(mappedBy = "aluno")
    private List<Atendimento> atendimentos = new ArrayList<>();

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Sala sala;

    public Aluno() {
    }

    public Aluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        Sala oldSala = this.sala;
        this.sala = sala;
        changeSupport.firePropertyChange("sala", oldSala, sala);
    }

    public void setIdAluno(Integer idAluno) {
        Integer oldIdAluno = this.idAluno;
        this.idAluno = idAluno;
        changeSupport.firePropertyChange("idAluno", oldIdAluno, idAluno);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        String oldFoto = this.foto;
        this.foto = foto;
        changeSupport.firePropertyChange("foto", oldFoto, foto);
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        Date oldDataNasc = this.dataNasc;
        this.dataNasc = dataNasc;
        changeSupport.firePropertyChange("dataNasc", oldDataNasc, dataNasc);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        Curso oldCurso = this.curso;
        this.curso = curso;
        changeSupport.firePropertyChange("curso", oldCurso, curso);

    }

    public String getNomePai() {

        return nomePai;
    }

    public void setNomePai(String nomePai) {

        String oldNomePai = this.nomePai;
        this.nomePai = nomePai;
        changeSupport.firePropertyChange("nomePai", oldNomePai, nomePai);
    }

    public String getTelefonePai() {
        return telefonePai;
    }

    public void setTelefonePai(String telefonePai) {

        String oldTelefonePai = this.telefonePai;
        this.telefonePai = telefonePai;
        changeSupport.firePropertyChange("telefonePai", oldTelefonePai, telefonePai);
    }

    public String getTelefoneAluno() {
        return telefoneAluno;
    }

    public void setTelefoneAluno(String telefoneAluno) {
        String oldTelefoneAluno = this.telefoneAluno;
        this.telefoneAluno = telefoneAluno;
        changeSupport.firePropertyChange("telefoneAluno", oldTelefoneAluno, telefoneAluno);
    }

    public String getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        String oldCartaoSUS = this.cartaoSUS;
        this.cartaoSUS = cartaoSUS;
        changeSupport.firePropertyChange("cartaoSUS", oldCartaoSUS, cartaoSUS);
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        String oldAlergias = this.alergias;
        this.alergias = alergias;
        changeSupport.firePropertyChange("alergias", oldAlergias, alergias);
    }

    public String getMedusoContinuo() {
        return medusoContinuo;
    }

    public void setMedusoContinuo(String medusoContinuo) {
        String oldMedusoContinuo = this.medusoContinuo;
        this.medusoContinuo = medusoContinuo;
        changeSupport.firePropertyChange("medusoContinuo", oldMedusoContinuo, medusoContinuo);
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        String oldDoencas = this.doencas;
        this.doencas = doencas;
        changeSupport.firePropertyChange("doencas", oldDoencas, doencas);
    }

    private boolean digitosIguaisCPF(String novoCPF) {
        int i;
        char[] charCPF = novoCPF.toCharArray();
        for (i = 1; i < novoCPF.length() - 1; i++) {
            if (charCPF[i] != charCPF[0]) {
                return (false);
            }
        }
        return (true);
    }

    public int validaCPF(String novoCPF) {

        int i;
        int ok = 0;
        int soma = 0;
        int digitoGerado1,
                digitoGerado2;
        char[] charCPF;
        if (digitosIguaisCPF(novoCPF)) {
            ok = 3;
        } else {
            charCPF = novoCPF.toCharArray();
            for (i = 0; i < novoCPF.length() - 2; i++) {
                soma += digit(charCPF[i], 10) * (10 - i);
            }
            digitoGerado1 = soma % 11;
            if (digitoGerado1 < 2) {
                digitoGerado1 = 0;
            } else {
                digitoGerado1 = 11 - digitoGerado1;
            }

            soma = 0;
            for (i = 0; i < novoCPF.length() - 2; i++) {
                soma += digit(charCPF[i], 10) * (11 - i);
            }
            soma += digitoGerado1 * 2;
            digitoGerado2 = soma % 11;
            if (digitoGerado2 < 2) {
                digitoGerado2 = 0;
            } else {
                digitoGerado2 = 11 - digitoGerado2;
            }
            if ((digit(charCPF[9], 10) != digitoGerado1)
                    || (digit(charCPF[10], 10) != digitoGerado2)) {
                ok = 4;
            }
        }
        return (ok);
    }  //fim do validaCPF

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluno != null ? idAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.idAluno == null && other.idAluno != null) || (this.idAluno != null && !this.idAluno.equals(other.idAluno))) {
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

}
