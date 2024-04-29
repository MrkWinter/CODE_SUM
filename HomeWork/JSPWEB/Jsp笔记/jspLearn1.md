### jsp程序基本结构

1. 完整的jsp程序一般由 jSP指令标识 HTML标志 JSP脚本程序 JSP注释 JSP表达式组成
2. jsp指令文件 页面配置信息
3. html标志 html标志 
4. jsp脚本文件 java代码
5. jsp注释 注释 
6. jsp表达式

### jsp指令 <%@  %>

* page指令
  1. 包含多个属性 组成了page 指令
  2. page指令是设定整个页面相关的属性
  3. 使用方式为<%@ page 属性1="属性1" 属性2 = "属性2 " %> 
  4. 主要属性有 language import errorPage pageEncoding 
* include 指令
  1. 用于引入html jsp文件 显示在当前jsp页面中
  1. 使用相对路径
* taglib指令
  1. 引入标签库指令

### jsp脚本程序<% %>

1. jsp脚本程序就是jsp内部的java代码
2. jsp脚本程序定义的变量在整个页面都有效
3. 在用户访问web时 会生成一个独立的线程 保证每个用户的使用不受干扰 
4. jsp脚本程序中定义的变量对每个用户来说是独立的
5. <% %> 中输出的会以绝对的形式插入到编写的jsp文件中
6. 也就是说out.print() 输出的内容会表示到jsp文件对应的位置 包括标签 标签也会被解析
7. 脚本程序中不能定义方法
8. 脚本程序可以使用多个<%%>进行嵌套 其中可包含html标签

### jsp表达式<%= %>

1. 变量 对象等可以通过jsp表达式直接输出

### jsp声明标识<%! %>

1. 可以用<%! %> 标识来表示全局成员 (函数) 声明
2. 声明标识中只能定义 不能输出执行
3. 脚本程序中只能输出执行 不能定义
4. 声明标志中声明的函数(成员)能在jsp页面所有位置使用

### jsp注释<%-- --%>

1. 使用<%-- --%> jsp脚本注释
2. 使用<-- --> html注释
3. 使用 // java脚本注释

### jsp标准动作

* jsp:include
  1. <jsp:include page=“表达式相对路径” flush="true"/>
  2. <jsp:param name=“” value=""/>
  3. jsp:include 可以传递参数 并且是先编译后引入文件再编译
* jsp:forward动作
  1. jsp:forward 把请求转到另外的页面
  2. <jsp:forward page = ''path''/> path 可以放 表达式 变量参数
  3. <jsp:forward param >
  4. 执行forward 后 url还是为当前url 但页面内容会使用其他页面加载的内容

操作javabean的三个标准动作

* javaBean
  1. javaBean为java类 对象
  2. javaBean为封装的功能类 使 html css 与java的功能处理代码分离
  3. javaBean使软件便于维护
  4. javaBean原本分为 可视化javaBean(传统GUI) 和非可视javaBean (java逻辑代码)

* jsp:UseBean (new)
  1. <jsp:userBean id = "student" class= 'xxx.xxx.Student' scope = "page/request/sionsson/application"/>  引入java类 对象
  2.  id来区分不同对象 对象
  3. 可以使用setProoperty 来设置属性
  4. 可以使用getProperty 来获取属性(指定id)
* jsp:setProperty (setter)
  1. < jsp:getProperty name = "id_name" property = "age"/> 获取对象属性 (直接显示)
* jsp:getProperty (getter)
  1. < jsp:setProperty name = "id_name" property = "age" value = " v"/> 获取对象属性
