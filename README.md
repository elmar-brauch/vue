# Install npm
1) Install npm https://nodejs.org/en/download/
2) npm install -g @vue/cli
3) npm install -g typescript
4) Optional set 2 Proxies
   1) npm config set proxy <proxy-url:port>
   2) npm config set https-proxy <proxy-url:port>

# Extend Spring Boot project with Vue.js frontend
* Windows PowerShell started as admin and executed the following command:  
```Set-ExecutionPolicy RemoteSigned``` 
* In Maven parent project folder, create new Vue.js module with Vue.js CLI:  
```npm init vue```
  * Selected features: TypeScript, JSX, Router, Pinia, Eslint, Prettier
* Create pom.xml in frontend folder
* npm run dev

# Build Vue.js frontend to be packed in Spring Boot application
* Check all 3 pom.xml files to see how it's done ;-)
* Start Maven to build frontend and copy it into resource folder: mvn clean install
* Start Spring Boot application
* Open in browser: http://localhost:8080