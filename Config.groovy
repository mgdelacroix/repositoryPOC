class Config {

    Map<String, String> data

    Config(String configFileName) {
        URL configUrl = new File (configFileName).toURL()
        this.data = new ConfigSlurper().parse(configUrl)
    }

}