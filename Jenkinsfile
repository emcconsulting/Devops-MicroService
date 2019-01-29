node() {
	   
    stage 'Checkout'
        git url: 'https://github.com/emcconsulting/Devops-MicroService.git', branch: 'iac-demo'
        
    stage 'Maven Build'
		sh " mvn -q clean package "
		
}
