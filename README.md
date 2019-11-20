# TranslationService
Service that allow you to convert a long number into text

### `Download app`
If you want to download this app you can get it from github by download option or by git running on your console the command: git clone [repository_url]

### `Requirements`

Java JDK 11<br/>
Maven 3.6+

### `App url configuration`

This server is running on port: 10090 and the base url is http://[server_url]:[port]/translate/[number]
<br/>

If you need to change the port please modify the application.properties section

### `Build App`

This app was created over Maven so if you want to build the app you only need to run the next command inside the project folder: 
mvn package that will generate the JAR file over the target directory

The test cases for this App will run in the package stage as part of the build

### `Run App`
This app was build with SpringBoot and configured with a embed Tomcat server, so for running this app you only need to run the following command

<br/>
java -jar -Dspring.config.location=file:[PROPERTIES_LOCATION]/application.properties [JAR_LOCATION]/number_translate.jar

### `Test that server is app`

This is a Example call to check if the server is working you can use corl or imortid to Postman to check it<br/>
<br/>
curl -X GET \
  http://localhost:10090/translate/1234567890123456789 \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Cookie: BNI_prpersist=Gt8QHzCCZasran8nf-DfWujPTwc00EP7ZEqyoNQB1giLLMkxm5BPUYBiNtZmWfsVFPxUhvAbCknLt4X1dEe9gQ==' \
  -H 'Host: localhost:10090' \
  -H 'Postman-Token: 53463170-93d6-47d6-8f49-bc710bfe0f2c,c10f5e51-753b-45ff-84e4-d3bbff056a3b' \
  -H 'User-Agent: PostmanRuntime/7.18.0' \
  -H 'cache-control: no-cache'