### MySQL

* MySQL的下载配置

### MySQL的指令

* 开关MySQL服务的指令

  开 **net start mysql**

  关 **net stop mysql**

* 连接 退出 MySQL服务的指令

  1. 连接 **mysql -h 主机ip -P 端口 -u 用户名 -p密码**

     (1)  注意连接前MySQL服务前MySQL服务要开启

     (2)  不写密码会下一行要求 输入密码

     (3)  若没写-h 默认为本机  没写-P 默认为3306 可以改

     (4)  在实际工作时端口 3306 往往会修改

  2. 退出 **quit**

* 操作MySQL的图形化软件

  1. Navicat
  2. SQLyog

### MySQL结构

* 数据库的三层结构

  1. 数据库管理系统 DBMS (Deta Base Manage System)

     数据库管理系统可以看做是在本机(服务端) 根据一个端口开的一个服务程序 别的主机(客户端)可以根据主机ip + 端口连接这个服务 根据服务访问数据库中的数据

  2. 数据库 data base

     一个数据库在本机(服务端)的体现是一个文件夹 该数据库中可以存放数据信息 如表等  该文件夹在mysql服务程序安装下的子文件夹中(不准确)

  3. 表 等数据结构

     表等是具体存储数据的文件(普通表的本质仍然是文件)   根据数据库的 命令进行存储和调用  表中一般一行代表一条数据  一条数据代表一个对象

  总结：举个例子  mysql数据库大致原理相当于用 TDP编程一个应用程序在本机(服务端)开一个端口服务 根据sockets通道连接外部主机(客户端) 客户端可以发送指令  服务端进行解析  进行数据的存储和读取  其数据存储在本机(服务端)的文件夹(一个数据库)的文件中   数据库的本质是文件 数据持久化必须存储在文件(磁盘中)  

* Sql语句分类

  1. DDL  数据定义语句 如 [ create ] 定义表 库 字段
  2. DML  数据操作语句  如 [ insert  update  delete ] 增删改
  3. DQL 数据查询语句 如 [ select] 查询
  4. DCL  数据控制语句 [grant  revoke ] 用户及权限

  通过学习Sql语句可以通过java实现对mysql数据库的操作

### mysql常用语句

* 数据库相关 (DDL)

  1. create database dbname  创建数据库

     可选项 character set 指定数据库采用的字符集 若不指定 默认为 utf8 此外还有utf8mb4  (该字符集最大可表示4个字节)

     ​           collate 指定数据库字符集的校对规则 常用utf8_bin [区分大小写] utf8_general_ci [不区分大小写 默认] 

     ```sql
     #删除数据库指令
     DROP DATABASE db01
     #创建一个数据库指令
     CREATE DATABASE IF NOT EXISTS db01
     #创建指定字符集的数据库 默认校对规则为utf8_general_ci 不区分大小写
     create database db02 charACTER set utf8
     #创建指定校对规则的数据库 校对规则 utf8_bin区分大小写 
     create database db03 character set utf8 collate utf8_bin
     #规定数据库的字符集和校验规则在创建表时对应的为默认
     #区分大小写和不区分大小写就是表中数据是否当成一个看
     #搜索db02表中数据 name值为tom的 不区分大小写
     select * from user01 where name = 'tom'
     #搜索db03表中数据 name值为tom的 不区分大小写
     select * from user01 where name = 'tom'
     ```

  1. 查看 删除数据库
  
     show databases 查看当前数据库服务器中所有的数据库
  
     show create database dbname 查看指定数据库的信息
  
     反引号  `` 可以规避关键字 
  
     drop database 删除数据库 慎用
  
     ```sql
     #查看所有数据库
     show databases
     #查看指定创建的数据库详细信息
     show create database db03
     #``可以规避关键字
     create database `int` character set utf8 collate utf8_bin
     #删除数据库
     drop database `int`
     ```
  
  1. 数据库的备份和恢复
  
     备份整个数据库  mysqldump -u 用户名 -p  -B  数据库1 数据库2 > 文件名.sql  在命令行执行 (**注意命令行下指令不加分号 mysql命令行下命令加分号**)
  
     > 备份数据库的文件中存储的是一系列的sql指令 通过指令重新创建数据库 加入数据
     >
     > 注意：备份时一定要在cmd窗口执行 并且不进入mysql命令行系统 指定文件自动生成 不要自己创建文件
  
     恢复整个数据库  source 文件名.sql  在mysql命令行执行
  
     > 恢复数据库的指令实际上就是将备份的sql文件中的指令全部执行
     >
     > 注意： 恢复时一定要在cmd窗口执行 并且进入mysql命令行系统 
  
     备份数据库中的表 mysqldump -u 用户名 -p 数据库 表1 表2 > 文件名.sql 在命令行执行
  
     恢复数据库中的表  source 文件名.sql
  
     > 注意：恢复表时要在mysql命令下用use 指令转到对应的数据库下
  
     ```sql
     #备份数据库 cmd下
     mysqldump -u root -p -B db03 db02 > D:\VS项目\MySQL\learnmysql_7_8\source\bf.sql
     #恢复数据库 mysql下
     source D:\VS项目\MySQL\learnmysql_7_8\source\bf.sql
     #备份数据库中表 
     mysqldump -u root -p db02 user01 > c:\Mysofeware\MySQL\MySQLSource\biao.sql
     #恢复数据库中表
     source c:\Mysofeware\MySQL\MySQLSource\biao.sql
     ```
  
* 表相关

  1. 创建表

     create table table_name (field1 datatype，  ... ) character set 字符集 collate 校对规则  engine 存储引擎

     >长表名间用下滑线连接
     >
     >field 指定列名 datatype 指定列类型(字段类型)
     >
     >character set  跟随数据库默认   数据库默认 utf8
     >
     >collate 跟随数据库默认   数据库默认utf8_general_cin
     >
     >engine 引擎

     ```sql
     #在db01下创建表
     CREATE TABLE user01 (id INT,`name` VARCHAR(255),`password` VARCHAR(20),birthday DATE) CHARACTER SET utf8 COLLATE utf8_bin
     #在db02下创建表
     CREATE TABLE user02 (id INT,NAME VARCHAR(255),birstday VARCHAR(30)) CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB
     ```

  2. 表中常用数据类型(列类型)

     1. 数值类型
        1. 整形
           1. tinyint 一个字节
           2. smallint 两个字节
           3. mediumint 三个字节
           4. **int 四个字节**
           5. bigint 八个字节
        2. 小数类型
           1. float 单精度 四个字节
           2. **double 双精度 八个字节**
           3. **decimal[M,D] 大小不确定**
        3. 位类型
           1. bit(n) 1-64位 最高8字节 按二进制表示
     2. 文本类型 (字符串类型)
        1. **char(n) 0-255 可表示个字符**
        2. **varchar(n) 0-65535  2^16-1**
        3. **text 0-65535  2^16-1**
        4. mediumtext  0 - 2^24-1  
        5. long 0 - 2^32-1
        6. longtext  0 - 2^36-1
     3. 二进制类型
        1. blob 0-2^16-1
        2. longblob 0-2^32-1
     4. 日期类型
        1. year  年 一个字节
        2. date  日期类型  年月日  三个字节
        3. time   时间类型 时分秒 三个字节
        4. **datetime  年月日时分秒  YYYY MM DD HH mm ss**  八个字节
        5. **timestamp 时间戳** 四个字节
  
     >1. 数值类型 
     >
     > 以tinyint为例
     >
     > 表示范围为 默认为有符号数 -128 - 127    加上unsigned表示无符号数 1-255
     >
     > 可用insert into 表名 values(字段赋值) 的方式给表中添加数据 
     >
     > 可用select * from 表名 where 字段名 = "值" 方式来查询字段
     >
     >2. 位类型
     >
     > bit按二进制形式表示 可表示的位 0-64位 最高为8字节
     >
     > 用 bit(数字) 表示该bit类型表示的范围
     >
     > 赋值时用十进制赋值 转换成二进制表示
     >
     > 查询时仍可用十进制查询
     >
     >3. 小数类型
     >
     > 以decimal[M,D]为例
     >
     > M指表示数字的总位数最大为65  D表示小数位数最大为30
     >
     > M被省略 默认是10 D被省略 默认为为0  都被省略指最大为十进制十位数 
     >
     > 添加小数时若添加数小数位数较高 数据类型表示不完 则会四舍五入表示
     >
     > 添加小数时若添加数小数位数较低 数据类型表示时会在后面补0
     >
     >4. 字符串类型
     >
     >   1. 固定长度字符串：char(size) size的范围为 0-255字符 这里表示字符 最大可以表示255个字符的字符串
     >   2. 可变长度字符串：varchar(size) size的范围为 0-65535字节 这里表示字节 实际使用时填入65535就会报错 原因是  首先该字符串存储时会先拿1-3个字节来表示字段大小  实际表示字符的字节为 0-65532 其次字符表示并不都是一个字符占一个字节 使用gbk编码一个字符占两个字节 utf-8按字符串内容一个字符 1-3个字节  utf-8编码下size最大为21844(因为每个字符不一定是字母还是中文按 可存储的最小长度来算就是 存储的范围 每个字符预留3个字节)    size可填的范围按字符编码决定
     >
     >      tip：   SQLyog注释 ctrl + shift + c 取消 ctrl + shift + r
     >
     >      字符串再mysql中以单引号引起(控制台中双引号好像也可以)
     >
     >      **字符串类型使用细节：**
     >
     >   3. char(4)  4表示字节数 最大255  占用内存为4个字符内存的大小 无论存入的是否为4个字符 都会按4个字符的空间占用 是固定长度字符串
     >   4. varchar(4)  4 表示字符数表示可存入的最大字符数  占用内存是按编码计算的 最大占用内存为65532 内存占用按实际输入字符的内容变化也就是说 如果输入的是两个字符 就按两个字符和编码占用内存 此外 varchar还按字符串长度分配1-3个字节来记录存放内容的长度 实际占用的内存为 1-3字节 + 实际输入字符串根据编码占用的内存  (最大内存为65535)   是可变长度字符串 
     >   5. char 与 varchar的比较  如果存储的数据是定长 那么用char查询速度>varchar   varchar用于存储内容不定长的情况
     >   6. Text 2^16 数据类型可以用于替代varchar  除此之外还有 mediumtext  2^24  longtext  2^36  text不能有默认值 text存储内容的大小根据存储内容和字符编码决定 好像不需要用1-3个字符存储字段长度 
     >   7. varchar与text的比较 varchar限制字符串长度 需要用1-3个字节来记录字符串长度 text 不限制字符长度 不需用额外内存来记录字符长度
     >
     >5. 日期类型
     >
     >  ```sql
     >  #演示时间相关的数据类型  创建表
     >  create table user02 (birthday date,job_time datetime,login_time timestamp 
     >  	not null default current_timestamp on update current_timestamp);
     >  #not null default current_timestamp on update current_timestamp 该语句是设置时间为当前时间或更新时间
     >  #插入表中数据
     >  insert into user02(birthday,job_time) values('2022-11-11','2022-11-11 10:10:10');
     >  #若更新新表中某条信息 login_time 会自动的以当前时间进行更新
     >  select * from user02
     >  ```
     >
     >  日期类型好像就是特殊形式的字符串
     >
  
  3. 表的删除和修改
  
     1. 添加列
  
        alter table 表名 add 列名 数据类型 Not  null  default  ‘ ’  after resume 
  
     2. 修改列(数据类型)
  
        alter table 表名 modify 列名 数据类型 Not null default ' ' 
  
     3. 删除列
  
        alter teble 表名 drop 列名
  
     4. 修改表名
  
        rename table 表名 to 新表名
  
     5. 修改字符集
  
        alter table 表名 character set 字符集名称
  
     6. 修改列名(+ 数据类型)
  
        alter table 表名 change 列名 新列名 数据类型 Not null default ‘ ’
  
     7. 代码示例
  
        ```sql
        #显示所有列信息
        DESC user03
        #1. 添加列
        ALTER TABLE user03 ADD imange VARCHAR(30) NOT NULL DEFAULT '' AFTER RESUME
        #2. 修改列
        ALTER TABLE user03 MODIFY imange VARCHAR(20) NOT NULL DEFAULT ''
        #3. 删除列
        ALTER TABLE user03 DROP imange
        #4. 修改表名
        RENAME TABLE user03 TO user04
        RENAME TABLE user04 TO user03
        #5. 修改字符集
        ALTER TABLE user03 CHARACTER SET utf8
        ALTER TABLE user03 COLLATE utf8_general_ci
        ALTER TABLE user03 ENGINE INNODB
        #6. 修改列名 有修改列的功能
        ALTER TABLE user03 CHANGE `name` username VARCHAR(32) NOT NULL DEFAULT ''
        DESC user03 
        ```
  
