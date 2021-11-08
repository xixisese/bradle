## 目的
阐述Groovy语言创建DSL的原理

## 描述
实现bradle程序，模拟gradle方式，自定义DSL和解析脚本， 本项目与真实的gradle工作流程相去甚远，仅为阐述Groovy语言创建DSL的流程

## 使用
编辑build.bradle，其中repositories和dependencies没有实质意义，可使用task.register注册task，并调用对应task
```
bradle taskName
```
## 教程
[Groovy和DSL一: 模拟Gradle](http://liwuzhi.art/?p=700)
