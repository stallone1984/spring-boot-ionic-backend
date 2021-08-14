pipeline {
    agent any 
    def MVN_HOME = tool name: 'Maven3', type: 'maven'
    stages {
        stage('SCM Checkout') {
            steps {
                git 'https://github.com/stallone1984/spring-boot-ionic-backend'
            }
        }
        stage('Compile-Package') {
            steps {
                sh "${MVN_HOME}/bin/mvn package"
            }
        }
    }
}
