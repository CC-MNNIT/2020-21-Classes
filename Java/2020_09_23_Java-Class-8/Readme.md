# Softablitz Class 8

#### September 23th, 2020

### Softablitz Class 8 [Recording](https://drive.google.com/file/d/1LKXUAo9UahYaRjKVYOGWUAErj1dR3zmR/view?usp=sharing)

## Resources

- [Why databases?](https://www.softwaretestingclass.com/what-is-database-and-why-do-we-need-them/)
- [SQL](https://www.w3schools.com/sql/)
- [Classroom Code](DatabaseConnectivity.java)

## Info

Install [mysql](https://www.mysql.com/) on your pc. Set up the root username and password.

Start the mysql instance by activating either the batch script on windows or systemd service on linux.

Login to the mysql instance as:

```
mysql -u root -p
```

Then enter your root password. Practic some SQL queries on the mysql prompt before attemping the database problem statements.

Download the mysql connector jar and add it to the libraries of your project.

## Code Description

In the code, add the following line,

```java
Class.forName(String className);
```

The above code dynamically loads the class whose name is "className".

Dynamically load the Driver and proceed as mentioned in the ClassRoom code.

