#!/bin/bash
./gradlew installDist

cd ./build/install/dm-book-project/bin

./dm-book-project -Dserver.port=8080 org.dm.Main
./dm-book-project -Dserver.port=8081 org.dm.Main
./dm-book-project -Dserver.port=8082 org.dm.Main
./dm-book-project -Dserver.port=8083 org.dm.Main
