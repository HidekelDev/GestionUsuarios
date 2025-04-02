import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    // Declaramos la tabla que vamos a usar para mostrar los usuarios
    private JTable tablaUsuarios;
    // Creamos el modelo de la tabla para manejar los datos
    private DefaultTableModel modeloTabla;
    // Botones para interactuar con la ventana
    private JButton btnNuevo, btnActualizar, btnEliminar, btnCerrarSesion;
    private GestionUsuarios gestionUsuarios;

    public VentanaPrincipal() {
        // Obtenemos la instancia única de la clase GestionUsuarios para manejar los usuarios
        gestionUsuarios = GestionUsuarios.getInstancia();
        setTitle("Clientes Registrados");  // Título de la ventana
        setSize(800, 600);  // Tamaño de la ventana
        setLayout(new BorderLayout());  // Usamos BorderLayout para organizar los elementos

        // Configuramos el modelo de la tabla con las columnas
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Correo Electrónico");
        modeloTabla.addColumn("Usuario");

        // Creamos la tabla que usará el modelo y la insertamos en un JScrollPane para que sea desplazable
        tablaUsuarios = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        add(scrollPane, BorderLayout.CENTER);  // Añadimos la tabla al centro de la ventana

        // Panel que contiene los botones de acción
        JPanel panelBotones = new JPanel();
        // Creamos los botones con sus textos
        btnNuevo = new JButton("Nuevo");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnCerrarSesion = new JButton("Cerrar Sesión");

        // Establecemos el color de fondo de los botones
        btnNuevo.setBackground(new Color(220, 220, 220));
        btnActualizar.setBackground(new Color(220, 220, 220));
        btnEliminar.setBackground(new Color(220, 220, 220));
        btnCerrarSesion.setBackground(new Color(220, 220, 220));

        // Añadimos los botones al panel
        panelBotones.add(btnNuevo);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCerrarSesion);
        // Añadimos el panel de botones al sur de la ventana
        add(panelBotones, BorderLayout.SOUTH);

        // Actualizamos la tabla con la lista de usuarios
        actualizarTabla();

        // Acción para el botón de Cerrar Sesión
        btnCerrarSesion.addActionListener(e -> {
            // Cuando se hace clic en Cerrar Sesión, se abre la ventana de login y se cierra esta ventana
            VentanaLogin ventanaLogin = new VentanaLogin();
            ventanaLogin.setVisible(true);
            dispose();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Configuramos el comportamiento al cerrar la ventana
        setLocationRelativeTo(null);  // Centramos la ventana en la pantalla
    }

    // Método para actualizar la tabla con la lista de usuarios
    private void actualizarTabla() {
        modeloTabla.setRowCount(0);  // Limpiamos la tabla antes de agregar los nuevos datos
        // Obtenemos todos los usuarios de la instancia de GestionUsuarios
        List<Usuario> usuarios = gestionUsuarios.obtenerTodosUsuarios();
        // Iteramos por cada usuario y agregamos una fila en la tabla para cada uno
        for (Usuario usuario : usuarios) {
            modeloTabla.addRow(new Object[]{
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getTelefono(),
                    usuario.getCorreoElectronico(),
                    usuario.getNombreUsuario()
            });
        }
    }
}
