/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PlanoInternetForm.java
 *
 * Created on 05/07/2010, 03:29:09
 */

package sgalfa.visao;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sgalfa.controle.PlanoInternetControler;
import sgalfa.entidades.PlanoInternet;

/**
 *
 * @author pos
 */
public class PlanoInternetTela extends javax.swing.JDialog {

    private PlanoInternet objeto;
    private PlanoInternetControler controle;
    private List<PlanoInternet> lista;

    /** Creates new form PlanoInternetForm */
    public PlanoInternetTela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controle = PlanoInternetControler.getInstance();
        montaTabela();
        validaBotoes("inicio");
    }

    public void montaTabela(){
        lista = controle.montaLista(cOpcao.getSelectedIndex(),
                fFiltro.getText());
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("PlanoInternet");
        modelo.addColumn("Valor");
        for (Iterator<PlanoInternet> it = lista.iterator(); it.hasNext();){
            PlanoInternet planoInternet = it.next();
            modelo.addRow(new Object[]{planoInternet.getId(),
            planoInternet.getDescricao(),planoInternet.getValor()});
        }
        tabela.setModel(modelo);
    }

    public void validaBotoes(String acao){
        if (acao.equals("selecionado")){
            fDescricao.setEnabled(false);
            fValor.setEnabled(false);
            bNovo.setEnabled(true);
            bAlterar.setEnabled(true);
            bExcluir.setEnabled(true);
            bSalvar.setEnabled(false);
            bCancelar.setEnabled(false);
            bSair.setEnabled(true);
             jLabel6.setEnabled(false);
            jLabel8.setEnabled(false);
        } else if (acao.equals("novo") || acao.equals("alterar")){
            fDescricao.setEnabled(true);
            fValor.setEnabled(true);
            bNovo.setEnabled(false);
            bAlterar.setEnabled(false);
            bExcluir.setEnabled(false);
            bSalvar.setEnabled(true);
            bCancelar.setEnabled(true);
            bSair.setEnabled(false);
            tabela.setEnabled(false);
             jLabel6.setEnabled(true);
            jLabel8.setEnabled(true);
        } else if (acao.equals("inicio") ||
              acao.equals("cancelar") || acao.equals("salvar")){
            fDescricao.setEnabled(false);
            fValor.setEnabled(false);
            bNovo.setEnabled(true);
            bAlterar.setEnabled(false);
            bExcluir.setEnabled(false);
            bSalvar.setEnabled(false);
            bCancelar.setEnabled(false);
            bSair.setEnabled(true);
            tabela.setEnabled(true);
             jLabel6.setEnabled(false);
            jLabel8.setEnabled(false);
        }
    }

    public boolean verificaCampos(){
        if (fDescricao.getText().equals("") ||
                fDescricao.getText().equals(null)){
            JOptionPane.showMessageDialog(null,
                    "O campo Nome do planoInternet deve ser preenchio!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fDescricao.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void limpaCampos(){
        fId.setText(null);
        fDescricao.setText(null);
        fValor.setText(null);
    }

    public PlanoInternet getObjeto() {
        return objeto;
    }

    public void setObjeto(PlanoInternet objeto) {
        this.objeto = objeto;
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fId = new javax.swing.JTextField();
        fDescricao = new javax.swing.JTextField();
        fValor = new sgalfa.util.JMoneyField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        fFiltro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cOpcao = new javax.swing.JComboBox();
        bFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        bNovo = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Planos de Internet");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setText("Código:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Valor:");

        fId.setEditable(false);

        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("(*) Campos Obrigatórios");

        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fValor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(fValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        jLabel4.setText("Filtro:");

        cOpcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Descrição" }));

        bFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Search-32.png"))); // NOI18N
        bFiltrar.setText("Filtrar");
        bFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltrarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(bFiltrar)
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Users.png"))); // NOI18N
        bNovo.setText("Novo");
        bNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Cross-32.png"))); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Refresh-32.png"))); // NOI18N
        bAlterar.setText("Alterar");
        bAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/filesave-32.png"))); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Cancel-32.png"))); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Gnome-Application-Exit-32.png"))); // NOI18N
        bSair.setText("Sair");
        bSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bAlterar, bCancelar, bExcluir, bNovo, bSair, bSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovo)
                    .addComponent(bAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bAlterar, bCancelar, bExcluir, bNovo, bSair, bSalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltrarActionPerformed

        montaTabela();
        // TODO add your handling code here:
    }//GEN-LAST:event_bFiltrarActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed

        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bSairActionPerformed

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed

        validaBotoes("novo");
        limpaCampos();
        fDescricao.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_bNovoActionPerformed

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed

        validaBotoes("alterar");
        fDescricao.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_bAlterarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

        setObjeto(lista.get(tabela.getSelectedRow()));
        fId.setText(String.valueOf(objeto.getId()));
        fDescricao.setText(objeto.getDescricao());
        fValor.setText(String.valueOf(objeto.getValor()));
        validaBotoes("selecionado");
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseClicked

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        Object[] options = {"Sim" , "Não"};
        int i = JOptionPane.showOptionDialog(null, "Tem certeza" +
                " que deseja excluir este registro?", "Atenção!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        if (i == JOptionPane.YES_OPTION){
        setObjeto(lista.get(tabela.getSelectedRow()));
        controle.excluir(objeto);
        montaTabela();
        limpaCampos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bExcluirActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed

        if (verificaCampos() == true) {
        objeto = new PlanoInternet();
        objeto.setDescricao(fDescricao.getText());
        String valor = fValor.getText();
        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");
        objeto.setValor(new BigDecimal(valor));
        if (fId.getText().equals("")){
            objeto.setId(null);
        } else {
            objeto.setId(Long.parseLong(fId.getText()));
        }
        controle.salvar(objeto);
        validaBotoes("salvar");
        montaTabela();
        limpaCampos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bSalvarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed

        limpaCampos();
        validaBotoes("cancelar");
        // TODO add your handling code here:
    }//GEN-LAST:event_bCancelarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PlanoInternetTela dialog = new PlanoInternetTela(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bFiltrar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bSair;
    private javax.swing.JButton bSalvar;
    private javax.swing.JComboBox cOpcao;
    private javax.swing.JTextField fDescricao;
    private javax.swing.JTextField fFiltro;
    private javax.swing.JTextField fId;
    private sgalfa.util.JMoneyField fValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
