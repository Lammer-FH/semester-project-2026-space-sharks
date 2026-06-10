# frontend/Dockerfile (dev environment)
FROM node:lts-krypton

WORKDIR /app

# Install deps
COPY package*.json ./
RUN npm clean-install


EXPOSE 5173

# Start project
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]