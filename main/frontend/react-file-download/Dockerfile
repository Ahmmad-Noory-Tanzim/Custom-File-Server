# -------- Stage 1: Build React app --------
FROM node:22 AS build
WORKDIR /app

# Copy package.json and package-lock.json first for caching
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the source code
COPY . .

# Build the app
RUN npm run build




# -------- Stage 2: Serve with Nginx --------
FROM nginx:alpine

# Copy React build to Nginx html folder
COPY --from=build /app/dist /usr/share/nginx/html

# Remove default config
RUN rm /etc/nginx/conf.d/default.conf

# Copy custom Nginx config if needed
COPY nginx/default.conf /etc/nginx/conf.d/default.conf
