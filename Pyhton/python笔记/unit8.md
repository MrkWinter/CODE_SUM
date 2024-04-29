## 第八章

### sql

* 已经会了

### MysqlPython操作

* 基础使用

  ```python
  from pymysql import Connection
  # 获取mysql 数据库的链接对象
  conn = Coonection(
  host = 'localhost',
  port = 3306,
  user = 'root',
  password = 'xing123456')
  # 打印myslq数据库软件信息
  print(conn.get_server_info())
  # 获取游标对象
  cursor = conn.cursor()
  # 选择数据库
  conn.select_db("test")
  # 使用游标对象 执行sql语句
    -- DDL
  cursor.execute("create table usr01 (id int,name varchar(32)) character set utf-8")
    -- DQL
  cursor.excute("select * from user01")
  results: tuple = cursor.fetchall()
  for r in results:
      print(r)
  # 关闭数据库的连接
  conn.close()
  ```

* 数据插入

  ```python
  from pymysql import Connection
  # 获取mysql 数据库的链接对象
  conn = Coonection(
  host = 'localhost',
  port = 3306,
  user = 'root',
  password = 'xing123456'
  autocommit = True # 设置自动提交后不需要手动确认)
  # 获取游标对象
  cursor = conn.cursor()
  # 选择数据库
  conn.select_db("test")
  # 使用游标对象 执行sql语句
   -- DML
  cursor.execute("insert into user01 values(3,'李明')")
  # 通过commit() 方法确认 确认后才能完成修改
  conn.commit()
  # 关闭数据库的连接
  conn.close()
  ```

  

