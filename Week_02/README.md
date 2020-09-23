# 第二章内容总结

给自己定个规矩，总结做到这四个字：言简意赅

## 哈希表

​		哈希表HashTable，又名散列表，可根据关键码值直接进行访问的数据结构。

### 哈希表原理

​		内部使用数组存储，对码值进行散列函数计算得到在数组中存储的位置。借助散列函数对数组进行扩展，利用数组支持按下标随机访问元素的优势特性。对于哈希碰撞（不同的码值算出相同的数组下标），常用的解决方法有开放寻址法和链表法。

![image-20200922165706964](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200922165706964.png)

### 时空复杂度

​		如下图，哈希表的增删改查操作，状态好时为O(1)，状态不好时退化为O(n)。

![image-20200921222845614](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200921222845614.png)

​		简单说明：在没有hash冲突时，存取操作直接根据key值进行散列计算后得到数组的位置，直接进行存取操作，这个时间复杂度是O(1)。当出现hash冲突后，目前对hash冲突的解决办法一般是开放寻址法（线性探测、二次探测、双重散列）或链表法，不论哪种方法，对于冲突的hash值进行查找时都是需要以O(n)的复杂度进行查找。

### 参考

​		以上只是对哈希表简单的总结，详细可查看该资料文档：

​		https://xintiaohuiyi.gitbook.io/jynotebook/shu-ji/shu-ju-jie-gou-yu-suan-fa-zhi-mei/18-san-lie-biao-ff08-shang-ff09-ff1a-word-wen-dang-zhong-de-dan-ci-pin-xie-jian-cha-gong-neng-shi-ru

## 树

​		树是一个二维数据结构，由多个树节点组成，每个节点都包含指向子节点的指针或引用。当每个节点都只有一个子节点时，树就变成了链表；当节点中出现环时，树变成了图。

### 基本概念

​		Root -- 根节点							Parent Node -- 父节点						Child Node  -- 子节点

​		Sub Tree - 子树						  Level -- 层											 Depth -- 深度

​		Left Node -- 左节点				   Right Node -- 右节点						   Siblings -- 兄弟节点

![image-20200922171628880](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200922171628880.png)

### 结构定义

```
class TreeNode {
	int data;
	TreeNode left;
	TreeNode Right;
}
```

​		树可以使用基于上述节点的链表结构来存储，也可以使用数组来存储。

### 二叉树

​		顾名思义，二叉树就是每个节点最多有两个分叉即最多两个子节点。

![image-20200923114452220](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923114452220.png)

### 满二叉树

​		如上图所示，1&2&3都是二叉树，但是其实能看出来2和3是有点特殊的，2就是满二叉树，即叶子节点只出现在最底层里。

### 完全二叉树

​		3就是完全二叉树，特点是叶子节点只出现在最底两层，且最底层的叶子节点靠左排列，其他层的节点个数达到最大。可以理解为满二叉树是特殊的完全二叉树。

### 二叉搜索树

​		二叉搜索树要求，在树中的任意节点，其左子树中的每个节点的值都要小于此节点的值，右子树节点的值都大于此节点。注意：是左右子树的所有节点，不只是左右子节点，也不只是叶子节点。因此，左右子树也分别是二叉搜索树。

​		![image-20200923151528695](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923151528695.png)

​		二叉搜索树的增删改查的时间复杂度都是O(log n)，空间复杂度是O(n log n)

### 二叉树遍历

​		前序遍历：左根右；	中序遍历：左根右；	后序遍历：左右根

![image-20200923152747420](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923152747420.png)

## 堆

​		堆是一类数据结构的统称，该数据结构有如下特性：

- ​		堆总是一棵完全二叉树

- ​		堆中某个节点的值总是不大于或者不小于父节点的值（大顶堆或大根堆、小顶堆或小根堆），根节点就是所有数中的最大值或最小值。

  堆有很多种实现，最常见的是二叉堆、斐波那契堆等。

### 时间复杂度

find-max: O(1)

delete-max: O(log n)

insert: O(log n) 或 O(1)

### 二叉堆

二叉堆是比较常见的堆的实现。

![image-20200923162314914](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923162314914.png)

#### 实现细节

​		二叉堆一般是通过数组实现的，如上图：

​				根节点在数组中的索引是0

​				索引为i的左子节点的索引是2*i+1

​				索引为i的右子节点的索引是2*i+2

​				索引为i的父节点的索引是floor((i-1)/2)

#### 插入操作

1. 新元素插入堆尾部
2. 新元素不断与父节点比较，父节点小则与父节点进行交换，依次向上调整这个堆的结构，直至根节点或者值小于父节点，这是一个不断将大值上浮的过程。

![image-20200923163615437](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923163615437.png)

#### 删除堆顶操作

1. 将堆尾元素移至堆顶
2. 将新堆顶元素与子节点进行比较，如果子节点大于父节点，将较大的子节点与父节点交换，重复这个过程直至满足父子节点间大小关系为止，这是一个将小值不断下沉的过程。

![image-20200923164243347](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923164243347.png)

## 图

图是一种复杂的二维非线性数据结构，数学表达式为Graph(v, e)

![image-20200923171529594](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923171529594.png)

### 基本概念

1. 点：图中的元素就是点，或者叫顶点。
2. 边：图中的顶点可以和任何其他顶点建立连接关系，这种关系就是边。边分为有向和无向。
3. 度：与顶点相连接的边的条数，就是这个顶点的度。在有向图中，按照边的方向分为了入度和出度。指向顶点的边的条数叫入度，从顶点出发指向其他顶点的边的条数叫出度。
4. 权重：边的属性，可以理解为边的长度，或者边的损耗。

### 分类

​		图一般按是否有方向和权重分类：1. 无向无权图 2. 有向无权图 3. 无向有权图 4. 有向有权图

![image-20200923173044310](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923173044310.png)

### 存储方式

1. 邻接矩阵

   邻接矩阵底层依赖一个二维数组，横向与纵向索引都表示点的索引，矩阵中的每个元素表示边的情况。无向图和无向无权图中就用0/1来表示是否存在边或有向边；无向有权图，就是每条边的权重。

   ![image-20200923172111459](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923172111459.png)

   优点：存储简单、直接，因为基于数组，存取操作比较高效。

   ​			方便计算，很多图的运算可以转换为矩阵的运算。

   缺点：浪费空间，对于无向图，至少一半的空间是白白浪费了，对于稀疏图（点多边少）更是大量浪费空间。

2. 邻接表

   邻接表与散列表很像，每个顶点对应一条链表，链表中存储的是与这个顶点相互连接的其他顶点，如果是带权图，则在节点中增加一个属性表示权重即可。

   ![image-20200923174358701](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200923174358701.png)

   优点：节省空间

   缺点：时间复杂度变高，因为要遍历链表。所以可以做类似于散列表一样的优化，把链表部分替换为其他时间复杂度更有的数据结构，比如红黑树。

## Java HashMap API

### 源码解读