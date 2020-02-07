# FunctionalInterface
jdk1.8函数式接口

## 主要讲解jdk1.8新特性函数式编程和工具Stream

### 函数式接口特性
1. 一个函数式接口只有一个抽象方法
2. 如果有默认方法，他不会增加抽象方法的个数，因为它不是抽象的
3. 如果重写了Object方法，也不会增加抽象方法的个数
4. 创建函数式接口的实例：lamdba,方法引用，构造方法引用。
5. 注解满足2种情况不会报错：
	1. 不能注解到枚举，类，注解上
	2. 满足只有一个抽象方法
6. 不管接口是否被注解了FunctionalInterface，编译器仍认定为此接口为函数式接口	



### lamdba格式
(param1,param2) -> {  ...}

### 接口中的实现方法
接口中是可以写实现的，default

### 如何学好stream
1. 记住方法是做什么的
2. 记录参数中函数式接口：记住如何构建函数式接口

###一种设计理念
内部处理：我拥有数据的控制权，我有数据源,包含内部迭代

### stream方法列表
map：映射，转换  
forEach：内部迭代

### 函数式接口列表
Function :传入一参数，返回一个结果  
Consumer：接受一个参数，无返回值
filter:过滤
Predicate:接受一个参数，返回boolean类型
Supplier:无参数，一个返回结果

### 如何学好stream
1：记住方法是做什么的
2：记录参数中函数式接口：记住如何构建函数式接口


### 一种设计理念：
内部处理：我拥有数据的控制权，我有数据源
内部迭代

### 学习技巧
熟能生巧
刻意的熟能生巧


### Optional
empty()：返回一个空值的Optional:value == null
Optional(T value) : 私有的构造方法，如果参数为空的话就会抛出异常
of(value) : 返回一个value值为value的Optional,如果value为null则抛出异常。
ofNullable(value) :返回一个value值为value的Optional，如果value为空，不会抛出异常，返回一个vlaue为null的Optional
get()：如果value为空，直接报错，不为空反正value
isPresent():value是否为空，不为空返回true
ifPresent(Consumer) :如果不为空，则处理，使用Consumer
filter(Predicate) : 判断value是否符合predicate,不符合则Optional中value则置位null
map(Function) : 映射，返回一个value为转换了的Optional
flatMap(Function) : 直接使用function返回一个Optional
orElse(defaultValue):如果不为空，则返回value,否则返回defaultValue
orElseThrow(Supplier) : 如果为空，则自定义异常
orElseGet(Supplier) : 如果为空，则返回自定义的Value值

### Option
1：减少了更多的if else 判断，而且更加避免了NPE.

### 方法引用和构造方法引用
void accept(T t);
integer -> System.out.println(integer)
System.out::println
省略了左边的参数定义，对应使用方法的一个参数
1:参数能够对应到使用的方法的参数上
2:函数式接口有返回值：方法的调用必须要有返回值，必须和返回值相等
3:参数能够对应到方法调用的实例上，1,3点的共同点，替换的地方和参数一致,参数和被替换的个数一致

1:参数能替换到方法参数上和实例上，被替换的个数保持一致
2:返回值和对应的函数式接口一致，return是被自动加上的，如果函数式接口有返回值，那么方法的返回值，直接return,new的一样

R apply(T t);
str -> Integer.parseInt(str)
Integer::parseInt

str -> str.toUpperCase()
T get();
() -> new Student()
Student::new
String::toUpperCase
str.length();
String::length
str1.concat(str2)
String::concat

R apply(T t, U u);
public Student(int age,String name)
Student::new

### 格式
1：类的引用::方法
2: 类名::方法
3：构造方法引用

return new Student(param1,param2)

### Stream 文档
Stream:是组合操作，stream.xxx().aaa().bbb()...()
还有专有的stream:IntStream,LongStream,DoubleStream,符合stream特征和限制
Stream是需要
1：一个源的，可能是一个数组，一个集合，或者生产方法，I/O等等
2：有0或者多个中间操作，转换一个stream到一个新的stream
3:终止操作，产生一个结果或者“副作用”的方法。
Stream是延迟执行的，只有执行终止操作时才会计算，源被消费只有被需要的时候
集合和Stream是有一些表面上的相似之处
集合是有效的对元素进行管理和访问，插入，遍历，查询操作
流不会直接提供方法操作他们的元素。声明式的描述他们的源，比较关心在这个源上面做的聚合操作。
如果说没有提供具体的方法，可以使用iterator和spliterator,去实现它。
例子中是一个stream的查询操作，如果被修改可能出现不可预知的或者错误的情况
传入方法的行为：1：必须是非干扰的（不能修改这个源）2:大多数情况下必须为无状态的，他们的结果不依赖任何状态，不依赖于除了自身的元素的变量。
大多数的方法参数都是函数式接口，  
一个stream应该被操作一次，多线程的情况可能会被调用多次。
如果流返回了他的接受者，不会那么容易检测出来。
stream自动关闭，大多数不需要关闭，有一些IO操作需要关闭，可以使用try-with-resources方式
stream是否是顺序的和并行的，是他的一个属性决定的，可以通过方法去改变执行方式，可以通过方法查询执行方式。

