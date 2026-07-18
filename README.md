# Tienda virtual de café (StarBU)

Sistema web de tienda de café en línea desarrollado como proyecto académico para el curso de Ingeniería de Software.

El proyecto tiene como objetivo demostrar la aplicación del patrón de diseño **Decorator (GoF)** en un problema real del dominio de cafeterías: la personalización dinámica de bebidas mediante ingredientes adicionales.

---

# 1. Descripción del proyecto

**Coffee Store Online** es una aplicación web que permite a los clientes seleccionar diferentes tipos de café, personalizar sus bebidas agregando ingredientes adicionales, visualizar el precio actualizado y realizar pedidos.

El sistema simula una cafetería moderna donde los usuarios pueden crear bebidas personalizadas combinando productos base con diferentes complementos:

- Leche adicional.
- Chocolate.
- Crema batida.
- Canela.
- Vainilla.
- Caramelo.
- Otros ingredientes disponibles.

La aplicación utiliza el patrón de diseño **Decorator** para agregar responsabilidades y costos adicionales a una bebida sin crear una clase diferente para cada combinación posible.

---

# 2. Problema identificado

Las cafeterías modernas permiten que los clientes personalicen sus bebidas agregando diferentes ingredientes.

Ejemplo:

- Café americano con leche.
- Café americano con leche y caramelo.
- Café americano con leche, caramelo y crema.
- Latte con chocolate y vainilla.

Una implementación tradicional podría crear una clase por cada combinación:

```text
CafeConLeche
CafeConLecheYCaramelo
CafeConLecheCarameloYCrema
LatteConChocolate
LatteConChocolateYVainilla
```

Este enfoque genera problemas:

- Exceso de clases.
- Código difícil de mantener.
- Baja escalabilidad.
- Dificultad para agregar nuevos ingredientes.
- Violación del principio Open/Closed de SOLID.

---

# 3. Justificación del patrón elegido

## Patrón Decorator (GoF)

El patrón Decorator permite añadir nuevas responsabilidades a un objeto dinámicamente sin modificar su estructura original.

En este proyecto:

- La bebida base representa un café simple.
- Los ingredientes adicionales funcionan como decoradores.
- Cada decorador modifica la descripción y el precio final.

Ejemplo:

```text
Espresso
   +
Leche
   +
Caramelo
   +
Crema
```

Resultado:

```text
Espresso con leche, caramelo y crema

Precio:
Precio base + ingredientes adicionales
```

Ventajas:

- Evita crear clases para cada combinación.
- Facilita agregar nuevos ingredientes.
- Mantiene el código extensible.
- Cumple el principio Open/Closed.

---

# 4. Objetivos del proyecto

## Objetivo general

Desarrollar una tienda de café online aplicando el patrón Decorator para gestionar la personalización dinámica de bebidas.

## Objetivos específicos

- Mostrar un catálogo de cafés.
- Visualizar detalles de productos.
- Personalizar bebidas.
- Calcular precios dinámicamente.
- Gestionar carrito de compras.
- Crear pedidos.
- Aplicar principios SOLID.

---

# 5. Tecnologías utilizadas

## Frontend

- React
- TypeScript
- Tailwind CSS

## Backend

- Node.js
- Express
- TypeScript

## Base de datos

- PostgreSQL

## Herramientas

- Git
- GitHub
- Visual Studio Code
- Postman

---

# 6. Estructura del proyecto

```text
coffee-store-online/

├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   │   └── styles/
│   └── package.json
│
├── backend/
│   ├── src/
│   │
│   ├── domain/
│   │   └── coffee/
│   │       ├── Beverage.ts
│   │       ├── Espresso.ts
│   │       ├── Latte.ts
│   │       ├── BeverageDecorator.ts
│   │       ├── MilkDecorator.ts
│   │       ├── ChocolateDecorator.ts
│   │       └── CaramelDecorator.ts
│   │
│   ├── controllers/
│   ├── services/
│   ├── repositories/
│   └── routes/
│
├── database/
│
├── docs/
│   └── uml/
│
├── README.md
└── package.json
```

---

# 7. Funcionamiento del patrón Decorator

## Paso 1: Selección del café base

El usuario selecciona:

