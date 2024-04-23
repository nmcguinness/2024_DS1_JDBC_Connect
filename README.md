# DS1 - Connecting to a JDBC database

### Overview
This example illustrates how to connect, query, and update a MySQL database. 

The code is divided into *four* classes:

| File | Description |
| :---------------- | :------ | 
| **Main** | Connect, query, and output, and disconnect|
| **DBConnect** | Provides static methods to connect and disconnect from the DB |
| **DBCommand** | Provides static methods to executeQuery (SELECT) and executeUpdate (DELETE, INSERT, UPDATE) the DB |
|**DBOutputFormatter** | Provides specific static methods to output the results of your queries |

### Instructions

You will need to specify your own **database name**, and write your own **queries** and **output formatters** for the resultsets from these queries.

```
String dbName = "2024_ds1_ca3_games"; //"your DB name goes here"
//...
String query = "SELECT * FROM games";

 ```

### Dependencies

If you want to use the **2024_ds1_ca3_games** database from this example then use the [2024_ds1_ca3_games.sql](ConnectToJDBC/dependencies/2024_ds1_ca3_games.sql) in the *dependencies* folder in PHPMyAdmin.