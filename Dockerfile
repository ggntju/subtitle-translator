From openjdk:8
copy ./build/libs/subtitle-translator-0.0.1-SNAPSHOT.jar subtitle-translator-0.0.1-SNAPSHOT.jar
copy ./Credentials/translation-basic-266904-97cef68c84ea.json GOOGLE_APPLICATION_CREDENTIALS.json
ENV GOOGLE_APPLICATION_CREDENTIALS="GOOGLE_APPLICATION_CREDENTIALS.json"
CMD ["java", "-jar", "subtitle-translator-0.0.1-SNAPSHOT.jar"]
