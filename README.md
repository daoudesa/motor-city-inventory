# Motor City Performance Garage — Inventory Management

A Spring Boot web application for managing the parts and products inventory of a
specialty automotive performance shop. Parts are tracked individually, assembled
into products, and guarded by validation rules that keep stock levels consistent
as items are bought and sold.

## What it does

- **Parts inventory** — add, update, delete, and search parts. Every part is
  either *inhouse* (manufactured on site, tracked by machine ID) or *outsourced*
  (supplied by a vendor, tracked by company name). Both are persisted through a
  single-table inheritance hierarchy with a discriminator column.
- **Products** — group parts into sellable products. A product's associated parts
  are managed through a many-to-many join table.
- **Min/max inventory tracking** — each part carries a minimum and maximum stock
  level. Validation rejects any inventory value that falls outside that range, so
  stock can't silently drift out of bounds.
- **Buy Now** — decrements product inventory at purchase time, but only when the
  underlying parts can cover it.
- **Custom validation** — a constraint validator blocks a product's inventory
  from being raised beyond what its associated parts can supply
  (*"There aren't enough parts in inventory!"*), and a delete validator prevents
  removing a part that is still attached to a product.
- **Search and filter** — keyword filtering across both the parts and products
  tables.

## Stack

| | |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 2.6.6 (Web, Data JPA, Validation) |
| Views | Thymeleaf + Bootstrap 5 |
| Database | H2 (file-backed, auto-created on first run) |
| Build | Maven (wrapper included) |
| Tests | JUnit 5 |

## Running it

No database setup is required — H2 creates the schema on first launch and
`BootStrapData` seeds sample parts and products.

```bash
git clone https://github.com/cirbit/motor-city-inventory.git
cd motor-city-inventory
./mvnw spring-boot:run
```

Then open **http://localhost:8080/mainscreen**.

On Windows, use `mvnw.cmd spring-boot:run`.

### Tests

```bash
./mvnw test
```

Covers the domain model (parts, products, inheritance-specific fields) plus the
repository and service layers.

### H2 console

The database console is enabled at **http://localhost:8080/h2-console**.
Connect with JDBC URL `jdbc:h2:file:~/spring-boot-h2-db102`, user `sa`, and an
empty password.

## Project layout

```
src/main/java/com/example/demo/
├── bootstrap/      # seeds sample inventory at startup
├── controllers/    # main screen, part and product forms
├── domain/         # Part (abstract), InhousePart, OutsourcedPart, Product
├── repositories/   # Spring Data JPA repositories
├── service/        # service interfaces and implementations
└── validators/     # custom constraint validators
```
