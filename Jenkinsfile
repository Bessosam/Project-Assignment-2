pipeline {
   
    agent any

    tools {
        
        maven "MY_MAVEN"
    }

    stages {
        stage('clean and checkout') {
            steps {
                sh 'mvn clean -f backend'
                 echo 'downloading github project...'
                git branch: 'main', url: 'https://github.com/Bessosam/Project-Assignment-2.git'
            }
        }

        stage('build') {
            steps {
                echo 'building...'
                sh 'mvn test-compile -f backend'
                echo 'finished building'
            }
        }

        stage('test') {
            steps {
                echo 'starting test.....'
                sh 'mvn surefire:test -f backend'
                echo 'finished test'
            }
        }

        stage('package') {
            steps {
                echo 'packaging...'
                sh 'mvn war:war -f backend'
                echo 'packaged'
            }
        }
       stage('deploy') {
            steps {
               sh 'cp backend/target/ROOT.war /artifacts'
            }
        }
    }

}
