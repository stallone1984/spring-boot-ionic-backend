pipeline {
    agent any 
    stages {
        stage('SCM Checkout') {
            steps {
                git 'https://github.com/stallone1984/spring-boot-ionic-backend'
            }
        }
        stage('Compile-Package') {
            def MVN_HOME = tool name: 'Maven3', type: 'maven'
            steps {
                sh "${MVN_HOME}/bin/mvn package"
            }
        }
    }
}
