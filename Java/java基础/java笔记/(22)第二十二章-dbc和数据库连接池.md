### jdbc概述

* 基本介绍
  1. .JDBC为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题。
  2. Java程序员使用JDBC，可以连接任何提供了JDBC驱动程序的数据库系统，从而完成对数据库的各种操作。
  3. JDBC是Java提供一套用于数据库操作的接口API，Java程序员只需要面向这套接口编程即可。不同的数据库厂商，要针对这套接口，提供不同实现。
  4. 通过对JDBC(接口和类)的操作 通过动态绑定机制 进而操作各种数据库中jar包的类 从而实现操作不同的数据库

### jdbc快速入门

* jdbc程序编写步骤

  1. 注册驱动 加载Driver类

     此过程是调用不同数据库中的jar包中的驱动类 可以说是最主要的类，调用该驱动类的各种方法返回的jar包中各种操作数据库的对象 如connection statement parperedstatement resutset 等下的 通过java.sql包中的接口接收，接收后由于是向上转型 接着根据动态绑定机制调用各种方法以实现操作数据库的效果

  2. 获取连接 得到connection

     此步骤本质上都是由jar包中driver驱动类得到的connection连接(com.jdbc.mysql中的) 表现形式有两种  一是直接使用driver对象得到connection连接数据库的对象 二是将driver对象传入java.sql 中的  DriverManager类中 该类处理后得到连接数据库的connection实现类对象

  3. 指向增删查改 发送sql给mysql执行

  4. 释放资源 关闭相关连接

* 第一个jdbc程序

  ```java
  public class JdbcTest {
      public static void main(String[] args) throws SQLException {
          //前置工作： 在项目下创建一个文件夹比如 libs
          // 将 mysql.jar 拷贝到该目录下，点击 add to project ..加入到项目中
          //1. 注册驱动
          Driver driver = new Driver(); //创建driver对象
          //2. 得到连接
          //(1) jdbc:mysql:// 规定好表示协议，通过 jdbc 的方式连接 mysql
          //(2) localhost 主机，可以是 ip 地址
          //(3) 3306 表示 mysql 监听的端口
          //(4) db03 连接到 mysql dbms 的哪个数据库
          //(5) mysql 的连接本质就是前面学过的 socket 连接
          String url = "jdbc:mysql://localhost:3306/db03"; //规定要连接的mysql主机和数据库
          //将 用户名和密码放入到 Properties 对象
          Properties properties = new Properties();
          properties.setProperty("user","root"); //规定连接数据库的用户
          properties.setProperty("password","xing123456");
          //user 和 password 是规定好，后面的值根据实际情况写
          Connection connect = driver.connect(url, properties);
          //3. 执行 sql
          String sql = "insert into table1 values(12,'迪卢克')";
          //String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
          //String sql = "update actor set name='周星驰' where id = 1";
          //statement 用于执行静态 SQL 语句并返回其生成的结果的对象
          Statement statement = connect.createStatement();
          int row = statement.executeUpdate(sql); //row为影响的行数
          System.out.println(row>0?"成功":"失败");
          //4. 关闭连接资源
          statement.close();
          connect.close();
      }
  }
  ```