### Stream 方法
allMatch:是否所有元素都符合条件
anyMatch：是否有部分符合条件
collect：收集器，放到下一节课
concat：拼接相同的stream
count:元素的个数
distinct：元素去重，要放在有限元素个数之后
filter ： 过滤元素
findAny ： 查找任意一个
findFirst: 查找第一个
flatMap : 把元素内存在的集合，把每个集合汇聚起来
forEachOrdered:元素的输出和输入顺序是一致的
generate : 生成无限个相同元素的流
iterate：有初始值的生成工具
map:映射，转换
max，min ：获得最大最小的元素 Comparator也放到下一节课中
noneMatch：是否一个都不符合
reduce：汇聚操作，第一个参数是一个能够累积的值，第二个参数是元素值
skip:过滤几个 

stream是具有短路性质的

### Comparator
提供了创建Comarator的静态方法，可以使用元素的其他属性进行比较
也可以对已排序的内容使用其他属性再次进行排序

collect(Supplier,BiComsumer,BiComsumer )
终止操作，对元素进行汇聚操作，这个汇聚的结果是一个可变的结果容器
通过更改容器的状态进行汇聚操作，而不是替换这个结果
可以串行操作，不需要额外的同步操作
terminal操作


### Collector接口方介绍

finisher,可变的结果容器，进行最终结果的转换

特性：
CONCURRENT:多线程的，不要和串行的混一起
UNORDERED:无序的
IDENTITY_FINISH:是否需要最终的转换，一致性，无序调用finisher方法放回的Function接口


汇聚输入元素操作到一个可变的结果容器中
当所有的元素被处理之后可选择进行转换成一个最终的结果Finisher(和IDENTITY_FINISH相结合的)，可以串行和并行
Collectors实现了很多公用的汇聚操作的实现
supplier():创建一个新的结果容器
accumulate():组合一个新的元素到一个结果容器中
combiner():两个结果合并成一个，串行时使用
finisher():进行一个最终的转换
characteristics,特性的集合

串行的汇聚操作将创建一个结果容器，每个元素都会使用accumulate操作
并行的汇聚操作将输入分组，每个一个分组都会创建一个结果容器，并生成结果，使用combiner方法组合成一个组合的结果
为了串行和并行产生等价的结果
identity:同一性：a == combiner.appley(a, supplier.get()) 这个就能够验证同一性
associativity:结合性：不同的元素进行分割和不分割所产生的结果要保持等价

对于无序的特性，是被放宽松的允许排序上不同的不相等的特性
List有相同的元素，忽略排序，也是可以认为等价。

如果lib中使用Collector进行汇聚操作的，那么必须符合以下的约束：
1：accumulator 第一个，combiner 2个，finisher（其中的参数指的是可变结果容器）所使用的参数必须是supplier,conbiner,accumulate的所产生的结果。
2：不能对supplier，accumulator，combiner的结果做任何事情，除了把这些结果再次传入到accumulator，combiner，finisher或者返回结果。
3：如果结果容器传入到combiner，finisher，是不能再被使用了，这2个方法已经是对结果容器最后的处理了，而且不能再传入到accumulate函数了，说明已经汇聚结束了，不能再次汇聚了
4：如果是非线程的操作，是不需要collateor实现额外的同步操作，这个输入必须进行恰当的分区，分区的处理是被隔离的，进行组合操作必须是所有元素汇聚之后
5：如果是多线程处理的话，那么一个汇聚操作会被多线程的调用，使用一个结果容器，并没有在汇聚的时候保持隔离，多线程的汇聚仅仅被应用于有unordered特性或者原始数据存在unordered特性（Set）。


除了Collectors预定义的方法，可以使用of方法进行构造Collector
可以使用预定义的toCollection方法

使用分区并行的操作，变好还是变坏主要取决于accumulate和combiner

Collectors的方法是组合的，可以使用Collector产生一个新的Collector



### 和sql对比
select * from student 


select * from student where age > 20 

filter(age > 20).


select sum(age) from student

select grade,sum(age),average(age) from student group by grade

select name,sum(age) from student group by name


zhangsan 10

value  = map.get(zhangsan) //要创建一个新容器，把每一个对应的元素都放入到容器里面，放入容器的过程是相结合的容器的方法。
map.put(zhangsan,10)
newValue = value + other//与groupingBy方法相结合的Collector
map.put(zhangsan,newValue);


zhangsan ---> 容器
lisi     ---> 容器
中间结果：是一个map,Value值是downStream的中间结果
汇聚：是通过key找到downStream的中间结果进行汇聚