* 数据库C[create]R[read]U[update]D[delete]语句 有关数据库中表的数据操作 (DML)

  1. insert语句

     insert into 表名 (列名...) values (数据名...) 

     ```sql
     #insert语句
     DESC user04
     DROP TABLE user04
     CREATE TABLE user04 (id INT,`name` VARCHAR(30),sex CHAR(3)) CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB
     INSERT INTO user04 (id,`name`,sex) VALUES(21231,'王维','男')
     INSERT INTO user04 VALUES(2321,'李白','女')
     SELECT * FROM user04
     ```

     细节

     1. 插入的数据应与字段的数据类型相同 如果数字使用用单引号引 也可以自动转换成数字来识别
     2. 数据的长度一个在列规定的范围 不能将超过列数据定义的长度添加到表中 (内存不够存储)
     3. 插入时values中的值顺序应该与列顺序相同 依次赋值
     4. 字符和日期类型的数据应该包含在单引号中 不然报错
     5. 列可以插入空值 前提是该字段允许为空   在定义列时有Not null来定义字段不允许为空
     6. intsert into 表名  (字段名)  values(),(),()... 可以一次添加多条信息
     7. 如果是给表中全部字段添加值 可以不写列名 如 insert into  表名  value()
     8. 默认值的使用 如果不给某个字段值时 如果没有定义Not null  不赋值默认给null  所有字段如果有默认值 不赋值默认值为默认值

  2. update语句

     1. 修改表中某一字段所有内容

        update 表名 set 字段名 = 值

     2. 修改表中某一字段的特定一条数据内容

        update 表名 set 字段名 = 值 where 字段 = 值

     3. 代码演示

        ```sql
        #update 语句
        UPDATE user04 SET id = 12345
        SELECT * FROM user04
        UPDATE user04 SET id = id + 1000 WHERE NAME = '王维'
        ```

     细节：

     1. update可以用新值更新原有表中的各列数据
     2. set 语句指定要修那些列和要赋予那些值
     3. where 语句用用于指定更新那些行 如果没有where 则更新所有行的记录所有一定要小心
     4. 如果要更改多个字段可以用 set 字段1 = 值1 ，字段2 = 值2... whrere 字段名 = 值

  3. delete语句

     1. 删除表的所有数据

        delete from 表名

     2. 删除表的特有的一条(行)数据 不存在删除一列数据

        delete from 表名 where 字段名 = 值

     3. 代码演示

        ```sql
        #delete 语句
        DELETE FROM user04
        DELETE FROM user04 WHERE NAME = '王维'
        SELECT* FROM user04
        ```

     细节：

     1. 如果不使用where语句 将删除表中所有数据
     2. 使用delete 语句不能删除表本身 可使用drop table 表名

