### lambda表达式

* 简介

  lambda表达式实际上就是基于只有一个抽象方法的接口，通过匿名内部类实现接口方法 返回对象 的简写  一般表达式为接口名 变量名  = （形参数据类型  形参名...）-> { 方法体...  } ;

* 基本知识
  1. lambda 操作符   ->
  2.  lambda形参列表  (形参列表)
  3.  lambda体    方法体

* 根据情况表达式的六种书写方式

  1. 无参无返回值

     ()  ->  方法体；

  2.   有一个参数无返回值

     (形参数据类型  形参名)  ->  方法体；

  3. 类型推断  有一个参数无返回值 参数数据类型可以省

     （形参名）-> 方法体；

  4. 有一个参数时小括号可以省略

     形参名-> 方法体；

  5. 多个参数 多条执行语句 有返回值

     (形参名1， 形参名2)  ->  {多条语句}；

  6. 有参数 只有一条返回执行语句

     (形参名)  -> 去掉return的语句；

  总结：

  1. -> 左边  根据类型推断 参数类型可以省  一个参数括号可以省
  2. ->右边(labmda体)  一条执行语句 {}可以省  一条return语句 {} return 可以省 
  3. 所有使用lambda表达式必须依赖函数式接口
  4. lambda表达式是函数式接口的实现实例

### 函数式接口

* 函数式接口

  1. 接口中只有一个抽象方法的接口被称为函数式接口

* 内置四大函数式接口

  1. 消费型接口 Consumer<T>    void accept(T t)

  2. 供给型接口 Supplier<T>   T get()

  3. 函数型接口  Function<T，R>   R apply(T  t)

  4. 断定型接口  Predicate<T>   boolean test(T  t)

     基于Consumer接口演示

     ```java
     public class Test {
         public static void main(String[] args) {
             //Consumer 接口
             consumerTest(new Consumer() {
                 @Override
                 public void accept(Object o) {
                     System.out.println(o);
                 }
             });
             consumerTest((o)-> {System.out.println(o + "  好");});
         }
         public static void consumerTest(Consumer<String> consumer) {
             consumer.accept("你好");
         }
     }
     ```

### 方法引用 和构造器引用

* 方法引用基本介绍
  1. 方法引用本质是lambda表达式  只是将已有对象或类中国的方法直接替换 表达式的内容 也就是引入和接口中定义的抽象方法形参列表 返回类型都相同的方法 作为该接口该抽象方法的实现 (方引用前两种)  或者是通过类调用非静态方法时用 对应两个互相调用参数作为两个参数的抽象方法的实现
  2. 具体表示为 将 () -> 方法体 换成  对象/类 :: 方法

*  方法引用三种

  1. 对象 :: 非静态方法

     类中非静态方法和想要实现的抽象方法一模一样

  2. 类  :: 静态方法 (一般就不用对象去调用静态方法 直接用类调用不是很方便？？)

     类中静态方法和想要实现的抽象方法一模一样

  3. 类  :: 实例方法

     类中非静态方法和想要实现的抽象方法相似 存在对象调用关系 该引用方法的实际意义就是用该类对象作为第一个参数 然后调用对应的方法  （实现的抽象方法和此一样）  底层应该是先用类创建一个对象 然后 该对象作为表达式中第一个参数  通过该对象得到对应的方法 该方法的形参和表达式的第二个形参相同 然后执行第一个参数调用该方法 该方法中传入第二个参数 如果说前两中方式是方法体的替换 第三中方式就是参数列表的转变


* 构造器引用

  1. 类名 :: new      (调用无参构造器的形式)

     接口中的抽象方法为空参 要实现的方法为创建一个对象 返回

     而该抽象方法的实现刚好可以通过构造器 new 对象 来替换

  2. 类名 :: new       (调用有参构造器的形式)

     就是用构造器的形参替换抽象方法的形参 方法结果返回构造器new的对象

     总结： 和方法引用类似 函数式接口的抽象方法的形参列表和构造器的形参列表一致‘  抽象方法的返回值类型即为构造器所属的类的类型

* 数组引用

  1. 数组引用和构造器相似 可以将数组看作一个类 调用对应的构造器

     数据类型[]  ::  new  

     new 一个数组 需要一个长度参数 该参数为 length 传入函数时接口的抽象方法 该抽象方法最后返回一个数组 

### 强大的Stream API

* 基本介绍

   提供了高效的数据处理方式 可以对集合数据进行操作 类似于使用sql指向的数据库操作

  Stream操作有三个步骤

* Stream实例化

  1. 通过集合获取 顺序流  或 并行流

  2. 通过数组 获得对应的Stream

  3. 通过Stream的of方法

  4. 创建无限流

     ```java
     public class Test2 {
         public static void main(String[] args) {
             //创建Stream实例化对象的几种方式
             //1. 通过集合创建
             ArrayList<Object> objects = new ArrayList<>();
             Stream<Object> stream = objects.stream();//顺序流
             Stream<Object> objectStream = objects.parallelStream();//并行流
             //2. 通过数组创建对应的流
             int[] arr1 = new int[5];
             IntStream stream1 = Arrays.stream(arr1);
             //3. 通过Stream的of方法
             Stream.of(1,2,2,3,4,5);
             //4. 创建无限流
             Stream.iterate(2,t -> t + 1).limit(10).forEach(System.out::println);
             //种子是数据源 后面参数是迭代方法 指向 对该数据进行限制 最后执行遍历传入消费型函数(使用了函数引用) 打印
             Stream.generate(Math::random).limit(10).forEach((t) -> System.out.println(t));
             //根据数据源限制生成数 forEach中传入lambda表达式 通过调用函数式接口中的方法对数据进行 打印
         }
     }
     ```

