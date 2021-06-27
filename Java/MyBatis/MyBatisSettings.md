```xml
	
		<!-- settings是 MyBatis 中全局的调整设置，它们会改变 MyBatis 的运行时行为,应谨慎设置 -->  
	    <settings>  
	        <!-- 该配置影响的所有映射器中配置的缓存的全局开关。默认值true -->  
	      <setting name="cacheEnabled" value="true"/>  
	      <!--延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置fetchType属性来覆盖该项的开关状态。默认值false  -->  
	      <setting name="lazyLoadingEnabled" value="true"/>  
	        <!-- 是否允许单一语句返回多结果集（需要兼容驱动）。 默认值true -->  
	      <setting name="multipleResultSetsEnabled" value="true"/>  
	      <!-- 使用列标签代替列名。不同的驱动在这方面会有不同的表现， 具体可参考相关驱动文档或通过测试这两种不同的模式来观察所用驱动的结果。默认值true -->  
	      <setting name="useColumnLabel" value="true"/>  
	      <!-- 允许 JDBC 支持自动生成主键，需要驱动兼容。 如果设置为 true 则这个设置强制使用自动生成主键，尽管一些驱动不能兼容但仍可正常工作（比如 Derby）。 默认值false  -->  
	      <setting name="useGeneratedKeys" value="false"/>  
	     <!--  指定 MyBatis 应如何自动映射列到字段或属性。 NONE 表示取消自动映射；PARTIAL 只会自动映射没有定义嵌套结果集映射的结果集。 FULL 会自动映射任意复杂的结果集（无论是否嵌套）。 -->   
	     <!-- 默认值PARTIAL -->  
	      <setting name="autoMappingBehavior" value="PARTIAL"/>  
	        
	      <setting name="autoMappingUnknownColumnBehavior" value="WARNING"/>  
	     <!--  配置默认的执行器。SIMPLE 就是普通的执行器；REUSE 执行器会重用预处理语句（prepared statements）； BATCH 执行器将重用语句并执行批量更新。默认SIMPLE  -->  
	      <setting name="defaultExecutorType" value="SIMPLE"/>  
	      <!-- 设置超时时间，它决定驱动等待数据库响应的秒数。 -->  
	      <setting name="defaultStatementTimeout" value="25"/>  
	        
	      <setting name="defaultFetchSize" value="100"/>  
	      <!-- 允许在嵌套语句中使用分页（RowBounds）默认值False -->  
	      <setting name="safeRowBoundsEnabled" value="false"/>  
	      <!-- 是否开启自动驼峰命名规则（camel case）映射，即从经典数据库列名 A_COLUMN 到经典 Java 属性名 aColumn 的类似映射。  默认false -->  
	      <setting name="mapUnderscoreToCamelCase" value="false"/>  
	      <!-- MyBatis 利用本地缓存机制（Local Cache）防止循环引用（circular references）和加速重复嵌套查询。  
	             默认值为 SESSION，这种情况下会缓存一个会话中执行的所有查询。  
	            若设置值为 STATEMENT，本地会话仅用在语句执行上，对相同 SqlSession 的不同调用将不会共享数据。  -->  
	      <setting name="localCacheScope" value="SESSION"/>  
	      <!-- 当没有为参数提供特定的 JDBC 类型时，为空值指定 JDBC 类型。 某些驱动需要指定列的 JDBC 类型，多数情况直接用一般类型即可，比如 NULL、VARCHAR 或 OTHER。  -->  
	      <setting name="jdbcTypeForNull" value="OTHER"/>  
	    <!--   指定哪个对象的方法触发一次延迟加载。  -->  
	      <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString"/>  
	    </settings>  

```

