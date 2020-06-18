## 一、用JS实现页面跳转的方式

### 第1种

```html

<script language="javascript" type="text/javascript">
　　window.location.href="login.jsp?backurl="+window.location.href;
　　</script>
```

### 第2种：

```html
<script language="javascript">
　　alert("返回");
　　window.history.back(-1); 
　　</script>
```

### 第3种：

```html
这个方法是只针对IE的
<script language="javascript">
　　window.navigate("top.jsp"); 
　　</script>
```

### 第4种：

```html

<script language="JavaScript"> 
　　self.location=’top.htm’; 
　　</script>
```

### 第5种：

```html
<script language="javascript"> 
　　alert("非法访问！"); 
　　top.location=’xx.jsp’; 
　　</script>
```



## 二、关于spring boot2.0之后静态资源的访问

```
//注册拦截器
在springboot2.0版本以前拦截器会默认对静态资源不拦截，但是springboot 2.0 以后拦截器会拦截所有，
所以需要重写addInterceptors方法，不管是自己的静态资源还是webjars中的资源，都要放行。
```



## 三、servlet传统三大域

```
Model model ,此对象里面只能存储一个对象，不过包括了集合对象

* 方法里面的参数，只在一个page里面有用
* Request是一次请求
* Session是一个会话
* Application是多次会话(Tomcat开启到关闭)
```

## 四、发送delete、put请求问题

```
 post模拟delete、put请求需要HiddenHttpMethodFilter
 HiddenHttpMethodFilter 在spring boot 2.0 之后默认关闭了，需要在application配置文件里手动开启
         yml:  mvc:
                hiddenmethod:
                 filter:
                    enabled: true
```

发送方式（delete为例）

```
<a class="bt_delete" th:attr="delete_uri=@{/emp/}+${emp.getId()}">删除</a>

<form id="deleteEmp" method="post">
    <input type="hidden" name="_method" value="delete">
</form>

<script>
    $(".bt_delete").click(function () {
        alert("helo");
      $("#deleteEmp").attr("action",$(this).attr("delete_uri")).submit();
    });
</script>
```



## 五、bootstrap引入问题

```
 <link href="" th:href="@{/webjars/bootstrap/4.4.1-1/css/bootstrap.css}" rel="stylesheet">
<!--引入之后会修改默认的table属性-->
```

## 六、thymeleaf细节

```
1 在 th:if 方法所处的标签，true则生效
2 dates.format(employee.getBirthday(),'yyyy/MM/dd') 你是爹 yyyy/MM/dd 大小写错了你都是儿子！！！！
3 后台数据库存储也要注意 会默认减一天 22 会变 23
```

## 七、html 细节

```
<!-- 如果仅仅是为了文本在元素内居中对齐，可以使用 text-align: center; -->
<!--"for" 属性可把 label 绑定到另外一个元素。请把 "for" 属性的值设置为相关元素的 id 属性的值。-->
```

## 八、css 细节，布局问题

```
/*当两个容器嵌套时,如果外层容器和内层容器之间**没有别的元素**,*/
/*ff或chrome会把内层元素的margin-top作用于父元素。
margin-bottom是下方的外边距，并不能让元素向下方移动，
margin-top作为上边距，把元素“推”了下去。*/

   /*注意，设为Flex布局以后，子元素的float、clear和vertical-align属性将失效。
    Flex 布局非常有用，需要研究！！！*/
    
    /*在line-height==height即可文本垂直居中 */
    
    /* height不能继承body
    display:block 是每个标签成为独立的一个块，换行输出 ,相当于<br>
    子元素继承父元素的属性，如有相同，则覆盖*/
```



## 九、自动建表

在yml配置文件中设置，SQL文件放在类路劲下

```
#    自动建表
#    schema:
#      - classpath:Emp.sql
```

