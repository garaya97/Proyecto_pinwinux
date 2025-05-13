package vista;


import modelo.*;
import controlador.ControladorProducto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PanelProductos extends JPanel {
    private ControladorProducto controlador;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private JTextField txtNombre, txtCategoria, txtPrecio, txtCantidad, txtStockMinimo,  txtGarantia; //txtProveedorId,
    private JButton btnAgregar, btnActualizar, btnEliminar, btnLimpiar;

    public PanelProductos() {
        controlador = new ControladorProducto();
        initComponents();
        cargarDatos();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(7, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        panelFormulario.add(txtCategoria);

        panelFormulario.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panelFormulario.add(txtCantidad);

        panelFormulario.add(new JLabel("Stock Mínimo:"));
        txtStockMinimo = new JTextField();
        panelFormulario.add(txtStockMinimo);

/*         panelFormulario.add(new JLabel("ID Proveedor:"));
        txtProveedorId = new JTextField();
        panelFormulario.add(txtProveedorId); */

        panelFormulario.add(new JLabel("Días Garantía:"));
        txtGarantia = new JTextField();
        panelFormulario.add(txtGarantia);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        // Panel superior (formulario + botones)
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelFormulario, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        // Tabla de productos
        String[] columnas = {"ID", "Nombre", "Categoría", "Precio", "Cantidad", "Stock Mínimo", "Proveedor", "Garantía (días)"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);

        // Agregar componentes al panel principal
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar eventos
        configurarEventos();
    }

    private void configurarEventos() {
        btnAgregar.addActionListener(e -> agregarProducto());
        btnActualizar.addActionListener(e -> actualizarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        
        tablaProductos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablaProductos.getSelectedRow() != -1) {
                cargarDatosFormulario();
            }
        });
    }

    private void agregarProducto() {
        Producto producto = new Producto(
            0,
            txtNombre.getText(),
            txtCategoria.getText(),
            Double.parseDouble(txtPrecio.getText()),
            Integer.parseInt(txtCantidad.getText()),
            Integer.parseInt(txtStockMinimo.getText()),
            // Integer.parseInt(txtProveedorId.getText()),
            Integer.parseInt(txtGarantia.getText())
        );
        
        controlador.agregarProducto(producto, modeloTabla);
        limpiarCampos();
    }

    private void actualizarProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            
            Producto producto = new Producto(
                id,
                txtNombre.getText(),
                txtCategoria.getText(),
                Double.parseDouble(txtPrecio.getText()),
                Integer.parseInt(txtCantidad.getText()),
                Integer.parseInt(txtStockMinimo.getText()),
                // Integer.parseInt(txtProveedorId.getText()),
                Integer.parseInt(txtGarantia.getText())
            );
            
            controlador.actualizarProducto(producto, modeloTabla, filaSeleccionada);
            limpiarCampos();
        }
    }

    private void eliminarProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            controlador.eliminarProducto(id, modeloTabla, filaSeleccionada);
            limpiarCampos();
        }
    }

    private void cargarDatosFormulario() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtNombre.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
            txtCategoria.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
            txtPrecio.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
            txtCantidad.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
            txtStockMinimo.setText(modeloTabla.getValueAt(filaSeleccionada, 5).toString());
            // Proveedor es el nombre, necesitarías obtener el ID de otra manera
            txtGarantia.setText(modeloTabla.getValueAt(filaSeleccionada, 7).toString());
        }
    }

    private void cargarDatos() {
        controlador.cargarProductos(modeloTabla);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCategoria.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtStockMinimo.setText("");
        // txtProveedorId.setText("");
        txtGarantia.setText("");
        tablaProductos.clearSelection();
    }
}