* 连接数据库的五种方式

  1. 获取driver实现类对象 (基础)

     ```java
     public void connect1() throws SQLException {
         //注册驱动
         Driver driver = new Driver();
         String url = "jdbc:mysql://localhost:3306/db03";
         Properties properties = new Properties();
         properties.setProperty("user", "root");
         properties.setProperty("password", "xing123456");
         //通过驱动获得连接
         Connection connect = driver.connect(url, properties);
         System.out.println("连接方式一" + connect);
     }
     ```

  2. 通过反射获取driver对象 (相比之上较灵活一点)

     ```java
     public void connect2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
         //通过反射注册驱动
         Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
         Driver driver = (Driver) aClass.newInstance();
         String url = "jdbc:mysql://localhost:3306/db03";
         Properties properties = new Properties();
         properties.setProperty("user", "root");
         properties.setProperty("password", "xing123456");
         //通过驱动获得连接
         Connection connect = driver.connect(url, properties);
         System.out.println("连接方式二" + connect);
     }
     ```

  3. 使用drivermanager替换driver (相比之上 信息配置较简便)

     ```java
     public void connect3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
         Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
         Driver driver = (Driver) aClass.newInstance();
         //通过DriverManager 替代 driver 获取连接
         DriverManager.registerDriver(driver);
         String url = "jdbc:mysql://localhost:3306/db03";
         String user = "root";
         String password = "xing123456";
         Connection connection = DriverManager.getConnection(url, user, password);
         System.out.println("连接方式三" + connection);
     }
     ```

  4. 使用Class.forname 自动完成驱动注册 (相比之上少了两句注册驱动)

     ```java
     public void connect4() throws ClassNotFoundException, SQLException {
         //类加载也可以拿掉 因为mysql的jar包中有该driver类的信息 底层自动加载 但不建议
         Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
         //Driver driver = (Driver) aClass.newInstance();
         //DriverManager.registerDriver(driver);
         //通过静态代码块自动注册
         String url = "jdbc:mysql://localhost:3306/db03";
         String user = "root";
         String password = "xing123456";
         Connection connection = DriverManager.getConnection(url, user, password);
         System.out.println("连接方式四" + connection);
     }
     ```

  5. 使用properties配置文件加载信息 (相比之上最为灵活 动态代码)

     ```java
     public void connect5() throws IOException, ClassNotFoundException, SQLException {
         //通过配置文件获取信息
         Properties properties = new Properties();
         properties.load(new FileInputStream("mysql-jdbc.properties"));
         //同方式四一样
         Class<?> driver = Class.forName(properties.getProperty("Driver"));
         String url = properties.getProperty("url");
         String user = properties.getProperty("user");
         String password = properties.getProperty("password");
         Connection connection = DriverManager.getConnection(url, user, password);
         System.out.println("连接方式五" + connection);
     }
     ```

* 结果集

  1. 结果集表示数据库结果集的数据表，通常通过执行查询数据库的语句生成

  2. ResultSet对象保持一个光标指向其当前的数据行。最初，光标位于第一行之前，next方法将光标移动到下一行

  3. 由于在ResultSet对象中没有更多行时返回false，因此可以在while循环中使用循环来遍历结果集

  4. resultset对象中存储的数据库结果集的数据表底层是存储在集合中的 （一条数据?）

  5. 对结果集的操作和collection连接有关系 collection连接关闭就不能再访问结果集

  6. resultset表面看起来是一个记录集，其实这个对象中只是记录了结果集的相关信息，具体的记录并没有存放在对象中，具体的记录内容知道你通过 next 方法提取的时候，再通过相关的 getXXXXX 方法提取字段内容的时候才能从数据库中得到，这些并不会占用内存，具体消耗内存是由于你将记录集中的数据提取出来加入到你自己的集合中的时候才会发生，如果你没有使用集合记录所有的记录就不会发生消耗内存厉害的情况

     ```java
     public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
         Properties properties = new Properties();
         properties.load(new FileInputStream("mysql-jdbc.properties"));
         String url = properties.getProperty("url");
         String user = properties.getProperty("user");
         String password = properties.getProperty("password");
         String driver = properties.getProperty("Driver");
         String sql = "select * from table1";
         //1.注册驱动
         Class<?> aClass = Class.forName(driver);
         //2.获取连接通道
         Connection connection = DriverManager.getConnection(url,user,password);
         //3.获取指令通道
         Statement statement = connection.createStatement();
         //4.组建发送指令
         ResultSet resultSet = statement.executeQuery(sql);
         while (resultSet.next()) {
             int id = resultSet.getInt("id");//通过列名指定 推荐
             int anInt = resultSet.getInt(1);//获取该行的第一列
             String string = resultSet.getString(2);//得到该行的第二列
             System.out.println("\t" + anInt+ "\t" + string);
         }
         //关闭通道
         resultSet.close();
         statement.close();
         connection.close();
     }
     ```

* statement (接口)

  1. Statement对象 用于执行静态SQL语句并返回其生成的结果的对象
  2. 在连接建立后，需要对数据库进行访问，执行 命名或是SQL 语句，可以通过Statement [存在SQL注入]  PreparedStatement[预处理]   Callable Statement [存储过程] 来实现
  3. Statement对象执行SQL 语句，存在SQL注入风险  SQL 注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的 SQL 语句段或命令,恶意攻击数据库。 简单例子来说就是通过字符串拼接漏洞实现某种非法行为
  4. 要防范 SQL 注入，只要用 PreparedStatement(从Statement扩展而来)取代 Statement 

