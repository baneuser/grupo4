/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LoginController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import utilitarios.Item;
import vista.interfaces.IReservarCita;

/**
 *
 * @author Usuario
 */
public class JFReservarCita extends javax.swing.JFrame implements IReservarCita {

    /**
     * Creates new form JFReservarCita
     */
    private DefaultComboBoxModel<Item> modelComboEspecialidad = null;
    private DefaultComboBoxModel<Item> modelComboHorario = null;
    private DefaultComboBoxModel<Item> modelComboMedico = null;
    
    public JFReservarCita() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtReservar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbxEspecialidad = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcbxHorario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtfNota = new javax.swing.JTextField();
        jbtCerrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfSintomas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfDniPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbxMedico = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        jbtReservar.setText("Reservar");

        jLabel1.setText("Especialidad (*):");

        jLabel2.setText("Horario (*):");

        jLabel4.setText("Nota:");

        jbtCerrar.setText("Cerrar");

        jLabel6.setText("Sintomas (*):");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("(*) Campos obligatorios");

        jtfDniPaciente.setFocusable(false);
        jtfDniPaciente.setOpaque(false);

        jLabel3.setText("DATOS DEL PACIENTE:");

        jLabel8.setText("Médico:");

        jcbxMedico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbxMedico.setEnabled(false);
        jcbxMedico.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbxHorario, 0, 204, Short.MAX_VALUE)
                                    .addComponent(jtfNota)
                                    .addComponent(jtfSintomas)
                                    .addComponent(jcbxMedico, 0, 204, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 199, Short.MAX_VALUE)
                                .addComponent(jbtReservar)
                                .addGap(18, 18, 18)
                                .addComponent(jbtCerrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbxEspecialidad, 0, 204, Short.MAX_VALUE)
                                    .addComponent(jtfDniPaciente))))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtfDniPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtfNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jtfSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCerrar)
                    .addComponent(jbtReservar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setText("RESERVAR CITA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtCerrar;
    private javax.swing.JButton jbtReservar;
    private javax.swing.JComboBox<Item> jcbxEspecialidad;
    private javax.swing.JComboBox<Item> jcbxHorario;
    private javax.swing.JComboBox<Item> jcbxMedico;
    private javax.swing.JTextField jtfDniPaciente;
    private javax.swing.JTextField jtfNota;
    private javax.swing.JTextField jtfSintomas;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="IPadre">
    @Override
    public void arranca() {
        this.setVisible(true);
        getRootPane().setDefaultButton(jbtReservar);
        centrarVentana();
    }
    
    @Override
    public void ocultar() {
        this.setVisible(false);
    }
    
    public void centrarVentana() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int anchoVentana = getWidth();
        int altoVentana = getHeight();
    
        int x = (dim.width - anchoVentana) / 2;
        int y = (dim.height - altoVentana) / 2;
    
        setLocation(x, y);
    }

    @Override
    public void mostrarPanel(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    @Override
    public void limpiarTexto() {
//        jtfUsuario.setText("");
//        jpfPassword.setText("");
    }

    @Override
    public void enfocar() {
//        jtfUsuario.requestFocus();
    }

    @Override
    public void seleccionarText() {
//        jtfUsuario.selectAll();
    }

    @Override
    public void setTitulo(String txt) {
        this.setTitle(txt);
    }
    
    @Override
    public Object getObjeto(String id) {
        Object o = null;
        switch (id) {
            case JCB_ESPECIALIDADES:
                o = jcbxEspecialidad;
                break;
            case JBT_CERRAR:
                o = jbtCerrar;
                break;
            case JBT_RESERVAR:
                o = jbtReservar;
                break;
            default:
                throw new AssertionError();
        }
        return o;
    }
    // </editor-fold>
    
    @Override
    public void setTexto(String obj, String txt) {
        switch (obj) {
            case JTF_PACIENTE:
                jtfDniPaciente.setText(txt);
                break;
            case JTF_NOTA:
                jtfNota.setText(txt);
                break;
            case JTF_SINTOMAS:
                jtfSintomas.setText(txt);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getTexto(String obj) {
        String txt = "";
        switch (obj) {
            case JTF_PACIENTE:
                txt = jtfDniPaciente.getText();
                break;
            case JTF_NOTA:
                txt = jtfNota.getText();
                break;
            case JTF_SINTOMAS:
                txt = jtfSintomas.getText();
                break;
            default:
                throw new AssertionError();
        }
        return txt;
    }

    @Override
    public void limpiarTexto(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setController(LoginController c) {
        jbtReservar.addActionListener(c);
        jbtCerrar.addActionListener(c);
        jcbxEspecialidad.addItemListener(c);
    }
    
    @Override
    public int getIdEspecialidadSeleccionada() {
        int id = 0;
//        id = jcbEspecialidades.getSelectedIndex();
        Item selectedItem = (Item) jcbxEspecialidad.getSelectedItem();
        if (selectedItem != null) {
            id = selectedItem.getId();
        }
        return id;
    }
    
    @Override
    public int getIdMedicoSeleccionada() {
        int medico = 0;
//        id = jcbEspecialidades.getSelectedIndex();
        Item selectedItem = (Item) jcbxMedico.getSelectedItem();
        if (selectedItem != null) {
            medico = selectedItem.getId();
        }
        return medico;
    }
    
    @Override
    public void actualizarEspecialidad(ArrayList<Item> data) {
        modelComboEspecialidad = new DefaultComboBoxModel<>();
        jcbxEspecialidad.setModel(modelComboEspecialidad);
        data.forEach((item) -> {
            modelComboEspecialidad.addElement(item);
        });
    }
    
    @Override
    public void actualizarHorario(ArrayList<Item> data) {
        modelComboHorario = new DefaultComboBoxModel<>();
        jcbxHorario.setModel(modelComboHorario);
        data.forEach((item) -> {
            modelComboHorario.addElement(item);
        });
    }
    
    @Override
    public void actualizarMedico(ArrayList<Item> data) {
        modelComboMedico = new DefaultComboBoxModel<>();
        jcbxMedico.setModel(modelComboMedico);
        data.forEach((item) -> {
            modelComboMedico.addElement(item);
        });
    }
    
    @Override
    public int getHorario() {
        int id = 0;
//        id = jcbEspecialidades.getSelectedIndex();
        Item selectedItem = (Item) jcbxHorario.getSelectedItem();
        if (selectedItem != null) {
            id = selectedItem.getId();
        }
        return id;
    }

    @Override
    public String getEspecialidadSeleccionada() {
        String especialidad = "";
//        id = jcbEspecialidades.getSelectedIndex();
        Item selectedItem = (Item) jcbxEspecialidad.getSelectedItem();
        if (selectedItem != null) {
            especialidad = selectedItem.toString();
        }
        return especialidad;
    }

    @Override
    public void seleccionarxDefectoOpcionEspecialidad() {
        jcbxEspecialidad.setSelectedIndex(0);
    }
}
