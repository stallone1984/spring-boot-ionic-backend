pipeline {
    agent any 
    stages {
        stage('SCM Checkout') {
            steps {
                git 'https://github.com/stallone1984/spring-boot-ionic-backend'
            }
        }
        stage('Compile-Package') {
            steps {
                def MVN_HOME = tool name: 'Maven3', type: 'maven'
                sh "${MVN_HOME}/bin/mvn package"
            }
        }
    }
}
