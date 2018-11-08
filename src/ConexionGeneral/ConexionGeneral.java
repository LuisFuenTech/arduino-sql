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
package ConexionGeneral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Fuentes
 */
public class ConexionGeneral {
    
    private static final String DRIVER = "java.sql.Driver";
    private static final String SSL = "?useTimezone=true&serverTimezone=UTC"
                                   + "&useSSL=false"
                                   + "&verifyServerCertificate=false"
                                   + "&autoReconnect=true";
    private static final  String HEAD = "jdbc:mysql://";
    private static Connection con;
    private static  String username;
    private static  String password;
    private static String host;
    private static String puerto;
    private static String bd;
    private static String url;
    
    
    //Constructor
    public ConexionGeneral(String host, String puerto, String bd, String username, String password){
        ConexionGeneral.username = username;
        ConexionGeneral.password = password;
        ConexionGeneral.host = host;
        ConexionGeneral.puerto = puerto;
        ConexionGeneral.bd = bd;
        con = null;        
        url = HEAD + ConexionGeneral.host + ":" + ConexionGeneral.puerto +"/"+ ConexionGeneral.bd + SSL;
        
        try{
            
            Class.forName(DRIVER);
            con = DriverManager.getConnection(url, ConexionGeneral.username, ConexionGeneral.password);
            
            
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
