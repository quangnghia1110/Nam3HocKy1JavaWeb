# Lập trình web
- Đề tài: **Xây dụng website chuỗi bán trà sữa AloTra bằng SpringBoot + JSP + Bootstrap + JPA + SQLServer**
- Giáo viên hướng dẫn: ThS. Nguyễn Hữu Trung
- Sinh viên:
  - Nguyễn Thái Văn         21110939 (Nhóm trưởng)
  - Ngô Quang Nghĩa         21110559
  - Huỳnh Nhật	Nam         21110903
  - Lê Minh	Kha             21110890
  - Nguyễn Trung Phiên      21110593
  - Trần Nguyễn Phương Tây  21110641
  - Nguyễn Trọng Phúc       21110915
  - Phan Minh Thuận         21110667
  - Võ Đức Toàn             21110689
  - Lê Văn	Vũ              21110943

## Tổng quan
- Technical: **JSP** (**J**akarta **S**erver **P**ages) and **Servlet**
- Framework: Spring Boot
- Database:
    - Relational database management system : **Microsoft SQL Server**
    - Object-relational mapping : **Hibernate 5.4.10.Final**
- Front-end frameworks :
    - **Bootstrap**
    - **jQuery** 
    - **AJAX** 
- Design pattern : **Model - View - Controller (MVC)**
- Integrated development environment (IDE) : **Eclipse IDE for Enterprise Java and Web Developers - 2023-06**

