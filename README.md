# PizzaStore


->This application is developed to demonstrate my understanding of Restful Services and also My learning Skills as I have done this project using Spring boot - JPA

-> To start with design of the project with given requirements 
->with given requirements classes or model which were designed to have architecture step up are 

1)User 
2)Credit card (Which would belong to user)
3)Pizza 
4)Item (This would be topping in pizza)
5)Orders (This would have different number of pizza, a credit card and user who has ordered pizza)

Relationship between this model 
1)User hasMany Creditcards (but actually implemented Many to Many due to JPA configurations)
2)Pizza hasMany Items
3)Orders hasMany Pizza 
Orders hasOne Credit card
Orders has one user 

Once database mapping was laid down model POJO classes were written using Spring JPA. Sample data was created and half of this data is created automatically whenever application is started up and half of the data were not including in it. These sample data is placed in userController and hence after application has startup http://localhost:8080/create has to be executed 


->Creating with REST call as per requirement a order has to be created 
->A call in OrderController is created and all the database calls are written in service call not to expose business logic to users 

Things did not like about Application. 
->Most of the was spent on learning how Spring boot and JPA works 
->Getting sample applications to work without any configuring issues. 
->Submitting a application which might require a mysql database.
->two more details. 

README to run application 
1) Application can be executed using maven commands or 
2)importing it in STS and running it as Spring boot application
3)Before starting application mysql database should be present in runing enviornment 
4)To create sample data execute this link in browser 
http://localhost:8080/create
4)Once application is started Rest call for creating an order can be executed through link 
http://localhost:8080/orders
