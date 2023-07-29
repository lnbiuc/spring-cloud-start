## Network
```shell
docker network create --subnet 192.168.0.0/16 --gateway 192.168.0.1 docker-net
```

## MySQL
```shell
docker run -d --name mysql -p 3306:3306 --restart always --memory 1G --net docker-net --ip 192.168.0.2 -e MYSQL_ROOT_PASSWORD=mysqlforserver@date0522 mysql:8.0.25
```

## Redis
```shell
docker run -d --name d-redis -p 6379:6379 --restart always --memory="500m" --network docker-net --ip 192.168.0.3 -e REDIS_MAXMEMORY=500mb -e REDIS_MAXMEMORY_POLICY=allkeys-lru redis redis-server /usr/local/etc/redis/redis.conf
```

## RabbitMQ
```shell
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 --restart always --network docker-net --ip 192.168.0.4 --memory="500m" rabbitmq:3.13.0-beta.2-management-alpine
```

## zipkin
```shell
docker run -d --name zipkin -p 9411:9411 --restart always --network docker-net --ip 192.168.0.5 --memory="500m" openzipkin/zipkin
```
## nacos
```shell
docker run -d --name nacos -p 8848:8848 --restart always --network docker-net --ip 192.168.0.6 --memory="500m" nacos/nacos-server
```