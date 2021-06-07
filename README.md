### **Execute application**

Open the package of project on any terminal and run:
- mvn spring-boot:run


### **Data base**

1- After execute application, with your browser, access the page:
_http://localhost:8080/h2-console_

2- Credentials of database:
        
        -   Saved Settings: Generic H2 (Embedded)
        -   Setting Name: Generic H2 (Embedded)
        -   JDBC URL: jdbc:h2:mem:desafio
        -   User Name:	root
        -   Password :
_obs: Was inserted some users(Client and Seller) on application, access the database to know more_
-   User(Client) : ids(1,2,3)
-   Seller       : ids(4,5,6)

### **Test with Postman**

Was exported the collection to test the application. The name of file is _Desafio Spring.postman_collection.json_
-   To test, just import this file on Postman