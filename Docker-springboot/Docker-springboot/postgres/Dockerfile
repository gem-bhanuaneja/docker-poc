FROM postgres:latest
#setting environment properties to connect to db running in container
ENV POSTGRES_DB=dockerDB
ENV POSTGRES_USER=car
ENV POSTGRES_PASSWORD=1234
# Expose the default PostgreSQL port
EXPOSE 5432
# Start PostgreSQL server
CMD ["postgres"]