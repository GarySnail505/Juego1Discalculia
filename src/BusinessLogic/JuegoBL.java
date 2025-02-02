package BusinessLogic;

import DataAccess.DAO.PuntajeDAO;
import DataAccess.DAO.UsuarioDAO;
import DataAccess.DTO.PuntajeDTO;
import DataAccess.DTO.UsuarioDTO;
import DataAccess.Data_Helper_Sqlite;
import java.util.List;

public class JuegoBL {
    private final BLFactory<UsuarioDTO> usuarioBL;
    private final BLFactory<PuntajeDTO> puntajeBL;

    private UsuarioDTO usuarioActual;
    
    private PuntajeDTO puntajeActual;

    public JuegoBL() {
        this.usuarioBL = new BLFactory<>(UsuarioDAO::new);
        this.puntajeBL = new BLFactory<>(PuntajeDAO::new);
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        try {
            List<UsuarioDTO> usuarios = usuarioBL.getAll();
            for (UsuarioDTO u : usuarios) {
                if (u.getNombreUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
                    return true; // Credenciales válidas
                }
            }
            return false; // Usuario no encontrado
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error en la consulta
        }
    }

    private PuntajeDAO puntajeDAO = new PuntajeDAO();

    public boolean guardarPuntaje(PuntajeDTO puntaje) throws Exception {
        puntajeDAO.create(puntaje);
        return true;
    }

    public void actualizarPuntaje(boolean correcto) throws Exception {
        if (correcto) {
            puntajeActual.setAciertos(puntajeActual.getAciertos() + 1);
        } else {
            puntajeActual.setErrores(puntajeActual.getErrores() + 1);
        }
        puntajeBL.upd(puntajeActual);
    }

    public List<UsuarioDTO> getAllUsuarios() throws Exception {
        return usuarioBL.getAll();
    }

    public UsuarioDTO getUsuarioActual() {
         return usuarioActual;
    }
    
    public void setUsuarioActual(UsuarioDTO usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}