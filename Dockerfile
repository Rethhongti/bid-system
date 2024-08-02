FROM bellsoft/liberica-runtime-container:jdk-17-musl

COPY target/bid-system-0.0.1-SNAPSHOT.jar bid-system-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "bid-system-0.0.1-SNAPSHOT.jar"]