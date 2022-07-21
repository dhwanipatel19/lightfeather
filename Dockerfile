FROM amazonlinux:2
FROM openjdk:11
RUN groupadd -g 1000 lightfeather && \
    useradd -g 1000 lightfeather -g lightfeather

USER lightfeather

COPY --chown=lightfeather:lightfeather . /home/lightfeather/managementsystem
RUN cd /home/lightfeather/managementsystem
WORKDIR /home/lightfeather/managementsystem

# changing entry point to directly work with gradlew as container is acting up with RestControllerAdvice for Exception Handling properly
#ENTRYPOINT ["java","-jar","build/libs/managementstyle-0.0.1-SNAPSHOT.jar"] 
ENTRYPOINT ["./gradlew", "bootRun"]