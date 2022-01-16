FROM java:8

COPY *.jar /Distribute.jar

CMD ["--server.port=8082"]

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/Distribute.jar"]