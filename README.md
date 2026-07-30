# API de Gestión de Citas Médicas (Clínica)

Una API RESTful robusta desarrollada para gestionar de manera eficiente los pacientes, médicos y la programación de citas de una clínica. Este proyecto demuestra buenas prácticas de desarrollo backend, arquitectura en capas y manejo de bases de datos relacionales.

## Tecnologías Utilizadas

* **Lenguaje:** Java 21
* **Framework:** Spring Boot 3
* **Persistencia de Datos:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL 
* **Gestor de Dependencias:** Maven

## Características Principales (Endpoints)

* **Gestión de Pacientes:** Operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para los registros de pacientes.
* **Gestión de Médicos:** Administración del personal médico y sus especialidades.
* **Programación de Citas:** 
  * Creación de nuevas citas validando la disponibilidad del médico.
  * Cancelación de citas.
  * Listado de citas por fecha o por paciente.
* **Manejo de Excepciones:** Respuestas HTTP estandarizadas para errores (ej. 404 Not Found, 400 Bad Request cuando un horario está ocupado).