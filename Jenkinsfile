node() {
	   
    stage 'Checkout'
        git url: 'https://github.com/emcconsulting/Devops-MicroService.git', branch: 'int-test'
        
    stage 'Maven Build'
		sh "sudo mvn -q clean package "
		
	stage 'Sonar Validation'	
    	sh "sudo mvn sonar:sonar -Dsonar.host.url=http://192.168.33.80:9000"
    	
	stage 'Docker Build'
		sh "sudo docker build -t emcdevops/tnt-utilities ."
		
	stage 'integration testing'
		dir('tnt-utilities.it') {
		sh "sudo mvn clean install -DskipTests"
		sh "sudo docker build -t emcdevops/tnt-utilities-it ."
        }
        
        dir('src/main/resources/integration'){
        sh "sudo docker-compose up --abort-on-container-exit"
		sh "sudo docker cp intg-test-cont:test-output ../../../../target/test-output"
		sh "sudo docker-compose rm -f"   
        }

		publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/test-output', reportFiles: 'index.html', reportName: 'TestNg integration test report '])
		
		publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/test-output/citrus-reports',
		 reportFiles: 'citrus-test-results.html', reportName: 'citrus integration test report '])
	

		
	stage 'Docker Run'
	    sh"sudo docker stop \$(sudo docker ps -a -q)"
		sh "sudo docker rm \$(sudo docker ps -a -q)"
		sh "sudo docker run -p 9091:9091  emcdevops/tnt-utilities -d &"
	
	stage 'JMeter Performance Tests'
	    sh "sudo /home/vagrant/jmeter/apache-jmeter-3.1/bin/jmeter -n -JEnvURL=192.168.33.80 -JPrtNum=9091  -Jusers=7  -JsuppressJMeterOutput=false -JjmeterLogLevel=DEBUG -Jmeter.save.saveservice.output_format=xml  -t '/var/lib/jenkins/workspace/tnt-utilities-int-test/src/test/jmeter/DevopsJmeter.jmx' -l '/var/lib/jenkins/workspace/tnt-utilities-int-test/target/jmeter/devops_jmeter_result.jtl' "
	    step([$class:'ArtifactArchiver',artifacts:'**/target/jmeter/*.jtl',fingerprint:true]) 
	    performanceReport compareBuildPrevious: false, configType: 'ART', errorFailedThreshold: 0, errorUnstableResponseTimeThreshold: '', errorUnstableThreshold: 0, failBuildIfNoResultFile: false, modeEvaluation: true, modeOfThreshold: false, modePerformancePerTestCase: true, modeThroughput: true, nthBuildNumber: 0, parsers: [[$class: 'JMeterParser', glob: '**/target/jmeter/*.jtl']], relativeFailedThresholdNegative: 0.0, relativeFailedThresholdPositive: 0.0, relativeUnstableThresholdNegative: 0.0, relativeUnstableThresholdPositive: 0.0
	 
	
}
