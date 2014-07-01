/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FornecedorTela.java
 *
 * Created on 26/01/2010, 20:43:23
 */
package sgalfa.visao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import sgalfa.controle.CidadeControle;
import sgalfa.controle.FornecedorControle;
import sgalfa.entidades.Cidade;
import sgalfa.entidades.Fornecedor;

/**
 *
 * @author Administrador
 */
public class FornecedorTela extends javax.swing.JFrame {

    private Fornecedor objeto;
    private FornecedorControle controle;
    private List<Fornecedor> lista;
    private List<Cidade> cidades;
    private CidadeControle conCid;

    /** Creates new form FornecedorTela */
    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            fNome.setEditable(false);
            fRazao.setEditable(false);
            fproprietario.setEditable(false);
            ftelefone1.setEditable(false);
            cstatus.setEditable(false);
            fcelular.setEditable(false);
            email.setEditable(false);
            cCidade.setEnabled(false);
            jLabel12.setEnabled(false);
            jLabel13.setEnabled(false);
            jLabel14.setEnabled(false);
            jLabel15.setEnabled(false);
            jLabel16.setEnabled(false);
            fFax.setEditable(false);
            fCnpj.setEditable(false);
            fEndereco.setEditable(false);
            fNumero.setEditable(false);
            fRg.setEditable(false);
            fTelefone.setEditable(false);
            fbairro.setEditable(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(true);
            btExcluir.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            tabela.setEnabled(true);
        } else if (acao.equals("novo") || acao.equals("alterar")) {
            fNome.setEditable(true);
            fRazao.setEditable(true);
            cCidade.setEnabled(true);
            fproprietario.setEditable(true);
            ftelefone1.setEditable(true);
            cstatus.setEditable(true);
            fcelular.setEditable(true);
            email.setEditable(true);
            fFax.setEditable(true);
            fCnpj.setEditable(true);
            fEndereco.setEditable(true);
            fNumero.setEditable(true);
            fRg.setEditable(true);
            fTelefone.setEditable(true);
            fbairro.setEditable(true);
            jLabel12.setEnabled(true);
            jLabel13.setEnabled(true);
            jLabel14.setEnabled(true);
            jLabel15.setEnabled(true);
            jLabel16.setEnabled(true);
            btNovo.setEnabled(false);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);
            tabela.setEnabled(false);
        } else if (acao.equals("inicio") || acao.equals("cancelar")
                || acao.equals("salvar")) {
            jLabel12.setEnabled(false);
            jLabel13.setEnabled(false);
            jLabel14.setEnabled(false);
            jLabel15.setEnabled(false);
            jLabel16.setEnabled(false);
            fNome.setEditable(false);
            fproprietario.setEditable(false);
            ftelefone1.setEditable(false);
            cstatus.setEditable(false);
            fcelular.setEditable(false);
            email.setEditable(false);
            fRazao.setEditable(false);
            cCidade.setEnabled(false);
            fFax.setEditable(false);
            fCnpj.setEditable(false);
            fEndereco.setEditable(false);
            fNumero.setEditable(false);
            fRg.setEditable(false);
            fTelefone.setEditable(false);
            fbairro.setEditable(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            tabela.setEnabled(true);
        }
    }

    public boolean valida_CpfCnpj(String s_aux) {
        s_aux = s_aux.replace(".", "");
        s_aux = s_aux.replace("-", "");
         s_aux = s_aux.replace("/", "");
//------- Rotina para CPF
        if (s_aux.length() == 11) {
            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++) {
                digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();
//--------- Multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                d1 = d1 + (11 - n_Count) * digitoCPF;
//--------- Para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                d2 = d2 + (12 - n_Count) * digitoCPF;
            }
            ;
//--------- Primeiro resto da divisão por 11.
            resto = (d1 % 11);
//--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;
//--------- Segundo resto da divisão por 11.
            resto = (d2 % 11);
//--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }
//--------- Digito verificador do CPF que está sendo validado.
            String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());
