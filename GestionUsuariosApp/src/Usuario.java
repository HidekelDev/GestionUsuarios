// Esta clase es para crear un usuario con varios datos
public class Usuario {

    // Aquí definimos los datos del usuario, como su nombre, apellido, teléfono, correo y contraseña
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correoElectronico;
    private String contrasena;

    // Este es el constructor, básicamente cuando creas un nuevo usuario le pasas estos datos
    // y los asigna a las variables que definimos arriba
    public Usuario(String nombreUsuario, String nombre, String apellido, String telefono, String correoElectronico, String contrasena) {
        this.nombreUsuario = nombreUsuario; // Le asignamos el nombre de usuario
        this.nombre = nombre; // Le asignamos el nombre
        this.apellido = apellido; // Le asignamos el apellido
        this.telefono = telefono; // Le asignamos el teléfono
        this.correoElectronico = correoElectronico; // Le asignamos el correo
        this.contrasena = contrasena; // Le asignamos la contraseña
    }

    // Estos son los métodos para obtener y cambiar los datos del usuario

    public String getNombreUsuario() {
        return nombreUsuario; // Devuelve el nombre de usuario
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario; // Cambia el nombre de usuario
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Cambia el nombre
    }

    public String getApellido() {
        return apellido; // Devuelve el apellido
    }

    public void setApellido(String apellido) {
        this.apellido = apellido; // Cambia el apellido
    }

    public String getTelefono() {
        return telefono; // Devuelve el teléfono
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono; // Cambia el teléfono
    }

    public String getCorreoElectronico() {
        return correoElectronico; // Devuelve el correo
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico; // Cambia el correo
    }

    public String getContrasena() {
        return contrasena; // Devuelve la contraseña
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena; // Cambia la contraseña
    }
}
