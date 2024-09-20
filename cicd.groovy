node('linux')
{
   
  stage ('Poll') {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        userRemoteConfigs: [[url: "https://github.com/zopencommunity/yqport.git"]]])
        }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/yqport.git'), string(name: 'PORT_DESCRIPTION', value: 'yq is a portable command-line YAML, JSON, XML, CSV, TOML and properties processor' ), string(name: 'NODE_LABEL', value: "go_120")]
  }
}
