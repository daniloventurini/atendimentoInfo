/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Administrador
 */
@Entity
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCompra;
    @ManyToOne
    private Fornecedor fornecedor;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="compra", targetEntity=ItensCompra.class, fetch=FetchType.LAZY)
    private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
    @Column
    private BigDecimal valor;
    @Column (length=10)
    private String pagamento;
    @Column
    private BigDecimal valorDepositado;
    @Column
    private BigDecimal valorRestante;

    public String  getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }




    public BigDecimal getValorDepositado() {
        return valorDepositado;
    }

    public void setValorDepositado(BigDecimal valorDepositado) {
        this.valorDepositado = valorDepositado;
    }

    public BigDecimal getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(BigDecimal valorRestante) {
        this.valorRestante = valorRestante;
    }

    public List<ItensCompra> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItensCompra> itensCompra) {
        this.itensCompra = itensCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

  
 

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }


    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Compra() {
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
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemacurso.entidades.Compra[id=" + id + "]";
    }

}
