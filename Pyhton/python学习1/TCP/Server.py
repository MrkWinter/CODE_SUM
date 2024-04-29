# 导入socket模块
import socket

# 1. 创建Socket对象
socket_server = socket.socket()
# 2. 绑定ip地址和端口
socket_server.bind(("localhost", 8888))
# 3. 监听端口
socket_server.listen(1)  # listen 方法接收一个整形参数 表示接收的连接数量
# 4. 得到连接对象 和客户端地址信息
conn, address = socket_server.accept()  # 该方法返回的是一个二元元组
print(f"接收到了客户端的连接 信息为{address}")
while True:
    # 5. 使用连接对象 接收客户端发送的信息
    receive: str = conn.recv(1024).decode('UTF-8')  # 得到的是字节数据 1024为缓存区 decode以utf-8解码成字符串
    print(f"客户端发来了信息:{receive}")
    # 6. 回复发送信息
    message = input("输入信息:")
    if message == "exit":
        break
    conn.send(message.encode("UTF-8"))  # 字符串编码成字节数组发送
# 7. 关闭连接
conn.close()
socket_server.close()
