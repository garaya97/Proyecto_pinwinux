/* package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelProveedores extends JPanel {
    private JTextField txtNombre, txtContacto, txtDireccion, txtTelefono;
    private JButton btnAgregar, btnModificar, btnEliminar;
    private JTable tablaProveedores;
    private DefaultTableModel tableModel;

    public PanelProveedores() {
        setLayout(new BorderLayout());
        
        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Proveedor"));
        
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);
        
        panelFormulario.add(new JLabel("Contacto:"));
        txtContacto = new JTextField();
        panelFormulario.add(txtContacto);
        
        panelFormulario.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelFormulario.add(txtDireccion);
        
        panelFormulario.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelFormulario.add(txtTelefono);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        
        // Panel superior (formulario + botones)
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelFormulario, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);
        
        // Tabla de proveedores
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Contacto", "Dirección", "Teléfono"}, 0);
        tablaProveedores = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tablaProveedores);
        
        // Agregar componentes al panel principal
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Configurar eventos
        configurarEventos();
    }

    private void configurarEventos() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar proveedor
            }
        });
        
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar proveedor
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar proveedor
            }
        });
    }
}
 */