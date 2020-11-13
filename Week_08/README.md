学习笔记

## 插入排序

![image-20201113200431924](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20201113200431924.png)

```java
// 插入排序，a表示数组，n表示数组大小
public void insertionSort(int[] a, int n) {
  if (n <= 1) return;

  for (int i = 1; i < n; ++i) {
    int value = a[i];
    int j = i - 1;
    // 查找插入的位置
    for (; j >= 0; --j) {
      if (a[j] > value) {
        a[j+1] = a[j];  // 数据移动
      } else {
        break;
      }
    }
    a[j+1] = value; // 插入数据
  }
}
```



## 冒泡排序

![image-20201113200641576](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20201113200641576.png)

```java
// 冒泡排序，a表示数组，n表示数组大小
public void bubbleSort(int[] a, int n) {
  if (n <= 1) return;
 
 for (int i = 0; i < n; ++i) {
    // 提前退出冒泡循环的标志位
    boolean flag = false;
    for (int j = 0; j < n - i - 1; ++j) {
      if (a[j] > a[j+1]) { // 交换
        int tmp = a[j];
        a[j] = a[j+1];
        a[j+1] = tmp;
        flag = true;  // 表示有数据交换      
      }
    }
    if (!flag) break;  // 没有数据交换，提前退出
  }
}
```



## 选择排序

![image-20201113200750207](C:\Users\wangbing\AppData\Roaming\Typora\typora-user-images\image-20201113200750207.png)

```java
// 选择排序，a表示数组，n表示数组大小
public void bubbleSort(int[] a, int n) {
  if (n <= 1) return;
 
 for (int i = 0; i < n; ++i) {
 	for (int j = i + 1; j < n; ++j) {
 		if (a[j] < a[i]) { //交换
 			int tmp = a[j];
 			a[j] = a[i];
 			a[i] = tmp;
 		}
 	}
 }
}
```

