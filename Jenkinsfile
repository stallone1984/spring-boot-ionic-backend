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
                def mvnHome = tool name: 'Maven3', type: 'maven'
                sh "${mvnHome}/bin/mvn package"
            }
        }
    }
}
