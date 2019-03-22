# Sample User Management Application


## About
This is just a sample user management application using **JSON Web Token (JWT)** with **Spring Security** and
**Spring Boot 2**. This solution is partially based on the blog entry
[REST Security with JWT using Java and Spring Security](https://www.toptal.com/java/rest-security-with-jwt-spring-security-and-java). Thanks to the authors!


## Usage
Application exposes following endpoints

/login

/refresh (for refreshing the token with new expiration date)

/user

/person/{id}

The login end point will return the JWT token which the client should send back as Authorization header with the value as "Bearer " + token, in order to be able to retrieve the user details or person details.

### Login Credentials

araut/arautpwd

jsmith/jsmithpwd

New users can be created in the database (H2) by accessing /h2-console.  The password is encrypted using the BycryptPasswordEncoder.

## Creator

**Ashish Raut**

* <https://twitter.com/AshishR10920483>
* <https://github.com/ashish2r>

## Copyright and license

