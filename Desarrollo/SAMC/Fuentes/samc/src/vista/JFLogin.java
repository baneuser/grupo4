/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.interfaces.ILogin;
import controlador.LoginController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class JFLogin extends javax.swing.JFrame implements ILogin {

    /**
     * Creates new form JFLogin
     */
    public JFLogin() {
        initComponents();
        jbtAceptar.setName(JBT_ACEPTAR);
        jtfUsuario.setName(JTF_USUARIO);
        jpfPassword.setName(JPF_PASSWORD);
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
        jtfUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbtAceptar = new javax.swing.JButton();
        jbtLimpiar = new javax.swing.JButton();
        jpfPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - SAMC");

        jLabel1.setText("Usuario");

        jtfUsuario.setText("admin");

        jLabel2.setText("Contraseña");

        jbtAceptar.setText("Login");

        jbtLimpiar.setText("Limpiar");

        jpfPassword.setText("1234");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jpfPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtAceptar)
                .addGap(27, 27, 27)
                .addComponent(jbtLimpiar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtAceptar;
    private javax.swing.JButton jbtLimpiar;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void setControlador(LoginController c) {
        jbtAceptar.addActionListener(c);
        jbtLimpiar.addActionListener(c);
    }

    @Override
    public ArrayList<String> getCredenciales() {
        ArrayList<String> lista = null;
        if (!jtfUsuario.getText().isEmpty() && !new String(jpfPassword.getPassword()).isEmpty()) {
            lista = new ArrayList<>();
            lista.add(jtfUsuario.getText());
            lista.add(new String(jpfPassword.getPassword()));
        }
        return lista;
    }
    
    // <editor-fold defaultstate="collapsed" desc="IPadre">
    @Override
    public void arranca() {
        this.setVisible(true);
        getRootPane().setDefaultButton(jbtAceptar);
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
        jtfUsuario.setText("");
        jpfPassword.setText("");
    }

    @Override
    public void enfocar() {
        jtfUsuario.requestFocus();
    }

    @Override
    public void seleccionarText() {
        jtfUsuario.selectAll();
    }

    @Override
    public void setTitulo(String txt) {
        this.setTitle(txt);
    }
    
    @Override
    public Object getObjeto(String id) {
        Object o = null;
        switch (id) {
            case JBT_ACEPTAR:
                o = jbtAceptar;
                break;
            case JBT_LIMPIAR:
                o = jbtLimpiar;
                break;
            default:
                throw new AssertionError();
        }
        return o;
    }
    // </editor-fold>

    @Override
    public void setTexto(String obj, String txt) {
    }

    @Override
    public void limpiarTexto(String obj) {
        switch (obj) {
            case JTF_USUARIO:
                jtfUsuario.setText("");
                break;
            case JPF_PASSWORD:
                jpfPassword.setText("");
                break;
            default:
                throw new AssertionError();
        }
    }

}
