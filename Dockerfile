FROM maven:3.8.3-jdk-8 as build
LABEL author="kiran"
RUN git clone https://github.com/wakaleo/game-of-life.git && \
    cd game-of-life && \
    mvn clean install "-DskipTests"

FROM tomcat:8
LABEL author="kiran"
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /game-of-life/gameoflife-web/target/gameoflife.war /usr/local/tomcat/webapps/gameoflife.war
EXPOSE 8080
CMD ["catalina.sh", "run"]