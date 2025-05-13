Chic@os agrego el Script de base de datos.

-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS gestion_inventario_pinwinux;
USE gestion_inventario_pinwinux;

-- Tabla de proveedores
CREATE TABLE IF NOT EXISTS proveedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100),
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de productos
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL DEFAULT 0,
    stock_minimo INT NOT NULL DEFAULT 5,
    -- proveedor_id INT,
    garantia_dias INT NOT NULL DEFAULT 30,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    -- ,FOREIGN KEY (proveedor_id) REFERENCES proveedores(id) ON DELETE SET NULL
);

-- Tabla de clientes (simplificada para el sistema)
CREATE TABLE IF NOT EXISTS clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100),
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de ventas
CREATE TABLE IF NOT EXISTS ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    cliente_id INT,
    cliente_nombre VARCHAR(100) NOT NULL, -- Para guardar el nombre aunque se borre el cliente
    total DECIMAL(12, 2) NOT NULL,
    anulada BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE SET NULL
);

-- Tabla de items de venta
CREATE TABLE IF NOT EXISTS items_venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (venta_id) REFERENCES ventas(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- Tabla de notas de crédito
CREATE TABLE IF NOT EXISTS notas_credito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT NOT NULL,
    fecha DATETIME NOT NULL,
    cliente_id INT,
    cliente_nombre VARCHAR(100) NOT NULL,
    monto_acreditado DECIMAL(12, 2) NOT NULL,
    motivo TEXT,
    procesada BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (venta_id) REFERENCES ventas(id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE SET NULL
);

-- Tabla de items de nota de crédito
CREATE TABLE IF NOT EXISTS items_nota_credito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nota_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (nota_id) REFERENCES notas_credito(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- Tabla de historial de inventario (opcional para tracking)
CREATE TABLE IF NOT EXISTS historial_inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT NOT NULL,
    cantidad_anterior INT NOT NULL,
    cantidad_nueva INT NOT NULL,
    tipo_movimiento ENUM('ENTRADA', 'SALIDA', 'AJUSTE') NOT NULL,
    referencia_id INT, -- ID de venta, nota crédito, etc.
    tipo_referencia VARCHAR(50), -- 'VENTA', 'NOTA_CREDITO', etc.
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario VARCHAR(50),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

select * from productos

SHOW TABLES;


-- Insertar proveedores de prueba
INSERT INTO proveedores (nombre, contacto, direccion, telefono) VALUES
('TecnoSuministros', 'Juan Pérez', 'Av. Tecnológica 123', '555-1234'),
('CompuParts', 'María Gómez', 'Calle Componentes 456', '555-5678');

-- Insertar productos de prueba
INSERT INTO productos (nombre, categoria, precio, cantidad, stock_minimo, proveedor_id, garantia_dias) VALUES
('Teclado RGB', 'Periféricos', 45.99, 50, 10, 1, 30),
('Mouse inalámbrico', 'Periféricos', 25.50, 75, 15, 1, 30),
('Monitor 24"', 'Monitores', 199.99, 20, 5, 2, 365),
('Disco SSD 500GB', 'Almacenamiento', 79.99, 40, 8, 2, 180);

-- Insertar cliente de prueba
INSERT INTO clientes (nombre, contacto, direccion, telefono) VALUES
('Cliente Corporativo', 'Carlos Ruiz', 'Av. Principal 789', '555-9012');

-- Índices para mejorar el rendimiento
CREATE INDEX idx_productos_nombre ON productos(nombre);
CREATE INDEX idx_productos_categoria ON productos(categoria);
CREATE INDEX idx_ventas_fecha ON ventas(fecha);
CREATE INDEX idx_ventas_cliente ON ventas(cliente_id);
CREATE INDEX idx_notas_credito_venta ON notas_credito(venta_id);
