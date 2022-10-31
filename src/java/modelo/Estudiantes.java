
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

        

public class Estudiantes extends Persona {
    private String carne;
    private int id_id_tipo_sangre;
    Conexion cn;
    public Estudiantes() {}

    public Estudiantes(String carne, int id_tsangre, int id, String nombres, String apellidos, String direccion, String telefono, String correo, String fecha_nacimiento) {
        super(id, carne,nombres, apellidos, direccion, telefono, correo, fecha_nacimiento);
        this.carne = carne;
        this.id_id_tipo_sangre = id_id_tipo_sangre;
    }

    

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getId_id_tipo_sangre() {
        return id_id_tipo_sangre;
    }

    public void setId_id_tipo_sangre(int id_id_tipo_sangre) {
        this.id_id_tipo_sangre = id_id_tipo_sangre;
    }
 public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "SELECT e.id_estudiantes as id,e.carne,e.nombres,e.apellidos,e.direccion,e.telefono,e.correo,e.fecha_nacimiento,t.t_sangre,p.id_id_tipo_sangre FROM estudiantes as e inner join id_tipo_sangre as t on e.id_tipo_sangre = t.id_tipo_sangre;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","carne","nombres","apellidos","direccion","telefono","correo","nacimiento","id_tipo_sangre"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[9];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("carne");
          datos[2] = consulta.getString("nombres");
          datos[3] = consulta.getString("apellidos");
          datos[4] = consulta.getString("direccion");
          datos[5] = consulta.getString("telefono");
          datos[6] = consulta.getString("correo");
          datos[7] = consulta.getString("fecha_nacimiento");
          datos[8] = consulta.getString("id_tipo-sangre");
          tabla.addRow(datos);
      
      }
      
     cn.cerrar_conexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }
    @Override
    public int agregar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into estudiantes(carne,nombres,apellidos,direccion,telefono,correo,fecha_nacimiento,id_tipo_sangre) values(?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getCarne());
            parametro.setString(2,getNombres());
            parametro.setString(3,getApellidos());
            parametro.setString(4,getDireccion());
            parametro.setString(5,getTelefono());
            parametro.setString(6,getCorreo());
            parametro.setString(7,getFecha_nacimiento());
            parametro.setInt(8, getId_tipo_sangre());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    @Override
    public int modificar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update estudiantes set carne = ?,nombres= ?,apellidos= ?,direccion= ?,telefono= ?,correo= ?,fecha_nacimiento= ?,id_tipo_sangre= ? where id_estudiantes = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getCarne());
            parametro.setString(2,getNombres());
            parametro.setString(3,getApellidos());
            parametro.setString(4,getDireccion());
            parametro.setString(5,getTelefono());
            parametro.setString(6,getCorreo());
            parametro.setString(7,getFecha_nacimiento());
            parametro.setInt(8, getId_tipo_sangre());
            parametro.setInt(9, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    @Override
    public int eliminar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from estudiantes  where id_estudiantes = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }

    private int getId_tipo_sangre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
