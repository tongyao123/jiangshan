
* 0.3版本
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
  * 传入参数 sensorId ，值限制为传感器id，建议通过getSensorIDList接口获得列表后选择传入
  * 传入参数 curveType ，值限制传感器的可查询曲线类型，建议通过getCurveType接口获得列表后选择传入