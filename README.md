# DS1 - Connecting to a JDBC database
This example illustrates how to connect, query, and update a MySQL database. 

The code is divided into *four* classes:

1. **Main** - Connect, query, and output, and disconnect.
2. **DBConnect** - Provides static methods to connect and disconnect from the DB.
3. **DBCommand** - Provides static methods to executeQuery (SELECT)
and executeUpdate (DELETE, INSERT, UPDATE) the DB.
4. **DBOutputFormatter** - Provides specific static methods to output the results of your queries.

You will need to specify your own **database name**, and write your own **queries** and **output formatters** for the resultsets from these queries.

If you want to use the *2024_ds1_ca3_games* database from this example then use the *2024_ds1_ca3_games.sql* file in the *dependencies* folder in PHPMyAdmin.