FROM openjdk:17

RUN mkdir /java_backend

RUN chmod 777 java_backend
WORKDIR /java_backend

# Copy code into the image
COPY patient-0.0.1-SNAPSHOT.jar /java_backend/
# COPY /var/jenkins/workspace/alcon-ioldt-patient-api_poc/target/patient-0.0.1-SNAPSHOT.jar /java_backend/

# Set the working directory
# WORKDIR /java_backend

# Run the code
CMD ["java", "-jar", "patient-0.0.1-SNAPSHOT.jar"]
