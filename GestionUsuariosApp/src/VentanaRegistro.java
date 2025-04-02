import javax.swing.*;
import java.awt.*;

public class VentanaRegistro extends JFrame {
    // Campos para ingresar los datos del usuario
    private JTextField txtNombre, txtApellido, txtNombreUsuario, txtTelefono, txtCorreoElectronico;
    private JPasswordField txtContrasena, txtConfirmarContrasena;
    private JButton btnRegistrar;
    private GestionUsuarios gestionUsuarios;

    public VentanaRegistro() {
        // Obtenemos la instancia única de GestionUsuarios para manejar los usuarios
        gestionUsuarios = GestionUsuarios.getInstancia();
        setTitle("Registro");  // Título de la ventana
        setSize(450, 350);  // Tamaño de la ventana
        setLayout(new GridBagLayout());  // Usamos GridBagLayout para organizar los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Los componentes se expanden horizontalmente

        // Fuente que se usará para los textos
        Font fuente = new Font("Arial", Font.PLAIN, 14);

        // Etiqueta y campo para el nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblNombre, gbc);

        txtNombre = new JTextField();
        txtNombre.setFont(fuente);
        txtNombre.setPreferredSize(new Dimension(250, 30));  // Tamaño del campo de texto
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtNombre, gbc);

        // Etiqueta y campo para el apellido
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblApellido, gbc);

        txtApellido = new JTextField();
        txtApellido.setFont(fuente);
        txtApellido.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtApellido, gbc);

        // Etiqueta y campo para el nombre de usuario
        JLabel lblNombreUsuario = new JLabel("Usuario:");
        lblNombreUsuario.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblNombreUsuario, gbc);

        txtNombreUsuario = new JTextField();
        txtNombreUsuario.setFont(fuente);
        txtNombreUsuario.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtNombreUsuario, gbc);

        // Etiqueta y campo para el teléfono
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblTelefono, gbc);

        txtTelefono = new JTextField();
        txtTelefono.setFont(fuente);
        txtTelefono.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(txtTelefono, gbc);

        // Etiqueta y campo para el correo electrónico
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblCorreo, gbc);

        txtCorreoElectronico = new JTextField();
        txtCorreoElectronico.setFont(fuente);
        txtCorreoElectronico.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(txtCorreoElectronico, gbc);

        // Etiqueta y campo para la contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(lblContrasena, gbc);

        txtContrasena = new JPasswordField();
        txtContrasena.setFont(fuente);
        txtContrasena.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(txtContrasena, gbc);

        // Etiqueta y campo para confirmar la contraseña
        JLabel lblConfirmarContrasena = new JLabel("Confirmar Contraseña:");
        lblConfirmarContrasena.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(lblConfirmarContrasena, gbc);

        txtConfirmarContrasena = new JPasswordField();
        txtConfirmarContrasena.setFont(fuente);
        txtConfirmarContrasena.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(txtConfirmarContrasena, gbc);

        // Botón para registrar al usuario
        btnRegistrar = new JButton("Registrar Usuario");
        btnRegistrar.setFont(fuente);
        btnRegistrar.setBackground(new Color(30, 150, 50));  // Color verde
        btnRegistrar.setForeground(Color.BLACK);  // Color negro para el texto
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(btnRegistrar, gbc);

        // Acción cuando el usuario hace clic en el botón "Registrar"
        btnRegistrar.addActionListener(e -> {
            // Obtenemos los valores de todos los campos de texto
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String nombreUsuario = txtNombreUsuario.getText();
            String telefono = txtTelefono.getText();
            String correoElectronico = txtCorreoElectronico.getText();
            String contrasena = new String(txtContrasena.getPassword());
            String confirmarContrasena = new String(txtConfirmarContrasena.getPassword());

            // Validación: Si algún campo está vacío, mostramos un mensaje
            if (nombre.isEmpty() || apellido.isEmpty() || nombreUsuario.isEmpty() || telefono.isEmpty() || correoElectronico.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                JOptionPane.showMessageDialog(VentanaRegistro.this, "Todos los campos son obligatorios");
                return;
            }

            // Validación: Si las contraseñas no coinciden, mostramos un mensaje
            if (!contrasena.equals(confirmarContrasena)) {
                JOptionPane.showMessageDialog(VentanaRegistro.this, "Las contraseñas no coinciden");
                return;
            }

            // Creamos un nuevo objeto Usuario con los datos proporcionados
            Usuario usuario = new Usuario(nombreUsuario, nombre, apellido, telefono, correoElectronico, contrasena);
            // Agregamos el usuario a la lista gestionada por GestionUsuarios
            gestionUsuarios.agregarUsuario(usuario);
            // Mostramos un mensaje indicando que el registro fue exitoso
            JOptionPane.showMessageDialog(VentanaRegistro.this, "Usuario registrado con éxito");
            dispose();  // Cerramos la ventana de registro
        });

        // Configuramos el comportamiento al cerrar la ventana (solo la cierra, no termina el programa)
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);
    }
}