//--------- Concatenando o primeiro resto com o segundo.
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
//--------- Comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
            return nDigVerific.equals(nDigResult);
        } //-------- Rotina para CNPJ
        else if (s_aux.length() == 14) {
            int soma = 0, aux, dig;
            String cnpj_calc = s_aux.substring(0, 12);
            char[] chr_cnpj = s_aux.toCharArray();
//--------- Primeira parte
            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
//--------- Segunda parte
            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        } else {
            return false;
        }
    }

    public boolean verificaCampos() {
        if (fNome.getText().equals("") || fNome.getText() == null) {
            JOptionPane.showMessageDialog(null, "O campo Nome deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fNome.requestFocus();
            return false;
        } else if (valida_CpfCnpj(fCnpj.getText()) == false) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fCnpj.requestFocus();
            return false;

        } else if (cCidade.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Cidade deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cCidade.requestFocus();
            return false;
        } else if (cstatus.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Status deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cstatus.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void montaTabela() {
        lista = controle.montaLista(cFiltro.getSelectedIndex(), fFiltro.getText());
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("CNPJ");
        modelo.addColumn("Inscrição Est.");
        for (Iterator<Fornecedor> it = lista.iterator(); it.hasNext();) {
            Fornecedor cid = it.next();
            modelo.addRow(new Object[]{cid.getNome(), cid.getCnpj(), cid.getInscricao()});
        }
        tabela.setModel(modelo);
    }

    public void montaCombo() {
        cidades = new ArrayList<Cidade>();
        cidades = conCid.listaTodos();

        cCidade.removeAllItems();
        for (Iterator<Cidade> it = cidades.iterator(); it.hasNext();) {
            Cidade ci = it.next();
            cCidade.addItem(ci.getNomeCidade());
        }
    }

    public Fornecedor getObjeto() {
        return objeto;
    }

    public void setObjeto(Fornecedor objeto) {
        this.objeto = objeto;
    }

    public FornecedorTela() {
        initComponents();
        controle = FornecedorControle.getInstance();
        conCid = CidadeControle.getInstance();
        montaCombo();
        limpaCombos();
        montaTabela();
        botoes("inicio");
    }

    public void limpaCombos() {
        cCidade.setSelectedItem(null);
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
        fNome = new javax.swing.JTextField();
        cCidade = new javax.swing.JComboBox();
        rotuloId = new javax.swing.JLabel();
        fId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fbairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fTelefone = new javax.swing.JFormattedTextField();
        fFax = new javax.swing.JFormattedTextField();
        fCnpj = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        fRazao = new javax.swing.JTextField();
        fRg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cstatus = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        ftelefone1 = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        fcelular = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        fproprietario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fFiltro = new javax.swing.JTextField();
        cFiltro = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fornecedor");
        setResizable(false);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Users.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Refresh-32.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgalfa/icones/Cross-32.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
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

        jLabel1.setText("Nome");

        jLabel2.setText("Cidade");

        rotuloId.setText("Código");

        fId.setEditable(false);

        jLabel4.setText("Endereço");

        jLabel6.setText("Numero");

        jLabel7.setText("Bairro");

        jLabel5.setText("Telefone");

        jLabel8.setText("Fax");

        jLabel9.setText("CNPJ:");

        jLabel10.setText("Inscrição Est.");

        try {
            fTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            fFax.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fFax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFaxActionPerformed(evt);
            }
        });

        try {
            fCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Razão Soc.");

        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("*");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("*");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("*");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("(*) Campos Obrigatórios");

        jLabel17.setText("Status:");

        cstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "DESATIVADO", "RE-ATIVADO" }));

        jLabel18.setText("Telefone 2");

        try {
            ftelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel19.setText("Celular:");

        try {
            fcelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel20.setText("Email");

        jLabel21.setText("Proprietário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rotuloId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                                    .addComponent(fNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                                    .addComponent(fRazao, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fbairro, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 485, Short.MAX_VALUE)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fTelefone)
                                        .addComponent(fCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fRg, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ftelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fFax, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(24, 24, 24)
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(80, 80, 80))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fproprietario, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloId)
                    .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(fRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(fbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(fRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel5)
                    .addComponent(fTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel19)
                    .addComponent(fcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(fproprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69))
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

        cFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CPF", "RG" }));

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cFiltro, jButton1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addGap(10, 10, 10)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btSair, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSair)
                        .addComponent(btCancelar)
                        .addComponent(btSalvar))
                    .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        fNome.setText("");
        fRazao.setText("");
        fId.setText("");
        cCidade.setSelectedItem(null);
        fproprietario.setText("");
        ftelefone1.setText("");
        fcelular.setText("");
        cstatus.setSelectedItem("ATIVO");
        email.setText("");
        fFax.setText("");
        fCnpj.setText("");
        fEndereco.setText("");
        fNumero.setText("");
        fRg.setText("");
        fTelefone.setText("");
        fbairro.setText("");
        fNome.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para alterar!");
        } else {
            botoes("alterar");
            fNome.requestFocus();
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
            objeto = new Fornecedor();
            objeto.setNome(fNome.getText());
            objeto.setCidade(cidades.get(cCidade.getSelectedIndex()));
            objeto.setBairro(fbairro.getText());
            objeto.setFax(fFax.getText());
            objeto.setProprietario(fproprietario.getText());
            objeto.setTelefone1(ftelefone1.getText());
            objeto.setCelular(fcelular.getText());
            objeto.setStatus(cstatus.getSelectedItem().toString());
            objeto.setEmail(email.getText());
            objeto.setRazaoSocial(fRazao.getText());
            objeto.setCnpj(fCnpj.getText());
            objeto.setEndereco(fEndereco.getText());
            objeto.setNumero(Integer.parseInt(fNumero.getText()));
            objeto.setInscricao(fRg.getText());
            objeto.setTelefone(fTelefone.getText());
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
        fNome.setText(objeto.getNome());
        cCidade.setSelectedItem(objeto.getCidade().getNomeCidade());
        fproprietario.setText(objeto.getProprietario());
        ftelefone1.setText(objeto.getTelefone1());
        fcelular.setText(objeto.getCelular());
        cstatus.setSelectedItem(objeto.getStatus());
        email.setText(objeto.getEmail());
        fFax.setText(objeto.getFax());
        fRazao.setText(objeto.getRazaoSocial());
        fCnpj.setText(objeto.getCnpj());
        fEndereco.setText(objeto.getEndereco());
        fNumero.setText(String.valueOf(objeto.getNumero()));
        fRg.setText(objeto.getInscricao());
        fTelefone.setText(objeto.getTelefone());
        fbairro.setText(objeto.getBairro());
        botoes("selecionado");
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        montaTabela();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void fFaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFaxActionPerformed

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setToolTipText("Preenchimeto Obrigatório");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jLabel13.setToolTipText("Preenchimeto Obrigatório"); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jLabel14.setToolTipText("Preenchimeto Obrigatório");// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        jLabel15.setToolTipText("Preenchimeto Obrigatório");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FornecedorTela().setVisible(true);
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
    private javax.swing.JComboBox cCidade;
    private javax.swing.JComboBox cFiltro;
    private javax.swing.JComboBox cstatus;
    private javax.swing.JTextField email;
    private javax.swing.JFormattedTextField fCnpj;
    private javax.swing.JTextField fEndereco;
    private javax.swing.JFormattedTextField fFax;
    private javax.swing.JTextField fFiltro;
    private javax.swing.JTextField fId;
    private javax.swing.JTextField fNome;
    private javax.swing.JTextField fNumero;
    private javax.swing.JTextField fRazao;
    private javax.swing.JTextField fRg;
    private javax.swing.JFormattedTextField fTelefone;
    private javax.swing.JTextField fbairro;
    private javax.swing.JFormattedTextField fcelular;
    private javax.swing.JTextField fproprietario;
    private javax.swing.JFormattedTextField ftelefone1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
