mvn clean package

rm -rf dist

mkdir -p dist

cp -rf linux/bin dist/bin
cp -rf linux/conf dist/conf
cp -rf linux/doc dist/doc
cp -rf linux/lib dist/lib
cp -rf linux/logs dist/logs
cp -rf linux/src dist/src

cp -rf target/lib dist

cp -f target/microservices-server-0.0.1-SNAPSHOT.jar dist/lib/microservices-server.jar
















