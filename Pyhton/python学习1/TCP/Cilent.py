# 引入模块
import socket
# 1. 获得套接字对象
socket_client = socket.socket()
# 2. 获取连接
socket_client.connect(("localhost", 8888))
while True:
    # 3. 发送消息
    message: str = input("请输入信息")
    if message == "exit":
        break
    socket_client.send(message.encode("UTF-8"))
    # 4. 接收信息
    receive: str = socket_client.recv(1024).decode("UTF-8")
    print(f"服务端发来了信息:{receive}")
# 5. 关闭连接
socket_client.close()


