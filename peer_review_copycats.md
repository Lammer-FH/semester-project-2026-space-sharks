# Peer Review — Milestone 1: Team _Copycats_

Reviewed by: Team _Space Sharks_

---


## API Specification
Positiv:
- Endpoint-Übersichtstabelle am Anfang
- Konsistente Plural-Paths (/rooms, /bookings, /guests)
- Request + Response Bodies mit JSON-Beispielen bei jedem Endpoint
- Fehler-Responses dokumentiert (400, 404, 409, 401, 403) mit einheitlichem Error-Format
- Auth-Konzept mit JWT durchdacht (Login, Bearer Token)
- Pagination bei Rooms (page/size)

Fehlt:
- Kein pricePerNight in Room-Responses — wichtig für Zimmerauswahl
- Kein maxOccupants in Room-Responses
- Kein totalPrice in Booking-Response — wäre für US-5 Confirmation praktisch

## ER-Diagram / DB Design
Positiv:
- password_hash in guests — passt zum Auth/Login
- guest_id in bookings nullable — Buchung ohne Account möglich (US-4)
- room_extras Join-Table für M:N korrekt
- status als ENUM statt boolean -> besser erweiterbar

Fehlt:
- Kein price_per_night in rooms
- Kein max_occupants in rooms

## Paper Prototype
Positiv:
- Alle Screens abgedeckt: Landing Page, About, Imprint (US-1), Zimmer mit max 5 + load more (US-2), Date-Auswahl + Verfügbarkeit (US-3), Booking-Formular mit allen Feldern + Booking Overview (US-4), Confirmation mit Details + Directions + Contact (US-5)
- Nicht verfügbare Zimmer ausgegraut — gute Idee wenn man gewünschten Zeitraum schon angibt 
- Room Details mit Bildergalerie
- "print needs to fit A4" beruecksichtigt (US-5 DoD)
- Desktop-Variante auf Seite 2

Kleinigkeit:
- User-Flow zwischen Screens könnte klarer sein (Pfeile/Verbindungen)

## Backlog / Kanban
- ist vorhanden in Github Projects, aber Issues fehlen noch im Backlog
