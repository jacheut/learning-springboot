
## 简介
通过Socket.IO协议实现WebSocket实时通信

## WeSocket长连接
Socket.IO服务器端和客户端，使用Java语言实现，用于和浏览器或Android客户端进行长连接的WebSocket通信。
服务器端可以实时将消息推送给客户端，以此来取代客户端轮询机制。

Sockt.io官网：<https://socket.io/>
文档：<https://socket.io/docs/>

服务器端使用 [netty-socketio](https://github.com/mrniko/netty-socketio) 1.7.14
客户端使用 [socket.io-client-java](https://github.com/socketio/socket.io-client-java) 1.0.0
客户端和服务端的版本需要对应，否则socket.io-client会有版本冲突

### WebSocket js客户端测试

```
/client/html/index.html
```

### WebSocket Java客户端测试

```
com.xncoding.pos.socket.client.SocketClient
```