## Hướng dẫn cài đặt
- Yêu cầu:
    -  Phải có Eclipse IDE for Enterprise Java and Web Developers và Microsoft SQL Server Management Studio tồn tại trên máy tính
    -  [Tải JDK phù hợp](https://www.oracle.com/java/technologies/downloads/) => Project đang sử dụng JDK 20
    -  [Tải apache-tomcat phù hợp](https://tomcat.apache.org/) => Project đang sử dụng apache-tomcat 10.1.14
    -  [Tải apache-maven phù hợp](https://maven.apache.org/download.cgi) => Project đang sử dụng apache-maven 3.9.4
    -  Cài một vài featured trong Eclipse MarketPlace:
        - Eclipse Enterprise Java and Web Developer Tools 3.30
        - Spring Tools 4 (aka Spring Tool Suite) 4.21.1.RELEASE
        - [Lombok](https://projectlombok.org/setup/eclipse)
- Các bước làm:
    - Clone project về thư mục: https://github.com/quangnghia1110/project_java_web.git
    - Tạo môi trường cho maven và jdk
    - Thực hiện restored database trong Microsoft SQL Server Management Studio 
    - Mở project vừa clone về trong Eclipse IDE for Enterprise Java and Web Developers
    - Tạo servers (ở đây là apache-tomcat)
    - Thực hiện update maven để nó download các thư viện về
    - Ấn Alt+Shift+X, B để có thể chạy project
## Tài liệu
- File báo cáo: [Báo cáo đồ án cuối kỳ web](https://docs.google.com/document/d/16XekAK2jCEcMKaYo8waotoBbjcPuryvB/edit?usp=sharing&ouid=107759858224619439962&rtpof=true&sd=true)
- File backup database: [MILKTEA.bak](https://drive.google.com/file/d/16DzHS1CZa2BDaC6ZbWUolUIb9b2UeJCs/view?usp=sharing)

## Project Structure
<pre>
<b>eCommerceWebsite</b>
├── src
│   ├── main
│   │   ├── <b>java</b>
│   │   │   ├── <b>hcmute.config</b>
│   │   │   │   └── CrosConfig                 
│   │   │   │   └── CustomSiteMeshFilter     
│   │   │   │   └── MvcConfig                         
│   │   │   │   └── StorageProperties                
│   │   │   │   └── VNPayConfig                       
│   │   │   │   └── WebSecurityConfig                         
│   │   │   ├── <b>hcmute.controller</b>
│   │   │   │   └── admin 
│   │   │   │   └── api 
│   │   │   │   └── manager 
│   │   │   │   └── security
│   │   │   │   └── user     
│   │   │   ├── <b>hcmute.embeddedId</b>
│   │   │   │   └── BranchMilkTeaId 
│   │   │   │   └── CartDetailId 
│   │   │   │   └── OrderDetailId 
│   │   │   ├── <b>hcmute.entity</b>
│   │   │   │   └── BranchEntity
│   │   │   │   └── BranchMilkTea
│   │   │   │   └── CartDetailEntity
│   │   │   │   └── CartEntity
│   │   │   │   └── CityEntity
│   │   │   │   └── MilkTeaCategoryEntity
│   │   │   │   └── MilkTeaEntity
│   │   │   │   └── MilkTeaTypeEntity
│   │   │   │   └── OrderDetailEntity
│   │   │   │   └── OrderEntity
│   │   │   │   └── PayMethodEntity
│   │   │   │   └── RoleEntity
│   │   │   │   └── UserEntity
│   │   │   │   └── UserRoleEntity
│   │   │   ├── <b>hcmute.exception</b>
│   │   │   │   └── GlobalExceptionHandler
│   │   │   │   └── OAuth2AuthenticationProcessingException
│   │   │   │   └── ResourceNotFoundException
│   │   │   │   └── StorgeException
│   │   │   │   └── StoreFileNotFoundException
│   │   │   ├── <b>hcmute.model</b>
│   │   │   │   └── AuthProvider
│   │   │   │   └── BranchModel
│   │   │   │   └── BranchMilkTeaModel
│   │   │   │   └── CartDetailModel
│   │   │   │   └── CartModel
│   │   │   │   └── CityModel
│   │   │   │   └── MilkTeaCategoryModel
│   │   │   │   └── MilkTeaModel
│   │   │   │   └── MilkTeaTypeModel
│   │   │   │   └── OrderData
│   │   │   │   └── OrderDetailModel
│   │   │   │   └── OrderModel
│   │   │   │   └── OrderProduct
│   │   │   │   └── PayMethodModel
│   │   │   │   └── UserModel
│   │   │   │   └── UserRoleModel
│   │   │   ├── <b>hcmute.repository</b>
│   │   │   │   └── BranchRepository
│   │   │   │   └── BranchMilkTeaRepository
│   │   │   │   └── CartDetailRepository
│   │   │   │   └── CartRepository
│   │   │   │   └── CityRepository
│   │   │   │   └── MilkTeaCategoryRepository
│   │   │   │   └── MilkTeaRepository
│   │   │   │   └── MilkTeaTypeRepository
│   │   │   │   └── OrderDetailRepository
│   │   │   │   └── OrderRepository
│   │   │   │   └── PayMethodRepository
│   │   │   │   └── RoleRepository
│   │   │   │   └── UserRepository
│   │   │   │   └── UserRoleRepository
│   │   │   ├── <b>hcmute.security</b>
│   │   │   │   └── user
│   │   │   │       └── FacebookOAuth2UserInfo
│   │   │   │       └── GoogleOAuth2UserInfo
│   │   │   │       └── OAuth2UserInfo
│   │   │   │       └── OAuth2UserInfoFactory
│   │   │   │   └── CustomOauth2User
│   │   │   │   └── CustomOauth2UserService
│   │   │   │   └── OAuthLoginSuccessHandler
│   │   │   ├── <b>hcmute.service</b>
│   │   │   │   └── impl
│   │   │   │       └── BranchServiceImpl
│   │   │   │       └── BranchMilkTeaServiceImpl
│   │   │   │       └── CartDetailServiceImpl
│   │   │   │       └── CartServiceImpl
│   │   │   │       └── CityServiceImpl
│   │   │   │       └── ForgotPasswordServiceImpl
│   │   │   │       └── MilkTeaCategoryServiceImpl
│   │   │   │       └── MilkTeaServiceImpl
│   │   │   │       └── MilkTeaTypeServiceImpl
│   │   │   │       └── OrderDetailServiceImpl
│   │   │   │       └── OrderServiceImpl
│   │   │   │       └── PayMethodServiceImpl
│   │   │   │       └── RoleServiceImpl
│   │   │   │       └── StorgeServiceImpl
│   │   │   │       └── UserServiceImpl
│   │   │   │       └── UserRoleServiceImpl
│   │   │   │   └── IBranchService
│   │   │   │   └── IBranchMilkTeaService
│   │   │   │   └── ICartDetailService
│   │   │   │   └── ICartService
│   │   │   │   └── ICityService
│   │   │   │   └── IForgotPasswordService
│   │   │   │   └── IMilkTeaCategoryService
│   │   │   │   └── IMilkTeaService
│   │   │   │   └── IMilkTeaTypeService
│   │   │   │   └── IOrderDetailService
│   │   │   │   └── IOrderService
│   │   │   │   └── IPayMethodService
│   │   │   │   └── IRoleService
│   │   │   │   └── IStorgeService
│   │   │   │   └── IUserService
│   │   │   │   └── IUserRoleService
│   │   │   ├── <b>hcmute.utils</b>
│   │   │   │   └── CommonUtils
│   │   │   │   └── ProjectApplication
│   │   │   │   └── ServletInitalizer
│   │   ├── <b>resources</b>
│   │   │   │   └── static
│   │   │   │       └── admin
│   │   │   │           └── assets
│   │   │   │           └── css
│   │   │   │           └── js
│   │   │   │       └── security
│   │   │   │           └── img
│   │   │   │       └── user
│   │   │   │           └── css
│   │   │   │           └── js
│   │   │   │   └── application.properties
│   │   ├── <b>webapp</b>
│   │   │   │   └── common
│   │   │   │       └── admin
│   │   │   │           └── footer
│   │   │   │           └── header
│   │   │   │       └── manager
│   │   │   │           └── footer
│   │   │   │           └── header
│   │   │   │       └── user
│   │   │   │           └── footer
│   │   │   │           └── header
│   │   │   │       └── taglib.jsp
│   │   │   │   └── decorators
│   │   │   │       └── admin.jsp
│   │   │   │       └── manager.jsp
│   │   │   │       └── user.jsp
│   │   │   │   └── WEB-INF
│   │   │   │       └── admin
│   │   │   │           └── customize
│   │   │   │           └── view
│   │   │   │           └── index.jsp
│   │   │   │       └── error
│   │   │   │           └── 403.jsp
│   │   │   │       └── manager
│   │   │   │           └── customize
│   │   │   │           └── view
│   │   │   │           └── index.jsp
│   │   │   │       └── security
│   │   │   │           └── change-password
│   │   │   │           └── forgot-password
│   │   │   │           └── login
│   │   │   │           └── register
│   │   │   │       └── user
│   │   │   │           └── branches_info.jsp
│   │   │   │           └── branches.jsp
│   │   │   │           └── cart.jsp
│   │   │   │           └── error.jsp
│   │   │   │           └── favorite.jsp
│   │   │   │           └── home.jsp
│   │   │   │           └── order.jsp
│   │   │   │           └── payment.jsp
│   │   │   │           └── product_detail.jsp
│   │   │   │           └── product.jsp
│   │   │   │           └── search.jsp
│   │   │   │           └── user_info.jsp
│   │   │   │       └── web.xml
└── pom.xml
</pre>
