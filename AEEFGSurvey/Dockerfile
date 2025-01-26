# Base Image
FROM nginx:latest

# Set environment variables for flexibility
ENV APP_HOME /usr/share/nginx/html

# Copy application files into the Nginx HTML directory
COPY ./Survey $APP_HOME/Survey
COPY ./Dashboard $APP_HOME/Dashboard

# Copy the custom Nginx configuration
COPY nginx.conf /etc/nginx/nginx.conf

# Set file permissions (if needed)
RUN chmod -R 755 $APP_HOME

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
