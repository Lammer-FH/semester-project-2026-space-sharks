# AI Usage

This document tracks all meaningful uses of AI tools throughout the project, as required by the course policy.

## Milestone 1 — Planning & Specification

### API Specification Formatting
| | |
|---|---|
| **Date** | 2026-05-04 |
| **Tool** | ChatGPT |
| **Purpose** | Improve structure and readability of API specification |
| **Result** | Adjusted layout and organization of endpoints |
| **Acceptance** | Accepted with minor edits |
| **Files** | `API_specification.md` |

### Database Design Formatting
| | |
|---|---|
| **Date** | 2026-05-04 |
| **Tool** | ChatGPT |
| **Purpose** | Improve clarity of schema representation |
| **Result** | Structured tables and relationships more clearly |
| **Acceptance** | Accepted |
| **Files** | `DB_Design.md` |

### API Request/Response Body Generation
| | |
|---|---|
| **Date** | 2026-05-05 |
| **Tool** | Claude |
| **Purpose** | Add detailed request and response bodies to API specification |
| **Result** | Formatted and matching request/response bodies according to DB design |
| **Acceptance** | Accepted |
| **Files** | `API_specification.md` |

## Milestone 2 — Backend & Infrastructure

### Spring Boot Backend Support
| | |
|---|---|
| **Date** | 2026-05-26 |
| **Tool** | Claude |
| **Purpose** | Help review and finish hotels, rooms, and availability APIs |
| **Result** | Implemented backend; AI supported with review, hotelId fix, and backlog updates |
| **Acceptance** | Accepted |
| **Files** | `src/main/java/com/company/`, `BACKLOG.md` |

### M2 Submission Cleanup
| | |
|---|---|
| **Date** | 2026-05-26 |
| **Tool** | Claude |
| **Purpose** | Clean up README, backlog, and stub string responses |
| **Result** | Updated docs, cleaned config comments |
| **Acceptance** | Accepted |
| **Files** | `README.md`, `BACKLOG.md`, `application.properties` |

### Docker Environment Setup
| | |
|---|---|
| **Date** | 2026-05-29 |
| **Tool** | Claude Code |
| **Purpose** | Create Docker and docker-compose configuration for running the backend with MySQL |
| **Result** | Generated Dockerfile and docker-compose.yml with service definitions for Spring Boot and MySQL, adjusted pom.xml for containerized builds |
| **Acceptance** | Accepted |
| **Files** | `Dockerfile`, `docker-compose.yml`, `pom.xml` |

### Placeholder Image Generation
| | |
|---|---|
| **Date** | 2026-05-29 |
| **Tool** | Claude Code |
| **Purpose** | Provide sample room images for development since no real images exist yet |
| **Result** | Downloaded 8 room placeholder images from picsum.photos, configured Vite proxy to serve backend static resources |
| **Acceptance** | Accepted |
| **Files** | `src/main/resources/static/images/rooms/1-8.jpg`, `frontend/vite.config.ts` |

## Frontend — US-1 to US-3

### Text Generation for Frontend Components
| | |
|---|---|
| **Date** | 2026-05-28 |
| **Tool** | Claude Code |
| **Purpose** | Generate descriptive labels, headings, and button texts for static pages and room detail UI |
| **Result** | Created text content for all static website pages, detail grid labels, section headings, button labels (e.g. "View Details", "Check Availability"), and status messages |
| **Acceptance** | Accepted with minor adjustments |
| **Files** | `frontend/src/views/HomePage.vue`, `AboutPage.vue`, `ImprintPage.vue`, `RoomDetailPage.vue`, `frontend/src/components/molecules/RoomCard.vue`, `AvailabilityResult.vue` |

### US-3 Implementation Support (Room Detail & Availability)
| | |
|---|---|
| **Date** | 2026-05-29 |
| **Tool** | Claude Code |
| **Purpose** | Accelerate implementation of room detail page, date picker integration, and availability check flow |
| **Result** | AI generated component scaffolding and Pinia store logic based on my design decisions (step-based flow, back navigation, detail grid layout). I reviewed all output, tested the flow, identified and fixed Ionic lifecycle issues (`onIonViewWillEnter` vs `onUnmounted`), and adjusted UX details (button labels, padding, layout) |
| **Acceptance** | Accepted with multiple iterations based on manual testing |
| **Files** | `frontend/src/views/RoomDetailPage.vue`, `frontend/src/components/molecules/DateRangePicker.vue`, `AvailabilityResult.vue`, `frontend/src/store/useBookingStore.ts`, `frontend/src/components/organisms/AppHeader.vue`, `frontend/src/components/templates/PageLayout.vue` |