* Stream的中间操作

  1.  筛选与切片

     1. filter() 接收lambda表达式 排除某些元素

     2. limit()  截断流 使元素不超过指定数量

     3. skip()  跳过元素 返回一个扔掉前你ge元素的流 若元素不足则返回的是空流

     4. distinct()   筛选 通过流所生成元素的hashCode() 和equals方法判断两个元素是否相同 从而去重

        ```java
        ArrayList<Object> objects = new ArrayList<>();
        Stream<Object> stream = objects.stream();
        //1. 过滤限制
        stream.filter(o -> o != null).forEach(System.out::println);
        //2. 截断限制
        stream.limit(10).forEach(t -> System.out.println(t));
        //3. 跳过限制
        stream.skip(10).forEach(System.out::println);
        //4. 去重限制
        stream.distinct().forEach(System.out::println);
        ```

  2. 映射

     1. map(Function ) 接收一个函数作为参数 将对应元素转换成其他形式或提取信息 该函数会被应用到每一个元素上 并将其映射成一个新的元素

     2.  flatMap(Function  ) 和map不同的是 如果函数将对应元素转换返回的是一个流的集合的集合 会依次将集合中的流全部取出 形成一个大的集合 禁止套娃

        ```java
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<String> stream = strings.stream();
        //map 映射 遍历每个元素 对其修改为操作应的映射
        stream.map((String s) -> {
            return s.toUpperCase();
        }).forEach(System.out::println);
        ```

  3. 排序

     1. sorted() - 自然排序

     2. sorted(Comparator )  - 定制排序

        ```java
        public class Test5 {
            public static void main(String[] args) {
                List<Integer> integers = Arrays.asList(1, 4, 1, 6, 3, 7, 3, 789, 0);
                //1. 自然排序 使用默认的Integer的compare方法
                integers.stream().sorted().forEach(System.out::println);
                //2. 自定义排序 重新实现Comparer 接口的 compare 方法 进行自定义比较
                integers.stream().sorted((e1,e2) -> e2-e1).forEach(System.out::println);
            }
        }
        ```

* Stream终止操作

  1. 匹配与查找

     1. allMatch(Predicate p)  检查是否匹配所有元素
     2. anyMatch(Predicate p)  检查是否至少匹配一个元素
     3. noneMatch(Predicate p)  检查是否没有匹配的元素
     4. findFirst()  返回第一个元素
     5. findAny()  返回任意一个元素(顺序流和并行流返回的不一样)
     6. count()  返回流中元素的总个数 (返回值为long)
     7. max(Comparator c) 返回流中最大值
     8. min(Comparator c)  返回流中最小值
     9. foreach(Consumer c) 内部迭代 可以对流中数据进行变遍历   (集合中也有forEach 和此不一样 集合中的是接口中的默认方法  集合中interator 迭代器是外部迭代)

  2. 规约

     1. reduce(T identity ， BinaryOperator) 可以将流中元素反复结合起来 得到一个值 返回

     2. reduce(BinaryOperator)  同上 但无初始值 默认为0

        ```java
        public class Test6 {
            public static void main(String[] args) {
                List<Integer> integers = Arrays.asList(1, 23, 4, 65, 8, 64);
                //1. reduce一
                Integer reduce = integers.stream().reduce(0, (i1, i2) -> i1 + i2);
                System.out.println(reduce);
                //1. reduce二
                Optional<Integer> reduce1 = integers.stream().reduce(Integer::sum);
                System.out.println(reduce1);
            }
        }
        ```

     3. 收集 

        1. collect(Collector c)  用于将数据收集起来 保存到对应的集合中去   通过Collector传入接口实现对象实现 传入的collector接口可以用Collectors中的静态方法创建抽象接口实例 其中有以下几种

        2. Collector.toList

        3. Collector.toSet

           ```java
           //搜集
           List<Integer> collect = integers.stream().collect(Collectors.toList());
           Set<Integer> collect1 = integers.stream().collect(Collectors.toSet());
           ```

### Optional类

* 基本介绍
  1. Optional类避免空指针 
  2. Optional类是一个容器 类似于Integer 但是任何类的容器 它可以保存T的值 代表存在 或者存储null 表示不存在 从而避免空指针
* 方法
  1. Optional.of(非空对象) 将一个对象封装成Optional
  2. Optional.empty()  创建一个空的Optional实例
  3. Optional.ofNullable(可为空对象)   将一个对象封装成Optional
  4. 对象1.orElse(对象2) 如果Optional对象1中封装的对象为空 返回对象2 否则返回对象1中封装的对象 (通常与ofNullable方法搭配使用)
  5. get() 取得Optional封装的对象数据 (如果封装的数据为空则报错  通常与of方法搭配使用 用于获取封装的数据)
  6. isPresent()  判断Optional容器是否包含对象数据