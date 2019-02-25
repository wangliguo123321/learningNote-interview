[TOC]
假装目录可以跳转

对java平台的理解 

Exception和Error有什么区别？是什么 区别

谈谈 final、finally、 finalize 有什么不同？ 

强引用、软引用、弱引用、幻象引用有什么区别？ 

String、StringBuffer、StringBuilder有什么区别？ 

动态代理是基于什么原理？
#### 对java平台的理解


Java 本身是一种面向对象的语言，最显著的特性有两个方面，一是所谓的“书写一次，到处运 行”（Write once, run anywhere），能够非常容易地获得跨平台能力；另外就是垃圾收集 （GC, Garbage Collection），Java 通过垃圾收集器（Garbage Collector）回收分配内存， 大部分情况下，程序员不需要自己操心内存的分配和回收。 我们日常会接触到 JRE（Java Runtime Environment）或者 JDK（Java Development Kit）。 JRE，也就是 Java 运行环境，包含了 JVM 和 Java 类库，以及一些模块等。而 JDK 可以看作是 JRE 的一个超集，提供了更多工具，比如编译器、各种诊断工具等。 对于“Java 是解释执行”这句话，这个说法不太准确。我们开发的 Java 的源代码，首先通过 Javac 编译成为字节码（bytecode），然后，在运行时，通过 Java 虚拟机（JVM）内嵌的解释 器将字节码转换成为最终的机器码。但是常见的 JVM，比如我们大多数情况使用的 Oracle JDK 提供的 Hotspot JVM，都提供了 JIT（Just-In-Time）编译器，也就是通常所说的动态编译器， JIT 能够在运行时将热点代码编译成机器码，这种情况下部分热点代码就属于编译执行，而不是 解释执行了
#### Exception和Error有什么区别？
##### 是什么
Exception 和 Error 都是继承了 Throwable 类，在 Java 中只有 Throwable 类型的实例才可以 被抛出（throw）或者捕获（catch），它是异常处理机制的基本组成类型。
##### 区别
Exception 和 Error 体现了 Java 平台设计者对不同异常情况的分类。
Exception 是程序正常运 行中，可以预料的意外情况，可能并且应该被捕获，进行相应处理。 Error 是指在正常情况下，不大可能出现的情况，绝大部分的 Error 都会导致程序（比如 JVM 自身）处于非正常的、不可恢复状态。既然是非正常情况，所以不便于也不需要捕获，常见的比 如 OutOfMemoryError 之类，都是 Error 的子类。 
Exception 又分为可检查（checked）异常和不检查（unchecked）异常，可检查异常在源代码 里必须显式地进行捕获处理，这是编译期检查的一部分。前面我介绍的不可查的 Error，是 Throwable 不是 Exception。 不检查异常就是所谓的运行时异常，类似 NullPointerException、 ArrayIndexOutOfBoundsException 之类，通常是可以编码避免的逻辑错误，具体根据需要来 判断是否需要捕获，并不会在编译期强制要求。
#### 谈谈 final、finally、 finalize 有什么不同？ 
final 可以用来修饰类、方法、变量，分别有不同的意义，final 修饰的 class 代表不可以继承扩 展，
final 的变量是不可以修改的，而 final 的方法也是不可以重写的（override）。 finally 则是 Java 保证重点代码一定要被执行的一种机制。我们可以使用 try-finally 或者 trycatch-finally 机制来进行错误处理。
finalize 是基础类 java.lang.Object 的一个方法，它的设计目的是保证对象在被垃圾收集前完成 特定资源的回收。



#### 强引用、软引用、弱引用、幻象引用有什么区别？

在Java语言中，除了基本数据类型外，其他的都是指向各类对象的对象引用；Java中根据其 生命周期的长短，将引用分为4类。


1 强引用 特点：我们平常典型编码Object obj = new Object()中的obj就是强引用。通过关键字new 创建的对象所关联的引用就是强引用。 当JVM内存空间不足，JVM宁愿抛出OutOfMemory Error运行时错误（OOM），使程序异常终止，也不会靠随意回收具有强引用的“存活”对 象来解决内存不足的问题。对于一个普通的对象，如果没有其他的引用关系，只要超过了引 用的作用域或者显式地将相应（强）引用赋值为 null，就是可以被垃圾收集的了，具体回收 时机还是要看垃圾收集策略。 

