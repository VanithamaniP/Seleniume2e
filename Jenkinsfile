pipeline {
    agent {
stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            }
}
            }
            }
