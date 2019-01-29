node() {
	   
    stage 'Checkout'
        git url: 'https://github.com/emcconsulting/Devops-MicroService.git', branch: 'iac-demo'
        
    stage 'Maven Build'
		sh "sudo mvn -q clean package "
		
}
