# Challenge Backend Java – SOOFT Technology

## ✅ Descripción

Este proyecto resuelve el desafío propuesto por SOOFT Technology, que consiste en implementar 3 endpoints REST utilizando Java, Spring Boot y una arquitectura hexagonal limpia y desacoplada.

---

## 🚀 Funcionalidades implementadas

### 1. Registrar una nueva empresa
- **POST** `/empresas`
- Recibe: `cuit`, `razonSocial`
- Asigna automáticamente `fechaAdhesion` (fecha actual)
- Devuelve la empresa registrada

### 2. Obtener empresas que se adhirieron en los últimos 30 días
- **GET** `/empresas/adhesion/ultimos-30-dias`
- Paginado (`page`, `size`)
- Devuelve empresas con `fechaAdhesion >= hoy - 30 días`

### 3. Obtener empresas que realizaron transferencias en los últimos 30 días
- **GET** `/transferencias/ultimos-30-dias`
- Paginado
- Devuelve empresas que tienen al menos una transferencia con `fecha >= hoy - 30 días`

---

## 🧱 Arquitectura

Se utilizó una **arquitectura hexagonal**, siguiendo las siguientes capas:

- `domain.model`: entidades puras del dominio (`Empresa`, `Transferencia`)
- `domain.port.in`: interfaces de casos de uso (entradas)
- `domain.port.out`: interfaces de persistencia y consultas (salidas)
- `application`: implementaciones de los casos de uso
- `adapter.in`: controllers REST
- `adapter.out`: entidades JPA, mappers y repositorios
- `mapper`: MapStruct para transformar entre capas
- `exception`: manejo global de errores

---

## 🗃️ Base de datos

- Motor: H2 en memoria
- Las tablas se generan automáticamente (`ddl-auto=create-drop`)
- Los datos se precargan desde `data.sql` en `src/main/resources`

---

## ⚠️ Suposiciones realizadas

1. Se agregó el campo `fecha` a la entidad `Transferencia`, ya que no estaba definido pero era imprescindible para cumplir con el filtro de últimos 30 días.
2. Se asumió que el campo `CUIT` de empresa debe ser único, por lo que se aplicó una restricción de unicidad y se capturan errores de integridad.
3. Se eligió una base relacional (H2) para claridad y facilidad de pruebas, priorizando integridad referencial y queries eficientes con joins e índices.
4. Se utilizaron DTOs para desacoplar el dominio de la capa web, y mappers para mantener las transformaciones aisladas.

---

## 🧪 Cómo probar

- Levantar la aplicación (`./gradlew bootRun` o desde tu IDE)
- Acceder a:
    - `http://localhost:8080/h2-console` (usuario: `sa`, pass: `admin`)
    - Endpoints REST disponibles en Postman o navegador

---
# challengeSooft
