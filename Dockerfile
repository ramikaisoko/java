FROM tomcat:latest
LABEL maintainer="deepak@softwareyoga.com"

COPY */board-app-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
#ADD
#EXPOSE 8080
CMD ["catalina.sh", "run"]