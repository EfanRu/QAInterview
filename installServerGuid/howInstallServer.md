## Steps for RedOs


# Install psql
https://redos.red-soft.ru/base/server-configuring/dbms/install-postgresql/

create postgres user
fix remote connect to postgres

systemctl restart postgresql-15.service


GRANT SELECT ON ALL TABLES IN SCHEMA public TO user;

download and load sample database
https://www.postgresqltutorial.com/postgresql-getting-started/load-postgresql-sample-database/
https://www.postgresqltutorial.com/postgresql-getting-started/postgresql-sample-database/
https://www.pgadmin.org/download/pgadmin-4-apt/


# Install docker
https://redos.red-soft.ru/base/arm/arm-other/docker-install/

# Install selenoid
sudo docker pull selenoid/chrome:116.0
sudo docker pull aerokube/selenoid
sudo docker pull aerokube/selenoid-ui

it's dont work :(
docker run -d --name selenoid -p 4444:4444 -v //var/run/docker.sock:/var/run/docker.sock -v /home/slava/selenoid:/etc/selenoid:ro aerokube/selenoid:latest

it's work (run in catalog with directory config/browsers.json [browsers.json](browsers.json))
wget https://github.com/aerokube/selenoid/releases/download/1.11.0/selenoid_linux_amd64
sudo chmod +x selenoid_linux_amd64

docker run -d --name selenoid-ui -p 8080:8080 aerokube/selenoid-ui --selenoid-uri http://localhost:4444