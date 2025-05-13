/* package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNotasCredito extends JPanel {
    private JButton btnGenerarNota, btnProcesarNota;
    private JTable tablaNotas, tablaItemsNota;
    private DefaultTableModel tableModelNotas, tableModelItems;

    public PanelNotasCredito() {
        setLayout(new BorderLayout());
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        btnGenerarNota = new JButton("Generar Nota de Crédito");
        btnProcesarNota = new JButton("Procesar Nota de Crédito");
        
        panelBotones.add(btnGenerarNota);
        panelBotones.add(btnProcesarNota);
        
        // Tabla de notas de crédito
        tableModelNotas = new DefaultTableModel(new Object[]{"ID", "Venta ID", "Fecha", "Cliente", "Monto", "Motivo", "Procesada"}, 0);
        tablaNotas = new JTable(tableModelNotas);
        JScrollPane scrollPaneNotas = new JScrollPane(tablaNotas);
        
        // Tabla de items de nota de crédito
        tableModelItems = new DefaultTableModel(new Object[]{"Producto", "Cantidad", "Precio Unitario", "Subtotal"}, 0);
        tablaItemsNota = new JTable(tableModelItems);
        JScrollPane scrollPaneItems = new JScrollPane(tablaItemsNota);
        scrollPaneItems.setBorder(BorderFactory.createTitledBorder("Detalle de Devolución"));
        
        // Panel central (notas + items)
        JPanel panelCentral = new JPanel(new GridLayout(2, 1));
        panelCentral.add(scrollPaneNotas);
        panelCentral.add(scrollPaneItems);
        
        // Agregar componentes al panel principal
        add(panelBotones, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        
        // Configurar eventos
        configurarEventos();
    }

    private void configurarEventos() {
        btnGenerarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para generar nota de crédito
            }
        });
        
        btnProcesarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para procesar nota de crédito
            }
        });
        
        tablaNotas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // Lógica para cargar items de nota seleccionada
            }
        });
    }
}
 */