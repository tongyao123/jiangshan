
* 0.33版本
* 新增四信传感器数据库
* 增加对应的传感器数据获取接口，接口地址为ip+/SensorMessage+接口名
搜索
* 获取指定类型的传感器列表
* getSensorIDList(String sensorType)接口
  * 传入参数 sensorType ，值限制为
    * weather 气象传感器
    * soil 土壤检测器

* 获取指定传感器最新数据
* getSensorLatestData （String sensorType, String sensorId) 接口
  * 传入参数 sensorType ，值限制为
    * weather 气象传感器
    * soil 土壤检测器
  * 传入参数 sensorId ，值限制为传感器id，建议通过getSensorIDList接口获得列表后选择传入

* 获取不同类型的传感器的可查询曲线类型
* getCurveType(String sensorType) 接口
  * 传入参数 sensorType ，值限制为
      * weather 气象传感器
      * soil 土壤检测器

* 获取不同类型的某个设备号的指定曲线*/
* getSensorCurve(String sensorType,String sensorId,String curveType) 接口
  * 传入参数 sensorType ，值限制为
      * weather 气象传感器
      * soil 土壤检测器
  * 传入参数 sensorId ，值限值为传感器id，建议通过getSensorIDList接口获得列表后选择传入
  * 传入参数 curveType ，值限值为传感器的可查询曲线类型，建议通过getCurveType接口获得列表后选择传入

* 0.40版本
* 增加海康摄像头相关的后台访问接口

* 1.0.0版本
* 增加完善所有摄像头控制接口，具体参照海康摄像头的官方文档

* 1.0.1版本
* 所有资产筛选相关功能增加城镇，乡村筛选功能，接口地址为ip+/screenMessage+接口名
* 城镇获取接口getTownList(String distinct) 接口
  * 传入参数 distinct ，值限值为标准地区编码中的区、县级编码
* 乡村获取接口getVillageList(String town) 接口
  * 传入参数 town ，值限值城镇编码,建议通过getTownList接口获得列表后选择传入