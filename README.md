# healenium-example
Java project with healenium usage example.

Run tests against the application with randomly generated markup https://sha-test-app.herokuapp.com/

## How to start
### 1.Start Healenium backend from infra folder

```cd infra```

```docker-compose up -d```

Verify that images ```healenium/hlm-backend:latest``` and ```postgres:11-alpine``` are up and running


### 2.Run test in terminal with gradle

```./gradlew clean test -i```

### 3.Report link will be available in console like
```
Report available at http://localhost:7878/healenium/report/0cdcb909-73c2-4e74-a7f2-d46c06929a8f
```
