/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AtendimentoTela.java
 *
 * Created on 26/01/2010, 20:43:23
 */
package sgalfa.visao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import sgalfa.controle.AtendimentoControle;
import sgalfa.controle.ClienteControle;
import sgalfa.controle.FuncionarioControle;
import sgalfa.entidades.Atendimento;
import sgalfa.entidades.Cliente;
import sgalfa.entidades.Funcionario;

/**
 *
 * @author Administrador
 */
public class AtendimentoTela extends javax.swing.JFrame {

    private ClienteControle conCli;
    private FuncionarioControle conFun;
    private Atendimento objeto;
    private AtendimentoControle controle;
    private List<Atendimento> lista;
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    Boolean teste;

    AtendimentoTela(Atendimento objetoEnvio, String situacao) {
        initComponents();
        controle = AtendimentoControle.getInstance();
        conCli = ClienteControle.getInstance();
        conFun = FuncionarioControle.getInstance();
        objeto = objetoEnvio;
        montaComboFuniconario();
        montaComboCliente();

        if (situacao.equals("alterar")) {
            tabelaMouseClicked(objeto);
        } else if (situacao.equals("novo")) {
            btNovoActionPerformed(null);
        }


    }

    public void Alterar() {
        if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para alterar!");
        } else {
            botoes("alterar");
            cCliente.requestFocus();
        }


    }

    /** Creates new form AtendimentoTela */
    public void montaComboCliente() {
        clientes = new ArrayList<Cliente>();
        clientes = conCli.listaTodos();
        cCliente.removeAllItems();
        for (Iterator<Cliente> it = clientes.iterator(); it.hasNext();) {
            Cliente c = it.next();
            cCliente.addItem(c.getNome());
        }
    }

    public void montaComboFuniconario() {
        funcionarios = new ArrayList<Funcionario>();
        funcionarios = conFun.listaTodos();
        cFuncionario.removeAllItems();
        for (Iterator<Funcionario> it = funcionarios.iterator(); it.hasNext();) {
            Funcionario f = it.next();
            cFuncionario.addItem(f.getNome());
        }
    }

    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            fData.setEnabled(false);
            fObs.setEnabled(false);
            fValor.setEditable(false);
            cEstado.setEnabled(false);
            cFuncionario.setEnabled(false);
            jLabel7.setEnabled(false);
            jLabel8.setEnabled(false);
            jLabel9.setEnabled(false);
            jLabel11.setEnabled(false);
            jLabel12.setEnabled(false);
            cCliente.setEnabled(false);
            btNovo.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);

        } else if (acao.equals("novo") || acao.equals("alterar")) {
            fData.setEnabled(true);
            jLabel7.setEnabled(true);
            jLabel8.setEnabled(true);
            jLabel9.setEnabled(true);
            jLabel11.setEnabled(true);
            jLabel12.setEnabled(true);
            fObs.setEnabled(true);
            fValor.setEditable(true);
            cEstado.setEnabled(true);           
            cFuncionario.setEnabled(true);
            cCliente.setEnabled(true);
            btNovo.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);

        } else if (acao.equals("inicio") || acao.equals("cancelar")
                || acao.equals("salvar")) {
            fData.setEnabled(false);
            fValor.setEditable(false);
            jLabel7.setEnabled(false);
            jLabel8.setEnabled(false);
            jLabel9.setEnabled(false);
            jLabel11.setEnabled(false);
            jLabel12.setEnabled(false);
            fObs.setEnabled(false);
            cFuncionario.setEnabled(false);
            cEstado.setEnabled(false);
            cCliente.setEnabled(false);
            btNovo.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);

        }
    }

    public boolean verificaCampos() {
        if (cCliente.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Cliente deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cCliente.requestFocus();
            return false;
        } else if (cFuncionario.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Funcionario deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cFuncionario.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public Atendimento getObjeto() {
        return objeto;
    }

    public void setObjeto(Atendimento objeto) {
        this.objeto = objeto;
    }


    public AtendimentoTela() {
        initComponents();
        controle = AtendimentoControle.getInstance();
        conCli = ClienteControle.getInstance();
        conFun = FuncionarioControle.getInstance();

        botoes("inicio");
        montaComboCliente();
        montaComboFuniconario();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rotuloId = new javax.swing.JLabel();
        fId = new javax.swing.JTextField();
        cCliente = new javax.swing.JComboBox();
        fData = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cEstado = new javax.swing.JComboBox();
        cFuncionario = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fObs = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fValor = new sgalfa.util.JMoneyField();

        jLabel10.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordem de Serviço");
        setResizable(false);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Users.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/filesave-32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Cancel-32.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Gnome-Application-Exit-32.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setText("Estado:");

        jLabel2.setText("Cliente:");

        rotuloId.setText("Código:");

        fId.setEditable(false);

        jLabel5.setText("Data:");

        cEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativa", "Cancelada", "Finalizada", "Urgente" }));

        cFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Técnico:");

        fObs.setColumns(20);
        fObs.setRows(5);
        jScrollPane1.setViewportView(fObs);

        jLabel4.setText("Obs:");

        jLabel6.setText("Valor:");

        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("*");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("*");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("*");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("(*) Campos Obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rotuloId)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                    .addComponent(cEstado, 0, 400, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fData, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addComponent(cCliente, 0, 400, Short.MAX_VALUE)
                                    .addComponent(cFuncionario, 0, 400, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fValor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel8)))
                    .addComponent(rotuloId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(fData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(fValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addGap(10, 10, 10)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btNovo, btSair, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSair)
                    .addComponent(btCancelar)
                    .addComponent(btSalvar)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancelar, btNovo, btSair, btSalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed

        dispose();

    }//GEN-LAST:event_btSairActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        botoes("novo");
        fData.setDate(new Date());
        fObs.setText("");
        fValor.setText("");
        cEstado.setSelectedItem(null);
        cCliente.setSelectedItem(null);
        cFuncionario.setSelectedItem(null);
        fId.setText("");

    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (verificaCampos() == true) {
            objeto = new Atendimento();
            objeto.setCliente(clientes.get(cCliente.getSelectedIndex()));
            objeto.setFuncionario(funcionarios.get(cFuncionario.getSelectedIndex()));
            objeto.setDataOrdemServico(fData.getDate());
            objeto.setEstado(String.valueOf(cEstado.getSelectedItem()));
            objeto.setObs(fObs.getText());
            String valor = fValor.getText();
            valor = valor.replace(".", "");
            valor = valor.replace(",", ".");
            objeto.setValor(new BigDecimal(valor));
            if (fId.getText().equals("")) {
                objeto.setId(null);
            } else {
                objeto.setId(Long.parseLong(fId.getText()));
            }
            objeto.setHoraServiço(String.valueOf(getHora()));
            controle.salvar(objeto);
            AtendimentoBuscaTela tela = new AtendimentoBuscaTela();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            tela.montaTabela("normal");
            dispose();


        }


    }//GEN-LAST:event_btSalvarActionPerformed

    public String getHora() {

        // cria um StringBuilder
        StringBuilder sb = new StringBuilder();

        // cria um GregorianCalendar que vai conter a hora atual
        GregorianCalendar d = new GregorianCalendar();

        // anexa do StringBuilder os dados da hora
        sb.append(d.get(GregorianCalendar.HOUR_OF_DAY));
        sb.append(":");
        sb.append(d.get(GregorianCalendar.MINUTE));
        sb.append(":");
        sb.append(d.get(GregorianCalendar.SECOND));

        // retorna a String do StringBuilder
        return sb.toString();
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        botoes("cancelar");

    }//GEN-LAST:event_btCancelarActionPerformed

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
       jLabel7.setToolTipText("Preenchimeto Obrigatório");  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
       jLabel8.setToolTipText("Preenchimeto Obrigatório"); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
jLabel9.setToolTipText("Preenchimeto Obrigatório");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
jLabel11.setToolTipText("Preenchimeto Obrigatório");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AtendimentoTela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cCliente;
    private javax.swing.JComboBox cEstado;
    private javax.swing.JComboBox cFuncionario;
    private com.toedter.calendar.JDateChooser fData;
    private javax.swing.JTextField fId;
    private javax.swing.JTextArea fObs;
    private sgalfa.util.JMoneyField fValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rotuloId;
    // End of variables declaration//GEN-END:variables

    private void tabelaMouseClicked(Atendimento objeto) {
        setObjeto(objeto);
        fId.setText(String.valueOf(this.objeto.getId()));
        fData.setDate(this.objeto.getDataOrdemServico());
        fObs.setText(this.objeto.getObs());
        fValor.setText(String.valueOf(this.objeto.getValor()));
        cCliente.setSelectedItem(this.objeto.getCliente().getNome());
        cFuncionario.setSelectedItem(this.objeto.getFuncionario().getNome());
        cEstado.setSelectedItem(this.objeto.getEstado());
        botoes("alterar");
    }
}
