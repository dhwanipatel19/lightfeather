FROM node:latest

ENV NODE_VERSION 18.6.0

#apk add --update nodejs npm
#apk add --update npm

WORKDIR /home/node
COPY . .

RUN npm install
ENTRYPOINT [ "npm", "start" ]