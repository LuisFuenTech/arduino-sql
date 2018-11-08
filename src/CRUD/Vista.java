/*
    Este código proporciona los métodos necesarios para poder realizar las
    siguentes acciones desde java: Insertar, Actualizar, Eliminar, Buscar en la
    base de datos.
 */
package CRUD;

import ConexionGeneral.ConexionGeneral;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Luis Fuentes
 */
public class Vista extends javax.swing.JFrame {

    public String clave="", arduinoString;
    public static ConexionGeneral conexion; //Objeto ConexionGeneral, abre la conexion ddbb
    public static Connection con;//Objeto Connection de connector/j    
    public static PreparedStatement ps;/*Realiza la consulta y envía datos
                                        a la BDD*/
    public static ResultSet rs; //Extrae los datos extraídos de la BDD

    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();

    SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {

            try {

                if (arduino.isMessageAvailable()) {
                    
                     arduinoString = arduino.printMessage();
                     
                     if(arduinoString.length()>= 1 && arduinoString.length()<=2)
                     {
                         if(arduinoString.equals("27")){
                             clave = "";
                         }else{
                            clave += arduinoString;
                         }                                                     
                     }
                     else{
                         codigo_tf.setText(arduinoString);                         
                        buscar();
                     }
                                           
                    System.out.println("Tamaño dato: "+arduinoString.length());
                    System.out.println("Clave:" + clave);
                    System.out.println("Dato:" + arduinoString);
                    //limpiarArduino();
                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        id_tf.setVisible(false);
        //codigo_tf.setVisible(false);
        this.setLocationRelativeTo(null);

        try {
            arduino.arduinoRXTX("COM10", 9600, listener);
        } catch (ArduinoException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre_lb = new javax.swing.JLabel();
        apellido_lb = new javax.swing.JLabel();
        telefono_lb = new javax.swing.JLabel();
        nombre_tf = new javax.swing.JTextField();
        apellido_tf = new javax.swing.JTextField();
        telefono_tf = new javax.swing.JTextField();
        genero_lb = new javax.swing.JLabel();
        genero_cb = new javax.swing.JComboBox<>();
        guarda_bt = new javax.swing.JButton();
        modifica_bt = new javax.swing.JButton();
        elimina_bt = new javax.swing.JButton();
        limpia_bt = new javax.swing.JButton();
        buscar_bt = new javax.swing.JButton();
        id_tf = new javax.swing.JTextField();
        passw_lb = new javax.swing.JLabel();
        codigo_tf = new javax.swing.JTextField();
        passw_tf = new javax.swing.JTextField();
        codigo_lb1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombre_lb.setFont(new java.awt.Font("ABeeZee", 0, 16)); // NOI18N
        nombre_lb.setText("Nombre:");

        apellido_lb.setFont(new java.awt.Font("ABeeZee", 0, 16)); // NOI18N
        apellido_lb.setText("Apellido:");

        telefono_lb.setFont(new java.awt.Font("ABeeZee", 0, 16)); // NOI18N
        telefono_lb.setText("Teléfono:");

        nombre_tf.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N

        apellido_tf.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N

        telefono_tf.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N

        genero_lb.setFont(new java.awt.Font("ABeeZee", 0, 16)); // NOI18N
        genero_lb.setText("Género:");

        genero_cb.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        genero_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Masculino", "Femenino" }));

        guarda_bt.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        guarda_bt.setText("Guarda");
        guarda_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guarda_btActionPerformed(evt);
            }
        });

        modifica_bt.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        modifica_bt.setText("Modifica");
        modifica_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifica_btActionPerformed(evt);
            }
        });

        elimina_bt.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        elimina_bt.setText("Elimina");
        elimina_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimina_btActionPerformed(evt);
            }
        });

        limpia_bt.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        limpia_bt.setText("Limpia");
        limpia_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpia_btActionPerformed(evt);
            }
        });

        buscar_bt.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        buscar_bt.setText("Buscar");
        buscar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_btActionPerformed(evt);
            }
        });

        id_tf.setEnabled(false);

        passw_lb.setFont(new java.awt.Font("ABeeZee", 0, 14)); // NOI18N
        passw_lb.setText("Contraseña:");

        codigo_tf.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N

        passw_tf.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N

        codigo_lb1.setFont(new java.awt.Font("ABeeZee", 0, 16)); // NOI18N
        codigo_lb1.setText("Código:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guarda_bt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifica_bt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elimina_bt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpia_bt))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefono_lb)
                            .addComponent(apellido_lb)
                            .addComponent(nombre_lb)
                            .addComponent(genero_lb)
                            .addComponent(codigo_lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passw_lb))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar_bt))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(codigo_tf)
                                    .addComponent(nombre_tf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(telefono_tf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(apellido_tf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(genero_cb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passw_tf))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar_bt)
                    .addComponent(id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_lb)
                    .addComponent(nombre_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido_lb)
                    .addComponent(apellido_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono_lb)
                    .addComponent(telefono_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genero_lb)
                    .addComponent(genero_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_lb1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passw_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passw_lb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guarda_bt)
                    .addComponent(modifica_bt)
                    .addComponent(elimina_bt)
                    .addComponent(limpia_bt))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guarda_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guarda_btActionPerformed
        guardar();
    }//GEN-LAST:event_guarda_btActionPerformed

    private void buscar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_btActionPerformed
        try {
            buscar();
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscar_btActionPerformed

    private void modifica_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifica_btActionPerformed
        modificar();
    }//GEN-LAST:event_modifica_btActionPerformed

    private void limpia_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpia_btActionPerformed
        limpiar();
    }//GEN-LAST:event_limpia_btActionPerformed

    private void elimina_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimina_btActionPerformed
        eliminar();
    }//GEN-LAST:event_elimina_btActionPerformed

    private void limpiar() {
        codigo_tf.setText(null);
        nombre_tf.setText(null);
        apellido_tf.setText(null);
        telefono_tf.setText(null);
        genero_cb.setSelectedIndex(0);
        passw_tf.setText(null);

        try {
            arduino.sendData("2");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limpiarArduino() {
        nombre_tf.setText(null);
        apellido_tf.setText(null);
        telefono_tf.setText(null);
        genero_cb.setSelectedIndex(0);
        passw_tf.setText(null);

        try {
            arduino.sendData("2");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardar() {
        con = null;

        try {

            conexion = new ConexionGeneral("localhost", "3306", "escuela", "root", "1234");//Inicializar objeto ConexionGeneral
            con = conexion.getConnection(); //Variable Connection es igualada a conexion.getConnection();

            /*Insertará en la tabla "persona" en las columnas. En VALUES, los 
              interrogantes significas que esos datos serán pasados después, es
              usado como medida de seguridad*/
            ps = con.prepareStatement("INSERT INTO persona (codigo, nombre, "
                    + "apellido, telefono, genero, password) VALUES(?,?,?,?,?,?)");

            /*Para insertar se usa setString(). El número indica el orden en que
              son insertados los valores desde prepareStatement. El otro parámetro
              es para extraer el texto desde el form java*/
            ps.setString(1, codigo_tf.getText());
            ps.setString(2, nombre_tf.getText());
            ps.setString(3, apellido_tf.getText());
            ps.setString(4, telefono_tf.getText());
            ps.setString(5, genero_cb.getSelectedItem().toString());
            ps.setString(6, passw_tf.getText());

            /*Luego de tener todos lo datoss, es necesario ejecutar "update".
              Si retorna un valor mayor que cero, indica que la actualización
                a la BDD fue exitosa*/
            int notifica = ps.executeUpdate();

            if (notifica > 0) {
                JOptionPane.showMessageDialog(null, "Persona guardada");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar persona");
                limpiar();
            }

            con.close();//Cerrar la conexión

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
            System.err.println("Error" + e);
        }
    }

     public void buscar() throws ArduinoException, SerialPortException {
        con = null;
        try {

            conexion = new ConexionGeneral("localhost", "3306", "escuela", "root", "1234");//Inicializar objeto ConexionGeneral
            con = conexion.getConnection(); //Variable Connection es igualada a conexion.getConnection();

            //Realiza la petición de consulta a la BDD
            ps = con.prepareStatement("SELECT * FROM persona WHERE codigo = ?");
            ps.setString(1, codigo_tf.getText());

            //Ejecuta la consulta
            rs = ps.executeQuery();

            if (rs.next()) {//Si hay datos, extrae los datos de la BDD
                if(rs.getString("password").equals(clave)){
                
                id_tf.setText(rs.getString("id"));//Importante extraer el id
                nombre_tf.setText(rs.getString("nombre"));
                apellido_tf.setText(rs.getString("apellido"));
                telefono_tf.setText(rs.getString("telefono"));
                genero_cb.setSelectedItem(rs.getString("genero"));

                //=============================================================
                try {
                    arduino.sendData("1");
                } catch (ArduinoException | SerialPortException ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "ACCEDO CONCEDIDO\n "
                        + "Bienvenido " + rs.getString("nombre"));
                clave="";
                limpiar();
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    clave="";
                    limpiar();
                }

            } else {

                try {
                    arduino.sendData("0");
                } catch (ArduinoException | SerialPortException ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "ACCEDO DENEGADO\n"
                        + "No existe una persona con la clave insertada");
                clave="";
                limpiarArduino();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
            System.err.println("Error " + e);
        }
    }

    public void modificar() {
        con = null;

        try {

            conexion = new ConexionGeneral("localhost", "3306", "escuela", "root", "1234");
            con = conexion.getConnection();

            ps = con.prepareStatement("UPDATE persona SET codigo=?, nombre=?,"
                    + " apellido=?, telefono=?, genero=?, password=? WHERE id=?");
            ps.setString(1, codigo_tf.getText());
            ps.setString(2, nombre_tf.getText());
            ps.setString(3, apellido_tf.getText());
            ps.setString(4, telefono_tf.getText());
            ps.setString(5, genero_cb.getSelectedItem().toString());
            ps.setString(6, id_tf.getText());
            ps.setString(7, passw_tf.getText());

            int notifica = ps.executeUpdate();

            if (notifica > 0) {
                JOptionPane.showMessageDialog(null, "Persona modificada");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar persona");
                limpiar();
            }

            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
            System.err.println("Error" + e);
        }
    }

    public void eliminar() {
        con = null;

        try {

            conexion = new ConexionGeneral("localhost", "3306", "escuela", "root", "1234");
            con = conexion.getConnection();
            ps = con.prepareStatement("DELETE FROM persona WHERE id=?");
            ps.setInt(1, Integer.parseInt(id_tf.getText()));

            int notifica = ps.executeUpdate();

            if (notifica > 0) {
                JOptionPane.showMessageDialog(null, "Persona eliminada");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar persona");
                limpiar();
            }

            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
            System.err.println("Error" + e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Vista().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido_lb;
    private javax.swing.JTextField apellido_tf;
    private javax.swing.JButton buscar_bt;
    private javax.swing.JLabel codigo_lb1;
    private javax.swing.JTextField codigo_tf;
    private javax.swing.JButton elimina_bt;
    private javax.swing.JComboBox<String> genero_cb;
    private javax.swing.JLabel genero_lb;
    private javax.swing.JButton guarda_bt;
    private javax.swing.JTextField id_tf;
    private javax.swing.JButton limpia_bt;
    private javax.swing.JButton modifica_bt;
    private javax.swing.JLabel nombre_lb;
    private javax.swing.JTextField nombre_tf;
    private javax.swing.JLabel passw_lb;
    private javax.swing.JTextField passw_tf;
    private javax.swing.JLabel telefono_lb;
    private javax.swing.JTextField telefono_tf;
    // End of variables declaration//GEN-END:variables
}
