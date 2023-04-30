FROM openjdk:20

RUN mkdir /app

COPY  /out/production/ecommerceApp/ /app

WORKDIR /app

CMD java Main