* 有关数据库中表的数据操作 (DML) select语句

  1. 单表

     * select 基本语法

       select [distinct去重]  * /{col1, col2, 字段名} from 表名 (字段)代表单独一列
  
       distinct表示去重 若查询的数据有重复则不显示重复的
  
       *表示查询所有列数据  可指定查询那列数据显示
  
       ```sql
       #select 语句
       #查询表中所有列信息
       SELECT * FROM student
       #查询表中所有学生姓名和英语成绩信息
       select name,english from student
       #过滤查询得到表中行信息相同的信息内容
       select distinct english from student
       #查询的记录 每个字段都相同 才判定为相同
       SELECT DISTINCT * FROM student
       ```
  
     * sleect查询运算后的数据
  
       select 字段名 运算符 字段名 from 表名
  
       select 字段名 运算符 字段名 as 别名 from 表名
  
       指定查询那列是可以将字段进行运算符的处理 as 可以在显示时给字段起一个别名 也可以不用 直接在后面加上别名
  
       ```sql
       #查询所有同学的总分
       SELECT NAME,(chinese+english+math) AS total FROM student
       SELECT NAME,(chinese+english+math)  total FROM student
       SELECT NAME,(chinese+english+math) AS "total grade" FROM student (双引号)
       SELECT NAME,(chinese+english+math)  "total grade" FROM student
       #查询给所有同学总分加10分的情况
       select name, chinese+english+math +10 as total from student
       ```
  
     * select查询限定后的数据   -   where 子句中经常使用的运算符
  
       比较运算符    >       <        <=      >=     =     !=      <>(等同于 !=用于判断值是否不相等)     between and (显示在某一区域的值是闭区间)  in(set)  - 显示在in列表中的值  like (模糊查询)      Not like  (模糊查询)    is  null (判断是否为空)

       逻辑运算符 and(相当于&&)    or(相当于||)    not (相当于!)

       ```sql
       #where 子句的运算符
       #查询姓名为赵云的同学信息
       SELECT * FROM student WHERE NAME = '赵云'
       #查询英语成绩大于90 分的同学
       SELECT * FROM student WHERE english>90
       #查询总分大于200分的同学 
       SELECT * FROM student WHERE chinese + math + english > 200
       SELECT * FROM student WHERE math > 60 AND math<90 -- between and 使用时 between 后跟小值 and后跟大值
       SELECT * FROM student WHERE english > chinese
       #模糊查询%表示0-多个 表示以韩开头的
       SELECT * FROM student WHERE chinese + math +english>200 AND math<chinese AND NAME LIKE '赵%'
       #between and 表示闭区间
       SELECT * FROM student WHERE chinese BETWEEN 50 AND 60
       #in 查询表示等于()中的内容的
       SELECT * FROM student WHERE math IN(89,90,91)
       ```
  
     * select 查询 排序后的数据
  
       order by  字段  asc/desc
  
       asc 表示升序 desc表示降序

       ```sql
       #order by排序
       SELECT * FROM student ORDER BY chinese ASC
       SELECT NAME ,(chinese + math + english) AS total FROM student ORDER BY total DESC
       SELECT * FROM student ORDER BY (chinese + math)
       ```

     * 聚合函数 将一列数据作为一个整体 进行纵向计算 count max min avg  sum

       * count 函数

         select count(* / 列字段) from 表名 where 限定条件

         count(*)  返回满足条件的记录的行数

         统计满足条件的列的总数 但会排除为null的情况

         count(*) *是指表中所有的字段 一行字段有一个不为空 则count+1  列字段好像只能放一个 如果列字段的值不为null 这时conut+1 count返回满足条件(列字段内容不为空) 的行数 应是生成表后统计值 如
  
         ```sql
         #count 函数
         SELECT COUNT(*) FROM student WHERE math > 60 
         #这里好像是先生成 select * from student where math > 60 后再统计
         SELECT COUNT(NAME) FROM student WHERE math > 60
         #这里好像是先生成 select name from student where math > 60 后再统计
         ```
         
       * sum函数
  
         select sum(数值列) from 表名 where ...
  
         sum(字段名) 表示返回列的数值总和 可以加上限制条件
  
          字段应为数值型 不然没有意义( 字符串返回0 不会报错)
  
         ```sql
         #sum函数
         SELECT SUM(math) FROM student
         SELECT SUM(NAME) FROM student
         //聚合函数列的行数要与查询列的行数相匹配
         ```
  
       * avg 函数
  
         select ava(字段名) from 表名 where..
  
         sum(字段名) 表示返回列的数值平均数 可以加上限制条件
  
          字段应为数值型 不然没有意义(不会报错)
  
         ```sql
         #avg函数
         SELECT AVG(math) FROM student
         SELECT AVG(NAME) FROM student
         ```
  
       * max min 函数
  
         select max min(字段名) from 表名 where..
  
         max min(字段名) 表示返回列的数值最大最小值 可以加上限制条件
  
          字段应为数值型 不然没有意义(不会报错)
  
         ```sql
         #max min 函数 
         select max(english) from student
         SELECT min(english) FROM student
         ```
  
     * group by  + having 语句 分组统计
  
       select 查询显示内容 from 表名 group by 字段名1，字段名2，having 过滤条件
  
       分组语句的逻辑： 表列(字段)有的可能是重复的组标 根据这些重复(或者不重复)可以用group by 进行分组  分组后查询显示内容也就是列字段(显示内容必须和分组后的数据能叠加一致 不然会因行与行不对应而报错) 得到对应的显示的表  最后 可以用having语句对得到的表进行筛选 得到想要的表
  
       分组可以使用多列进行分组
  
       ```sql
       # 查询部门中工资平均数和最大数
       SELECT * FROM emp
       SELECT AVG(sal),MAX(sal),deptno FROM emp GROUP BY deptno
       #查询每个部门目的每种岗位的平均工资和最低工资
       SELECT deptno,job,AVG(sal),MIN(sal)FROM emp GROUP BY deptno,job
       #显示平均工资低于2000的部门号和它的平均工资
       SELECT deptno,AVG(sal) AS avgsal FROM emp GROUP BY deptno HAVING avgsal<2000 
       
       # group by having 与 where 的区别和联系
       -- 使用语法 select 字段 from 表名 where 条件 group by 分组字段名
       --  区别
       -- 1. 执行时机不同 where是分组前进行过滤 不满足where条件 不参与分组 而having是分组之后对结果进行过滤
       -- 2. 判断条件不同 where 不能用聚合函数进行判断 而having可以
       -- 3. 执行顺序 where > 聚合函数 > having 
       ```
  
     * 字符串函数相关
  
       ```sql
       #演示字符串相关函数的使用 
       #1. charset(str) 返回字符串集
       select charset(ename) from emp
       #2. concat(字段1,字段2,...) 连接子串 将多个列拼成一列
       select concat(ename,'工作是',job) from emp
       #3. instr(str,sub) 返回sub在str中的出现位置从1开始 没有出现返回0
       #dual 亚元表 系统表 可以作为测试表使用
       select instr('abcdef','def') from dual 
       #4. ucase(字段) 转成大写
       select ucase(ename) from emp
       #5. lcase(字段) 转成小写
       select lcase(ename) from emp
       #6. left(str,len) 从左边取len个字符
       select left('hhh',2) from dual
       select left(ename,2) from emp
       #7. right(str,len) 从左边取len个字符
       SELECT right(ename,2) FROM emp
       #8. length(str) 返回str的字节长度
       select length(ename) from emp
       #9. replace(字段,search_str,replace_str) 查询字段 如果是search_str 替换成replace_str。就是包含where字句的查询时的update替换 update emp set job = replace_str where job = search_str
       select ename,replace(job,'MANAGER','经理') from emp
       #10. strcmp(str1,str2) 判断字符是否相同 返回值和java中字符串equals相同 比较按表的校验规则计算来看是否区分大小写
       select strcmp('hh','hh') from dual
       SELECT STRCMP(job,'hh') FROM emp
       #11. substring(str,start,end) 从str的第start位置 取到第end个位置若end不写则取到最后所有的字符 闭区间 并且字符串下标从1开始
       select substring('abcd',1,3) from dual
       select substring(ename,1,3) from emp 
       #12. ltrim() rtrim()  trim() 去掉 左 右 两边的空格 trim函数不会去除中间空格 
       select ltrim('  hh') from dual
       select rtrim('hh  ') from dual
       select trim('  hh  ') from dual
       #13  lpad() rpad(str1，num，str2) 左右填充 str1不足num位的话左填充str1 填充到长度为4  str2过长只会使用前面部分
       select rpad('a',3,'df') from dual 
       #以首字母小写的形式显示所有员工表的姓名
       select concat(lcase(substring(ename,1,1)),substring(ename,2)) from emp
       select concat(lcase(left(ename,1)),substring(ename,2,100)) from emp
       ```
  
     * 数学函数相关
  
       ```sql
       #数学相关函数
       #1. abs(num) 求num的绝对值
       SELECT ABS(-2) FROM DUAL 
       #2. bin(num) num十进制转二进制
       SELECT BIN(34) FROM DUAL
       #3. ceiling 向上取整
       SELECT CEILING(3.2) FROM DUAL
       #4. floor 向下取整
       SELECT FLOOR(4.9) FROM DUAL
       #5. conv(num,form_base,to_base) num 是 from_base进制的数 转换成 to_base进制的数
       SELECT CONV(32,16,10) FROM DUAL
       #6. format(num,decimal_num) num 保留 decima_num位的小数
       SELECT FORMAT(3.223123,3) FROM DUAL
       #7. hex(num) num 转十六进制
       SELECT HEX(89) FROM DUAL
       #8. least(num1,num2,num3...) 求最小值  most 求最大值
       SELECT LEAST(2,56,782,1,4) FROM DUAL
       #9. mod(num,deom) num%deom 的值
       SELECT MOD(5,2) FROM DUAL
       #10. rand(num) 返回随机数 范围是0-1.0 num为种子 给定始终返回固定值
       SELECT RAND() FROM DUAL
       #11， round(num,value) 四舍五入 并保留value为小数
       select round(33.22,0) from dual -- 返回0
       ```
  
     * 时间函数类
  
       ```sql
       #时间日期类
       #1. current_date() 当前日期 年月日 (为当前日期)
       SELECT CURRENT_DATE() FROM DUAL
       #2. current_time() 当前时间 时分秒 (时间？不对)
       SELECT CURRENT_TIME() FROM DUAL
       -- 注意： 以上两个函数可以简写成 curdate() 和 curtime()
       #3. current_timestamp() 当前时间戳
       #   now() 当前时间 和时间戳格式一样是年月日时分秒
       SELECT CURRENT_TIMESTAMP() FROM DUAL
       DROP TABLE news
       CREATE TABLE news(id INT, `position` VARCHAR(255), times DATETIME)
       INSERT INTO news VALUE(1,'北京新闻',NOW());
       INSERT INTO news VALUE(1,'天京新闻',NOW());
       INSERT INTO news VALUE(1,'湖北新闻',NOW());
       
       #取段格式化日期
       #1. date(datetime) 函数可以返回日期部分 年月日
       #   year() month() day() 返回 年 月 日
       #显示所有新闻信息 发布日期值显示 日期 不显示时间
       SELECT id,`position`,DATE(times) FROM news
       #日期加减函数 返回时间格式和传入格式一样
       #2. date_add(time,interval_time) 返回time加上interval_time后的时间
       #   date_sub(time,interval_time) 返回time减去interval_time后的时间
       #interval_time 可以是 year month day hour minute second
       #time类型可以是date类型 或者是datetime类型  timestamp类型 返回的是对应的原类型
       #查询10分钟内发布的信息
       SELECT * FROM news WHERE DATE_ADD(times,INTERVAL 10 MINUTE) >= NOW()
       SELECT * FROM news WHERE DATE_SUB(NOW(),INTERVAL 10 MINUTE) <= times
       #日期求差函数 分返回差天数的和差时分秒(时间)的
       #3. datediff(date1,date2) date1 和 date2 所差的天数
       #   timediff(time1,time2) time1 和 time2 所差的时分秒数
       #   time date 类型可以的date类型 或者是datetime类型  timestamp类型
       #   求出2011-11-11 和 19909-1-1 相减的天数
       SELECT DATEDIFF('2011-11-11','1990-1-1') FROM DUAL
       SELECT DATEDIFF('10:11:11','10:11:10') FROM DUAL
       #4. last_day(date_time)  返回date_time 当月的最后一天
       #当hiredate为该月的倒数第三天时
       select * from emp where last_day(hiredate) - 2 = hiredate 
       
       #用sql语句求出你活了多少天
       SELECT DATEDIFF(CURRENT_DATE(),'2003-9-23') FROM DUAL
       #如果你能活80岁 还能活多少天
       SELECT DATEDIFF(DATE_ADD('2003-9-23',INTERVAL 80 YEAR),CURRENT_DATE()) FROM DUAL
       
       #5. unix_timestamp() 返回距离1970-1-1 到现在的秒数
       SELECT UNIX_TIMESTAMP() FROM DUAL 
       #6. from_unixtime() 可以把一个unixtime秒数 转换成指定格式的日期
       #   意义为可以将时间同一按成秒数存储 采用此方法来获取具体日期
       SELECT FROM_UNIXTIME(UNIX_TIMESTAMP(),'%Y-%m-%d-%H-%i-%s') FROM DUAl
       ```
  
     * 加密和系统函数
  
       ```sql
       #1. user() 查询用户 可以查看登录mysql有哪些用户 以及登录的ip  用户名@ip地址
       SELECT USER() FROM DUAL
       #2. database() 查询当前使用数据库的名称
       SELECT DATABASE() FROM DUAL
       #3. md5(str) 为字符串算出一个md5 32 的字符串 常用(用户密码)加密
       #生成的密码为char(32)的字符串
       SELECT MD5('xing123456') FROM DUAL
       CREATE TABLE user05 (NAME VARCHAR(32),passwd CHAR(32));
       INSERT INTO user05 VALUES('ll',MD5('xing123456'));
       SELECT * FROM user05 WHERE passwd = MD5('xing123456');
       #4. password(str) 加密函数 mysql数据库的密码就是用该函数加密
       #库名 + 表名 可以不更改所在数据库位置 直接查询数据库对应的表
       SELECT * FROM mysql.user 
       SELECT PASSWORD('xing123456') FROM DUAL
       ```
  
     * 流程控制函数
  
       ```sql
       #流程控制函数
       
       #1. if(expr1,expr2,expr2) 三元运算符
       SELECT IF(TRUE,'背景','上海') FROM DUAL
       #2. ifnull(expr1,expr2) 如果expr1为空返回expr2 否则返回expr1
       SELECT IFNULL(NULL,'hh') FROM DUAL
       #3.多分支语句 (case [字段] when expr1 then expr2 when expr3 then expr4 else expr5 end)
       -- 两种形式 
        -- 1. (case 字段 when expr1 then expr2 when expr3 then expr4 else expr5 end) 相当于
        -- if(字段 == expr1) expr2 else if(字段 == expr3) expr4 else expr5
        -- 2. (case when expr1 then expr2 when expr3 then expr4 else expr5 end) 相当于
        -- 多分支语句 if(expr1) expr2 else if(expr3) expr4 else expr5
       
       #查询emp表 如果comm为空 (判断为为空使用is 不为空 isnot 其他判断相等用 = 不等使用!= 没有==符号的使用) 则显示0.0
       SELECT ename, IF(comm IS NULL,0.0,comm) AS comm FROM emp 
       SELECT ename, IFNULL(comm,0.0) AS comm FROM emp
       #查询表 如果job 是clerk 显示职员 如果是manager 显示经理 如果salesman 显示销售人员
       SELECT ename, job,(SELECT CASE 
       		WHEN job = 'CLERK' THEN '职员' 
       		WHEN job = 'MANAGER' THEN '经理' 
       		WHEN job = 'SALESMAN' THEN '销售人员' 
       		ELSE job END) AS job FROM emp;
       ```
  
     * 加强
  
       ```sql
       # 查询加强
       # 如何查找 1992.1.1 后入职的员工
       SELECT * FROM emp WHERE hiredate > '1992-01-01';
       #如何使用 like 操作符(模糊)
       #%: 表示 0 到多个任意字符 _: 表示单个任意字符
       #  显示首字符为 S 的员工姓名和工资
       SELECT ename, sal FROM emp WHERE ename LIKE 'S%';
       #  显示第三个字符为大写 O 的所有员工的姓名和工资
       SELECT ename, sal FROM emp WHERE ename LIKE '__O%';
       #  如何显示没有上级的雇员的情况
       SELECT ename, sal FROM emp WHERE mgr IS NULL;
       #查询表结构
       DESC emp
       
       #使用 order by 子句
       #按照工资的从低到高的顺序[升序]，显示雇员的信息
       SELECT * FROM emp ORDER BY sal ASC
       #按照部门号升序而雇员的工资降序排列 , 显示雇员信息
       SELECT * FROM emp ORDER BY deptno ASC , sal DESC;
       ```
  
     * 分页查询
  
       select  ...  limit start , row   返回从start +1行开 取row行的 数据  
  
       公式 ：limit 每页显示的记录数 * 第几页-1 ，每页显示的记录数
  
       start从0开始    
  
       ```sql
       -- 分页查询
       -- 按雇员的 id 号升序取出， 每页显示 3 条记录，请分别显示 第 1 页，第 2 页，第 3 页
       -- 第 1 页
       SELECT * FROM emp
       ORDER BY empno
       LIMIT 0, 3;
       -- 第 2 页
       SELECT * FROM emp
       ORDER BY empno
       LIMIT 3, 3;
       -- 第 3 页
       SELECT * FROM emp
       ORDER BY empno
       LIMIT 6, 3;
       -- 推导一个公式
       SELECT * FROM emp
       ORDER BY empno
       LIMIT 每页显示记录数 * (第几页-1) , 每页显示记录数
       
       #按雇员的empno号降序取出 每页有5条记录  显示第3页 第5页
       SELECT * FROM emp ORDER BY empno DESC LIMIT 10,5;
       SELECT * FROM emp ORDER BY empno DEC LIMIT 20,5
       ```
  
     * 增强group `by`
  
       ```sql
       #增强 group by 的使用
       -- (1) 显示每种岗位的雇员总数、平均工资。
       SELECT COUNT(*), AVG(sal), job FROM emp GROUP BY job;
       -- (2) 显示雇员总数，以及获得补助的雇员数。
       
       -- 思路: 获得补助的雇员数 就是 comm 列为非 null, 就是 count(列)，如果该列的值为 null, 是不会统计的
       SELECT COUNT(*), COUNT(comm) FROM emp
       -- 扩展要求：统计没有获得补助的雇员数
       SELECT COUNT(*), COUNT(IF(comm IS NULL, 1, NULL))
       FROM emp
       SELECT COUNT(*), COUNT(*) - COUNT(comm)
       FROM emp
       -- (3) 显示管理者的总人数。小技巧:尝试写->修改->尝试[正确的]
       SELECT COUNT(DISTINCT mgr)
       FROM emp;
       -- (4) 显示雇员工资的最大差额。
       -- 思路： max(sal) - min(sal)
       SELECT MAX(sal) - MIN(sal)
       FROM emp;
       SELECT * FROM emp;
       select * from dept;
       ```
  
     * select子句的优先顺序  
  
       1. 编写顺序 
  
          select from where group by having order by limit
  
       2. 执行顺序 from   where   group by    select    order by  limit
  
          > 1. `FROM`子句：确定要查询的表或视图。
          > 2. `WHERE`子句：对表中的行进行筛选，根据指定的条件过滤数据。
          > 3. `GROUP BY`子句：按指定的列对结果进行分组。
          > 4. `HAVING`子句：对分组后的结果进行筛选，根据指定的条件过滤数据。
          > 5. `SELECT`子句：选择要返回的列
          > 6. `ORDER BY`子句：对结果进行排序。
          > 7. `LIMIT`或`OFFSET`子句：限制返回的结果数量或跳过指定数量的结果
       
       ```sql
       -- 应用案例：请统计各个部门 group by 的平均工资 avg，
       -- 并且是大于 1000 的 having，并且按照平均工资从高到低排序， order by
       -- 取出前两行记录 limit 0, 2
       SELECT AVG(sal) AS sal,deptno FROM emp GROUP BY deptno HAVING sal>1000 ORDER BY sal ASC
       LIMIT 0,2;
       ```
  
  2. 多表
  
    * 多表查询基本介绍
      1. 不加条件的多表查询的结果为 会将第一张表的一行 与第二张表的每一行相拼接 然后组成多条记录
  
      2. 最终组成的表的行数为第一张表的行数* 第二张表的行数 
  
      3. 最终组成的表的列数为第一张表的列数+ 第二张表的列数
  
      4. 这样的处理返回的结果称为笛卡尔积
  
      5. 得出多表合适信息的关键就是写出多表的过滤条件
  
      6. 表名.列名可以指定指示某一个表中的特定列 数据库.表 可以指定指示某一个数据库中特定的表  表名.*表示该表中的所有字段(列)
  
         ```sql
         -- 多表查询
         -- ?显示雇员名,雇员工资及所在部门的名字 【笛卡尔集】
         /*
         老韩分析
         1. 雇员名,雇员工资 来自 emp 表
         2. 部门的名字 来自 dept 表
         3. 需求对 emp 和 dept 查询 ename,sal,dname,deptno
         4. 当我们需要指定显示某个表的列是，需要 表.列表
         */
         SELECT ename,sal,dname,emp.deptno FROM emp, dept WHERE emp.deptno = dept.deptno
         SELECT * FROM emp,dept;
         SELECT * FROM salgrade,emp;
         -- 小技巧：多表查询的条件不能少于 表的个数-1, 否则会出现笛卡尔集
         #如何显示部门号为 10 的部门名、员工名和工资
         SELECT dname,ename,sal FROM emp,dept WHERE emp.deptno = dept.deptno AND dept.deptno = 10
         #显示各个员工的姓名，工资，及其工资的级别
         SELECT ename,sal,grade FROM emp,salgrade WHERE sal BETWEEN losal AND hisal
         #显示雇员名 雇员工资 也所在部门的名字 并按部门排序
         SELECT ename,sal,dname FROM emp,dept WHERE emp.deptno = dept.deptno ORDER BY dname DESC
         ```
  
    * 概述
  
      <img src="img\image-20230905180600104.png" alt="image-20230905180600104" style="zoom:50%;" />
  
    * 自连接  (可以是内连接 也可以是外连接) 
  
      将同一张表当做两张表使用 通常可以自连接的表不同行的某两列有联系
  
      from 表1 名1，表2 名2 用同一张表要使用别名 直接在后面加上别名 不然报错
  
      ```sql
      #自连接
      #显示公司员工名字和他的上级的名字
      SELECT worker.ename,boss.ename FROM emp worker,emp boss WHERE worker.mgr = boss.empno
      -- 细节: 表起了别名就不能在使用原表名
      -- 连接表时 where 条件在连接后 --- on 条件 where 条件
      ```
  
    * 外连接
  
      外连接分为左外连接 和右外连接 常用于多表查询数据不匹配时仍需显示不匹配数据的情况
  
      左外连接就是左表无论是否与右表匹配始终会显示完全内容 不匹配的字段显示为null
  
      右外连接就是右表无论是否与左表匹配始终会显示完全内容 不匹配的字段显示为null
  
      ```sql
      #左外连接
      SELECT NAME,stu.id, grade FROM stu LEFT JOIN exam ON stu.id = exam.id;
      #右外连接
      SELECT NAME,exam.id, grade FROM stu RIGHT JOIN exam ON stu.id = exam.id;
      #列出部门名称和这些部门的员工信息(名字和工作)，练习
      #同时列出那些没有员工的部门名
      SELECT * FROM dept
      SELECT * FROM emp
      #左连接
      SELECT ename, job,sal,dept.deptno,dname,loc FROM dept LEFT JOIN emp ON emp.deptno = dept.deptno
      #右连接
      SELECT ename, job,sal,dept.deptno,dname,loc FROM emp RIGHT JOIN dept ON emp.deptno = dept.deptno
      
      # 内连接和外连接中细节 []为可选写
      -- 使用连接 join语法必须用on
      -- 内连接实际语句 为 select 字段 from t1 [inner] join t1 on 条件
       -- 上为 显式内连接
      -- 一般使用 select 字段 from t1,t2 where 条件
       -- 上为 隐式内连接
      -- 外连接 实际语句 为 select 字段 from t1 left/right [outer] join t2 on 条件
       -- 上为 显式左/右外连接
      -- 一般使用 select 字段 from t1 left/right join t2 on 条件
       -- 上为 隐式左/右外连接
      ```
  
    * 子查询
  
      子查询是指嵌入在其它 sql 语句中的 select 语句,也叫嵌套查询
  
      select 语句单独执行可以当成查询语句  用做子句用(select...)可以当成具体一个数值(单行子查询) 多个具体数值(多行子查询)   临时表(多行多列子查询)  单行多列不同字段值 (多列子查询)  多行多列子查询
  
      1. 单行(单列)子查询 -- 标量子查询
  
         ```sql
         #显示与 SMITH 同一部门的所有员工
         SELECT * FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ename='SMITH')
         ```
  
      2. 多行(单列)子查询  -- 列子查询
  
         多行子句返回多个结果 常用 in函数表示在其中结果中
  
         ```sql
         #显示部门编号为10的员工的工作相同的员工信息 但不含10 号部门自己的
         SELECT * FROM emp WHERE job IN(SELECT DISTINCT job FROM emp WHERE deptno = 10) AND deptno != 10
         ```
  
         子查询中all any的使用  (常与多行单列子查询配合使用)
  
         ```sql
         #all的使用
         #显示工资比部门 30 的其中所有员工的工资高的员工的姓名、工资和部门号
         select ename,sal,deptno from emp where sal > 
         		all(select sal from emp where deptno = 30 )
         SELECT ename,sal,deptno FROM emp WHERE sal > 
         		(SELECT max(sal) FROM emp WHERE deptno = 30 )
         
         #any的使用 (与some相同)
         #显示工资比部门 30 的其中一个的工资高的员工的姓名、工资和部门号
         select ename,sal,deptno from emp where sal > 
         		any(select sal from emp where deptno = 30 )
         select ename,sal,deptno from emp where sal > 
         		(select min(sal) from emp where deptno = 30 )
         ```
  
      3. (单行)多列子查询 -- 行子查询
      
         用(字段1，字段2 )  = (多列子查询语句) 进行查询结果的使用
      
         ```sql
         #查询与 allen 的部门和岗位完全相同的所有雇员(并且不含 allen 本人)
         SELECT * FROM emp WHERE 
         	(deptno,job) = (SELECT deptno,job FROM emp WHERE ename = 'ALLEN') 
         	AND ename !='ALLEN';
         SELECT * FROM student WHERE (math,english,chinese) =
         	(SELECT math,english,chinese FROM student WHERE NAME = '宋江')
         	AND NAME != '宋江';
         ```
      
      4. 子查询当做临时表使用 (多行多列子查询)  -- 表子查询
  
         子查询语句当成表使用时 要用括号括起来然后在后面 起名
  
         ```sql
         #查询各个类别中价格最高的商品
         #1. 查最高价和种类
         #2. 根据自连接得出结果
         #显示商品类比中最高价的临时表1
         SELECT cat_id,MAX(shop_price) AS max_price FROM ecs_goods GROUP BY cat_id
         #根据临时表查询
         SELECT goods_name,shop_price FROM (SELECT cat_id,MAX(shop_price) AS max_price FROM ecs_goods GROUP BY cat_id) max_price_table,ecs_goods
         	WHERE max_price_table.cat_id = ecs_goods.cat_id AND 
         	max_price_table.max_price = ecs_goods.shop_price; 
         ```
  
         临时表(多行多列子查询)的使用练习
  
         ```sql
         #查询与 allen 的部门和岗位完全相同的所有雇员(并且不含 allen 本人)
         SELECT * FROM emp WHERE 
         	(deptno,job) = (SELECT deptno,job FROM emp WHERE ename = 'ALLEN') 
         	AND ename !='ALLEN';
         SELECT * FROM student WHERE (math,english,chinese) =
         	(SELECT math,english,chinese FROM student WHERE NAME = '宋江')
         	AND NAME != '宋江';
         	
         SELECT * FROM emp
         SELECT * FROM dept
         #查找每个部门工资高于本部门平均工资的人的资料
         SELECT AVG(sal) AS avg_sal,deptno FROM emp GROUP BY deptno
         SELECT empno,job,mgr,hiredate,sal,comm,emp.deptno FROM emp, (SELECT AVG(sal) AS avg_sal,deptno FROM emp GROUP BY deptno) avg_emp
         		WHERE sal>avg_sal AND avg_emp.deptno = emp.deptno;
         		
         #查找每个部门工资最高的人的向详细信息
         SELECT deptno , MAX(sal) AS max_sal FROM emp GROUP BY deptno
         SELECT empno,job,mgr,hiredate,sal,comm,emp.deptno FROM emp,(SELECT deptno , MAX(sal) AS max_sal FROM emp GROUP BY deptno) max_emp
         		WHERE max_emp.deptno = emp.deptno AND max_sal = sal;
         		
         SELECT deptno,COUNT(*) AS numb FROM emp GROUP BY deptno
         SELECT dname,loc,dept.deptno,numb FROM dept,(SELECT deptno,COUNT(*) AS numb FROM emp GROUP BY deptno) num_table
         	WHERE dept.deptno = num_table.deptno;
         ```
  
      5. 表的自我复制(蠕虫复制)和去重
  
         ```sql
         #表的自我复制(蠕虫复制)
         CREATE TABLE tab01 (NAME VARCHAR(32), job VARCHAR(32),sal DOUBLE,deptno INT)
         #这里是将emp表中的每一条字段插入tab01表中  省去了values() 
         #这里select字句看做是多行的单行多列子查询
         INSERT INTO tab01 SELECT ename,job,sal,deptno FROM emp
         INSERT INTO tab01 SELECT * FROM tab01
         SELECT * FROM tab01	
         #表的去重
         #使用like可以创建一个和指定表结构相同的表
         create table temp_tab like tab01;
         insert into temp_tab select distinct * from tab01;
         delete from tab01;
         insert into tab01 select * from temp_tab;
         drop table temp_tab;
         select * from tab01
         ```
  
      6. 表的联合
  
         ```sql
         #表的联合
         SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
         SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3
         -- union all 就是将两个查询结果合并，不会去重
         SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
         UNION ALL
         SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3
         -- union 就是将两个查询结果合并，会去重
         SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
         UNION
         SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3
         -- 细节
         # union all 和 union 联合的列必须相同 并且联合查询一定程度上可以用 or || 取代
         ```

