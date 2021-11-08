## 目的
通过模拟gradle加载脚本的流程，阐述利用Groovy创建DSL的原理

## 描述
实现bradle程序，能够加载和解析自定义的build.bradle脚本

## 使用
编辑build.bradle，使用tasks.register注册task，并通过以下命令调用对应task
```
bradle taskName
```
## 教程
[Groovy和DSL一: 模拟Gradle](http://liwuzhi.art/?p=700)
