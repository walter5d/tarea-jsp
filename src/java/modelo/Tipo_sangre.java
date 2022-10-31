
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Tipo_sangre {
    private int Tipo_sangre;
    private String Tipo_sangre;
    Conexion cn;
    private String tipo_sangre;
    private int id_tipo_sangre;
    public Tipo_sangre(){}
    public Tipo_sangre(int id_, String puesto) {
        this.id_tipo_sangre = id_tipo_sangre;
        this.tipo_sangre = tipo_sangre;
    }

    public int getId_tipo_sangre() {
        return id_tipo_sangre;
    }

    public void setId_tipo_sangre(int id_tipo_sangre) {
        this.id_tipo_sangre = id_tipo_sangre;
    }

    public String gettipo_sangre() {
        return tipo_sangre;
    }

    public void settipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }
    public HashMap drop_tipo_sangre(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="Select id_tipo_sangre as id,tipo_sangre from tipos_sangre";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("tipo_sangre") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
    
}