### mysql约束

约束用于确保数据库的数据满足特定的商业规则  在mysql中 约束包括not null，unique，primary key，foreign key，check五种 

(唯一)约束与索引的关系 索引和约束有特定的删除指令 在规范上应使用特定的组  但好像也可以用删除索引的方式删除约束 也可以通过删除约束的方式删除索引  添加一样相同 故唯一约束添加方法 可以添加索引来生成 也可以添加约束来生成索引

* 主键约束 (primary key)

  列上定义了唯一约束后该列只不能重复和为空

  ```sql
  #主键使用
  CREATE TABLE t17(id INT PRIMARY KEY,`name` VARCHAR(32), email VARCHAR(32));
  -- 主键列的值是不可以重复
  INSERT INTO t17 VALUES(1, 'jack', 'jack@sohu.com');
  INSERT INTO t17 VALUES(2, 'tom', 'tom@sohu.com');
  #主键使用的细节讨论
  #1. primary key 不能重复而且不能为 null。(插入数据不能不赋值 并且不能赋值null)
  INSERT INTO t17 VALUES(NULL, 'hsp', 'hsp@sohu.com');
  #2. 一张表最多只能有一个主键, 但可以是复合主键(比如 id+name 不允许两个值同时相同 并且定义主键式采用第二种方式) 
  CREATE TABLE t18 (id INT ,`name` VARCHAR(32), email VARCHAR(32),PRIMARY KEY(id,NAME));
  #3. 主键的指定方式 有三种
  -- 1. 直接在字段名后指定：字段名 primary key
  -- 2. 在表定义最后写 primary key(列名);
  -- 3. alter table t1 add primary key (字段)
  -- 非规范索引式添加法
    -- 暂时认定主键不分索引和约束
  # 删除的方式 一种 (规范删除)
  -- 1. alter table t1 drop primary key
  -- 非规范索引式删除法
   -- -- 暂时认定主键不分索引和约束
  #
  CREATE TABLE t19 (id INT ,`name` VARCHAR(32) PRIMARY KEY, email VARCHAR(32));
  CREATE TABLE t20 (id INT ,`name` VARCHAR(32) ,email VARCHAR(32),PRIMARY KEY(`name`) -- 在表定义最后写 primary key(列名)
  #4. 使用 desc 表名，可以看到 primary key 的情况
  #5. 实际开发时 每个表中往往都会设计一个主键
  ```

