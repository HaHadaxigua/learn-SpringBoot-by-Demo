# README
通过做SpringBoot的Demo来学习Spring Boot

开这个项目也是为了方便记录，就当作是一种监督与目标吧。

希望能有所收获，加油！

## 记录
- 2020.01.19

    在git push的时候出现了Everything up-to-date的问题。
    
    重写配置下git的global config就可以解决
    ```shell script
        git config --global user.name "your user name"
        git config --global user.email "your email"
        
        // 重新提交
        git add .
        git status 
        git commit -m "update message"
        git status 
        git push 
        // git push origin master 
    ```