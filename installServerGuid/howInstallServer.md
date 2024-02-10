## Steps for RedOs


# Install psql
https://redos.red-soft.ru/base/server-configuring/dbms/install-postgresql/
    - create postgres user
    - fix remote connect to postgres
    - restart postgres
```
dnf install postgresql15-server -y
postgresql-15-setup initdb
systemctl enable postgresql-15.service --now
systemctl status postgresql-15.service

su - postgres
psql
ALTER USER postgres WITH ENCRYPTED PASSWORD 'yourpassword';
create database dvdrental;
create user aqa with password 'Toster2023';
grant select on all tables in schema public to aqa;
grant execute on all functions in schema public to aqa;
GRANT pg_read_all_data TO aqa;
exit
exit
nano /var/lib/pgsql/15/data/postgresql.conf -> # listen_addresses = 'localhost' -> listen_addresses = '*' 
nano /var/lib/pgsql/15/data/pg_hba.conf + host all all 0.0.0.0/0 md5
systemctl restart postgresql-15.service

```


GRANT SELECT ON ALL TABLES IN SCHEMA public TO user;
    Upper grand is needed for non-administrative user so that the DB is not broken and it does not have to be deployed from scratch.

download and load sample database
https://disk.yandex.ru/d/KI1tMlZlG7ZtXQ
https://www.postgresqltutorial.com/postgresql-getting-started/load-postgresql-sample-database/
https://www.postgresqltutorial.com/postgresql-getting-started/postgresql-sample-database/
https://www.pgadmin.org/download/pgadmin-4-apt/

Sample of database will be restored with PgAdmin tool in DB dvdretal.

# Install docker
https://redos.red-soft.ru/base/arm/arm-other/docker-install/

# Run selenoid & selenoid-ui in docker
sudo docker pull selenoid/chrome:116.0
sudo docker pull aerokube/selenoid
sudo docker pull aerokube/selenoid-ui

it's dont work :(
docker run -d --name selenoid -p 4444:4444 -v //var/run/docker.sock:/var/run/docker.sock -v /home/slava/selenoid:/etc/selenoid:ro aerokube/selenoid:latest

it's work (run in catalog with directory config/browsers.json [browsers.json](browsers.json))
wget https://github.com/aerokube/selenoid/releases/download/1.11.0/selenoid_linux_amd64
sudo chmod +x selenoid_linux_amd64

docker run -d --name selenoid-ui -p 8080:8080 aerokube/selenoid-ui --selenoid-uri http://localhost:4444

# Run wireMock in docker
docker run --it --rm -p 8081:8081 --name wiremock \
    -v $PWD:/var/wiremock/extensions wiremock/wiremock:2.33.1 \
    --extensions org.wiremock.webhooks.Webhooks \
    --global-response-templating \
    --max-request-journal-entries 1000 \
    --async-response-enabled true \
    --port 8081