* 非空约束 not null 与默认约束 default

  在列上定义了not null 表示在插入数据时 必须为该行提供数据(没有插入数据前 就没有该值 插入数据就必须有值 并且不能给值为null 常与default 组合使用) not null 指插入数据时 不允许为null 但在默认值为 null 不赋值的情况下仍可为 null 所有字段不指定默认值都为 null   非空约束和默认约束 可以用修改列的属性值来添加和删除

  ```sql
  #  即 alter table modiefy 字段名 属性 非空约束 默认约束限定
  ```

* 唯一约束  unique

  列上定义了唯一约束后该列只不能重复 

  (唯一)约束与索引的关系 索引和约束有特定的删除指令 在规范上应使用特定的组  但好像也可以用删除索引的方式删除约束 也可以通过删除约束的方式删除索引  添加一样相同 故唯一约束添加方法 可以添加索引来生成 也可以添加约束来生成索引

  ```sql
  #-- unique 的使用
  #unqiue 使用细节
  #1. 如果没有指定 not null , 则 unique 字段可以有多个 null
  #   如果一个列(字段)， 是 unique not null 使用效果类似 primary key
  INSERT INTO t21 VALUES(NULL, 'tom', 'tom@sohu.com');
  SELECT * FROM t21;
  #2. 一张表可以有多个 unique 字段
  CREATE TABLE t22 (id INT UNIQUE , `name` VARCHAR(32) UNIQUE , email VARCHAR(32));
  DESC t2
  
  #3 唯一约束的添加方式
  -- 1. 直接创建表时在字段后面添加
  -- 2. alter table t1 add unique (字段名)
  -- 非规范索引式添加
  -- 1. alter table t1 add unique index (字段名)
  -- 2. create unique index unique_index on t1 (id)
  # 唯一约束的删除方式
  -- 1. drop CONSTRAINT 未知--???
  -- 非规范索引式删除
  -- 2  drop index 唯一约束名 on t1
  ```

