node {
    stage("Build") {
        try {
            docker.image('maven:3.5.2').inside {
                checkout scm
                configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
                    sh "mvn -s $MAVEN_SETTINGS -pl pc-bus-opentext-card clean package"
                }
            }
            sh "docker build -t pc-bus-opentext-card-image ./pc-bus-opentext-card"
            sh "docker build -t cucumber ./cucumber"
        } finally {
            sh "docker-compose rm -f -s"
        }
    }
    stage("Cucumber test") {
        try {
            sh "docker-compose up --exit-code-from cucumber"
        } finally {
            sh "docker-compose rm -f -s -v"
            archive 'pc-bus-opentext-card/**/*.jar'
            cucumber 'cucumber/cucumber-reports/json-reports/*.json'
        }
    }
}
