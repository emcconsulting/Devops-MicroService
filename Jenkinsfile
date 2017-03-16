node() {
	   
    stage 'Checkout'
        git url: 'https://github.com/emcconsulting/Devops-MicroService.git', branch: 'master'
        def mvnHome = tool 'M3'
    stage 'Maven Build'
		//sh "sudo rm -rf target"
		sh "sudo ${mvnHome}/bin/mvn -q clean package "
	stage 'Sonar Validation'	
    	sh "sudo ${mvnHome}/bin/mvn sonar:sonar -Dsonar.host.url=http://192.168.33.80:9000"
	stage 'Docker Build'
		sh "sudo docker build -t emcdevops/tnt-utilities ."
	stage 'Docker Run'
	    sh"sudo docker stop \$(sudo docker ps -a -q)"
		sh "sudo docker rm \$(sudo docker ps -a -q)"
		sh "sudo docker run -p 9092:9092  emcdevops/tnt-utilities -d &"
}
