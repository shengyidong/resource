docker rm -f jenkins
docker run -d -p 8080:8080 -v /usr/local/work/jenkins/jenkins_home:/root/.jenkins --name jenkins jenkins:1.0.0
