package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.Data_Helper_Sqlite;
import DataAccess.IDAO;
import DataAccess.DTO.UsuarioDTO;

public class UsuarioDAO extends Data_Helper_Sqlite implements IDAO<UsuarioDTO>{
    @Override
    public UsuarioDTO readBy(Integer id) throws Exception {
        UsuarioDTO oS = new UsuarioDTO();
        String query =" SELECT IdUsuario  " 
                     +" ,NombreUsuario        " 
                     +" ,Contrasena        " 
                     
                     +" ,Estado        " 
                     +" ,Fecha_creacion     " 
                     +" ,Fecha_modificacion "
                     +" FROM  Usuario   "
                     +" WHERE   Estado ='A' AND IdUsuario =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new UsuarioDTO(rs.getInt(1)       // IdUsuario
                                ,rs.getString(2)        // NombreUsuario             
                                ,rs.getString(3)        // Contrasena             
                                ,rs.getString(4)        // Estado         
                                ,rs.getString(5)        // Fecha_creacion      
                                ,rs.getString(6));      // Fecha_modificacion
            }
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<UsuarioDTO> readAll() throws Exception {
        List <UsuarioDTO> lst = new ArrayList<>();
        String query =" SELECT IdUsuario  " 
                     +" ,NombreUsuario        " 
                     +" ,Contrasena        " 
                     +" ,Estado        " 
                     +" ,Fecha_creacion     " 
                     +" ,Fecha_modificacion "
                     +" FROM    Usuario   "
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                UsuarioDTO s = new UsuarioDTO( rs.getInt(1)     // IdUsuario
                                        ,rs.getString(2)  // NombreUsuario             
                                        ,rs.getString(3)  // Constrasena             
                                        ,rs.getString(4)  // Estado         
                                        ,rs.getString(5)  // Fecha_creacion      
                                        ,rs.getString(6));// Fecha_modificacion
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(UsuarioDTO entity) throws Exception {
        String query = " INSERT INTO Usuario (NombreUsuario, Contrasena) VALUES (?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreUsuario());
            pstmt.setString(2, entity.getContrasena());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(UsuarioDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Usuario SET NombreUsuario = ?, Contrasena = ?, Fecha_modificacion = ? WHERE IdUsuario = ? ";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreUsuario());
            pstmt.setString(1, entity.getContrasena());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdUsuario());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Usuario SET Estado = ? WHERE IdUsuario = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Usuario "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
    
}
