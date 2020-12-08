# healenium-example
Java project with healenium usage example

## How to start
### 1.Start Healenium backend from infra folder

```cd infra```

```docker-compose up -d```

Verify that images ```healenium/hlm-backend:latest``` and ```postgres:11-alpine``` are up and running


### 2.Run test in terminal with gradle

```./gradlew clean test -i```

