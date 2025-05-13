/* package controlador;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;
import util.Conexion;


public class ControladorProveedor {
    public void agregarProveedor(Proveedor proveedor, DefaultTableModel tableModel) {
        String query = "INSERT INTO proveedores (nombre, contacto, direccion, telefono) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getContacto());
            statement.setString(3, proveedor.getDireccion());
            statement.setString(4, proveedor.getTelefono());
            
            statement.executeUpdate();
            cargarProveedores(tableModel);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarProveedor(Proveedor proveedor, DefaultTableModel tableModel) {
        String query = "UPDATE proveedores SET nombre = ?, contacto = ?, direccion = ?, telefono = ? WHERE id = ?";
        
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getContacto());
            statement.setString(3, proveedor.getDireccion());
            statement.setString(4, proveedor.getTelefono());
            statement.setInt(5, proveedor.getId());
            
            statement.executeUpdate();
            cargarProveedores(tableModel);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProveedor(int id, DefaultTableModel tableModel) {
        String query = "DELETE FROM proveedores WHERE id = ?";
        
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, id);
            statement.executeUpdate();
            cargarProveedores(tableModel);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cargarProveedores(DefaultTableModel tableModel) {
        String query = "SELECT * FROM proveedores";
        tableModel.setRowCount(0);
        
        try (Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String contacto = resultSet.getString("contacto");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                
                tableModel.addRow(new Object[]{id, nombre, contacto, direccion, telefono});
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 */