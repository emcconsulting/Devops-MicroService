node() {
	   
    stage 'Checkout'
        git url: 'https://github.com/emcconsulting/Devops-MicroService.git', branch: 'master'
        def mvnHome = tool 'M3'
    stage 'Maven Build'
		//sh "sudo rm -rf target"
		sh "sudo ${mvnHome}/bin/mvn clean install "
	stage 'Docker Build'
		sh "sudo docker build -t emcdevops/tnt-utilities ."
	stage 'Docker Run'
		sh "sudo docker run emcdevops/tnt-utilities"
}
