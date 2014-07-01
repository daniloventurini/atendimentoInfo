/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MatriculaTela.java
 *
 * Created on 26/01/2010, 20:43:23
 */
package sgalfa.visao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sgalfa.controle.ClienteControle;
import sgalfa.controle.ContasReceberControle;
import sgalfa.controle.CursoControler;
import sgalfa.controle.CursosMatriculadosControle;
import sgalfa.controle.ProdutoControle;
import sgalfa.controle.MatriculaControle;
import sgalfa.entidades.Cliente;
import sgalfa.entidades.Curso;
import sgalfa.entidades.CursosMatriculados;
import sgalfa.entidades.Produto;
import sgalfa.entidades.Matricula;

/**
 *
 * @author Administrador
 */
public class MatriculaTela extends javax.swing.JFrame {

    private Matricula objeto;
    private MatriculaControle controle;
    private ContasReceberControle controleConta;
    private List<Matricula> lista;
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private ClienteControle conCli;
    private ProdutoControle conPro;
    private CursosMatriculados objetoCurMat;
    private CursosMatriculadosControle controleCurMat;
    private CursoControler conProd;
    private List<Curso> cursos;
    private List<CursosMatriculados> cursosMatriculados;
    private Curso prod;


    public void limpaCombos(){
        cCliente.setSelectedItem(null);
    }
    /** Creates new form MatriculaTela */
    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            cCliente.setEnabled(false);
            fData.setEnabled(false);
            btCursos.setEnabled(false);
            btNovo.setEnabled(true);
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
            cCliente.setEnabled(true);
            fData.setEnabled(true);
            btCursos.setEnabled(true);
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
            cCliente.setEnabled(false);
            btCursos.setEnabled(false);
            fData.setEnabled(false);
            btNovo.setEnabled(true);
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
        if (cCliente.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Cliente deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cCliente.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void montaTabela() {
        lista = controle.listaTodos();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Data");
        modelo.addColumn("Aluno");

        for (Iterator<Matricula> it = lista.iterator(); it.hasNext();) {
            Matricula cid = it.next();
            modelo.addRow(new Object[]{cid.getId(), cid.getDataMatricula(), cid.getCliente().getNome()});
        }
        tabela.setModel(modelo);
    }

   

    public void montaComboCliente() {
        clientes = new ArrayList<Cliente>();
        clientes = conCli.listaTodos();
        cCliente.removeAllItems();
        for (Iterator<Cliente> it = clientes.iterator(); it.hasNext();) {
            Cliente c = it.next();
            cCliente.addItem(c.getNome());
        }
    }

    public Matricula getObjeto() {
        return objeto;
    }

    public void setObjeto(Matricula objeto) {
        this.objeto = objeto;
    }

    public CursosMatriculados getObjetoCurMat() {
        return objetoCurMat;
    }

    public void setObjetoCurMat(CursosMatriculados objetoCurMat) {
        this.objetoCurMat = objetoCurMat;
    }



    public MatriculaTela() {
        initComponents();
        controle = MatriculaControle.getInstance();
        conCli = ClienteControle.getInstance();
        conPro = ProdutoControle.getInstance();
        controleConta = ContasReceberControle.getInstance();
        controleCurMat = CursosMatriculadosControle.getInstance();
        conProd = CursoControler.getInstance();
        montaComboCliente();
        limpaCombos();
        montaTabela();
        botoes("inicio");
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
        rotuloId = new javax.swing.JLabel();
        fId = new javax.swing.JTextField();
        cCliente = new javax.swing.JComboBox();
        fData = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btCursos = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fFiltroCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Matricula");
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

        jLabel1.setText("Aluno:");

        rotuloId.setText("Código");

        fId.setEditable(false);

        cCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Data");

        btCursos.setText("Cursos");
        btCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCursosActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("(*) Campos Obrigatórios");

        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");

        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rotuloId)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fData, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addGap(164, 164, 164))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloId)
                    .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCursos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
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

        jLabel3.setText("Aluno:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Search-32.png"))); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btSalvar)
                        .addGap(10, 10, 10)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btSair, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSalvar)
                        .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addComponent(btCancelar)))
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed

        dispose();

    }//GEN-LAST:event_btSairActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        botoes("novo");
        cCliente.setSelectedItem(null);
        fId.setText("");

        fData.setDate(new Date());
        fData.requestFocus();
        objeto = new Matricula();
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
            objeto.setCliente(clientes.get(cCliente.getSelectedIndex()));

            objeto.setDataMatricula(fData.getDate());



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

        cCliente.setSelectedItem(objeto.getCliente().getNome());

        fData.setDate(objeto.getDataMatricula());

        botoes("selecionado");
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        montaTabela();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCursosActionPerformed

        if (verificaCampos() == true) {

            objeto.setDataMatricula(fData.getDate());
            objeto.setCliente(clientes.get(cCliente.getSelectedIndex()));

            if (fId.getText().equals("")) {
                objeto.setId(null);
            } else {
                objeto.setId(Long.parseLong(fId.getText()));
            }
            CursosMatriculadosForm tela = new CursosMatriculadosForm(new javax.swing.JFrame(), true, objeto);
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            objeto = tela.getObjMatricula();

        }
}//GEN-LAST:event_btCursosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MatriculaTela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCursos;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cCliente;
    private com.toedter.calendar.JDateChooser fData;
    private javax.swing.JTextField fFiltroCliente;
    private javax.swing.JTextField fId;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rotuloId;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
