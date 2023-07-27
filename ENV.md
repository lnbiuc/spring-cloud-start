## MySQL
```shell
docker run -d --name mysql -p 3306:3306 --restart always --memory 1G --net docker-net --ip 192.168.0.2 -e MYSQL_ROOT_PASSWORD=mysqlforserver@date0522 mysql
```

## Redis
```shell
docker run -d --name d-redis -p 6379:6379 --restart always --memory="500m" --network docker-net --ip 192.168.0.3 -e REDIS_MAXMEMORY=500mb -e REDIS_MAXMEMORY_POLICY=allkeys-lru redis redis-server /usr/local/etc/redis/redis.conf
```

```
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection(
  "jdbc:mysql://aws.connect.psdb.cloud/cloud?sslMode=VERIFY_IDENTITY",
  "hr9elvtij6iighwaq81q",
  "pscale_pw_D92zUdnumJcPyL9aXI7wdu4BPViFniPa735h4kPyqA");

```