# 第二章内容总结

给自己定个规矩，总结做到这四个字：言简意赅

## 哈希表

哈希表HashTable，又名散列表，可根据关键码值直接进行访问的数据结构。

### 哈希表原理

内部使用数组存储，对码值进行散列函数计算得到在数组中存储的位置。借助散列函数对数组进行扩展，利用数组支持按下标随机访问元素的优势特性。对于哈希碰撞（不同的码值算出相同的数组下标），常用的解决方法有开放寻址法和链表法。

![image-20200922165706964](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200922165706964.png)

### 时空复杂度

​		如下图，哈希表的增删改查操作，状态好时为O(1)，状态不好时退化为O(n)。

![image-20200921222845614](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20200921222845614.png)

​		简单说明：在没有hash冲突时，存取操作直接根据key值进行散列计算后得到数组的位置，直接进行存取操作，这个时间复杂度是O(1)。当出现hash冲突后，目前对hash冲突的解决办法一般是开放寻址法（线性探测、二次探测、双重散列）或链表法，不论哪种方法，对于冲突的hash值进行查找时都是需要以O(n)的复杂度进行查找。

### 参考

​		以上只是对哈希表简单的总结，详细可查看该资料文档：

​		https://xintiaohuiyi.gitbook.io/jynotebook/shu-ji/shu-ju-jie-gou-yu-suan-fa-zhi-mei/18-san-lie-biao-ff08-shang-ff09-ff1a-word-wen-dang-zhong-de-dan-ci-pin-xie-jian-cha-gong-neng-shi-ru

## 树



## 堆



## 图



## Java HashMap API

