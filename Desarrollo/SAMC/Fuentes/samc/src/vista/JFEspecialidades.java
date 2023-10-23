/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LoginController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import utilitarios.Item;
import vista.interfaces.IEspecialidades;

/**
 *
 * @author Usuario
 */
public class JFEspecialidades extends javax.swing.JFrame implements IEspecialidades {
    
//    private DefaultTableModel model = new DefaultTableModel();
//    private JTableUtil jtuEspecialidades = new JTableUtil();;
    private DefaultComboBoxModel<Item> modelCombo = null;
    /**
     * Creates new form JFPerfil
     */
    public JFEspecialidades() {
        initComponents();
//        jtbEspecialidades.setModel(model);
        jcbEspecialidades.setName(JCB_ESPECIALIDADES);
        jbtCerrar.setName(JBT_CERRAR);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbEspecialidades = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaHorario = new javax.swing.JTextArea();

        setTitle("Visualización de Horarios y Especialidades");

        jbtCerrar.setText("Cerrar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Especialidad:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Horario de Atención:");

        jtaHorario.setColumns(20);
        jtaHorario.setRows(5);
        jScrollPane2.setViewportView(jtaHorario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtCerrar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtCerrar;
    private javax.swing.JComboBox<Item> jcbEspecialidades;
    private javax.swing.JTextArea jtaHorario;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void setControlador(LoginController c, JTableController c2) {
//        jbtCerrar.addActionListener(c);
////        jtuEspecialidades.setController(c2);
//    }
    
    @Override
    public void setControlador(LoginController c) {
        jbtCerrar.addActionListener(c);
//        jtuEspecialidades.setController(c2);
        jcbEspecialidades.addItemListener(c);
    }

    @Override
    public void arranca() {
        this.setVisible(true);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiarTexto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enfocar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTitulo(String txt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObjeto(String id) {
        Object o = null;
        switch (id) {
            case JBT_CERRAR:
                o = jbtCerrar;
                break;
            case JCB_ESPECIALIDADES:
                o = jcbEspecialidades;
                break;
            default:
                throw new AssertionError();
        }
        return o;
    }

    @Override
    public void setTexto(String obj, String txt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void actualizarTabla(Object[][] data) {
//        model = new DefaultTableModel();
////        jtbEspecialidades.setModel(model);
////        model = (DefaultTableModel) jtbEspecialidades.getModel();
//        model.addColumn("Codigo");
//        model.addColumn("Especialidad");
////        model.addColumn("Cupos");
//        model.addColumn("Acción");
//        jtbEspecialidades.setModel(model);
//        jtuEspecialidades.getJButtonInJTable(jtbEspecialidades, 2);
//        for (Object[] rowData : data) {
////            model.addRow(rowData);
//            model.addRow(new Object[]{rowData[0], rowData[1], rowData[2]});
//        }
//        TableColumn column;
//        for (int i = 0; i < jtbEspecialidades.getColumnCount(); i++) {
//            column = jtbEspecialidades.getColumnModel().getColumn(i);
//            
//            // Establecer un ancho fijo para la columna (por ejemplo, 150 píxeles)
//            // column.setPreferredWidth(150);
//
//            // Ajustar automáticamente la longitud de la columna según el contenido
//            int max = 0;
//            for (int row = 0; row < jtbEspecialidades.getRowCount(); row++) {
//                TableCellRenderer renderer = jtbEspecialidades.getCellRenderer(row, i);
//                Component comp = jtbEspecialidades.prepareRenderer(renderer, row, i);
//                max = Math.max(comp.getPreferredSize().width, max);
//            }
//            column.setPreferredWidth(max);
//        }
//    }
    
    @Override
    public void limpiarTexto(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTexto(String obj) {
        String rpta = "";
        switch (obj) {
            case JCB_ESPECIALIDADES:
                rpta = (String) jcbEspecialidades.getSelectedItem();
                break;
            default:
                throw new AssertionError();
        }
        return rpta;
    }

//    @Override
//    public int getIdSeleccionada() {
//        int id = -1;
//        if (jtbEspecialidades.getColumnCount() > 0) {
//            id = (int) jtbEspecialidades.getValueAt(jtbEspecialidades.getSelectedRow(), 0);
//        }
//        return id;
//    }

    @Override
    public int getIdEspecialidad() {
        int id = 0;
//        id = jcbEspecialidades.getSelectedIndex();
        Item selectedItem = (Item) jcbEspecialidades.getSelectedItem();
        if (selectedItem != null) {
            id = selectedItem.getId();
        }
        return id;
    }

    @Override
    public void actualizarEspecialidad(ArrayList<Item> data) {
        modelCombo = new DefaultComboBoxModel<>();
        jcbEspecialidades.setModel(modelCombo);
        data.forEach((item) -> {
            modelCombo.addElement(item);
        });
    }

    @Override
    public void actualizarHorario(ArrayList<String> data) {
        jtaHorario.setText("");
        for (String string : data) {
            jtaHorario.append(string + "\n");
        }
    }
}
