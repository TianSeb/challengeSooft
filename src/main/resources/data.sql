-- Resetear autoincremento
ALTER TABLE empresa ALTER COLUMN id RESTART WITH 4;

-- Crear Indices
CREATE INDEX idx_empresa_fecha_adhesion ON empresa(fecha_adhesion);
CREATE INDEX idx_empresa_razon_social ON empresa(razon_social);

CREATE INDEX idx_transferencia_fecha ON transferencia(fecha);
CREATE INDEX idx_transferencia_empresa ON transferencia(empresa_id);

-- Empresas
INSERT INTO empresa (id, cuit, razon_social, fecha_adhesion) VALUES
 (1, '20123456780', 'Empresa Alfa S.A.', '2024-05-10'),
 (2, '20987654321', 'Empresa Beta SRL', '2024-06-01'),
 (3, '20345678901', 'Empresa Gamma', '2024-06-15');

-- Transferencias
INSERT INTO transferencia (fecha, importe, cuenta_debito, cuenta_credito, empresa_id) VALUES
('2025-06-01', 10000.00, '123-456', '654-321', 1),
('2025-06-05', 15000.00, '111-222', '333-444', 2),
('2025-06-20', 5000.00, '555-666', '777-888', 2),
('2024-05-10', 9000.00, '999-000', '000-999', 3);


