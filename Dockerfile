FROM java:8
WORKDIR /
ADD ./build/libs/nastushenka*.jar Nastushenka.jar
EXPOSE 8080
CMD java -jar Nastushenka.jar
