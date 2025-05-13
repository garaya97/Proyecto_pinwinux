/* package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVentas extends JPanel {
    private JTextField txtCliente;
    private JButton btnNuevaVenta, btnAnularVenta;
    private JTable tablaVentas, tablaItemsVenta;
    private DefaultTableModel tableModelVentas, tableModelItems;

    public PanelVentas() {
        setLayout(new BorderLayout());
        
        // Panel de formulario
        JPanel panelFormulario = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Nueva Venta"));
        
        panelFormulario.add(new JLabel("Cliente:"));
        txtCliente = new JTextField(20);
        panelFormulario.add(txtCliente);
        
        btnNuevaVenta = new JButton("Nueva Venta");
        panelFormulario.add(btnNuevaVenta);
        
        btnAnularVenta = new JButton("Anular Venta");
        panelFormulario.add(btnAnularVenta);
        
        // Tabla de ventas
        tableModelVentas = new DefaultTableModel(new Object[]{"ID", "Fecha", "Cliente", "Total"}, 0);
        tablaVentas = new JTable(tableModelVentas);
        JScrollPane scrollPaneVentas = new JScrollPane(tablaVentas);
        
        // Tabla de items de venta
        tableModelItems = new DefaultTableModel(new Object[]{"Producto", "Cantidad", "Precio Unitario", "Subtotal"}, 0);
        tablaItemsVenta = new JTable(tableModelItems);
        JScrollPane scrollPaneItems = new JScrollPane(tablaItemsVenta);
        scrollPaneItems.setBorder(BorderFactory.createTitledBorder("Detalle de Venta"));
        
        // Panel central (ventas + items)
        JPanel panelCentral = new JPanel(new GridLayout(2, 1));
        panelCentral.add(scrollPaneVentas);
        panelCentral.add(scrollPaneItems);
        
        // Agregar componentes al panel principal
        add(panelFormulario, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        
        // Configurar eventos
        configurarEventos();
    }

    private void configurarEventos() {
        btnNuevaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para nueva venta
            }
        });
        
        btnAnularVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para anular venta
            }
        });
        
        tablaVentas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // Lógica para cargar items de venta seleccionada
            }
        });
    }
}
 */