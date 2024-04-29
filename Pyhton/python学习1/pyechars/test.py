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