* 外键约束 foreign key

  外键约束 用于定义主表和从表之间的关系 使主表和从表之间绑定联系 通过 foreign key(字段) references 主表(主表字段) 建立联系

  注意 外键没有索引 故不区分索引和约束

  ```sql
  #外键约束
  #创建主表
  CREATE TABLE tab_class (class_id INT PRIMARY KEY,class_type VARCHAR(32),loc VARCHAR(32))
  #创建从表
  CREATE TABLE tab_stu (id INT, NAME VARCHAR(32),stu_id INT ,FOREIGN KEY (stu_id) REFERENCES tab_class(class_id)) 
  INSERT INTO tab_class VALUES(100,'java','北京')
  INSERT INTO tab_class VALUES(200,'php','天津')
  INSERT INTO tab_stu VALUES(1,'王五',100)
  # 300因外键约束无法添加
  INSERT INTO tab_stu VALUES(2,'李四',300)
  #外键约束细节
  #1. 外键指向的的主表的字段必须是primary key 或者是 unique 保证指向唯一
  #2. 外键字段的类型要和主表中联系的字段类型相同(长度可以不同)
  #3. 实现外键约束的表的存储引擎必须是innodb
  #4. 一旦从表外键和主表建立联系 主表中建立联系的行不能删除 除非将从表中与该行有联系的行全部删除
  #5. 从表添加数据的外键字段必须在主表中的联系字段存在 不然无法添加
  #6. 从表中添加数据的外键字段可以为null 前提是该字段允许为空
  
  #添加外键约束
  alter table 表名 add constraint foreign key(外键字段名) references 主表(主表列名)
  #删除外键约束
  alter table t1 drop foreign key 外键名
  ```

  外键删除和更新行为

  ![image-20230905162924296](img\image-20230905162924296.png)

  外键默认删除和更新行为为前两个 不允许主表中没有的数据今天添加 和 不允许有关联的数据进行删除 

  除此之外 还可以通过 在设置外键时 在后面加上 on update 行为 on delete 行为 来控制外键的行为

* 检查约束 check

  check用于数据强制满足的条件 但 mysql5.7暂时不支持check 只做语法校验 不会生效

  ```sql
  #check
  CREATE TABLE t23 (id INT PRIMARY KEY,`name` VARCHAR(32) , sex VARCHAR(6) CHECK (sex IN('man','woman')),sal DOUBLE CHECK ( sal > 1000 AND sal < 2000));
  #这里可以使用枚举
  CREATE TABLE t23 (id INT PRIMARY KEY,`name` VARCHAR(32) , sex VARCHAR(6) enum('男','女'),       
  sal DOUBLE CHECK ( sal > 1000 AND sal < 2000));
   #枚举生效 check不生效
  -- 添加数据 不生效
  INSERT INTO t23 VALUES(1, 'jack', 'mid', 1);
  SELECT * FROM t23;
  ```

* 约束的删除

  ```sql
  ALTER TABLE 表名 DROP CONSTRAINT '约束名';
  ```

* 练习

  ```sql
  #商店售货系统表练习
  create database shop_db character set utf8 collate utf8_bin;
  use shop_db
  drop table goods
  create table goods (good_id int primary key , good_name varchar(128), unitprice double check (unitprice between 1.0 and 9999.99),
  	category varchar(64),provider varchar(64));
  create table customer (customer_id int primary key,`name` varchar(32) not null,address varchar(64),email varchar(64) unique ,sex
  	varchar(4) check (sex in('男','女')),card_id int);
  create table purchase (order_id int primary key, customer_id int ,foreign key(customer_id) references customer(customer_id),good_id int,
  	foreign key(good_id) references goods(good_id),nums int);
  ```

### (主键)自增长

* 介绍

  在某列数据中 可以使用自增长使某列数据自动增长 自动维护 当不指定值或指定为null是自动填充

  语法为 字段 primary key auto_increment

