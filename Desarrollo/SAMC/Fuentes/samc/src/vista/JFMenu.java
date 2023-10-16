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
        jmiEspecialidades.setName(JMI_ESPECIALIDADES);
        jmiCerrarSesion.setName(JMI_CERRARSESION);
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
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmiEspecialidades = new javax.swing.JMenuItem();
        jmiCerrarSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiPerfil = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rm218batch4-ning-24.jpg"))); // NOI18N

        jMenu1.setText("File");

        jMenuItem2.setText("Registrar Paciente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Horario");
        jMenu1.add(jMenuItem3);

        jmiEspecialidades.setText("Especialidades");
        jMenu1.add(jmiEspecialidades);

        jmiCerrarSesion.setText("Cerrar Sesion");
        jMenu1.add(jmiCerrarSesion);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jmiPerfil.setText("Perfil");
        jMenu2.add(jmiPerfil);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jmiCerrarSesion;
    private javax.swing.JMenuItem jmiEspecialidades;
    private javax.swing.JMenuItem jmiPerfil;
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
        jmiEspecialidades.addActionListener(c);
        jmiCerrarSesion.addActionListener(c);
    }
    
    @Override
    public Object getObjeto(String id) {
        Object o = null;
        switch (id) {
            case JMI_PERFIL:
                o = jmiPerfil;
                break;
            case JMI_ESPECIALIDADES:
                o = jmiEspecialidades;
                break;
            case JMI_CERRARSESION:
                o = jmiCerrarSesion;
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
