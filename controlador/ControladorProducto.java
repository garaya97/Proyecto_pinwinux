package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import util.Conexion;
import javax.swing.JTextField;


public class ControladorProducto {
    public void agregarProducto(Producto producto, DefaultTableModel tableModel) {                //proveedor_id,           //?,
        String query = "INSERT INTO productos (nombre, categoria, precio, cantidad, stock_minimo,  garantia_dias) VALUES (?,  ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.setInt(5, producto.getStockMinimo());
            // stmt.setInt(6, producto.getProveedorId());
            stmt.setInt(6, producto.getGarantiaDias());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        producto.setId(rs.getInt(1));
                    }
                }
                cargarProductos(tableModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cargarProductos(DefaultTableModel tableModel) {
        String query = "select * from productos";
        tableModel.setRowCount(0);
        
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad"),
                    rs.getInt("stock_minimo"),
                    // rs.getString("proveedor_nombre"),
                    rs.getInt("garantia_dias")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(Producto producto, DefaultTableModel tableModel, int filaSeleccionada) {
        String query = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidad = ?, stock_minimo = ?, proveedor_id = ?, garantia_dias = ? WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.setInt(5, producto.getStockMinimo());
            // stmt.setInt(6, producto.getProveedorId());
            stmt.setInt(7, producto.getGarantiaDias());
            stmt.setInt(8, producto.getId());
            
            stmt.executeUpdate();
            cargarProductos(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int id, DefaultTableModel tableModel, int filaSeleccionada) {
        String query = "DELETE FROM productos WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            tableModel.removeRow(filaSeleccionada);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void leerProducto(int filaSeleccionada, DefaultTableModel tableModel, JTextField[] campos) {
        for (int i = 0; i < campos.length; i++) {
            campos[i].setText(tableModel.getValueAt(filaSeleccionada, i + 1).toString());
        }
    }
    

    public List<Producto> obtenerTodosProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM productos";
        
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                productos.add(new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad"),
                    rs.getInt("stock_minimo"),
                    // rs.getInt("proveedor_id"),
                    rs.getInt("garantia_dias")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}