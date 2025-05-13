package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JTabbedPane tabbedPane;
    
    public VentanaPrincipal() {
        setTitle("Sistema de Gestión de Inventario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Productos", new PanelProductos());
        // tabbedPane.addTab("Ventas", new PanelVentas());
        // tabbedPane.addTab("Notas de Crédito", new PanelNotasCredito());
        // tabbedPane.addTab("Proveedores", new PanelProveedores());
        
        add(tabbedPane);
    }
}