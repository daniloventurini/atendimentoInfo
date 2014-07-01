/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProdutoTela.java
 *
 * Created on 26/01/2010, 20:43:23
 */
package sgalfa.visao;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import sgalfa.controle.GrupoControler;
import sgalfa.controle.ProdutoControle;
import sgalfa.entidades.Funcionario;
import sgalfa.entidades.Grupo;
import sgalfa.entidades.Produto;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Administrador
 */
public class ProdutoTela extends javax.swing.JFrame {

    private Produto objeto;
    private ProdutoControle controle;
    private GrupoControler gruControle;
    private List<Produto> lista;
    private List<Grupo> grupos;
    public boolean verifica = false;

    /** Creates new form ProdutoTela */
    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            fProduto.setEditable(false);
            fValor.setEditable(false);
            fQnt.setEditable(false);
            fDescricao.setEditable(false);
            btNovo.setEnabled(true);
            cGrupo.setEnabled(false);
            btAlterar.setEnabled(true);
            btExcluir.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            tabela.setEnabled(true);
            jLabel5.setEnabled(false);
            jLabel6.setEnabled(false);
            jLabel8.setEnabled(false);
        } else if (acao.equals("novo") || acao.equals("alterar")) {
            fProduto.setEditable(true);
            fValor.setEditable(true);
            fQnt.setEditable(true);
            fDescricao.setEditable(true);
            cGrupo.setEnabled(true);
            btNovo.setEnabled(false);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);
            tabela.setEnabled(false);
            jLabel5.setEnabled(true);
            jLabel6.setEnabled(true);
            jLabel8.setEnabled(true);
        } else if (acao.equals("inicio") || acao.equals("cancelar")
                || acao.equals("salvar")) {
            fProduto.setEditable(false);
            fValor.setEditable(false);
            fQnt.setEditable(false);
            fDescricao.setEditable(false);
            btNovo.setEnabled(true);
            cGrupo.setEnabled(false);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            tabela.setEnabled(true);
            jLabel5.setEnabled(false);
            jLabel6.setEnabled(false);
            jLabel8.setEnabled(false);
        }
    }

    public boolean verificaCampos() {
        if (fProduto.getText().equals("") || fProduto.getText() == null) {
            JOptionPane.showMessageDialog(null, "O campo Produto deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fProduto.requestFocus();
            return false;
        } else if (cGrupo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Grupo deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fValor.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void montaTabela() {
        String texto = "<html><font color=RED>Em Falta</font></html>";//COR NO TEXTO VERMELHA
        lista = controle.montaLista(cFiltro.getSelectedIndex(), fFiltro.getText());
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Produto");
        modelo.addColumn("Descrição");
        modelo.addColumn("Valor");
        modelo.addColumn("Quantidade");
        modelo.addColumn("P/ Falta");

        for (Iterator<Produto> it = lista.iterator(); it.hasNext();) {
            Produto cid = it.next();
            if (cid.getQnt() <= 2) {
                modelo.addRow(new Object[]{cid.getNomeProduto(), cid.getDescricao(), cid.getValor(), cid.getQnt(), texto});
            } else {
                modelo.addRow(new Object[]{cid.getNomeProduto(), cid.getDescricao(), cid.getValor(), cid.getQnt()});
            }
        }
        tabela.setModel(modelo);
    }
    //--------------------------------------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------------------------------------
    public Produto getObjeto() {
        return objeto;
    }

    public void setObjeto(Produto objeto) {
        this.objeto = objeto;
    }

    public ProdutoTela() {
        initComponents();
        controle = ProdutoControle.getInstance();
        gruControle = GrupoControler.getInstance();
        montaTabela();
        limpaCombos();
        montaComboGrupo();
        botoes("inicio");
        //-------------------------VERIFICA QUANTIDADE MINIMA----------------------------------------------------------------- 
        for (Produto obj : lista) {
            if (obj.getQnt() <= 2) {
                verifica = true;
            }
        }
        if (verifica == true) {
            JOptionPane.showMessageDialog(null, "A produtos que atigiram a quantidade minima! Favor Verificar",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        //-------------------------VERIFICA QUANTIDADE MINIMA----------------------------------------------------------------- 
    }

    public void limpaCombos() {
        cGrupo.setSelectedItem(null);
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
        btSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fProduto = new javax.swing.JTextField();
        rotuloId = new javax.swing.JLabel();
        fId = new javax.swing.JTextField();
        fDescricao = new javax.swing.JTextField();
        fValor = new sgalfa.util.JMoneyField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cGrupo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        fQnt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fFiltro = new javax.swing.JTextField();
        cFiltro = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");
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

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Gnome-Application-Exit-32.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setText("Produto");

        jLabel2.setText("Descrição");

        rotuloId.setText("Código");

        fId.setEditable(false);

        jLabel4.setText("Valor:");

        jLabel5.setText("Grupo:");

        cGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Quantidade:");

        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("*");

        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("(*) Campos Obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(rotuloId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fDescricao)
                            .addComponent(fValor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fQnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel9))
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

        jLabel3.setText("Filtro");

        cFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Produto", "Descrição" }));

        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("|<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("<");

        jButton4.setText(">");

        jButton5.setText(">|");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addGap(10, 10, 10)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSair)
                        .addComponent(btCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed

        dispose();

    }//GEN-LAST:event_btSairActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        botoes("novo");
        fProduto.setText("");
        fQnt.setText("");
        fValor.setText("");
        fId.setText("");
        cGrupo.setSelectedItem(null);
        fDescricao.setText("");
        fProduto.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para alterar!");
        } else {
            botoes("alterar");
            fProduto.requestFocus();
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
            objeto = new Produto();
            objeto.setGrupo(grupos.get(cGrupo.getSelectedIndex()));
            objeto.setNomeProduto(fProduto.getText());
            objeto.setQnt(Integer.parseInt(fQnt.getText()));
            objeto.setDescricao(fDescricao.getText());
            String val = fValor.getText().replace(".", "");
            val = val.replace(",", ".");
            objeto.setValor(new BigDecimal(val));
            if (fId.getText().equals("")) {
                objeto.setId(null);
            } else {
                objeto.setId(Long.parseLong(fId.getText()));
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
        fProduto.setText(objeto.getNomeProduto());
        fDescricao.setText(objeto.getDescricao());
        fQnt.setText(String.valueOf(objeto.getQnt()));
        fValor.setText(String.valueOf(objeto.getValor()));
        cGrupo.setSelectedItem(objeto.getGrupo().getNome());
        botoes("selecionado");
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        montaTabela();

    }//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ProdutoTela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cFiltro;
    private javax.swing.JComboBox cGrupo;
    private javax.swing.JTextField fDescricao;
    private javax.swing.JTextField fFiltro;
    private javax.swing.JTextField fId;
    private javax.swing.JTextField fProduto;
    private javax.swing.JTextField fQnt;
    private sgalfa.util.JMoneyField fValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
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

    public void montaComboGrupo() {
        grupos = gruControle.listaTodos();
        cGrupo.removeAllItems();
        for (Iterator<Grupo> it = grupos.iterator(); it.hasNext();) {
            Grupo g = it.next();
            cGrupo.addItem(g.getNome());
        }
    }
}
