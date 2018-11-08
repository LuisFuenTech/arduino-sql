/*
    Este código crea una clase Conexión, con el objeto de ser llamada desde
    cualquier proyecto para establecer conexión con la base de datos.
    
    Los datos que sería modificados en el futuro acorde a la necesidad serían:
    -localhost (localhost)
    -puerto (3306)
    -nombre de la base de datos (escuela)
    -usuario (root)
    -contraseña (4321)

    La estructura de la URL es la siguiente:
    jdbc:mysql://host:puerto/nombreBBDD
*/
package ConexionLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Fuentes
 */
public class ConexionLocal {
    
    private static Connection con;
    private static final String DRIVER = "java.sql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/escuela"
                                   + "?useTimezone=true&serverTimezone=UTC"
                                   + "&useSSL=false"
                                   + "&verifyServerCertificate=false"
                                   + "&autoReconnect=true";
    private static final String PASSWORD = "4321";
    private static final String USERNAME = "root";

    public ConexionLocal() {
        con = null;
        
        try{
            
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            if(con!=null){
                JOptionPane.showMessageDialog(null, "Conexión establecida");
            }
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar " + e);
        }
    }
    
    //Este método nos retorna la conexión a la base de datos
    public Connection getConnection(){
        return con;
    }
    
    //Este método desconecta la base de dato
    public void desconectar() throws SQLException{
        con=null;
        
        if(con==null){
            JOptionPane.showMessageDialog(null, "Conexión terminada");
        }
    }
    
}
