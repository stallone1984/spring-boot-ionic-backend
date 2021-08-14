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
                bat 'mvn package'
            }
        }
    }
}
