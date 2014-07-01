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
import javax.persistence.Temporal;

/**
 *
 * @author Gustavo
 */
@Entity
public class Despesas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (length=50)
    private String despesa;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datadespesa;
    @Column
    private BigDecimal valor;
    @Column (length=300)
    private String obs;

    public Date getDatadespesa() {
        return datadespesa;
    }

    public void setDatadespesa(Date datadespesa) {
        this.datadespesa = datadespesa;
    }

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Despesas() {
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
        if (!(object instanceof Despesas)) {
            return false;
        }
        Despesas other = (Despesas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemacurso.entidades.Despesas[id=" + id + "]";
    }

}