2 软引用 特点：软引用通过SoftReference类实现。 软引用的生命周期比强引用短一些。只有当 JVM 认为内存不足时，才会去试图回收软引用指向的对象：即JVM 会确保在抛出 OutOfMemory Error 之前，清理软引用指向的对象。软引用可以和一个引用队列（ReferenceQueue）联合 使用，如果软引用所引用的对象被垃圾回收器回收，Java虚拟机就会把这个软引用加入到与 之关联的引用队列中。后续，我们可以调用ReferenceQueue的poll()方法来检查是否有它所 关心的对象被回收。如果队列为空，将返回一个null,否则该方法返回队列中前面的一个Refer ence对象。 应用场景：软引用通常用来实现内存敏感的缓存。如果还有空闲内存，就可以暂时保留缓存，当内存不足时清理掉，这样就保证了使用缓存的同时，不会耗尽内存。 

3 弱引用 弱引用通过WeakReference类实现。 弱引用的生命周期比软引用短。在垃圾回收器线程扫描 它所管辖的内存区域的过程中，一旦发现了具有弱引用的对象，不管当前内存空间足够与 否，都会回收它的内存。由于垃圾回收器是一个优先级很低的线程，因此不一定会很快回收 弱引用的对象。弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所 引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。 应用场景：弱应用同样可用于内存敏感的缓存。

4 虚引用 特点：虚引用也叫幻象引用，通过PhantomReference类来实现。无法通过虚引用访问对象 的任何属性或函数。幻象引用仅仅是提供了一种确保对象被 finalize 以后，做某些事情的机 制。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾 回收器回收。虚引用必须和引用队列 （ReferenceQueue）联合使用。当垃圾回收器准备回 收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到 与之关联的引用队列中。 ReferenceQueue queue = new ReferenceQueue (); PhantomReference pr = new PhantomReference (object, queue); 程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾 回收。如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存 被回收之前采取一些程序行动。 应用场景：可用来跟踪对象被垃圾回收器回收的活动，当一个虚引用关联的对象被垃圾收集 器回收之前会收到一条系统通知。



#### String、StringBuffer、StringBuilder有什么区别？

String 是 Java 语言非常基础和重要的类，提供了构造和管理字符串的各种基本逻辑。它是典型 的 Immutable 类，被声明成为 final class，所有属性也都是 final 的。也由于它的不可变性， 类似拼接、裁剪字符串等动作，都会产生新的 String 对象。由于字符串操作的普遍性，所以相 关操作的效率往往对应用性能有明显影响。
StringBuffer 是为解决上面提到拼接产生太多中间对象的问题而提供的一个类，它是 Java 1.5 中新增的，我们可以用 append 或者 add 方法，把字符串添加到已有序列的末尾或者指定位 置。StringBuffer 本质是一个线程安全的可修改字符序列，它保证了线程安全，也随之带来了额 外的性能开销，所以除非有线程安全的需要，不然还是推荐使用它的后继者，也就是 StringBuilder。 StringBuilder 在能力上和 StringBuffer 没有本质区别，但是它去掉了线程安全的部分，有效减 小了开销，是绝大部分情况下进行字符串拼接的首选。

为了实现修改字符序列的目的，StringBuffer 和 StringBuilder 底层都是利用可修改的（char， JDK 9 以后是 byte）数组，二者都继承了 AbstractStringBuilder，里面包含了基本操作，区别 仅在于最终的方法是否加了 synchronized。

#### 动态代理是基于什么原理？

反射机制是 Java 语言提供的一种基础功能，赋予程序在运行时自省（introspect，官方用语） 的能力。通过反射我们可以直接操作类或者对象，比如获取某个对象的类定义，获取类声明的属 性和方法，调用方法或者构造对象，甚至可以运行时修改类定义

