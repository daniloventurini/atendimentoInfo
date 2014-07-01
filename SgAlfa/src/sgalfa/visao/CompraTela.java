/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CompraTela.java
 *
 * Created on 26/01/2010, 20:43:23
 */
package sgalfa.visao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sgalfa.controle.ContasReceberControle;
import sgalfa.controle.ProdutoControle;
import sgalfa.controle.CompraControle;
import sgalfa.controle.ContasPagarControle;
import sgalfa.controle.FornecedorControle;
import sgalfa.entidades.Produto;
import sgalfa.entidades.Compra;
import sgalfa.entidades.ContasPagar;
import sgalfa.entidades.Fornecedor;

/**
 *
 * @author Administrador
 */
public class CompraTela extends javax.swing.JFrame {

    private Compra objeto;
    private CompraControle controle;
    private ContasPagarControle controleConta;
    private List<Compra> lista;
    private List<Fornecedor> fornecedores;
    private List<Produto> produtos;
    private FornecedorControle conCli;
    private ProdutoControle conPro;

    /** Creates new form CompraTela */
    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            cFOrnecedor.setEnabled(false);
            cFormaPagamento.setEnabled(false);
            fData.setEnabled(false);
            jLabel6.setEnabled(false);
            jLabel9.setEnabled(false);
            jLabel10.setEnabled(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(true);
            btExcluir.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair2.setEnabled(true);
            tabela.setEnabled(true);
            btAddItens.setEnabled(false);
        } else if (acao.equals("novo") || acao.equals("alterar")) {
            cFOrnecedor.setEnabled(true);
            cFormaPagamento.setEnabled(true);
            fData.setEnabled(true);
            jLabel6.setEnabled(true);
            jLabel9.setEnabled(true);
            jLabel10.setEnabled(true);
            btNovo.setEnabled(false);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair2.setEnabled(false);
            tabela.setEnabled(false);
            btAddItens.setEnabled(true);
        } else if (acao.equals("inicio") || acao.equals("cancelar")
                || acao.equals("salvar")) {
            cFOrnecedor.setEnabled(false);
            cFormaPagamento.setEnabled(false);
            fData.setEnabled(false);
            jLabel6.setEnabled(false);
            jLabel9.setEnabled(false);
            jLabel10.setEnabled(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair2.setEnabled(true);
            tabela.setEnabled(true);
            btAddItens.setEnabled(false);
        }
    }

    public boolean verificaCampos() {
        if (cFOrnecedor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Fornecedor deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cFOrnecedor.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void montaTabela() {
        lista = controle.listaCriterio(fFiltroData1.getDate(), fFiltroData2.getDate(), fFiltroCliente.getText());
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Data");
        modelo.addColumn("Cliente");
        modelo.addColumn("Valor");
        modelo.addColumn("Valor Restante");
        for (Iterator<Compra> it = lista.iterator(); it.hasNext();) {
            Compra cid = it.next();
            modelo.addRow(new Object[]{cid.getDataCompra(), cid.getFornecedor().getNome(), cid.getValor(), cid.getValorRestante()});
        }
        tabela.setModel(modelo);
    }

    public void montaComboCliente() {
        fornecedores = new ArrayList<Fornecedor>();
        fornecedores = conCli.listaTodos();
        cFOrnecedor.removeAllItems();
        for (Iterator<Fornecedor> it = fornecedores.iterator(); it.hasNext();) {
            Fornecedor c = it.next();
            cFOrnecedor.addItem(c.getNome());
        }
    }

    public Compra getObjeto() {
        return objeto;
    }

    public void setObjeto(Compra objeto) {
        this.objeto = objeto;
    }

    public CompraTela() {
        initComponents();
        controle = CompraControle.getInstance();
        conCli = FornecedorControle.getInstance();
        conPro = ProdutoControle.getInstance();
        controleConta = ContasPagarControle.getInstance();
        montaComboCliente();
        limpaCombos();
        montaTabela();
        botoes("inicio");
    }

     public void limpaCombos(){
        cFOrnecedor.setSelectedItem(null);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rotuloId = new javax.swing.JLabel();
        fId = new javax.swing.JTextField();
        cFOrnecedor = new javax.swing.JComboBox();
        fData = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btAddItens = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cFormaPagamento = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fValor = new sgalfa.util.JMoneyField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fFiltroCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        fFiltroData1 = new com.toedter.calendar.JDateChooser();
        fFiltroData2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btSair2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação de Compra");
        setResizable(false);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Users.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Refresh-32.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Cross-32.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/filesave-32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Cancel-32.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setText("Fornecedor:");

        rotuloId.setText("Código");

        fId.setEditable(false);

        jLabel4.setText("Data");

        jLabel5.setText("Valor Total");

        btAddItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/produto apply.png"))); // NOI18N
        btAddItens.setText("Produtos");
        btAddItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddItensActionPerformed(evt);
            }
        });

        jLabel2.setText("Forma de Pagamento:");

        cFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A vista", "A prazo " }));
        cFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cFormaPagamentoActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("(*) Campos Obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addComponent(fValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAddItens, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rotuloId)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fData, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(174, 174, 174))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cFOrnecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloId)
                    .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cFOrnecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btAddItens)
                    .addComponent(jLabel9))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel3.setText("Fornecedor");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Search-32.png"))); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Data Inicial");

        jLabel8.setText("Data Final");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fFiltroData1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fFiltroData2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fFiltroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fFiltroData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(fFiltroData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btSair2.setText("Sair");
        btSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSair2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair2, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSalvar)
                            .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btCancelar))
                    .addComponent(btSair2))
                .addGap(36, 36, 36))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btExcluir, btNovo, btSalvar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancelar, btSair2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        botoes("novo");
        cFOrnecedor.setSelectedItem(null);
        fId.setText("");
        fValor.setText("");
      
        fData.setDate(new Date());
        fData.requestFocus();
        objeto = new Compra();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para alterar!");
        } else {
            botoes("alterar");
            fData.requestFocus();
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para Excluir!");
        } else {
            Object[] options = {"Sim", "Não"};
            int i = JOptionPane.showOptionDialog(null,
                    "Tem certeza que deseja excluir este registro?",
                    "Atenção!!!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (i == JOptionPane.YES_OPTION) {
                try {
                    setObjeto(lista.get(tabela.getSelectedRow()));
                    controle.excluir(objeto);
                    montaTabela();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "O registro não pode ser"
                            + "excluido porque possui dependências!");
                }
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (verificaCampos() == true) {
            objeto.setFornecedor(fornecedores.get(cFOrnecedor.getSelectedIndex()));
            objeto.setPagamento(String.valueOf(cFormaPagamento.getSelectedItem()));
            objeto.setDataCompra(fData.getDate());
            String val = fValor.getText().replace(".", "");
            val = val.replace(",", ".");
            objeto.setValor(new BigDecimal(val));

           
                        
           
            if (fId.getText().equals("")) {
                objeto.setId(null);
            } else {
                objeto.setId(Long.parseLong(fId.getText()));
            }

           if (cFormaPagamento.getSelectedIndex() == 1) {
                ContasPagar pg = new ContasPagar();
                pg.setFornecedor(objeto.getFornecedor());
                pg.setDataConta(objeto.getDataCompra());
                pg.setValor(objeto.getValor());
                controleConta.salvar(pg);
            }
           
            controle.salvar(objeto);

            botoes("salvar");
            montaTabela();
          
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        botoes("cancelar");

    }//GEN-LAST:event_btCancelarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        setObjeto(lista.get(tabela.getSelectedRow()));
        fId.setText(String.valueOf(objeto.getId()));
        if (objeto.getPagamento().equals("A vista")) {
            cFormaPagamento.setSelectedIndex(0);
        }
        if (objeto.getPagamento().equals("A prazo")) {
            cFormaPagamento.setSelectedIndex(1);
        }
        if (objeto.getPagamento().equals("Cheque")) {
            cFormaPagamento.setSelectedIndex(2);
        }
        cFOrnecedor.setSelectedItem(objeto.getFornecedor().getNome());
        fValor.setText(String.valueOf(objeto.getValor()));
        fData.setDate(objeto.getDataCompra());

        botoes("selecionado");
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        montaTabela();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAddItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddItensActionPerformed

        if (verificaCampos() == true) {

            objeto.setDataCompra(fData.getDate());
            objeto.setFornecedor(fornecedores.get(cFOrnecedor.getSelectedIndex()));
            String valor = fValor.getText();
            valor = valor.replace(".", "");
            valor = valor.replace(",", ".");
            objeto.setValor(new BigDecimal(valor));
            if (fId.getText().equals("")) {
                objeto.setId(null);
            } else {
                objeto.setId(Long.parseLong(fId.getText()));
            }
            ItensCompraForm tela = new ItensCompraForm(new javax.swing.JFrame(), true, objeto);
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            objeto = tela.getObjCompra();
            fValor.setText(String.valueOf(tela.getTotalGeral()));

        }
    }//GEN-LAST:event_btAddItensActionPerformed

    private void cFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cFormaPagamentoActionPerformed
      
    }//GEN-LAST:event_cFormaPagamentoActionPerformed

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
     jLabel6.setToolTipText("Preenchimeto Obrigatório");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
           jLabel6.setToolTipText("Preenchimeto Obrigatório");  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseEntered

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btSair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair2ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btSair2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CompraTela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddItens;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair2;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cFOrnecedor;
    private javax.swing.JComboBox cFormaPagamento;
    private com.toedter.calendar.JDateChooser fData;
    private javax.swing.JTextField fFiltroCliente;
    private com.toedter.calendar.JDateChooser fFiltroData1;
    private com.toedter.calendar.JDateChooser fFiltroData2;
    private javax.swing.JTextField fId;
    private sgalfa.util.JMoneyField fValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rotuloId;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
