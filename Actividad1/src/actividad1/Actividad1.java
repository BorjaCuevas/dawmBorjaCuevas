
package actividad1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Borja
 */
public class Actividad1 {
    private String username, host, password;
    
    
    
    public Actividad1(){
        this.host="jdbc:mysql://www.db4free.net:3306/izv_dawm";
        this.username="izv_dawm";
        this.password="123456";
        
        Connection con= null;
        
        
    }
    public void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(host, username, password);
            String sql = "if object_id('FK_BCHorario_BCComercio') is not null"
                    + "drop rule FK_BCHorario_BCComercio;"
                    + "GO"
                    + "if object_id('BCComercio') is not null"
                    + "drop table BCComercio;"
                    + "GO";
            
            sql += "CREATE TABLE BCComercio("
                    + "id_nombre varchar(20) primary key,"
                    + "nombre varchar(50) not null,"
                    + "direccion varchar(100) not null,"
                    + "tipo varchar(50));"
                    + "GO"
                    + "if object_id('BCHorario') is not null"
                    + "drop table BCHorario;"
                    + "GO"
                    + "CREATE TABLE BCHorario("
                    + "id_horario varchar(20) primary key,"
                    + "dia integer not null,"
                    + "inicio integer,"
                    + "final time,"
                    + "id_comercio varchar(20) not null,"
                    + "CONSTRAINT FK_BCHorario_BCComercio (id_comercio)"
                    + "references (id_nombre) BCComercio;"
                    + "GO";
            
            sql += "INSERT INTO BCComercio"
                    + "VALUES ('Panaderia.Gr.1','Artesanos de Granada',"
                    + "'Avenida Cervantes, Nº20','Panaderia');"
                    + "GO"
                    + "INSERT INTO BCHorario"
                    + "VALUES ('Normal','1','07:00:00','21;00;00');"
                    + "GO";
            
            sql += "INSERT INTO ";
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Actividad1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        Actividad1 a=new Actividad1();
        a.conectar();
    }
    
}
