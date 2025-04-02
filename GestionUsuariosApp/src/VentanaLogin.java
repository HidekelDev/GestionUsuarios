import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    // Campos para los elementos de la ventana
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnEntrar;
    private JButton btnRegistrarse;
    private GestionUsuarios gestionUsuarios;

    public VentanaLogin() {
        // Obtenemos la instancia de la clase gestionUsuarios
        gestionUsuarios = GestionUsuarios.getInstancia();

        // Configuramos el título de la ventana y su tamaño
        setTitle("Iniciar Sesión");
        setSize(350, 250);

        // Usamos GridBagLayout para organizar los elementos en la ventana
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaciado entre los elementos
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Llenado horizontal para los componentes

        // Definimos la fuente para los textos
        Font fuente = new Font("Arial", Font.PLAIN, 14);

        // Etiqueta y campo de texto para el usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsuario, gbc);  // Añadimos la etiqueta a la ventana

        txtUsuario = new JTextField();
        txtUsuario.setFont(fuente);
        txtUsuario.setPreferredSize(new Dimension(200, 30));  // Establecemos el tamaño del campo de texto
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtUsuario, gbc);  // Añadimos el campo de texto para el usuario

        // Etiqueta y campo de texto para la contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblContrasena, gbc);  // Añadimos la etiqueta para la contraseña

        txtContrasena = new JPasswordField();
        txtContrasena.setFont(fuente);
        txtContrasena.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtContrasena, gbc);  // Añadimos el campo de contraseña

        // Botón para entrar
        btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(fuente);
        btnEntrar.setBackground(new Color(30, 100, 200));  // Color de fondo del botón
        btnEntrar.setForeground(Color.BLACK);  // Color del texto del botón
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;  // Este botón ocupa el ancho completo
        add(btnEntrar, gbc);  // Añadimos el botón Entrar

        // Botón para registrarse
        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setFont(fuente);
        btnRegistrarse.setBackground(new Color(80, 80, 80));  // Color de fondo del botón
        btnRegistrarse.setForeground(Color.BLACK);  // Color del texto del botón
        gbc.gridy = 3;  // Colocamos este botón en la fila 3
        add(btnRegistrarse, gbc);  // Añadimos el botón Registrarse

        // Acción para el botón Entrar
        btnEntrar.addActionListener(e -> {
            String usuario = txtUsuario.getText();  // Obtenemos el nombre de usuario
            String contrasena = new String(txtContrasena.getPassword());  // Obtenemos la contraseña

            // Verificamos que el usuario y la contraseña no estén vacíos
            if (usuario.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(VentanaLogin.this, "Ingrese usuario y contraseña");
                return;  // Si están vacíos, no seguimos con el proceso
            }

            // Intentamos obtener el usuario de la base de datos
            Usuario usuarioEncontrado = gestionUsuarios.obtenerUsuario(usuario, contrasena);
            if (usuarioEncontrado != null) {  // Si lo encontramos
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);  // Mostramos la ventana principal
                dispose();  // Cerramos la ventana de login
            } else {
                // Si no lo encontramos, mostramos un mensaje de error
                JOptionPane.showMessageDialog(VentanaLogin.this, "Usuario o contraseña incorrectos");
            }
        });

        // Acción para el botón Registrarse
        btnRegistrarse.addActionListener(e -> {
            VentanaRegistro ventanaRegistro = new VentanaRegistro();
            ventanaRegistro.setVisible(true);  // Mostramos la ventana de registro
        });

        // Configuramos el comportamiento al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centra la ventana en la pantalla
    }

    public static void main(String[] args) {
        // Ejecutamos la ventana de login en el hilo de eventos
        SwingUtilities.invokeLater(() -> new VentanaLogin().setVisible(true));
    }
}
