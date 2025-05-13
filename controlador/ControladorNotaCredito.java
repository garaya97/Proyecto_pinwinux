/* package controlador;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.NotaCredito;
import util.Conexion;
import modelo.ItemVenta;



public class ControladorNotaCredito {
    public void generarNotaCredito(NotaCredito notaCredito, List<ItemVenta> itemsDevueltos, DefaultTableModel tableModel) {
        String queryNota = "INSERT INTO notas_credito (venta_id, fecha, cliente, monto_acreditado, motivo, procesada) VALUES (?, ?, ?, ?, ?, ?)";
        String queryItems = "INSERT INTO items_nota_credito (nota_id, producto_id, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);
            
            // Insertar la nota de crédito
            try (PreparedStatement statementNota = connection.prepareStatement(queryNota, Statement.RETURN_GENERATED_KEYS)) {
                statementNota.setInt(1, notaCredito.getVentaId());
                statementNota.setDate(2, new java.sql.Date(notaCredito.getFecha().getTime()));
                statementNota.setString(3, notaCredito.getCliente());
                statementNota.setDouble(4, notaCredito.getMontoAcreditado());
                statementNota.setString(5, notaCredito.getMotivo());
                statementNota.setBoolean(6, notaCredito.isProcesada());
                
                statementNota.executeUpdate();
                
                // Obtener el ID generado
                try (ResultSet generatedKeys = statementNota.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int notaId = generatedKeys.getInt(1);
                        
                        // Insertar items de devolución
                        try (PreparedStatement statementItems = connection.prepareStatement(queryItems)) {
                            for (ItemVenta item : itemsDevueltos) {
                                statementItems.setInt(1, notaId);
                                statementItems.setInt(2, item.getProductoId());
                                statementItems.setInt(3, item.getCantidad());
                                statementItems.setDouble(4, item.getPrecioUnitario());
                                statementItems.addBatch();
                            }
                            statementItems.executeBatch();
                        }
                    }
                }
            }
            
            connection.commit();
            cargarNotasCredito(tableModel);
            
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void procesarNotaCredito(int id, boolean devolverAStock, DefaultTableModel tableModel) {
        String queryActualizar = "UPDATE notas_credito SET procesada = true WHERE id = ?";
        String queryRestaurarStock = "UPDATE productos p JOIN items_nota_credito i ON p.id = i.producto_id SET p.cantidad = p.cantidad + i.cantidad WHERE i.nota_id = ?";
        
        try (Connection connection = Conexion.getConnection()) {
            connection.setAutoCommit(false);
            
            if (devolverAStock) {
                try (PreparedStatement statementRestaurar = connection.prepareStatement(queryRestaurarStock)) {
                    statementRestaurar.setInt(1, id);
                    statementRestaurar.executeUpdate();
                }
            }
            
            try (PreparedStatement statement = connection.prepareStatement(queryActualizar)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
            
            connection.commit();
            cargarNotasCredito(tableModel);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cargarNotasCredito(DefaultTableModel tableModel) {
        String query = "SELECT * FROM notas_credito";
        tableModel.setRowCount(0);
        
        try (Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int ventaId = resultSet.getInt("venta_id");
                Date fecha = resultSet.getDate("fecha");
                String cliente = resultSet.getString("cliente");
                double monto = resultSet.getDouble("monto_acreditado");
                String motivo = resultSet.getString("motivo");
                boolean procesada = resultSet.getBoolean("procesada");
                
                tableModel.addRow(new Object[]{id, ventaId, fecha, cliente, monto, motivo, procesada ? "Sí" : "No"});
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ItemVenta> obtenerItemsNotaCredito(int notaId) {
        List<ItemVenta> items = new ArrayList<>();
        String query = "SELECT * FROM items_nota_credito WHERE nota_id = ?";
        
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, notaId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ItemVenta item = new ItemVenta(
                        resultSet.getInt("producto_id"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDouble("precio_unitario")
                    );
                    items.add(item);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return items;
    }
}
 */