# Boutique Hotel Technikum – Booking App

Spring Boot backend and Ionic/Vue frontend for the hotel booking app (AWT 2026).

## Quick start (local docker environment)

```
docker compose up -d --build
```

The app then available at: `http://localhost:3000`


## Backend

Base URL: `http://localhost:8081/api/v1`

Swagger (API Endpoint Testing): `http://localhost:8081/api/v1/swagger-ui/index.html`

### Database – which one to use?

The project supports two databases. **Only one is active at a time**, depending on how you start the app.

| | H2 (default) | MySQL |
|---|--------------|-------|
| **When to use** | Local development, quick testing | When MySQL is required (project spec, demo) |
| **Config file** | `application.properties` | `application-mysql.properties` |
| **Data persistence** | In-memory – lost on restart | Stored in MySQL server |
| **How to start** | `mvn spring-boot:run` | `mvn spring-boot:run "-Dspring-boot.run.profiles=mysql"` |

On every startup (both databases): Hibernate creates the tables from the JPA entities, then `data.sql` inserts seed data (hotel, 8 rooms, sample bookings).

### Run with H2 (default)

`mvn spring-boot:run` **without** a profile always uses H2.

```bash
mvn spring-boot:run
```

Check the startup log for: `jdbc:h2:mem:hotelbookingdb`

Optional – browse data in the H2 console:

- URL: `http://localhost:8081/h2-console`
- JDBC URL: `jdbc:h2:mem:hotelbookingdb`
- User: `sa`
- Password: *(empty)*

### Run with MySQL

`mvn spring-boot:run` alone does **not** use MySQL. You must activate the **`mysql`** profile.

1. Start MySQL Server (port 3306).
2. Set the root password in your shell *(do not commit it to Git)*:

```powershell
$env:MYSQL_PASSWORD="your-root-password"
```

If root has no password, leave `MYSQL_PASSWORD` unset.

3. Stop any app already running on port 8081, then start:

```powershell
mvn spring-boot:run "-Dspring-boot.run.profiles=mysql"
```

4. Confirm in the startup log: `jdbc:mysql://localhost:3306/hotel_booking` *(not `jdbc:h2`)*.

The database `hotel_booking` is created automatically if it does not exist. Same seed data as H2.

### Run with Docker (recommended for demo)

Starts both MySQL and the backend in containers — no local Java or MySQL needed.

```bash
docker compose up --build
```

Backend available at `http://localhost:8081/api/v1`. MySQL data is persisted in a Docker volume (`mysql-data`).

To stop and remove containers:

```bash
docker compose down
```

To also remove the database volume:

```bash
docker compose down -v
```

## Frontend

```bash
cd frontend
npm install
npm run dev
```

### Component structure (Atomic Design)

Components are organized following [Atomic Design](https://bradfrost.com/blog/post/atomic-web-design/) principles:

| Layer | Path | What belongs here | Examples |
|---|---|---|---|
| **Atoms** | `components/atoms/` | Smallest UI building blocks — single-purpose, no business logic | `AppButton`, `SectionTitle`, `FeatureIcon`, `RoomImage` |
| **Molecules** | `components/molecules/` | Combine multiple atoms into a functional unit | `RoomCard`, `DateRangePicker`, `PaginationButtons` |
| **Organisms** | `components/organisms/` | Complex, standalone sections composed of molecules and atoms | `AppHeader`, `AppMenu` |
| **Templates** | `components/templates/` | Page-level layout wrappers that define structure but not content | `PageLayout` |
| **Views** | `views/` | Route-level pages that compose templates and organisms with actual data | `HomePage`, `RoomsPage`, `RoomDetailPage` |
