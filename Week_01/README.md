给自己定个规矩，总结做到这四个字：言简意赅

## GitHub

### 本地仓库操作指令

git --version							查看git版本

git init										初始化git仓库

git config --global user.name "username"		配置用户名

git config --global user.email "a@b.com"			配置电子邮箱

git status								查看git仓库状态

git add 文件名或 **.**					将某个文件或所有文件添加到git仓库，让git去跟踪此文件

git commit -m "提交说明"			提交变动到git本地仓库

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