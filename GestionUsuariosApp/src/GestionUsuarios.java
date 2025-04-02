import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    // Esto es para tener una sola instancia de esta clase (patrón Singleton)
    private static GestionUsuarios instancia;
    // Aquí guardamos a todos los usuarios
    private List<Usuario> usuarios;

    // El constructor es privado, para que no puedan crear más instancias de esta clase
    private GestionUsuarios() {
        usuarios = new ArrayList<>(); // Inicializamos la lista de usuarios
    }

    // Este método nos da la única instancia de esta clase
    public static GestionUsuarios getInstancia() {
        if (instancia == null) { // Si aún no hemos creado la instancia
            instancia = new GestionUsuarios(); // Creamos la instancia
        }
        return instancia; // Devuelve la instancia
    }

    // Este método agrega un nuevo usuario a la lista
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario); // Añade el usuario a la lista
    }

    // Este método busca un usuario por su nombre de usuario y contraseña
    public Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
        // Recorre la lista de usuarios para encontrar el que coincida con el nombre y contraseña
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario; // Si lo encuentra, lo devuelve
            }
        }
        return null; // Si no lo encuentra, devuelve null
    }

    // Este método devuelve todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarios; // Devuelve la lista completa de usuarios
    }

    // Este método actualiza la información de un usuario en la lista
    public void actualizarUsuario(Usuario usuario) {
        // Busca al usuario en la lista y lo reemplaza con el nuevo
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(usuario.getNombreUsuario())) {
                usuarios.set(i, usuario); // Reemplaza el usuario antiguo por el nuevo
                return; // Ya lo actualizó, sale del método
            }
        }
    }

    // Este método elimina un usuario de la lista por su nombre de usuario
    public void eliminarUsuario(String nombreUsuario) {
        // Remueve al usuario que coincida con el nombre de usuario
        usuarios.removeIf(usuario -> usuario.getNombreUsuario().equals(nombreUsuario));
    }
}