* 细节

  1. 一般来说自增长是和primary key 配合使用的
  2. 自增长也可以单独使用 但需要配合一个unique
  3. 自增长修饰的字符为整数型的(小数也可以使用但使用场景非常少)
  4. 自增长从1开始 也可以通过alter table 表名 auto_increment = 新的开始值来修改
  5. 如果添加数据时 给自增长(字段)指定特有值 则按特有值为准 其后增长的值结果为指定的特有值+1   如果指定了自增长 一般来说就按自增长的规则来添加数据
  6. 主键约束自增长如果数据未插入成功仍然自增长 下次插入数据自增长不连续
  7. 可以通过删除主键 再添加主键的方式 删除自增长

* 代码

  ```sql
  #自增长
  CREATE TABLE user06 (id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(32))
  INSERT INTO user06 VALUES(NULL,'wang');
  INSERT INTO user06 (NAME) VALUES('ying');
  ALTER TABLE user06 AUTO_INCREMENT = 9;
  SELECT * FROM user06
  ```

### 索引

* 基本介绍

  索引是用来提升搜索速度的 不加内存 不改程序 不调sql  在表中可以用 create index 索引名 on 索引表 (索引字段) 来在表中创建索引 在搜索有关该字段的数据时可以大幅提高搜索速度 但表的大小会增加 以空间换时间

* 索引的原理

  1. 没有索引为什么会慢：select语句进行搜索时会进行全表扫描
  2. 有索引为什么会变块： 创建索引相当于创建了一个数据结构 如二叉树等 可以提高查找的效率 但数据结构占用空间 会有以下坏处： 1. 磁盘占用     2. c u d 增删改速度变慢(因为要维护索引的数据结构) 
  3. 因一般查找比增删改的操作要多所以利大于弊

* 索引的分类

  1. 主键索引 主键自动的为主索引 (类型 primary key)
  2. 唯一索引 (unique)
  3. 普通索引 (index)
  4. 全文索引 (fulltext) 适用于mylsam 一般开发不适用mysql自带的全文索引 而是适用：全文索引solr 和 elasticsearch (es) 了解即可

* 索引的创建

  ```sql
  #创建索引
  create table t1 (id int unique ,name varchar(32))
  #主键索引 可以直接在字段后加上primary key 也可以用以下方式创建
  alter table t1 add primary key (id)
  -- 非规范约束式创建法
   -- 暂时认定主键不分索引和约束
  #唯一索引 唯一索引可以直接在字段后加上 unique 也可以用以下方式创建
  create unique index unique_index on t1 (id)
  -- 非规范约束添加法
   -- alter table t1 add unique (id)
  #普通索引 使用主键索引和唯一索引 字段应都是唯一性
  create index id_index on t1 (id)
  alter table t1 add index (id)
  #索引的选取 如果某列的值，是不会重复的
  #则优先考虑使用 unique(primary key)索引, 否则使用普通索引
  #显示表的索引信息
  show index from t1
  ```

* 索引的删除

  ```sql
  #索引的删除
  #删除索引方式(可以用来删除普通索引和唯一索引) 
  drop index `索引名` on t1
  注意：
  索引和约束对等同时存在生效 可以说是一个东西的不同表现 删除完索引 就可以实现删除约束 删除完约束 也可以删除索引
  可以通过主键 唯一 外键 约束的名称 通过删除索引来删除对应的约束
  #删除主键索引
  alter table t1 drop primary key
  ```

* 索引的修改

  ```sql
  #索引的修改
  #ps 删除 + 添加 = 修改
  ```

* 索引的查询

  ```sql
  #索引的查询
  show index from t1
  show indexes from t1
  show keys from t1
  desc t1
  ```
  
* 索引练习

  ```sql
  #练习 建立主键索引
  create table order1 (id int primary key, goods_name varchar(64),
  	goods_num int);
  create table order2 (id int ,goods_name varchar(64),
  	goods_num int);
  alter table order2 add primary key (id)
  #练习 创建唯一索引
  create table menu1 (id int primary key,menu_name varchar(32),cooker varchar(32),
  	costomer_id int unique,price double);
  create table menu2 (id int primary key,menu_name varchar(32),cooker varchar(32),
  	costomer_id int,price double);
  create unique index costomer_id_index on menu2 (costomer_id);
  #练习 建立普通索引
  create table sportman1 (id int primary key, `name` varchar(32), hobity varchar(32));
  alter table sportman1 add index (`name`);
  create index name_index on sportman1 (`name`);
  show index from sportman1
  ```

* 小结  哪些列上适合使用索引

  1. 较频繁的作为查询条件字段应该创建索引
  2. 唯一性太差的字段不适合单独创建索引，即使频繁作为查询条件
  3. 更新非常频繁的字段不适合创建索引
  4. 不会出现在WHERE子句中字段不该创建索引

### mysql 事物

* 事物基本介绍  

  事务用于保证数据的一致性,它由一组相关的dml语句组成,该组的dml语句要么全部成功，要么全部失败。如:转账就要用事务来处理，用以保证数据的一致性。当执行事务操作时(dml语句),mysql会在表上加锁,防止其它用户改表的数据 这对用户来讲是非常重要的 简单来说事物就是存档 出现错误可以回档 

* mysql 数据库控制台事务的几个重要操作(基本操作 transaction.sql)

  1. start transaction -- 开始一个事务 只能使用一次commit提交 提交后结束事物 (begin也可以开启事物 相当于start transcation)
  2. set @@autocommit = 0 设置事物提交方式 0 为非自动提交 可以多次使用commit提交  提交后不结束事物
  3. select @@autocommit 查看事物提交方式 0 为不自动提交 1为自动提交
  4. savepoint 保存点名-- 设置保存点
  5. rollback to 保存点名 -- 回退事务到保存点
  6. rollback -- 回退全部事务
  7. commit -- 提交事务,所有的操作生效不能回退

  ```sql
  #事物基本使用 依次执行
  CREATE TABLE t1 (id INT)
  start transaction #开启事物
  savepoint a1 #记录点 可以返回
  insert into t1 values(1); #添加一条数据
  rollback to a1 #回到记录点 添加的数据操作清除
  commit #提交事物 表示事物完成 不能回退
  ```

* 事物细节

  1. 如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚
  2. 如果开始一个事务，你没有创建保存点.你可以执行 rollback，默认就是回退到你事务开始的状态
  3. 你也可以在这个事务中(还没有提交时),创建多个保存点.比如: savepoint  aaa;  savepoint bbb;
  4. 你可以在事务没有提交前，选择回退到哪个保存点
  5. mysql的事务机制需要innodb的存储引擎才可以使用,myisam引擎不能
  6. 开始一个事务有两种方式 start transaction，set autocommit=off.

* 事物隔离级别

  多个连接开启各自事务操作数据库中数据时，数据库系统要负责隔离操作，以保证各个连接在获取数据时的准确性 如果不考虑隔离性，可能会引发如下问题：脏读insert updaet delect (未提交)  不可重复读update delect update (已提交)  幻读 insert (已提交)

  1. 脏读 (dirty read):当一个事务读取另一个事务尚未提交的改变(update,insert,delete)时，产生脏读 产生脏读的情况：事物隔离级别为读未提交 可以读到另一个未提交过事物中进行增删改的数据

  2. 不可重复读 (nonrepeatable read): 同一查询在同一事务中多次进行，由于其他提交事务所做的修改或删除，每次返回不同的结果集，此时发生不可重复读。产生不可重复读的情况：事物隔离级别为读未提交或读以提交 读到另一个提交过事物中进行的删除和修改数据

  3. 幻读 (phantom read): 同一查询在同一事务中多次进行，由于其他提交事务所做的插入操作，每次返回不同的结果集，此时发生幻读。产生幻读的情况：事物隔离级别为读未提交或读已提交或可重复读时 读到另一个提交过事物中进行的插入数据  (幻读情况 ：在事物中查询没有 但因其他事物插入数据 导致无法插入)

  4. 事物隔离级别表

     | mysql隔离级别            | 脏读 | 不可重复读 | 幻读 | 加锁读 |
     | ------------------------ | ---- | ---------- | ---- | ------ |
     | 读未提交read uncommitted | √    | √          | √    | 不加锁 |
     | 读已提交read committed   | ×    | √          | √    | 不加锁 |
     | 可重复读repeatable read  | ×    | ×          | √    | 不加锁 |
     | 可串行化serizlizable     | ×    | ×          | ×    | 加锁   |

     注意可重复读和可串行化避免脏读 不可重复读  的原理不同 可重复读事物隔离级别下的事物开启时 无论另一个事物进行删除 修改 插入操作的数据是否提交 该事物总是读取到刚开启事物的数据状态 始终保持读取数据统一  可串行化表现出避免避免脏读 不可重复读 幻读的形式是通过加锁 可串行化 事物隔离级别下的事物开启时 如果存在另一事物进行删除 修改 插入操作数据未提交的情况 该事物进行查询会卡住直到另一个事物提交 保证该事物查询完第一次后 显示的数据始终是第一次显示的数据  事物结束后才 可能看到别人修改过的数据

  5. 注意 ： 事物隔离级别避免的问题是对于一方的 事物隔离级别越高 数据越安全 但性能越低 反之亦然

  6. 实现理论

     排他锁(写锁)

     加完排他锁后 任何锁都不能加 只有在释放完后才能加锁 排他锁只允许加锁者进行读和修改 其他用户都不能对其对象读和修改

     共享锁(读锁)

     加完共享锁后 只能加共享锁 只有在释放完后才能加其他锁 共享锁允许锁有用户进行读 但不能进行修改操作

