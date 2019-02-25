  [TOC] 目录
  
  
### Collection和Map总体概述
![](http://ww1.sinaimg.cn/large/b06adeeegy1g0il5di3vxj217s0gawhu.jpg)

1 Collection是一个接口，是高度抽象出来的集合，它包含了集合的基本操作和属性。

  Collection包含了List和Set两大分支。
  
1. List是一个有序的队列，每一个元素都有它的索引。第一个元素的索引值是0。
          List的实现类有LinkedList, ArrayList, Vector, Stack。

2. Set是一个不允许有重复元素的集合。
          Set的实现类有HastSet和TreeSet。HashSet依赖于HashMap，它实际上是通过HashMap实现的；TreeSet依赖于TreeMap，它实际上是通过TreeMap实现的。

2 Map是一个映射接口，即key-value键值对。Map中的每一个元素包含“一个key”和“key对应的value”。

   AbstractMap是个抽象类，它实现了Map接口中的大部分API。而HashMap，TreeMap，WeakHashMap都是继承于AbstractMap。
   Hashtable虽然继承于Dictionary，但它实现了Map接口。

接下来，再看Iterator。它是遍历集合的工具，即我们通常通过Iterator迭代器来遍历集合。我们说Collection依赖于Iterator，是因为Collection的实现类都要实现iterator()函数，返回一个Iterator对象。
ListIterator是专门为遍历List而存在的。

再看Enumeration，它是JDK 1.0引入的抽象类。作用和Iterator一样，也是遍历集合；但是Enumeration的功能要比Iterator少。在上面的框图中，Enumeration只能在Hashtable, Vector, Stack中使用

参考链接：http://www.cnblogs.com/skywang12345/p/3308498.html
      
      
  ### Collection概述
  ![](http://ww1.sinaimg.cn/large/b06adeeegy1g0iz4dx38kj20ma0ewwfu.jpg)
  Collection是一个接口，它主要的两个分支是：List 和 Set。
  
  List和Set都是接口，它们继承于Collection。List是有序的队列，List中可以有重复的元素；而Set是数学概念中的集合，Set中没有重复元素！
  List和Set都有它们各自的实现类。
  
  为了方便，我们抽象出了AbstractCollection抽象类，它实现了Collection中的绝大部分函数；这样，在Collection的实现类中，我们就可以通过继承AbstractCollection省去重复编码。AbstractList和AbstractSet都继承于AbstractCollection，具体的List实现类继承于AbstractList，而Set的实现类则继承于AbstractSet。
  
  另外，Collection中有一个iterator()函数，它的作用是返回一个Iterator接口。通常，我们通过Iterator迭代器来遍历集合。ListIterator是List接口所特有的，在List接口中，通过ListIterator()返回一个ListIterator对象。
  
  List的定义如下：
  
  public interface List<E> extends Collection<E> {}
  
  
  List是一个继承于Collection的接口，即List是集合中的一种。List是有序的队列，List中的每一个元素都有一个索引；第一个元素的索引值是0，往后的元素的索引值依次+1。和Set不同，List中允许有重复的元素。
  
  Set的定义如下：
  
  public interface Set<E> extends Collection<E> {}
  
  Set是一个继承于Collection的接口，即Set也是集合中的一种。Set是没有重复元素的集合。
  
  
  
  
 ### ArrayList概述
![](http://ww1.sinaimg.cn/large/b06adeeegy1g0izb5of8sj20dc0bidh6.jpg)
  
  ArrayList 是一个数组队列，相当于 动态数组。与Java中的数组相比，它的容量能动态增长。它继承于AbstractList，实现了List, RandomAccess, Cloneable, java.io.Serializable这些接口。
  
  ArrayList 继承了AbstractList，实现了List。它是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。
  ArrayList 实现了RandmoAccess接口，即提供了随机访问功能。RandmoAccess是java中用来被List实现，为List提供快速访问功能的。在ArrayList中，我们即可以通过元素的序号快速获取元素对象；这就是快速随机访问。稍后，我们会比较List的“快速随机访问”和“通过Iterator迭代器访问”的效率。
  
  ArrayList 实现了Cloneable接口，即覆盖了函数clone()，能被克隆。
  
  ArrayList 实现java.io.Serializable接口，这意味着ArrayList支持序列化，能通过序列化去传输。
  
  和Vector不同，ArrayList中的操作不是线程安全的！所以，建议在单线程中才使用ArrayList，而在多线程中可以选择Vector或者CopyOnWriteArrayList。
  
#### ArrayList包含了两个重要的对象：elementData 和 size。
1.elementData 是"Object[]类型的数组"，它保存了添加到ArrayList中的元素。实际上，elementData是个动态数组，我们能通过构造函数 ArrayList(int initialCapacity)来执行它的初始容量为initialCapacity；如果通过不含参数的构造函数ArrayList()来创建ArrayList，则elementData的容量默认是10。elementData数组的大小会根据ArrayList容量的增长而动态的增长，具体的增长方式，请参考源码分析中的ensureCapacity()函数。

2.size 则是动态数组的实际大小。
####  ArrayList的特点
(01) ArrayList 实际上是通过一个数组去保存数据的。当我们构造ArrayList时；若使用默认构造函数，则ArrayList的默认容量大小是10。

(02) 当ArrayList容量不足以容纳全部元素时，ArrayList会重新设置容量：新的容量=“(原始容量x3)/2 + 1”。

(03) ArrayList的克隆函数，即是将全部元素克隆到一个数组中。

(04) ArrayList实现java.io.Serializable的方式。当写入到输出流时，先写入“容量”，再依次写入“每一个元素”；当读出输入流时，先读取“容量”，再依次读取“每一个元素”。
####  ArrayList操作
1. 遍历

    Integer value = null;
    int size = list.size();
    for (int i=0; i<size; i++) {
        value = (Integer)list.get(i);        
    }
 2. toArray方法
 
        // toArray(T[] contents)调用方式二。最常用！
        public static Integer[] vectorToArray2(ArrayList<Integer> v) {
            Integer[] newText = (Integer[])v.toArray(new Integer[0]);
            return newText;
        }
 3. 遍历常用API

        public class ArrayListTest {
        
            public static void main(String[] args) {
                
                // 创建ArrayList
                ArrayList list = new ArrayList();
        
                // 将“”
                list.add("1");
                list.add("2");
                list.add("3");
                list.add("4");
                // 将下面的元素添加到第1个位置
                list.add(0, "5");
        
                // 获取第1个元素
                System.out.println("the first element is: "+ list.get(0));
                // 删除“3”
                list.remove("3");
                // 获取ArrayList的大小
                System.out.println("Arraylist size=: "+ list.size());
                // 判断list中是否包含"3"
                System.out.println("ArrayList contains 3 is: "+ list.contains(3));
                // 设置第2个元素为10
                list.set(1, "10");
        
                // 通过Iterator遍历ArrayList
                for(Iterator iter = list.iterator(); iter.hasNext(); ) {
                    System.out.println("next is: "+ iter.next());
                }
        
                // 将ArrayList转换为数组
                String[] arr = (String[])list.toArray(new String[0]);
                for (String str:arr)
                    System.out.println("str: "+ str);
        
                // 清空ArrayList
                list.clear();
                // 判断ArrayList是否为空
                System.out.println("ArrayList is empty: "+ list.isEmpty());
            }
        }
 参考：http://www.cnblogs.com/skywang12345/p/3308556.html
 
 ###    fail-fast 原理，解决
  
  #### 原理：
  ConcurrentModificationException是在操作Iterator时抛出的异常。
  
  调用 next() 和 remove()时，都会执行 checkForComodification()。若 “modCount 不等于 expectedModCount”，则抛出ConcurrentModificationException异常，产生fail-fast事件。
  fail-fast 机制是java集合(Collection)中的一种错误机制。当多个线程对同一个集合的内容进行操作时，就可能会产生fail-fast事件。
  例如：当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了；那么线程A访问集合时，就会抛出ConcurrentModificationException异常，产生fail-fast事件
   
   无论是add()、remove()，还是clear()，只要涉及到修改集合中的元素个数时，都会改变modCount的值。
   
   接下来，我们再系统的梳理一下fail-fast是怎么产生的。步骤如下：
   (01) 新建了一个ArrayList，名称为arrayList。
  
   (02) 向arrayList中添加内容。
   
   (03) 新建一个“线程a”，并在“线程a”中通过Iterator反复的读取arrayList的值。
   
   (04) 新建一个“线程b”，在“线程b”中删除arrayList中的一个“节点A”。
   
   (05) 在某一时刻，“线程a”创建了arrayList的Iterator。此时“节点A”仍然存在于arrayList中，创建arrayList时，expectedModCount = modCount(假设它们此时的值为N)。
          在“线程a”在遍历arrayList过程中的某一时刻，“线程b”执行了，并且“线程b”删除了arrayList中的“节点A”。“线程b”执行remove()进行删除操作时，在remove()中执行了“modCount++”，此时modCount变成了N+1！“线程a”接着遍历，当它执行到next()函数时，调用checkForComodification()比较“expectedModCount”和“modCount”的大小；而“expectedModCount=N”，“modCount=N+1”,这样，便抛出ConcurrentModificationException异常，产生fail-fast事件。
   
   #### 解决
   修改ArrayList对应的CopyOnWriteArrayLis
 原因：
 (01) 和ArrayList继承于AbstractList不同，CopyOnWriteArrayList没有继承于AbstractList，它仅仅只是实现了List接口。
 
 (02) ArrayList的iterator()函数返回的Iterator是在AbstractList中实现的；而CopyOnWriteArrayList是自己实现Iterator。
 
 (03) ArrayList的Iterator实现类中调用next()时，会“调用checkForComodification()比较‘expectedModCount’和‘modCount’的大小”；但是，CopyOnWriteArrayList的Iterator实现类中，没有所谓的checkForComodification()，更不会抛出ConcurrentModificationException异常！ 
   
  参考：http://www.cnblogs.com/skywang12345/p/3308762.html
  
 ###  LinkedList概述
 LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。
 
 LinkedList 实现 List 接口，能对它进行队列操作。
 
 LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。
 
 LinkedList 实现了Cloneable接口，即覆盖了函数clone()，能克隆。
 
 LinkedList 实现java.io.Serializable接口，这意味着LinkedList支持序列化，能通过序列化去传输。

 LinkedList 是非同步的。
 ![](http://ww1.sinaimg.cn/large/b06adeeegy1g0j0u5cbiqj20g30j7wgu.jpg)
 
#### LinkedList的本质是双向链表。
 
 (01) LinkedList继承于AbstractSequentialList，并且实现了Dequeue接口。 
 
 (02) LinkedList包含两个重要的成员：header 和 size。
 　　header是双向链表的表头，它是双向链表节点所对应的类Entry的实例。Entry中包含成员变量： previous, next, element。其中，previous是该节点的上一个节点，next是该节点的下一个节点，element是该节点所包含的值。 
 　　size是双向链表中节点的个数。
  
  


 
 ### Vector概述

 
 Vector 是矢量队列，它是JDK1.0版本添加的类。继承于AbstractList，实现了List, RandomAccess, Cloneable这些接口。
 
 Vector 继承了AbstractList，实现了List；所以，它是一个队列，支持相关的添加、删除、修改、遍历等功能。

 Vector 实现了RandmoAccess接口，即提供了随机访问功能。RandmoAccess是java中用来被List实现，为List提供快速访问功能的。在Vector中，我们即可以通过元素的序号快速获取元素对象；这就是快速随机访问。

 Vector 实现了Cloneable接口，即实现clone()函数。它能被克隆。
 
 和ArrayList不同，Vector中的操作是线程安全的。
 ![](http://ww1.sinaimg.cn/large/b06adeeegy1g0izqwxt6oj20ec0cg0uh.jpg)
  #### Vector包含了3个成员变量：elementData , elementCount， capacityIncrement。
       
  1. elementData 是"Object[]类型的数组"，它保存了添加到Vector中的元素。elementData是个动态数组，如果初始化Vector时，没指定动态数组的>大小，则使用默认大小10。随着Vector中元素的增加，Vector的容量也会动态增长，capacityIncrement是与容量增长相关的增长系数，具体的增长方式，请参考源码分析中的ensureCapacity()函数。
       
  2. elementCount 是动态数组的实际大小。
       
  3. capacityIncrement 是动态数组的增长系数。如果在创建Vector时，指定了capacityIncrement的大小；则，每次当Vector中动态数组容量增加时>，增加的大小都是capacityIncrement。
 
 #### Vector总结：
 
 (01) Vector实际上是通过一个数组去保存数据的。当我们构造Vecotr时；若使用默认构造函数，则Vector的默认容量大小是10。
 
 (02) 当Vector容量不足以容纳全部元素时，Vector的容量会增加。若容量增加系数 >0，则将容量的值增加“容量增加系数”；否则，将容量大小增加一倍。
 
 (03) Vector的克隆函数，即是将全部元素克隆到一个数组中。
 #### Vector操作
 遍历操作
 
        Integer value = null;
        int size = vec.size();
        for (int i=0; i<size; i++) {
            value = (Integer)vec.get(i);        
        }
   
        
 测试函数：遍历Vector和常用API 
       
   
        public class VectorTest {
            public static void main(String[] args) {
                // 新建Vector
                Vector vec = new Vector();
                    
                // 添加元素
                vec.add("1");
                // 设置第一个元素为100
                vec.set(0, "100");
                // 将“300”插入到第3个位置
                vec.add(2, "300");
                // (顺序查找)获取100的索引
                System.out.println("vec.indexOf(100):"+vec.indexOf("100"));
                // (倒序查找)获取100的索引
                System.out.println("vec.lastIndexOf(100):"+vec.lastIndexOf("100"));
                // 获取第一个元素
                System.out.println("vec.firstElement():"+vec.firstElement());
                // 获取第3个元素
                System.out.println("vec.elementAt(2):"+vec.elementAt(2));
                // 获取最后一个元素
                System.out.println("vec.lastElement():"+vec.lastElement());
        
                // 获取Vector的大小
                System.out.println("size:"+vec.size());
                // 获取Vector的总的容量
                System.out.println("capacity:"+vec.capacity());
        
                // 获取vector的“第2”到“第4”个元素
                System.out.println("vec 2 to 4:"+vec.subList(1, 4));
        
                // 通过Enumeration遍历Vector
                Enumeration enu = vec.elements();
                while(enu.hasMoreElements())
                    System.out.println("nextElement():"+enu.nextElement());
                    
                Vector retainVec = new Vector();
                retainVec.add("100");
                retainVec.add("300");
                // 获取“vec”中包含在“retainVec中的元素”的集合
                System.out.println("vec.retain():"+vec.retainAll(retainVec));
                System.out.println("vec:"+vec);
                    
                // 获取vec对应的String数组
                String[] arr = (String[]) vec.toArray(new String[0]);
                for (String str:arr)
                    System.out.println("str:"+str);
        
                // 清空Vector。clear()和removeAllElements()一样！
                vec.clear();
        //        vec.removeAllElements();
        
                // 判断Vector是否为空
                System.out.println("vec.isEmpty():"+vec.isEmpty());
            }   
        }  
 参考：http://www.cnblogs.com/skywang12345/p/3308556.html      
        