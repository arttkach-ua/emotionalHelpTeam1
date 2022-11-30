FROM openjdk:17-oracle
WORKDIR   /app

COPY build/libs/team1.emotional.help-0.0.1-SNAPSHOT.jar   ./team1.emotional.help-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","team1.emotional.help-0.0.1-SNAPSHOT.jar"]