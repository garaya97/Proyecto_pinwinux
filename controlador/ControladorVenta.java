/* package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.ItemVenta;
import modelo.Venta;
import util.Conexion;

public class ControladorVenta {
    public void realizarVenta(Venta venta, List<ItemVenta> items, DefaultTableModel tableModel) {
        String queryVenta = "INSERT INTO ventas (fecha, cliente, total) VALUES (?, ?, ?)";
        String queryItems = "INSERT INTO items_venta (venta_id, producto_id, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
        String queryActualizarStock = "UPDATE productos SET cantidad = cantidad - ? WHERE id = ?";
        
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            conn.setAutoCommit(false);
            
            // Insertar venta
            try (PreparedStatement stmtVenta = conn.prepareStatement(queryVenta, Statement.RETURN_GENERATED_KEYS)) {
                stmtVenta.setDate(1, new java.sql.Date(venta.getFecha().getTime()));
                stmtVenta.setString(2, venta.getCliente());
                stmtVenta.setDouble(3, venta.getTotal());
                
                stmtVenta.executeUpdate();
                
                // Obtener ID generado
                try (ResultSet rs = stmtVenta.getGeneratedKeys()) {
                    if (rs.next()) {
                        int ventaId = rs.getInt(1);
                        
                        // Insertar items
                        try (PreparedStatement stmtItems = conn.prepareStatement(queryItems)) {
                            for (ItemVenta item : items) {
                                stmtItems.setInt(1, ventaId);
                                stmtItems.setInt(2, item.getProductoId());
                                stmtItems.setInt(3, item.getCantidad());
                                stmtItems.setDouble(4, item.getPrecioUnitario());
                                stmtItems.addBatch();
                                
                                // Actualizar stock
                                try (PreparedStatement stmtStock = conn.prepareStatement(queryActualizarStock)) {
                                    stmtStock.setInt(1, item.getCantidad());
                                    stmtStock.setInt(2, item.getProductoId());
                                    stmtStock.executeUpdate();
                                }
                            }
                            stmtItems.executeBatch();
                        }
                    }
                }
            }
            
            conn.commit();
            cargarVentas(tableModel);
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cargarVentas(DefaultTableModel tableModel) {
        String query = "SELECT * FROM ventas WHERE anulada = false";
        tableModel.setRowCount(0);
        
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getDate("fecha"),
                    rs.getString("cliente"),
                    rs.getDouble("total")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ItemVenta> obtenerItemsVenta(int ventaId) {
        List<ItemVenta> items = new ArrayList<>();
        String query = "SELECT i.*, p.nombre as producto_nombre FROM items_venta i JOIN productos p ON i.producto_id = p.id WHERE i.venta_id = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, ventaId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    items.add(new ItemVenta(
                        rs.getInt("producto_id"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_unitario")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void anularVenta(int id, DefaultTableModel tableModel) {
        String query = "UPDATE ventas SET anulada = true WHERE id = ?";
        String queryRestaurarStock = "UPDATE productos p JOIN items_venta i ON p.id = i.producto_id SET p.cantidad = p.cantidad + i.cantidad WHERE i.venta_id = ?";
        
        try (Connection conn = Conexion.getConnection()) {
            conn.setAutoCommit(false);
            
            try (PreparedStatement stmtRestaurar = conn.prepareStatement(queryRestaurarStock)) {
                stmtRestaurar.setInt(1, id);
                stmtRestaurar.executeUpdate();
            }
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
            
            conn.commit();
            cargarVentas(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} */