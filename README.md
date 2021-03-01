# GmairData-analysis

1.此项目为springcloud项目，有三个主模块分别为log、eureka、还有analysis   eureka主要负责模块调用

2.log模拟为底层获取数据库mogodb的模块，相当于果麦项目里面的log

3.analysis直接调用log获得数据接口来获得数据并分析，showcontroller主要是对获得的数据做一个展示
 其中数据分析的函数在function包下面的UserAnalysis（单用户分析）和UsersAnalysis（多用户分析）
