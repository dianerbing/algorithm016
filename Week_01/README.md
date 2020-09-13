# 第一周内容总结

给自己定个规矩，总结做到这四个字：言简意赅

## GitHub

### 本地仓库操作指令

1. git --version							查看git版本
2. git init										初始化git仓库
3. git config --global user.name "username"		配置用户名
4. git config --global user.email "a@b.com"			配置电子邮箱
5. git status								查看git仓库状态
6. git add 文件名或 **.**					将某个文件或所有文件添加到git仓库，让git去跟踪此文件
7. git commit -m "提交说明"			提交变动到git本地仓库

![image-20200913211312635](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200913211312635.png)

![image-20200913211250596](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200913211250596.png)

### GitHub仓库

1. 在github新建仓库

2. git remote add 自定义远程git仓库名 ssh地址     （为本地仓库添加一个远程仓库，记得在仓库路径下执行）

   git remote add testGit git@github.com:dianerbing/testGit.git

3. git remote 查看远程仓库名

4. 使用ssh协议，配置公私钥，日后pull和push无需输入密码

   4.1 **ssh-keygen -t rsa -C "电子邮箱"**	命令执行后一路回车，不用输入密码，否则每次pull/push都要输密码

   4.2 **拷贝公钥信息到github**（github右上角->Settings->SSH and GPG keys->New SSH key->复制到Key中）

   4.3 检查是否建立ssh认证

   ​		ssh -T git@github.com

   ​		提示中出现you have successfully authenticated 说明成功建立ssh认证

5. git push -u 远程仓库名 master（master是主干，也可以是分支名）

### GitHub fork&clone

 1. 在别人的仓库上点击fork

    将别人的开源项目拷贝到我的github仓库中，且与原仓库相互独立

    ![image-20200913213535638](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200913213535638.png)

    ![image-20200913213449846](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200913213449846.png)

 2. git clone ssh地址（见下图）

    ![image-20200913213927878](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200913213927878.png)

    ​	git clone之前不需要git init，因为git clone相当于执行了以下四步：

    ​			git init (创建本地存储库)

    ​			git remote add (将URL添加到该存储库)

    ​			git fetch (从该URL中获取所有分支到本地存储库)

    ​			git checkout(创建工作树中主分支的所有文件)

 3. clone后，远程仓库中的内容已checkout到本地，可以进行正常commit/pull/push操作

## 五毒神掌

> 5-10分钟读题和思考，如果没有思路，马上看题解，默写代码
>
> 马上自己写，提交leetcode，多种解法，体会优化
>
> 24小时后，再重复做题
>
> 一周后重复做题
>
> 面试前一周或两周重复恢复性训练

## 切题四件套

> 理清题意，确定题目要求
>
> 想尽可能多的解法，对比每种解法的时间空间复杂度，找到比较好的解法
>
> 可能多地动手写
>
> 测试用例

## 数据结构

- 一维
  - 基础：数组array(string)、链表 linked list
  - 高级：栈stack、队列queue、双端队列deque、集合set、映射map (hash or map)  etc
- 二维
  - 基础：树 tree，图 graph
  - 高级：二叉搜索树 binary search tree(red-black tree, AVL)、堆 heap、并查集 disjoint set、字典树Trie etc
- 特殊
  - 位运算 Bitwise、布隆过滤器 BloomFilter
  - LRU Cache

## 算法

- 分支 branch  -> if else、switch
- 循环 loop -> for、while
- 递归 Recursion
- 搜索 Search
- 动态规划 Dynamic Programming
- 二分查找 Binary Search
- 贪心 Greedy
- 数学 Math，几何 Geometry

## 时间复杂度

- O(1) 常数复杂度 Constant Complexity

- O(log n) 对数复杂度 Logarithmic Complexity 

- O(n) 线性时间复杂度 Linear Complexity

- O(n^2) 平方复杂度 N square Complexity

- O(n^3) 立方复杂度 N cubic Complexity

- O(2^n) 指数复杂度 Exponential Complexity

- O(n!) 阶乘复杂度 Factorial

  ![](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200913222646074.png)

### 常见算法复杂度

- 一层循环 O(n)
- 二层循环 O(n^2)
- 三层循环 O(n^3)
- 菲波那切数列 O(k^n)
- 二分查找 O(log n)
- 二叉树遍历 O(n)
- 图的遍历 O(n)
- 搜索算法 DFS、BFS O(n) **每个节点访问一次且仅访问一次**
- 有序二维矩阵二分查找 O(n)
- 归并排序 O(n log n)

## 数组、链表

### 数组

由内存管理器为其分配**连续的**内存地址

#### 时间复杂度

- preappend（头插） O(1)
- append（尾插） O(1)
- insert（中插）O(n) 需要群移
- delete（删除）O(n) 需要群移
- lookup（搜索）O(1)

### 链表

> 链表由一个或多个包含节点组成，每个节点包含两个成员：value和next指针（指向下一个节点）
>
> ​	节点只包含next指针的叫单链表
>
> ​	节点包含next指针和prev指针的叫双向链表
>
> 链表的第一个节点叫head，最后一个叫tail
>
> ​	如果tail的next指向head，叫循环链表

java中的LinkedList是双向链表

![image-20200913224830437](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200913224830437.png)

#### 时间复杂度

- preappend（头插） O(1)
- append（尾插） O(1)
- insert（中插）O(1)
- delete（删除）O(1)
- lookup（搜索）O(n)

### 跳表

使用跳表的前提是链表有序

每种操作的时间复杂度都是**O(log n)**，空间复杂度是O(n)

**跳表实现的关键就是链表有序、升维和空间换时间**

![image-20200913225651082](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200913225651082.png)

## 栈和队列

- 栈stack：先进后出，添加、删除皆为O(1)，查询为O(n)
- 队列queue：先进先出，添加、删除皆为O(1)，查询为O(n)
- 双端队列Double-End Queue(Deque)：两端都可进出，添加、删除皆为O(1)，查询为O(n)
- 优先队列Priority Queue：按元素优先级取出，添加O(1)，取出O(log n)，底层实现有很多种heap、bst、treap

### Java Stack API

- boolean empty() 是否为空
- E peek() 查栈顶元素
- E pop() 弹出栈顶元素
- E push(E item) 入栈
- int search(Object o) 搜索

#### 源码分析

### Java Queue API

- add(e) 
- remove()
- element()
- offer(e)
- poll()
- peek()

#### 源码分析

### Java Deque API

#### 源码分析

#### 样例代码

```java
Deque<String> deque = new LinkedList<>();
//LinkedList里push就是addFirst
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0) {
    System.out.println(deque.pop());
}
System.out.println(deque);
```



### Java PriorityQueue API

#### 源码分析

