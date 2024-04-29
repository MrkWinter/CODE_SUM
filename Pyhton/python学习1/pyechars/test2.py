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