* preparedstatement 防止sql注入

  1. PreparedStatement 执行的 SQL 语句中的参数用?来表示 ，调用PreparedStatement 对象的 setXxx 方法来设置这些参数 setXxx 方法有两个参数，第一个参数是要设置的 SQL 语句中的参数的索引(从 1 开始)，第二个是设置的 SQL 语句中的参数的值
  2. 调用 executeQuery()，返回 ResultSet 对象 用于查询操作
  3. 调用 executeUpdate(: 执行更新，包括增、删、修改
  4. statement与preparedstatement相似 后者是基于前者改进的 不同于sql语句的位置
  5. 该方法被称为预处理 好处是可以避免SQL注入 同时减少了编译次数 同时一定程度上避免字符串拼接错误

  ```java
  public class PrepareStatement01 {
      public static void main(String[] args) throws Exception{
          Scanner scanner = new Scanner(System.in);
          //next()方法得到的字符串按空格隔开 不能读取空格 而是读到空格自动结束
          //nextline() 方法可以读空格
          System.out.println("请输入查询id");
          String id = scanner.nextLine();
          System.out.println("请输入查询姓名");
          String name = scanner.nextLine();
  
          Properties properties = new Properties();
          properties.load(new FileInputStream("mysql-jdbc.properties"));
          String url = properties.getProperty("url");
          String user = properties.getProperty("user");
          String password = properties.getProperty("password");
          String driver = properties.getProperty("Driver");
  
          Class<?> aClass = Class.forName(driver);
  
          Connection connection = DriverManager.getConnection(url, user, password);
  
          //用PreparedStatemet代替statement
          //statement是直接用方法发送sql指令
          //不同于statement prest 需要指定sql语句 然后进行预处理
          //再调用方法 自动将处理后的sql语句发送
          PreparedStatement preparedStatement = connection.prepareStatement(
                  "select * from table1 where id = ? and name = ?");
          preparedStatement.setString(1,id);
          preparedStatement.setString(2,name);
          ResultSet resultSet = preparedStatement.executeQuery();
          //注意： 执行select语句用executeQuery() 执行cud语句用excuteUpdate()
          if(resultSet.next()) {
              System.out.println("查询成功");
              System.out.println(resultSet.getInt(1) + "\t" +
                      resultSet.getString(2) + "\t");
          } else {
              System.out.println("查询失败");
          }
          resultSet.close();
          preparedStatement.close();
          connection.close();
      }
  }
  ```

* jdbc api

  <img src="img\image-20230716164624334.png" alt="image-20230716164624334" style="zoom: 67%;" />

<img src="img\image-20230716164807035.png" alt="image-20230716164807035" style="zoom: 50%;" />

* jdbcutils工具类的开发

  ```java
  public class JDBCUtil {
      static private String url;
      static private String user;
      static private String password;
      static private String driver;
      static {
          Properties properties = new Properties();
          try {
              properties.load(new FileInputStream("mysql-jdbc.properties"));
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
          url = properties.getProperty("url");
          user = properties.getProperty("user");
          password = properties.getProperty("password");
          driver = properties.getProperty("Driver");
      }
      //加载得到连接的方法
      public static Connection getCollection() {
          try {
              Class<?> aClass = Class.forName(driver);
              Connection connection = DriverManager.getConnection(url, user, password);
              return connection;
          } catch (ClassNotFoundException e) {
              throw new RuntimeException(e);
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
      //关闭释放资源的方法
      public static void close(ResultSet resultSet, Statement statement,Connection connection) {
          try {
              if(resultSet!=null)
                  resultSet.close();
              if (statement!=null)
                  statement.close();
              if (connection!=null)
                  connection.close();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
  }
  ```

* JDBCutils工具类的使用

  ```java
  public class JDBCUtilUse {
      public static void main(String[] args) {
          Connection collection = JDBCUtil.getCollection();
          PreparedStatement preparedStatement = null;
          try {
              preparedStatement = collection.prepareStatement("insert into table1 values(?,?)");
              preparedStatement.setInt(1,2);
              preparedStatement.setString(2,"神里绫华");
              int i = preparedStatement.executeUpdate();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          } finally {
              JDBCUtil.close(null,preparedStatement,collection);
          }
  
      }
  }
  ```

### 事物

* JDBC事物基本介绍
  1. JDBC程序中当一个Connection对象创建时，默认情况下是自动提交事务，每次执行一个 SQL 语句时，如果执行成功，就会向数据库自动提交，而不能回滚
  2. JDBC程序中为了让多个 SQL 语句作为一个整体执行，需要使用事务
  3. 调用 Connection 的 setAutoCommit(false)可以取消自动提交事务
  4. 在所有的 SQL 语句都成功执行后，调用 Connection 的 commit()  方法提交事务
  5. 在其中某个操作失败或出现异常时，调用 Connection 的 rollback() 方法回滚事务

* 事物使用代码演示

  ```java
  public class Transaction {
      public static void main(String[] args) throws SQLException {
          Connection collection = JDBCUtil.getCollection();
          PreparedStatement preparedStatement = null;
          PreparedStatement preparedStatement1 = null;
          try {
              collection.setAutoCommit(false); //开启事物
               preparedStatement = collection.prepareStatement
                      ("update table2 set ballance = ballance + 100 where name = '马云'");
              preparedStatement.executeUpdate();
              int i = 1/0;//出现异常事物回滚
              preparedStatement1 = collection.prepareStatement
                      ("update table2 set ballance = ballance - 100 where name = '马超'");
              preparedStatement1.executeUpdate();
              collection.commit();//全部完成 提交
          } catch (SQLException e) {
              collection.rollback(); //事物回滚
              throw new RuntimeException(e);
          } finally {
              JDBCUtil.close(null,preparedStatement,null);
              JDBCUtil.close(null,preparedStatement1,collection);
          }
      }
  }
  ```

* 批处理

  1. 当需要成批插入或者更新记录时。可以采用Java的批量更新机制，这一机制允许多条语句一次性提交给数据库批量处理。通常情况下比单独提交处理更有效率

  2. JDBC的批量处理语句包括下面方法 

     1.  addBatch() 添加需要批量处理的SQL语句或参数
     2. executeBatch()  执行批量处理语句 
     3. clearBatch()   清空批处理包的语句

  3. JDBC连接MySQL时，如果要使用批处理功能，要在url中加参数?rewriteBatchedStatements=true

  4. 批处理往往和PreparedStatement一起搭配使用，可以既减少编译次数，又减少运行次数，效率大大提高

  5. 代码演示

     ```java
     public class Batch {
         public static void main(String[] args) throws Exception {
             Connection collection = JDBCUtil.getCollection();
             String url = "insert into table3 values(?,?)";
             PreparedStatement preparedStatement = collection.prepareStatement(url);
             for (int i = 0; i < 5000; i++) {
                 preparedStatement.setInt(1, i);
                 preparedStatement.setString(2, "jack" + i);
                 preparedStatement.addBatch();
                 if ((i + 1) % 1000 == 0) {
                     preparedStatement.executeBatch();
                     preparedStatement.clearBatch();
                 //将 sql 语句加入到批处理包中 -> 看源码
                 //1. //第一就创建 ArrayList - elementData => Object[]
                 //2. elementData => Object[] 就会存放我们预处理的 sql 语句
                 //3. 当 elementData 满后,就按照 1.5 扩容
                 //4. 当添加到指定的值后，就 executeBatch()
                 //5. 批量处理会减少我们发送 sql 语句的网络开销，而且减少编译次数，因此效率提高
                 //public void addBatch () throws SQLException {
                 //    synchronized (this.checkClosed().getConnectionMutex()) {
                 //        if (this.batchedArgs == null) {
                 //            this.batchedArgs = new ArrayList();
                 //        }
                 //        for (int i = 0; i < this.parameterValues.length; ++i) {
                 //            this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                 //        }
                 //        this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues,
                 //                this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                 //    }
                 //}
                 }
             }
             JDBCUtil.close(null, preparedStatement, collection);
         }
     }
     ```



### 连接池

* 传统连接方法弊端

  1. 传统的JDBC数据库连接使用 DriverManager  连接的时候都要将 Connection 加载到内存中再验证IP地址，用户名和密码(0.05s~1s时间)。需要数据库连接的时候就向数据库要求一个，频繁的进行数据库连接操作将占用很多的系统资源，容易造成服务器崩溃。
  2. 每一次数据库连接，使用完后都得断开，如果程序出现异常而未能关闭，将导致数据库内存泄漏，最终将导致重启数据库。
  3. 传统获取连接的方式，不能控制创建的连接数量，如连接过多，也可能导致内存泄漏，MySQL崩溃
  4. 解决传统开发中的数据库连接问题，i可以采用数据库连接池技术(connection pool) 

* 连接池的分类

  1. JDBC 的数据库连接池使用 javax.sql.DataSource 来表示，DataSource只是一个接口，该接口通常由第三方提供实现
  2. **C3P0** 数据库连接池，速度相对较慢，稳定性不错(hibernate, spring)
  3. DBCP数据库连接池，速度相对c3p0较快，但不稳定
  4. Proxool数据库连接池，有监控连接池状态的功能，稳定性较c3p0差一点
  5. **Druid(德鲁伊)**是阿里提供的数据库连接池，集DBCP、C3P0 、Proxoo优点于一身的数据库连接池

* c3p0连接池

  1. 方式一 创建数据源对象 设置信息得到连接

     ```java
     public void connect1() throws PropertyVetoException, SQLException {
         //创建一个数据源对象 用数据去初始化 (连接交给该对象)
         ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
         String url = "jdbc:mysql://localhost:3306/db03";
         String user = "root";
         String password = "xing123456";
         String driver = "com.mysql.jdbc.Driver";
         comboPooledDataSource.setJdbcUrl(url);
         comboPooledDataSource.setUser(user);
         comboPooledDataSource.setPassword(password);
         comboPooledDataSource.setDriverClass(driver);
         //设置初始化连接数
         comboPooledDataSource.setInitialPoolSize(10);
         //最大连接数
         comboPooledDataSource.setMaxConnectionAge(50);
         //得到池中的连接
         Connection connection = comboPooledDataSource.getConnection();
         System.out.println(connection + "连接成功");
         //断开在池中的引用
         connection.close();
     }
     ```

  2. 方式二  使用配置文件模板来给数据源对象设置信息

     ```java
     public void connect2() throws SQLException {
         //使用配置文件初始化数据源对象
         ComboPooledDataSource c3p0 = new ComboPooledDataSource("test_c3p0");
         Connection connection = c3p0.getConnection();
         System.out.println(connection + "连接成功");
         connection.close();
     }
     ```

     ps:配置文件时 配置文件放在src目录下 配置信息正确 配置信息名与java代码中 的名称一致 配置代码用 <named-config name="xxx"> </named-config>来包括 c3p0连接池是通过c3p0-config.xml配置文件得到连接数据库的配置信息的 通过CombopooleddataSource 对象传入xml配置文件中配置的配置文件名 创建数据源(连接池)对象 从而获得连接

* druid (德鲁伊) 连接池

  ```java
  public class Druid {
      public static void main(String[] args) throws Exception {
          Properties properties = new Properties();
          properties.load(new FileInputStream("druid.properties"));
          //读取配置文件创建数据源
          DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
          Connection connection = dataSource.getConnection();
          System.out.println(connection + "连接成功");
          connection.close();
      }
  }
  ```

  ps : 德鲁伊连接池是通过properties配置文件得到配置信息连接数据库的 通过DruidDataSourceFactory 类中 的 createDateSource(properties文件)方法来得到数据源(数据库连接池)
  
* 使用德鲁伊连接池完善的工具类

  ```java
  public class JDBCUtilsByDruid {
      private static DataSource dataSource;
      static {
          try {
              Properties properties = new Properties();
              properties.load(new FileInputStream("druid.properties"));
              dataSource = DruidDataSourceFactory.createDataSource(properties);
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }
      public static Connection getConnection() {
          try {
              return dataSource.getConnection();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
      public static void close(ResultSet resultSet, Statement statement, Connection connection) {
          try {
              if(resultSet!=null)
                  resultSet.close();
              if (statement!=null)
                  statement.close();
              if (connection!=null)
                  connection.close();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
  }
  ```

### commons-dbutils工具介绍

* 基本介绍

  1. commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库，它是对JDBC的封装
     使用dbutils能极大简化jdbc编码的工作量[真的]。
  2. 该工具类可以将查到的数据封装到一个arraylist集合中 便于操作
  3. QueryRunner类: 该类封装了SQL的执行，是线程安全的。可以实现增、删、改、查、批处理
  4. ResultSetHandler接口: 该接口用于处理 java.sql.ResultSet，将数据按要求转换为另一种形式 接口下的方法有

  > ArrayHandler: 把结果集中的第一行数据转成对象数组。
  >
  > ArrayListHandler: 把结果集中的每一行数据都转成一个数组，再存放到List中BeanHandler: 将结果集中的第一行数据封装到一个对应的JavaBean实例中。
  >
  > BeanListHandler: 将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里ColumnListHandler: 将结果集中某一列的数据存放到List中。
  >
  > KevedHandler(name): 将结果集中的每行数据都封装到Map里，再把这些map再存到一个map里，其key为指定的key.MapHandler: 将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。MapListHandler: 将结果集中的每一行数据都封装到一个Map里，然后再存放到List

* 基本使用(查）

  1. (多行多列) 使用BeanListHander(xxx.class)   用于存储表中每行数据的类称为 domain/pojo/javabean

     ```java
     public class DbutilsUse {
         public static void main(String[] args) throws SQLException {
             //1. 得到 连接 (druid)
             Connection connection = JDBCUtilsByDruid.getConnection();
             //2. 使用 DBUtils 类和接口 , 先引入 DBUtils 相关的 jar , 加入到本 Project
             //3. 创建 QueryRunner
             QueryRunner queryRunner = new QueryRunner();
             //4. 就可以执行相关的方法，返回 ArrayList 结果集
             // 注意: sql 语句也可以查询部分列
             String sql = "select id, name from table2 where id >= ?";
             //(1) query 方法就是执行 sql 语句，得到 resultset ---封装到 --> ArrayList 集合中
             //(2) 返回集合
             //(3) connection: 连接
             //(4) sql : 执行的 sql 语句
             //(5) new BeanListHandler<>(Table2.class): 在将 resultset -> Table2 对象 -> 封装到 ArrayList
             // 底层使用反射机制 去获取 Table2 类的属性，然后进行封装
             //(6) 1 就是给 sql 语句中的? 赋值，可以有多个值，因为是可变参数 Object... params
             //(7) 底层得到的 resultset ,会在 query 关闭时, 关闭 PreparedStatment
             List<Table2> query = queryRunner.query(connection, sql, new BeanListHandler<>(Table2.class), 1);
             /**
             //分析 queryRunner.query 方法:
             public <T > T query(Connection conn, String sql, ResultSetHandler < T > rsh, Object...params) throws
             SQLException {
                 PreparedStatement stmt = null;//定义 PreparedStatement
                 ResultSet rs = null;//接收返回的 ResultSet
                 Object result = null;//返回 ArrayList
                 try {
                     stmt = this.prepareStatement(conn, sql);//创建 PreparedStatement
                     this.fillStatement(stmt, params);//对 sql 进行 ? 赋值
                     rs = this.wrap(stmt.executeQuery());//执行 sql,返回 resultset
                     result = rsh.handle(rs);//返回的 resultset --> arrayList[result] [使用到反射，对传入 class 对象处理]
                 } catch (SQLException var33) {
                     this.rethrow(var33, sql, params);
                 } finally {
                     try {
                         this.close(rs);//关闭 resultset
                     } finally {
                         this.close((Statement) stmt);//关闭 preparedstatement 对象
                     }
                 }
                 return result;
             }*/
             System.out.println(query);
             JDBCUtilsByDruid.close(null,null,connection);
         }
     }
     ```

  2. 查多行单列情况 使用beanhander(xxx.class)

     ```java
     public void testSelect2() throws SQLException {
         Connection connection = JDBCUtilsByDruid.getConnection();
         String sql = "select * from table2 where id = ?";
         QueryRunner queryRunner = new QueryRunner();
         Table2 query = queryRunner.query(connection, sql, new BeanHandler<>(Table2.class), 1);
         System.out.println(query);
         JDBCUtilsByDruid.close(null,null,connection);
     }
     ```

  3. 查单行单列情况 使用scanerHander()

     ```java
     public void testSelect3() throws SQLException {
         Connection connection = JDBCUtilsByDruid.getConnection();
         String sql = "select name from table2 where id = ?";
         QueryRunner queryRunner = new QueryRunner();
         //这里不用传入对象 因为返回的是一个object对象
         Object query1 = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);
         System.out.println(query1);
         JDBCUtilsByDruid.close(null,null,connection);
     }
     ```

* 基本使用(增删改)

  ```java
  public void testDML() {
      //增 删 改
      Connection connection = JDBCUtilsByDruid.getConnection();
      String sql1 = "insert into table2 values(?,?,?)";
      String sql2 = "delete from table2 where id = ?";
      String sql3 = "update table2 set id = ? where name = ?";
      QueryRunner queryRunner = new QueryRunner();
      try {
          connection.setAutoCommit(false);
          int alteredRow1 = queryRunner.update(connection, sql1, 3, "马化腾", 3000);
          int alteredRow2 = queryRunner.update(connection, sql2, 3);
          int alteredRow3 = queryRunner.update(connection, sql3, 2, "马云");
          connection.commit();
      } catch (SQLException e) {
  
          try {
              connection.rollback();
          } catch (SQLException ex) {
              throw new RuntimeException(ex);
          }
          throw new RuntimeException(e);
      } finally {
          JDBCUtilsByDruid.close(null,null,connection);
      }
  }
  ```

### DAO 和增删改查通用方法-BasicDao

* 基本介绍

  1. DAO: data access object数据访问对象
  2. 这样的通用类，称为 BasicDao，是专门和数据库交互的，即完成对数据库(表)的crud操作
  3. 在BaiscDao 的基础上，实现一张表 对应一个Dao，更好的完成功能，比如 Customer表Customerjava类(avabean)-CustomerDao.java

  

* 使用dao简化与数据库交互的代码

  1. basicdao类

     ```java
     public class BasicDAO<T> {
         private Connection connection = null;
         private QueryRunner queryRunner = new QueryRunner();
     
         //dml操作
         public int updateSql(String sql,Object... parameters) {
             connection = JDBCUtilsByDruid.getConnection();
             try {
                 return queryRunner.update(connection,sql,parameters);
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             } finally {
                 JDBCUtilsByDruid.close(null,null,connection);
             }
         }
         //查 多行多列
         public List<T> quarryMulti(String sql, Class<T> tClass, Object...parameters) {
             connection = JDBCUtilsByDruid.getConnection();
             try {
                return queryRunner.query(connection,sql,new BeanListHandler<>(tClass),parameters);
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             } finally {
                 JDBCUtilsByDruid.close(null,null,connection);
             }
         }
         //查 单行多列
         public T quarrySingle(String sql,Class<T> tClass,Object... parameters) {
             connection = JDBCUtilsByDruid.getConnection();
             try {
                 return queryRunner.query(connection,sql,new BeanHandler<>(tClass),parameters);
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             } finally {
                 JDBCUtilsByDruid.close(null,null,connection);
             }
         }
         //查 单行单列
         public Object quarryScn(String sql,Object... parameters) {
             connection = JDBCUtilsByDruid.getConnection();
             try {
                 return queryRunner.query(connection,sql,new ScalarHandler<>(),parameters);
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             } finally {
                 JDBCUtilsByDruid.close(null,null,connection);
             }
         }
     }
     ```

  2. actordao类继承指定泛型为actor后的Basicdao类的使用

     ```java
     public class ActorUse {
         public static void main(String[] args) {
             //多行多列查询
             ActorDAO actorDAO = new ActorDAO();
             List<Actor> actors = actorDAO.quarryMulti("select * from actor where id > ?", Actor.class, 0);
             System.out.println("多行多列数据" + actors);
     
             //单行多列数据
             Actor actor = actorDAO.quarrySingle("select * from actor where id = ?", Actor.class, 1);
             System.out.println("单行多列数据" + actor);
     
             //单行单列数据
             Object o = actorDAO.quarryScn("select name from actor where id = ?", 1);
             System.out.println("单行但列数据" + o);
     
             //插入数据操作
             int affectedRow = actorDAO.updateSql("insert into actor values(null,?,?)", "范冰冰", 1000);
             if (affectedRow>0)
                 System.out.println("插入成功");
         }
     }
     ```