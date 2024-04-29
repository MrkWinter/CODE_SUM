## 第六章

### Python基础综合案例

#### 数据可视化 - 折线图视化

* json 数据格式

  1. 什么是json 

     json是不同语言直接的中转站

     ![image-20230919220225595](img\image-20230919220225595.png)

  2. python与json数据的互相转换

     ![image-20230919220702276](img\image-20230919220702276.png)

     ![image-20230919221235758](img\image-20230919221235758.png)

     ```python
     import json
     
     data = [{"wang":1},{"li":3},{"qign":3}]
     # json.dumps(字典或列表(套字典),ensure_ascii = False) 用来将字典或列表转换成字符串(json)
     str_json = json.dumps(data,ensure_ascii = False) 
     
     date = '[{"wang":1},{"li":3},{"qign":3}]'
     # json.loads(json字符串,ensure_ascii = False) 用来将json(字符串)转换成字典或列表
     l = json.loads(data,ensure_ascii = False)
     
     注意: ensure_ascii = False 参数是转换时不使用assii码转换中文 而是直接输出出去 如果为true 则中文转换成unicode字符 使用该参数保证中文的正常显示
     
     ```

     

* pyecharts模块介绍

  1. 基本介绍

     ![image-20230919222802327](img\image-20230919222802327.png)

  2. 安装

     ```python
     pip install pyecharts
     ```

* pyecharts快速入门

  1. 基础折线图

     ```python
     from pyecharts.charts import Line
     from pyecharts.options import TitleOpts, LegendOpts, ToolboxOpts, VisualMapOpts
     
     # 导入包
     if __name__ == "__main__":
         # 得到折线图对象
         line = Line()
         # 添加x轴数据
         line.add_xaxis(["中国", "美国", "日本"])
         # 添加y轴数据
         line.add_yaxis("GDP", [30, 20, 10])
         # 设置全局配置项 set_global_opts来设置
         line.set_global_opts(
             # 图表标题 及 位置
             title_opts=TitleOpts(title="GDP展示", pos_left="center", pos_bottom="1"),
             # 图例是否显示
             legend_opts=LegendOpts(is_show=True),
             # 工具箱是否显示
             toolbox_opts=ToolboxOpts(is_show=True),
             # 视觉映射是否显示
             visualmap_opts=VisualMapOpts(is_show=True)
         )
         # 生成图表
         line.render()
     ```

  2. 全局配置项

     ![image-20230919230136735](img\image-20230919230136735.png)

* 数据处理

  通过[] 取出json文件中的具体数据  (要先将json文件转换成列表字典)

* 创建折线图  

  根据数据 创建图表

#### 数据可视化 - 地图视化

* 基础地图使用

  1. 基础使用

     ```python
     from pyecharts.charts import Map
     from pyecharts.options import VisualMapOpts
     
     # 导入包
     if __name__ == "__main__":
         map = Map()
         # 准备地图对象
         data = [("北京市", 11),
                 ("上海市", 22),
                 ("广东省", 33),
                 ("湖南省", 44),
                 ("甘肃省", 66), ]
         # 准备数据
         map.add("中国地图", data, "china")
         # 导入地图数据
         map.set_global_opts(
             # 设置地图的视觉指示器
             visualmap_opts=VisualMapOpts(
                 is_show=True,  # 设置颜色可见
                 is_piecewise=True,  # 设置自定义颜色范围
                 pieces=[
                     {"min": 10, "max": 99, "label": "1-9", "color": "#CCFFFF"}
                 ]
             )
         )
         # 设置全局选项
     
         map.render()
         # 生成地图
     
     ```

     

* 国内疫情地图

  根据数据画

* 省级疫情地图

  根据数据画

#### 数据可视化 - 柱状图视化

* 基础柱状图

  ```python
  from pyecharts.charts import Bar
  from pyecharts.options import LabelOpts
  
  # 导入包
  bar = Bar()
  # 生成对象
  bar.add_xaxis(["中国", "美国", "英国"])
  # 添加x轴数据  label_opts=LabelOpts(position="right") 是将数据标签放到右侧
  bar.add_yaxis("GDP", [30, 20, 10], label_opts=LabelOpts(position="right"))
  # 添加y轴数据
  
  # 反转xy轴
  bar.reversal_axis()
  # 绘制图
  bar.render()
  ```

* 基础时间柱状图

  ```python
  from pyecharts.charts import Bar, Timeline
  from pyecharts.options import LabelOpts
  from pyecharts.globals import ThemeType
  
  # 导入包
  bar = Bar()
  # 生成对象
  bar.add_xaxis(["中国", "美国", "英国"])
  # 添加x轴数据  label_opts=LabelOpts(position="right") 是将数据标签放到右侧
  bar.add_yaxis("GDP", [30, 20, 10], label_opts=LabelOpts(position="right"))
  # 添加y轴数据
  
  bar2 = Bar()
  bar2.add_xaxis(["中国", "美国", "英国"])
  bar2.add_yaxis("GDP", [40, 30, 20], label_opts=LabelOpts(position="right"))
  bar2.reversal_axis()
  bar3 = Bar()
  bar3.add_xaxis(["中国", "美国", "英国"])
  bar3.add_yaxis("GDP", [50, 40, 30], label_opts=LabelOpts(position="right"))
  bar3.reversal_axis()
  # 添加时间线 并设置主题
  timeline = Timeline({"theme": ThemeType.LIGHT})
  # 添加数据
  timeline.add(bar, "2021年")
  timeline.add(bar2, "2022年")
  timeline.add(bar3, "2023年")
  # 设置自动播放
  timeline.add_schema(
      play_interval=1000,  # 自动播放间隔时间
      is_timeline_show=True,  # 是佛在自动播放时显示时间线
      is_auto_play=True,  # 是否自动播放
      is_loop_play=True  # 是否循环自动播放
  )
  # 绘制图
  timeline.render()
  ```

* GDP动态柱状图绘制

  ```python
  # 列表排序函数
  sort(key = 排序规则,reverse = 是否逆序)排序函数
  -- 如
  my_list = [["a",1]["b",[3]]["c",4]]
  my_list.sort(lambde element: element[1],reverser = True)
  ```
  
  