### Partition
Partition
true
flase

### Spliterator
stream()方法是Collection的一个默认方法

Stream -->Spliterator --> Collection --> Object[]

Spliterator<E> spliterator() 创建一个Spliterator
Spliterator ： 用于遍历和分区对元素。可以从数组，集合和IO通道和生成器函数
tryAdvance：可以单独的处理元素
forEachRemaining：是批量的处理元素，减少竞争的
trySplit方法分割元素，生成另外一个Spliterator,可以被使用在串行操作中，可能放入另外一个线程中
如果使用了不能分割的，高度不平衡的，低效的分割不会在串行中获益
遍历和分割会消耗元素。每个Spliterator是只能有一个批次里操作
Spliterator要报告他结构特性的一个集合：
ORDERED：和文档上输入次序一致。这个是有约束作用的
DISTINCT：不重复的
SORTED：排序的
SIZED：固定程度的，有长度的
NONNULL：不为空的
IMMUTABLE：不可变的
CONCURRENT：支持多线程的
SUBSIZED：被分割有长度的
这些特性是使用位操作记录的
开发者不能在赋予新的含义

延迟绑定的分割迭代器，第一次遍历，第一次分割，第一次查询的时候才会绑定，
如果绑定后进行修改那么就要报错，快速失败。对于批处理的方法，不是每元素失败则报错而是遍历完之后才会报错

分隔迭代器提供一个预估值通过estimateSize得知，有SIZE特性时这个是真是反应真实个数，及时不知道，也是对源上的操作有一定的效果的，判断是否进行拆分或者遍历余下的元素

分割迭代器不是期望设计成支持多线程，确保在每次只有一个线程在调用。线程隔离的方式去实现。
使用trySplit把生成的Spliterator放入到另外一个线程，这个Spliterator可以进行遍历，也可以继续分割。
原始的分隔迭代器把另外一个Spliterator交给另外一个线程的操作最好在tryAdvance（遍历）之前，分割好了之后在进行遍历，有一些保障是在遍历之前的
原始子类的实现，主要针对基本数据类型，防止装箱操作，OfInt OfLong OfDouble
对原始原生类型的介绍，应该使用都应的方法比如IntConsumer

迭代器像是设计并行遍历，通过支持分解和单元素遍历的方式，比Iterator竞争更小。
在绑定之后和遍历完成之前结果干扰，可能发生任意和不确定的事情
如何管理：
这个源不能被干扰
源不可变，CopyOnWriteArrayList将报告一个不可变的特性
支持多线程，ConcurrentHashMap将报告一个支持多线程的特性
可变源的尽量定义成，延迟绑定，快速失败。

### Stream数据结构
Head（Stream） 继承了 ReferencePipeline（Stream） 继承了 AbstractPipeline -->Spliterator 

### AbstractPipeline
AbstractPipeline：是stream和stream的原生（Int,Long,Double）专业类型的主要实现,专门对stream管理和求值。
对流的初始部分和源封装和0个或者多个中间操作，AbstractPipeline都称为一个stage(阶段)，源阶段或者中间操作的阶段
中间操作通常由AbstractPipeline创建，同时专有的管道（IntPipeline）继承AbstractPipeline。一个指定的操作的类同样继承于AbstractPipeline。
AbstractPipeline包含大多的求值操作，IntPipeline专有的类会增加额外辅助方法加入到这些类中。
如果流被串联（连接）了或者终止操作，那么就被认定为这个流被消费了，不会有更多的中间操作或者终止操作被执行。
对于无状态的流一次执行所有操作。对于串行有状态的流来说，分别放入到块中，每一个片段的分别计算最终结果，被使用放入到下一个片段中。只有执行终止操作时源才会被消费。


ReferencePipeline：是源阶段或者表示中间阶段
Head：只代表了ReferencePipeline的源阶段

### Sink
Sink:槽，进行值贯穿管道的每个阶段的，有begin和end的额外方法的，必须执行begin然后接受数据，在执行end方法，接受每个方法时都会检查是否再次执行的机制。
存在初始和活跃状态，开始状态是初始，begin则变为活跃，end再次变为初始状态，可以重复使用。accept只能活跃时使用。

### 终止操作流程
TerminalOp:ForEachOp,FindOp,MatchOp,ReduceOp

1: 实现了会返回一个Sink操作的方法，终止操作是封装了方法的行为的
2：Pipeline对终止操作的一个处理，但是最终是终止操作对pipeline的一个操作
3：wrapAndCopyInto此时创建终止操作的Sink
4: wrapSink,其实对Sink进行一个串联操作
5：copyInto，Sink链的begin,forRemaining(),end方法，防止终止操作的Sink
6: 根据Sink的get方法进行返回


### 结课总结
1：jdk的文档是非常清楚
2：stream的使用，函数式接口的使用，内部处理的设计思路
3：类的设计思路

