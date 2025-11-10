# Springboot-gestion-clientes

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)
![Lombok](https://img.shields.io/badge/Lombok-1.18.26-red.svg)
![OpenAPI](https://img.shields.io/badge/OpenAPI-3.0.0-blue.svg)
![JUnit](https://img.shields.io/badge/JUnit-5-purple.svg)
![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)
![Mit License](https://img.shields.io/badge/License-MIT-yellow.svg)

## 📋 Description
**Springboot-gestion-clientes** es una aplicación RESTful desarrollada con **Spring Boot**. Esta API está diseñada para gestionar clientes, permitiendo operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de manera eficiente y segura.

### 🎯 Main Features

- ✅ **Gestión de Clientes**: Permite crear, leer, actualizar y eliminar clientes.
- ✅ **API RESTful**: Endpoints bien definidos para interactuar con el servicio de gestión de clientes.
- ✅ **Documentación OpenAPI**: Interfaz Swagger UI para explorar y probar los endpoints.
- ✅ **Excepciones Personalizadas**: Respuestas claras y detalladas para errores comunes.
- ✅ **Pruebas Unitarias**: Pruebas realizadas con JUnit para garantizar la calidad del código.

## 📋 Endpoints Principales
Aquí están los principales endpoints de la API:

| Método | Endpoint               | Descripción                       |
|--------|------------------------|-----------------------------------|
| POST   | /api/v1/clientes       | Crea un nuevo cliente             |
| GET    | /api/v1/clientes       | Obtiene la lista de clientes      |
| GET    | /api/v1/clientes/{id}  | Obtiene un cliente por ID          |
| PUT    | /api/v1/clientes/{id}  | Actualiza un cliente por ID      |
| DELETE | /api/v1/clientes/{id}  | Elimina un cliente por ID        |

## 🏗️ Arquitectura
Este proyecto sigue una arquitectura bien definida:
```
┌─────────────────────────────────────┐
│         Controllers                 │
│      (REST API Endpoints)           │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│          Services                   │
│    (Lógica de Negocio)              │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        Repository Layer             │
│   (Acceso a Información con JPA)    │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        Configuration Layer          │
│   (Configuración de base de datos)  │
└─────────────────────────────────────┘
```
Todas las capas tienen tareas específicas, asegurando una clara separación entre cada una. Esto permite un fácil mantenimiento y escalabilidad del proyecto.

### Cómo Ejecutar la Aplicación

1. Clona el repositorio:
   ```bash
    git clone <https://github.com/matepore/springboot-gestion-clientes>
    cd springboot-gestion-clientes
    ```
2. Ejecuta la aplicación usando Maven:
   ```bash
    mvn spring-boot:run
    ```
3. Accede a la documentación de la API en `http://localhost:8080/db_clientes/swagger-ui/index.html#/`.
4. Usa los endpoints para gestionar clientes según sea necesario.
5. Ejecuta las pruebas unitarias:
   ```bash
    mvn test
    ```

## 📝 Licencia

Este proyecto está licenciado para uso personal o educativo bajo la licencia MIT.

## 👥 Autor
**Mateo Calcagno**
- 📧 Email: calcagno.mateo@gmail.com
- 📱 Celular: +54 9 11 3119-1742
- 🌎 Nacionalidad: Argentina
- 🎓 Educación: Técnico Universitario en Desarrollo de Software
- 🏛️ Institución: Universidad de Ezeiza
