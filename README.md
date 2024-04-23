# DS1 - Connecting to a JDBC database
This example illustrates how to connect, query, and update a MySQL database. The code is divided into four classes:

1. **Main** - Connect, query, and output, and disconnect.
2. **DBConnect** - Provides static methods to connect and disconnect from the DB.
3. **DBCommand** - Provides static methods to executeQuery (SELECT)
and executeUpdate (DELETE, INSERT, UPDATE) the DB.
4. **DBOutputFormatter** - Provides specific static methods to output the results of your queries.