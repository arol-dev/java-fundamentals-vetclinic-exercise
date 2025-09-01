# 🐾 Ejercicio VetClinic Light Monolith

Este ejercicio tiene como objetivo desarrollar un **sistema básico de gestión de clínicas veterinarias** utilizando **Spring Boot**.  

El trabajo se divide en dos fases:  

1. **Primera parte:** Implementar una API REST monolítica en Spring Boot, con arquitectura por capas y sin seguridad ni Swagger.  
2. **Segunda parte:** Extender la API agregando **seguridad con OAuth2.0 (JWT Bearer Token mediante Auth0)** y **documentación con Swagger**.  

En ambas fases se incluyen **colecciones de Postman** para verificar la correcta implementación de los endpoints.  
⚠️ Importante: en la segunda fase, cualquier request sin token válido debe devolver **401 Unauthorized**.  

---

## 🔧 Parte 1: Implementación de API RESTful

**Objetivo:** construir una API REST monolítica con Spring Boot usando arquitectura por capas, sin incluir aún seguridad ni Swagger.  

### Requisitos técnicos

- Java 17+  
- Spring Boot  
- Maven  
- JPA + H2 (o PostgreSQL si se prefiere)  
- Git + Gitflow  

### Entidades principales

- `Owner`: nombre, teléfono, dirección  
- `Pet`: nombre, tipo, fecha de nacimiento, relación con Owner  
- `Visit`: fecha, motivo, relación con Pet  

### Endpoints básicos

**Owners**
- `GET /owners`  
- `POST /owners`  

**Pets**
- `GET /pets`  
- `POST /pets`  

**Visits**
- `GET /visits`  
- `POST /visits`  

### Actividades sugeridas

1. Crear el proyecto con **Spring Initializr**.  
2. Definir el **modelo de entidades** (`Owner`, `Pet`, `Visit`).  
3. Implementar **repositorios JPA** para cada entidad.  
4. Crear los **servicios** que gestionen la lógica de negocio.  
5. Implementar **controladores REST** para exponer los endpoints.  
6. Incorporar **DTOs y mapeo** (ejemplo: ModelMapper o MapStruct).  
7. Escribir **tests unitarios básicos con JUnit** para los servicios.  
8. Probar los endpoints con la colección de **Postman (sin seguridad)**.  
9. Mantener el proyecto en Git usando un flujo de ramas claro (**Gitflow**).  

👉 Consejo: comienza probando con H2 en memoria y luego, si quieres, cambia a PostgreSQL.  

---

## ✅ Tests con Postman (Parte 1)

Archivos incluidos:  

- `java-fundamentals-vetclinic.postman_collection.json`  
- `java-fundamentals-vetclinic-local.postman_environment.json`  

Variables necesarias en el entorno:  

- `baseUrl`: URL del backend (ejemplo: `http://localhost:8080`)  

### Ejecución

1. Importar la colección y el entorno en Postman.  
2. Seleccionar el entorno **Vet Clinic Monolith - Local**.  
3. Asegurar que el backend esté corriendo en `localhost:8080`.  
4. Ejecutar los requests en este orden:  
   - `POST /owners` → crea un Owner y guarda `ownerId`.  
   - `POST /pets` → crea un Pet vinculado al `ownerId`.  
   - `POST /visits` → crea una Visit vinculada al `petId`.  
5. Confirmar que todos los tests pasan correctamente.  

Validaciones que realiza Postman:  
- Códigos de estado `200/201`.  
- Respuestas en formato JSON.  
- Entidades contienen los campos mínimos (`id`, `nombre`, etc.).  
- IDs persistidos correctamente (`ownerId`, `petId`, `visitId`).  

---

## 🚀 Parte 2: Seguridad con OAuth2.0 (JWT) y Swagger

**Objetivo:** añadir seguridad con **OAuth2.0 usando JWT Bearer Token** (mediante Auth0) y documentar la API con Swagger/OpenAPI.  

### Configuración en Auth0

Antes de implementar la seguridad en el backend, deberás preparar la configuración en Auth0:  

1. **Registrarse en Auth0** (https://auth0.com).  
2. Crear una **API** en Auth0:  
   - Definir un **API Identifier (audience)** → será utilizado en el backend.  
   - Habilitar el uso de **JWTs**.  
3. Crear una **Application (Machine-to-Machine Application)** en Auth0:  
   - Obtener el **Client ID** y **Client Secret**.  
   - Asociar la aplicación con la API creada.  
4. Guardar los siguientes datos, que serán necesarios en tu configuración de Spring Boot y Postman:  
   - `auth0Domain` (ejemplo: `tu-dominio.eu.auth0.com`)  
   - `clientId`  
   - `clientSecret`  
   - `audience`  

👉 Consejo: Auth0 genera **Access Tokens en formato JWT**, que serán enviados como **Bearer Token** en cada request.  

---

### Actividades sugeridas (Parte 2)

1. Crear una clase de configuración `SecurityConfig` en Spring.  
2. Integrar **seguridad con OAuth2.0 (JWT Bearer Token vía Auth0)**.  
3. Definir qué endpoints requieren autenticación (ejemplo: `POST` protegidos, `GET` públicos o autenticados según tu diseño).  
4. Configurar manejo de errores → una request sin token o con token inválido debe devolver **401 Unauthorized**.  
5. Añadir documentación de la API con **Swagger/OpenAPI**.  
6. Probar nuevamente los endpoints con la colección de **Postman (con seguridad)**.  

---

## ✅ Tests con Postman (Parte 2)

Archivos incluidos:  

- `java-fundamentals-vetclinic-oauth2.postman_collection.json`  
- `java-fundamentals-vetclinic-local.postman_environment.json`  

Variables necesarias en el entorno:  

- `baseUrl`: URL del backend (ejemplo: `http://localhost:8080`)  
- `auth0Domain`: dominio de Auth0 (ejemplo: `tu-dominio.eu.auth0.com`)  
- `clientId`: Client ID de la aplicación en Auth0  
- `clientSecret`: Client Secret de la aplicación  
- `audience`: API Identifier configurado en Auth0  
- `accessToken`: (se genera automáticamente)  

### Ejecución

1. Importar la colección y el entorno en Postman.  
2. Seleccionar el entorno **Vet Clinic Monolith - Local**.  
3. Asegurar que el backend esté corriendo en `localhost:8080`.  
4. Ejecutar en orden:  
   - `POST /owners` → crea un Owner (requiere token válido).  
   - `POST /pets` → crea un Pet vinculado al `ownerId`.  
   - `POST /visits` → crea una Visit vinculada al `petId`.  
5. Verificar que una llamada sin token devuelva **401 Unauthorized**.  
6. Confirmar que con token válido los tests pasen correctamente.  

Validaciones que realiza Postman:  
- Autenticación correcta con Auth0 → `accessToken` incluido automáticamente.  
- Códigos de estado `200/201`.  
- Respuestas en formato JSON.  
- Contrato mínimo de las entidades (`id`, `nombre`, etc.).  
- Persistencia de IDs (`ownerId`, `petId`, `visitId`).  