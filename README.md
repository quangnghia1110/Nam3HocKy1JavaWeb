## Overview

- Technical: **JSP** (**J**akarta **S**erver **P**ages) and **Servlet**
- Framework: Spring Boot

- Database:
    - Relational database management system : **Microsoft SQL Server**
    - Object-relational mapping : **Hibernate 5.4.10.Final**

- Front-end frameworks :
    - **Bootstrap** - Open source front end
      framework
    - **jQuery** - Fast, small, and feature-rich JavaScript library
    - **AJAX** - Send and retrieve data from a server
      asynchronously without interfering with the display and behaviour of the existing page.

- Design pattern : **Model - View - Controller (MVC)**
- Integrated development environment (IDE) : **Eclipse IDE for Enterprise Java and Web Developers - 2023-06**
<br>
<br>

## Project Structure

<pre>
<b>eCommerceWebsite</b>
├── src
│   ├── main
│   │   ├── <b>java</b>
│   │   │   ├── <b>hcmute.config</b>
│   │   │   │   └── CrosConfig               ()  
│   │   │   │   └── CustomSiteMeshFilter     ()
│   │   │   │   └── MvcConfig                         ()
│   │   │   │   └── StorageProperties                ()
│   │   │   │   └── VNPayConfig                       ()
│   │   │   │   └── WebSecurityConfig                         ()
│   │   │   ├── <b>hcmute.controller</b>
│   │   │   ├── <b>hcmute.embeddedId</b>
│   │   │   ├── <b>hcmute.entity</b>
│   │   │   ├── <b>hcmute.exception</b>
│   │   │   ├── <b>hcmute.model</b>
│   │   │   ├── <b>hcmute.repository</b>
│   │   │   ├── <b>hcmute.security</b>
│   │   │   ├── <b>hcmute.service</b>
│   │   │   ├── <b>hcmute.utils</b>
  
│   │   │   ├── <b>com.hknp.controller</b>
│   │   │   │   └── api               (REST API)
│   │   │   │   └── filter            (Servlet filter)
│   │   │   │   └── common            (common controller for all user's page)
│   │   │   │   └── admin             (controller for admin page)
│   │   │   │   └── delivery          (controller for delivery page)
│   │   │   │   └── employee          (controller for employee page)
│   │   │   │   └── seller            (controller for seller page)
│   │   │   │   └── web               (controller for guest & customer page)
│   │   │   ├── <b>com.hknp.interfaces</b>
│   │   │   ├── <b>com.hknp.model</b>
│   │   │   │   └── dao               (data access object with singleton pattern)
│   │   │   │   └── enity             (Entity Bean class)
│   │   │   │   └── domain
│   │   │   ├── <b>com.hknp.utils</b>
│   │   ├── <b>webapp</b>
│   │   │   ├── <b>WEB-INF</b>
│   │   │   │   └─── <a href="./src/main/webapp/WEB-INF/web.xml" target="_blank">web.xml</a>
│   │   │   ├── <b>assets</b>
│   │   │   │   └── css               (argon css && custom css)
│   │   │   │   └── fonts             (nucleo font)
│   │   │   │   └── img               (images)
│   │   │   │   └── js                (custom javascript)
│   │   │   │   └── vendor            (front-end frameworks)
│   │   │   ├── <b>common</b>                (common components for all jsp page)
│   │   │   ├── <b>view</b>
│   │   │   │   └── admin             (contain admin pages)
│   │   │   │   └── delivery          (contain delivery pages)
│   │   │   │   └── employee          (contain employee pages)
│   │   │   │   └── seller            (contain seller pages)
│   │   │   │   └── web               (contain guest & customer pages)
│   │   │   ├── index.jsp             (redirect to /home)
└── <a href="./pom.xml" target="_blank">pom.xml</a>                           (Acronym for Project Object Model)
</pre>

<br>
<br>

## How to run