### Frontend Styling (Room Detail, Booking Flow, Confirmation)
| | |
|---|---|
| **Date** | 2026-05-29 |
| **Tool** | Claude Code |
| **Purpose** | Generate CSS styling for room details, availability result, booking form, review step, and confirmation page |
| **Result** | Generated CSS styles for layout, responsive grids, availability result with gradient design, form validation error styles, booking review card, and confirmation page |
| **Acceptance** | Accepted with minor adjustments |
| **Files** | `frontend/src/views/RoomDetailPage.vue`, `BookingConfirmationPage.vue`, `frontend/src/components/molecules/AvailabilityResult.vue`, `BookingForm.vue`, `BookingReview.vue`, `frontend/src/components/organisms/AppHeader.vue`, `frontend/src/components/templates/PageLayout.vue` |

## Frontend — US-4 & US-5

### US-4 Implementation Support (Booking Flow)
| | |
|---|---|
| **Date** | 2026-06-08 |
| **Tool** | Claude Code |
| **Purpose** | Implement booking form with guest validation, review step, and confirmation page |
| **Result** | AI generated BookingForm, BookingReview, and BookingConfirmationPage components, extended useBookingStore with step management and `submitBooking` action. I defined the user flow (availability → form → review → confirmation), specified validation behavior (errors on submit, not disabled button), requested confirm email field, and debugged backend guest creation issue (guest was `null` in response) |
| **Acceptance** | Accepted after several review-fix cycles |
| **Files** | `frontend/src/components/molecules/BookingForm.vue`, `BookingReview.vue`, `frontend/src/views/BookingConfirmationPage.vue`, `frontend/src/store/useBookingStore.ts`, `frontend/src/router/index.ts` |

### US-5 Implementation Support (Extended Booking Confirmation)
| | |
|---|---|
| **Date** | 2026-06-08 |
| **Tool** | Claude Code |
| **Purpose** | Extend confirmation page with full room details, directions, contact info, and print support |
| **Result** | AI generated extended confirmation layout with OpenStreetMap embed, transport options, contact section, and print CSS. I reviewed the output and triggered a refactoring to extract RoomSummary as a reusable component to reduce duplication across RoomCard and BookingConfirmationPage |
| **Acceptance** | Accepted with adjustments |
| **Files** | `frontend/src/views/BookingConfirmationPage.vue`, `frontend/src/components/molecules/RoomSummary.vue`, `RoomCard.vue`, `frontend/src/theme/variables.css` |

### Backend Bugfix — Guest Not Created During Booking
| | |
|---|---|
| **Date** | 2026-06-08 |
| **Tool** | Claude Code |
| **Purpose** | Fix null guest in booking response when guest does not exist yet |
| **Result** | AI identified the issue in BookingService (missing guest creation in else-branch) and added `createAndReturnGuest` method to GuestService. I verified the fix by testing the full booking flow |
| **Acceptance** | Accepted |
| **Files** | `src/main/java/com/company/service/BookingService.java`, `GuestService.java` |

### Component Reuse Analysis and Refactoring
| | |
|---|---|
| **Date** | 2026-06-08 |
| **Tool** | Claude Code |
| **Purpose** | Improve Atomic Design structure by identifying and eliminating duplicated component patterns |
| **Result** | AI analyzed all frontend components and identified duplicated room display logic. Extracted RoomSummary molecule with slot support, refactored RoomCard to compose RoomSummary, replaced duplicated room block in BookingConfirmationPage. I initiated this refactoring based on peer review feedback about component structure |
| **Acceptance** | Accepted |
| **Files** | `frontend/src/components/molecules/RoomSummary.vue`, `RoomCard.vue`, `frontend/src/views/BookingConfirmationPage.vue` |
