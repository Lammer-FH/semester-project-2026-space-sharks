# --- Stage 1: Build the Vue app ---
FROM node:lts-alpine AS build-stage
WORKDIR /app

# Install dependencies
COPY package*.json ./
RUN npm install

# Copy source and build
COPY . .
RUN npm run build

# --- Stage 2: Serve with Nginx ---
FROM nginx:stable-alpine AS production-stage

# Remove default Nginx page
RUN rm -rf /usr/share/nginx/html/*

# Copy built files
COPY --from=build-stage /app/dist /usr/share/nginx/html

# Expose port
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
