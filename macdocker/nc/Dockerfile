version: '3'

services:
  db:
    image: mariadb
    container_name: mysql
    command: --transaction-isolation=READ-COMMITTED --binlog-format=ROW
    restart: always
    volumes:
      - /home/roy/nc/mysql:/var/lib/mysql
    environment:
      - MYSQL_ROOT_PASSWORD=nc123456
    env_file:
      - db.env

  redis:
    image: redis
    restart: always
    container_name: redis
    volumes:
          - /home/roy/nc/redis:/data

  app:
    build: ./app
    restart: always
    ports:
      - 8080:80
    container_name: nc
    volumes:
      - /home/roy/nc/nc:/var/www/html
      - /home/roy/mydisk:/mydisk
    environment:
      - MYSQL_HOST=db
      - TZ=Asia/Shanghai
    env_file:
      - db.env
    depends_on:
      - db
      - redis

  cron:
    build: ./app
    restart: always
    container_name: nc-cron
    volumes:
      - /home/roy/nc/nc:/var/www/html
    entrypoint: /cron.sh
    depends_on:
      - db
      - redis