```text
Espresso

Precio:
$3.00
```

---

## Paso 2: Selección de ingredientes

El cliente agrega:

```text
+ Leche ($0.50)
+ Caramelo ($0.70)
+ Crema ($0.80)
```

---

## Paso 3: Construcción de decoradores

Internamente se genera:

```text
CreamDecorator(
    CaramelDecorator(
        MilkDecorator(
            Espresso
        )
    )
)
```

---

## Paso 4: Cálculo del precio

Cada decorador agrega su costo:

```text
Espresso       $3.00
Leche          $0.50
Caramelo       $0.70
Crema          $0.80

Total          $5.00
```

---

# 8. Clases principales

## Beverage

Interfaz principal del patrón.

Responsabilidades:

- Definir comportamiento común.
- Obtener descripción.
- Obtener costo.

Métodos:

```typescript
getDescription()
getCost()
```

---

## Espresso

Clase concreta de bebida.

Responsabilidad:

Representar un café básico.

Ejemplo:

```text
Descripción:
Espresso

Precio:
3.00
```

---

## Latte

Clase concreta de bebida.

Responsabilidad:

Representar un café latte.

---

## BeverageDecorator

Clase abstracta decoradora.

Responsabilidades:

- Mantener referencia al objeto decorado.
- Delegar comportamiento.

---

## MilkDecorator

Responsabilidad:

Agregar leche a una bebida.

Modifica:

- Descripción.
- Precio.

---

## ChocolateDecorator

Responsabilidad:

Agregar chocolate.

---

## CaramelDecorator

Responsabilidad:

Agregar caramelo.

---

# 9. Principios SOLID aplicados

## Single Responsibility Principle

Cada clase tiene una única responsabilidad.

Ejemplo:

- Espresso administra un café.
- MilkDecorator administra leche.

---

## Open/Closed Principle

El sistema permite agregar ingredientes nuevos sin modificar clases existentes.

Ejemplo:

Crear:

```text
VanillaDecorator
```

sin cambiar Espresso.

---

## Liskov Substitution Principle

Todos los decoradores pueden utilizarse como una bebida normal.

---

## Interface Segregation Principle

Las interfaces contienen únicamente métodos necesarios.

---

## Dependency Inversion Principle

Las dependencias se realizan mediante abstracciones.

---

# 10. Flujo del sistema

```text
Usuario
  |
  |
Selecciona café
  |
  |
Visualiza detalle
  |
  |
Agrega ingredientes
  |
  |
Se crean decoradores
  |
  |
Calcula precio final
  |
  |
Agrega al carrito
  |
  |
Confirma pedido
  |
  |
Sistema registra compra
```

---

# 11. Funcionalidades principales

## Catálogo de cafés

Permite:

- Ver productos disponibles.
- Consultar precios.
- Ver información del café.

---

## Personalización

Permite:

- Agregar ingredientes.
- Crear combinaciones dinámicas.
- Actualizar precios.

---

## Carrito

Permite:

- Agregar bebidas.
- Modificar cantidades.
- Calcular total.

---

## Pedidos

Permite:

- Confirmar compra.
- Registrar pedido.
- Consultar estado.

---

# 12. Instalación

## Clonar repositorio

```bash
git clone https://github.com/usuario/coffee-store-online.git
```

---

## Backend

```bash
cd backend

npm install

npm run dev
```

---

## Frontend

```bash
cd frontend

npm install

npm start
```

---

# 13. Conventional Commits

Ejemplos utilizados durante el desarrollo:

```text
feat: create coffee catalog module

feat: implement decorator pattern

feat: add beverage decorators

feat: create shopping cart

feat: implement order module

fix: correct beverage price calculation

refactor: improve domain structure

docs: update README documentation

test: add decorator tests

style: improve frontend design
```

---

# 14. Funcionalidades adicionales

## Favoritos

Permitir guardar bebidas personalizadas.

---

## Historial de pedidos

Mostrar compras anteriores.

---

## Sistema de promociones

Aplicar descuentos según reglas.

---

## Calificación de productos

Permitir valorar cafés.

---

## Estado del pedido

Ejemplo:

```text
Preparando
↓
En camino
↓
Entregado
```
