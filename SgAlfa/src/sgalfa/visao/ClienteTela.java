/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClienteTela.java
 *
 * Created on 26/01/2010, 20:43:23
 */
package sgalfa.visao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sgalfa.controle.CidadeControle;
import sgalfa.controle.ClienteControle;
import sgalfa.entidades.Cidade;
import sgalfa.entidades.Cliente;

/**
 *
 * @author Administrador
 */
public class ClienteTela extends javax.swing.JFrame {

    private Cliente objeto;
    private ClienteControle controle;
    private List<Cliente> lista;
    private List<Cidade> cidades;
    private CidadeControle conCid;

    /** Creates new form ClienteTela */
    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            fNome.setEditable(false);
            csexo.setEnabled(false);
            ftelefone1.setEditable(false);
            email.setEditable(false);
            cstatus.setEnabled(false);
            conjugue.setEditable(false);
            fApelido.setEditable(false);
            fDataCadastro.setEnabled(false);
            fDataNas.setEnabled(false);
            fComplemento.setEditable(false);
            fLocalTrab.setEditable(false);
            fReferencia.setEditable(false);
            fCep.setEditable(false);
            cCidade.setEnabled(false);
            fCelular.setEditable(false);
            fCpf.setEditable(false);
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
            jLabel27.setEnabled(false);
            jLabel26.setEnabled(false);
            jLabel25.setEnabled(false);
            jLabel24.setEnabled(false);
            jLabel28.setEnabled(false);
            jLabel23.setEnabled(false);
            jLabel22.setEnabled(false);
            jLabel19.setEnabled(false);
            Asterisco1.setEnabled(false);
            jLabel29.setEnabled(false);
        } else if (acao.equals("novo") || acao.equals("alterar")) {
            fNome.setEditable(true);
            csexo.setEnabled(true);
            ftelefone1.setEditable(true);
            email.setEditable(true);
            cstatus.setEnabled(true);
            conjugue.setEditable(true);
            fApelido.setEditable(true);
            fDataCadastro.setEnabled(true);
            fDataNas.setEnabled(true);
            fCep.setEditable(true);
            fComplemento.setEditable(true);
            fLocalTrab.setEditable(true);
            fReferencia.setEditable(true);
            cCidade.setEnabled(true);
            fCelular.setEditable(true);
            fCpf.setEditable(true);
            fEndereco.setEditable(true);
            fNumero.setEditable(true);
            fRg.setEditable(true);
            fTelefone.setEditable(true);
            fbairro.setEditable(true);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);
            tabela.setEnabled(false);
            jLabel27.setEnabled(true);
            jLabel26.setEnabled(true);
            jLabel28.setEnabled(true);
            jLabel23.setEnabled(true);
            jLabel22.setEnabled(true);
            jLabel24.setEnabled(true);
            jLabel25.setEnabled(true);
            jLabel19.setEnabled(true);
            Asterisco1.setEnabled(true);
            jLabel29.setEnabled(true);
        } else if (acao.equals("inicio") || acao.equals("cancelar")
                || acao.equals("salvar")) {
            fNome.setEditable(false);
            csexo.setEnabled(false);
            ftelefone1.setEditable(false);
            email.setEditable(false);
            cstatus.setEnabled(false);
            conjugue.setEditable(false);
            fApelido.setEditable(false);
            fDataCadastro.setEnabled(false);
            fDataNas.setEnabled(false);
            fComplemento.setEditable(false);
            fLocalTrab.setEditable(false);
            fReferencia.setEditable(false);
            cCidade.setEnabled(false);
            fCelular.setEditable(false);
            fCep.setEditable(false);
            fCpf.setEditable(false);
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
            jLabel27.setEnabled(false);
            jLabel26.setEnabled(false);
            jLabel25.setEnabled(false);
            jLabel24.setEnabled(false);
            jLabel28.setEnabled(false);
            jLabel23.setEnabled(false);
            jLabel22.setEnabled(false);
            jLabel19.setEnabled(false);
            Asterisco1.setEnabled(false);
            jLabel29.setEnabled(false);
        }
    }

    public boolean valida_CpfCnpj(String s_aux) {
        s_aux = s_aux.replace(".", "");
        s_aux = s_aux.replace("-", "");
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

    public static boolean ValidateEmail(String email) {
        Pattern pattern = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    
      public static boolean ValidateCep(String cep) {
        Pattern pattern = Pattern.compile("[0-9]{5}-[0-9]{3}");
        Matcher matcher = pattern.matcher(cep);
        return matcher.find();
    }

    public boolean verificaCampos() {
        if (fNome.getText().equals("") || fNome.getText() == null) {
            JOptionPane.showMessageDialog(null, "O campo Nome deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fNome.requestFocus();
            return false;

        } else if (csexo.getSelectedItem()
                == null) {
            JOptionPane.showMessageDialog(null, "O sexo deve ser selecionado",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            csexo.requestFocus();
            return false;
        } else if (cstatus.getSelectedItem()
                == null) {
            JOptionPane.showMessageDialog(null, "O Status deve ser selecionado",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cstatus.requestFocus();
            return false;

        } else if (fCpf.getText().equals("") || fCpf.getText() == null) {
            JOptionPane.showMessageDialog(null, "O campo CPF deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fNome.requestFocus();
            return false;
        } else if (fRg.getText().equals("") || fRg.getText() == null) {
            JOptionPane.showMessageDialog(null, "O campo RG deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fNome.requestFocus();
            return false;
        } else if (valida_CpfCnpj(fCpf.getText()) == false) {
            JOptionPane.showMessageDialog(null, "CPF inválido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fCpf.requestFocus();
            return false;
        } else if (ValidateEmail(email.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Email Invalido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            email.requestFocus();
            return false;
        }else if (ValidateCep(fCep.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Cep Invalido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fCep.requestFocus();
            return false;
        } else if (cCidade.getSelectedItem()
                == null) {
            JOptionPane.showMessageDialog(null, "O campo Cidade deve ser preenchido!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cCidade.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void montaTabela() {
        lista = controle.montaLista(cFiltro.getSelectedIndex(), fFiltro.getText());
        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("RG");
        for (Iterator<Cliente> it = lista.iterator(); it.hasNext();) {
            Cliente cid = it.next();
            modelo.addRow(new Object[]{cid.getNome(), cid.getCpf(), cid.getRg()});
        }
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tabela.setModel(modelo);
        tabela.setRowSorter(sorter);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

    public Cliente getObjeto() {
        return objeto;
    }

    public void setObjeto(Cliente objeto) {
        this.objeto = objeto;
    }

    public ClienteTela() {
        initComponents();
        controle = ClienteControle.getInstance();
        conCid = CidadeControle.getInstance();
        montaCombo();
        montaTabela();
        limpaCombos();
        botoes("inicio");
        // objeto.setStatus("ATIVO");
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

        jLabel20 = new javax.swing.JLabel();
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
        fCelular = new javax.swing.JFormattedTextField();
        fCpf = new javax.swing.JFormattedTextField();
        fRg = new javax.swing.JFormattedTextField();
        fApelido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fComplemento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fCep = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        fReferencia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        fLocalTrab = new javax.swing.JTextField();
        fDataNas = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fDataCadastro = new com.toedter.calendar.JDateChooser();
        Asterisco1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        csexo = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        ftelefone1 = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        conjugue = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        cstatus = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fFiltro = new javax.swing.JTextField();
        cFiltro = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadasto de Clientes");
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

        jLabel5.setText("Telefone 1");

        jLabel8.setText("Celular");

        jLabel9.setText("CPF");

        jLabel10.setText("RG");

        try {
            fTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            fCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            fCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Apelido");

        jLabel12.setText("Complemento");

        jLabel13.setText("CEP");

        try {
            fCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCepActionPerformed(evt);
            }
        });

        jLabel14.setText("Referencia");

        fReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fReferenciaActionPerformed(evt);
            }
        });

        jLabel15.setText("Local Trab.");

        jLabel16.setText("Data de Nascimento");

        jLabel17.setText("Data do Cadastro");

        Asterisco1.setForeground(new java.awt.Color(255, 51, 51));
        Asterisco1.setText("*");
        Asterisco1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Asterisco1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Asterisco1MousePressed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("*");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("*");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("*");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setText("*");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(255, 51, 51));
        jLabel25.setText("*");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(255, 51, 51));
        jLabel26.setText("*");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(255, 51, 51));
        jLabel27.setText("*");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(255, 51, 51));
        jLabel28.setText("*");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel29.setForeground(new java.awt.Color(255, 0, 51));
        jLabel29.setText("(*) Campo de preenchimento obrigatório");

        jLabel18.setText("Sexo:");

        csexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        jLabel21.setText("Telefone 2");

        try {
            ftelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel30.setText("E-mail:");

        jLabel31.setText("Conjûgue");

        jLabel32.setText("Status:");

        cstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "DESATIVADO", "RE-ATIVADO" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(512, Short.MAX_VALUE)
                        .addComponent(jLabel29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fLocalTrab, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel6)))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                                        .addComponent(jLabel13)
                                        .addGap(2, 2, 2)
                                        .addComponent(fCep, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fDataNas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                                    .addComponent(fEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(rotuloId)
                                            .addComponent(jLabel11)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fNome, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(csexo, 0, 107, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fRg, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ftelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(fApelido, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22)
                                        .addGap(4, 4, 4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Asterisco1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(conjugue, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel27))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rotuloId)
                        .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addComponent(fDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Asterisco1)
                        .addComponent(jLabel32)
                        .addComponent(cstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(csexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(fCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(fRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel5)
                    .addComponent(fTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(ftelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(fbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)
                        .addComponent(jLabel13)
                        .addComponent(fCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addComponent(fDataNas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel14)
                    .addComponent(fReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fLocalTrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(conjugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSair)
                        .addComponent(btCancelar)
                        .addComponent(btSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btNovo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE))
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
        fId.setText("");
        cCidade.setSelectedItem(null);
        fCelular.setText("");
        fCpf.setText("");
        csexo.setSelectedItem(null);
        ftelefone1.setText("");
        email.setText("");
        cstatus.setSelectedItem("ATIVO");
        conjugue.setText("");
        fEndereco.setText("");
        fNumero.setText("");
        fRg.setText("");
        fTelefone.setText("");
        fbairro.setText("");
        fDataCadastro.setDate(new Date());
        fDataNas.setDate(null);
        fComplemento.setText("");
        fLocalTrab.setText("");
        fReferencia.setText("");
        fCep.setText("");
        fApelido.setText("");
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
        try {
            if (verificaCampos() == true) {
                objeto = new Cliente();
                objeto.setNome(fNome.getText());
                objeto.setCidade(cidades.get(cCidade.getSelectedIndex()));
                objeto.setBairro(fbairro.getText());
                objeto.setCelular(fCelular.getText());
                objeto.setCpf(fCpf.getText());
                objeto.setSexo(csexo.getSelectedItem().toString());
                objeto.setTelefone1(ftelefone1.getText());
                objeto.setEmail(email.getText());
                objeto.setConjugue(conjugue.getText());
                objeto.setStatus(cstatus.getSelectedItem().toString());
                objeto.setEndereco(fEndereco.getText());
                objeto.setNumero(Integer.parseInt(fNumero.getText()));
                objeto.setRg(fRg.getText());
                objeto.setTelefone(fTelefone.getText());
                objeto.setDataCadastro(fDataCadastro.getDate());
                objeto.setDatanascimento(fDataNas.getDate());
                objeto.setComplemento(fComplemento.getText());
                objeto.setLocaltrabalho(fLocalTrab.getText());
                objeto.setReferencia(fReferencia.getText());
                objeto.setCep(fCep.getText());
                objeto.setApelido(fApelido.getText());

                if (fId.getText().equals("")) {
                    objeto.setId(null);
                } else {
                    objeto.setId(Long.parseLong(fId.getText()));
                }
                controle.salvar(objeto);
                botoes("salvar");
                montaTabela();
            }
        } catch (Exception e) {
            //  if (e.getCause().getMessage().contains("cpf")) {
            JOptionPane.showMessageDialog(null, "CPF ja cadastrado! Tente Novamente",
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            //  }
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
        fCelular.setText(objeto.getCelular());
        fCpf.setText(objeto.getCpf());
        fEndereco.setText(objeto.getEndereco());
        fNumero.setText(String.valueOf(objeto.getNumero()));
        fRg.setText(objeto.getRg());
        csexo.setSelectedItem(objeto.getSexo());
        ftelefone1.setText(objeto.getTelefone1());
        email.setText(objeto.getEmail());
        conjugue.setText(objeto.getConjugue());
        cstatus.setSelectedItem(objeto.getStatus());
        fTelefone.setText(objeto.getTelefone());
        fbairro.setText(objeto.getBairro());
        fDataCadastro.setDate(objeto.getDataCadastro());
        fDataNas.setDate(objeto.getDatanascimento());
        fComplemento.setText(objeto.getComplemento());
        fLocalTrab.setText(objeto.getLocaltrabalho());
        fReferencia.setText(objeto.getReferencia());
        fCep.setText(objeto.getCep());
        fApelido.setText(objeto.getApelido());
        botoes("selecionado");
        if (evt.getClickCount() == 2) {
            if (objeto.getId() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um registro para alterar!");
            } else {
                botoes("alterar");
                fNome.requestFocus();
            }

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        montaTabela();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void fCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fCepActionPerformed

    private void fReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fReferenciaActionPerformed

    private void Asterisco1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asterisco1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Asterisco1MousePressed

    private void Asterisco1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Asterisco1MouseEntered
        Asterisco1.setToolTipText("Preenchimeto Obrigatório");  // TODO add your handling code here:
    }//GEN-LAST:event_Asterisco1MouseEntered

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jLabel19.setToolTipText("Preenchimeto Obrigatório");         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        jLabel22.setToolTipText("Preenchimeto Obrigatório");// TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jLabel23.setToolTipText("Preenchimeto Obrigatório");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        jLabel28.setToolTipText("Preenchimeto Obrigatório");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        jLabel26.setToolTipText("Preenchimeto Obrigatório");// TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        jLabel27.setToolTipText("Preenchimeto Obrigatório");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        jLabel25.setToolTipText("Preenchimeto Obrigatório");// TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        jLabel24.setToolTipText("Preenchimeto Obrigatório");   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClienteTela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Asterisco1;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cCidade;
    private javax.swing.JComboBox cFiltro;
    private javax.swing.JTextField conjugue;
    private javax.swing.JComboBox csexo;
    private javax.swing.JComboBox cstatus;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fApelido;
    private javax.swing.JFormattedTextField fCelular;
    private javax.swing.JFormattedTextField fCep;
    private javax.swing.JTextField fComplemento;
    private javax.swing.JFormattedTextField fCpf;
    private com.toedter.calendar.JDateChooser fDataCadastro;
    private com.toedter.calendar.JDateChooser fDataNas;
    private javax.swing.JTextField fEndereco;
    private javax.swing.JTextField fFiltro;
    private javax.swing.JTextField fId;
    private javax.swing.JTextField fLocalTrab;
    private javax.swing.JTextField fNome;
    private javax.swing.JTextField fNumero;
    private javax.swing.JTextField fReferencia;
    private javax.swing.JFormattedTextField fRg;
    private javax.swing.JFormattedTextField fTelefone;
    private javax.swing.JTextField fbairro;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
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