* 事物隔离级别的查看和设置

  ```sql
  #查看当前会话级别
  select @@tx_isolation;
  #查看系统当前隔离级别
  select @@global.tx_isolation;
  #设置当前会话隔离级别
  set session transaction isolation level repeatable read;
  #设置系统当前隔离级别
  set global transaction isolation  level repeatable read;
  #mysql 默认隔离级别是repeatable read 一般情况下 没有特殊要求 不必要修改
  #可用以下方式修改默认隔离级别 修改my.ini 配置文件
  transaction-ISolation = 隔离-级别 如 repeatable-read
  ```

* mysql 事务 ACID

  1. 原子性 (Atomicity)原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生
  2. 一致性 (Consistency)事务必须使数据库从一个-致性状态变换到另外一个一致性状态
  3. 隔离性 (lsolation)事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
  4. 持久性 (Durability)持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的接下来即使数据库发生故障也不应该对其有任何影响

* mysql 表类型和存储引擎

  1. 基本介绍

     MySQL的表类型由存储引擎 (Storage Engines) 决定，主要包括MyISAM  innoDB  Memory等。
     MySQL 数据表主要支持六种类型 ，分别是: CSV、Memory、ARCHIVE、MRG MYISAM、MYISAM、InnoBDB.这六种又分为两类，一类是”事务安全型”(transaction-safe)，比如:InnoDB;其余都属于第二类，称为”非事务安全 型”(non-transaction-safe)

  2. 重要的三种存储引擎 myisam innodb memory

     1. MyISAM不支持事务、也不支持外键，但其访问速度快，对事务完整性没有要求
     2. lnnoDB存储引擎提供了具有提交、回滚和崩溃恢复能力的事务安全。但是比起MyISAM存储引擎，InnoDB写的处理效率差一些并且会占用更多的磁盘空间以保留数据和索引。
     3. MEMORY存储引擎使用存在内存中的内容来创建表。每个MEMORY表只实际对应一个磁盘文件。MEMORY类型的表访问非常得快，因为它的数据是放在内存中的，并且默认使用HASH索引。但是一旦MySQL服务关闭，表中的数据就会丢失掉,表的结构还在。

     ```sql
     #表类型和存储引擎
     #查看所有的存储引擎
     SHOW ENGINES
     #1. innodb 存储引擎
     #  1. 支持事务 2. 支持外键 3. 支持行级锁
     #2. myisam 存储引擎
     #  1. 添加速度快 2. 不支持外键和事务 3. 支持表级锁
     #3. memory 存储引擎
     #  1. 数据存储在内存中[关闭了 Mysql 服务，数据丢失, 但是表结构还在] 2. 执行速度很快(没有 IO 读写) 3. 默认支持索引(hash 表)
     #  指令修改存储引擎
     ALTER TABLE `t29` ENGINE = INNODB
     ```

* 如何选择存储引擎

  1. 如果应用不需要事务，处理的只是基本的CRUD操作，那么MyISAM是不二选择速度快
  2. 如果需要支持事务，选择InnoDB
  3. Memory 存储引擎就是将数据存储在内存中，由于没有磁盘I./0的等待速度极快。但由于是内存存储引擎，所做的任何修改在服务器重启后都将消失。(经典用法 用户的在线状态）

### mysql视图

* 视图基本概念

  1. 视图是一个虚拟表 其内容由查询来定义 同真实表一样 视图包含列 其数据来自对应的真实表(基表)
  2. 通过视图可以修改基表的数据
  3. 基表的改变 也会影响到视图的数据
  4. 视图可以隐藏一些重要的信息 不让用户查询看到
  5. 视图实际上就是一张类似根据临时表 组成的结构 用户只能根据这张临时表进行查询 

* 视图的使用

  ```sql
  # 视图的使用
  #1. 创建视图
  CREATE VIEW emp_view01 AS SELECT empno, ename, job, deptno FROM emp;
  #2. 查看视图
  DESC emp_view01
  SELECT * FROM emp_view01;
  SELECT empno, job FROM emp_view01;
  #   查看创建的视图
  SHOW CREATE VIEW emp_view01
  #3. 删除视图
  DROP VIEW emp_view01;
  #4. 修改视图
  UPDATE emp_view01 SET job = 'MANAGER' WHERE empno = 7369
  -- 视图的细节
  #1. 创建视图后，到数据库去看，对应视图只有一个视图结构文件 (形式: 视图名.frm) 视图本身并不存储数据 而是通过映射的方式得到基本的数据信息
  #2. 视图的数据变化会影响到基表，基表的数据变化也会影响到视图[insert update delete ]
  #3. 修改视图 会影响到基表
  #4. 视图中可以再使用视图 , 比如从 emp_view01 视图中，选出 empno,和 ename 做出新视图
  DESC emp_view01
  CREATE VIEW emp_view02 AS SELECT empno, ename FROM emp_view01
  SELECT * FROM emp_view02
  ```

* 视图最佳实践

  1. 安全。些数据表有着重要的信息。有些字段是保密的，不能让用户直接看到。这时就可以创建一个视图，在这张视图中只保留一部分字段。这样，用户就可以查询自己需要的字段，不能查看保密的字段
  2. 性能。关系数据库的数据常常会分表存储，使用外键建立这些表的之间关系。这时数据库查询通常会用到连接 (JOIN)。这样做不但麻烦，效率相对也比较低。如果建立一个视图，将相关的表和字段组合在一起，就可以避免使用JOIN查询数据。
  3. 灵活。如果系统中有一张旧的表，这张表由于设计的问题，即将被废弃。然而，很多应用都是基于这张表，不易修改。这时就可以建立一张视图，视图中的数据直接映射到新建的表。这样，就可以少做很多改动，也达到了升级数据表的目的。

* 视图的练习

  ```sql
  #视图的练习 映射到多个基表
  select* from emp  empno ename deptno 
  select* from dept deptno dname
  select * from salgrade  grade losal hisal
  create view view01 as select emp.deptno,ename,dname,grade from emp,dept,salgrade where
  	emp.deptno = dept.deptno and emp.sal between losal and hisal;
  select * from view01
  ```

### mysql管理

* 用户

  1. mysql中的用户，都存储在系统数据库mysql中 user 表中 
  2. host ： 允许登录的’位置‘ localhost  表示该用户只允许本机登录 也可以指定ip地址
  3. user：用户名
  4. authentication_string： 密码 是通过mysql的password() 函数加密之后的密码

* 用户权限图

  ![image-20230715103510242](img\image-20230715103510242.png)

* 用户管理指令

  ```sql
  #创建用户 (root 用户操作)
  create user 'xing'@'localhost' identified by '123456';
  select * from mysql.user
  #删除用户 (root 用户操作)
  drop user 'xing'@'localhost';
  #修改自己密码
  set password = password('xing123456');
  #修改别人密码 (需要权限)
  set password for 'xing'@'localhost' = password('123456');
  
  alter user 'itcast'@'localhost' identified with mysql_native_passoord by '1234';
  #
  #用户权限的管理
  #1. 创建用户
  create user 'xing'@'localhost' identified by '123456';
  #使用 root 用户创建 testdb ,表 news
  CREATE DATABASE testdb 
  CREATE TABLE news (id INT ,content VARCHAR(32));
  -- 添加一条测试数据
  INSERT INTO news VALUES(100, '北京新闻');
  SELECT * FROM news;
  #2. 授予权限 
  grant select,insert,delete on news to 'xing'@'localhost';
  # 授予权限同时修改密码
  GRANT update ON news TO 'xing'@'localhost' identified by '123456'
    # 如果名为 'new_user'@'host' 的用户不存在，MySQL 将会创建一个新用户，并为该用户设置密码为 'password'，然后授予指定的权限。如果用户 'new_user'@'host' 已经存在，那么 MySQL 将会更新该用户的密码，并授予权限
  # 当用户未存在时 结尾用identified by 密码 可以创建用户的同时赋予权限
  
  #3. 回收权限
  REVOKE SELECT,UPDATE,INSERT,delete ON testdb.news FROM 'xing'@'localhost'
  REVOKE ALL ON testdb.news FROM 'xing'@'localhost'
  -- 删除用户
  DROP USER 'xing'@'localhost'
  ```

* 用户管理细节

  ```sql
  #用户管理细节
  #1. 在创建用户的时候，如果不指定 Host, 则为% , %表示所有 IP 都有连接权限
  -- create user xxx;
  CREATE USER jack
  SELECT `host`, `user` FROM mysql.user
  #2. 也可以这样指定
  -- create user 'xxx'@'192.168.1.%' 表示 xxx 用户在 192.168.1.*的 ip 可以登录 mysql
  CREATE USER 'smith'@'192.168.1.%'
  #3. 在删除用户的时候，如果 host 不是 %, 需要明确指定 '用户'@'host 值'
  DROP USER jack -- 默认就是 DROP USER 'jack'@'%'
  DROP USER 'smith'@'192.168.1.%'
  ```

