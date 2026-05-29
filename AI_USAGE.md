# AI Usage

Date: 2026-05-04  
Tool: ChatGPT  
Task: Support with formatting of API specification  
Purpose: Improve structure and readability  
Result: Adjusted layout and organization of endpoints  
Acceptance: Accepted with minor edits  
Files: API_specification.md  

---

Date: 2026-05-04  
Tool: ChatGPT  
Task: Support with formatting of database design  
Purpose: Improve clarity of schema representation  
Result: Structured tables and relationships more clearly  
Acceptance: Accepted  
Files: DB_Design.md  

---

Date: 2026-05-05  
Tool: Claude  
Task: Support with generating request and response bodies of API specification  
Purpose: Add more details to api specification 
Result: Formatted and matching request/response bodies according to db design  
Acceptance: Accepted
Files: API_specification.md

---

Date: 2026-05-26  
Tool: Claude  
Task: Support with Spring Boot backend
Purpose: Help review and finish hotels, rooms and availability APIs  
Result: implemented backend, AI supported with review, hotelId fix and backlog updates  
Acceptance: Accepted
Files: src/main/java/com/company/, BACKLOG.md

---

Date: 2026-05-26
Tool: Claude
Task: M2 Submission cleanup
Purpose: README, backlog and stub string responses
Result: Updated docs, cleaned config comments
Acceptance: Accepted
Files: README.md, BACKLOG.md, application.properties

---

Date: 2026-05-28
Tool: Claude Code
Task: Text generation for frontend components
Purpose: Generate descriptive labels, headings, and button texts for website details, room detail page and availability check UI
Result: Created text content for all static website pages, detail grid labels, section headings, button labels (e.g. "View Details", "Check Availability"), and status messages
Acceptance: Accepted with minor adjustments
Files: frontend/src/views/HomePage.vue, frontend/src/views/AboutPage.vue, frontend/src/views/ImprintPage.vue, frontend/src/views/RoomDetailPage.vue, frontend/src/components/molecules/RoomCard.vue, frontend/src/components/molecules/AvailabilityResult.vue

---

Date: 2026-05-29
Tool: Claude Code
Task: Docker environment setup
Purpose: Create Docker and docker-compose configuration for running the backend with MySQL
Result: Generated Dockerfile and docker-compose.yml with service definitions for the Spring Boot backend and MySQL database, adjusted pom.xml for containerized builds
Acceptance: Accepted
Files: Dockerfile, docker-compose.yml, pom.xml

---

Date: 2026-05-29
Tool: Claude Code
Task: Frontend styling for room detail page
Purpose: Design a visually distinct room detail page with hero image, detail grid, amenities section, and availability check
Result: Generated CSS styles for layout, responsive detail grid, hero image wrapper, typography, and spacing
Acceptance: Accepted with minor padding adjustments
Files: frontend/src/views/RoomDetailPage.vue, frontend/src/components/organisms/AppHeader.vue, frontend/src/components/templates/PageLayout.vue

---

Date: 2026-05-29
Tool: Claude Code
Task: Placeholder image generation for room images
Purpose: Provide sample images for development since no real images exist yet
Result: Downloaded 8 room placeholder images from picsum.photos, configured Vite proxy to serve backend static resources
Acceptance: Accepted
Files: src/main/resources/static/images/rooms/1-8.jpg, frontend/vite.config.ts
