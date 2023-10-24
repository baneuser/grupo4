/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LoginController;
import vista.interfaces.IMenu;
//import controlador.MenuController;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class JFMenu extends javax.swing.JFrame implements IMenu {

    /**
     * Creates new form NewJFrame
     */
    public JFMenu() {
        initComponents();
        jmiPerfil.setName(JMI_PERFIL);
        jmiHorEsp.setName(JMI_HORESP);
        jmiCerrarSesion.setName(JMI_CERRARSESION);
        jmiRegistrarPaciente.setName(JMI_REGISTRAR);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiRegistrarPaciente = new javax.swing.JMenuItem();
        jmiHorEsp = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiCerrarSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiPerfil = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/image (1).png"))); // NOI18N

        jmFile.setText("File");

        jmiRegistrarPaciente.setText("Registrar Paciente");
        jmiRegistrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarPacienteActionPerformed(evt);
            }
        });
        jmFile.add(jmiRegistrarPaciente);

        jmiHorEsp.setText("Horario y Especialidades");
        jmFile.add(jmiHorEsp);
        jmFile.add(jSeparator1);

        jmiCerrarSesion.setText("Cerrar Sesion");
        jmFile.add(jmiCerrarSesion);

        jMenuBar1.add(jmFile);

        jMenu2.setText("Edit");

        jmiPerfil.setText("Perfil");
        jMenu2.add(jmiPerfil);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiRegistrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiRegistrarPacienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuItem jmiCerrarSesion;
    private javax.swing.JMenuItem jmiHorEsp;
    private javax.swing.JMenuItem jmiPerfil;
    private javax.swing.JMenuItem jmiRegistrarPaciente;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="IPadre">
    @Override
    public void arranca() {
        this.setVisible(true);
//        getRootPane().setDefaultButton(jbtAceptar);
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
//        jtfUsuario.requestFocus();
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
    // </editor-fold>

    @Override
    public void setControlador(LoginController c) {
        jmiPerfil.addActionListener(c);
        jmiHorEsp.addActionListener(c);
        jmiCerrarSesion.addActionListener(c);
        jmiRegistrarPaciente.addActionListener(c);
    }
    
    @Override
    public Object getObjeto(String id) {
        Object o = null;
        switch (id) {
            case JMI_PERFIL:
                o = jmiPerfil;
                break;
            case JMI_HORESP:
                o = jmiHorEsp;
                break;
            case JMI_CERRARSESION:
                o = jmiCerrarSesion;
                break;
             case JMI_REGISTRAR:
                o = jmiRegistrarPaciente;
                break;
            default:
                throw new AssertionError();
        }
        return o;
    }

    @Override
    public void setTexto(String obj, String txt) {
    }

    @Override
    public void limpiarTexto(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTexto(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
