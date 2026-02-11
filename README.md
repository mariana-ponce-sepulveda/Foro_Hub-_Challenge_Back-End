<h1 align="center">💬 ForoHub 🗣️</h1> <p align="center"> </p> <p align="center"> <img src="https://img.shields.io/badge/STATUS-Finished-brightgreen?style=for-the-badge"> <img src="https://img.shields.io/badge/GOAL-Self%20Learning-blue?style=for-the-badge"> <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/JWT-Black?style=for-the-badge&logo=jsonwebtokens"> </p>
📝 Descripción

ForoHub es una API REST desarrollada con Spring Boot que simula un foro técnico de discusión.

La aplicación permite a los usuarios registrarse, autenticarse mediante JWT (JSON Web Tokens) y gestionar tópicos y respuestas dentro de la plataforma.

Este proyecto fue desarrollado como parte del programa Oracle Next Education (ONE) y tiene como objetivo reforzar conocimientos en desarrollo backend, seguridad y arquitectura de aplicaciones.

🛠️ Tecnologías Utilizadas

Java 17

Spring Boot 3

Spring Security

Spring Data JPA

Auth0 JWT

MySQL

Flyway

Lombok

Maven

🚀 Funcionalidades

✔️ Autenticación Stateless con JWT
✔️ Registro y login de usuarios
✔️ CRUD completo de tópicos
✔️ Gestión de respuestas
✔️ Gestión de cursos
✔️ Paginación y ordenamiento
✔️ Migraciones automáticas con Flyway
✔️ Encriptación de contraseñas con BCrypt
✔️ Manejo global de excepciones

🔐 Seguridad

La aplicación implementa un sistema Stateless Authentication:

📌 Registro

El usuario crea una cuenta.

La contraseña se almacena usando BCrypt hashing.

📌 Login

El usuario envía email y contraseña.

Si las credenciales son válidas, se genera un Token JWT.

📌 Autorización

El cliente debe enviar el token en el header:

Authorization: Bearer <token>


Las rutas protegidas validan el token antes de permitir el acceso.

📋 Endpoints Principales
🔓 Autenticación (Públicos)

POST /login → Retorna JWT

POST /users → Registro de usuarios

🔒 Tópicos (Protegidos)

GET /topics → Lista paginada de tópicos

GET /topics/{id} → Detalle de un tópico

POST /topics → Crear nuevo tópico

PUT /topics/{id} → Actualizar tópico propio

DELETE /topics/{id} → Eliminar tópico

📚 Cursos y Respuestas (Protegidos)

GET /courses → Listar cursos

POST /courses → Crear curso

POST /responses → Responder a un tópico

▶️ Cómo Ejecutar el Proyecto

1️⃣ Clonar repositorio
git clone https://github.com/tu-usuario/forohub.git

2️⃣ Configurar Base de Datos

Crear base de datos en MySQL:

CREATE DATABASE forohub;


Configurar application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

api.security.secret=${JWT_SECRET:tu_clave_secreta}
📂 Arquitectura del Proyecto
controller        → Controladores REST
dto               → Transferencia segura de datos
exceptions        → Manejo global de errores
infra.security    → Configuración JWT y filtros
model             → Entidades JPA
repository        → Acceso a datos
service           → Lógica de negocio

🎯 Objetivo del Proyecto

Aplicar principios de arquitectura REST

Implementar seguridad moderna con JWT

Practicar separación de responsabilidades

Comprender el flujo completo de autenticación

Trabajar con migraciones versionadas

## 📌 Estado del Proyecto

✅ Finalizado — abierto a mejoras o nuevas versiones.
