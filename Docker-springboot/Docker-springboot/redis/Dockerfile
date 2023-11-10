# Use the official Redis image from Docker Hub
FROM redis:latest

COPY redis.conf /usr/local/etc/redis/redis.conf
# Expose the default Redis port
EXPOSE 6379

# Start Redis server
CMD ["redis-server","/usr/local/etc/redis/redis.conf"]