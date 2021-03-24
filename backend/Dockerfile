# Creating .jar file
FROM gradle:6.8-jdk11-openj9 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME
  
COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src
    
RUN gradle build -x test || return 0
COPY . .
RUN gradle clean build -x test 
    
# Actual container
FROM adoptopenjdk/openjdk11:alpine-jre
ENV ARTIFACT_NAME=fujitsu-backend-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
    
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
    
EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}