# Fujitsu-Internship-Task :v:
## _Karl Rapur_


This project follows a three-tier architectural design pattern. For simplicity and presentation reasons all layers are combined into one repository. The objective of this task is to my skills from different perspectives, such as knowledge of programming language, programming patterns, code documenting and testing, and technical stack ecosystem

## Frontend :blue_book:
The frontend application runs default on http://localhost:8081/. The application uses Ngnix server.
- Vue 3 framework
- Primevue UI library
- Vuex
- vue-router
- axios
- joi


## Backend :closed_book:
The backend application runs default on http://localhost:8080/ 
- Spring-Boot
- hibernate-validator
- lombok
- JPA

## Database :green_book:
The database runs default on http://localhost:5432/. For testing purposes postgres do not have a volume attached to it, which means after each container stop, data will be lost. Volumes can be simply attached via the `docker-compose.yml` file. More info [here](https://docs.docker.com/storage/volumes/).
- postgres


---

## :exclamation::exclamation::exclamation: Docker & Deployment

This project is very easy to install and deploy in Docker containers.
First, make sure your Docker client is up and running.

```sh
cd Fujitsu-Internship-Task
docker-compose up
```

This will take a couple of minutes on the initial start because Docker has to build images.
Once up, servers can be accessed on previously defined ports. 
You can change port mappings in `docker-compose.yml`.

---

## Development

### Frontend
Frontend uses VueCli + Webpack for fast developing.
Make a change in your file and instantaneously see your updates!

Open your favorite Terminal and run these commands.

For developing:
```sh
cd Fujitsu-Internship-Task/frontend
npm install
npm run serve
```

For testing:

```sh
cd Fujitsu-Internship-Task/frontend
npm install
npm run test:unit
```

### Backend
Backend uses Gradle for fast developing.
Currently, tests are run on the live Postgres database.
Make sure you have an active connection to Postgres.

```sh
cd Fujitsu-Internship-Task/backend
```
