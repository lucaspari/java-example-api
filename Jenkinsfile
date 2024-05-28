pipeline {
    agent { docker { image 'maven:3.8.3-openjdk-17' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
            }
        stage('test'){
            steps {
                sh 'mvn test'
            }
        }
    }
}