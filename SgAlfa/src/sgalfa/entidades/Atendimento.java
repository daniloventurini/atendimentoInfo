/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Gustavo
 */
@Entity
public class Atendimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;
    @Column (length=20)
    private String estado;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataOrdemServico;
    @Column (length=20)
    private String horaServiço;
    @Column (length=300)
    private String obs;
    @Column
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }



    public String getHoraServiço() {
        return horaServiço;
    }

    public void setHoraServiço(String horaServiço) {
        this.horaServiço = horaServiço;
    }



    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataOrdemServico() {
        return dataOrdemServico;
    }

    public void setDataOrdemServico(Date dataOrdemServico) {
        this.dataOrdemServico = dataOrdemServico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Atendimento() {
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendimento)) {
            return false;
        }
        Atendimento other = (Atendimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemacurso.entidades.OrdemServico[id=" + id + "]";
    }

}
