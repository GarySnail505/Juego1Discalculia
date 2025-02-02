package DataAccess.DTO;

public class UsuarioDTO {
    private Integer IdUsuario;
    private String  NombreUsuario;
    private String  Contrasena;
    private String  Estado;
    private String  Fecha_creacion;
    private String  Fecha_modificacion;

    public UsuarioDTO(){

    }

    public UsuarioDTO(String nombreUsuario, String contrasena) {
        this.NombreUsuario = nombreUsuario;        
        this.Contrasena = contrasena;        
    }

    public UsuarioDTO(Integer idUsuario, String nombreUsuario, String contrasena, 
    String estado, String fechaCreacion, String fechaModificacion) {
        this.IdUsuario = idUsuario;        
        this.NombreUsuario = nombreUsuario;        
        this.Contrasena = contrasena;        
        this.Estado = estado;
        this.Fecha_creacion = fechaCreacion;
        this.Fecha_modificacion = fechaModificacion;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return NombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return Contrasena;
    }
    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFecha_creacion() {
        return Fecha_creacion;
    }
    public void setFecha_creacion(String fecha_creacion) {
        Fecha_creacion = fecha_creacion;
    }
    public String getFecha_modificacion() {
        return Fecha_modificacion;
    }
    public void setFecha_modificacion(String fecha_modificacion) {
        Fecha_modificacion = fecha_modificacion;
    }


    @Override
    public String toString(){
        return getClass().getName()

        +"\n IdUsuario: "                +getIdUsuario()
        +"\n NombreUsuario: "            +getNombreUsuario()
        +"\n Contrasena: "               +getContrasena()
        +"\n Estado: "                   +getEstado()
        +"\n Fecha_creacion: "           +getFecha_creacion()
        +"\n Fecha_modificacion: "       +getFecha_modificacion();
    }

}
