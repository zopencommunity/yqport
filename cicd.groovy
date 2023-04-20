node('linux')
{
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/yqport.git'), string(name: 'PORT_DESCRIPTION', value: 'yq is a portable command-line YAML, JSON, XML, CSV, TOML and properties processor' )]
  }
}
