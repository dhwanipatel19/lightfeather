FROM node:latest

ENV NODE_VERSION 18.6.0

WORKDIR /home/node
COPY . .

RUN npm install
ENTRYPOINT [ "npm", "start" ]