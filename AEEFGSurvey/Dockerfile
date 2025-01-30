# Base Image
FROM nginx:latest

# Set environment variables
ENV APP_HOME /usr/share/nginx/html

# Create necessary directories and set permissions
RUN mkdir -p /var/cache/nginx \
    && mkdir -p /var/run/nginx \
    && mkdir -p /var/log/nginx \
    && mkdir -p $APP_HOME/Survey \
    && mkdir -p $APP_HOME/Dashboard

# Set proper ownership
RUN chown -R nginx:nginx /var/cache/nginx \
    && chown -R nginx:nginx /var/run/nginx \
    && chown -R nginx:nginx /var/log/nginx \
    && chown -R nginx:nginx $APP_HOME \
    && chmod -R 755 /var/cache/nginx \
    && chmod -R 755 /var/run/nginx \
    && chmod -R 755 /var/log/nginx \
    && chmod -R 755 $APP_HOME

# Copy application files into the Nginx HTML directory
COPY ./Survey $APP_HOME/Survey/
COPY ./Dashboard $APP_HOME/Dashboard/

# Fix permissions after copy
RUN chown -R nginx:nginx $APP_HOME

# Copy the custom Nginx configuration
COPY nginx.conf /etc/nginx/nginx.conf

# Create pid file and set ownership
RUN touch /var/run/nginx.pid \
    && chown -R nginx:nginx /var/run/nginx.pid

# Switch to non-root user
USER nginx

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]